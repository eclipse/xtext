/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.PsiJavaFileBaseImpl;
import com.intellij.psi.tree.IElementType;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.idea.jvm.JvmFileType;
import org.eclipse.xtext.xbase.idea.jvm.JvmLanguage;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class PsiJvmFileImpl extends PsiJavaFileBaseImpl {
  @Accessors
  private Map<EObject, PsiElement> mapping;
  
  public PsiJvmFileImpl(final IElementType elementType, final IElementType contentElementType, final FileViewProvider viewProvider) {
    super(elementType, contentElementType, viewProvider);
  }
  
  @Override
  public boolean isPhysical() {
    return true;
  }
  
  @Override
  public FileType getFileType() {
    return JvmFileType.INSTANCE;
  }
  
  @Override
  public Language getLanguage() {
    return JvmLanguage.INSTANCE;
  }
  
  @Override
  public String toString() {
    String _name = this.getName();
    return ("PsiJvmFile:" + _name);
  }
  
  @Pure
  public Map<EObject, PsiElement> getMapping() {
    return this.mapping;
  }
  
  public void setMapping(final Map<EObject, PsiElement> mapping) {
    this.mapping = mapping;
  }
}
