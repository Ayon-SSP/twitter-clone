package tech.codingclub.helix.database;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import tech.codingclub.helix.tables.Follower;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishabh
 */
public class GenericDB<T> {

    public static DatabaseConnectionPool databaseConnectionPool;

    static {
        databaseConnectionPool = DatabaseUtil.getDataseBaseConnectionPool();
    }

    public static List<?> getRows(TableLike<?> table, Class<?> converterClass, Condition condition, Integer limit, SortField<?> orderBy) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            SelectJoinStep<Record> a = create.select().from(table);
            SelectConditionStep<Record> x = null;
            SelectOffsetStep<Record> y;

            if (condition != null) {
                x = a.where(condition);
            }

            if (limit == null) {
                if (x == null) {
                    if (orderBy != null) {
                        return a.orderBy(orderBy).fetch().into(converterClass);
                    }
                    return a.fetch().into(converterClass);
                } else {
                    if (orderBy != null) {
                        return x.orderBy(orderBy).fetch().into(converterClass);
                    }
                    return x.fetch().into(converterClass);
                }
            } else {
                if (x == null) {
                    if (orderBy != null) {
                        y = a.orderBy(orderBy).limit(limit);
                    } else {
                        y = a.limit(limit);
                    }
                } else {
                    if (orderBy != null) {
                        y = x.orderBy(orderBy).limit(limit);
                    } else {
                        y = x.limit(limit);
                    }
                }
                return y.fetch().into(converterClass);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return null;
    }

    public static void incrementCount(TableImpl<?> table, Field<Long> x, Condition condition) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);

            if (condition != null) {
                create.update(table).set(x, x.add(1)).where(condition).execute();
            } else {
                create.update(table).set(x, x.add(1)).execute();
            }
        } catch (Exception w) {
            w.printStackTrace();
        }
    }


    public static int getCount(TableLike<?> table, Condition condition) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            SelectJoinStep<Record1<Integer>> x = create.selectCount()
                    .from(table);
            if (condition != null)
                return x.where(condition).fetchOne(0, int.class);
            return x.fetchOne(0, int.class);
        } catch (Exception w) {
            w.printStackTrace();
        }
        return 0;
    }

    public static List<?> getRows(TableLike<?> table, Class<?> converterClass, Condition condition, Integer limit) {
        return getRows(table, converterClass, condition, limit, null);
    }

    public static void main(String[] args) {
    }

    public static boolean deleteRow(TableLike<?> table, Condition condition)
    {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            create.delete(table.asTable()).where(condition).execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return false;
    }

    public T getMinFromTable(Field<?> x, TableLike<?> table, Condition condition) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            if (condition == null)
                return (T) create.select(x.min()).from(table).fetchOne().get(0);

            return (T) create.select(x.min()).from(table).where(condition).fetchOne().get(0);
        } catch (Exception e) {
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return null;
    }

    public T getMaxFromTable(Field<?> x, TableLike<?> table, Condition condition) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            if (condition == null)
                return (T) create.select(x.max()).from(table).fetchOne().get(0);

            return (T) create.select(x.max()).from(table).where(condition).fetchOne().get(0);
        } catch (Exception e) {
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return null;
    }

    public boolean updateColumn(Field<T> x, T t, TableImpl<?> table, Condition condition) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();

            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);

            if (condition == null) {
                create.update(table).set(x, t).execute();
            } else {
                create.update(table).
                        set(x, t).
                        where(condition).execute();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return false;
    }

    public List<T> getColumnRows(Field<?> x, TableLike<?> table, Class<T> converterClass, Condition condition, Integer limit) {
        return getColumnRows(x, table, converterClass, condition, limit, null);
    }

    public List<T> getColumnRows(Field<?> x, TableLike<?> table, Class<T> converterClass, Condition condition, Integer limit, SortField<?> orderBy) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            if (condition == null) {
                if (limit == null) {
                    if (orderBy != null) {
                        return create.select(x).from(table).orderBy(orderBy).fetch().into(converterClass);
                    } else {
                        return create.select(x).from(table).fetch().into(converterClass);
                    }
                }
                if (orderBy != null) {
                    return create.select(x).from(table).orderBy(orderBy).limit(limit).fetch().into(converterClass);
                } else {
                    return create.select(x).from(table).limit(limit).fetch().into(converterClass);
                }
            }

            if (limit == null) {
                if (orderBy != null) {
                    return create.select(x).from(table).where(condition).orderBy(orderBy).fetch().into(converterClass);
                } else {
                    return create.select(x).from(table).where(condition).fetch().into(converterClass);
                }
            }

            if (orderBy != null) {
                return create.select(x).from(table).where(condition).orderBy(orderBy).limit(limit).fetch().into(converterClass);
            } else {
                return create.select(x).from(table).where(condition).limit(limit).fetch().into(converterClass);
            }

        } catch (Exception e) {
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return null;
    }

    public T getRow(TableLike<?> table, Class<?> converterClass, Condition condition) {
        List<?> x = getRows(table, converterClass, condition, 1);
        return (T) (x != null && x.size() > 0 ? x.get(0) : null);
    }

    public T addRow(TableImpl<?> table, T t) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            return (T) create.insertInto(table).set(create.newRecord(table, t)).returning().fetchOne().into(t.getClass());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return null;
    }

    public ArrayList<T> addRows(TableImpl<?> table, ArrayList<T> ts) {
        ArrayList<T> tr = new ArrayList<T>();
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            for (T t : ts) {
                try {
                    tr.add((T) create.insertInto(table).set(create.newRecord(table, t)).returning().fetchOne().into(t.getClass()));
                } catch (Exception er) {
                    tr.add(t);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return tr;
    }

    public T updateRow(TableImpl<?> table, T t, Condition condition) {
        Connection conn = null;
        try {
            conn = databaseConnectionPool.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            if (condition != null) {
                return (T) create.update(table).set(create.newRecord(table, t)).where(condition).returning().fetchOne().into(t.getClass());
            }
            return (T) create.update(table).set(create.newRecord(table, t)).returning().fetchOne().into(t.getClass());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            databaseConnectionPool.leaveConnection(conn);
        }
        return null;
    }
}
