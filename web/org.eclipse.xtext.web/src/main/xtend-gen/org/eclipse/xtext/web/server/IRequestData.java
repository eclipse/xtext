/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import java.util.Collection;

@SuppressWarnings("all")
public interface IRequestData {
  public final static String METADATA_REQUEST_TYPE = "requestType";
  
  public abstract Collection<String> getParameterKeys();
  
  public abstract String getParameter(final String key);
  
  public abstract Collection<String> getMetadataKeys();
  
  public abstract String getMetadata(final String key);
}
