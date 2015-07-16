/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.CodeDocumentationAwareCommenter;
import com.intellij.psi.PsiComment;
import com.intellij.psi.tree.IElementType;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultCommenter implements CodeDocumentationAwareCommenter {
  private IElementType mlCommentTokenType;
  
  private IElementType slCommentTokenType;
  
  @Inject
  public void setTokenTypes(final TokenTypeProvider tokenTypeProvider, final ITokenDefProvider tokenDefProvider) {
    IElementType _tokenType = this.getTokenType("RULE_ML_COMMENT", tokenTypeProvider, tokenDefProvider);
    this.mlCommentTokenType = _tokenType;
    IElementType _tokenType_1 = this.getTokenType("RULE_SL_COMMENT", tokenTypeProvider, tokenDefProvider);
    this.slCommentTokenType = _tokenType_1;
  }
  
  protected IElementType getTokenType(final String tokenName, @Extension final TokenTypeProvider tokenTypeProvider, @Extension final ITokenDefProvider tokenDefProvider) {
    IElementType _xblockexpression = null;
    {
      Map<Integer, String> _tokenDefMap = tokenDefProvider.getTokenDefMap();
      Set<Map.Entry<Integer, String>> _entrySet = _tokenDefMap.entrySet();
      final Function1<Map.Entry<Integer, String>, Boolean> _function = new Function1<Map.Entry<Integer, String>, Boolean>() {
        @Override
        public Boolean apply(final Map.Entry<Integer, String> it) {
          String _value = it.getValue();
          return Boolean.valueOf(Objects.equal(_value, tokenName));
        }
      };
      final Map.Entry<Integer, String> mlCommentEntry = IterableExtensions.<Map.Entry<Integer, String>>findFirst(_entrySet, _function);
      IElementType _xifexpression = null;
      boolean _notEquals = (!Objects.equal(mlCommentEntry, null));
      if (_notEquals) {
        Integer _key = mlCommentEntry.getKey();
        _xifexpression = tokenTypeProvider.getIElementType((_key).intValue());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getLineCommentPrefix() {
    return "//";
  }
  
  @Override
  public String getBlockCommentPrefix() {
    return "/*";
  }
  
  @Override
  public String getBlockCommentSuffix() {
    return "*/";
  }
  
  @Override
  public String getCommentedBlockCommentPrefix() {
    return null;
  }
  
  @Override
  public String getCommentedBlockCommentSuffix() {
    return null;
  }
  
  @Override
  public IElementType getBlockCommentTokenType() {
    return this.mlCommentTokenType;
  }
  
  @Override
  public String getDocumentationCommentLinePrefix() {
    return "*";
  }
  
  @Override
  public String getDocumentationCommentPrefix() {
    return null;
  }
  
  @Override
  public String getDocumentationCommentSuffix() {
    return null;
  }
  
  @Override
  public IElementType getDocumentationCommentTokenType() {
    return this.mlCommentTokenType;
  }
  
  @Override
  public IElementType getLineCommentTokenType() {
    return this.slCommentTokenType;
  }
  
  @Override
  public boolean isDocumentationComment(final PsiComment element) {
    return false;
  }
}
