/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.xpect.XjmFactory;
import org.xpect.XjmMethod;
import org.xpect.XjmTest;
import org.xpect.XjmXpectMethod;
import org.xpect.XpectJavaModel;
import org.xpect.XpectStandaloneSetup;
import org.xpect.setup.ThisRootTestClass;
import org.xpect.setup.ThisTestObject.TestObjectSetup;
import org.xpect.state.ResolvedConfiguration;
import org.xpect.state.Configuration;
import org.xpect.state.StateContainer;
import org.xpect.util.AnnotationUtil;
import org.xpect.util.XpectJavaModelFactory;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectRunner extends ParentRunner<XpectFileRunner> {

	private List<XpectFileRunner> children;
	private Collection<URI> files;
	private final XpectJavaModel xpectJavaModel;
	private final IXpectURIProvider uriProvider;
	private final Injector xpectInjector;
	private final StateContainer state;
	public static ClassLoader testClassloader = null;
	public static XpectRunner INSTANCE = null;

	public XpectRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
		INSTANCE = this;
		testClassloader = testClass.getClassLoader();
		this.uriProvider = findUriProvider(testClass);
		this.xpectInjector = findXpectInjector();
		this.xpectJavaModel = this.xpectInjector.getInstance(XpectJavaModelFactory.class).createJavaModel(testClass);
		this.state = createState(createConfiguration());
	}

	public StateContainer getState() {
		return state;
	}

	protected Configuration createConfiguration() {
		Configuration config = new Configuration();
		config.addValue(ThisRootTestClass.class, super.getTestClass().getJavaClass());
		config.addFactory(TestObjectSetup.class);
		config.addFactory(ValidatingSetup.class);
		config.addDefaultValue(IXpectURIProvider.class, this.uriProvider);
		config.addDefaultValue(XpectJavaModel.class, this.xpectJavaModel);
		for (XjmTest test : this.xpectJavaModel.getTests()) {
			for (XjmFactory fact : test.getFactories())
				config.addFactory(fact.getJavaClass());
			for (XjmMethod method : test.getMethods())
				if (method instanceof XjmXpectMethod)
					for (XjmFactory fact : ((XjmXpectMethod) method).getFactories())
						config.addFactory(fact.getJavaClass());
		}
		return config;
	}

	protected StateContainer createState(Configuration config) {
		return new StateContainer(new ResolvedConfiguration(config));
	}

	protected Injector getXpectInjector() {
		return xpectInjector;
	}

	public XpectJavaModel getXpectJavaModel() {
		return xpectJavaModel;
	}

	protected Injector findXpectInjector() {
		IResourceServiceProvider rssp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(URI.createURI("foo.xpect"));
		if (rssp != null)
			return rssp.get(Injector.class);
		if (!EcorePlugin.IS_ECLIPSE_RUNNING)
			return new XpectStandaloneSetup().createInjectorAndDoEMFRegistration();
		throw new IllegalStateException("The language *.xpect is not activated");
	}

	protected XpectFileRunner createChild(Class<?> clazz, URI uri) {
		return new XpectFileRunner(this, uri);
	}

	protected List<XpectFileRunner> createChildren(Class<?> clazz) {
		List<XpectFileRunner> result = Lists.newArrayList();
		for (URI uri : getFiles())
			result.add(createChild(clazz, uri));
		return result;
	}

	@Override
	protected Description describeChild(XpectFileRunner child) {
		return child.getDescription();
	}

	protected IXpectURIProvider findUriProvider(Class<?> clazz) throws InitializationError {
		IXpectURIProvider provider = AnnotationUtil.newInstanceViaMetaAnnotation(clazz, XpectURIProvider.class, IXpectURIProvider.class);
		if (provider == null)
			provider = XpectTestFiles.Default.create(clazz);
		return provider;
	}

	@Override
	protected List<XpectFileRunner> getChildren() {
		if (children == null)
			children = createChildren(getTestClass().getJavaClass());
		return children;
	}

	protected Collection<URI> getFiles() {
		if (files == null)
			files = uriProvider.getAllURIs();
		return files;
	}

	public IXpectURIProvider getUriProvider() {
		return uriProvider;
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			super.run(notifier);
		} finally {
			try {
				state.invalidate();
			} catch (Throwable t) {
				notifier.fireTestFailure(new Failure(getDescription(), t));
			}
		}
	}

	@Override
	protected void runChild(XpectFileRunner child, RunNotifier notifier) {
		// IXpectRunnerSetup<Object, Object, Object, Object> setup =
		// createSetup();
		// SetupContext ctx = createSetupContext(setup);
		// ctx.setXpectJavaModel(xpectJavaModel);?
		// ctx.setAllFiles(getFiles());
		// ctx.setTestClass(getTestClass().getJavaClass());
		// ctx.setUriProvider(uriProvider);
		try {
			// if (setup != null)
			// setup.beforeClass(ctx);
			// child.run(notifier, setup, ctx);
			child.run(notifier);
		} catch (Throwable t) {
			notifier.fireTestFailure(new Failure(child.getDescription(), t));
		}
		// finally {
		// try {
		// if (setup != null)
		// setup.afterClass(ctx, ctx.getUserClassCtx());
		// } catch (Throwable t) {
		// notifier.fireTestFailure(new Failure(getDescription(), t));
		// }
		// }
	}
}
