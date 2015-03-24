/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.google.inject.Inject;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtilCore;
import java.io.File;
import java.util.List;
import javax.inject.Provider;
import javax.swing.JComponent;
import org.eclipse.xtend.core.idea.config.XtendLibraryDescription;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSupportConfigurable extends FrameworkSupportInModuleConfigurable {
  @Inject
  private Provider<XtendLibraryDescription> libraryDescriptionProvider;
  
  @Override
  public void addSupport(final Module module, final ModifiableRootModel rootModel, final ModifiableModelsProvider modifiableModelsProvider) {
    String _moduleFilePath = module.getModuleFilePath();
    File _file = new File(_moduleFilePath);
    File _parentFile = _file.getParentFile();
    final File output = new File(_parentFile, "xtend-gen");
    String _path = output.getPath();
    String _systemIndependentName = FileUtil.toSystemIndependentName(_path);
    final String url = VfsUtilCore.pathToUrl(_systemIndependentName);
    ContentEntry[] _contentEntries = rootModel.getContentEntries();
    final Function1<ContentEntry, Boolean> _function = new Function1<ContentEntry, Boolean>() {
      @Override
      public Boolean apply(final ContentEntry it) {
        SourceFolder[] _sourceFolders = it.getSourceFolders();
        boolean _isEmpty = ((List<SourceFolder>)Conversions.doWrapArray(_sourceFolders)).isEmpty();
        return Boolean.valueOf((!_isEmpty));
      }
    };
    ContentEntry _findFirst = IterableExtensions.<ContentEntry>findFirst(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)), _function);
    _findFirst.addSourceFolder(url, false);
    boolean _and = false;
    boolean _exists = output.exists();
    boolean _not = (!_exists);
    if (!_not) {
      _and = false;
    } else {
      boolean _mkdirs = output.mkdirs();
      _and = _mkdirs;
    }
    if (_and) {
      LocalFileSystem _instance = LocalFileSystem.getInstance();
      _instance.refreshAndFindFileByIoFile(output);
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
