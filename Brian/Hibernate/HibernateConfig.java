package Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateConfig {

	private SessionFactory sessionFactory;

    public HibernateConfig() {
        Configuration config = new Configuration();

        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/customer");
        config.setProperty("hibernate.connection.username", "bperry");
        config.setProperty("hibernate.connection.password", "Xcalarp2c@15");


        /* NASTY PATHS*/
        //SQLGrammarException: Could not open connection, Not a valid database exception
        //config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/taco");

        //change the next two lines of code to match your MySQL user name and password.

        //change the pool size to reflect how many users you expect your application to have initially

        /* NASTY PATHS */
        //change the pool size to reflect how many users you expect your application to have initially
        // Access denied
        //config.setProperty("hibernate.connection.username", "notAUser");
        //config.setProperty("hibernate.connection.password", "nouser");
        // NULL POINTER EXCEPTION
        // config.setProperty("hibernate.connection.username", null);
        //config.setProperty("hibernate.connection.password", null);


        config.setProperty("hibernate.connection.pool_size", "1");
        config.setProperty("hibernate.connection.autocommit", "true");
        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

        config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        config.setProperty("hibernate.current_session_context_class", "thread");

        //Matched classes to database tables
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(CustomerPhone.class);
        config.addAnnotatedClass(CustomerAddress.class);

        ServiceRegistry serviceRegistry =
                new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public  Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}






