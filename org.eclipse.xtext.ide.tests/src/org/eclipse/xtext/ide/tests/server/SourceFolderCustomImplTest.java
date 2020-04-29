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
import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.xtext.ide.server.IMultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.MultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.util.IFileSystemScanner;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.FileSourceFolder;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.WorkspaceConfig;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Scopes;

/**
 * Tests customized version of default methods ISourceFolder#contains(URI) and
 * ISourceFolder#getAllResources(IFileSystemScanner)
 */
public class SourceFolderCustomImplTest extends AbstractTestLangLanguageServerTest {
	public static class CustomWorkspaceConfigFactory extends MultiRootWorkspaceConfigFactory {
		@Override
		public void addProjectsForWorkspaceFolder(WorkspaceConfig workspaceConfig, WorkspaceFolder workspaceFolder,
				Set<String> existingNames) {
			if (workspaceFolder != null) {
				if (workspaceFolder.getUri() != null) {
					SourceFolderCustomImplTest.CustomFileProjectConfig project = new SourceFolderCustomImplTest.CustomFileProjectConfig(
							getUriExtensions().toUri(workspaceFolder.getUri()), workspaceConfig);
					project.addSourceFolder(".");
					workspaceConfig.addProject(project);
				}
			}
		}
	}

	public static class CustomFileProjectConfig extends FileProjectConfig {
		public CustomFileProjectConfig(URI uri, WorkspaceConfig workspaceConfig) {
			super(uri, workspaceConfig);
		}

		@Override
		public FileSourceFolder addSourceFolder(String relativePath) {
			SourceFolderCustomImplTest.CustomFileSourceFolder sourceFolder = new SourceFolderCustomImplTest.CustomFileSourceFolder(
					this, relativePath);
			getSourceFolders().add(sourceFolder);
			return sourceFolder;
		}
	}

	public static class CustomFileSourceFolder extends FileSourceFolder {
		public CustomFileSourceFolder(FileProjectConfig parent, String name) {
			super(parent, name);
		}

		public boolean filterTheFile(URI uri) {
			return uri.toFileString().endsWith("sample.testlang");
		}

		@Override
		public boolean contains(URI uri) {
			if (filterTheFile(uri)) {
				return false;
			}
			return super.contains(uri);
		}

		@Override
		public List<URI> getAllResources(IFileSystemScanner scanner) {
			List<URI> allResources = super.getAllResources(scanner);
			allResources.removeIf((URI uri) -> filterTheFile(uri));
			return allResources;
		}
	}

	@Inject
	private WorkspaceManager workspaceManager;

	@Inject
	private IFileSystemScanner scanner;

	/**
	 * Asserts that the custom implementation returns not all files of the
	 * configured source folder
	 */
	@Test
	public void testCustomSourceFolderImplementation() {
		writeFile("sample.testlang", "MyContent");
		initialize();
		ProjectManager projectManager = workspaceManager.getProjectManager("");
		Set<? extends ISourceFolder> sourceFolders = projectManager.getProjectConfig().getSourceFolders();
		Assert.assertTrue(sourceFolders.size() == 1);
		ISourceFolder sourceFolder = sourceFolders.iterator().next();
		List<URI> allResources = sourceFolder.getAllResources(scanner);
		Assert.assertTrue(
				allResources.stream().anyMatch((URI uri) -> uri.toString().endsWith("test-data/test-project/")));
		Assert.assertFalse(allResources.stream()
				.anyMatch((URI uri) -> uri.toString().endsWith("test-data/test-project/sample.testlang")));
		Assert.assertEquals(allResources.size(), 1);
	}

	@Override
	protected com.google.inject.Module getServerModule() {
		com.google.inject.Module defaultModule = super.getServerModule();
		com.google.inject.Module customModule = new AbstractModule() {
			@Override
			protected void configure() {
				bind(IMultiRootWorkspaceConfigFactory.class)
						.to(SourceFolderCustomImplTest.CustomWorkspaceConfigFactory.class);
				bind(WorkspaceManager.class).in(Scopes.SINGLETON);
			}
		};
		return Modules2.mixin(defaultModule, customModule);
	}
}
