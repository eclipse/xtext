/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.tasks.Priority;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public class TaskTag {
  @Property
  private String _name;
  
  @Property
  private Priority _priority;
  
  public int length() {
    String _name = this.getName();
    return _name.length();
  }
  
  public String getName() {
    return this._name;
  }
  
  public void setName(final String name) {
    this._name = name;
  }
  
  public Priority getPriority() {
    return this._priority;
  }
  
  public void setPriority(final Priority priority) {
    this._priority = priority;
  }
}
