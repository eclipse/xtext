/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.setup;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.xpect.Environment;
import org.xpect.XjmMethod;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.XpectJavaModel;
import org.xpect.registry.ILanguageInfo;
import org.xpect.runner.IXpectURIProvider;
import org.xpect.setup.IXpectRunnerSetup.ITestSetupContext;
import org.xpect.util.IParameterAdapter;
import org.xpect.util.IParameterProvider;
import org.xpect.util.URIDelegationHandler;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SetupContext implements ITestSetupContext {

	private Collection<URI> allFiles;

	// private List<List<ITypedProvider>> allParameters;

	private XjmMethod method;

	private List<IParameterAdapter> paramAdapters;

	private Map<Class<? extends Annotation>, IParameterProvider> paramValues;

	// private List<ITypedProvider> proposedParameters;

	private Class<?> testClass;

	private Object testInstance;

	private IXpectURIProvider uriProvider;

	private Object userClassCtx;

	private Object userFileCtx;

	private Object userTestCtx;

	private XpectFile xpectFile;

	private XpectInvocation xpectInvocation;

	public Collection<URI> getAllFiles() {
		return allFiles;
	}

	// public List<List<ITypedProvider>> getAllParameters() {
	// return allParameters;
	// }
	//
	// @Override
	// public Collection<ITypedProvider> getAllParameterValues(int
	// parameterIndex) {
	// return allParameters.get(parameterIndex);
	// }

	public XjmMethod getMethod() {
		return method;
	}

	public List<IParameterAdapter> getParamAdapters() {
		if (paramAdapters == null)
			return Collections.emptyList();
		return paramAdapters;
	}

	public Map<Class<? extends Annotation>, IParameterProvider> getParamValues() {
		if (paramValues == null)
			return Collections.emptyMap();
		return paramValues;
	}

	// public List<ITypedProvider> getProposedParameters() {
	// return proposedParameters;
	// }
	//
	// @Override
	// public ITypedProvider getProposedParameterValue(int parameterIndex) {
	// return proposedParameters.get(parameterIndex);
	// }

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

	public void installParameterAdapter(IParameterAdapter adapter) {
		if (paramAdapters == null)
			paramAdapters = Lists.newArrayList();
		paramAdapters.add(adapter);
	}

	public void installParameterValue(Class<? extends Annotation> key, IParameterProvider provider) {
		if (paramValues == null)
			paramValues = Maps.newLinkedHashMap();
		paramValues.put(key, provider);
	}

	public void setAllFiles(Collection<URI> allFiles) {
		this.allFiles = allFiles;
	}

	// public void setAllParameters(List<List<ITypedProvider>> allParameters) {
	// this.allParameters = allParameters;
	// }

	public void setMethod(XjmMethod method) {
		this.method = method;
	}

	// @Override
	// public void setParameterValue(int parameterIndex, ITypedProvider value) {
	// proposedParameters.set(parameterIndex, value);
	// }

	// public void setProposedParameters(List<ITypedProvider>
	// proposedParameters) {
	// this.proposedParameters = proposedParameters;
	// }

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

	private Map<String, Injector> ext2Injector = Maps.newHashMap();

	public Injector getInjector(URI uri) {
		String ext = new URIDelegationHandler().getOriginalFileExtension(uri.lastSegment());
		Injector injector = ext2Injector.get(ext);
		if (injector != null)
			return injector;
		ILanguageInfo info = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(ext);
		if (info == null)
			throw new IllegalStateException("No Xtext language configuration found for file extension '" + ext + "'.");
		EList<IXpectGuiceModuleSetup> moduleSetups = xpectJavaModel.getSetups(IXpectGuiceModuleSetup.class, getEnvironment());
		injector = info.getInjector();
		if (!moduleSetups.isEmpty()) {
			List<Module> modules = Lists.newArrayList();
			for (IXpectGuiceModuleSetup moduleSetup : moduleSetups)
				modules.add(injector.getInstance(moduleSetup.getModule()));
			injector = info.getInjector(modules.toArray(new Module[modules.size()]));
		}
		ext2Injector.put(ext, injector);
		return injector;
	}

	private XpectJavaModel xpectJavaModel;

	public XpectJavaModel getXpectJavaModel() {
		return xpectJavaModel;
	}

	public void setXpectJavaModel(XpectJavaModel xpectJavaModel) {
		this.xpectJavaModel = xpectJavaModel;
	}

	private Environment environment;

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Injector getInjector() {
		return getInjector(xpectFile.eResource().getURI());
	}

}
