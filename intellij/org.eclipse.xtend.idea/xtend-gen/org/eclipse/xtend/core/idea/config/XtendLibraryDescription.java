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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.swing.JComponent;
import org.eclipse.xtend.core.idea.config.XtendLibraryPresentationProvider;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

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
  
  public final static String XTEND_LIBRARY_NAME = "Xtend Library";
  
  @Override
  public NewLibraryConfiguration createNewLibrary(final JComponent parentComponent, final VirtualFile contextDirectory) {
    return this.createLibraryDescription();
  }
  
  public NewLibraryConfiguration createLibraryDescription() {
    abstract class __XtendLibraryDescription_1 extends NewLibraryConfiguration {
      __XtendLibraryDescription_1(@NotNull final String defaultLibraryName) {
        super(defaultLibraryName);
      }
      
      HashMap<OrderRootType, List<String>> roots;
    }
    
    List<XtendLibraryPresentationProvider> _providers = XtendLibraryDescription.getProviders();
    final XtendLibraryPresentationProvider provider = IterableExtensions.<XtendLibraryPresentationProvider>head(_providers);
    boolean _equals = Objects.equal(provider, null);
    if (_equals) {
      return null;
    }
    return new __XtendLibraryDescription_1(XtendLibraryDescription.XTEND_LIBRARY_NAME) {
      {
        roots = XtendLibraryDescription.this.libraryRoots();
      }
      @Override
      public void addRoots(final LibraryEditor editor) {
        final Procedure2<OrderRootType, List<String>> _function = new Procedure2<OrderRootType, List<String>>() {
          @Override
          public void apply(final OrderRootType k, final List<String> v) {
            final Procedure1<String> _function = new Procedure1<String>() {
              @Override
              public void apply(final String it) {
                editor.addRoot(it, k);
              }
            };
            IterableExtensions.<String>forEach(v, _function);
          }
        };
        MapExtensions.<OrderRootType, List<String>>forEach(this.roots, _function);
      }
    };
  }
  
  @Override
  public Set<? extends LibraryKind> getSuitableLibraryKinds() {
    return XtendLibraryDescription.LIBRARY_KINDS;
  }
  
  public HashMap<OrderRootType, List<String>> libraryRoots() {
    final HashMap<OrderRootType, List<String>> roots = CollectionLiterals.<OrderRootType, List<String>>newHashMap();
    String _urlForLibraryRoot = this.getUrlForLibraryRoot(Lists.class);
    String _urlForLibraryRoot_1 = this.getUrlForLibraryRoot(ToStringBuilder.class);
    String _urlForLibraryRoot_2 = this.getUrlForLibraryRoot(Active.class);
    String _urlForLibraryRoot_3 = this.getUrlForLibraryRoot(Data.class);
    roots.put(OrderRootType.CLASSES, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_urlForLibraryRoot, _urlForLibraryRoot_1, _urlForLibraryRoot_2, _urlForLibraryRoot_3)));
    return roots;
  }
  
  @Override
  public LibrariesContainer.LibraryLevel getDefaultLevel() {
    return LibrariesContainer.LibraryLevel.PROJECT;
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
