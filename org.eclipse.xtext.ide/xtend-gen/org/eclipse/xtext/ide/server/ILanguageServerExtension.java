/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import org.eclipse.xtext.ide.server.ILanguageServerAccess;

/**
 * Interface for language specific extensions to the LSP.
 * Implementors should use {link JsonRpcNotification} and {link JsonRpcRequest} annotations.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public interface ILanguageServerExtension {
  /**
   * The same jsonrpc method might be supported by multiple languages and only the actual invocation
   * might reveal is a language wants to handle it, based on e.g. a uri in the parameter.
   * 
   * To indicate that a request is not handled, this exception should be thrown by the service.
   */
  public static final RuntimeException NOT_HANDLED_EXCEPTION = new UnsupportedOperationException("not handled");
  
  /**
   * the language server provides a access to language server documents, resources and build events.
   */
  public abstract void initialize(final ILanguageServerAccess access);
}
