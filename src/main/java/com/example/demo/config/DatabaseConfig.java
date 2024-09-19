package com.example.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {




  /*  @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:testdb")
                .username("sa")
                .password("password")
                .driverClassName("org.h2.Driver")

                .build();
    }*/

    @Bean
    public DataSource dataSource (){
        System.out.println("Initializing DataSource...");
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder

                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("static/createTable.sql")
                /*.addScript("static/fillinTable.sql")*/

                .continueOnError(true)
                .ignoreFailedDrops(true)

                .build();
    }


   /* @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("org.h2.Driver");

        // Выполнение скриптов
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("createTable.sql")); // Ваш файл с схемой
        populator.addScript(new ClassPathResource("fillinTable.sql"));  // Ваш файл с данными

        DatabasePopulatorUtils.execute(populator, dataSource);

        return dataSource;
    }
*/
   /* @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.demo.model");

        return sessionFactory;
    }
    @Bean
    public HibernateTransactionManager transactionManager (){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }*/


  /*  @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("scripts/createTable.sql"));
        populator.addScript(new ClassPathResource("scripts/fillinTable.sql"));


        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(populator);

        return initializer;
    }*/
}
