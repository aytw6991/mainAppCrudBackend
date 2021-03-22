package com.f1soft.config;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.f1soft.controller.AttendanceResource.class);
        resources.add(com.f1soft.controller.EmployeeResource.class);
        resources.add(com.f1soft.controller.UnitResource.class);
        resources.add(filter.CorsFilter.class);
        resources.add(filter.EmployeeFilter.class);
    }
    
}
