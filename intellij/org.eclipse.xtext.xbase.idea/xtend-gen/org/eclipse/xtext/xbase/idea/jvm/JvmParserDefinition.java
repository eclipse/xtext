/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.java.JavaParserDefinition;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import org.eclipse.xtext.xbase.idea.jvm.JvmFileElementType;
import org.eclipse.xtext.xbase.idea.jvm.PsiJvmFileImpl;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmParserDefinition extends JavaParserDefinition {
  @Override
  public IFileElementType getFileNodeType() {
    return JvmFileElementType.INSTANCE;
  }
  
  @Override
  public PsiFile createFile(final FileViewProvider viewProvider) {
    IFileElementType _fileNodeType = this.getFileNodeType();
    IFileElementType _fileNodeType_1 = this.getFileNodeType();
    return new PsiJvmFileImpl(_fileNodeType, _fileNodeType_1, viewProvider);
  }
}
