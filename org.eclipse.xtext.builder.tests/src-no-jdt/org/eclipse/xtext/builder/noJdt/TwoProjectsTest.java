/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.noJdt;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class TwoProjectsTest extends AbstractBuilderTest {

	private IProject first;
	private IFile firstFile;

	private IProject second;
	private IFile secondFile;

	@Before
	public void createProjects() throws Exception {
		workspace.run((monitor) -> {
			first = createEmptyXtextProject("first");
			second = createEmptyXtextProject("second");
		});
	}

	protected void addProjectReference(IProject from, IProject referencedProject) throws CoreException {
		IProjectDescription description = from.getDescription();
		description.setReferencedProjects(new IProject[] { referencedProject });
		from.setDescription(description, null);
	}

	protected void removeProjectReference(IProject from) throws CoreException {
		IProjectDescription description = from.getDescription();
		description.setReferencedProjects(new IProject[0]);
		from.setDescription(description, null);
	}

	@After
	public void forgetProjects() throws Exception {
		first = null;
		firstFile = null;
		second = null;
		secondFile = null;
	}

	@Test
	public void testTwoFilesInTwoReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
	}

	@Test
	public void testTwoFilesInTwoReferencedProjectsRemoveNature() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeNature(first, XtextProjectHelper.NATURE_ID);
		build();
		assertEquals(1, countMarkers(secondFile));
	}

	@Test
	public void testTwoFilesInTwoReferencedProjectsAddNature() throws Exception {
		workspace.run((monitor) -> {
			removeNature(first, XtextProjectHelper.NATURE_ID);
			firstFile = createFile("first/first" + F_EXT, "Hello First!");
			secondFile = createFile("second/second" + F_EXT, "Hello Second ( from First )!");
		});
		build();
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		assertEquals(printMarkers(secondFile), 1, countMarkers(secondFile));
		addProjectReference(second, first);
		build();
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		assertEquals(printMarkers(secondFile), 1, countMarkers(secondFile));
		addNature(first.getProject(), XtextProjectHelper.NATURE_ID);
		build();
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
	}

	protected void createTwoFilesInTwoReferencedProjects() throws Exception {
		workspace.run((monitory) -> {
			firstFile = createFile("first/first" + F_EXT, "Hello First!");
			secondFile = createFile("second/second" + F_EXT, "Hello Second ( from First )!");
			addProjectReference(second, first);
		});
		build();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(0, countMarkers(secondFile));
	}

	@Test
	public void testTwoFilesInTwoInversedReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeProjectReference(second);
		build();
		addProjectReference(first, second);
		build();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(1, countMarkers(secondFile));
	}

	@Test
	public void testTwoFilesInTwoNonReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeProjectReference(second);
		build();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(1, countMarkers(secondFile));
	}

	@Test
	public void testChangeReferenceOfProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		removeProjectReference(second);
		build();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(1, countMarkers(secondFile));
		addProjectReference(second, first);
		build();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(0, countMarkers(secondFile));
	}

	@Test
	public void testOpenAndCloseReferencedProjects() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		first.getProject().close(monitor());
		build();
		assertEquals(1, countMarkers(secondFile));
		first.getProject().open(monitor());
		build();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
	}

	@Test
	public void testChangeReferencedFile() throws Exception {
		createTwoFilesInTwoReferencedProjects();

		// change referenced file
		firstFile.setContents(new StringInputStream("Hello Third!"), true, true, monitor());
		build();
		assertEquals(1, countMarkers(secondFile));

		//change back to valid state
		firstFile.setContents(new StringInputStream("Hello First!"), true, true, monitor());
		build();
		assertEquals(0, countMarkers(secondFile));
	}

	@Test
	public void testDeleteReferencedFile() throws Exception {
		createTwoFilesInTwoReferencedProjects();

		// delete referenced file
		firstFile.delete(true, new NullProgressMonitor());
		build();
		assertEquals(1, countMarkers(secondFile));

		// create new
		firstFile = createFile("first/first" + F_EXT, "Hello First!");
		build();
		assertEquals(0, countMarkers(firstFile));
		assertEquals(0, countMarkers(secondFile));
	}

	@Test
	public void testOpenAndCloseReferencedProjectsTogether_01() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		build();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		workspace.run((monitor) -> {
			first.getProject().close(monitor);
			second.getProject().close(monitor);
		});
		build();
		workspace.run((monitor) -> {
			first.getProject().open(monitor);
			second.getProject().open(monitor);
		});
		build();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
	}

	@Test
	public void testOpenAndCloseReferencedProjectsTogether_02() throws Exception {
		createTwoFilesInTwoReferencedProjects();
		build();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
		first.getProject().close(monitor());
		second.getProject().close(monitor());
		build();
		first.getProject().open(monitor());
		second.getProject().open(monitor());
		build();
		assertEquals(printMarkers(secondFile), 0, countMarkers(secondFile));
		assertEquals(printMarkers(firstFile), 0, countMarkers(firstFile));
	}

}
