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
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelInferrerRegistry;
import org.xpect.Environment;
import org.xpect.parameter.ParameterProvider;
import org.xpect.parameter.XpectParameterAdapter;
import org.xpect.setup.AbstractXpectSetup;
import org.xpect.setup.ISetupInitializer;
import org.xpect.xtext.lib.setup.ThisOffset.ThisOffsetProvider;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup.ClassCtx;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup.TestCtx;

import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@XpectParameterAdapter(XtextOffsetAdapter.class)
public class XtextStandaloneSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx, FileCtx> {

	protected static class ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}

	@Override
	public ClassCtx beforeClass(IClassSetupContext frameworkCtx) {
		JvmModelInferrerRegistry.INSTANCE.setUseRegistry(false);
		return new ClassCtx();
	}

	@Override
	public FileCtx beforeFile(IFileSetupContext frameworkCtx, ClassCtx userCtx, ISetupInitializer<FileCtx> initializer) throws IOException {
		FileCtx ctx = new FileCtx();
		initializer.initialize(ctx);
		Resource resource = loadThisResource(frameworkCtx.getInjector(), frameworkCtx, ctx);
		validate(ctx, resource);
		return ctx;
	}

	protected void validate(FileCtx ctx, Resource resource) {
		ctx.getValidate().validate(resource);
	}

	@Override
	public TestCtx beforeTest(ITestSetupContext frameworkCtx, FileCtx userCtx) throws IOException {
		Injector injector = frameworkCtx.getInjector();
		injector.injectMembers(frameworkCtx.getTestInstance());
		XtextResource res = loadThisResource(injector, frameworkCtx, userCtx);
		frameworkCtx.installParameterValue(ThisResource.class, new ParameterProvider(res));
		frameworkCtx.installParameterValue(ThisOffset.class, new ThisOffsetProvider(frameworkCtx.getXpectInvocation(), res));
		if (!res.getContents().isEmpty())
			frameworkCtx.installParameterValue(ThisModel.class, new ParameterProvider(res.getContents().get(0)));
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

}
