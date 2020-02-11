/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class DefaultHierarchyNodeReference implements IHierarchyNodeReference {
  private final String text;
  
  @Delegate
  private final ITextRegionWithLineInformation textRegion;
  
  private final Object navigationElement;
  
  public DefaultHierarchyNodeReference(final String text, final ITextRegionWithLineInformation textRegion, final Object navigationElement) {
    super();
    this.text = text;
    this.textRegion = textRegion;
    this.navigationElement = navigationElement;
  }
  
  @Pure
  public String getText() {
    return this.text;
  }
  
  @Pure
  public ITextRegionWithLineInformation getTextRegion() {
    return this.textRegion;
  }
  
  @Pure
  public Object getNavigationElement() {
    return this.navigationElement;
  }
  
  public boolean contains(final ITextRegion other) {
    return this.textRegion.contains(other);
  }
  
  public boolean contains(final int offset) {
    return this.textRegion.contains(offset);
  }
  
  public int getEndLineNumber() {
    return this.textRegion.getEndLineNumber();
  }
  
  public int getLength() {
    return this.textRegion.getLength();
  }
  
  public int getLineNumber() {
    return this.textRegion.getLineNumber();
  }
  
  public int getOffset() {
    return this.textRegion.getOffset();
  }
  
  public ITextRegion merge(final ITextRegion region) {
    return this.textRegion.merge(region);
  }
  
  public ITextRegionWithLineInformation merge(final ITextRegionWithLineInformation other) {
    return this.textRegion.merge(other);
  }
}
