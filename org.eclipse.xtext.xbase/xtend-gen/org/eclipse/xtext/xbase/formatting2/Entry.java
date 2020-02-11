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
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.formatting2.ObjectEntry;
import org.eclipse.xtext.xbase.formatting2.SeparatorEntry;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Accessors
@SuppressWarnings("all")
public abstract class Entry<T extends Object, R extends ITextSegment> {
  protected Entry<T, R> next;
  
  protected Entry<T, R> previous;
  
  public abstract ObjectEntry<T, R> getLeadingObject();
  
  public abstract ObjectEntry<T, R> getTrailingObject();
  
  public abstract SeparatorEntry<T, R> getLeadingSeparator();
  
  public abstract SeparatorEntry<T, R> getTrailingSeparator();
  
  @Pure
  public Entry<T, R> getNext() {
    return this.next;
  }
  
  public void setNext(final Entry<T, R> next) {
    this.next = next;
  }
  
  @Pure
  public Entry<T, R> getPrevious() {
    return this.previous;
  }
  
  public void setPrevious(final Entry<T, R> previous) {
    this.previous = previous;
  }
}
