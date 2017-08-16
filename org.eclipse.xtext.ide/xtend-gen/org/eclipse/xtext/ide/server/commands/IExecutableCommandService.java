/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
@SuppressWarnings("all")
public interface IExecutableCommandService {
  /**
   * Called on server initialize.
   * @return the supported commands
   */
  public abstract List<String> initialize();
  
  /**
   * Called on server initialize, only if the client supported dynamicRegistration of commands.
   */
  public default void initializeDynamicRegistration(final Function1<? super String, ? extends IDisposable> register) {
  }
  
  /**
   * Called when the client wants to execute a registered command.
   */
  public abstract Object execute(final ExecuteCommandParams params, final ILanguageServerAccess access, final CancelIndicator cancelIndicator);
}
