/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.IXtextBuilderParticipant.BuildType;
import org.eclipse.xtext.builder.tests.Activator;
import org.eclipse.xtext.builder.tests.LoggingBuilderParticipant;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class BuildCancellationTest extends AbstractBuilderTest {

	private LoggingBuilderParticipant participant;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		IXtextBuilderParticipant instance = Activator.getInstance()
				.getInjector("org.eclipse.xtext.builder.tests.BuilderTestLanguage")
				.getInstance(IXtextBuilderParticipant.class);
		participant = (LoggingBuilderParticipant) instance;
		participant.startLogging();
	}

	@Override
	protected void tearDown() throws Exception {
		participant.stopLogging();
		participant = null;
		super.tearDown();
	}

	/** see https://bugs.eclipse.org/bugs/show_bug.cgi?id=325814 */
	public void testCancellationTriggersFullBuild() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		participant.reset();

		OperationCanceledException expected = new OperationCanceledException();
		try {
			participant.cancel(expected);
			project.getProject().build(IncrementalProjectBuilder.FULL_BUILD, monitor());
			fail("Expected OperationCanceledException");
		} catch (OperationCanceledException e) {
			assertSame(expected, e);
		} catch (Exception e) {
			fail("Expected OperationCanceledException");
		}
		participant.reset();

		waitForAutoBuild();
		assertEquals(1, participant.getInvocationCount());
		assertSame(BuildType.FULL, participant.getContext().getBuildType());
		participant.reset();
	}

}
