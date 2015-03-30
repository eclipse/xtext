/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.google.common.base.Objects;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.impl.source.tree.JavaElementType;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtext.xbase.idea.jvm.JvmMarker;
import org.eclipse.xtext.xbase.idea.jvm.JvmStubElementTypes;
import org.eclipse.xtext.xbase.idea.jvm.LighterJvmMarker;

@SuppressWarnings("all")
public class JvmPsiBuilderExtensions {
  public static JvmMarker wrap(final PsiBuilder.Marker marker) {
    JvmMarker _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (marker instanceof LighterASTNode) {
        _matched=true;
        _switchResult = new LighterJvmMarker(marker, ((LighterASTNode)marker));
      }
    }
    if (!_matched) {
      _switchResult = new JvmMarker(marker);
    }
    return _switchResult;
  }
  
  public static PsiBuilder.Marker unwrap(final PsiBuilder.Marker marker) {
    PsiBuilder.Marker _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (marker instanceof JvmMarker) {
        _matched=true;
        _switchResult = ((JvmMarker)marker).getOriginalMarker();
      }
    }
    if (!_matched) {
      _switchResult = marker;
    }
    return _switchResult;
  }
  
  public static IElementType getJvmType(final IElementType type) {
    IElementType _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type, JavaElementType.CLASS)) {
        _matched=true;
        _switchResult = JvmStubElementTypes.CLASS;
      }
    }
    if (!_matched) {
      if (Objects.equal(type, JavaElementType.ANONYMOUS_CLASS)) {
        _matched=true;
        _switchResult = JvmStubElementTypes.ANONYMOUS_CLASS;
      }
    }
    if (!_matched) {
      if (Objects.equal(type, JavaElementType.ENUM_CONSTANT_INITIALIZER)) {
        _matched=true;
        _switchResult = JvmStubElementTypes.ENUM_CONSTANT_INITIALIZER;
      }
    }
    if (!_matched) {
      if (Objects.equal(type, JavaElementType.METHOD)) {
        _matched=true;
        _switchResult = JvmStubElementTypes.METHOD;
      }
    }
    if (!_matched) {
      if (Objects.equal(type, JavaElementType.ANNOTATION_METHOD)) {
        _matched=true;
        _switchResult = JvmStubElementTypes.ANNOTATION_METHOD;
      }
    }
    if (!_matched) {
      if (Objects.equal(type, JavaElementType.FIELD)) {
        _matched=true;
        _switchResult = JvmStubElementTypes.FIELD;
      }
    }
    if (!_matched) {
      if (Objects.equal(type, JavaElementType.ENUM_CONSTANT)) {
        _matched=true;
        _switchResult = JvmStubElementTypes.ENUM_CONSTANT;
      }
    }
    if (!_matched) {
      _switchResult = type;
    }
    return _switchResult;
  }
}
