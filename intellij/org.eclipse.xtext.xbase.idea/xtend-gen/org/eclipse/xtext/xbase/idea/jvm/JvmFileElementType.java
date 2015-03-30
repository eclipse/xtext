/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.java.parser.FileParser;
import com.intellij.lang.java.parser.JavaParser;
import com.intellij.lang.java.parser.JavaParserUtil;
import com.intellij.psi.impl.source.JavaFileElementType;
import com.intellij.util.diff.FlyweightCapableTreeStructure;
import org.eclipse.xtext.xbase.idea.jvm.JvmFileElement;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiBuilder;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmFileElementType extends JavaFileElementType {
  public final static JvmFileElementType INSTANCE = new JvmFileElementType();
  
  @Override
  public ASTNode createNode(final CharSequence text) {
    return new JvmFileElement(text, this);
  }
  
  @Override
  public FlyweightCapableTreeStructure<LighterASTNode> parseContentsLight(final ASTNode chameleon) {
    PsiBuilder _createBuilder = JavaParserUtil.createBuilder(chameleon);
    final PsiBuilder builder = new JvmPsiBuilder(_createBuilder);
    this.doParse(builder);
    return builder.getLightTree();
  }
  
  @Override
  public ASTNode parseContents(final ASTNode chameleon) {
    PsiBuilder _createBuilder = JavaParserUtil.createBuilder(chameleon);
    final PsiBuilder builder = new JvmPsiBuilder(_createBuilder);
    this.doParse(builder);
    ASTNode _treeBuilt = builder.getTreeBuilt();
    return _treeBuilt.getFirstChildNode();
  }
  
  private void doParse(final PsiBuilder builder) {
    final PsiBuilder.Marker root = builder.mark();
    FileParser _fileParser = JavaParser.INSTANCE.getFileParser();
    _fileParser.parse(builder);
    root.done(this);
  }
}
