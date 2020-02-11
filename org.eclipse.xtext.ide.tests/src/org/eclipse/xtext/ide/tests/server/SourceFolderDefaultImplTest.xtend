/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.Module
import com.google.inject.Scopes
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.util.IFileSystemScanner
import org.eclipse.xtext.util.Modules2
import org.junit.Test

import static org.junit.Assert.*

/**
 * Tests default methods ISourceFolder#contains(URI) and ISourceFolder#getAllResources(IFileSystemScanner)
 */
class SourceFolderDefaultImplTest extends AbstractTestLangLanguageServerTest {
	@Inject
	WorkspaceManager workspaceManager;
	@Inject
	IFileSystemScanner scanner;
	
	/** Asserts that the default implementation returns all files in the configured source folder */
	@Test
	def void testDefaultSourceFolderImplementation() {
		'sample.testlang'.writeFile("MyContent")
		initialize
		
		val projectManager = workspaceManager.getProjectManager("")
		val sourceFolders = projectManager.projectConfig.sourceFolders
		
		assertTrue(sourceFolders.size == 1);
		val sourceFolder = sourceFolders.get(0);
		val allResources = sourceFolder.getAllResources(scanner);

		assertTrue(allResources.exists[uri|uri.toString.endsWith("test-data/test-project/")]);
		assertTrue(allResources.exists[uri|uri.toString.endsWith("test-data/test-project/sample.testlang")]);
		assertEquals(allResources.size, 2);
	}

	
	override protected getServerModule() {
		val defaultModule = super.getServerModule()
		val Module customModule = new AbstractModule() {
			
			override protected configure() {
				bind(WorkspaceManager).in(Scopes.SINGLETON);
			}
		}
		
		return Modules2.mixin(defaultModule, customModule)
	}
	
}
