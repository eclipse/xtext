/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.collect.Iterables;
import java.util.List;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.utils.GenModelHelper;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Initializes a resource set in order to load the grammar of a language. The resources to include are specified
 * via {@link XtextGeneratorLanguage#addReferencedResource(String)}.
 */
@Log
@SuppressWarnings("all")
public class XtextGeneratorResourceSetInitializer {
  public void initialize(final ResourceSet resourceSet, final List<String> referencedResources) {
    final StandaloneSetup delegate = new StandaloneSetup();
    delegate.setResourceSet(resourceSet);
    resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
    final Consumer<String> _function = (String it) -> {
      this.loadResource(it, resourceSet);
    };
    referencedResources.forEach(_function);
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
    if (_fileExtension != null) {
      switch (_fileExtension) {
        case "genmodel":
          GenModelPackage.eINSTANCE.getEFactoryInstance();
          final IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
          if ((resourceServiceProvider == null)) {
            try {
              final Class<?> genModelSupport = Class.forName("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport");
              final Object instance = genModelSupport.getDeclaredConstructor().newInstance();
              genModelSupport.getDeclaredMethod("createInjectorAndDoEMFRegistration").invoke(instance);
            } catch (final Throwable _t) {
              if (_t instanceof ClassNotFoundException) {
                XtextGeneratorResourceSetInitializer.LOG.debug("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport not found, GenModels will not be indexed");
              } else if (_t instanceof Exception) {
                final Exception e_1 = (Exception)_t;
                XtextGeneratorResourceSetInitializer.LOG.error("Couldn\'t initialize GenModel support.", e_1);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
          break;
        case "ecore":
          final IResourceServiceProvider resourceServiceProvider_1 = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
          if ((resourceServiceProvider_1 == null)) {
            try {
              final Class<?> ecore = Class.forName("org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup");
              ecore.getDeclaredMethod("setup", new Class[] {}).invoke(null);
            } catch (final Throwable _t) {
              if (_t instanceof ClassNotFoundException) {
                final ClassNotFoundException e = (ClassNotFoundException)_t;
                XtextGeneratorResourceSetInitializer.LOG.error("Couldn\'t initialize Ecore support. Is \'org.eclipse.xtext.ecore\' on the classpath?");
                XtextGeneratorResourceSetInitializer.LOG.debug(e.getMessage(), e);
              } else if (_t instanceof Exception) {
                final Exception e_1 = (Exception)_t;
                XtextGeneratorResourceSetInitializer.LOG.error("Couldn\'t initialize Ecore support.", e_1);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
          break;
        case "xcore":
          final IResourceServiceProvider resourceServiceProvider_2 = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource);
          if ((resourceServiceProvider_2 == null)) {
            try {
              final Class<?> xcore = Class.forName("org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup");
              xcore.getDeclaredMethod("doSetup", new Class[] {}).invoke(null);
            } catch (final Throwable _t) {
              if (_t instanceof ClassNotFoundException) {
                final ClassNotFoundException e = (ClassNotFoundException)_t;
                XtextGeneratorResourceSetInitializer.LOG.error("Couldn\'t initialize Xcore support. Is it on the classpath?");
                XtextGeneratorResourceSetInitializer.LOG.debug(e.getMessage(), e);
              } else if (_t instanceof Exception) {
                final Exception e_1 = (Exception)_t;
                XtextGeneratorResourceSetInitializer.LOG.error("Couldn\'t initialize Xcore support.", e_1);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
          final URI xcoreLangURI = URI.createPlatformResourceURI("/org.eclipse.emf.ecore.xcore.lib/model/XcoreLang.xcore", true);
          try {
            resourceSet.getResource(xcoreLangURI, true);
          } catch (final Throwable _t) {
            if (_t instanceof WrappedException) {
              final WrappedException e = (WrappedException)_t;
              XtextGeneratorResourceSetInitializer.LOG.error("Could not load XcoreLang.xcore.", e);
              final Resource brokenResource = resourceSet.getResource(xcoreLangURI, false);
              resourceSet.getResources().remove(brokenResource);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          break;
      }
    }
  }
  
  private void registerEPackages(final ResourceSet resourceSet) {
    final Procedure1<EPackage> _function = (EPackage it) -> {
      this.register(it);
    };
    this.<EPackage>each(resourceSet, EPackage.class, _function);
  }
  
  private void register(final EPackage ePackage) {
    final EPackage.Registry registry = ePackage.eResource().getResourceSet().getPackageRegistry();
    Object _get = registry.get(ePackage.getNsURI());
    boolean _tripleEquals = (_get == null);
    if (_tripleEquals) {
      registry.put(ePackage.getNsURI(), ePackage);
    }
  }
  
  private void registerGenModels(final ResourceSet resourceSet) {
    final Procedure1<GenModel> _function = (GenModel it) -> {
      this.register(it);
    };
    this.<GenModel>each(resourceSet, GenModel.class, _function);
  }
  
  private void register(final GenModel genModel) {
    new GenModelHelper().registerGenModel(genModel);
  }
  
  private <Type extends Object> void each(final ResourceSet resourceSet, final Class<Type> type, final Procedure1<? super Type> strategy) {
    for (int i = 0; (i < resourceSet.getResources().size()); i++) {
      {
        final Resource resource = resourceSet.getResources().get(i);
        final Consumer<Type> _function = (Type it) -> {
          strategy.apply(it);
        };
        Iterables.<Type>filter(resource.getContents(), type).forEach(_function);
      }
    }
  }
  
  private static final Logger LOG = Logger.getLogger(XtextGeneratorResourceSetInitializer.class);
}
