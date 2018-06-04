/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Accessors
@EqualsHashCode
@SuppressWarnings("all")
public class Task {
  private TaskTag tag;
  
  private String description;
  
  private int lineNumber;
  
  private int offset;
  
  public String getFullText() {
    String _name = this.tag.getName();
    return (_name + this.description);
  }
  
  public int getTotalLength() {
    return this.getFullText().length();
  }
  
  public int getTagLength() {
    return this.tag.length();
  }
  
  @Pure
  public TaskTag getTag() {
    return this.tag;
  }
  
  public void setTag(final TaskTag tag) {
    this.tag = tag;
  }
  
  @Pure
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  @Pure
  public int getLineNumber() {
    return this.lineNumber;
  }
  
  public void setLineNumber(final int lineNumber) {
    this.lineNumber = lineNumber;
  }
  
  @Pure
  public int getOffset() {
    return this.offset;
  }
  
  public void setOffset(final int offset) {
    this.offset = offset;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Task other = (Task) obj;
    if (this.tag == null) {
      if (other.tag != null)
        return false;
    } else if (!this.tag.equals(other.tag))
      return false;
    if (this.description == null) {
      if (other.description != null)
        return false;
    } else if (!this.description.equals(other.description))
      return false;
    if (other.lineNumber != this.lineNumber)
      return false;
    if (other.offset != this.offset)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.tag== null) ? 0 : this.tag.hashCode());
    result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
    result = prime * result + this.lineNumber;
    return prime * result + this.offset;
  }
}
