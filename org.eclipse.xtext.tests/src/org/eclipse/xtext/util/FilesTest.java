/*******************************************************************************
 * Copyright (c) 2019 Universite de Technologie de Belfort-Montbeliard (http://www.utbm.fr) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

/**
 * @author Stephane Galland - Initial contribution and API
 */
public class FilesTest {

	private static File makeFile(File root, String... elements) {
		File res = root;
		for (final String component : elements) {
			if (res == null) {
				res = new File(component);
			} else {
				res = new File(res, component);
			}
		}
		return res;
	}

	private static void touch(File folder, String filename) throws IOException {
		folder.mkdirs();
		final File file = new File(folder, filename);
		file.createNewFile();
	}

	private File createTestFolder() throws IOException {
		File rootPath = makeFile(null, "build", "tmp", "FilesTest" + (int) (Math.random() * 100000000.));
		while (rootPath.exists()) {
			rootPath = makeFile(null, "build", "tmp", "FilesTest" + (int) (Math.random() * 100000000.));
		}
		final File folder1 = makeFile(rootPath, "src", "main", "java");
		final File folder2 = makeFile(rootPath, "src", "main", "java", "mypack");
		final File folder3 = makeFile(rootPath, "src", "generated-sources", "xtend", "mypack");
		final File folder4 = makeFile(rootPath, "target", "classes", "mypack");
		touch(folder1, "MyFile.java");
		touch(folder2, "MyType.xtend");
		touch(folder3, "MyType.java");
		touch(folder4, "MyType.class");
		touch(rootPath, ".hiddenfile");
		return rootPath;
	}

	@Test
	public void cleanFolder_deleteParentTrue() throws Exception {
		final File root = createTestFolder();
		Files.cleanFolder(root, null, true, true);
		assertFalse(root.exists());
	}

	@Test
	public void cleanFolder_deleteParentFalse() throws Exception {
		final File root = createTestFolder();
		Files.cleanFolder(root, null, true, false);
		assertTrue(root.exists());
		assertEquals(0, root.listFiles().length);
	}

}
