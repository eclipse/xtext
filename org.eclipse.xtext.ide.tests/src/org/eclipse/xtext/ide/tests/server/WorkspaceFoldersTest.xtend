/*******************************************************************************
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
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
import java.io.File
import java.io.FileWriter
import java.util.concurrent.CompletableFuture
import org.eclipse.lsp4j.DidChangeWorkspaceFoldersParams
import org.eclipse.lsp4j.WorkspaceFolder
import org.eclipse.lsp4j.WorkspaceFoldersChangeEvent
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.util.Modules2
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.junit.Assert.assertEquals

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class WorkspaceFoldersTest extends AbstractTestLangLanguageServerTest {

	@Inject extension UriExtensions

	@Inject WorkspaceManager workspaceManager

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder() 

	@Test
	def void testInitialize() {
		val rootFolder1 = temporaryFolder.newFolder('root1') 
		val rootFolder2 = temporaryFolder.newFolder('root2') 
		writeFile(rootFolder1, "one.testlang", '''
			type Foo {
				Bar bar
			}
		''')
		val twoUri = writeFile(rootFolder2, "two.testlang", '''
			type Bar {
				Foo foo
			}
		''')
		initialize[ 
			workspaceFolders = #[
				new WorkspaceFolder(rootFolder1.toURI.toUriString, 'root1'),
				new WorkspaceFolder(rootFolder2.toURI.toUriString, 'root2')
			]
		]
		assertEquals(2, diagnostics.size)
		assertEquals(1, diagnostics.get(twoUri).size)
		withBuild [
			languageServer.didChangeWorkspaceFolders(new DidChangeWorkspaceFoldersParams => [
				event = new WorkspaceFoldersChangeEvent => [
					removed = #[
						new WorkspaceFolder(rootFolder2.toURI.toUriString, 'root2')
					]
				]
			])
		]	
		assertEquals(0, diagnostics.get(twoUri).size)
		withBuild [
			languageServer.didChangeWorkspaceFolders(new DidChangeWorkspaceFoldersParams => [
				event = new WorkspaceFoldersChangeEvent => [
					added = #[
						new WorkspaceFolder(rootFolder2.toURI.toUriString, 'root2')
					]
				]
			])
		]	
		assertEquals(1, diagnostics.get(twoUri).size)
	}

	protected def void withBuild(()=>void lambda) {
		val future = new CompletableFuture<Void>()
		workspaceManager.addBuildListener[  
			workspaceManager.removeBuildListener(self)
			future.complete(null)			
		]
		lambda.apply
		future.get
	}

	def String writeFile(File root, String path, CharSequence contents) {
		val file = new File(root, path)
		file.parentFile.mkdirs
		file.createNewFile

		val writer = new FileWriter(file)
		writer.write(contents.toString)
		writer.close

		return file.toURI.normalize.toUriString
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