import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input username: ");
        String username = input.nextLine();
        System.out.println("Please input password: ");
        String pwd = input.nextLine();

        // Connecting database
        Properties info = new Properties();
        info.load(new FileInputStream("src\\jdbc"));
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String driver = info.getProperty("driver");
        String url = info.getProperty("url");
        // register driver
        Class.forName(driver);
        // get connection
        Connection connection = DriverManager.getConnection(url, user, password);
        // execute SQL
        String sql = "select * from admin where name='" +
                username +
                "' and password='" +
                pwd +
                "'";
        // System.out.println(sql);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
       /* System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));*/
        if(resultSet.next()) {
            System.out.println("Login");
        }
        else
        {
            System.out.println("Fail");
        }
        // close
        resultSet.close();
        statement.close();
        connection.close();
    }
}
