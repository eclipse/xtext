/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ITokenTypeRemapper;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.WhitespaceSkippedCallback;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.diff.FlyweightCapableTreeStructure;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiBuilderExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class JvmPsiBuilder implements PsiBuilder {
  @Delegate
  private final PsiBuilder delegate;
  
  @Override
  public PsiBuilder.Marker mark() {
    PsiBuilder.Marker _mark = this.delegate.mark();
    return JvmPsiBuilderExtensions.wrap(_mark);
  }
  
  public JvmPsiBuilder(final PsiBuilder delegate) {
    super();
    this.delegate = delegate;
  }
  
  public void advanceLexer() {
    this.delegate.advanceLexer();
  }
  
  public void enforceCommentTokens(final TokenSet tokens) {
    this.delegate.enforceCommentTokens(tokens);
  }
  
  public boolean eof() {
    return this.delegate.eof();
  }
  
  public void error(final String messageText) {
    this.delegate.error(messageText);
  }
  
  public int getCurrentOffset() {
    return this.delegate.getCurrentOffset();
  }
  
  public LighterASTNode getLatestDoneMarker() {
    return this.delegate.getLatestDoneMarker();
  }
  
  public FlyweightCapableTreeStructure<LighterASTNode> getLightTree() {
    return this.delegate.getLightTree();
  }
  
  public CharSequence getOriginalText() {
    return this.delegate.getOriginalText();
  }
  
  public Project getProject() {
    return this.delegate.getProject();
  }
  
  public String getTokenText() {
    return this.delegate.getTokenText();
  }
  
  public IElementType getTokenType() {
    return this.delegate.getTokenType();
  }
  
  public ASTNode getTreeBuilt() {
    return this.delegate.getTreeBuilt();
  }
  
  public IElementType lookAhead(final int steps) {
    return this.delegate.lookAhead(steps);
  }
  
  public IElementType rawLookup(final int steps) {
    return this.delegate.rawLookup(steps);
  }
  
  public int rawTokenIndex() {
    return this.delegate.rawTokenIndex();
  }
  
  public int rawTokenTypeStart(final int steps) {
    return this.delegate.rawTokenTypeStart(steps);
  }
  
  public void remapCurrentToken(final IElementType type) {
    this.delegate.remapCurrentToken(type);
  }
  
  public void setDebugMode(final boolean dbgMode) {
    this.delegate.setDebugMode(dbgMode);
  }
  
  public void setTokenTypeRemapper(final ITokenTypeRemapper remapper) {
    this.delegate.setTokenTypeRemapper(remapper);
  }
  
  public void setWhitespaceSkippedCallback(final WhitespaceSkippedCallback callback) {
    this.delegate.setWhitespaceSkippedCallback(callback);
  }
  
  public <T extends Object> T getUserData(final Key<T> key) {
    return this.delegate.getUserData(key);
  }
  
  public <T extends Object> void putUserData(final Key<T> key, final T value) {
    this.delegate.putUserData(key, value);
  }
  
  public <T extends Object> T getUserDataUnprotected(final Key<T> key) {
    return this.delegate.getUserDataUnprotected(key);
  }
  
  public <T extends Object> void putUserDataUnprotected(final Key<T> key, final T value) {
    this.delegate.putUserDataUnprotected(key, value);
  }
}
