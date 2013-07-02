package org.eclipse.xtend.core.macro.fsaccess;

import com.google.common.base.Objects;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.fsaccess.FileSystemAccessImpl;
import org.eclipse.xtend.lib.macro.services.FolderHandle;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public abstract class AbstractFileSystemAccessImpl implements FileSystemAccessImpl {
  public final FolderHandle getSourceFolder(final CompilationUnitImpl it) {
    final Function0<FolderHandle> _function = new Function0<FolderHandle>() {
        public FolderHandle apply() {
          FolderHandle _doGetSourceFolder = AbstractFileSystemAccessImpl.this.doGetSourceFolder(it);
          return _doGetSourceFolder;
        }
      };
    FolderHandle _folder = this.getFolder(_function, "source");
    return _folder;
  }
  
  public abstract FolderHandle doGetSourceFolder(final CompilationUnitImpl it);
  
  public final FolderHandle getRootFolder(final CompilationUnitImpl it) {
    final Function0<FolderHandle> _function = new Function0<FolderHandle>() {
        public FolderHandle apply() {
          FolderHandle _doGetRootFolder = AbstractFileSystemAccessImpl.this.doGetRootFolder(it);
          return _doGetRootFolder;
        }
      };
    FolderHandle _folder = this.getFolder(_function, "root");
    return _folder;
  }
  
  public abstract FolderHandle doGetRootFolder(final CompilationUnitImpl it);
  
  public final FolderHandle getTargetFolder(final CompilationUnitImpl it) {
    final Function0<FolderHandle> _function = new Function0<FolderHandle>() {
        public FolderHandle apply() {
          FolderHandle _doGetTargetFolder = AbstractFileSystemAccessImpl.this.doGetTargetFolder(it);
          return _doGetTargetFolder;
        }
      };
    FolderHandle _folder = this.getFolder(_function, "target");
    return _folder;
  }
  
  public abstract FolderHandle doGetTargetFolder(final CompilationUnitImpl it);
  
  private FolderHandle getFolder(final Function0<? extends FolderHandle> it, final String folderType) {
    FolderHandle _xblockexpression = null;
    {
      final FolderHandle folder = it.apply();
      boolean _equals = Objects.equal(folder, null);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Could not find ");
        _builder.append(folderType, "");
        _builder.append(" folder.");
        IllegalStateException _illegalStateException = new IllegalStateException(_builder.toString());
        throw _illegalStateException;
      }
      _xblockexpression = (folder);
    }
    return _xblockexpression;
  }
}
