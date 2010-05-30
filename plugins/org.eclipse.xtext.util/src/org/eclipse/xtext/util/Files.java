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
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;

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
				String uri = sourceDir + "/" + file;
				ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
				InputStream is = contextClassLoader.getResourceAsStream(uri);
				try {
					copy.createNewFile();
					FileOutputStream fwr = new FileOutputStream(copy);
					byte[] buff = new byte[1024];
					int read;
					while ((read = is.read(buff)) != -1) {
						fwr.write(buff, 0, read);
					}
					log.debug("Copied " + copy);
				} catch (IOException e) {
					log.error(e);
				} finally {
					try {
						is.close();
					} catch (IOException e) {
						log.error(e);
					}
				}
			}
		}
	}

	public static boolean cleanFolder(File parentFolder, final FileFilter filter, boolean continueOnError,
			boolean deleteParentFolder) throws FileNotFoundException {
		if (!parentFolder.exists()) {
			throw new FileNotFoundException(parentFolder.getAbsolutePath());
		}
		FileFilter myFilter = filter;
		if (myFilter == null)
			myFilter = new FileFilter() {
				public boolean accept(File pathname) {
					return true;
				}
			};
		log.debug("Cleaning folder " + parentFolder.toString());
		final File[] contents = parentFolder.listFiles(myFilter);
		for (int j = 0; j < contents.length; j++) {
			final File file = contents[j];
			if (file.isDirectory()) {
				if (!cleanFolder(file, myFilter, continueOnError, false) && !continueOnError)
					return false;
			} else {
				if (!file.delete()) {
					log.error("Couldn't delete " + file.getAbsolutePath());
					if (!continueOnError)
						return false;
				}
			}
		}
		if (deleteParentFolder) {
			if (!parentFolder.delete()) {
				log.error("Couldn't delete " + parentFolder.getAbsolutePath());
				return false;
			}
		}
		return true;
	}

	/**
	 * This will completely sweep the given folder. Consider using
	 * {@link #cleanFolder(File, FileFilter, boolean, boolean)} if you want to preserve CVS or SVN information.
	 * 
	 * @param folder
	 * @return
	 * @throws FileNotFoundException
	 */
	public static boolean sweepFolder(File folder) throws FileNotFoundException {
		return Files.cleanFolder(folder, new FileFilter() {
			public boolean accept(File pathname) {
				return true;
			}
		}, true, false);
	}

	public static String readFileIntoString(String filename) {
		try {
			FileInputStream inputStream = new FileInputStream(filename);
			try {
				byte[] buffer = new byte[2048];
				int bytesRead = 0;
				StringBuffer b = new StringBuffer();
				do {
					bytesRead = inputStream.read(buffer);
					if (bytesRead != -1)
						b.append(new String(buffer, 0, bytesRead));
				} while (bytesRead != -1);
				return b.toString();
			} finally {
				inputStream.close();
			}
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public static void writeStringIntoFile(String filename, String content) {
		try {
			FileWriter writer = new FileWriter(filename);
			try {
				writer.append(content);
			} finally {
				writer.close();
			}
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
}
