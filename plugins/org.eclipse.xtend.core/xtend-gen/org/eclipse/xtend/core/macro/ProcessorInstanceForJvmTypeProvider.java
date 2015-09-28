/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import java.io.Closeable;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.internal.AlternateJdkLoader;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Singleton
@SuppressWarnings("all")
public class ProcessorInstanceForJvmTypeProvider {
  @Accessors
  public static class ProcessorClassloaderAdapter extends AdapterImpl {
    private ClassLoader classLoader;
    
    public ProcessorClassloaderAdapter(final ClassLoader classLoader) {
      this.classLoader = classLoader;
    }
    
    @Override
    public boolean isAdapterForType(final Object type) {
      return Objects.equal(type, ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter.class);
    }
    
    @Override
    public void unsetTarget(final Notifier oldTarget) {
      this.discard();
    }
    
    @Override
    public void setTarget(final Notifier newTarget) {
      boolean _equals = Objects.equal(newTarget, null);
      if (_equals) {
        this.discard();
      }
    }
    
    public ClassLoader discard() {
      ClassLoader _xifexpression = null;
      if ((this.classLoader instanceof Closeable)) {
        ClassLoader _xtrycatchfinallyexpression = null;
        try {
          ClassLoader _xblockexpression = null;
          {
            ((Closeable) this.classLoader).close();
            _xblockexpression = this.classLoader = null;
          }
          _xtrycatchfinallyexpression = _xblockexpression;
        } catch (final Throwable _t) {
          if (_t instanceof IOException) {
            final IOException e = (IOException)_t;
            String _message = e.getMessage();
            ProcessorInstanceForJvmTypeProvider.logger.error(_message, e);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xifexpression = _xtrycatchfinallyexpression;
      }
      return _xifexpression;
    }
    
    @Pure
    public ClassLoader getClassLoader() {
      return this.classLoader;
    }
    
    public void setClassLoader(final ClassLoader classLoader) {
      this.classLoader = classLoader;
    }
  }
  
  private final static Logger logger = Logger.getLogger(ProcessorInstanceForJvmTypeProvider.class);
  
  /**
   * @return an instance of the given JvmType
   */
  public Object getProcessorInstance(final JvmType type) {
    try {
      ClassLoader _classLoader = this.getClassLoader(type);
      Class<?> _loadClass = null;
      if (_classLoader!=null) {
        String _identifier = type.getIdentifier();
        _loadClass=_classLoader.loadClass(_identifier);
      }
      final Class<?> loadClass = _loadClass;
      Object _newInstance = null;
      if (loadClass!=null) {
        _newInstance=loadClass.newInstance();
      }
      return _newInstance;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _identifier_1 = type.getIdentifier();
        String _plus = ("Problem during instantiation of " + _identifier_1);
        String _plus_1 = (_plus + " : ");
        String _message = e.getMessage();
        String _plus_2 = (_plus_1 + _message);
        throw new IllegalStateException(_plus_2, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected ClassLoader getClassLoader(final EObject ctx) {
    Resource _eResource = ctx.eResource();
    final ResourceSet resourceSet = _eResource.getResourceSet();
    EList<Adapter> _eAdapters = resourceSet.eAdapters();
    Iterable<ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter> _filter = Iterables.<ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter>filter(_eAdapters, ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter.class);
    final ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter adapter = IterableExtensions.<ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter>head(_filter);
    boolean _notEquals = (!Objects.equal(adapter, null));
    if (_notEquals) {
      return adapter.getClassLoader();
    }
    boolean _matched = false;
    if (!_matched) {
      if (resourceSet instanceof XtextResourceSet) {
        _matched=true;
        final Object classLoaderCtx = ((XtextResourceSet)resourceSet).getClasspathURIContext();
        ClassLoader _switchResult_1 = null;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (classLoaderCtx instanceof ClassLoader) {
            _matched_1=true;
            _switchResult_1 = ((ClassLoader)classLoaderCtx);
          }
        }
        if (!_matched_1) {
          if (classLoaderCtx instanceof Class) {
            _matched_1=true;
            _switchResult_1 = ((Class<?>)classLoaderCtx).getClassLoader();
          }
        }
        final ClassLoader jvmTypeLoader = _switchResult_1;
        ClassLoader _xifexpression = null;
        if ((jvmTypeLoader instanceof URLClassLoader)) {
          URLClassLoader _xblockexpression = null;
          {
            final ArrayList<URL> urls = CollectionLiterals.<URL>newArrayList();
            URL[] _uRLs = ((URLClassLoader)jvmTypeLoader).getURLs();
            Iterables.<URL>addAll(urls, ((Iterable<? extends URL>)Conversions.doWrapArray(_uRLs)));
            final ClassLoader bootClassloader = ((URLClassLoader)jvmTypeLoader).getParent();
            if ((bootClassloader instanceof AlternateJdkLoader)) {
              URL[] _uRLs_1 = ((AlternateJdkLoader)bootClassloader).getURLs();
              Iterables.<URL>addAll(urls, ((Iterable<? extends URL>)Conversions.doWrapArray(_uRLs_1)));
            }
            ClassLoader _classLoader = TransformationContext.class.getClassLoader();
            _xblockexpression = new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), _classLoader);
          }
          _xifexpression = _xblockexpression;
        } else {
          _xifexpression = jvmTypeLoader;
        }
        final ClassLoader processorClassLoader = _xifexpression;
        boolean _notEquals_1 = (!Objects.equal(processorClassLoader, null));
        if (_notEquals_1) {
          EList<Adapter> _eAdapters_1 = ((XtextResourceSet)resourceSet).eAdapters();
          ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter _processorClassloaderAdapter = new ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter(processorClassLoader);
          _eAdapters_1.add(_processorClassloaderAdapter);
          return processorClassLoader;
        }
      }
    }
    ProcessorInstanceForJvmTypeProvider.logger.info("No class loader configured. Trying with this class classloader.");
    Class<? extends ProcessorInstanceForJvmTypeProvider> _class = this.getClass();
    return _class.getClassLoader();
  }
}
