/*******************************************************************************
 * Copyright (c) 2008, 2018 itemis AG (http://www.itemis.eu) and others.
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
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class Files {
	private static Logger log = Logger.getLogger(Files.class);

	/**
	 * Copies a list of files from a source to a target directory. Existing files
	 * are not overwritten. If the target directory does not exist it will be created.
	 * 
	 * @param sourceDir source directory
	 * @param targetDir target directory. Not mandatory to exist before.
	 * @param files File paths relative to the source directory to copy
	 */
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
					try {
						byte[] buff = new byte[1024];
						int read;
						while ((read = is.read(buff)) != -1) {
							fwr.write(buff, 0, read);
						}
					} finally {
						fwr.close();
					}
					log.debug("Copied " + copy);
				} catch (IOException e) {
					log.error(e.getMessage() ,e);
				} finally {
					try {
						is.close();
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		}
	}

	public static boolean cleanFolder(final File parentFolder, final FileFilter filter, boolean continueOnError,
			boolean deleteParentFolder) throws FileNotFoundException {
		if (!parentFolder.exists()) {
			throw new FileNotFoundException(parentFolder.getAbsolutePath());
		}
		FileFilter myFilter = filter;
		if (myFilter == null)
			myFilter = new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					return true;
				}
			};
		log.debug("Cleaning folder " + parentFolder.toString());
		final File[] contents = parentFolder.listFiles(myFilter);
		if (contents == null) {
			return true;
		}
		for (int j = 0; j < contents.length; j++) {
			final File file = contents[j];
			if (file.isDirectory()) {
				if (!cleanFolder(file, myFilter, continueOnError, true) && !continueOnError)
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
			String[] children = parentFolder.list();
			if (children != null && children.length == 0 && !parentFolder.delete()) {
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
	 * @param folder to delete
	 * @return {@code true} if all content was successfully deleted
	 * @throws FileNotFoundException if folder does not exists
	 */
	public static boolean sweepFolder(File folder) throws FileNotFoundException {
		return Files.cleanFolder(folder, new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return true;
			}
		}, true, false);
	}

	/**
	 * @deprecated Use com.google.common.io.Files.toString(File, Charset) instead
	 */
	@Deprecated
	public static String readFileIntoString(String filename) {
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(filename);
			return readStreamIntoString(inputStream);
		} catch (FileNotFoundException e) {
			throw new WrappedException(e);
		}
	}

	
	/**
	 * @since 2.3
	 * @deprecated Use com.google.common.io.ByteStreams.toByteArray(InputStream) instead
	 */
	@Deprecated
	public static byte[] readStreamIntoByteArray(InputStream inputStream) {
		try {
			return ByteStreams.toByteArray(inputStream);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	public static String readStreamIntoString(InputStream inputStream) {
		Preconditions.checkNotNull(inputStream, "inputStream");
		try {
			return new String(ByteStreams.toByteArray(inputStream));
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public static void writeStringIntoFile(String filename, String content) {
		try {
			final File file = new File(filename);
			com.google.common.io.Files.write(content.getBytes(), file);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
}
