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
import java.util.ArrayList;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractScopeBasedSelectable extends AbstractCompoundSelectable {
  @Accessors({ AccessorType.PROTECTED_GETTER, AccessorType.PROTECTED_SETTER })
  private GlobalSearchScope scope;
  
  @Inject
  private ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex;
  
  protected Iterable<? extends ISelectable> getSelectables() {
    return this.getResourceDescriptions();
  }
  
  public IResourceDescription getResourceDescription(final URI uri) {
    Object _xblockexpression = null;
    {
      final BaseXtextFile psiFile = this.findFile(uri);
      boolean _notEquals = (!Objects.equal(psiFile, null));
      if (_notEquals) {
        return new PsiFileBasedResourceDescription(psiFile);
      }
      _xblockexpression = null;
    }
    return ((IResourceDescription)_xblockexpression);
  }
  
  public ArrayList<IResourceDescription> getResourceDescriptions() {
    ArrayList<IResourceDescription> _xblockexpression = null;
    {
      Project _project = this.scope.getProject();
      @Extension
      final PsiManager psiManager = PsiManager.getInstance(_project);
      final ArrayList<IResourceDescription> descriptions = CollectionLiterals.<IResourceDescription>newArrayList();
      final Function1<Collection<VirtualFile>, Boolean> _function = new Function1<Collection<VirtualFile>, Boolean>() {
        public Boolean apply(final Collection<VirtualFile> files) {
          boolean _xblockexpression = false;
          {
            final Function1<VirtualFile, PsiFile> _function = new Function1<VirtualFile, PsiFile>() {
              public PsiFile apply(final VirtualFile it) {
                return psiManager.findFile(it);
              }
            };
            Iterable<PsiFile> _map = IterableExtensions.<VirtualFile, PsiFile>map(files, _function);
            Iterable<BaseXtextFile> _filter = Iterables.<BaseXtextFile>filter(_map, BaseXtextFile.class);
            for (final BaseXtextFile xtextFile : _filter) {
              PsiFileBasedResourceDescription _psiFileBasedResourceDescription = new PsiFileBasedResourceDescription(xtextFile);
              descriptions.add(_psiFileBasedResourceDescription);
            }
            _xblockexpression = true;
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      this.processFiles(_function);
      _xblockexpression = descriptions;
    }
    return _xblockexpression;
  }
  
  public boolean isEmpty() {
    Boolean _xblockexpression = null;
    {
      final boolean[] emptinessCheck = { true };
      final Function1<Collection<VirtualFile>, Boolean> _function = new Function1<Collection<VirtualFile>, Boolean>() {
        public Boolean apply(final Collection<VirtualFile> files) {
          boolean _xblockexpression = false;
          {
            boolean _isEmpty = files.isEmpty();
            if (_isEmpty) {
              return true;
            }
            emptinessCheck[0] = false;
            _xblockexpression = false;
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      this.processFiles(_function);
      _xblockexpression = IterableExtensions.<Boolean>head(((Iterable<Boolean>)Conversions.doWrapArray(emptinessCheck)));
    }
    return (_xblockexpression).booleanValue();
  }
  
  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName qualifiedName, final boolean ignoreCase) {
    String _string = qualifiedName.toString();
    Project _project = this.scope.getProject();
    Collection<BaseXtextFile> _get = this.exportedObjectQualifiedNameIndex.get(_string, _project, this.scope);
    ArrayList<IEObjectDescription> _newArrayList = CollectionLiterals.<IEObjectDescription>newArrayList();
    final Function2<ArrayList<IEObjectDescription>, BaseXtextFile, ArrayList<IEObjectDescription>> _function = new Function2<ArrayList<IEObjectDescription>, BaseXtextFile, ArrayList<IEObjectDescription>>() {
      public ArrayList<IEObjectDescription> apply(final ArrayList<IEObjectDescription> allDescriptions, final BaseXtextFile xtextFile) {
        ArrayList<IEObjectDescription> _xblockexpression = null;
        {
          final PsiFileBasedResourceDescription resourceDescription = new PsiFileBasedResourceDescription(xtextFile);
          Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects(type, qualifiedName, ignoreCase);
          Iterables.<IEObjectDescription>addAll(allDescriptions, _exportedObjects);
          _xblockexpression = allDescriptions;
        }
        return _xblockexpression;
      }
    };
    return IterableExtensions.<BaseXtextFile, ArrayList<IEObjectDescription>>fold(_get, _newArrayList, _function);
  }
  
  protected BaseXtextFile findFile(final URI uri) {
    BaseXtextFile _xblockexpression = null;
    {
      final String fileName = uri.lastSegment();
      Project _project = this.scope.getProject();
      PsiFile[] _filesByName = FilenameIndex.getFilesByName(_project, fileName, this.scope);
      Iterable<BaseXtextFile> _filter = Iterables.<BaseXtextFile>filter(((Iterable<?>)Conversions.doWrapArray(_filesByName)), BaseXtextFile.class);
      final Function1<BaseXtextFile, Boolean> _function = new Function1<BaseXtextFile, Boolean>() {
        public Boolean apply(final BaseXtextFile it) {
          URI _uRI = it.getURI();
          return Boolean.valueOf(uri.equals(_uRI));
        }
      };
      _xblockexpression = IterableExtensions.<BaseXtextFile>findFirst(_filter, _function);
    }
    return _xblockexpression;
  }
  
  protected void processFiles(final Function1<? super Collection<VirtualFile>, ? extends Boolean> acceptor) {
    Iterable<FileType> _xtextLanguageFilesTypes = this.getXtextLanguageFilesTypes();
    for (final FileType fileType : _xtextLanguageFilesTypes) {
      Collection<VirtualFile> _files = FileTypeIndex.getFiles(fileType, this.scope);
      Boolean _apply = acceptor.apply(_files);
      boolean _not = (!(_apply).booleanValue());
      if (_not) {
        return;
      }
    }
  }
  
  protected Iterable<FileType> getXtextLanguageFilesTypes() {
    FileBasedIndex _instance = FileBasedIndex.getInstance();
    Project _project = this.scope.getProject();
    Collection<FileType> _allKeys = _instance.<FileType>getAllKeys(FileTypeIndex.NAME, _project);
    final Function1<FileType, Boolean> _function = new Function1<FileType, Boolean>() {
      public Boolean apply(final FileType it) {
        return Boolean.valueOf(AbstractScopeBasedSelectable.this.isXtextLanguage(it));
      }
    };
    return IterableExtensions.<FileType>filter(_allKeys, _function);
  }
  
  protected boolean isXtextLanguage(final FileType fileType) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (fileType instanceof LanguageFileType) {
        _matched=true;
        Language _language = ((LanguageFileType)fileType).getLanguage();
        _switchResult = (_language instanceof IXtextLanguage);
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  @Pure
  protected GlobalSearchScope getScope() {
    return this.scope;
  }
  
  protected void setScope(final GlobalSearchScope scope) {
    this.scope = scope;
  }
}
