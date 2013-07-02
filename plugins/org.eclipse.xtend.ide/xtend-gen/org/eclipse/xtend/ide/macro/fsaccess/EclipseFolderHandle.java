package org.eclipse.xtend.ide.macro.fsaccess;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend.ide.macro.fsaccess.EclipseFileHandle;
import org.eclipse.xtend.ide.macro.fsaccess.EclipseResourceHandle;
import org.eclipse.xtend.lib.macro.services.FileHandle;
import org.eclipse.xtend.lib.macro.services.FolderHandle;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class EclipseFolderHandle extends EclipseResourceHandle implements FolderHandle {
  public EclipseFolderHandle(final IProject project, final IPath path) {
    super(project, path);
  }
  
  public FileHandle getFile(final String path) {
    EclipseFileHandle _xblockexpression = null;
    {
      final IPath filePath = this.path.append(path);
      final IFolder folder = this.project.getFolder(filePath);
      boolean _exists = folder.exists();
      if (_exists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Given path is an existed folder (not a file): \'");
        IPath _location = folder.getLocation();
        IPath _makeAbsolute = _location.makeAbsolute();
        _builder.append(_makeAbsolute, "");
        _builder.append("\'.");
        IllegalStateException _illegalStateException = new IllegalStateException(_builder.toString());
        throw _illegalStateException;
      }
      EclipseFileHandle _eclipseFileHandle = new EclipseFileHandle(this.project, filePath);
      _xblockexpression = (_eclipseFileHandle);
    }
    return _xblockexpression;
  }
  
  public FolderHandle getFolder(final String path) {
    EclipseFolderHandle _xblockexpression = null;
    {
      final IPath filePath = this.path.append(path);
      final IFile file = this.project.getFile(filePath);
      boolean _exists = file.exists();
      if (_exists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Given path is an existed file (not a folder): \'");
        IPath _location = file.getLocation();
        IPath _makeAbsolute = _location.makeAbsolute();
        _builder.append(_makeAbsolute, "");
        _builder.append("\'.");
        IllegalStateException _illegalStateException = new IllegalStateException(_builder.toString());
        throw _illegalStateException;
      }
      EclipseFolderHandle _eclipseFolderHandle = new EclipseFolderHandle(this.project, filePath);
      _xblockexpression = (_eclipseFolderHandle);
    }
    return _xblockexpression;
  }
  
  public IResource getMember() {
    IFolder _folder = this.getFolder();
    return _folder;
  }
}
