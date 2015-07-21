/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.formatting;

import com.google.inject.Inject;
import com.intellij.formatting.Block;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.eclipse.xtext.idea.formatting.BlockFactory;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultFormattingModelBuilder implements FormattingModelBuilder {
  @Inject
  @Extension
  private BlockFactory _blockFactory;
  
  @Override
  public FormattingModel createModel(final PsiElement element, final CodeStyleSettings settings) {
    FormattingModel _xblockexpression = null;
    {
      final Block block = this._blockFactory.createRootBlock(element, settings);
      PsiFile _containingFile = element.getContainingFile();
      _xblockexpression = FormattingModelProvider.createFormattingModelForPsiFile(_containingFile, block, settings);
    }
    return _xblockexpression;
  }
  
  @Override
  public TextRange getRangeAffectingIndent(final PsiFile file, final int offset, final ASTNode elementAtOffset) {
    return null;
  }
}
