/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
public class ResourceDescriptionUpdaterTest extends AbstractParticipatingBuilderTest {

	private static final String SRC_FOLDER = "src";
	private static final String PROJECT2 = "foo2";
	private static final String PROJECT1 = "foo";
	private static final String REFERENCING_FILE_NAME = "target";
	private static final String REFERENCED_FILE_NAME = "source";

	@Override
	@Before
	public void startLogging() {
		super.startLogging();
	}
	
	@Test public void testIndependentProjects() throws Exception {
		IFolder folder = createProjectWithXtextNature(PROJECT1);
		addFile(folder, REFERENCED_FILE_NAME, "namespace bar { object B }");
		addFile(folder, REFERENCING_FILE_NAME, "namespace foo { object A references bar.B}");

		IFolder folder2 = createProjectWithXtextNature(PROJECT2);
		addFile(folder2, REFERENCED_FILE_NAME, "namespace bar { object B }");
		addFile(folder2, REFERENCING_FILE_NAME, "namespace foo { object A references bar.B}");

		reset();
		changeFile(folder, REFERENCED_FILE_NAME, "namespace bar { object B object C }");

		assertTrue(REFERENCED_FILE_NAME, affectedResourcesContain(PROJECT1, REFERENCED_FILE_NAME));
		assertTrue(REFERENCING_FILE_NAME, affectedResourcesContain(PROJECT1, REFERENCING_FILE_NAME));
		assertFalse(REFERENCING_FILE_NAME, affectedResourcesContain(PROJECT2, REFERENCING_FILE_NAME));
	}

	private synchronized boolean affectedResourcesContain(final String projectName, final String fileName) {
		try {
			final URI expected = URI.createPlatformResourceURI(projectName + "/" + SRC_FOLDER + "/" + fileName + F_EXT, true);
			Iterables.find(getContext().getDeltas(), new Predicate<IResourceDescription.Delta>() {

				@Override
				public boolean apply(Delta actual) {
					return expected.equals(actual.getUri());
				}
			});
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private void addFile(IFolder folder, String fileName, String content) throws CoreException {
		IFile file = folder.getFile(fileName + F_EXT);
		file.create(new StringInputStream(content), true, monitor());
		build();
	}

	private void changeFile(IFolder folder, String fileName, String content) throws CoreException {
		IFile file = folder.getFile(fileName + F_EXT);
		file.setContents(new StringInputStream(content), IResource.FORCE, monitor());
		build();
	}

	private IFolder createProjectWithXtextNature(String projectName) throws CoreException, JavaModelException {
		IJavaProject project = createJavaProject(projectName);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder(SRC_FOLDER);
		return folder;
	}
}
