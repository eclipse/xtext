/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Accessors
@SuppressWarnings("all")
public class TaskTag {
  private String name;
  
  private Priority priority;
  
  public int length() {
    return this.name.length();
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public Priority getPriority() {
    return this.priority;
  }
  
  public void setPriority(final Priority priority) {
    this.priority = priority;
  }
}
