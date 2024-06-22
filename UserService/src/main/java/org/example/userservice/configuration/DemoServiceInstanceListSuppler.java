//package org.example.userservice.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.DefaultServiceInstance;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//import java.util.Arrays;
//import java.util.List;
//
//
//public class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {
//
//    private final String serviceId;
//
//    DemoServiceInstanceListSuppler(String serviceId) {
//        this.serviceId = serviceId;
//    }
//    @Override
//    public String getServiceId() {
//        return null;
//    }
//    @Override
//    public Flux<List<ServiceInstance>> get() {
//        return Flux.just(Arrays.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 9997, false),
//                new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 9998, false),
//                new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 9999, false)));    }
//}
