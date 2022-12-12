
package com.ri.mc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ri.mc.entity.Clinic;
import com.ri.mc.entity.Patient;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    // private EntityManager entityManager;

    // @Autowired
    // public MyDataRestConfig(EntityManager entityManager) {
    //     this.entityManager = entityManager;
    // }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Determine http methods that i would unsupport
        HttpMethod[] TheUnsupportedActions = { HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE };

        // Disable Http Methods for Product: PUT, POST, and DELETE.
        config.getExposureConfiguration()
                .forDomainType(Patient.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(TheUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(TheUnsupportedActions));

        // Disable Http Methods for ProductCategory: PUT, POST, and DELETE.
        config.getExposureConfiguration()
                .forDomainType(Clinic.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(TheUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(TheUnsupportedActions));

        // // call an internal helper method
        // exposeId(config);
    }

    // private void exposeId(RepositoryRestConfiguration config) {

    //     // expose entity id
        
    //     Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

    //     // create an array of entity types
    //     List<Class<?>> entityClasses = new ArrayList<>();

    //     for (final EntityType<?> entityType : entities) {
    //         entityClasses.add(entityType.getJavaType());
    //     }

    //     Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
    //     config.exposeIdsFor(domainTypes);
    // }
}
