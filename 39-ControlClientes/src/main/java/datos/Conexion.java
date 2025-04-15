package datos;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/control_clientes?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "alexander";
    private static final String JDBC_PASSWORD = "admin";
    
    private static BasicDataSource basicDataSource;

    public static DataSource getDataSource() {
        if (basicDataSource == null) {
            synchronized (Conexion.class) {
                if (basicDataSource == null) {
                    basicDataSource = new BasicDataSource();
                    basicDataSource.setUrl(JDBC_URL);
                    basicDataSource.setUsername(JDBC_USER);
                    basicDataSource.setPassword(JDBC_PASSWORD);
                    basicDataSource.setInitialSize(10);
                    basicDataSource.setMaxTotal(50);
                    basicDataSource.setMinIdle(5);
                    basicDataSource.setMaxIdle(20);
                    basicDataSource.setMaxWaitMillis(10000);
                }
            }
        }
        return basicDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
