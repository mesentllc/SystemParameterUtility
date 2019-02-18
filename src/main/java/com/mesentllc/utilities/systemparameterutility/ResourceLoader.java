package com.mesentllc.utilities.systemparameterutility;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ResourceLoader {
	private static final HashMap<String, String> resources = new HashMap<String, String>();

	private static void addClassPathResource(String path) {
		String line;
		
		try {
			ClassPathResource classPathResource = new ClassPathResource(path);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
			StringBuilder stringBuffer = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line).append("\n");
			}
			resources.put(path, stringBuffer.toString());
		}
		catch (IOException ioe) {
			throw new RuntimeException("Failed to load resource.", ioe);
		}
	}

	public static synchronized String getString(String path) {
		if (!resources.containsKey(path)) {
			addClassPathResource(path);
		}
		return resources.get(path);
	}
}
