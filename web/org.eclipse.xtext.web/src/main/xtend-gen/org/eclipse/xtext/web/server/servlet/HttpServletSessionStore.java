/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.servlet;

import javax.servlet.http.HttpSession;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.web.server.ISessionStore;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class HttpServletSessionStore implements ISessionStore {
  private final HttpSession session;
  
  @Override
  public <T extends Object> T get(final Object key) {
    String _string = key.toString();
    Object _attribute = this.session.getAttribute(_string);
    return ((T) _attribute);
  }
  
  @Override
  public void put(final Object key, final Object value) {
    String _string = key.toString();
    this.session.setAttribute(_string, value);
  }
  
  @Override
  public void remove(final Object key) {
    String _string = key.toString();
    this.session.removeAttribute(_string);
  }
  
  public HttpServletSessionStore(final HttpSession session) {
    super();
    this.session = session;
  }
}
