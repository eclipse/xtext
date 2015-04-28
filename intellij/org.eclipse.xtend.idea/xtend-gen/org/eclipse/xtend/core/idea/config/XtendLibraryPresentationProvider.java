/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.intellij.openapi.roots.libraries.LibraryKind;
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.List;
import javax.swing.Icon;
import org.eclipse.xtend.core.idea.config.XtendLibraryProperties;
import org.eclipse.xtend.core.idea.icons.XtendIcons;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendLibraryPresentationProvider extends LibraryPresentationProvider<XtendLibraryProperties> {
  public final static LibraryKind LIBRARY_KIND = LibraryKind.create(XtendLanguage.INSTANCE.getID());
  
  public XtendLibraryPresentationProvider() {
    super(XtendLibraryPresentationProvider.LIBRARY_KIND);
  }
  
  @Override
  public XtendLibraryProperties detect(final List<VirtualFile> classesRoots) {
    return new XtendLibraryProperties();
  }
  
  @Override
  public Icon getIcon() {
    return XtendIcons.Xtend_ICON;
  }
}
