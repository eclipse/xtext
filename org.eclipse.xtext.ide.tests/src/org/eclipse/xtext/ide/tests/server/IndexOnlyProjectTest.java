/**
 * Copyright (c) 2019, 2020 NumberFour AG (http://www.enfore.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.io.File;
import java.util.Set;

import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.xtext.ide.server.IMultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.MultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.testing.ReferenceTestConfiguration;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Checks functionality of method IProjectConfig#isIndexOnly()
 * 
 * @author Marcus Mews - Initial contribution and API
 */
public class IndexOnlyProjectTest extends AbstractTestLangLanguageServerTest {
	@Override
	public com.google.inject.Module getServerModule() {
		return Modules2.mixin(new ServerModule(), new Module() {

			@Override
			public void configure(Binder binder) {
				binder.bind(IMultiRootWorkspaceConfigFactory.class).toInstance(new MultiRootWorkspaceConfigFactory() {
					@Override
					public void addProjectsForWorkspaceFolder(WorkspaceConfig workspaceConfig,
							WorkspaceFolder workspaceFolder, Set<String> existingNames) {
						String uri = null;
						if (workspaceFolder != null) {
							uri = workspaceFolder.getUri();
							if (uri != null) {
								FileProjectConfig project = new FileProjectConfig(
										getUriExtensions().toUri(uri),
										getUniqueProjectName(workspaceFolder.getName(), existingNames)) {
									@Override
									public boolean isIndexOnly() {
										return true;
									}
								};
								project.addSourceFolder(".");
								workspaceConfig.addProject(project);
							}
						}
					}
				});

			}
		});
	}

	/**
	 * Shows that the resource is indexed
	 */
	@Test
	public void testIndexByUsingReferences() {
		testReferences((ReferenceTestConfiguration cfg) -> {
			String model = "type Foo {}\n" + "type Bar {\n" + "	Foo foo\n" + "}\n";
			cfg.setModel(model);
			cfg.setColumn("type F".length());
			cfg.setExpectedReferences("MyModel.testlang [[2, 1] .. [2, 4]]\n");
		});
	}

	/**
	 * Shows that the resource is not validated during initial build
	 */
	@Test
	public void testInitializeBuildNoValidation() {
		writeFile("MyType1.testlang", "type Test { NonExisting foo }");
		initialize();
		Assert.assertTrue(Joiner.on(",").join(getDiagnostics().entrySet()), getDiagnostics().isEmpty());
	}

	/**
	 * Shows that the error-free resource is not generated during initial build
	 */
	@Test
	public void testInitializeBuildNoGeneration() {
		writeFile("MyType1.testlang", "type TestType { int foo }");
		initialize();
		File outputFile = new File(root, "src-gen/TestType.java");
		Assert.assertFalse(Joiner.on(",").join(getDiagnostics().entrySet()), outputFile.isFile());
	}

	/**
	 * Shows that the resource is not validated during incremental build
	 */
	@Test
	public void testIncrementalBuildNoValidation() {
		writeFile("MyType1.testlang", "type Test { NonExisting foo }");
		initialize();
		Assert.assertTrue(Joiner.on(",").join(getDiagnostics().entrySet()), getDiagnostics().isEmpty());
		String path = writeFile("MyType2.testlang", "type NonExisting {}");
		languageServer.getWorkspaceService().didChangeWatchedFiles(
				new DidChangeWatchedFilesParams(Lists.newArrayList(new FileEvent(path, FileChangeType.Created))));
		Assert.assertTrue(Joiner.on(",").join(getDiagnostics().entrySet()), getDiagnostics().isEmpty());
	}
}
