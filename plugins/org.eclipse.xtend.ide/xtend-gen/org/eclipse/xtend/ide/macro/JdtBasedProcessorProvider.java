package org.eclipse.xtend.ide.macro;

import com.google.common.base.Objects;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

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
      String _identifier = type.getIdentifier();
      final ClassLoader classLoader = this.createClassLoader(_identifier, project);
      String _identifier_1 = type.getIdentifier();
      final Class<? extends Object> result = classLoader.loadClass(_identifier_1);
      try {
        return result.newInstance();
      } catch (Throwable _e) {
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
  
  protected ClassLoader createClassLoader(final String typeName, final IJavaProject javaProject) {
    try {
      final IType type = javaProject.findType(typeName);
      boolean _equals = Objects.equal(type, null);
      if (_equals) {
        Class<? extends JdtBasedProcessorProvider> _class = this.getClass();
        return _class.getClassLoader();
      }
      final IJavaProject projectToUse = type.getJavaProject();
      final IClasspathEntry[] resolvedClasspath = projectToUse.getResolvedClasspath(true);
      final List<URL> urls = CollectionLiterals.<URL>newArrayList();
      List<URL> _outputFolders = this.getOutputFolders(projectToUse);
      urls.addAll(_outputFolders);
      for (final IClasspathEntry entry : resolvedClasspath) {
        {
          IPath path = null;
          URL url = null;
          int _entryKind = entry.getEntryKind();
          final int _switchValue = _entryKind;
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(_switchValue,IClasspathEntry.CPE_SOURCE)) {
              _matched=true;
            }
          }
          if (!_matched) {
            if (Objects.equal(_switchValue,IClasspathEntry.CPE_PROJECT)) {
              _matched=true;
              IProject _project = projectToUse.getProject();
              IWorkspace _workspace = _project.getWorkspace();
              IWorkspaceRoot _root = _workspace.getRoot();
              IPath _path = entry.getPath();
              final IResource project = _root.findMember(_path);
              IProject _project_1 = project.getProject();
              IJavaProject _create = JavaCore.create(_project_1);
              List<URL> _outputFolders_1 = this.getOutputFolders(_create);
              urls.addAll(_outputFolders_1);
            }
          }
          if (!_matched) {
            {
              IPath _path_1 = entry.getPath();
              path = _path_1;
              File _file = path.toFile();
              URI _uRI = _file.toURI();
              URL _uRL = _uRI.toURL();
              url = _uRL;
            }
          }
          boolean _notEquals = (!Objects.equal(url, null));
          if (_notEquals) {
            urls.add(url);
          }
        }
      }
      Class<? extends JdtBasedProcessorProvider> _class_1 = this.getClass();
      ClassLoader _classLoader = _class_1.getClassLoader();
      URLClassLoader _uRLClassLoader = new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), _classLoader);
      return _uRLClassLoader;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private List<URL> getOutputFolders(final IJavaProject javaProject) {
    try {
      final List<URL> result = CollectionLiterals.<URL>newArrayList();
      IPath _outputLocation = javaProject.getOutputLocation();
      IPath path = _outputLocation.addTrailingSeparator();
      String _string = path.toString();
      org.eclipse.emf.common.util.URI _createPlatformResourceURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(_string, true);
      String _string_1 = _createPlatformResourceURI.toString();
      URL _uRL = new URL(_string_1);
      URL url = _uRL;
      result.add(url);
      IClasspathEntry[] _rawClasspath = javaProject.getRawClasspath();
      for (final IClasspathEntry entry : _rawClasspath) {
        int _entryKind = entry.getEntryKind();
        final int _switchValue = _entryKind;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_switchValue,IClasspathEntry.CPE_SOURCE)) {
            _matched=true;
            IPath _outputLocation_1 = entry.getOutputLocation();
            path = _outputLocation_1;
            boolean _notEquals = (!Objects.equal(path, null));
            if (_notEquals) {
              IPath _addTrailingSeparator = path.addTrailingSeparator();
              String _string_2 = _addTrailingSeparator.toString();
              org.eclipse.emf.common.util.URI _createPlatformResourceURI_1 = org.eclipse.emf.common.util.URI.createPlatformResourceURI(_string_2, true);
              String _string_3 = _createPlatformResourceURI_1.toString();
              URL _uRL_1 = new URL(_string_3);
              url = _uRL_1;
              result.add(url);
            }
          }
        }
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
