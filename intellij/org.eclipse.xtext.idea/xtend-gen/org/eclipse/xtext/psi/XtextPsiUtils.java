/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi;

import com.google.common.base.Objects;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.indexing.IndexingDataKeys;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextPsiUtils {
  public static VirtualFile findVirtualFile(final PsiElement element) {
    VirtualFile _xifexpression = null;
    if ((element instanceof PsiFile)) {
      PsiFile originalFile = ((PsiFile)element).getOriginalFile();
      if (((originalFile != element) && (originalFile != null))) {
        return XtextPsiUtils.findVirtualFile(originalFile);
      }
      VirtualFile virtualFile = ((PsiFile)element).<VirtualFile>getUserData(IndexingDataKeys.VIRTUAL_FILE);
      if ((virtualFile != null)) {
        return virtualFile;
      }
      FileViewProvider _viewProvider = ((PsiFile)element).getViewProvider();
      return _viewProvider.getVirtualFile();
    } else {
      VirtualFile _xifexpression_1 = null;
      boolean _equals = Objects.equal(element, null);
      if (_equals) {
        return null;
      } else {
        PsiFile _containingFile = element.getContainingFile();
        _xifexpression_1 = XtextPsiUtils.findVirtualFile(_containingFile);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
