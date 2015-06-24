/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.test;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.web.server.IRequestData;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class MockRequestData implements IRequestData {
  private final Map<String, String> parameters;
  
  @Override
  public Set<String> getParameterKeys() {
    Set<String> _keySet = this.parameters.keySet();
    return Collections.<String>unmodifiableSet(_keySet);
  }
  
  @Override
  public String getParameter(final String key) {
    return this.parameters.get(key);
  }
  
  @Override
  public Set<String> getMetadataKeys() {
    return Collections.<String>emptySet();
  }
  
  @Override
  public String getMetadata(final String key) {
    return null;
  }
  
  public MockRequestData(final Map<String, String> parameters) {
    super();
    this.parameters = parameters;
  }
}
