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
import org.xpect.Environment;
import org.xpect.XjmMethod;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.XpectJavaModel;
import org.xpect.parameters.IParameterAdapter;
import org.xpect.parameters.IParameterProvider;
import org.xpect.runner.IXpectURIProvider;

import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IXpectRunnerSetup<T, K, V, X> extends IXpectSetup {

	public interface IClassSetupContext {

		Collection<URI> getAllFiles();

		Class<?> getTestClass();

		XpectJavaModel getXpectJavaModel();

		Environment getEnvironment();

		void installParameterAdapter(IParameterAdapter adapter);

		void installParameterValue(Class<? extends Annotation> key, IParameterProvider provider);

		Injector getInjector(URI uri);

		IXpectURIProvider getURIProvider();
	}

	public interface IFileSetupContext extends IClassSetupContext {
		XpectFile getXpectFile();

		Injector getInjector();
	}

	public interface ITestSetupContext extends IFileSetupContext {
		XjmMethod getMethod();

		Object getTestInstance();

		XpectInvocation getXpectInvocation();
	}

	void afterClass(IClassSetupContext frameworkCtx, T userCtx) throws Exception;

	void afterFile(IFileSetupContext frameworkCtx, K userCtx) throws Exception;

	void afterTest(ITestSetupContext frameworkCtx, V userCtx) throws Exception;

	T beforeClass(IClassSetupContext frameworkCtx) throws Exception;

	K beforeFile(IFileSetupContext frameworkCtx, T userCtx, ISetupInitializer<X> initializer) throws Exception;

	V beforeTest(ITestSetupContext frameworkCtx, K userCtx) throws Exception;
}
