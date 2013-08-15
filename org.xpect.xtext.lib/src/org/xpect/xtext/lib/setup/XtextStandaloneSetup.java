/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.io.IOException;
import java.util.EnumSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xpect.Environment;
import org.xpect.parameter.XpectParameterAdapter;
import org.xpect.setup.ISetupInitializer;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup.ClassCtx;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup.Config;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup.TestCtx;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup.FileCtx;
import org.xpect.xtext.lib.setup.emf.File;
import org.xpect.xtext.lib.setup.emf.ResourceFactory;
import org.xpect.xtext.lib.setup.generic.GenericResource;
import org.xpect.xtext.lib.util.XtextOffsetAdapter;

import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
@XpectParameterAdapter(XtextOffsetAdapter.class)
public class XtextStandaloneSetup extends AbstractXtextSetup<ClassCtx, Config, TestCtx, Config> {

	protected static class ClassCtx {
	}

	public static class Config extends AbstractXtextSetup.AbstractConfig {

		private org.xpect.xtext.lib.setup.emf.ResourceSet resourceSet = null;

		public void add(org.xpect.xtext.lib.setup.emf.ResourceSet resourceSet) {
			if (this.resourceSet != null)
				throw new IllegalStateException("Only one ResourceSet per test is supported.");
			this.resourceSet = resourceSet;
		}

		public org.xpect.xtext.lib.setup.emf.ResourceSet getResourceSet() {
			return resourceSet;
		}

	}

	public class Defaults implements ISetupInitializer<Config> {
		private final ISetupInitializer<Config> delegate;

		public Defaults(ISetupInitializer<Config> delegate) {
			this.delegate = delegate;
		}

		protected ResourceFactory convert(GenericResource res) {
			if (res instanceof org.xpect.xtext.lib.setup.generic.File)
				return new File((org.xpect.xtext.lib.setup.generic.File) res);
			else if (res instanceof org.xpect.xtext.lib.setup.generic.ThisFile)
				return new org.xpect.xtext.lib.setup.emf.ThisFile((org.xpect.xtext.lib.setup.generic.ThisFile) res);
			throw new IllegalStateException();
		}

		public void initialize(Config object) {
			delegate.initialize(object);
			if (object.getResourceSet() == null)
				object.add(new org.xpect.xtext.lib.setup.emf.ResourceSet());
			for (GenericResource res : object.getGenericResources())
				object.getResourceSet().add(convert(res));
			if (!object.getResourceSet().hasThisFile())
				object.getResourceSet().add(new org.xpect.xtext.lib.setup.emf.ThisFile());
		}
	}

	protected static class TestCtx extends Config {
	}

	@Override
	public ClassCtx beforeClass(IClassSetupContext frameworkCtx) {
		JvmModelInferrerRegistry.INSTANCE.setUseRegistry(false);
		return new ClassCtx();
	}

	@Override
	public Config beforeFile(IFileSetupContext frameworkCtx, ClassCtx userCtx, ISetupInitializer<Config> initializer) throws Exception {
		Config ctx = new Config();
		new Defaults(initializer).initialize(ctx);
		Resource resource = loadThisResource(frameworkCtx.getInjector(), frameworkCtx, ctx);
		ctx.getValidate().validate(resource);
		return ctx;
	}

	@Override
	public TestCtx beforeTest(ITestSetupContext frameworkCtx, Config userCtx) throws Exception {
		Injector injector = frameworkCtx.getInjector();
		injector.injectMembers(frameworkCtx.getTestInstance());
		XtextResource res = loadThisResource(injector, frameworkCtx, userCtx);
		installResourceParameterValues(frameworkCtx, res);
		return null;
	}

	public XtextResource loadThisResource(Injector injector, IFileSetupContext frameworkCtx, FileCtx userCtx) throws IOException {
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = injector.getInstance(org.eclipse.emf.ecore.resource.ResourceSet.class);
		if (resourceSet instanceof XtextResourceSet) {
			((XtextResourceSet) resourceSet).setClasspathURIContext(frameworkCtx.getTestClass());
		}
		if (userCtx.getResourceSet() != null) {
			Resource result = null;
			for (ISetupFile file : userCtx.getResourceSet().getFiles()) {
				Resource res = injector.getInstance(IResourceFactory.class).createResource(file.getURI(frameworkCtx));
				resourceSet.getResources().add(res);
				res.load(file.createInputStream(frameworkCtx), null);
				if (file instanceof ThisFile)
					result = res;
			}
			return (XtextResource) result;
		} else {
			URI thisURI = frameworkCtx.getXpectFile().eResource().getURI();
			Resource res = injector.getInstance(IResourceFactory.class).createResource(thisURI);
			resourceSet.getResources().add(res);
			res.load(resourceSet.getURIConverter().createInputStream(thisURI), null);
			return (XtextResource) res;
		}
	}

	public EnumSet<Environment> getEnvironments() {
		return EnumSet.of(Environment.STANDALONE_TEST);
	}

	public XtextResource loadThisResource(Injector injector, IFileSetupContext frameworkCtx, Config config) throws Exception {
		ResourceSet resourceSet = injector.getInstance(ResourceSet.class);
		if (resourceSet instanceof XtextResourceSet)
			((XtextResourceSet) resourceSet).setClasspathURIContext(frameworkCtx.getTestClass());
		Resource result = null;
		for (ResourceFactory file : config.getResourceSet().getFactories()) {
			Resource res = file.create(frameworkCtx, resourceSet);
			if (file instanceof org.xpect.xtext.lib.setup.emf.ThisFile)
				result = res;
		}
		return (XtextResource) result;
	}

}
