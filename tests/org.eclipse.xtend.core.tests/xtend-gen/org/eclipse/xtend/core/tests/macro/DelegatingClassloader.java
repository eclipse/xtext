package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class DelegatingClassloader extends ClassLoader {
  private Function1<? super String,? extends Class<? extends Object>> classFinder;
  
  public DelegatingClassloader(final ClassLoader parent, final Function1<? super String,? extends Class<? extends Object>> classFinder) {
    super(parent);
    this.classFinder = classFinder;
  }
  
  public Class<? extends Object> findClass(final String name) throws ClassNotFoundException {
    Class<? extends Object> _xblockexpression = null;
    {
      final Class<? extends Object> result = this.classFinder.apply(name);
      boolean _notEquals = ObjectExtensions.operator_notEquals(result, null);
      if (_notEquals) {
        return result;
      }
      Class<? extends Object> _findClass = super.findClass(name);
      _xblockexpression = (_findClass);
    }
    return _xblockexpression;
  }
  
  public Class<? extends Object> loadClass(final String name) throws ClassNotFoundException {
    Class<? extends Object> _loadClass = super.loadClass(name);
    return _loadClass;
  }
}
