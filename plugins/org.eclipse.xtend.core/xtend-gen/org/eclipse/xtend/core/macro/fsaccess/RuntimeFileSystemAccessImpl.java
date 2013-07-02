package org.eclipse.xtend.core.macro.fsaccess;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.fsaccess.FileSystemAccessImpl;
import org.eclipse.xtend.lib.macro.services.FileSystemAccess;
import org.eclipse.xtend.lib.macro.services.FolderHandle;

/**
 * <p>
 * This class is the stub for the Runtime mode.
 * </p><p>
 * Currently {@link FileSystemAccess} is used only in the context of active annotations processing with Eclipse or Maven.</p>
 */
@SuppressWarnings("all")
public class RuntimeFileSystemAccessImpl implements FileSystemAccessImpl {
  public FolderHandle getSourceFolder(final CompilationUnitImpl impl) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("FileSystemAccess is not supported in the Runtime mode");
    throw _unsupportedOperationException;
  }
  
  public FolderHandle getRootFolder(final CompilationUnitImpl impl) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("FileSystemAccess is not supported in the Runtime mode");
    throw _unsupportedOperationException;
  }
  
  public FolderHandle getTargetFolder(final CompilationUnitImpl impl) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("FileSystemAccess is not supported in the Runtime mode");
    throw _unsupportedOperationException;
  }
}
