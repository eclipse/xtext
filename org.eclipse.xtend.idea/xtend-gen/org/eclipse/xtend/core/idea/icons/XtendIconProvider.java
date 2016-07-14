/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.icons;

import com.intellij.ide.IconProvider;
import com.intellij.psi.PsiElement;
import javax.swing.Icon;
import org.eclipse.xtend.core.idea.icons.XtendIcons;
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendIconProvider extends IconProvider {
  @Override
  public Icon getIcon(final PsiElement element, final int flags) {
    Icon _switchResult = null;
    boolean _matched = false;
    if (element instanceof XtendFileImpl) {
      _matched=true;
      _switchResult = XtendIcons.Xtend_ICON;
    }
    return _switchResult;
  }
}
