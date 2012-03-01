/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static org.eclipse.xtext.util.Strings.*;

import java.io.File;
import java.io.FileInputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaIoFileSystemAccessTest extends Assert {

	@Test
	public void testDirsAreCreated() throws Exception {
		File dir = null;
		File file = null;
		try {
			JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess(
					IResourceServiceProvider.Registry.INSTANCE, new IEncodingProvider.Runtime());
			File tmpDir = configureFileSystemAccess(fileSystemAccess);
			fileSystemAccess.generateFile("tmp/X", "XX");
			dir = new File(tmpDir, "tmp");
			assertTrue(dir.exists());
			assertTrue(dir.isDirectory());
			file = new File(dir, "X");
			assertTrue(file.exists());
			assertTrue(file.isFile());
		} finally {
			try {
				if (file != null)
					file.delete();
			} finally {
				if (dir != null)
					dir.delete();
			}
		}
	}

	protected File configureFileSystemAccess(JavaIoFileSystemAccess fileSystemAccess) {
		String tempDir = System.getProperties().getProperty("java.io.tmpdir") + File.separator;
		File tmpDir = new File(tempDir);
		fileSystemAccess.setOutputPath(tempDir);
		return tmpDir;
	}

	@Test
	public void testURI() throws Exception {
		JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess();
		fileSystemAccess.setOutputPath("testOutput", "/testDir");
		URI uri = fileSystemAccess.getURI("testFile", "testOutput");
		String expectedUri = new File(new File(File.separator + "testDir"), "testFile")
			.toURI().toString();
		assertEquals(expectedUri, uri.toString());
	}

	@Test
	public void testEncoding() throws Exception {
		File file = null;
		try {
			JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess(
					IResourceServiceProvider.Registry.INSTANCE, new IEncodingProvider() {
						public String getEncoding(URI uri) {
							return "ISO-8859-1";
						}
					});
			File tmpDir = configureFileSystemAccess(fileSystemAccess);
			String contents = "gürkenbröd";
			fileSystemAccess.generateFile("test.txt", contents);
			file = new File(tmpDir, "test.txt");
			assertTrue(file.exists());
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] buffer = new byte[512];
			int read = fileInputStream.read(buffer);
			String utfString = new String(buffer, 0, read, "UTF-8");
			assertFalse(equal(contents, utfString));
			String isoString = new String(buffer, 0, read, "ISO-8859-1");
			assertEquals(contents, isoString);
		} finally {
			if (file != null)
				file.delete();
		}
	}
}
