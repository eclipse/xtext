/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.utils.GenModelHelper;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;

/**
 * @noextend
 */
@Log
@SuppressWarnings("all")
public class XtextLanguageStandaloneSetup implements IGuiceAwareGeneratorComponent {
  @Accessors
  private List<String> loadedResources = CollectionLiterals.<String>newArrayList();
  
  @Inject
  private IXtextGeneratorLanguage language;
  
  public void addLoadedResource(final String uri) {
    this.loadedResources.add(uri);
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
    ResourceSet _resourceSet = this.language.getResourceSet();
    this.setup(_resourceSet);
  }
  
  private void setup(final ResourceSet resourceSet) {
    final StandaloneSetup delegate = new StandaloneSetup();
    delegate.setResourceSet(resourceSet);
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        XtextLanguageStandaloneSetup.this.loadResource(it, resourceSet);
      }
    };
    IterableExtensions.<String>forEach(this.loadedResources, _function);
    this.registerGenModels(resourceSet);
    this.registerEPackages(resourceSet);
  }
  
  private Resource loadResource(final String loadedResource, final ResourceSet resourceSet) {
    Resource _xblockexpression = null;
    {
      final URI loadedResourceUri = URI.createURI(loadedResource);
      this.ensureResourceCanBeLoaded(loadedResourceUri, resourceSet);
      _xblockexpression = resourceSet.getResource(loadedResourceUri, true);
    }
    return _xblockexpression;
  }
  
  private Object ensureResourceCanBeLoaded(final URI loadedResource, final ResourceSet resourceSet) {
    Object _switchResult = null;
    String _fileExtension = loadedResource.fileExtension();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_fileExtension, "genmodel")) {
        _matched=true;
        Object _xblockexpression = null;
        {
          GenModelPackage.eINSTANCE.getEFactoryInstance();
          final IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
          Object _xifexpression = null;
          if ((resourceServiceProvider == null)) {
            Object _xtrycatchfinallyexpression = null;
            try {
              Object _xblockexpression_1 = null;
              {
                final Class<?> genModelSupport = Class.forName("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport");
                final Object instance = genModelSupport.newInstance();
                Method _declaredMethod = genModelSupport.getDeclaredMethod("createInjectorAndDoEMFRegistration");
                _xblockexpression_1 = _declaredMethod.invoke(instance);
              }
              _xtrycatchfinallyexpression = _xblockexpression_1;
            } catch (final Throwable _t) {
              if (_t instanceof ClassNotFoundException) {
                final ClassNotFoundException e = (ClassNotFoundException)_t;
                XtextLanguageStandaloneSetup.LOG.debug("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport not found, GenModels will not be indexed");
              } else if (_t instanceof Exception) {
                final Exception e_1 = (Exception)_t;
                XtextLanguageStandaloneSetup.LOG.error("Couldn\'t initialize GenModel support.", e_1);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            _xifexpression = _xtrycatchfinallyexpression;
          }
          _xblockexpression = _xifexpression;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (Objects.equal(_fileExtension, "ecore")) {
        _matched=true;
        final IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
        if ((resourceServiceProvider == null)) {
          EcoreSupportStandaloneSetup.setup();
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_fileExtension, "xcore")) {
        _matched=true;
        Object _xblockexpression_1 = null;
        {
          final IResourceServiceProvider resourceServiceProvider_1 = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
          if ((resourceServiceProvider_1 == null)) {
            try {
              final Class<?> xcore = Class.forName("org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup");
              Method _declaredMethod = xcore.getDeclaredMethod("doSetup", new Class[] {});
              _declaredMethod.invoke(null);
            } catch (final Throwable _t) {
              if (_t instanceof ClassNotFoundException) {
                final ClassNotFoundException e = (ClassNotFoundException)_t;
                XtextLanguageStandaloneSetup.LOG.error("Couldn\'t initialize Xcore support. Is it on the classpath?");
                String _message = e.getMessage();
                XtextLanguageStandaloneSetup.LOG.debug(_message, e);
              } else if (_t instanceof Exception) {
                final Exception e_1 = (Exception)_t;
                XtextLanguageStandaloneSetup.LOG.error("Couldn\'t initialize Xcore support.", e_1);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
          final URI xcoreLangURI = URI.createPlatformResourceURI("/org.eclipse.emf.ecore.xcore.lib/model/XcoreLang.xcore", true);
          Object _xtrycatchfinallyexpression = null;
          try {
            _xtrycatchfinallyexpression = resourceSet.getResource(xcoreLangURI, true);
          } catch (final Throwable _t_1) {
            if (_t_1 instanceof WrappedException) {
              final WrappedException e_2 = (WrappedException)_t_1;
              boolean _xblockexpression_2 = false;
              {
                XtextLanguageStandaloneSetup.LOG.error("Could not load XcoreLang.xcore.", e_2);
                final Resource brokenResource = resourceSet.getResource(xcoreLangURI, false);
                EList<Resource> _resources = resourceSet.getResources();
                _xblockexpression_2 = _resources.remove(brokenResource);
              }
              _xtrycatchfinallyexpression = Boolean.valueOf(_xblockexpression_2);
            } else {
              throw Exceptions.sneakyThrow(_t_1);
            }
          }
          _xblockexpression_1 = _xtrycatchfinallyexpression;
        }
        _switchResult = _xblockexpression_1;
      }
    }
    return _switchResult;
  }
  
  private void registerEPackages(final ResourceSet resourceSet) {
    EList<Resource> _resources = resourceSet.getResources();
    final Function1<Resource, EList<EObject>> _function = new Function1<Resource, EList<EObject>>() {
      @Override
      public EList<EObject> apply(final Resource it) {
        return it.getContents();
      }
    };
    List<EList<EObject>> _map = ListExtensions.<Resource, EList<EObject>>map(_resources, _function);
    Iterable<EObject> _flatten = Iterables.<EObject>concat(_map);
    Iterable<EPackage> _filter = Iterables.<EPackage>filter(_flatten, EPackage.class);
    final Procedure1<EPackage> _function_1 = new Procedure1<EPackage>() {
      @Override
      public void apply(final EPackage it) {
        XtextLanguageStandaloneSetup.this.registerEPackage(it);
      }
    };
    IterableExtensions.<EPackage>forEach(_filter, _function_1);
  }
  
  private void registerGenModels(final ResourceSet resourceSet) {
    EList<Resource> _resources = resourceSet.getResources();
    final Function1<Resource, EList<EObject>> _function = new Function1<Resource, EList<EObject>>() {
      @Override
      public EList<EObject> apply(final Resource it) {
        return it.getContents();
      }
    };
    List<EList<EObject>> _map = ListExtensions.<Resource, EList<EObject>>map(_resources, _function);
    Iterable<EObject> _flatten = Iterables.<EObject>concat(_map);
    Iterable<GenModel> _filter = Iterables.<GenModel>filter(_flatten, GenModel.class);
    final Procedure1<GenModel> _function_1 = new Procedure1<GenModel>() {
      @Override
      public void apply(final GenModel it) {
        XtextLanguageStandaloneSetup.this.registerGenModel(it);
      }
    };
    IterableExtensions.<GenModel>forEach(_filter, _function_1);
  }
  
  private void registerGenModel(final GenModel genModel) {
    GenModelHelper _genModelHelper = new GenModelHelper();
    _genModelHelper.registerGenModel(genModel);
  }
  
  private Object registerEPackage(final EPackage ePackage) {
    Object _xblockexpression = null;
    {
      Resource _eResource = ePackage.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      final EPackage.Registry registry = _resourceSet.getPackageRegistry();
      Object _xifexpression = null;
      String _nsURI = ePackage.getNsURI();
      Object _get = registry.get(_nsURI);
      boolean _tripleEquals = (_get == null);
      if (_tripleEquals) {
        String _nsURI_1 = ePackage.getNsURI();
        _xifexpression = registry.put(_nsURI_1, ePackage);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private final static Logger LOG = Logger.getLogger(XtextLanguageStandaloneSetup.class);
  
  @Pure
  public List<String> getLoadedResources() {
    return this.loadedResources;
  }
  
  public void setLoadedResources(final List<String> loadedResources) {
    this.loadedResources = loadedResources;
  }
}
