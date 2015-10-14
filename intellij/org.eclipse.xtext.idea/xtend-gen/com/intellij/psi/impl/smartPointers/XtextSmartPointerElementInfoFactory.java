/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.intellij.psi.impl.smartPointers;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.ProperTextRange;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.smartPointers.SmartPointerElementInfo;
import com.intellij.psi.impl.smartPointers.SmartPointerElementInfoFactory;
import com.intellij.psi.impl.smartPointers.XtextSelfElementInfo;
import com.intellij.psi.stubs.IStubElementType;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextSmartPointerElementInfoFactory extends SmartPointerElementInfoFactory {
  @Override
  public SmartPointerElementInfo createElementInfo(final PsiElement element, final PsiFile containingFile) {
    if ((element instanceof PsiEObjectImpl)) {
      Project _project = containingFile.getProject();
      TextRange _textRange = ((PsiEObjectImpl)element).getTextRange();
      ProperTextRange _create = ProperTextRange.create(_textRange);
      IStubElementType _elementType = ((PsiEObjectImpl)element).getElementType();
      Language _rootLanguage = LanguageUtil.getRootLanguage(element);
      return new XtextSelfElementInfo(_project, _create, _elementType, containingFile, _rootLanguage, 
        false);
    }
    return null;
  }
}
