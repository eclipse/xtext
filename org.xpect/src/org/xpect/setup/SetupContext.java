/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.setup;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceFactory;
import org.xpect.XjmMethod;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.XpectJavaModel;
import org.xpect.parameter.IParameterProvider;
import org.xpect.runner.IXpectURIProvider;
import org.xpect.setup.IXpectRunnerSetup.ITestSetupContext;
import org.xpect.util.IXtInjectorProvider;

import com.google.common.collect.Maps;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SetupContext implements ITestSetupContext {

	private Collection<URI> allFiles;

	private XjmMethod method;

	private Map<Class<? extends Annotation>, IParameterProvider> paramValues;

	private Class<?> testClass;

	private Object testInstance;

	private IXpectURIProvider uriProvider;

	private Object userClassCtx;

	private Object userFileCtx;

	private Object userTestCtx;

	private XpectFile xpectFile;

	private XpectInvocation xpectInvocation;

	private XpectJavaModel xpectJavaModel;

	public Collection<URI> getAllFiles() {
		return allFiles;
	}

	public Injector getInjector() {
		return IXtInjectorProvider.INSTANCE.getInjector(xpectJavaModel, xpectFile.eResource().getURI());
	}

	public XjmMethod getMethod() {
		return method;
	}

	public <T> T getParameterValue(Class<? extends Annotation> key, Class<T> type) {
		IParameterProvider provider = paramValues.get(key);
		if (provider == null)
			return null;
		return provider.get(type, paramValues);
	}

	public Map<Class<? extends Annotation>, IParameterProvider> getParamValues() {
		if (paramValues == null)
			return Collections.emptyMap();
		return paramValues;
	}

	public Class<?> getTestClass() {
		return testClass;
	}

	public Object getTestInstance() {
		return testInstance;
	}

	public IXpectURIProvider getURIProvider() {
		return uriProvider;
	}

	public Object getUserClassCtx() {
		return userClassCtx;
	}

	public Object getUserFileCtx() {
		return userFileCtx;
	}

	public Object getUserTestCtx() {
		return userTestCtx;
	}

	public XpectFile getXpectFile() {
		return xpectFile;
	}

	public XpectInvocation getXpectInvocation() {
		return xpectInvocation;
	}

	public XpectJavaModel getXpectJavaModel() {
		return xpectJavaModel;
	}

	public void installParameterValue(Class<? extends Annotation> key, IParameterProvider provider) {
		if (paramValues == null)
			paramValues = Maps.newLinkedHashMap();
		paramValues.put(key, provider);
	}

	public Resource load(ResourceSet resourceSet, URI uri, InputStream input) throws IOException {
		Injector injector = IXtInjectorProvider.INSTANCE.getInjector(xpectJavaModel, uri);
		Resource resource = injector.getInstance(IResourceFactory.class).createResource(uri);
		resourceSet.getResources().add(resource);
		try {
			resource.load(input, null);
		} finally {
			if (input != null)
				input.close();
		}
		return resource;
	}

	public URI resolve(String uri) {
		return getURIProvider().resolveURI(getXpectFile().eResource().getURI(), uri);
	}

	public void setAllFiles(Collection<URI> allFiles) {
		this.allFiles = allFiles;
	}

	public void setMethod(XjmMethod method) {
		this.method = method;
	}

	public void setTestClass(Class<?> testClass) {
		this.testClass = testClass;
	}

	public void setTestInstance(Object testInstance) {
		this.testInstance = testInstance;
	}

	public void setUriProvider(IXpectURIProvider uriProvider) {
		this.uriProvider = uriProvider;
	}

	public void setUserClassCtx(Object userClassCtx) {
		this.userClassCtx = userClassCtx;
	}

	public void setUserFileCtx(Object userFileCtx) {
		this.userFileCtx = userFileCtx;
	}

	public void setUserTestCtx(Object userTestCtx) {
		this.userTestCtx = userTestCtx;
	}

	public void setXpectFile(XpectFile xpectFile) {
		this.xpectFile = xpectFile;
	}

	public void setXpectInvocation(XpectInvocation xpectInvocation) {
		this.xpectInvocation = xpectInvocation;
	}

	public void setXpectJavaModel(XpectJavaModel xpectJavaModel) {
		this.xpectJavaModel = xpectJavaModel;
	}
}
