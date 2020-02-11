/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.commands;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.ExecuteCommandCapabilities;
import org.eclipse.lsp4j.ExecuteCommandOptions;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.Registration;
import org.eclipse.lsp4j.RegistrationParams;
import org.eclipse.lsp4j.Unregistration;
import org.eclipse.lsp4j.UnregistrationParams;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IDisposable;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Log
@SuppressWarnings("all")
public class ExecutableCommandRegistry {
  private static final String METHOD = "workspace/executeCommand";
  
  private Multimap<String, IExecutableCommandService> registeredCommands;
  
  private LanguageClient client;
  
  public void initialize(final Iterable<? extends IResourceServiceProvider> allLanguages, final ClientCapabilities capabilities, final LanguageClient client) {
    this.client = client;
    this.registeredCommands = HashMultimap.<String, IExecutableCommandService>create();
    Boolean _elvis = null;
    WorkspaceClientCapabilities _workspace = capabilities.getWorkspace();
    ExecuteCommandCapabilities _executeCommand = null;
    if (_workspace!=null) {
      _executeCommand=_workspace.getExecuteCommand();
    }
    Boolean _dynamicRegistration = null;
    if (_executeCommand!=null) {
      _dynamicRegistration=_executeCommand.getDynamicRegistration();
    }
    if (_dynamicRegistration != null) {
      _elvis = _dynamicRegistration;
    } else {
      _elvis = Boolean.valueOf(false);
    }
    final boolean hasDynamicRegistration = (boolean) _elvis;
    for (final IResourceServiceProvider lang : allLanguages) {
      {
        final IExecutableCommandService service = lang.<IExecutableCommandService>get(IExecutableCommandService.class);
        if ((service != null)) {
          final List<String> commands = service.initialize();
          for (final String c : commands) {
            this.registeredCommands.put(c, service);
          }
          if (hasDynamicRegistration) {
            final Function1<String, IDisposable> _function = (String command) -> {
              return this.register(command, service);
            };
            service.initializeDynamicRegistration(_function);
          }
        }
      }
    }
  }
  
  protected IDisposable register(final String command, final IExecutableCommandService service) {
    final String requestId = UUID.randomUUID().toString();
    Registration _registration = new Registration();
    final Procedure1<Registration> _function = (Registration it) -> {
      it.setId(requestId);
      it.setMethod(ExecutableCommandRegistry.METHOD);
      ExecuteCommandOptions _executeCommandOptions = new ExecuteCommandOptions();
      final Procedure1<ExecuteCommandOptions> _function_1 = (ExecuteCommandOptions it_1) -> {
        it_1.setCommands(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(command)));
      };
      ExecuteCommandOptions _doubleArrow = ObjectExtensions.<ExecuteCommandOptions>operator_doubleArrow(_executeCommandOptions, _function_1);
      it.setRegisterOptions(_doubleArrow);
    };
    final Registration reg = ObjectExtensions.<Registration>operator_doubleArrow(_registration, _function);
    RegistrationParams _registrationParams = new RegistrationParams();
    final Procedure1<RegistrationParams> _function_1 = (RegistrationParams it) -> {
      it.setRegistrations(CollectionLiterals.<Registration>newArrayList(reg));
    };
    RegistrationParams _doubleArrow = ObjectExtensions.<RegistrationParams>operator_doubleArrow(_registrationParams, _function_1);
    this.client.registerCapability(_doubleArrow);
    this.registeredCommands.put(command, service);
    final IDisposable _function_2 = () -> {
      Unregistration _unregistration = new Unregistration();
      final Procedure1<Unregistration> _function_3 = (Unregistration it) -> {
        it.setId(requestId);
        it.setMethod(ExecutableCommandRegistry.METHOD);
      };
      final Unregistration unReg = ObjectExtensions.<Unregistration>operator_doubleArrow(_unregistration, _function_3);
      UnregistrationParams _unregistrationParams = new UnregistrationParams();
      final Procedure1<UnregistrationParams> _function_4 = (UnregistrationParams it) -> {
        it.setUnregisterations(CollectionLiterals.<Unregistration>newArrayList(unReg));
      };
      UnregistrationParams _doubleArrow_1 = ObjectExtensions.<UnregistrationParams>operator_doubleArrow(_unregistrationParams, _function_4);
      this.client.unregisterCapability(_doubleArrow_1);
      this.registeredCommands.remove(command, service);
    };
    return _function_2;
  }
  
  public Object executeCommand(final ExecuteCommandParams params, final ILanguageServerAccess access, final CancelIndicator cancelIndicator) {
    Object result = null;
    Collection<IExecutableCommandService> _get = this.registeredCommands.get(params.getCommand());
    for (final IExecutableCommandService service : _get) {
      {
        final Object localResult = service.execute(params, access, cancelIndicator);
        if ((localResult != null)) {
          if ((result != null)) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Multiple commands \'");
            String _command = params.getCommand();
            _builder.append(_command);
            _builder.append("\' have been registered. All are executed but only one result will be send back.");
            ExecutableCommandRegistry.LOG.error(_builder);
          } else {
            result = localResult;
          }
        }
      }
    }
    return result;
  }
  
  public List<String> getCommands() {
    return IterableExtensions.<String>toList(this.registeredCommands.keySet());
  }
  
  private static final Logger LOG = Logger.getLogger(ExecutableCommandRegistry.class);
}
