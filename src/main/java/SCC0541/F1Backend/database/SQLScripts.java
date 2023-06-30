package SCC0541.F1Backend.database;

public class SQLScripts {

    // FINDALLS
    public static final String FIND_ALL_CONSTRUCTORS = "SELECT * FROM CONSTRUCTORS";
    public static final String FIND_ALL_DRIVERS = "SELECT * FROM DRIVER";;

    //====--===---=-=---===--========--===---=-=---===--====
    // INSERTS
    public static final String LOG_INSERT = "INSERT INTO log_table VALUES (nextval('PUBLIC.SEQ_USER_LOGS_ID'), :id, :idOriginal)";
    public static final String CONSTRUCTOR_INSERT =
            "INSERT INTO CONSTRUCTORS VALUES " +
                    "(nextval('PUBLIC.SEQ_CONSTRUCTOR_ID')," +
                    ":constructorRef," +
                    ":name," +
                    ":nationality," +
                    ":url)";

    public static final String DRIVER_INSERT =
            "INSERT INTO DRIVER VALUES " +
                    "(nextval('PUBLIC.SEQ_DRIVER_ID')," +
                    ":driverRef," +
                    ":number," +
                    ":code," +
                    ":forename," +
                    ":surname," +
                    ":dob," +
                    ":nationality)";


    //====--===---=-=---===--========--===---=-=---===--====
    // GET BY ID
    public static final String FIND_DRIVER_BY_ID = "SELECT * " +
            "FROM DRIVER " +
            "WHERE driverId=:id";

    public static final String FIND_CONSTRUCTOR_BY_ID = "SELECT * " +
            "FROM CONSTRUCTORS " +
            "WHERE constructorId=:id";

}
