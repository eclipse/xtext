/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.extensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class RootModelExtensions {
  public static Iterable<SourceFolder> getSourceFolders(final Module module) {
    ModuleRootManager _instance = ModuleRootManager.getInstance(module);
    ContentEntry[] _contentEntries = _instance.getContentEntries();
    final Function1<ContentEntry, List<SourceFolder>> _function = new Function1<ContentEntry, List<SourceFolder>>() {
      @Override
      public List<SourceFolder> apply(final ContentEntry it) {
        SourceFolder[] _sourceFolders = it.getSourceFolders();
        return IterableExtensions.<SourceFolder>toList(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders)));
      }
    };
    List<List<SourceFolder>> _map = ListExtensions.<ContentEntry, List<SourceFolder>>map(((List<ContentEntry>)Conversions.doWrapArray(_contentEntries)), _function);
    return Iterables.<SourceFolder>concat(_map);
  }
  
  public static Iterable<SourceFolder> getExistingSourceFolders(final Module module) {
    Iterable<SourceFolder> _sourceFolders = RootModelExtensions.getSourceFolders(module);
    final Function1<SourceFolder, Boolean> _function = new Function1<SourceFolder, Boolean>() {
      @Override
      public Boolean apply(final SourceFolder it) {
        VirtualFile _file = it.getFile();
        return Boolean.valueOf((!Objects.equal(_file, null)));
      }
    };
    return IterableExtensions.<SourceFolder>filter(_sourceFolders, _function);
  }
  
  public static String getRelativePath(final SourceFolder sourceFolder) {
    VirtualFile _file = sourceFolder.getFile();
    ContentEntry _contentEntry = sourceFolder.getContentEntry();
    VirtualFile _file_1 = _contentEntry.getFile();
    return VfsUtil.getRelativePath(_file, _file_1);
  }
}
