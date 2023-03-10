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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.clustering.CopiedResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug334456Test extends AbstractBuilderTest {

	@Inject
	private Provider<PluginProjectFactory> projectFactoryProvider;
	
	@Test public void testNoCopiedResourceDescription() throws Exception {
		createPluginProject("foo");
		build();
		IResourceDescriptions descriptions = BuilderUtil.getBuilderState();
		assertFalse(Iterables.isEmpty(descriptions.getAllResourceDescriptions()));
		for(IResourceDescription description: descriptions.getAllResourceDescriptions()) {
			if (description instanceof CopiedResourceDescription) {
				fail("Did not expect an instance of copied resource description in builder state");
			}
		}
	}
	
	@Test public void testSameResourceCountForTwoProjects() throws Exception {
		IProject fooProject = createPluginProject("foo");
		build();
		IResourceDescriptions descriptions = BuilderUtil.getBuilderState();
		int firstSize = Iterables.size(descriptions.getAllResourceDescriptions());
		IProject barProject = createPluginProject("bar");
		build();
		descriptions = BuilderUtil.getBuilderState();
		int secondSize = Iterables.size(descriptions.getAllResourceDescriptions());
		assertEquals(firstSize, secondSize);
		barProject.close(null);
		build();
		descriptions = BuilderUtil.getBuilderState();
		int thirdSize = Iterables.size(descriptions.getAllResourceDescriptions());
		assertEquals(firstSize, thirdSize);
		fooProject.close(null);
		build();
		descriptions = BuilderUtil.getBuilderState();
		int forthSize = Iterables.size(descriptions.getAllResourceDescriptions());
		// no remaining references to archives - fewer entries in index
		assertTrue(firstSize > forthSize);
	}

	private IProject createPluginProject(String name) throws CoreException {
		PluginProjectFactory projectFactory = projectFactoryProvider.get();
		projectFactory.setProjectName(name);
		projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(
			JavaCore.BUILDER_ID, 
			"org.eclipse.pde.ManifestBuilder",
			"org.eclipse.pde.SchemaBuilder",
			XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", XtextProjectHelper.NATURE_ID);
		projectFactory.addRequiredBundles(Collections.singletonList("org.eclipse.xtext"));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		return result;
	}

}
