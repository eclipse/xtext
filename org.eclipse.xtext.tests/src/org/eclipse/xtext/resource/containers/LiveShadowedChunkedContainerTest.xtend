/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.containers

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.LiveContainerTestLanguageInjectorProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.resource.liveContainerTestLanguage.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IWorkspaceConfig
import org.eclipse.xtext.workspace.ProjectConfigAdapter
import org.eclipse.xtext.workspace.WorkspaceConfig
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.resource.liveContainerTestLanguage.LiveContainerTestLanguagePackage.Literals.*
import static org.junit.Assert.*

import static extension org.eclipse.xtext.util.UriUtil.*

/**
 * @author koehnlein - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(LiveContainerTestLanguageInjectorProvider)
class LiveShadowedChunkedContainerTest {

	@Inject extension ParseHelper<Model>
	@Inject Provider<XtextResourceSet> resourceSetProvider
	@Inject IResourceDescription.Manager resourceDescriptionManager
	@Inject Provider<LiveShadowedChunkedResourceDescriptions> provider
	
	WorkspaceConfig workspaceConfig
	ProjectConfig fooProject
	ProjectConfig barProject
	
	URI fooURI
	URI barURI
	
	XtextResourceSet rs1
	
	LiveShadowedChunkedContainer fooContainer
	LiveShadowedChunkedContainer barContainer
	
	LiveShadowedChunkedResourceDescriptions liveShadowedChunkedResourceDescriptions
	
	@Before
	def void setUp() {
		workspaceConfig = new WorkspaceConfig()
		fooProject = new ProjectConfig('foo', workspaceConfig)
		barProject = new ProjectConfig('bar', workspaceConfig)
		val rs0 = resourceSetProvider.get
		fooURI = fooProject.sourceFolders.head.path.trimSegments(1).appendSegment('foo.livecontainertestlanguage')
		barURI = barProject.sourceFolders.head.path.trimSegments(1).appendSegment('bar.livecontainertestlanguage')
		val chunks = #{
			'foo' -> createResourceDescriptionData('foo'.parse(fooURI, rs0).eResource),
			'bar' -> createResourceDescriptionData('bar'.parse(barURI, rs0).eResource)
		}
		rs1 = resourceSetProvider.get
		new ChunkedResourceDescriptions(chunks, rs1)
		ProjectConfigAdapter.install(rs1, fooProject)
		liveShadowedChunkedResourceDescriptions = provider.get
		liveShadowedChunkedResourceDescriptions.context = rs1
		fooContainer = new LiveShadowedChunkedContainer(liveShadowedChunkedResourceDescriptions, 'foo')
		barContainer = new LiveShadowedChunkedContainer(liveShadowedChunkedResourceDescriptions, 'bar')
	}
	
	@Test
	def testRenameElement() {
		'fooChange'.parse(fooURI, rs1)
		assertEquals('fooChange', fooContainer.exportedObjects.map[qualifiedName.toString].join(','))
		assertEquals('fooChange', fooContainer.getExportedObjects(MODEL, QualifiedName.create('fooChange'), false).map[qualifiedName.toString].join(','))
		assertEquals('fooChange', fooContainer.getExportedObjectsByType(MODEL).map[qualifiedName.toString].join(','))
		assertEquals(1, fooContainer.resourceDescriptions.size)
		assertEquals(1, fooContainer.resourceDescriptionCount)
		assertTrue(fooContainer.hasResourceDescription(fooURI))
		assertFalse(fooContainer.hasResourceDescription(barURI))
		assertEquals(fooURI, fooContainer.getResourceDescription(fooURI).URI)
		
		assertEquals('bar', barContainer.exportedObjects.map[qualifiedName.toString].join(','))
		assertEquals('bar', barContainer.getExportedObjects(MODEL, QualifiedName.create('bar'), false).map[qualifiedName.toString].join(','))
		assertEquals('bar', barContainer.getExportedObjectsByType(MODEL).map[qualifiedName.toString].join(','))
		assertEquals(1, barContainer.resourceDescriptions.size)
		assertEquals(1, barContainer.resourceDescriptionCount)
		assertTrue(barContainer.hasResourceDescription(barURI))
		assertFalse(barContainer.hasResourceDescription(fooURI))
		assertEquals(barURI, barContainer.getResourceDescription(barURI).URI)
		assertGlobalDescriptionsAreUnaffected()
	}
	
	@Test 
	def testAddRemoveResource() {
		val bazResource = 'baz'.parse(fooProject.sourceFolders.head.path.trimSegments(1).appendSegment('baz.livecontainertestlanguage'), rs1).eResource
		assertEquals(2, fooContainer.resourceDescriptions.size)
		assertEquals(2, fooContainer.resourceDescriptionCount)
		assertEquals('baz,foo', fooContainer.exportedObjects.map[qualifiedName.toString].sort.join(','))
		assertEquals(1, barContainer.resourceDescriptions.size)
		assertEquals(1, barContainer.resourceDescriptionCount)
		assertGlobalDescriptionsAreUnaffected()
		rs1.resources.remove(bazResource)
		assertEquals(1, fooContainer.resourceDescriptions.size)
		assertEquals(1, fooContainer.resourceDescriptionCount)
		assertEquals('foo', fooContainer.exportedObjects.map[qualifiedName.toString].sort.join(','))
		assertEquals(1, barContainer.resourceDescriptions.size)
		assertEquals(1, barContainer.resourceDescriptionCount)
		assertGlobalDescriptionsAreUnaffected()
	}
	
	@Test 
	def testMoveResourceBetweenContainers() {
		val oldURI = fooProject.sourceFolders.head.path.trimSegments(1).appendSegment('baz.livecontainertestlanguage')
		val bazResource = 'baz'.parse(oldURI, rs1).eResource
		assertEquals(2, fooContainer.resourceDescriptions.size)
		assertEquals(2, fooContainer.resourceDescriptionCount)
		assertEquals('baz,foo', fooContainer.exportedObjects.map[qualifiedName.toString].sort.join(','))
		assertEquals(oldURI, fooContainer.getExportedObjects(MODEL, QualifiedName.create('baz'), false).head.EObjectURI.trimFragment)
		assertEquals(1, barContainer.resourceDescriptions.size)
		assertEquals(1, barContainer.resourceDescriptionCount)
		assertGlobalDescriptionsAreUnaffected()
		val newURI = URI.createURI(bazResource.URI.toString().replace('/foo/', '/bar/'))
		bazResource.URI = newURI
		assertEquals(1, fooContainer.resourceDescriptions.size)
		assertEquals(1, fooContainer.resourceDescriptionCount)
		assertEquals('foo', fooContainer.exportedObjects.map[qualifiedName.toString].sort.join(','))
		assertEquals(1, fooContainer.resourceDescriptions.size)
		assertEquals(1, fooContainer.resourceDescriptionCount)
		assertEquals('bar,baz', barContainer.exportedObjects.map[qualifiedName.toString].sort.join(','))
		assertEquals(2, barContainer.resourceDescriptions.size)
		assertEquals(2, barContainer.resourceDescriptionCount)
		assertEquals(newURI, barContainer.getExportedObjects(MODEL, QualifiedName.create('baz'), false).head.EObjectURI.trimFragment)
		assertGlobalDescriptionsAreUnaffected()
	}
	
	@Test 
	def testAddToNewContainer() {
		val bazProject = new ProjectConfig('baz', workspaceConfig)
		val newURI = bazProject.sourceFolders.head.path.trimSegments(1).appendSegment('baz.livecontainertestlanguage')
		'baz'.parse(newURI, rs1)
		val bazContainer = new LiveShadowedChunkedContainer(liveShadowedChunkedResourceDescriptions, 'baz')
		assertEquals(1, fooContainer.resourceDescriptions.size)
		assertEquals(1, fooContainer.resourceDescriptionCount)
		assertEquals('foo', fooContainer.exportedObjects.map[qualifiedName.toString].sort.join(','))
		assertEquals(1, barContainer.resourceDescriptions.size)
		assertEquals(1, barContainer.resourceDescriptionCount)
		assertEquals('bar', barContainer.exportedObjects.map[qualifiedName.toString].sort.join(','))
		assertEquals(1, bazContainer.resourceDescriptions.size)
		assertEquals(1, bazContainer.resourceDescriptionCount)
		assertEquals('baz', bazContainer.exportedObjects.map[qualifiedName.toString].sort.join(','))
		assertEquals(newURI, bazContainer.getExportedObjects(MODEL, QualifiedName.create('baz'), false).head.EObjectURI.trimFragment)
		assertGlobalDescriptionsAreUnaffected()
	}
	
	@Test
	def testDeleteElement() {
		'foo'.parse(fooURI, rs1).eResource.contents.clear()
		assertEquals('', fooContainer.exportedObjects.map[qualifiedName.toString].join(','))
		assertEquals(1, fooContainer.resourceDescriptions.size)
		assertEquals(1, fooContainer.resourceDescriptionCount)
		assertEquals(0, fooContainer.exportedObjects.size)
		assertEquals(1, barContainer.resourceDescriptions.size)
		assertEquals(1, barContainer.resourceDescriptionCount)
		assertGlobalDescriptionsAreUnaffected()
	}
	
	private def void assertGlobalDescriptionsAreUnaffected() {
		assertEquals('foo', (liveShadowedChunkedResourceDescriptions.globalDescriptions as ChunkedResourceDescriptions).getContainer('foo').getExportedObjects.map[qualifiedName.toString].join(','))
		assertEquals('bar', (liveShadowedChunkedResourceDescriptions.globalDescriptions as ChunkedResourceDescriptions).getContainer('bar').getExportedObjects.map[qualifiedName.toString].join(','))
	}
	
	
	private def createResourceDescriptionData(Resource... resources) {
		new ResourceDescriptionsData(resources.map[
			resourceDescriptionManager.getResourceDescription(it)
		])
	}
}

@Accessors(PUBLIC_GETTER)
class ProjectConfig implements IProjectConfig {
	
	URI path
	Set<SourceFolder> sourceFolders = newHashSet
	String name 
	IWorkspaceConfig workspaceConfig
	
	new(String name, WorkspaceConfig workspaceConfig) {
		this.name = name
		
		this.path = URI.createURI(new File(name).absoluteFile.toURI.toString).appendSegment('')
		sourceFolders.add(new SourceFolder(path.trimSegments(1).appendSegment('src').appendSegment('')))
		this.workspaceConfig = workspaceConfig
		workspaceConfig.addProject(this)
	}

	override findSourceFolderContaining(URI member) {
		sourceFolders.findFirst[path.isPrefixOf(member)]
	}
}


@FinalFieldsConstructor
@Accessors(PUBLIC_GETTER)
class SourceFolder implements ISourceFolder {
	
	val URI path
	
	override getName() {
		'src'
	}
}
