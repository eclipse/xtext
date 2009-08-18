/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.releng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.eclipse.xtext.releng.Helper.*;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MaterializeTargetPlatform {

	public static void main(String[] args) throws IOException {
		try {
			String targetDir = "./team/targetplatform/";
			Properties properties = new Properties();
			properties.load(new FileInputStream("./build-local.properties"));
			String downloadURLs = properties.getProperty("dependencyURLs");
			materializeTargetPlatform(downloadURLs, targetDir);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void materializeTargetPlatform(String downloadURLs, String targetDir) throws Exception {
		ensureDirExists(targetDir);

		cleanUp(targetDir);
		// download all zips
		String[] splittedURLs = downloadURLs.split(",");
		for (String downloadURL : splittedURLs) {
			downloadFile(targetDir, downloadURL);
		}

		String eclipseDir = targetDir;
		ensureDirExists(eclipseDir);
		for (String downloadURL : splittedURLs) {
			String fileName = targetDir + getLastSegment(downloadURL);
			extract(fileName, eclipseDir);
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("-- Targetplatform has been materialized to '"+targetDir+"eclipse'");
		System.out.println("-- Please point your PDE tooling to this directory using the 'target platform' preference page");
		System.out.println("------------------------------------------------------------------------------------------------");
	}

	private static void cleanUp(String targetDir) {
		File[] list = new File(targetDir).listFiles();
		for (File file : list) {
			if (file.getName().contains("SNAPSHOT") || file.getName().equals("eclipse")) {
				System.out.println("Deleting " + file.getName());
				file.delete();
			}
		}
	}

}
