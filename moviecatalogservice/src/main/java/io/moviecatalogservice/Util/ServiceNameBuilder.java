package io.moviecatalogservice.Util;

public class ServiceNameBuilder {
    
    public static String buildServiceName(String serviceName, String url){
        return "http://" + serviceName + url;
    }
}
