/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.resource.containers;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.XtextLiveScopeResourceSetProvider;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class LiveShadowedAllContainerStateTest {
	@Inject
	private IAllContainersState.Provider containerStateProvider;

	@Inject
	private ResourceDescriptionsProvider resourceDescriptionProvider;

	@Inject
	private XtextLiveScopeResourceSetProvider liveScopeResourceSetProvider;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Before
	public void setUp() throws Exception {
		TestsActivator.getInstance().getInjector(TestsActivator.ORG_ECLIPSE_XTEXT_UI_TESTS_TESTLANGUAGE).injectMembers(this);
	}

	@After
	public void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	@Test
	public void testInMemoryResourceWithoutProject() throws Exception {
		XtextResourceSet rs = new XtextResourceSet();
		rs.getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
		Resource resource = rs.createResource(URI.createPlatformResourceURI("myproject/myfile." + fileExtensionProvider.getPrimaryFileExtension(), true));
		resource.load(new StringInputStream("stuff foo"), Collections.emptyMap());
		String expected = 
				"container myproject isEmpty=false {\n" +
				"	resourceURI=platform:/resource/myproject/myfile.testlanguage exported=[foo]\n" +
				"}\n";
		Assert.assertEquals(expected, formatContainers(rs));
	}

	@Test
	public void testInMemoryResourceWithProject() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("MyProject");
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
		ResourceSet rs = liveScopeResourceSetProvider.get(project);
		Resource resource = rs.createResource(URI.createPlatformResourceURI("MyProject/myfile." + fileExtensionProvider.getPrimaryFileExtension(), true));
		resource.load(new StringInputStream("stuff foo"), Collections.emptyMap());
		String expected = 
				"container MyProject isEmpty=false {\n" +
				"	resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]\n" +
				"}\n";
		Assert.assertEquals(expected, formatContainers(rs));
	}

	@Test
	public void testEmptyProject() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("MyProject");
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
		ResourceSet rs = liveScopeResourceSetProvider.get(project);
		String expected = 
				"container MyProject isEmpty=true {\n" +
				"}\n";
		Assert.assertEquals(expected, formatContainers(rs));
	}

	@Test
	public void testPersistedWithoutResource() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("MyProject");
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
		String fileName = "MyProject/myfile." + fileExtensionProvider.getPrimaryFileExtension();
		IResourcesSetupUtil.createFile(fileName, "stuff foo");
		IResourcesSetupUtil.waitForBuild();
		ResourceSet rs = liveScopeResourceSetProvider.get(project);
		String expected = 
				"container MyProject isEmpty=false {\n" +
				"	resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]\n" +
				"}\n";
		Assert.assertEquals(expected, formatContainers(rs));
	}

	@Test
	public void testPersistedWithResource() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("MyProject");
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
		String fileName = "MyProject/myfile." + fileExtensionProvider.getPrimaryFileExtension();
		IResourcesSetupUtil.createFile(fileName, "stuff foo");
		IResourcesSetupUtil.waitForBuild();
		ResourceSet rs = liveScopeResourceSetProvider.get(project);
		Assert.assertNotNull(rs.getResource(URI.createPlatformResourceURI(fileName, true), true));
		String expected = 
				"container MyProject isEmpty=false {\n" +
				"	resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]\n" +
				"}\n";
		Assert.assertEquals(expected, formatContainers(rs));
	}

	@Test
	public void testPersistedWithOtherResource() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("MyProject");
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
		String fileName = "MyProject/myfile1." + fileExtensionProvider.getPrimaryFileExtension();
		IResourcesSetupUtil.createFile(fileName, "stuff foo");
		IResourcesSetupUtil.waitForBuild();
		ResourceSet rs = liveScopeResourceSetProvider.get(project);
		Resource resource = rs.createResource(URI.createPlatformResourceURI("MyProject/myfile2." + fileExtensionProvider.getPrimaryFileExtension(), true));
		resource.load(new StringInputStream("stuff bar"), Collections.emptyMap());
		String expected = 
				"container MyProject isEmpty=false {\n" +
				"	resourceURI=platform:/resource/MyProject/myfile1.testlanguage exported=[foo]\n" +
				"	resourceURI=platform:/resource/MyProject/myfile2.testlanguage exported=[bar]\n" +
				"}\n";
		Assert.assertEquals(expected, formatContainers(rs));
	}

	private String formatContainers(ResourceSet rs) {
		IResourceDescriptions resourceDescriptions = resourceDescriptionProvider.getResourceDescriptions(rs);
		IAllContainersState containerState = containerStateProvider.get(resourceDescriptions);
		Set<URI> allURIs = Sets.newHashSet(Iterables.transform(rs.getResources(), Resource::getURI));
		Set<String> allContainers = Sets.newHashSet(
				(Iterables.filter(Iterables.transform(allURIs, it -> containerState.getContainerHandle(it)), Predicates.notNull())));
		for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			allContainers.add(p.getName());
		}
		StringBuilder builder = new StringBuilder();
		for (String container : allContainers) {
			builder.append("container ");
			builder.append(container);
			builder.append(" isEmpty=");
			builder.append(containerState.isEmpty(container));
			builder.append(" {\n");
			for (URI uri : IterableExtensions.sortBy(containerState.getContainedURIs(container), URI::toString)) {
				builder.append("	resourceURI=");
				builder.append(uri);
				builder.append(" exported=[");
				builder.append(Joiner.on(", ").join(Iterables
						.transform(resourceDescriptions.getResourceDescription(uri).getExportedObjects(), IEObjectDescription::getName)));
				builder.append("]\n");
			}
			builder.append("}\n");
		}
		return builder.toString();
	}
}
