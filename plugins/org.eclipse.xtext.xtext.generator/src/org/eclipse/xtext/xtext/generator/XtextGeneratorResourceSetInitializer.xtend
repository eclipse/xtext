/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import java.util.List
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.common.util.WrappedException
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.mwe.utils.GenModelHelper
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.internal.Log
import org.eclipse.emf.ecore.EcorePackage

/**
 * @noextend
 * @noreference
 */
@Log
class XtextGeneratorResourceSetInitializer {
	
	public def void initialize(ResourceSet resourceSet, List<String> referencedResources) {
		val delegate = new StandaloneSetup
		delegate.resourceSet = resourceSet
		resourceSet.packageRegistry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE)
		referencedResources.forEach[
			loadResource(resourceSet)
		]
		registerGenModels(resourceSet)
		registerEPackages(resourceSet)
	}
	
	private def void loadResource(String loadedResource, ResourceSet resourceSet) {
		val loadedResourceUri = URI.createURI(loadedResource)
		ensureResourceCanBeLoaded(loadedResourceUri, resourceSet)
		resourceSet.getResource(loadedResourceUri, true)
	}
	
	private def void ensureResourceCanBeLoaded(URI loadedResource, ResourceSet resourceSet) {
		switch (loadedResource.fileExtension) {
			case 'genmodel': {
				GenModelPackage.eINSTANCE.getEFactoryInstance
				val resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource)
				if (resourceServiceProvider === null) {
					try {
						val genModelSupport = Class.forName('org.eclipse.emf.codegen.ecore.xtext.GenModelSupport')
						val instance = genModelSupport.newInstance()
						genModelSupport.getDeclaredMethod('createInjectorAndDoEMFRegistration').invoke(instance)
					} catch (ClassNotFoundException e) {
						LOG.debug("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport not found, GenModels will not be indexed")
					} catch (Exception e) {
						LOG.error("Couldn't initialize GenModel support.", e)
					}
				}
			}
			case 'ecore': {
				val resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource)
				if (resourceServiceProvider === null) {
					EcoreSupportStandaloneSetup.setup()
				}
			}
			case 'xcore': {
				val resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResource)
				if (resourceServiceProvider === null) {
					try {
						val xcore = Class.forName('org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup')
						xcore.getDeclaredMethod('doSetup', #[]).invoke(null)
					} catch (ClassNotFoundException e) {
						LOG.error("Couldn't initialize Xcore support. Is it on the classpath?")
						LOG.debug(e.getMessage(), e)
					} catch (Exception e) {
						LOG.error("Couldn't initialize Xcore support.", e)
					}
				}
				val xcoreLangURI = URI.createPlatformResourceURI('/org.eclipse.emf.ecore.xcore.lib/model/XcoreLang.xcore', true)
				try {
					resourceSet.getResource(xcoreLangURI, true)
				} catch (WrappedException e) {
					LOG.error("Could not load XcoreLang.xcore.", e)
					val brokenResource = resourceSet.getResource(xcoreLangURI, false)
					resourceSet.resources.remove(brokenResource)
				}
			}
		}
	}
	
	private def void registerEPackages(ResourceSet resourceSet) {
		resourceSet.each(EPackage) [ register ]
	}
	
	private def void register(EPackage ePackage) {
		val registry = ePackage.eResource.resourceSet.packageRegistry
		if (registry.get(ePackage.nsURI) === null) {
			registry.put(ePackage.nsURI, ePackage)
		}
	}
	
	private def void registerGenModels(ResourceSet resourceSet) {
		resourceSet.each(GenModel) [ register ]
	}
	
	private def void register(GenModel genModel) {
		new GenModelHelper().registerGenModel(genModel)
	}
	
	private def <Type> void each(ResourceSet resourceSet, Class<Type> type, (Type)=>void strategy) {
		// don't use forEach loop since the given strategy may trigger additional resource loading
		for(var i = 0; i < resourceSet.resources.size; i++) {
			val resource = resourceSet.resources.get(i)
			resource.contents.filter(type).forEach[ strategy.apply(it) ]
		}
	}
}