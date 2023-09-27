package lk.ijse.gdse.config;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "lk.ijse.gdse.assignment2springaad.repo")
public class JPAConfiguration {
    public JPAConfiguration() {
        System.out.println("JPAConfiguration created!");
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ProjectTechLeadManagement?createDatabaseIfNotExist=true");
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("1234");
        return driverManagerDataSource;
    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
        vendor.setShowSql(true);
        vendor.setDatabase(Database.MYSQL);
        vendor.setGenerateDdl(true);
        return vendor;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter vendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(vendorAdapter);//vendorAdapter
        bean.setDataSource(dataSource);//connection
        bean.setPackagesToScan("lk.ijse.gdse.assignment2springaad.entity");//Where to scan for entities.
        return bean;

    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
