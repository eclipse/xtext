package org.eclipse.xtend.ide.macro;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class JdtBasedProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
  private final static Logger LOG = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(JdtBasedProcessorProvider.class);
      return _logger;
    }
  }.apply();
  
  public Object getProcessorInstance(final JvmType type) {
    try {
      Resource _eResource = type.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      Object _classpathURIContext = ((XtextResourceSet) _resourceSet).getClasspathURIContext();
      final IJavaProject project = ((IJavaProject) _classpathURIContext);
      IClasspathEntry[] _rawClasspath = project.getRawClasspath();
      final Function1<IClasspathEntry,URL> _function = new Function1<IClasspathEntry,URL>() {
          public URL apply(final IClasspathEntry it) {
            try {
              IPath _path = it.getPath();
              File _file = _path.toFile();
              URL _uRL = _file.toURL();
              return _uRL;
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      final List<URL> urls = ListExtensions.<IClasspathEntry, URL>map(((List<IClasspathEntry>)Conversions.doWrapArray(_rawClasspath)), _function);
      ClassLoader _classLoader = ProcessorInstanceForJvmTypeProvider.class.getClassLoader();
      URLClassLoader _uRLClassLoader = new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), _classLoader);
      final URLClassLoader classLoader = _uRLClassLoader;
      String _identifier = type.getIdentifier();
      final Class<? extends Object> result = classLoader.loadClass(_identifier);
      try {
        return result.newInstance();
      } catch (Exception _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        JdtBasedProcessorProvider.LOG.info(e);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
