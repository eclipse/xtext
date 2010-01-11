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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.nature.XtextNature;
import org.eclipse.xtext.builder.tests.Activator;
import org.eclipse.xtext.builder.tests.LoggingBuilderParticipant;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuilderParticipantTest extends AbstractBuilderTest {

	private LoggingBuilderParticipant participant;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		IXtextBuilderParticipant instance = Activator.getInstance().getInjector(
				"org.eclipse.xtext.builder.tests.BuilderTestLanguage").getInstance(IXtextBuilderParticipant.class);
		participant = (LoggingBuilderParticipant) instance;
		participant.reset();
	}
	
	public void testParticipantInvoked() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		assertTrue(0 < participant.getInvocationCount());
		participant.reset();
		
		file.delete(true, monitor());
		waitForAutoBuild();
		assertEquals(1, participant.getInvocationCount());
	}
}
