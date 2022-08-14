package util.SQLCOMMAND;

public class OrderSQLCommand {
    public static final String INSERT_ORDER = "INSERT INTO [ORDER] (NAME, PHONE_NUMBER, DETAIL_ADDRESS, " +
            "TOTAL, ORDER_DATE, STATUS, CUSTOMER_ID, ADDRESS_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_ORDER= "UPDATE [ORDER] SET NAME = ?, PHONE_NUMBER = ?, DETAIL_ADDRESS = ?," +
            " TOTAL = ?, ORDER_DATE = ?, STATUS = ?, CUSTOMER_ID = ?, ADDRESS_ID = ? WHERE ORDER_ID = ?";
    public static final String DELETE_ORDER = "DELETE FROM [ORDER] WHERE ORDER_ID = ?";
}
