package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;


@Configuration
@ComponentScan (basePackages = {"web"})
@EnableTransactionManagement
public class JpaDbConf {
    @Bean
    DriverManagerDataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://10.115.115.61:3306/KATA?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC");
        ds.setUsername("admin");
        ds.setPassword("Denis_16");
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean fb = new LocalContainerEntityManagerFactoryBean();
        fb.setDataSource(getDataSource());
        fb.setPackagesToScan("web.model");
        fb.setJpaProperties(additionalProperties());
        fb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return fb;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return tm;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        return properties;

    }
}
