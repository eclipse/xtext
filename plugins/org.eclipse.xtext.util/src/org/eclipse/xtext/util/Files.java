/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class Files {

	private static Logger log = Logger.getLogger(Files.class);

	public static void copyFiles(String sourceDir, String targetDir, List<String> files) {
		File target = new File(targetDir);
		if (!target.exists()) {
			target.mkdir();
		}
		for (String file : files) {
			File copy = new File(target.getAbsolutePath() + File.separatorChar + file);
			if (!copy.exists()) {
				try {
					ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
					String uri = sourceDir + "/" + file;
					InputStream is = contextClassLoader.getResourceAsStream(uri);
					copy.createNewFile();
					FileOutputStream fwr = new FileOutputStream(copy);
					byte[] buff = new byte[1024];
					int read;
					while ((read = is.read(buff)) != -1) {
						fwr.write(buff, 0, read);
					}
					log.debug("Copied " + copy);
				}
				catch (IOException e) {
					log.error(e);
				}
			}
		}
	}

	public static void cleanFolder(File f) throws FileNotFoundException {
		if (!f.exists()) {
			throw new FileNotFoundException(f.getAbsolutePath());
		}
		log.info("Cleaning folder " + f.toString());
		final File[] contents = f.listFiles();
		for (int j = 0; j < contents.length; j++) {
			final File file = contents[j];
			if (file.isDirectory()) {
				cleanFolder(file);
			}
			else {
				if (!file.delete()) {
					log.error("Couldn't delete " + file.getAbsolutePath());
				}
			}
		}
		f.delete();
	}
}
