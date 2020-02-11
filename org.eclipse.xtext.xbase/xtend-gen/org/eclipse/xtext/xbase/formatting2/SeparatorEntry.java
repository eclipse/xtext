/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.formatting2.Entry;
import org.eclipse.xtext.xbase.formatting2.ObjectEntry;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Accessors
@SuppressWarnings("all")
public class SeparatorEntry<T extends Object, R extends ITextSegment> extends Entry<T, R> {
  private R separator;
  
  @Override
  public ObjectEntry<T, R> getLeadingObject() {
    return ((ObjectEntry<T, R>) this.previous);
  }
  
  @Override
  public ObjectEntry<T, R> getTrailingObject() {
    return ((ObjectEntry<T, R>) this.next);
  }
  
  @Override
  public SeparatorEntry<T, R> getLeadingSeparator() {
    Entry<T, R> _previous = null;
    if (this.previous!=null) {
      _previous=this.previous.previous;
    }
    return ((SeparatorEntry<T, R>) _previous);
  }
  
  @Override
  public SeparatorEntry<T, R> getTrailingSeparator() {
    Entry<T, R> _next = null;
    if (this.next!=null) {
      _next=this.next.next;
    }
    return ((SeparatorEntry<T, R>) _next);
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _text = this.separator.getText();
    _builder.append(_text);
    _builder.append("\" at offset=");
    int _offset = this.separator.getOffset();
    _builder.append(_offset);
    _builder.append(" lenght=");
    int _length = this.separator.getLength();
    _builder.append(_length);
    return _builder.toString();
  }
  
  @Pure
  public R getSeparator() {
    return this.separator;
  }
  
  public void setSeparator(final R separator) {
    this.separator = separator;
  }
}
