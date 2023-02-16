package tech.codingclub.helix.database;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionPool {
    private static long DB_EVICTION_TIMEOUT_MILLISEC = 10000000;
    private DataSource ds = null;
    private GenericObjectPool connectionPool;

    /**
     * Creates the pool.
     *
     * @param dbUrl    url location for database
     * @param userName username required to connect to database
     * @param password password required to connect to database
     */

    public DatabaseConnectionPool(String dbUrl, String userName, String password, int minIdle, int maxActive) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver"); //also you need the MySQL driver

        } catch (Exception e) {
        }

        System.out.println("Trying to connect to database...");
        Connection connection = null;
        try {
            this.ds = setupDataSource(dbUrl, userName, password, minIdle, maxActive);

            connection = getConnection();

            System.out.println("Connection attempt to database succeeded.");

        } catch (Exception e) {
            System.out.println("Error when attempting to connect to DB using ('" + dbUrl + "','" + userName + "')" + e);
        } finally {
            if (connection != null && !connection.isClosed())
                connection.close();
        }

    }

    /**
     * destructor
     */
    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable ex) {
        }
    }

    /**
     * @param connectURI - JDBC Connection URI
     * @param username   - JDBC Connection username
     * @param password   - JDBC Connection password
     * @param minIdle    - Minimum number of idel connection in the connection pool
     * @param maxActive  - Connection Pool Maximum Capacity (Size)
     * @throws Exception
     */
    private DataSource setupDataSource(String connectURI,
                                       String username,
                                       String password,
                                       int minIdle, int maxActive
    ) throws Exception {
        //
        // First, we'll need a ObjectPool that serves as the
        // actual pool of connections.
        //
        // We'll use a GenericObjectPool instance, although
        // any ObjectPool implementation will suffice.
        //
        connectionPool = new GenericObjectPool(null);

        connectionPool.setMinIdle(minIdle);
        connectionPool.setMaxActive(maxActive);
        connectionPool.setTestOnBorrow(true);
        connectionPool.setMinEvictableIdleTimeMillis(DB_EVICTION_TIMEOUT_MILLISEC);

        // we keep it for two reasons
        // #1 We need it for statistics/debugging
        // #2 PoolingDataSource does not have getPool()
        // method, for some obscure, weird reason.

        //
        // Next, we'll create a ConnectionFactory that the
        // pool will use to create Connections.
        // We'll use the DriverManagerConnectionFactory,
        // using the connect string from configuration
        //

        ConnectionFactory connectionFactory =
                new DriverManagerConnectionFactory(connectURI, username, password);

        //
        // Now we'll create the PoolableConnectionFactory, which wraps
        // the "real" Connections created by the ConnectionFactory with
        // the classes that implement the pooling functionality.
        //
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, connectionPool, null, null, false, true);

        PoolingDataSource dataSource = new PoolingDataSource(connectionPool);

        return dataSource;

    }

    public Connection getConnection() throws SQLException {
        Connection connection = ds.getConnection();

        if (connection == null || (connection != null && connection.isClosed())) {
            connection = ds.getConnection();
        }

        return connection;
    }

    public void leaveConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}