/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.util.IFileSystemScanner;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Scopes;

/**
 * Tests default methods ISourceFolder#contains(URI) and
 * ISourceFolder#getAllResources(IFileSystemScanner)
 */
public class SourceFolderDefaultImplTest extends AbstractTestLangLanguageServerTest {
	@Inject
	private WorkspaceManager workspaceManager;

	@Inject
	private IFileSystemScanner scanner;

	/**
	 * Asserts that the default implementation returns all files in the
	 * configured source folder
	 */
	@Test
	public void testDefaultSourceFolderImplementation() {
		this.writeFile("sample.testlang", "MyContent");
		this.initialize();
		ProjectManager projectManager = this.workspaceManager.getProjectManager("");
		Set<? extends ISourceFolder> sourceFolders = projectManager.getProjectConfig().getSourceFolders();
		Assert.assertTrue(sourceFolders.size() == 1);
		ISourceFolder sourceFolder = sourceFolders.iterator().next();
		List<URI> allResources = sourceFolder.getAllResources(this.scanner);
		Assert.assertTrue(
				allResources.stream().anyMatch((URI uri) -> uri.toString().endsWith("test-data/test-project/")));
		Assert.assertTrue(allResources.stream()
				.anyMatch((URI uri) -> uri.toString().endsWith("test-data/test-project/sample.testlang")));
		Assert.assertEquals(allResources.size(), 2);
	}

	@Override
	protected com.google.inject.Module getServerModule() {
		com.google.inject.Module defaultModule = super.getServerModule();
		com.google.inject.Module customModule = new AbstractModule() {
			@Override
			protected void configure() {
				bind(WorkspaceManager.class).in(Scopes.SINGLETON);
			}
		};
		return Modules2.mixin(defaultModule, customModule);
	}
}
