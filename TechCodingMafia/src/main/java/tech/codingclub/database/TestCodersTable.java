package tech.codingclub.database;

import tech.codingclub.entity.Coders;

public class TestCodersTable {

    public static void main(String[] args) {

        Coders coder = new Coders("HARI", 31L );
        //Insert this object into DB !

        //< ENTITY CLASS>
        new GenericDB<Coders>().addRow(tech.codingclub.tables.Coders.CODERS,coder);
        //System.out.println(coder.getname());

        // CRUD OPERATIONS

        // CREATE READ UPDATE DELETE
    }
}
