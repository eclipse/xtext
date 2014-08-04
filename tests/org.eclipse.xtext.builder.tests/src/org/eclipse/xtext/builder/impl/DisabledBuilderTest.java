/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.junit.Test;

/**
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=412501
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DisabledBuilderTest extends AbstractBuilderTest {

	@Test
	public void testDisabledProject() throws CoreException {
		IBuilderState descriptions = BuilderUtil.getBuilderState();
		URI uri = URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore");
		assertNull(descriptions.getResourceDescription(uri));
		
		IProject foo = createPluginProject("foo", false, null);
		foo.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		assertNull(descriptions.getResourceDescription(uri));

		createPluginProject("bar", true, "foo");
		foo.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		assertNotNull(descriptions.getResourceDescription(uri));
	}
	
	
	private IProject createPluginProject(String name, boolean addBuilder, String dependency) throws CoreException {
		PluginProjectFactory projectFactory = getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(JavaCore.BUILDER_ID, "org.eclipse.pde.ManifestBuilder",
				"org.eclipse.pde.SchemaBuilder");
		if (addBuilder) {
			projectFactory.addBuilderIds(XtextProjectHelper.BUILDER_ID);
		}
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature",
				XtextProjectHelper.NATURE_ID);
		projectFactory.addRequiredBundles(Collections.singletonList("org.eclipse.emf.ecore"));
		if(dependency != null)
			projectFactory.addRequiredBundles(Collections.singletonList(dependency));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		return result;
	}

}
