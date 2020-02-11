/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class CommandServiceTest extends AbstractTestLangLanguageServerTest {
  @Accessors
  public static class TestExecuteCommandConfiguration {
    private String command = "";
    
    private List<Object> args = new ArrayList<Object>();
    
    private Consumer<Object> assertCommandResult = null;
    
    @Pure
    public String getCommand() {
      return this.command;
    }
    
    public void setCommand(final String command) {
      this.command = command;
    }
    
    @Pure
    public List<Object> getArgs() {
      return this.args;
    }
    
    public void setArgs(final List<Object> args) {
      this.args = args;
    }
    
    @Pure
    public Consumer<Object> getAssertCommandResult() {
      return this.assertCommandResult;
    }
    
    public void setAssertCommandResult(final Consumer<Object> assertCommandResult) {
      this.assertCommandResult = assertCommandResult;
    }
  }
  
  protected void testExecuteCommand(final Procedure1<? super CommandServiceTest.TestExecuteCommandConfiguration> configurator) {
    try {
      @Extension
      final CommandServiceTest.TestExecuteCommandConfiguration configuration = new CommandServiceTest.TestExecuteCommandConfiguration();
      configurator.apply(configuration);
      final String command = configuration.command;
      final List<Object> args = configuration.args;
      ExecuteCommandParams _executeCommandParams = new ExecuteCommandParams(command, args);
      final CompletableFuture<Object> result = this.languageServer.executeCommand(_executeCommandParams);
      if ((configuration.assertCommandResult != null)) {
        final Object value = result.get();
        configuration.assertCommandResult.accept(value);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExecute() {
    final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
      ClientCapabilities _clientCapabilities = new ClientCapabilities();
      final Procedure1<ClientCapabilities> _function_1 = (ClientCapabilities it_1) -> {
        WorkspaceClientCapabilities _workspaceClientCapabilities = new WorkspaceClientCapabilities();
        final Procedure1<WorkspaceClientCapabilities> _function_2 = (WorkspaceClientCapabilities it_2) -> {
          ExecuteCommandCapabilities _executeCommandCapabilities = new ExecuteCommandCapabilities();
          final Procedure1<ExecuteCommandCapabilities> _function_3 = (ExecuteCommandCapabilities it_3) -> {
            it_3.setDynamicRegistration(Boolean.valueOf(true));
          };
          ExecuteCommandCapabilities _doubleArrow = ObjectExtensions.<ExecuteCommandCapabilities>operator_doubleArrow(_executeCommandCapabilities, _function_3);
          it_2.setExecuteCommand(_doubleArrow);
        };
        WorkspaceClientCapabilities _doubleArrow = ObjectExtensions.<WorkspaceClientCapabilities>operator_doubleArrow(_workspaceClientCapabilities, _function_2);
        it_1.setWorkspace(_doubleArrow);
      };
      ClientCapabilities _doubleArrow = ObjectExtensions.<ClientCapabilities>operator_doubleArrow(_clientCapabilities, _function_1);
      it.setCapabilities(_doubleArrow);
    };
    this.initialize(_function);
    final Procedure1<CommandServiceTest.TestExecuteCommandConfiguration> _function_1 = (CommandServiceTest.TestExecuteCommandConfiguration it) -> {
      it.command = "testlang.a";
      final Consumer<Object> _function_2 = (Object it_1) -> {
        if ((it_1 instanceof String)) {
          this.assertEquals("a", ((String)it_1));
        } else {
          Assert.fail("no string");
        }
      };
      it.assertCommandResult = _function_2;
    };
    this.testExecuteCommand(_function_1);
    final Procedure1<CommandServiceTest.TestExecuteCommandConfiguration> _function_2 = (CommandServiceTest.TestExecuteCommandConfiguration it) -> {
      it.command = "testlang.b";
      final Consumer<Object> _function_3 = (Object it_1) -> {
        if ((it_1 instanceof String)) {
          this.assertEquals("b", ((String)it_1));
        } else {
          Assert.fail("no string");
        }
      };
      it.assertCommandResult = _function_3;
    };
    this.testExecuteCommand(_function_2);
    final Procedure1<CommandServiceTest.TestExecuteCommandConfiguration> _function_3 = (CommandServiceTest.TestExecuteCommandConfiguration it) -> {
      it.command = "doesnotexist.c";
      final Consumer<Object> _function_4 = (Object it_1) -> {
        Assert.assertNull(it_1);
      };
      it.assertCommandResult = _function_4;
    };
    this.testExecuteCommand(_function_3);
  }
}
