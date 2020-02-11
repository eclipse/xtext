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
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory
import org.eclipse.xtext.ide.server.ProjectWorkspaceConfigFactory
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.util.IFileSystemScanner
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.workspace.FileProjectConfig
import org.eclipse.xtext.workspace.FileSourceFolder
import org.eclipse.xtext.workspace.WorkspaceConfig
import org.junit.Test

import static org.junit.Assert.*

/**
 * Tests customized version of default methods ISourceFolder#contains(URI) and ISourceFolder#getAllResources(IFileSystemScanner)
 */
class SourceFolderCustomImplTest extends AbstractTestLangLanguageServerTest {
	@Inject
	WorkspaceManager workspaceManager;
	@Inject
	IFileSystemScanner scanner;

	
	/** Asserts that the custom implementation returns not all files of the configured source folder */
	@Test
	def void testCustomSourceFolderImplementation() {
		'sample.testlang'.writeFile("MyContent")
		initialize
		
		val projectManager = workspaceManager.getProjectManager("")
		val sourceFolders = projectManager.projectConfig.sourceFolders
		
		assertTrue(sourceFolders.size == 1);
		val sourceFolder = sourceFolders.get(0);
		val allResources = sourceFolder.getAllResources(scanner);

		assertTrue(allResources.exists[uri|uri.toString.endsWith("test-data/test-project/")]);
		assertFalse(allResources.exists[uri|uri.toString.endsWith("test-data/test-project/sample.testlang")]);
		assertEquals(allResources.size, 1);
	}

	static class CustomWorkspaceConfigFactory extends ProjectWorkspaceConfigFactory {

		override findProjects(WorkspaceConfig workspaceConfig, URI uri) {
			if (uri !== null) {
				val project = new CustomFileProjectConfig(uri, workspaceConfig)
				project.addSourceFolder('.')
				workspaceConfig.addProject(project)
			}
		}
	}

	static class CustomFileProjectConfig extends FileProjectConfig {
	
		new(URI uri, WorkspaceConfig workspaceConfig) {
			super(uri, workspaceConfig)
		}
	
		override FileSourceFolder addSourceFolder(String relativePath) {
			val sourceFolder = new CustomFileSourceFolder(this, relativePath)
			sourceFolders += sourceFolder
			sourceFolder
		}
	}

	static class CustomFileSourceFolder extends FileSourceFolder {
		
		new(FileProjectConfig parent, String name) {
			super(parent, name)
		}
		
		def boolean filterTheFile(URI uri) {
			return uri.toFileString.endsWith("sample.testlang");
		}
		
		override contains(URI uri) {
			if (filterTheFile(uri)) {
				return false;
			}
			super.contains(uri)
		}
		
		override getAllResources(IFileSystemScanner scanner) {
			val allResources = super.getAllResources(scanner);
			allResources.removeIf(uri| filterTheFile(uri));
			return allResources;
		}
	}

	
	override protected getServerModule() {
		val defaultModule = super.getServerModule()
		val Module customModule = new AbstractModule() {
			
			override protected configure() {
				bind(IWorkspaceConfigFactory).to(CustomWorkspaceConfigFactory)
				bind(WorkspaceManager).in(Scopes.SINGLETON);
			}
			
		}
		
		return Modules2.mixin(defaultModule, customModule)
	}
}
