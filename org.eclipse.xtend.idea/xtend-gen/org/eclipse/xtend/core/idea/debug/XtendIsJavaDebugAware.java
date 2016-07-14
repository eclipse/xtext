/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.debug;

import com.google.common.base.Objects;
import com.intellij.debugger.engine.JavaDebugAware;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.PsiFile;
import org.eclipse.xtend.core.idea.lang.XtendFileType;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendIsJavaDebugAware extends JavaDebugAware {
  @Override
  public boolean isBreakpointAware(final PsiFile psiFile) {
    FileType _fileType = psiFile.getFileType();
    return Objects.equal(_fileType, XtendFileType.INSTANCE);
  }
}
