package pfa.iir5.gestion_frais_transport.configs;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig {

    private final EntityManager entityManager;

    @Autowired
    public DataRestConfig(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurer() {

            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
                    CorsRegistry cors) {

                entityManager.getMetamodel().getEntities().forEach(entity -> {
                    config.exposeIdsFor(entity.getJavaType());
                });

                entityManager.getMetamodel().getEntities().forEach(entity -> {
                    config.getExposureConfiguration().forDomainType(entity.getJavaType())
                            .disablePutForCreation();
                });
            }
        };
    }
}
