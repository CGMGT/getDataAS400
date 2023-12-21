package gt.com.tigo.getDataAS400.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "gt.com.tigo.getDataAS400.dao.as400",
        entityManagerFactoryRef = "assetEntityManager",
        transactionManagerRef = "assetTransactionManager"
)
public class getDataAS400Config {

    @Value("${spring.datasource.as400.jndi-name}")
    private String assetsJndi;

    @Bean
    public DataSource assetsDataSource() {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(this.assetsJndi);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean assetEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(assetsDataSource());

        em.setPackagesToScan("gt.com.tigo.getDataAS400.model.as400");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public PlatformTransactionManager assetTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(assetEntityManager().getObject());

        return transactionManager;
    }

}
