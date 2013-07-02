package org.eclipse.xtend.core.macro.fsaccess;

import com.google.common.annotations.Beta;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.services.FolderHandle;

@Beta
@SuppressWarnings("all")
public interface FileSystemAccessImpl {
  @NonNull
  public abstract FolderHandle getSourceFolder(final CompilationUnitImpl impl);
  
  @NonNull
  public abstract FolderHandle getRootFolder(final CompilationUnitImpl impl);
  
  @NonNull
  public abstract FolderHandle getTargetFolder(final CompilationUnitImpl impl);
}
