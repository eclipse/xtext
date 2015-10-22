/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.lang.CreateElementType;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class CompositeMarker {
  private final int lookAhead;
  
  private final IElementType elementType;
  
  private final PsiBuilder.Marker marker;
  
  @Accessors
  private boolean hasSemanticElement;
  
  public CompositeMarker(final PsiBuilder.Marker marker, final int lookAhead, final IElementType elementType) {
    this.marker = marker;
    this.lookAhead = lookAhead;
    this.elementType = elementType;
  }
  
  public CompositeMarker precede(final IElementType elementType) {
    PsiBuilder.Marker _precede = this.marker.precede();
    return new CompositeMarker(_precede, this.lookAhead, elementType);
  }
  
  public void done() {
    CreateElementType _withUserData = this.withUserData(this.elementType);
    this.marker.done(_withUserData);
  }
  
  protected CreateElementType withUserData(final IElementType elementType) {
    final CreateElementType.CreateCallback _function = new CreateElementType.CreateCallback() {
      @Override
      public void onCreate(final ASTNode it) {
        it.<Integer>putUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY, Integer.valueOf(CompositeMarker.this.lookAhead));
        it.<Boolean>putUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY, Boolean.valueOf(CompositeMarker.this.hasSemanticElement));
      }
    };
    return new CreateElementType(elementType, _function);
  }
  
  @Pure
  public boolean isHasSemanticElement() {
    return this.hasSemanticElement;
  }
  
  public void setHasSemanticElement(final boolean hasSemanticElement) {
    this.hasSemanticElement = hasSemanticElement;
  }
}
