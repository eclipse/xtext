/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea;

import com.google.common.base.Objects;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtext.idea.tests.LibraryUtil;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class LightXtendTest extends LightToolingTest {
  public LightXtendTest() {
    super(XtendFileType.INSTANCE);
  }
  
  @Override
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    try {
      LibraryUtil.addXtendLibrary(model);
      VirtualFile _file = contentEntry.getFile();
      final VirtualFile xtendGenFolder = VfsUtil.createDirectoryIfMissing(_file, "xtend-gen");
      contentEntry.addSourceFolder(xtendGenFolder, false);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected String getXtextStyle(final IElementType tokenType) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(tokenType, XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE);
    if (_equals) {
      _xifexpression = XtendHighlightingStyles.RICH_TEXT_DELIMITER_ID;
    } else {
      _xifexpression = super.getXtextStyle(tokenType);
    }
    return _xifexpression;
  }
}
