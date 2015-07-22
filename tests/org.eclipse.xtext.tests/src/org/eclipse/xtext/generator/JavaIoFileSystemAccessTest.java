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
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.CharSequenceTraceWrapper;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.ByteStreams;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaIoFileSystemAccessTest extends Assert {

	@Test
	public void testDirsAndFilesAreCreated() throws Exception {
		File dir = null;
		File textFile = null;
		File binFile = null;
		try {

			JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess(
					IResourceServiceProvider.Registry.INSTANCE, new IEncodingProvider.Runtime());

			File tmpDir = configureFileSystemAccess(fileSystemAccess);
			fileSystemAccess.generateFile("tmp/X", "XX");
			fileSystemAccess.generateFile("tmp/Y", new StringInputStream("\1\2\3"));

			dir = new File(tmpDir, "tmp");
			assertTrue(dir.exists());
			assertTrue(dir.isDirectory());

			textFile = new File(dir, "X");
			assertTrue(textFile.exists());
			assertTrue(textFile.isFile());
			assertEquals("XX", fileSystemAccess.readTextFile("tmp/X"));

			binFile = new File(dir, "Y");
			assertTrue(binFile.exists());
			assertFalse(fileSystemAccess.isFile("tmp", IFileSystemAccess.DEFAULT_OUTPUT)); // isFile evaluates to false for directories
			assertTrue(fileSystemAccess.isFile("tmp/Y", IFileSystemAccess.DEFAULT_OUTPUT));
			assertTrue(binFile.isFile());
			InputStream stream = fileSystemAccess.readBinaryFile("tmp/Y");
			try {
				assertEquals("\1\2\3", new String(ByteStreams.toByteArray(stream)));
			} finally {
				stream.close();
			}

		} finally {
			try {
				if (textFile != null)
					textFile.delete();
			} finally {
				try {
					if (binFile != null)
						binFile.delete();
				} finally {
					if (dir != null)
						dir.delete();
				}
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
		String expectedUri = new File(new File(File.separator + "testDir"), "testFile").toURI().toString();
		assertEquals(expectedUri, uri.toString());
	}

	@Test
	public void testEncoding() throws Exception {
		File file = null;
		try {
			JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess(
					IResourceServiceProvider.Registry.INSTANCE, new IEncodingProvider() {
						@Override
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

	@Test
	public void testTraceIsCreated() throws Exception {
		File file = null;
		try {

			JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess(
					IResourceServiceProvider.Registry.INSTANCE, new IEncodingProvider.Runtime(),
					new TraceFileNameProvider(), new TraceRegionSerializer());

			File tmpDir = configureFileSystemAccess(fileSystemAccess);
			SourceRelativeURI uri = new SourceRelativeURI(URI.createURI("foo/bar"));
			CharSequenceTraceWrapper wrapper = new CharSequenceTraceWrapper();
			fileSystemAccess.generateFile("tmp/X", wrapper.wrapWithTraceData("XX", uri, 0, 10, 0, 1));

			file = new File(tmpDir, "tmp/X");
			assertTrue(file.exists());
			assertTrue(file.isFile());
			assertEquals("XX", fileSystemAccess.readTextFile("tmp/X"));

			file = new File(tmpDir, "tmp/.X._trace");
			assertTrue(file.exists());
			assertTrue(file.isFile());

		} finally {
			if (file != null)
				file.delete();
		}
	}
}
