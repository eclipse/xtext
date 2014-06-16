/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.tasks.TaskTag;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@SuppressWarnings("all")
public final class Task {
  @Property
  private TaskTag _tag;
  
  @Property
  private String _description;
  
  @Property
  private int _lineNumber;
  
  @Property
  private int _offset;
  
  public String getFullText() {
    TaskTag _tag = this.getTag();
    String _name = _tag.getName();
    String _description = this.getDescription();
    return (_name + _description);
  }
  
  public int getTotalLength() {
    String _fullText = this.getFullText();
    return _fullText.length();
  }
  
  public int getTagLength() {
    TaskTag _tag = this.getTag();
    return _tag.length();
  }
  
  public TaskTag getTag() {
    return this._tag;
  }
  
  public void setTag(final TaskTag tag) {
    this._tag = tag;
  }
  
  public String getDescription() {
    return this._description;
  }
  
  public void setDescription(final String description) {
    this._description = description;
  }
  
  public int getLineNumber() {
    return this._lineNumber;
  }
  
  public void setLineNumber(final int lineNumber) {
    this._lineNumber = lineNumber;
  }
  
  public int getOffset() {
    return this._offset;
  }
  
  public void setOffset(final int offset) {
    this._offset = offset;
  }
}
