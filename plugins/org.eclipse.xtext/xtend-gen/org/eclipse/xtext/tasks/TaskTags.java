/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import java.util.Iterator;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Accessors
@SuppressWarnings("all")
public class TaskTags implements Iterable<TaskTag> {
  private boolean caseSensitive;
  
  private final List<TaskTag> taskTags = CollectionLiterals.<TaskTag>newArrayList();
  
  @Override
  public Iterator<TaskTag> iterator() {
    return this.taskTags.iterator();
  }
  
  @Pure
  public boolean isCaseSensitive() {
    return this.caseSensitive;
  }
  
  public void setCaseSensitive(final boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
  }
  
  @Pure
  public List<TaskTag> getTaskTags() {
    return this.taskTags;
  }
}
