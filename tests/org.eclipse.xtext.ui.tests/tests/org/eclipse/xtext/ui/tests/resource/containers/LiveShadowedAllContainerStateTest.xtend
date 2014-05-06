/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.resource.containers;

import com.google.inject.Inject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.containers.IAllContainersState
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.resource.XtextLiveScopeResourceSetProvider
import org.eclipse.xtext.ui.tests.Activator
import org.eclipse.xtext.util.StringInputStream
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.emf.common.util.URI.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static org.junit.Assert.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class LiveShadowedAllContainerStateTest {

	@Inject IAllContainersState.Provider containerStateProvider
	@Inject ResourceDescriptionsProvider resourceDescriptionProvider
	@Inject XtextLiveScopeResourceSetProvider liveScopeResourceSetProvider;
	@Inject extension FileExtensionProvider

	@Before
	def setUp() throws Exception {
		Activator.getInstance().getInjector(Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_TESTLANGUAGE).injectMembers(this);
	}

	@After
	def tearDown() throws Exception {
		cleanWorkspace();
	}

	@Test def testInMemoryResourceWithoutProject() {
		val rs = new XtextResourceSet
		rs.loadOptions.put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
		val resource = rs.createResource(createPlatformResourceURI("myproject/myfile." + primaryFileExtension, true))
		resource.load(new StringInputStream("stuff foo"), emptyMap)
		val expected = '''
			container myproject isEmpty=false {
				resourceURI=platform:/resource/myproject/myfile.testlanguage exported=[foo]
			}
		'''
		assertEquals(expected, formatContainers(rs))
	}

	@Test def testInMemoryResourceWithProject() {
		val project = createProject("MyProject")
		addNature(project, XtextProjectHelper.NATURE_ID)
		val rs = liveScopeResourceSetProvider.get(project)
		val resource = rs.createResource(createPlatformResourceURI("MyProject/myfile." + primaryFileExtension, true))
		resource.load(new StringInputStream("stuff foo"), emptyMap)
		val expected = '''
			container MyProject isEmpty=false {
				resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]
			}
		'''
		assertEquals(expected, formatContainers(rs))
	}

	@Test def testEmptyProject() {
		val project = createProject("MyProject")
		addNature(project, XtextProjectHelper.NATURE_ID)
		val rs = liveScopeResourceSetProvider.get(project)
		val expected = '''
			container MyProject isEmpty=true {
			}
		'''
		assertEquals(expected, formatContainers(rs))
	}

	@Test def testPersistedWithoutResource() {
		val project = createProject("MyProject")
		addNature(project, XtextProjectHelper.NATURE_ID)
		val fileName = "MyProject/myfile." + primaryFileExtension
		createFile(fileName, "stuff foo")
		waitForAutoBuild()
		val rs = liveScopeResourceSetProvider.get(project)
		val expected = '''
			container MyProject isEmpty=false {
				resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]
			}
		'''
		assertEquals(expected, formatContainers(rs))
	}

	@Test def testPersistedWithResource() {
		val project = createProject("MyProject")
		addNature(project, XtextProjectHelper.NATURE_ID)
		val fileName = "MyProject/myfile." + primaryFileExtension
		createFile(fileName, "stuff foo")
		waitForAutoBuild()
		val rs = liveScopeResourceSetProvider.get(project)
		assertNotNull(rs.getResource(createPlatformResourceURI(fileName, true), true))
		val expected = '''
			container MyProject isEmpty=false {
				resourceURI=platform:/resource/MyProject/myfile.testlanguage exported=[foo]
			}
		'''
		assertEquals(expected, formatContainers(rs))
	}

	@Test def testPersistedWithOtherResource() {
		val project = createProject("MyProject")
		addNature(project, XtextProjectHelper.NATURE_ID)
		val fileName = "MyProject/myfile1." + primaryFileExtension
		createFile(fileName, "stuff foo")
		waitForAutoBuild()
		val rs = liveScopeResourceSetProvider.get(project)
		val resource = rs.createResource(createPlatformResourceURI("MyProject/myfile2." + primaryFileExtension, true))
		resource.load(new StringInputStream("stuff bar"), emptyMap)
		val expected = '''
			container MyProject isEmpty=false {
				resourceURI=platform:/resource/MyProject/myfile1.testlanguage exported=[foo]
				resourceURI=platform:/resource/MyProject/myfile2.testlanguage exported=[bar]
			}
		'''
		assertEquals(expected, formatContainers(rs))
	}

	def private String formatContainers(ResourceSet rs) {
		val resourceDescriptions = resourceDescriptionProvider.getResourceDescriptions(rs)
		val containerState = containerStateProvider.get(resourceDescriptions)
		val allURIs = rs.resources.map[URI].toSet
		val allContainers = allURIs.map[containerState.getContainerHandle(it)].filterNull.toSet
		allContainers += ResourcesPlugin.getWorkspace.root.projects.map[name]
		'''
			«FOR container : allContainers»
				container «container» isEmpty=«containerState.isEmpty(container)» {
«««					visibleContainers=«containerState.getVisibleContainerHandles(container).join(", ")»
					«FOR uri : containerState.getContainedURIs(container).sortBy[toString]»
						resourceURI=«uri» exported=[«resourceDescriptions.getResourceDescription(uri).exportedObjects.map[name].join(", ")»]
					«ENDFOR»
				}
			«ENDFOR»
		'''
	}

}
