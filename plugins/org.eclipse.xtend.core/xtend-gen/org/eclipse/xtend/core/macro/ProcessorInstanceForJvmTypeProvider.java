package org.eclipse.xtend.core.macro;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class ProcessorInstanceForJvmTypeProvider {
  private ClassLoader _classLoaderToUse = new Function0<ClassLoader>() {
    public ClassLoader apply() {
      ClassLoader _classLoader = ProcessorInstanceForJvmTypeProvider.class.getClassLoader();
      return _classLoader;
    }
  }.apply();
  
  public ClassLoader getClassLoaderToUse() {
    return this._classLoaderToUse;
  }
  
  public void setClassLoaderToUse(final ClassLoader classLoaderToUse) {
    this._classLoaderToUse = classLoaderToUse;
  }
  
  /**
   * @return an instance of the given JvmType
   */
  public Object getProcessorInstance(final JvmType type) {
    try {
      ClassLoader _classLoaderToUse = this.getClassLoaderToUse();
      String _identifier = type.getIdentifier();
      final Class<? extends Object> loadClass = _classLoaderToUse.loadClass(_identifier);
      try {
        return loadClass.newInstance();
      } catch (Exception _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
