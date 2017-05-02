package com.at.config;

import com.at.audit.UsernameAuditorAware;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.cache.ehcache.EhCacheRegionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableJpaRepositories("com.at.repository")
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@EnableJpaAuditing
public class DatabaseConfig
{

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "database.driver";
    private static final String PROPERTY_NAME_DATABASE_URL = "database.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "database.username";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "database.password";
    private static final String PROPERTY_NAME_DATABASE_MIN_POOL_SIZE = "database.minPoolSize";
    private static final String PROPERTY_NAME_DATABASE_MAX_POOL_SIZE = "database.maxPoolSize";

    private static final String PROPERTY_JODA_AUTO_REGISTER_USER_TYPES = "jadira.usertype.autoRegisterUserTypes";
    private static final String PROPERTY_HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS = "hibernate.enable_lazy_load_no_trans";
    private static final String PROPERTY_HIBERNATE_USE_SECOND_LEVEL_CACHE = "hibernate.cache.use_second_level_cache";
    private static final String PROPERTY_HIBERNATE_USE_QUERY_CACHE = "hibernate.cache.use_query_cache";
    private static final String PROPERTY_HIBERNATE_CACHE_REGION_FACTORY_CLASS = "hibernate.cache.region.factory_class";
    private static final String PROPERTY_HIBERNATE_EHCACHE_CONFIG_RESOURCE_NAME = "net.sf.ehcache.configurationResourceName";
    private static final String PROPERTY_HIBERNATE_C3P0_PRIVILEGE_SPAWNED_TREADS = "hibernate.c3p0.privilegeSpawnedThreads";
    private static final String PROPERTY_HIBERNATE_C3P0_CONTEXT_CLASS_LOADER_SOURCE = "hibernate.c3p0.contextClassLoaderSource";



    @Resource
    private Environment env;


    @Bean
    AuditorAware<String> auditorProvider()
    {
        return new UsernameAuditorAware();
    }

    @Bean
    DataSource dataSource()
            throws
                PropertyVetoException
    {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUser(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        dataSource.setMinPoolSize(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_DATABASE_MIN_POOL_SIZE)));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_DATABASE_MAX_POOL_SIZE)));
        dataSource.setTestConnectionOnCheckout(true);

        return dataSource;
    }

    @Bean
    JpaVendorAdapter jpaVendorAdapter()
    {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        return vendorAdapter;
    }

    @Bean
    EntityManagerFactory entityManagerFactory()
            throws
                PropertyVetoException
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        factory.setPackagesToScan("com.at.model.entity");
        factory.setDataSource(dataSource());
        factory.setJpaPropertyMap(jpaPropertyMap());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    JpaTransactionManager transactionManager()
            throws
                PropertyVetoException
    {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    /**
     * Fill JPA property map.
     *
     * @return JPA property map
     */
    private Map<String, String> jpaPropertyMap()
    {
        final Map<String, String> properties = new HashMap<>();
        properties.put(PROPERTY_JODA_AUTO_REGISTER_USER_TYPES, "true");
        properties.put(PROPERTY_HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS, "true");
        properties.put(PROPERTY_HIBERNATE_USE_SECOND_LEVEL_CACHE, "true");
        properties.put(PROPERTY_HIBERNATE_USE_QUERY_CACHE, "true");
        properties.put(PROPERTY_HIBERNATE_C3P0_PRIVILEGE_SPAWNED_TREADS, "true");
        properties.put(PROPERTY_HIBERNATE_C3P0_CONTEXT_CLASS_LOADER_SOURCE, "library");
        properties.put(PROPERTY_HIBERNATE_CACHE_REGION_FACTORY_CLASS, EhCacheRegionFactory.class.getName());
        properties.put(PROPERTY_HIBERNATE_EHCACHE_CONFIG_RESOURCE_NAME, "/ehcache.xml");

        return properties;
    }

}
