/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import java.util.ArrayList
import java.util.List
import java.util.function.Consumer
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.ExecuteCommandCapabilities
import org.eclipse.lsp4j.ExecuteCommandParams
import org.eclipse.lsp4j.WorkspaceClientCapabilities
import org.eclipse.xtend.lib.annotations.Accessors
import static org.junit.Assert.*
import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class CommandServiceTest extends AbstractTestLangLanguageServerTest {
	
	@Accessors static class TestExecuteCommandConfiguration {
		String command = ''
		List<Object> args = new ArrayList
		
		Consumer<Object> assertCommandResult= null
	}

	protected def void testExecuteCommand((TestExecuteCommandConfiguration)=>void configurator) {
		val extension configuration = new TestExecuteCommandConfiguration
		configurator.apply(configuration)
		val command = configuration.command
		val args = configuration.args
		val result = languageServer.executeCommand(new ExecuteCommandParams(command, args))
		if (configuration.assertCommandResult !== null) {
			val value = result.get
			configuration.assertCommandResult.accept(value)
		}
	}
	
	@Test
	def void testExecute() {
		initialize[
			capabilities = new ClientCapabilities => [
				workspace = new WorkspaceClientCapabilities => [
					executeCommand = new ExecuteCommandCapabilities => [
						dynamicRegistration = true
					]
				]
			]
		]
		testExecuteCommand [
			command = "testlang.a"
			assertCommandResult = [
				if (it instanceof String) {
					assertEquals("a", it)
				} else {
					fail("no string")
				}
			]
		]
		testExecuteCommand [
			command = "testlang.b"
			assertCommandResult = [
				if (it instanceof String) {
					assertEquals("b", it)
				} else {
					fail("no string")
				}
			]
		]
		testExecuteCommand [
			command = "doesnotexist.c"
			assertCommandResult = [
				assertNull(it)
			]
		]
	}
	
}