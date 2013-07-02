package org.eclipse.xtend.core.macro.fsaccess;

import com.google.common.annotations.Beta;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.services.FolderHandle;

@Beta
@SuppressWarnings("all")
public interface FileSystemAccessImpl {
  public abstract FolderHandle getSourceFolder(final CompilationUnitImpl impl);
  
  public abstract FolderHandle getRootFolder(final CompilationUnitImpl impl);
  
  public abstract FolderHandle getTargetFolder(final CompilationUnitImpl impl);
}
