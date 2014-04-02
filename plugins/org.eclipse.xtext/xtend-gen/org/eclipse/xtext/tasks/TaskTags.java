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
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public final class TaskTags implements Iterable<TaskTag> {
  private boolean _caseSensitive;
  
  public boolean isCaseSensitive() {
    return this._caseSensitive;
  }
  
  public void setCaseSensitive(final boolean caseSensitive) {
    this._caseSensitive = caseSensitive;
  }
  
  private final List<TaskTag> taskTags = CollectionLiterals.<TaskTag>newArrayList();
  
  public Iterator<TaskTag> iterator() {
    return this.taskTags.iterator();
  }
  
  public List<TaskTag> getTaskTags() {
    return this.taskTags;
  }
}
