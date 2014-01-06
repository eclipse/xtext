package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

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
      boolean _notEquals = (!Objects.equal(result, null));
      if (_notEquals) {
        return result;
      }
      _xblockexpression = (super.findClass(name));
    }
    return _xblockexpression;
  }
  
  public Class<? extends Object> loadClass(final String name) throws ClassNotFoundException {
    return super.loadClass(name);
  }
}
