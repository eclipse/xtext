/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;

@Singleton
@SuppressWarnings("all")
public class ProcessorInstanceForJvmTypeProvider {
  private final static Logger logger = Logger.getLogger(ProcessorInstanceForJvmTypeProvider.class);
  
  private ClassLoader classLoader;
  
  public void setClassLoader(final ClassLoader classLoader) {
    this.classLoader = classLoader;
  }
  
  /**
   * @return an instance of the given JvmType
   */
  public Object getProcessorInstance(final JvmType type) {
    try {
      ClassLoader _classLoader = this.getClassLoader(type);
      Class<? extends Object> _loadClass = null;
      if (_classLoader!=null) {
        String _identifier = type.getIdentifier();
        _loadClass=_classLoader.loadClass(_identifier);
      }
      final Class<? extends Object> loadClass = _loadClass;
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
        IllegalStateException _illegalStateException = new IllegalStateException(_plus_2, e);
        throw _illegalStateException;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected ClassLoader getClassLoader(final EObject ctx) {
    boolean _notEquals = (!Objects.equal(this.classLoader, null));
    if (_notEquals) {
      return this.classLoader;
    }
    Resource _eResource = ctx.eResource();
    final ResourceSet resourceSet = _eResource.getResourceSet();
    boolean _matched = false;
    if (!_matched) {
      if (resourceSet instanceof XtextResourceSet) {
        _matched=true;
        final Object classLoaderCtx = ((XtextResourceSet)resourceSet).getClasspathURIContext();
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (classLoaderCtx instanceof ClassLoader) {
            _matched_1=true;
            return ((ClassLoader)classLoaderCtx);
          }
        }
        if (!_matched_1) {
          if (classLoaderCtx instanceof Class) {
            _matched_1=true;
            return ((Class<? extends Object>)classLoaderCtx).getClassLoader();
          }
        }
      }
    }
    ProcessorInstanceForJvmTypeProvider.logger.info("No class loader configured. Trying with this class\' classloader.");
    Class<? extends ProcessorInstanceForJvmTypeProvider> _class = this.getClass();
    return _class.getClassLoader();
  }
}
