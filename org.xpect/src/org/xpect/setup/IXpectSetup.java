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

import org.eclipse.emf.common.util.URI;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.runner.IXpectURIProvider;
import org.xpect.runner.XpectFrameworkMethod;
import org.xpect.util.ITypedAdapter;
import org.xpect.util.ITypedProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IXpectSetup<T, K, V, X> {

	public interface IClassSetupContext {

		Collection<URI> getAllFiles();

		Class<?> getTestClass();

		void installParameterAdapter(ITypedAdapter adapter);

		void installParameterValue(Class<? extends Annotation> key, ITypedProvider provider);

		IXpectURIProvider getURIProvider();
	}

	public interface IFileSetupContext extends IClassSetupContext {
		XpectFile getXpectFile();
	}

	public interface ITestSetupContext extends IFileSetupContext {
		// Collection<ITypedProvider> getAllParameterValues(int parameterIndex);

		XpectFrameworkMethod getMethod();

		// ITypedProvider getProposedParameterValue(int parameterIndex);

		Object getTestInstance();

		XpectInvocation getXpectInvocation();

		// void setParameterValue(int parameterIndex, ITypedProvider value);
	}

	void afterClass(IClassSetupContext frameworkCtx, T userCtx) throws Exception;

	void afterFile(IFileSetupContext frameworkCtx, K userCtx) throws Exception;

	void afterTest(ITestSetupContext frameworkCtx, V userCtx) throws Exception;

	T beforeClass(IClassSetupContext frameworkCtx) throws Exception;

	K beforeFile(IFileSetupContext frameworkCtx, T userCtx, ISetupInitializer<X> initializer) throws Exception;

	V beforeTest(ITestSetupContext frameworkCtx, K userCtx) throws Exception;
}
