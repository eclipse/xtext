/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.macros

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.List
import java.util.Set
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.resources.IWorkspace
import org.eclipse.emf.common.util.URI
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.xtend.ide.builder.UIResourceChangeRegistry
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.eclipse.xtext.util.StringInputStream
import org.junit.After
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.Executors
import java.security.SecureRandom
import java.util.concurrent.ExecutionException

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class UIResourceChangeRegistryTest extends AbstractXtendUITestCase {
	
	@Inject TestUiResourceChangeRegistry resourceChangeRegistry
	
	@Inject WorkbenchTestHelper workbenchTestHelper;

	@Rule public StopwatchRule rule = new StopwatchRule(true)
	
	@After override void tearDown() {
		workbenchTestHelper.project.delete(true, null)
	}
	
	val URI uri = URI.createURI("synthetic://testing/uri")
	
	@Test def void testConcurrentDiscard() throws Exception {
		for (it : 1 .. 10000) { 
			resourceChangeRegistry.registerCreateOrModify('/foo', uri.appendSegment(it.toString))
		}
		
		val Runnable r = [
			val random = new SecureRandom(#[1 as byte])
			for (it : 1 .. 1000) {
				val removedURI = uri.appendSegment(random.nextInt(10000).toString)
				resourceChangeRegistry.discardCreateOrModifyInformation(removedURI)
			}
		]  
		val executorService = Executors.newCachedThreadPool
		try {
			val future1 = executorService.submit(r)
			val future2 = executorService.submit(r)
			val future3 = executorService.submit(r)
			val future4 = executorService.submit(r)
			future1.get
			future2.get
			future3.get
			future4.get
		} catch(ExecutionException e) {
			throw e.cause
		} finally {
			executorService.shutdown()
		}
	}
	
	@Test def void testSerialization() {
		resourceChangeRegistry.registerExists('/foo', uri)
		resourceChangeRegistry.registerExists('/foo/bar', uri)
		resourceChangeRegistry.registerExists('/foo/bar', uri.appendFragment('fragment'))
		resourceChangeRegistry.registerGetCharset('/foo', uri)
		resourceChangeRegistry.registerGetCharset('/foo/bar', uri)
		resourceChangeRegistry.registerGetCharset('/foo/bar', uri.appendFragment('fragment'))
		resourceChangeRegistry.registerGetChildren('/foo', uri)
		resourceChangeRegistry.registerGetChildren('/foo/bar', uri)
		resourceChangeRegistry.registerGetChildren('/foo/bar', uri.appendFragment('fragment'))
		resourceChangeRegistry.registerGetContents('/foo', uri)
		resourceChangeRegistry.registerGetContents('/foo/bar', uri)
		resourceChangeRegistry.registerGetContents('/foo/bar', uri.appendFragment('fragment'))
		
		val out = new ByteArrayOutputStream()
		resourceChangeRegistry.writeState(out);
		val copy = new TestUiResourceChangeRegistry()
		copy.readState(new ByteArrayInputStream(out.toByteArray));
		
		assertEquals(resourceChangeRegistry.existsListeners, copy.existsListeners)
		assertEquals(resourceChangeRegistry.charsetListeners, copy.charsetListeners)
		assertEquals(resourceChangeRegistry.contentsListeners, copy.contentsListeners)
		assertEquals(resourceChangeRegistry.childrenListeners, copy.childrenListeners)
	}
	
	@Test def void testFolderExists() {
		val folderPath = "/foo/bar"
		resourceChangeRegistry.registerExists(folderPath, uri)
		assertTrue(resourceChangeRegistry.existsListeners.containsKey(folderPath))
		val project = WorkbenchTestHelper.createPluginProject("foo")
		assertTrue(resourceChangeRegistry.existsListeners.containsKey(folderPath))
		val folder = project.getFolder("bar")
		assertTrue(resourceChangeRegistry.existsListeners.containsKey(folderPath))
		modifyWorkspace [
			folder.create(true, true, null)
		]
		assertFalse(resourceChangeRegistry.existsListeners.containsKey(folderPath))
		assertEquals(1, resourceChangeRegistry.queuedURIs.size)
	}
	
	@Test def void testFolderChildren() {
		val project = WorkbenchTestHelper.createPluginProject("foo")
		val folderPath = "/foo/bar"
		resourceChangeRegistry.registerGetChildren(folderPath, uri)
		assertTrue(resourceChangeRegistry.childrenListeners.containsKey(folderPath))
		val folder = project.getFolder("bar")
		modifyWorkspace [
			folder.create(true, true, null)
		]
		assertFalse(resourceChangeRegistry.childrenListeners.containsKey(folderPath))
		assertEquals(1, resourceChangeRegistry.queuedURIs.size)
	}
	
	@Test def void testFolderChildren_AddedChild() {
		val project = WorkbenchTestHelper.createPluginProject("foo")
		val folder = project.getFolder("bar")
		modifyWorkspace [
			folder.create(true, true, null)
		]
		val folderPath = "/foo/bar"
		resourceChangeRegistry.registerGetChildren(folderPath, uri)
		modifyWorkspace [
			folder.getFile("test.txt").create(new StringInputStream("Hello World"), true, null)
		]
		assertFalse(resourceChangeRegistry.childrenListeners.containsKey(folderPath))
		assertEquals(1, resourceChangeRegistry.queuedURIs.size)
		
		// change contents of file -> no affection
		resourceChangeRegistry.registerGetChildren(folderPath, uri)
		modifyWorkspace [
			folder.getFile("test.txt").setContents(new StringInputStream("Hello Xtend"), true, true , null)
		]
		assertTrue(resourceChangeRegistry.childrenListeners.containsKey(folderPath))
		assertEquals(1, resourceChangeRegistry.queuedURIs.size)
		
		// delete file -> affection
		modifyWorkspace [
			folder.getFile("test.txt").delete(true, true, null)
		]
		assertFalse(resourceChangeRegistry.childrenListeners.containsKey(folderPath))
		assertEquals(2, resourceChangeRegistry.queuedURIs.size)
	}
	
	@Test def void testFileContents_changed() {
		val project = WorkbenchTestHelper.createPluginProject("foo")
		val folder = project.getFolder("bar")
		modifyWorkspace [
			folder.create(true, true, null)
			folder.getFile("test.txt").create(new StringInputStream("Hello"), true, null)
		]
		val folderPath = "/foo/bar/test.txt"
		resourceChangeRegistry.registerGetContents(folderPath, uri)
		// change contents of file -> affection
		modifyWorkspace [
			folder.getFile("test.txt").setContents(new StringInputStream("Hello Xtend"), true, true , null)
		]
		assertFalse(resourceChangeRegistry.contentsListeners.containsKey(folderPath))
		assertEquals(1, resourceChangeRegistry.queuedURIs.size)
		
		resourceChangeRegistry.registerGetContents(folderPath, uri)
		// change charset of file -> affection
		modifyWorkspace [
			folder.getFile("test.txt").setCharset("UTF-8", null)
		]
		assertFalse(resourceChangeRegistry.contentsListeners.containsKey(folderPath))
		assertEquals(2, resourceChangeRegistry.queuedURIs.size)
		
		resourceChangeRegistry.registerGetContents(folderPath, uri)
		// delete file -> affection
		modifyWorkspace [
			folder.getFile("test.txt").delete(true, true, null)
		]
		assertFalse(resourceChangeRegistry.contentsListeners.containsKey(folderPath))
		assertEquals(3, resourceChangeRegistry.queuedURIs.size)
	}
	
	def void modifyWorkspace(WorkspaceModifyOperation op) {
		resourceChangeRegistry.waitForEvent = true;
		op.run(null);
		while (resourceChangeRegistry.waitForEvent) {
			Thread.sleep(100)
		}
	}
	
	static class TestUiResourceChangeRegistry extends UIResourceChangeRegistry {
		
		public volatile boolean waitForEvent = false;
		
		public List<URI> queuedURIs = newArrayList()
		
		override queueURIs(Set<URI> interestedFiles) {
			queuedURIs += interestedFiles
		}
		
		@Inject override init(IWorkspace workspace) {
			workspace.addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE)
		}
		
		override resourceChanged(IResourceChangeEvent event) {
//			println(event.delta.toReadableString)
			super.resourceChanged(event)
			waitForEvent = false
		}
		
		def static String toReadableString(IResourceDelta delta) '''
			«delta.fullPath» «
			switch delta.kind {
				case IResourceDelta.ADDED : 'ADDED'
				case IResourceDelta.REMOVED : 'REMOVED'
				case IResourceDelta.CHANGED : 'CHANGED'
			}» «#[
				 IResourceDelta.CONTENT -> 'CONTENT',
				 IResourceDelta.DERIVED_CHANGED -> 'DERIVED_CHANGED',
				 IResourceDelta.DESCRIPTION -> 'DESCRIPTION',
				 IResourceDelta.ENCODING -> 'ENCODING',
				 IResourceDelta.LOCAL_CHANGED -> 'LOCAL_CHANGED',
				 IResourceDelta.OPEN -> 'OPEN',
				 IResourceDelta.MOVED_TO -> 'MOVED_TO',
				 IResourceDelta.MOVED_FROM -> 'MOVED_FROM',
				 IResourceDelta.COPIED_FROM -> 'COPIED_FROM',
				 IResourceDelta.TYPE -> 'TYPE',
				 IResourceDelta.SYNC -> 'SYNC',
				 IResourceDelta.MARKERS -> 'MARKERS',
				 IResourceDelta.REPLACED -> 'REPLACED'
			].map [
				if (delta.flags.bitwiseAnd(key) != 0) value else null
			].filterNull.join(',')» {
				«FOR child : delta.affectedChildren»
					«child.toReadableString»
				«ENDFOR»
			}
		'''
	}
	

}