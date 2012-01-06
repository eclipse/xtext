/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaIoFileSystemAccessTest extends Assert {

	@Test public void testDirsAreCreated() throws Exception {
		String tempDir = System.getProperties().getProperty("java.io.tmpdir") + File.separator;
		File tmpDir = new File(tempDir);
		JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess();
		fileSystemAccess.setOutputPath(tempDir);
		fileSystemAccess.generateFile("tmp/X", "XX");
		File dir = new File(tmpDir, "tmp");
		assertTrue(dir.exists());
		assertTrue(dir.isDirectory());
		File file = new File(dir, "X");
		assertTrue(file.exists());
		assertTrue(file.isFile());
		file.delete();
		dir.delete();
	}
	
	@Test public void testURI() throws Exception {
		JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess();
		fileSystemAccess.setOutputPath("testOutput", "/testDir");
		URI uri = fileSystemAccess.getURI("testFile", "testOutput");
		assertEquals("file:/testDir/testFile", uri.toString());
	}
}
