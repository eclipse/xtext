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
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @noextend
 * @noreference
 */
@Log
@SuppressWarnings("all")
public class XtextGeneratorResourceSetInitializer {
  public void initialize(final ResourceSet resourceSet, final List<String> referencedResources) {
    final StandaloneSetup delegate = new StandaloneSetup();
    delegate.setResourceSet(resourceSet);
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        XtextGeneratorResourceSetInitializer.this.loadResource(it, resourceSet);
      }
    };
    IterableExtensions.<String>forEach(referencedResources, _function);
    this.registerGenModels(resourceSet);
    this.registerEPackages(resourceSet);
  }
  
  private void loadResource(final String loadedResource, final ResourceSet resourceSet) {
    final URI loadedResourceUri = URI.createURI(loadedResource);
    this.ensureResourceCanBeLoaded(loadedResourceUri, resourceSet);
    resourceSet.getResource(loadedResourceUri, true);
  }
  
  private void ensureResourceCanBeLoaded(final URI loadedResource, final ResourceSet resourceSet) {
    String _fileExtension = loadedResource.fileExtension();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_fileExtension, "genmodel")) {
        _matched=true;
        GenModelPackage.eINSTANCE.getEFactoryInstance();
        final IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
        if ((resourceServiceProvider == null)) {
          try {
            final Class<?> genModelSupport = Class.forName("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport");
            final Object instance = genModelSupport.newInstance();
            Method _declaredMethod = genModelSupport.getDeclaredMethod("createInjectorAndDoEMFRegistration");
            _declaredMethod.invoke(instance);
          } catch (final Throwable _t) {
            if (_t instanceof ClassNotFoundException) {
              final ClassNotFoundException e = (ClassNotFoundException)_t;
              XtextGeneratorResourceSetInitializer.LOG.debug("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport not found, GenModels will not be indexed");
            } else if (_t instanceof Exception) {
              final Exception e_1 = (Exception)_t;
              XtextGeneratorResourceSetInitializer.LOG.error("Couldn\'t initialize GenModel support.", e_1);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_fileExtension, "ecore")) {
        _matched=true;
        final IResourceServiceProvider resourceServiceProvider_1 = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
        if ((resourceServiceProvider_1 == null)) {
          EcoreSupportStandaloneSetup.setup();
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_fileExtension, "xcore")) {
        _matched=true;
        final IResourceServiceProvider resourceServiceProvider_2 = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
        if ((resourceServiceProvider_2 == null)) {
          try {
            final Class<?> xcore = Class.forName("org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup");
            Method _declaredMethod_1 = xcore.getDeclaredMethod("doSetup", new Class[] {});
            _declaredMethod_1.invoke(null);
          } catch (final Throwable _t_1) {
            if (_t_1 instanceof ClassNotFoundException) {
              final ClassNotFoundException e_2 = (ClassNotFoundException)_t_1;
              XtextGeneratorResourceSetInitializer.LOG.error("Couldn\'t initialize Xcore support. Is it on the classpath?");
              String _message = e_2.getMessage();
              XtextGeneratorResourceSetInitializer.LOG.debug(_message, e_2);
            } else if (_t_1 instanceof Exception) {
              final Exception e_3 = (Exception)_t_1;
              XtextGeneratorResourceSetInitializer.LOG.error("Couldn\'t initialize Xcore support.", e_3);
            } else {
              throw Exceptions.sneakyThrow(_t_1);
            }
          }
        }
        final URI xcoreLangURI = URI.createPlatformResourceURI("/org.eclipse.emf.ecore.xcore.lib/model/XcoreLang.xcore", true);
        try {
          resourceSet.getResource(xcoreLangURI, true);
        } catch (final Throwable _t_2) {
          if (_t_2 instanceof WrappedException) {
            final WrappedException e_4 = (WrappedException)_t_2;
            XtextGeneratorResourceSetInitializer.LOG.error("Could not load XcoreLang.xcore.", e_4);
            final Resource brokenResource = resourceSet.getResource(xcoreLangURI, false);
            EList<Resource> _resources = resourceSet.getResources();
            _resources.remove(brokenResource);
          } else {
            throw Exceptions.sneakyThrow(_t_2);
          }
        }
      }
    }
  }
  
  private void registerEPackages(final ResourceSet resourceSet) {
    final Procedure1<EPackage> _function = new Procedure1<EPackage>() {
      @Override
      public void apply(final EPackage it) {
        XtextGeneratorResourceSetInitializer.this.register(it);
      }
    };
    this.<EPackage>each(resourceSet, EPackage.class, _function);
  }
  
  private void register(final EPackage ePackage) {
    Resource _eResource = ePackage.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final EPackage.Registry registry = _resourceSet.getPackageRegistry();
    String _nsURI = ePackage.getNsURI();
    Object _get = registry.get(_nsURI);
    boolean _tripleEquals = (_get == null);
    if (_tripleEquals) {
      String _nsURI_1 = ePackage.getNsURI();
      registry.put(_nsURI_1, ePackage);
    }
  }
  
  private void registerGenModels(final ResourceSet resourceSet) {
    final Procedure1<GenModel> _function = new Procedure1<GenModel>() {
      @Override
      public void apply(final GenModel it) {
        XtextGeneratorResourceSetInitializer.this.register(it);
      }
    };
    this.<GenModel>each(resourceSet, GenModel.class, _function);
  }
  
  private void register(final GenModel genModel) {
    GenModelHelper _genModelHelper = new GenModelHelper();
    _genModelHelper.registerGenModel(genModel);
  }
  
  private <Type extends Object> void each(final ResourceSet resourceSet, final Class<Type> type, final Procedure1<? super Type> strategy) {
    for (int i = 0; (i < resourceSet.getResources().size()); i++) {
      {
        EList<Resource> _resources = resourceSet.getResources();
        final Resource resource = _resources.get(i);
        EList<EObject> _contents = resource.getContents();
        Iterable<Type> _filter = Iterables.<Type>filter(_contents, type);
        final Procedure1<Type> _function = new Procedure1<Type>() {
          @Override
          public void apply(final Type it) {
            strategy.apply(it);
          }
        };
        IterableExtensions.<Type>forEach(_filter, _function);
      }
    }
  }
  
  private final static Logger LOG = Logger.getLogger(XtextGeneratorResourceSetInitializer.class);
}
