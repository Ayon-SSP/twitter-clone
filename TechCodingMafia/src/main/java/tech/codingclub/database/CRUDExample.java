package tech.codingclub.database;

import org.apache.commons.lang3.ObjectUtils;
import tech.codingclub.entity.Coders;

import java.util.Date;
import java.util.List;

public class CRUDExample {
    public static void main(String[] args) {
        System.out.println(" Reading rooms at "+new Date().getTime());

        // for only one row
        Coders coder= new GenericDB<Coders>().getRow(tech.codingclub.tables.Coders.CODERS,Coders.class,null);

        read_table();

        // UPDATING THE COLUMN
        new GenericDB<String>().updateColumn(tech.codingclub.tables.Coders.CODERS.NAME,"Coding Mafia",tech.codingclub.tables.Coders.CODERS,tech.codingclub.tables.Coders.CODERS.NAME.eq("Mohit"));

        read_table();
    }

    private static void read_table() {
        // for all rows
        List<Coders> x= (List<Coders>) GenericDB.getRows(tech.codingclub.tables.Coders.CODERS,Coders.class,null,null);

        // printing the rows
        for(Coders row:x)
        {
            System.out.println("Row : "+ row.getName()+" "+row.getAge());
        }
    }
}
