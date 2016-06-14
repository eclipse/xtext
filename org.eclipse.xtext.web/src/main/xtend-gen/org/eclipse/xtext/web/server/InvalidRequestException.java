/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import org.eclipse.xtend.lib.annotations.Accessors;

/**
 * Exception that can be thrown anytime while preparing or executing an Xtext service.
 * Clients invoking such a service directly or indirectly through {@link XtextServiceDispatcher}
 * must catch this exception and translate it to a proper error message.
 * An InvalidRequestException must never lead to an <em>internal server error</em>.
 */
@Accessors
@SuppressWarnings("all")
public class InvalidRequestException extends RuntimeException {
  /**
   * The request parameters are not valid.
   */
  public static class InvalidParametersException extends InvalidRequestException {
    public InvalidParametersException(final String message) {
      super(message);
    }
    
    public InvalidParametersException(final String message, final Throwable cause) {
      super(message, cause);
    }
  }
  
  /**
   * The Xtext language could not be inferred from the parameters or metadata.
   */
  public static class UnknownLanguageException extends InvalidRequestException {
    public UnknownLanguageException(final String message) {
      super(message);
    }
    
    public UnknownLanguageException(final String message, final Throwable cause) {
      super(message, cause);
    }
  }
  
  /**
   * The requested resource was not found on the server.
   */
  public static class ResourceNotFoundException extends InvalidRequestException {
    public ResourceNotFoundException(final String message) {
      super(message);
    }
    
    public ResourceNotFoundException(final String message, final Throwable cause) {
      super(message, cause);
    }
  }
  
  /**
   * The required document state does not match the current document state.
   * @see org.eclipse.xtext.web.server.model.XtextWebDocument#getStateId()
   */
  public static class InvalidDocumentStateException extends InvalidRequestException {
    public InvalidDocumentStateException(final String message) {
      super(message);
    }
    
    public InvalidDocumentStateException(final String message, final Throwable cause) {
      super(message, cause);
    }
  }
  
  /**
   * Permission to invoke the requested service was denied.
   */
  public static class PermissionDeniedException extends InvalidRequestException {
    public PermissionDeniedException(final String message) {
      super(message);
    }
    
    public PermissionDeniedException(final String message, final Throwable cause) {
      super(message, cause);
    }
  }
  
  public InvalidRequestException(final String message) {
    super(message);
  }
  
  public InvalidRequestException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
