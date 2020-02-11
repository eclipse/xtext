/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.junit.Assert.*;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class Bug355821Test extends AbstractParticipatingBuilderTest {
	
	@Inject
	private PluginProjectFactory projectFactory;
	
	@Test public void testBuildIsInvokedOnlyOnceWhenManifestChanges() throws Exception {
		IProject fooProject = createPluginProject("Foo");
		build();
		
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
//		manifestContent += "Bundle-RequiredExecutionEnvironment: JavaSE-1.8\n";
		reset();
		manifestFile.setContents(new StringInputStream(manifestContent), true, true, monitor());
		build();
		assertEquals(1, getInvocationCount());
	}
	
	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		if (context.getBuildType() == BuildType.FULL) {
			invocationCount++;
		}
	}

	private IProject createPluginProject(String name) throws CoreException {
		projectFactory.setProjectName(name);
		projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
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
