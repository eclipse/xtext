/*******************************************************************************
 * Copyright (c) 2019 NumberFour AG (http://www.enfore.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.FileChangeType
import org.eclipse.lsp4j.FileEvent
import org.junit.Test

import static org.junit.Assert.*
import com.google.inject.Module
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory
import org.eclipse.xtext.ide.server.ProjectWorkspaceConfigFactory
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.workspace.WorkspaceConfig
import org.eclipse.xtext.workspace.FileProjectConfig
import java.io.File

/**
 * Checks functionality of method IProjectConfig#isIndexOnly()
 * 
 * @author Marcus Mews - Initial contribution and API
 */
class IndexOnlyProjectTest extends AbstractTestLangLanguageServerTest {

	override Module getServerModule() {
		Modules2.mixin(new ServerModule, [
			bind(IWorkspaceConfigFactory).toInstance(new ProjectWorkspaceConfigFactory() {

				override findProjects(WorkspaceConfig workspaceConfig, URI location) {
					if (location !== null) {
						val FileProjectConfig project = new FileProjectConfig(location, workspaceConfig) {
							override boolean isIndexOnly() {
								return true;
							}
						};

						project.addSourceFolder(".");
						workspaceConfig.addProject(project);
					}
				}
			})
		])
	}

	/** Shows that the resource is indexed */
	@Test
	def void testIndexByUsingReferences() {
		testReferences[
			model = '''
				type Foo {}
				type Bar {
					Foo foo
				}
			'''
			column = 'type F'.length
			expectedReferences = '''
				MyModel.testlang [[2, 1] .. [2, 4]]
			'''
		]
	}

	/** Shows that the resource is not validated during initial build */
	@Test
	def void testInitializeBuildNoValidation() {
		'MyType1.testlang'.writeFile( '''
			type Test {
			    NonExisting foo
			}
		''')
		initialize
		assertTrue(diagnostics.entrySet.join(','), diagnostics.empty)
	}

	/** Shows that the error-free resource is not generated during initial build */
	@Test
	def void testInitializeBuildNoGeneration() {
		'MyType1.testlang'.writeFile( '''
			type TestType {
			    int foo
			}
		''')
		initialize

		val outputFile = new File(root, "src-gen/TestType.java");
		assertFalse(diagnostics.entrySet.join(','), outputFile.isFile)
	}

	/** Shows that the resource is not validated during incremental build */
	@Test
	def void testIncrementalBuildNoValidation() {
		'MyType1.testlang'.writeFile( '''
			type Test {
			    NonExisting foo
			}
		''')
		initialize
		assertTrue(diagnostics.entrySet.join(','), diagnostics.empty)

		val path = 'MyType2.testlang'.writeFile('''
			type NonExisting {
			}
		''')

		languageServer.getWorkspaceService.didChangeWatchedFiles(
			new DidChangeWatchedFilesParams(#[new FileEvent(path, FileChangeType.Created)])
		)
		assertTrue(diagnostics.entrySet.join(','), diagnostics.empty)
	}

}
