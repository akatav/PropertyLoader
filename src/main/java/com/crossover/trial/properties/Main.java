package com.crossover.trial.properties;

import com.crossover.trial.properties.exception.UnsupportedProtocolException;
import com.crossover.trial.properties.loader.PropertiesLoader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws UnsupportedProtocolException, IOException {
    	
    	new Thread(() -> {
    		PropertiesLoader loader = new PropertiesLoader();
	        loader.load(args);
	        System.out.println(loader.getProperties());
    	}).start();
    	
    }
}
