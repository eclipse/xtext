/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractScopeBasedSelectable extends AbstractCompoundSelectable {
  @Accessors({ AccessorType.PROTECTED_GETTER, AccessorType.PROTECTED_SETTER })
  private GlobalSearchScope scope;
  
  @Inject
  private ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex;
  
  @Override
  protected Iterable<? extends ISelectable> getSelectables() {
    return this.getResourceDescriptions();
  }
  
  public IResourceDescription getResourceDescription(final URI uri) {
    BaseXtextFile _findFile = this.findFile(uri);
    return this.toResourceDescription(_findFile);
  }
  
  public Iterable<IResourceDescription> getResourceDescriptions() {
    Iterable<IResourceDescription> _xblockexpression = null;
    {
      Project _project = this.scope.getProject();
      @Extension
      final PsiManager psiManager = PsiManager.getInstance(_project);
      Iterable<VirtualFile> _allXtextVirtualFiles = this.getAllXtextVirtualFiles();
      final Function1<VirtualFile, PsiFile> _function = new Function1<VirtualFile, PsiFile>() {
        @Override
        public PsiFile apply(final VirtualFile it) {
          return psiManager.findFile(it);
        }
      };
      Iterable<PsiFile> _map = IterableExtensions.<VirtualFile, PsiFile>map(_allXtextVirtualFiles, _function);
      Iterable<BaseXtextFile> _filter = Iterables.<BaseXtextFile>filter(_map, BaseXtextFile.class);
      final Function1<BaseXtextFile, IResourceDescription> _function_1 = new Function1<BaseXtextFile, IResourceDescription>() {
        @Override
        public IResourceDescription apply(final BaseXtextFile it) {
          return AbstractScopeBasedSelectable.this.toResourceDescription(it);
        }
      };
      _xblockexpression = IterableExtensions.<BaseXtextFile, IResourceDescription>map(_filter, _function_1);
    }
    return _xblockexpression;
  }
  
  @Override
  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName qualifiedName, final boolean ignoreCase) {
    String _string = qualifiedName.toString();
    Project _project = this.scope.getProject();
    Collection<BaseXtextFile> _get = this.exportedObjectQualifiedNameIndex.get(_string, _project, this.scope);
    final Function1<BaseXtextFile, Iterable<IEObjectDescription>> _function = new Function1<BaseXtextFile, Iterable<IEObjectDescription>>() {
      @Override
      public Iterable<IEObjectDescription> apply(final BaseXtextFile it) {
        IResourceDescription _resourceDescription = AbstractScopeBasedSelectable.this.toResourceDescription(it);
        return _resourceDescription.getExportedObjects(type, qualifiedName, ignoreCase);
      }
    };
    Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<BaseXtextFile, Iterable<IEObjectDescription>>map(_get, _function);
    return Iterables.<IEObjectDescription>concat(_map);
  }
  
  protected IResourceDescription toResourceDescription(final BaseXtextFile xtextFile) {
    PsiFileBasedResourceDescription _xifexpression = null;
    boolean _notEquals = (!Objects.equal(xtextFile, null));
    if (_notEquals) {
      _xifexpression = new PsiFileBasedResourceDescription(xtextFile);
    }
    return _xifexpression;
  }
  
  protected BaseXtextFile findFile(final URI uri) {
    BaseXtextFile _xblockexpression = null;
    {
      final String fileName = uri.lastSegment();
      Project _project = this.scope.getProject();
      PsiFile[] _filesByName = FilenameIndex.getFilesByName(_project, fileName, this.scope);
      Iterable<BaseXtextFile> _filter = Iterables.<BaseXtextFile>filter(((Iterable<?>)Conversions.doWrapArray(_filesByName)), BaseXtextFile.class);
      final Function1<BaseXtextFile, Boolean> _function = new Function1<BaseXtextFile, Boolean>() {
        @Override
        public Boolean apply(final BaseXtextFile it) {
          URI _uRI = it.getURI();
          return Boolean.valueOf(uri.equals(_uRI));
        }
      };
      _xblockexpression = IterableExtensions.<BaseXtextFile>findFirst(_filter, _function);
    }
    return _xblockexpression;
  }
  
  protected Iterable<VirtualFile> getAllXtextVirtualFiles() {
    Iterable<FileType> _xtextLanguageFilesTypes = this.getXtextLanguageFilesTypes();
    final Function1<FileType, Collection<VirtualFile>> _function = new Function1<FileType, Collection<VirtualFile>>() {
      @Override
      public Collection<VirtualFile> apply(final FileType fileType) {
        return FileTypeIndex.getFiles(fileType, AbstractScopeBasedSelectable.this.scope);
      }
    };
    Iterable<Collection<VirtualFile>> _map = IterableExtensions.<FileType, Collection<VirtualFile>>map(_xtextLanguageFilesTypes, _function);
    return Iterables.<VirtualFile>concat(_map);
  }
  
  protected Iterable<FileType> getXtextLanguageFilesTypes() {
    FileBasedIndex _instance = FileBasedIndex.getInstance();
    Project _project = this.scope.getProject();
    Collection<FileType> _allKeys = _instance.<FileType>getAllKeys(FileTypeIndex.NAME, _project);
    final Function1<FileType, Boolean> _function = new Function1<FileType, Boolean>() {
      @Override
      public Boolean apply(final FileType it) {
        return Boolean.valueOf(AbstractScopeBasedSelectable.this.isXtextLanguage(it));
      }
    };
    return IterableExtensions.<FileType>filter(_allKeys, _function);
  }
  
  protected boolean isXtextLanguage(final FileType fileType) {
    boolean _xifexpression = false;
    if ((fileType instanceof LanguageFileType)) {
      Language _language = ((LanguageFileType)fileType).getLanguage();
      _xifexpression = (_language instanceof IXtextLanguage);
    }
    return _xifexpression;
  }
  
  @Pure
  protected GlobalSearchScope getScope() {
    return this.scope;
  }
  
  protected void setScope(final GlobalSearchScope scope) {
    this.scope = scope;
  }
}
