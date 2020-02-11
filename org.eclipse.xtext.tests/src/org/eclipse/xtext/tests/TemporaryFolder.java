/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tests;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.rules.ExternalResource;

import com.google.common.io.Files;
import com.google.inject.Singleton;

/**
 * Basically copied from {@link org.junit.rules.TemporaryFolder}
 * which looks different in different junit versions and does not reset
 * the private field {@link #folder} on the {@link #after()} event.
 * 
 * Another change is that the folder is only created on demand.
 * 
 * The TemporaryFolder Rule allows creation of files and folders that are
 * guaranteed to be deleted when the test method finishes (whether it passes or
 * fails):
 * 
 * <pre>
 * public static class HasTempFolder {
 * 	&#064;Rule
 * 	public TemporaryFolder folder= new TemporaryFolder();
 * 
 * 	&#064;Test
 * 	public void testUsingTempFolder() throws IOException {
 * 		File createdFile= folder.newFile(&quot;myfile.txt&quot;);
 * 		File createdFolder= folder.newFolder(&quot;subfolder&quot;);
 * 		// ...
 * 	}
 * }
 * </pre>
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * 
 * @since 2.7
 */
@Singleton
public class TemporaryFolder extends ExternalResource {
	private File folder;

	private boolean initialized = false;
	
	@Override
	protected void before() throws Throwable {
		initialized = true;
	}
	
	@Override
	protected void after() {
		if (folder != null) {
			delete();
			folder = null;
			initialized = false;
		}
	}
	
	public boolean isInitialized() {
		return initialized;
	}
	
	// public for testing purposes only
	/**
	 * for testing purposes only.  Do not use.
	 */
	public void create() throws IOException {
		folder = Files.createTempDir();
	}
	
	/**
	 * Returns a new fresh file with the given name under the temporary folder.
	 */
	public File newFile(String fileName) throws IOException {
		File file= new File(getRoot(), fileName);
		file.createNewFile();
		return file;
	}
	
	/**
	 * Same signature as {@link java.io.File#createTempFile(String, String)}.
	 */
	public File createTempFile(String prefix, String suffix) throws IOException {
		return File.createTempFile(prefix, suffix, getRoot());
	}

	/**
	 * Returns a new fresh file with a random name under the temporary folder.
	 */
	public File newFile() throws IOException {
		return File.createTempFile("junit", null, getRoot());
	}

	/**
	 * Returns a new fresh folder with the given name under the temporary folder.
	 */
	public File newFolder(String... folderNames) {
		File file = getRoot();
		for (String folderName : folderNames) {
			file = new File(file, folderName);
			file.mkdir();
		}
		return file;
	}

	/**
	 * Returns a new fresh folder with a random name under the temporary
	 * folder.
	 */
	public File newFolder() throws IOException {
		try {
			File tempDir = createTempDir(getRoot());
			addSourceInfo(tempDir);
			return tempDir;
		} catch (IllegalStateException e) {
			throw new IOException(e.getMessage()); // IOException(e) not available prior to 1.6
		}
	}
	
	/**
	 * generate '.createdBy' file with a stack trace so tests that leak temp folders can be identified later.
	 */
	protected void addSourceInfo(File tempDir) throws IOException {
		PrintStream printStream = new PrintStream(new File(tempDir, ".createdBy"));
		try {
			printStream.append("This temp dir has been created from the stack below. If you want to make sure the temp folders are cleaned up after a test executed, you should add the following to your test class: \n\n");
			printStream.append("     @Rule @Inject public TemporaryFolder temporaryFolder \n\n");
			new Exception().printStackTrace(printStream);
		} finally {
			printStream.close();
		}
		
	}

	/**
	 * Copied from Guava 10.x but added a base dir argument
	 */
	private File createTempDir(File baseDir) {
		String baseName = System.currentTimeMillis() + "-";

		for (int counter = 0; counter < 10000; counter++) {
			File tempDir = new File(baseDir, baseName + counter);
			if (tempDir.mkdir()) {
				return tempDir;
			}
		}
		throw new IllegalStateException("Failed to create directory within " + 10000 + " attempts (tried " + baseName
				+ "0 to " + baseName + (10000 - 1) + ')');
	}
	
	/**
	 * @return the location of this temporary folder.
	 */
	public File getRoot() {
		if (folder == null) {
			try {
				create();
			} catch(IOException e) {
				throw new IllegalStateException("the temporary folder could not be created", e);
			}
		}
		return folder;
	}

	/**
	 * Delete all files and folders under the temporary folder.
	 * Usually not called directly, since it is automatically applied
	 * by the {@link Rule}
	 */
	public void delete() {
		recursiveDelete(folder);
	}

	private void recursiveDelete(File file) {
		File[] files= file.listFiles();
		if (files != null)
			for (File each : files)
				recursiveDelete(each);
		file.delete();
	}
}

