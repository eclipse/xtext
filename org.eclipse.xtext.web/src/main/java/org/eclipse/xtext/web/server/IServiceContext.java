/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server;

import java.util.Set;

/**
 * Provides the parameters and meta data of a service request.
 */
public interface IServiceContext {
  /**
   * Key for the service type parameter, which determines the actual service to be invoked.
   */
  static String SERVICE_TYPE = "serviceType";
  
  /**
   * The available keys that can be used as arguments to {@link #getParameter(String)}.
   */
  Set<String> getParameterKeys();
  
  /**
   * Returns the request parameter for the given key.
   */
  String getParameter(String key);
  
  /**
   * Returns a session into which information can be stored across multiple requests from
   * the same client. If a session does not exist yet, one is created.
   * 
   * <p><em>Warning:</em> This method may have side effects on the response sent to the client,
   * such as adding a session Id.</p>
   */
  ISession getSession();
}
