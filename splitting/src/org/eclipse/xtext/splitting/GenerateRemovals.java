/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.splitting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateRemovals {

	public static void main(String[] args) {
		if (args.length != 2) {
			fail("Expected paths to splitting.txt and output files as arguments.");
		}
		String outputDir = args[1];
		try {
			final Map<String, List<String>> removalPaths = new HashMap<>();
			for (String targetRepo : ValidateSplitting.REPOSITORIES) {
				removalPaths.put(targetRepo, new ArrayList<>());
			}
			
			// Gather paths to be removed from the history for each target repository
			try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
				String line;
				while ((line = reader.readLine()) != null) {
					if (!line.isEmpty()) {
						String[] parts = line.split(">>");
						String[] repos = parts[1].split(",");
						for (String targetRepo :  ValidateSplitting.REPOSITORIES) {
							boolean isInTargetRepo = false;
							for (String repo : repos) {
								if (targetRepo.equals(repo.trim())) {
									isInTargetRepo = true;
									break;
								}
							}
							if (!isInTargetRepo) {
								String path = parts[0].trim();
								removalPaths.get(targetRepo).add(path);
							}
						}
					}
				}
			}
			
			// Write a removal list for each target repository
			for (String targetRepo : ValidateSplitting.REPOSITORIES) {
				try (FileWriter writer = new FileWriter(outputDir + "/removals-" + targetRepo + ".txt")) {
					for (String path : removalPaths.get(targetRepo)) {
						writer.write(path);
						writer.write('\n');
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private static void fail(String message) {
		System.err.print("ERROR: ");
		System.err.println(message);
		System.exit(1);
	}

}
