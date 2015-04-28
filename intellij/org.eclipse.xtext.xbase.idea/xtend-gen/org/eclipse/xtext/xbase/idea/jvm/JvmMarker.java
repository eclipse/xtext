/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.WhitespacesAndCommentsBinder;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiBuilderExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class JvmMarker implements PsiBuilder.Marker {
  @Delegate
  @Accessors
  private final PsiBuilder.Marker originalMarker;
  
  @Override
  public PsiBuilder.Marker precede() {
    PsiBuilder.Marker _precede = this.originalMarker.precede();
    return JvmPsiBuilderExtensions.wrap(_precede);
  }
  
  @Override
  public void done(final IElementType type) {
    IElementType _jvmType = JvmPsiBuilderExtensions.getJvmType(type);
    this.originalMarker.done(_jvmType);
  }
  
  @Override
  public void doneBefore(final IElementType type, final PsiBuilder.Marker before) {
    IElementType _jvmType = JvmPsiBuilderExtensions.getJvmType(type);
    PsiBuilder.Marker _unwrap = JvmPsiBuilderExtensions.unwrap(before);
    this.originalMarker.doneBefore(_jvmType, _unwrap);
  }
  
  @Override
  public void doneBefore(final IElementType type, final PsiBuilder.Marker before, final String errorMessage) {
    IElementType _jvmType = JvmPsiBuilderExtensions.getJvmType(type);
    this.originalMarker.doneBefore(_jvmType, before, errorMessage);
  }
  
  public JvmMarker(final PsiBuilder.Marker originalMarker) {
    super();
    this.originalMarker = originalMarker;
  }
  
  public void collapse(final IElementType type) {
    this.originalMarker.collapse(type);
  }
  
  public void drop() {
    this.originalMarker.drop();
  }
  
  public void error(final String message) {
    this.originalMarker.error(message);
  }
  
  public void errorBefore(final String message, final PsiBuilder.Marker before) {
    this.originalMarker.errorBefore(message, before);
  }
  
  public void rollbackTo() {
    this.originalMarker.rollbackTo();
  }
  
  public void setCustomEdgeTokenBinders(final WhitespacesAndCommentsBinder left, final WhitespacesAndCommentsBinder right) {
    this.originalMarker.setCustomEdgeTokenBinders(left, right);
  }
  
  @Pure
  public PsiBuilder.Marker getOriginalMarker() {
    return this.originalMarker;
  }
}
