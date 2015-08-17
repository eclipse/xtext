/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeId;
import com.intellij.facet.FacetTypeRegistry;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import javax.inject.Provider;
import javax.swing.JComponent;
import org.eclipse.xtend.core.idea.config.XtendLibraryDescription;
import org.eclipse.xtend.core.idea.config.XtendLibraryManager;
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSupportConfigurable extends FrameworkSupportInModuleConfigurable {
  @Inject
  private Provider<XtendLibraryDescription> libraryDescriptionProvider;
  
  @Inject
  private XtendLibraryManager xtendLibManager;
  
  @Override
  public void addSupport(final Module module, final ModifiableRootModel rootModel, final ModifiableModelsProvider modifiableModelsProvider) {
    ContentEntry[] _contentEntries = rootModel.getContentEntries();
    final ContentEntry entry = IterableExtensions.<ContentEntry>head(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)));
    SourceFolder[] _sourceFolders = entry.getSourceFolders();
    final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        boolean _and = false;
        boolean _isTestSource = it.isTestSource();
        boolean _not = (!_isTestSource);
        if (!_not) {
          _and = false;
        } else {
          VirtualFile _file = it.getFile();
          boolean _exists = false;
          if (_file!=null) {
            _exists=_file.exists();
          }
          _and = _exists;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<SourceFolder> _filter = IterableExtensions.<SourceFolder>filter(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders)), _function);
    final SourceFolder mainSrc = IterableExtensions.<SourceFolder>head(_filter);
    VirtualFile xtendGenMain = this.createOrGetInParentDir(mainSrc, "xtend-gen");
    boolean _notEquals = (!Objects.equal(xtendGenMain, null));
    if (_notEquals) {
      JpsJavaExtensionService _instance = JpsJavaExtensionService.getInstance();
      final JavaSourceRootProperties properties = _instance.createSourceRootProperties("", true);
      entry.<JavaSourceRootProperties>addSourceFolder(xtendGenMain, JavaSourceRootType.SOURCE, properties);
    }
    SourceFolder[] _sourceFolders_1 = entry.getSourceFolders();
    final Function1<SourceFolder, Boolean> _function_1 = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        boolean _and = false;
        boolean _isTestSource = it.isTestSource();
        if (!_isTestSource) {
          _and = false;
        } else {
          VirtualFile _file = it.getFile();
          boolean _exists = false;
          if (_file!=null) {
            _exists=_file.exists();
          }
          _and = _exists;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<SourceFolder> _filter_1 = IterableExtensions.<SourceFolder>filter(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders_1)), _function_1);
    final SourceFolder testSrc = IterableExtensions.<SourceFolder>head(_filter_1);
    VirtualFile xtendGenTest = this.createOrGetInParentDir(testSrc, "xtend-gen");
    boolean _notEquals_1 = (!Objects.equal(xtendGenTest, null));
    if (_notEquals_1) {
      JpsJavaExtensionService _instance_1 = JpsJavaExtensionService.getInstance();
      final JavaSourceRootProperties properties_1 = _instance_1.createSourceRootProperties("", true);
      entry.<JavaSourceRootProperties>addSourceFolder(xtendGenTest, JavaSourceRootType.TEST_SOURCE, properties_1);
    }
    FacetTypeRegistry _instance_2 = FacetTypeRegistry.getInstance();
    String _iD = XtendLanguage.INSTANCE.getID();
    final FacetType facetType = _instance_2.findFacetType(_iD);
    if ((facetType == null)) {
      return;
    }
    final FacetManager mnr = FacetManager.getInstance(module);
    Facet _elvis = null;
    FacetTypeId _id = facetType.getId();
    String _defaultFacetName = facetType.getDefaultFacetName();
    Facet _findFacet = mnr.<Facet>findFacet(_id, _defaultFacetName);
    if (_findFacet != null) {
      _elvis = _findFacet;
    } else {
      FacetManager _instance_3 = FacetManager.getInstance(module);
      String _defaultFacetName_1 = facetType.getDefaultFacetName();
      Facet _addFacet = _instance_3.<Facet, FacetConfiguration>addFacet(facetType, _defaultFacetName_1, null);
      _elvis = _addFacet;
    }
    Facet facet = _elvis;
    FacetConfiguration _configuration = facet.getConfiguration();
    final XtendFacetConfiguration conf = ((XtendFacetConfiguration) _configuration);
    final XbaseGeneratorConfigurationState state = conf.getState();
    boolean _notEquals_2 = (!Objects.equal(xtendGenMain, null));
    if (_notEquals_2) {
      String _canonicalPath = xtendGenMain.getCanonicalPath();
      state.setOutputDirectory(_canonicalPath);
    }
    boolean _notEquals_3 = (!Objects.equal(xtendGenTest, null));
    if (_notEquals_3) {
      String _canonicalPath_1 = xtendGenTest.getCanonicalPath();
      state.setTestOutputDirectory(_canonicalPath_1);
    }
    this.xtendLibManager.ensureXtendLibAvailable(rootModel, module);
  }
  
  public VirtualFile createOrGetInParentDir(final SourceFolder sibling, final String relativePath) {
    try {
      VirtualFile _xblockexpression = null;
      {
        VirtualFile _file = null;
        if (sibling!=null) {
          _file=sibling.getFile();
        }
        VirtualFile _parent = null;
        if (_file!=null) {
          _parent=_file.getParent();
        }
        final VirtualFile parent = _parent;
        if ((parent == null)) {
          return null;
        }
        _xblockexpression = VfsUtil.createDirectoryIfMissing(parent, relativePath);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public JComponent createComponent() {
    return null;
  }
  
  @Override
  public CustomLibraryDescription createLibraryDescription() {
    return this.libraryDescriptionProvider.get();
  }
}
