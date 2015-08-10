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
import com.intellij.openapi.roots.libraries.LibraryUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.List;
import javax.swing.Icon;
import org.eclipse.xtend.core.idea.config.XtendLibraryDescription;
import org.eclipse.xtend.core.idea.config.XtendLibraryProperties;
import org.eclipse.xtend.core.idea.icons.XtendIcons;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
    final List<? extends Class<?>> detectorClasses = XtendLibraryDescription.getDetectorClasses();
    boolean _and = false;
    int _size = detectorClasses.size();
    int _size_1 = classesRoots.size();
    boolean _tripleEquals = (_size == _size_1);
    if (!_tripleEquals) {
      _and = false;
    } else {
      final Function1<Class<?>, Boolean> _function = new Function1<Class<?>, Boolean>() {
        @Override
        public Boolean apply(final Class<?> it) {
          String _name = it.getName();
          return Boolean.valueOf(LibraryUtil.isClassAvailableInLibrary(classesRoots, _name));
        }
      };
      boolean _forall = IterableExtensions.forall(detectorClasses, _function);
      _and = _forall;
    }
    if (_and) {
      return new XtendLibraryProperties();
    }
    return null;
  }
  
  @Override
  public Icon getIcon() {
    return XtendIcons.Xtend_ICON;
  }
}
