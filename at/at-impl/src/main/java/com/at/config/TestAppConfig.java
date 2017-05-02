package com.at.config;

import com.at.exception.settings.SettingsNotFoundException;
import com.at.model.entity.settings.Settings;
import com.at.service.GenericService;
import com.at.service.GenericServiceImpl;
import com.at.service.settings.SettingsService;
import com.at.service.settings.SettingsServiceImpl;
import com.at.service.user.UserService;
import org.hibernate.cache.ehcache.EhCacheRegionFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories("com.at.repository")
@EnableJpaAuditing
@EnableTransactionManagement
public class TestAppConfig
{

    private static final String PROPERTY_JODA_AUTO_REGISTER_USER_TYPES = "jadira.usertype.autoRegisterUserTypes";
    private static final String PROPERTY_HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS = "hibernate.enable_lazy_load_no_trans";
    private static final String PROPERTY_HIBERNATE_USE_SECOND_LEVEL_CACHE = "hibernate.cache.use_second_level_cache";
    private static final String PROPERTY_HIBERNATE_USE_QUERY_CACHE = "hibernate.cache.use_query_cache";
    private static final String PROPERTY_HIBERNATE_CACHE_REGION_FACTORY_CLASS = "hibernate.cache.region.factory_class";
    private static final String PROPERTY_HIBERNATE_EHCACHE_CONFIG_RESOURCE_NAME = "net.sf.ehcache.configurationResourceName";
    private static final String PROPERTY_HIBERNATE_C3P0_PRIVILEGE_SPAWNED_TREADS = "hibernate.c3p0.privilegeSpawnedThreads";
    private static final String PROPERTY_HIBERNATE_C3P0_CONTEXT_CLASS_LOADER_SOURCE = "hibernate.c3p0.contextClassLoaderSource";

    @Bean
    DataSource dataSource()
    {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Bean
    EntityManagerFactory entityManagerFactory()
    {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.at.model.entity");
        factory.setDataSource(dataSource());
        factory.setJpaPropertyMap(jpaPropertyMap());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    PlatformTransactionManager transactionManager()
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
