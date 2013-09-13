package com.github.skosmalla.flyway.demo;

import com.googlecode.flyway.core.Flyway;


public class FlywayApiDemo {
    /**
     * url = args[0]
     * user = args[1]
     * password args[2]
     * @param args
     */
    public static void main (String[] args){
        Flyway flyway = new Flyway();
        flyway.setDataSource(args[0], args[1], args[2]);
        flyway.migrate();

    }

}
