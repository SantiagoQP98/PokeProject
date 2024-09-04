package com.santiago.pokeproject;

import com.santiago.pokeproject.infrastructure.adapter.config.PokeApiProperties;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.text.NumberFormat;

@SpringBootApplication
@Log
@EnableConfigurationProperties(PokeApiProperties.class)
public class PokeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokeProjectApplication.class, args);
        printMemoryInfo();
    }

    private static void printMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        long mb = 1024L * 1024L;
        NumberFormat format = NumberFormat.getInstance();

        long freeMemory = runtime.freeMemory();
        long allocatedMemory = runtime.totalMemory();
        long maxMemory = runtime.maxMemory();

        log.info("========================== Memory Info ==========================");
        log.info("Free memory: " + format.format(freeMemory / mb) + " MB");
        log.info("Allocated memory: " + format.format(allocatedMemory / mb) + " MB");
        log.info("Max memory: " + format.format(maxMemory / mb) + " MB");
        log.info("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + " MB");
        log.info("=================================================================");
    }

}
