/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import java.util.Collection;

/**
 * Provides the parameters and meta data of a service request.
 */
@SuppressWarnings("all")
public interface IRequestData {
  /**
   * Key for the request type property, which determines the actual service to be invoked.
   * This property can be given either as a parameter or as part of the metadata of a request.
   */
  public final static String REQUEST_TYPE = "requestType";
  
  /**
   * The available keys that can be used as arguments to {@link #getParameter(String)}.
   */
  public abstract Collection<String> getParameterKeys();
  
  /**
   * Returns the request parameter for the given key.
   */
  public abstract String getParameter(final String key);
  
  /**
   * The available keys that can be used as arguments to {@link #getMetadata(String)}.
   * The returned collection contains all keys that are supported by this implementation,
   * but the actual values for some of these keys may be {@code null} because it might
   * be too expensive to determine the non-null metadata upfront.
   */
  public abstract Collection<String> getMetadataKeys();
  
  /**
   * Returns the request metadata for the given key.
   */
  public abstract String getMetadata(final String key);
}
