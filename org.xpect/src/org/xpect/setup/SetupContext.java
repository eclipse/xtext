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

import org.eclipse.emf.common.util.URI;
import org.xpect.XjmMethod;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.runner.IXpectURIProvider;
import org.xpect.setup.IXpectSetup.ITestSetupContext;
import org.xpect.util.ITypedAdapter;
import org.xpect.util.ITypedProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SetupContext implements ITestSetupContext {

	private Collection<URI> allFiles;

	// private List<List<ITypedProvider>> allParameters;

	private XjmMethod method;

	private List<ITypedAdapter> paramAdapters;

	private Map<Class<? extends Annotation>, ITypedProvider> paramValues;

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

	public List<ITypedAdapter> getParamAdapters() {
		if (paramAdapters == null)
			return Collections.emptyList();
		return paramAdapters;
	}

	public Map<Class<? extends Annotation>, ITypedProvider> getParamValues() {
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

	public void installParameterAdapter(ITypedAdapter adapter) {
		if (paramAdapters == null)
			paramAdapters = Lists.newArrayList();
		paramAdapters.add(adapter);
	}

	public void installParameterValue(Class<? extends Annotation> key, ITypedProvider provider) {
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

}
