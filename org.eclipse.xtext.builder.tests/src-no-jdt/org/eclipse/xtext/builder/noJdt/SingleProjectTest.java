/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.noJdt;

import static org.eclipse.xtext.builder.impl.BuilderUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourceAttributes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class SingleProjectTest extends AbstractBuilderTest {

	private IProject project;

	@Before
	public void createProject() throws Exception {
		project = createEmptyXtextProject("sample");
	}
	
	@After
	public void forgetProject() throws Exception {
		project = null;
	}
	
	@Test public void testValidSimpleModel() throws Exception {
		IFile file = createFile("sample/file" + F_EXT, "Hello World (from World)!");
		build();
		assertEquals(0, countMarkers(file));
	}

	@Test public void testSimpleModelWithSyntaxError() throws Exception {
		IFile file = createFile("sample/sample" + F_EXT, "Hello World");
		build();
		assertEquals(1, countMarkers(file));
	}

	@Test public void testTwoFilesInSameProject() throws Exception {
		IFile file1 = createFile("sample/a" + F_EXT, "Hello A!");
		IFile file2 = createFile("sample/b" + F_EXT, "Hello B (from A)!");
		build();
		assertEquals(printMarkers(file1), 0, countMarkers(file1));
		assertEquals(printMarkers(file2), 0, countMarkers(file2));
		assertTrue(indexContainsElement(file1.getFullPath().toString(), "A"));
		assertTrue(indexContainsElement(file2.getFullPath().toString(), "B"));
		assertEquals(2, countResourcesInIndex());
	}

	@Test public void testTwoFilesInSameProjectRemoveNature() throws Exception {
		createFile("sample/a" + F_EXT, "Hello A!");
		createFile("sample/b" + F_EXT, "Hello B (from A)!");
		build();
		assertEquals(2, countResourcesInIndex());
		removeXtextNature(project);
		build();
		assertEquals(0, countResourcesInIndex());
	}

	@Test public void testTwoFilesInSameProjectWithLinkingError() throws Exception {
		createFile("sample/a" + F_EXT, "Hello A!");
		IFile file = createFile("sample/a" + F_EXT, "Hello B (from C)!");
		build();
		assertEquals(1, countMarkers(file));
	}

	@Test public void testBug342875() throws Exception {
		IFile file = createFile("sample/first" + F_EXT, "Hello A");
		ResourceAttributes resourceAttributes = file.getResourceAttributes();
		resourceAttributes.setReadOnly(true);
		file.setResourceAttributes(resourceAttributes);
		try {
			build();
			assertTrue(file.isReadOnly());
			assertEquals(1, countMarkers(file));
		} finally {
			resourceAttributes.setReadOnly(false);
			file.setResourceAttributes(resourceAttributes);
		}
	}
}
