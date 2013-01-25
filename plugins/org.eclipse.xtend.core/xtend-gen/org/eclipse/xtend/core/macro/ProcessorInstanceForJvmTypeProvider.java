package org.eclipse.xtend.core.macro;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class ProcessorInstanceForJvmTypeProvider {
  private final static Logger logger = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(ProcessorInstanceForJvmTypeProvider.class);
      return _logger;
    }
  }.apply();
  
  /**
   * @return an instance of the given JvmType
   */
  public Object getProcessorInstance(final JvmType type) {
    try {
      ClassLoader _classLoader = this.getClassLoader(type);
      String _identifier = type.getIdentifier();
      final Class<? extends Object> loadClass = _classLoader==null?(Class<? extends Object>)null:_classLoader.loadClass(_identifier);
      try {
        return loadClass==null?(Object)null:loadClass.newInstance();
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _string = e.toString();
        ProcessorInstanceForJvmTypeProvider.logger.error(_string);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected ClassLoader getClassLoader(final EObject ctx) {
    Resource _eResource = ctx.eResource();
    final ResourceSet resourceSet = _eResource.getResourceSet();
    boolean _matched = false;
    if (!_matched) {
      if (resourceSet instanceof XtextResourceSet) {
        final XtextResourceSet _xtextResourceSet = (XtextResourceSet)resourceSet;
        _matched=true;
        final Object classLoaderCtx = _xtextResourceSet.getClasspathURIContext();
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (classLoaderCtx instanceof ClassLoader) {
            final ClassLoader _classLoader = (ClassLoader)classLoaderCtx;
            _matched_1=true;
            return _classLoader;
          }
        }
        if (!_matched_1) {
          if (classLoaderCtx instanceof Class) {
            final Class<?> _class = (Class<?>)classLoaderCtx;
            _matched_1=true;
            return _class.getClassLoader();
          }
        }
        Class<? extends Object> _class = classLoaderCtx==null?(Class<? extends Object>)null:classLoaderCtx.getClass();
        String _name = _class.getName();
        String _plus = ("Unsupported classloader context in resource set : " + _name);
        ProcessorInstanceForJvmTypeProvider.logger.error(_plus);
      }
    }
    return null;
  }
}
