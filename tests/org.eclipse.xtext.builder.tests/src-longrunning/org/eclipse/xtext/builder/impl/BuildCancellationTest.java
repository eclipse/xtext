/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class BuildCancellationTest extends AbstractParticipatingBuilderTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		startLogging();
	}

	/** see https://bugs.eclipse.org/bugs/show_bug.cgi?id=325814 */
	@Test public void testCancellationTriggersFullBuild() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		reset();

		OperationCanceledException expected = new OperationCanceledException();
		try {
			cancel(expected);
			project.getProject().build(IncrementalProjectBuilder.FULL_BUILD, monitor());
			fail("Expected OperationCanceledException");
		} catch (OperationCanceledException e) {
			assertSame(expected, e);
		} catch (Exception e) {
			fail("Expected OperationCanceledException");
		}
		reset();
		ResourcesPlugin.getWorkspace().build(
				IncrementalProjectBuilder.AUTO_BUILD, monitor());
		waitForAutoBuild();
		assertEquals(1, getInvocationCount());
		assertSame(BuildType.FULL, getContext().getBuildType());
		reset();
	}

}
