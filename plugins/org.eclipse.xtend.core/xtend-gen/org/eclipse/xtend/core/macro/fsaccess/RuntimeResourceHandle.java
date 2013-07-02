package org.eclipse.xtend.core.macro.fsaccess;

import java.io.File;
import org.eclipse.xtend.lib.macro.services.ResourceHandle;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class RuntimeResourceHandle implements ResourceHandle {
  protected final File file;
  
  public RuntimeResourceHandle(final File file) {
    this.file = file;
  }
  
  public boolean exists() {
    boolean _exists = this.file.exists();
    return _exists;
  }
  
  public String getName() {
    String _name = this.file.getName();
    return _name;
  }
  
  public String getPath() {
    try {
      String _canonicalPath = this.file.getCanonicalPath();
      return _canonicalPath;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
