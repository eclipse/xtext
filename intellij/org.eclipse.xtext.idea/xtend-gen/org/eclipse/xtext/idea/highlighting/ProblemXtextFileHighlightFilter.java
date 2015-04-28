/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.vfs.VirtualFile;
import org.eclipse.xtext.idea.lang.IXtextLanguage;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ProblemXtextFileHighlightFilter implements Condition<VirtualFile> {
  @Override
  public boolean value(final VirtualFile file) {
    boolean _xblockexpression = false;
    {
      final FileType fileType = file.getFileType();
      boolean _xifexpression = false;
      if ((fileType instanceof LanguageFileType)) {
        Language _language = ((LanguageFileType)fileType).getLanguage();
        return (_language instanceof IXtextLanguage);
      } else {
        _xifexpression = false;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
