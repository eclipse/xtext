/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.commands;

import java.util.List;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IDisposable;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IExecutableCommandService {
  /**
   * Called on server initialize.
   * @return the supported commands
   */
  List<String> initialize();
  
  /**
   * Called on server initialize, only if the client supported dynamicRegistration of commands.
   */
  default void initializeDynamicRegistration(Function1<? super String, ? extends IDisposable> register) {
  }
  
  /**
   * Called when the client wants to execute a registered command.
   */
  Object execute(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator);
}
