/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.LibraryKind;
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration;
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription;
import com.intellij.openapi.roots.ui.configuration.libraryEditor.LibraryEditor;
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainer;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.PathUtil;
import com.intellij.util.containers.ContainerUtil;
import java.io.File;
import java.util.List;
import java.util.Set;
import javax.swing.JComponent;
import org.eclipse.xtend.core.idea.config.XtendLibraryPresentationProvider;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendLibraryDescription extends CustomLibraryDescription {
  public final static Set<LibraryKind> LIBRARY_KINDS = IterableExtensions.<LibraryKind>toSet(ListExtensions.<XtendLibraryPresentationProvider, LibraryKind>map(XtendLibraryDescription.getProviders(), new Function1<XtendLibraryPresentationProvider, LibraryKind>() {
    @Override
    public LibraryKind apply(final XtendLibraryPresentationProvider it) {
      return it.getKind();
    }
  }));
  
  @Override
  public NewLibraryConfiguration createNewLibrary(final JComponent parentComponent, final VirtualFile contextDirectory) {
    NewLibraryConfiguration _xblockexpression = null;
    {
      List<XtendLibraryPresentationProvider> _providers = XtendLibraryDescription.getProviders();
      final XtendLibraryPresentationProvider provider = IterableExtensions.<XtendLibraryPresentationProvider>head(_providers);
      boolean _equals = Objects.equal(provider, null);
      if (_equals) {
        return null;
      }
      _xblockexpression = new NewLibraryConfiguration("Xtend Library") {
        @Override
        public void addRoots(final LibraryEditor editor) {
          String _urlForLibraryRoot = XtendLibraryDescription.this.getUrlForLibraryRoot(Lists.class);
          editor.addRoot(_urlForLibraryRoot, OrderRootType.CLASSES);
          String _urlForLibraryRoot_1 = XtendLibraryDescription.this.getUrlForLibraryRoot(ToStringBuilder.class);
          editor.addRoot(_urlForLibraryRoot_1, OrderRootType.CLASSES);
          String _urlForLibraryRoot_2 = XtendLibraryDescription.this.getUrlForLibraryRoot(Active.class);
          editor.addRoot(_urlForLibraryRoot_2, OrderRootType.CLASSES);
          String _urlForLibraryRoot_3 = XtendLibraryDescription.this.getUrlForLibraryRoot(Data.class);
          editor.addRoot(_urlForLibraryRoot_3, OrderRootType.CLASSES);
        }
      };
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<? extends LibraryKind> getSuitableLibraryKinds() {
    return XtendLibraryDescription.LIBRARY_KINDS;
  }
  
  @Override
  public LibrariesContainer.LibraryLevel getDefaultLevel() {
    return LibrariesContainer.LibraryLevel.GLOBAL;
  }
  
  protected String getUrlForLibraryRoot(final Class<?> clazz) {
    String _xblockexpression = null;
    {
      String _jarPathForClass = PathUtil.getJarPathForClass(clazz);
      final File libraryRoot = new File(_jarPathForClass);
      LocalFileSystem _instance = LocalFileSystem.getInstance();
      _instance.refreshAndFindFileByIoFile(libraryRoot);
      _xblockexpression = VfsUtil.getUrlForLibraryRoot(libraryRoot);
    }
    return _xblockexpression;
  }
  
  protected static List<XtendLibraryPresentationProvider> getProviders() {
    LibraryPresentationProvider[] _extensions = LibraryPresentationProvider.EP_NAME.getExtensions();
    return ContainerUtil.<LibraryPresentationProvider, XtendLibraryPresentationProvider>findAll(_extensions, XtendLibraryPresentationProvider.class);
  }
}
