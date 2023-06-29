package SCC0541.F1Backend.database;

public class SQLScripts {

    public static final String LOG_INSERT = "INSERT INTO log_table VALUES (nextval('PUBLIC.SEQ_USER_LOGS_ID'), :id, :idOriginal)";

}
