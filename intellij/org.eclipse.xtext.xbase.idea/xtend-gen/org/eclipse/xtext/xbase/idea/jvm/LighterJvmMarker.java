/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.xbase.idea.jvm.JvmMarker;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LighterJvmMarker extends JvmMarker implements LighterASTNode {
  @Delegate
  @Accessors
  private final LighterASTNode originalLighterASTNode;
  
  public LighterJvmMarker(final PsiBuilder.Marker marker, final LighterASTNode lighterASTNode) {
    super(marker);
    this.originalLighterASTNode = lighterASTNode;
  }
  
  public int getEndOffset() {
    return this.originalLighterASTNode.getEndOffset();
  }
  
  public int getStartOffset() {
    return this.originalLighterASTNode.getStartOffset();
  }
  
  public IElementType getTokenType() {
    return this.originalLighterASTNode.getTokenType();
  }
  
  @Pure
  public LighterASTNode getOriginalLighterASTNode() {
    return this.originalLighterASTNode;
  }
}
