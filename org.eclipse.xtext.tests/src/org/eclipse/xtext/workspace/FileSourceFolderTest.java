/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.workspace;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.StringEndsWith.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.Test;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class FileSourceFolderTest {

	@Test
	public void testNoTrailingPathSeparator() {
		FileSourceFolder fileSourceFolder = new FileSourceFolder(
			new FileProjectConfig(new File("lib")), "aname");
		assertThat(fileSourceFolder.toString(), endsWith("aname/)"));
	}

	@Test
	public void testTrailingPathSeparator() {
		FileSourceFolder fileSourceFolder = new FileSourceFolder(
				new FileProjectConfig(new File("lib")), "aname/");
		assertThat(fileSourceFolder.toString(), endsWith("aname/)"));
	}

	@Test
	public void testEqualsHashcode() {
		FileSourceFolder fileSourceFolderWithTrailingSeparator = new FileSourceFolder(
				new FileProjectConfig(new File("lib")), "aname/");
		FileSourceFolder fileSourceFolderWithoutTrailingSeparator = new FileSourceFolder(
				new FileProjectConfig(new File("lib")), "aname");
		assertEquals(fileSourceFolderWithTrailingSeparator,
				fileSourceFolderWithoutTrailingSeparator);
		assertEquals(fileSourceFolderWithTrailingSeparator.hashCode(),
				fileSourceFolderWithoutTrailingSeparator.hashCode());
	}
}
