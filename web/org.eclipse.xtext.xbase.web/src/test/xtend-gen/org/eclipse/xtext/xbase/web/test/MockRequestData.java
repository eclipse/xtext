/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.test;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.web.server.IRequestData;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class MockRequestData implements IRequestData {
  private final String requestType;
  
  @Accessors
  private final Map<String, String> parameters;
  
  @Override
  public String getMetadata(final String key) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(key, "requestType")) {
        _matched=true;
        _switchResult = this.requestType;
      }
    }
    return _switchResult;
  }
  
  public MockRequestData(final String requestType, final Map<String, String> parameters) {
    super();
    this.requestType = requestType;
    this.parameters = parameters;
  }
  
  @Pure
  public Map<String, String> getParameters() {
    return this.parameters;
  }
}
