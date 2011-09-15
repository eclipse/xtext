/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import java.io.InputStream;
import java.util.Collections;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.tests.Activator;
import org.eclipse.xtext.builder.tests.DelegatingBuilderParticipant;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class Bug355821Test extends AbstractParticipatingBuilderTest {
	
	public void testBuildIsInvokedOnlyOnceWhenManifestChanges() throws Exception {
		IProject fooProject = createPluginProject("Foo");
		waitForAutoBuild();
		
		IFile manifestFile = fooProject.getFile("META-INF/MANIFEST.MF");
		String manifestContent = "Manifest-Version: 1.0\n";
		manifestContent += "Bundle-ManifestVersion: 2\n";
		manifestContent += "Bundle-Name: Foo\n";
		manifestContent += "Bundle-SymbolicName: Foo; ";
		manifestContent +=	 "singleton:=true\n";
		manifestContent += "Bundle-Version: 1.0.0.qualifier\n";
		manifestContent += "Require-Bundle: org.eclipse.xtext,\n";
		// Add a dependency to change classpath
		manifestContent += " org.eclipse.core.runtime\n";
		manifestContent += "Bundle-ActivationPolicy: lazy\n";
		// Remove this one implies a change of build.properties
//		manifestContent += "Bundle-RequiredExecutionEnvironment: J2SE-1.5\n";
		reset();
		manifestFile.setContents(new StringInputStream(manifestContent), true, true, monitor());
		waitForAutoBuild();
		assertEquals(1, getInvocationCount());

	}
	
	
	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		if (context.getBuildType() == BuildType.FULL)
			invocationCount++;
	}

	private IProject createPluginProject(String name) throws CoreException {
		PluginProjectFactory projectFactory = getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(JavaCore.BUILDER_ID, "org.eclipse.pde.ManifestBuilder",
				"org.eclipse.pde.SchemaBuilder", XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature",
				XtextProjectHelper.NATURE_ID);
		projectFactory.addRequiredBundles(Collections.singletonList("org.eclipse.xtext"));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		return result;
	}
}
