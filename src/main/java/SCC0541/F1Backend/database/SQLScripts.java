package SCC0541.F1Backend.database;

public class SQLScripts {

    public static final String LOG_INSERT = "INSERT INTO log_table VALUES (nextval('PUBLIC.SEQ_USER_LOGS_ID'), :id, :idOriginal)";
    public static final String CONSTRUCTOR_INSERT =
    "INSERT INTO CONSTRUCTORS VALUES (nextval('PUBLIC.SEQ_CONSTRUCTOR_ID'),:constructorRef,:name,:nationality, :url)";
    public static final String FIND_ALL_CONSTRUCTORS = "SELECT * FROM CONSTRUCTORS";
    public static final String FIND_CONSTRUCTOR_BY_ID = "SELECT * FROM CONSTRUCTORS WHERE constructorId=:constructorId";

}
