/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.ExecuteCommandCapabilities;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class CommandServiceTest extends AbstractTestLangLanguageServerTest {
	public static class TestExecuteCommandConfiguration {
		private String command = "";

		private List<Object> args = new ArrayList<Object>();

		private Consumer<Object> assertCommandResult = null;

		public String getCommand() {
			return command;
		}

		public void setCommand(String command) {
			this.command = command;
		}

		public List<Object> getArgs() {
			return args;
		}

		public void setArgs(List<Object> args) {
			this.args = args;
		}

		public Consumer<Object> getAssertCommandResult() {
			return assertCommandResult;
		}

		public void setAssertCommandResult(Consumer<Object> assertCommandResult) {
			this.assertCommandResult = assertCommandResult;
		}
	}

	protected void testExecuteCommand(Procedure1<? super TestExecuteCommandConfiguration> configurator)
			throws Exception {
		TestExecuteCommandConfiguration configuration = new TestExecuteCommandConfiguration();
		configurator.apply(configuration);
		String command = configuration.command;
		List<Object> args = configuration.args;
		CompletableFuture<Object> result = languageServer.executeCommand(new ExecuteCommandParams(command, args));
		if (configuration.assertCommandResult != null) {
			Object value = result.get();
			configuration.assertCommandResult.accept(value);
		}
	}

	@Test
	public void testExecute() throws Exception {
		initialize((InitializeParams it) -> {
			ClientCapabilities clientCapabilities = new ClientCapabilities();
			WorkspaceClientCapabilities workspaceClientCapabilities = new WorkspaceClientCapabilities();
			workspaceClientCapabilities.setWorkspaceFolders(true);
			workspaceClientCapabilities.setExecuteCommand(new ExecuteCommandCapabilities(true));
			clientCapabilities.setWorkspace(workspaceClientCapabilities);
			it.setCapabilities(clientCapabilities);
		});
		testExecuteCommand((TestExecuteCommandConfiguration cfg) -> {
			cfg.command = "testlang.a";
			cfg.assertCommandResult = (Object o) -> {
				if (o instanceof String) {
					assertEquals("a", (String) o);
				} else {
					Assert.fail("no string");
				}
			};
		});
		testExecuteCommand((TestExecuteCommandConfiguration cfg) -> {
			cfg.command = "testlang.b";
			cfg.assertCommandResult = (Object o) -> {
				if (o instanceof String) {
					assertEquals("b", (String) o);
				} else {
					Assert.fail("no string");
				}
			};
		});
		testExecuteCommand((TestExecuteCommandConfiguration cfg) -> {
			cfg.command = "doesnotexist.c";
			cfg.assertCommandResult = (Object o) -> {
				Assert.assertNull(o);
			};
		});
	}
}
