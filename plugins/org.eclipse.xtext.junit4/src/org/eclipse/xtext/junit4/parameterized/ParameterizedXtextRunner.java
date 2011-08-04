/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import static org.eclipse.xtext.util.Exceptions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.parameterized.ParameterizedXtextRunner.ResourceRunner;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ParameterizedXtextRunner extends ParentRunner<ResourceRunner> {

	protected static class ParameterSetRunner {
		protected Description description;
		protected FrameworkMethod method;
		protected Object[] params;
		protected ResourceRunner runner;
		protected int index = -1;

		protected Constructor<?> findConstructor() {
			ROOT: for (Constructor<?> candidate : runner.clazz.getJavaClass().getConstructors())
				if (candidate.getParameterTypes().length == params.length) {
					for (int i = 0; i < params.length; i++)
						if (!candidate.getParameterTypes()[i].isInstance(params[i]))
							continue ROOT;
					return candidate;
				}
			List<String> types = Lists.newArrayList();
			for (Object p : params)
				types.add(p.getClass().getName());
			throw new RuntimeException("No valid constructor found in class " + runner.clazz.getName() + " for types "
					+ Joiner.on(", ").join(types));
		}

		public Description getDescription() {
			if (description == null) {
				String name = method == null ? "" : method.getName();
				if (index > -1)
					name = name + ":" + index;
				name = name + ":  " + runner.resource.getURI().lastSegment();
				description = Description.createTestDescription(runner.clazz.getJavaClass(), name);
			}
			return description;
		}

		public void init(ResourceRunner runner, FrameworkMethod method, Object[] params) {
			this.runner = runner;
			this.method = method;
			this.params = params;
		}

		public void run(RunNotifier notifier) {
			if (method == null)
				notifier.fireTestIgnored(getDescription());
			else {
				notifier.fireTestStarted(getDescription());
				try {
					Object test = findConstructor().newInstance(params);
					Object result = method.invokeExplosively(test);
					if (result != null) {
						String exp = migrate(params[1].toString(), result.toString());
						if (!exp.equals(result.toString()))
							throw new ComparisonFailure("", exp, result.toString());
					}

				} catch (Throwable e) {
					notifier.fireTestFailure(new Failure(getDescription(), e));
				}
				notifier.fireTestFinished(getDescription());
			}
		}

		protected String migrate(String expected, String actual) {
			String[] exp = expected.split("\\s|\\?\\?\\?");
			int start = 0;
			StringBuilder result = new StringBuilder();
			for (String s : exp) {
				int next = actual.indexOf(s, start);
				if (next < 0) {
					return expected;
					//					result.append(expected.substring(start));
					//					return result.toString();
				} else {
					result.append(actual.substring(start, next));
					result.append(s);
					start = next + s.length();
				}
			}
			return result.toString();
		}

	}

	protected static class ResourceRunner {
		protected TestClass clazz;
		protected Description description;
		protected IInjectorProvider injectorProvider;
		protected List<ParameterSetRunner> parameterSets = Lists.newArrayList();
		protected XtextResource resource;
		protected ResourceSet resourceSet;

		protected boolean acceptParameterSet(Pair<String, Object[]> t) {
			ParameterSetRunner runner = injectorProvider.getInjector().getInstance(ParameterSetRunner.class);
			FrameworkMethod method = findTestMethod(t.getFirst());
			runner.init(this, method, t.getSecond());
			return parameterSets.add(runner);
		}

		protected void acceptTestClass(Class<?> t) {
			Assert.assertEquals(clazz, t);
		}

		protected void collectParameters() {
			IParameterProvider parameterProvider = injectorProvider.getInjector().getInstance(IParameterProvider.class);
			parameterProvider.collectParameters(resource, new IAcceptor<URI>() {
				public void accept(URI t) {
					importURI(t);
				}
			}, new IAcceptor<Class<?>>() {
				public void accept(Class<?> t) {
					acceptTestClass(t);
				}

			}, new IAcceptor<Pair<String, Object[]>>() {
				public void accept(Pair<String, Object[]> t) {
					acceptParameterSet(t);
				}
			});
		}

		protected FrameworkMethod findTestMethod(String name) {
			for (FrameworkMethod meth : clazz.getAnnotatedMethods(Test.class))
				if (meth.getName().equals(name) && meth.getMethod().getParameterTypes().length == 0
						&& !Modifier.isStatic(meth.getMethod().getModifiers()))
					return meth;
			return null;
		}

		public Description getDescription() {
			if (description == null) {
				description = Description.createSuiteDescription(resource.getURI().lastSegment());
				for (ParameterSetRunner child : parameterSets)
					description.addChild(child.getDescription());
			}
			return description;
		}

		public List<ParameterSetRunner> getParameterSets() {
			return parameterSets;
		}

		protected void importURI(URI uri) {
			resourceSet.getResource(uri, true);
		}

		public void init(TestClass clazz, IInjectorProvider injector, URI uri) {
			this.clazz = clazz;
			this.injectorProvider = injector;
			this.resourceSet = injectorProvider.getInjector().getInstance(ResourceSet.class);
			this.resource = (XtextResource) resourceSet.getResource(uri, true);
			collectParameters();
			setIndex();
		}

		protected void setIndex() {
			Set<Method> visited = Sets.newHashSet();
			Set<Method> duplicate = Sets.newHashSet();
			for (ParameterSetRunner r : getParameterSets())
				if (!visited.add(r.method.getMethod()))
					duplicate.add(r.method.getMethod());
			Map<Method, Integer> counter = Maps.newHashMap();
			for (ParameterSetRunner r : getParameterSets())
				if (duplicate.contains(r.method.getMethod())) {
					Integer count = counter.get(r.method.getMethod());
					if (count == null)
						count = 1;
					else
						count++;
					counter.put(r.method.getMethod(), count);
					r.index = count;
				}
		}

	}

	private static Map<Class<?>, IInjectorProvider> injectorProviderClassCache = Maps.newHashMap();

	protected List<ResourceRunner> children;

	public ParameterizedXtextRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
	}

	protected IInjectorProvider createInjectorProvider() {
		IInjectorProvider injectorProvider = null;
		InjectWith injectWith = getTestClass().getJavaClass().getAnnotation(InjectWith.class);
		if (injectWith != null) {
			try {
				injectorProvider = injectWith.value().newInstance();
			} catch (Exception e) {
				throwUncheckedException(e);
			}
		}
		return injectorProvider;
	}

	@Override
	protected Description describeChild(ResourceRunner child) {
		return child.getDescription();
	}

	@Override
	protected List<ResourceRunner> getChildren() {
		if (children == null) {
			children = Lists.newArrayList();
			IInjectorProvider injectorProvider = getOrCreateInjectorProvider();
			for (URI uri : getURIs()) {
				ResourceRunner child = injectorProvider.getInjector().getInstance(ResourceRunner.class);
				child.init(getTestClass(), injectorProvider, uri);
				children.add(child);
			}
		}
		return children;
	}

	protected IInjectorProvider getInjectorProvider() {
		return injectorProviderClassCache.get(getTestClass().getJavaClass());
	}

	protected IInjectorProvider getOrCreateInjectorProvider() {
		IInjectorProvider injectorProvider = getInjectorProvider();
		if (injectorProvider == null) {
			injectorProvider = createInjectorProvider();
			injectorProviderClassCache.put(getTestClass().getJavaClass(), injectorProvider);
		}
		return injectorProvider;
	}

	protected List<URI> getURIs() {
		ResourceURIs classAnnotation = getTestClass().getJavaClass().getAnnotation(ResourceURIs.class);
		if (classAnnotation != null)
			return getURIs(classAnnotation);
		for (FrameworkMethod method : getTestClass().getAnnotatedMethods(ResourceURIs.class)) {
			int modifiers = method.getMethod().getModifiers();
			if (Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers))
				return getURIs(method);
		}
		throw new RuntimeException("The class " + getTestClass().getJavaClass()
				+ " or one of its static public methods needs to be annotated with @"
				+ ResourceURIs.class.getSimpleName());
	}

	@SuppressWarnings("unchecked")
	protected List<URI> getURIs(FrameworkMethod method) {
		try {
			return (List<URI>) method.invokeExplosively(null);
		} catch (Throwable e) {
			Exceptions.throwUncheckedException(e);
			return Collections.emptyList();
		}
	}

	protected List<URI> getURIs(ResourceURIs resourceURIs) {
		Assert.assertFalse("@ResourceURIs needs a baseURI", Strings.isEmpty(resourceURIs.baseDir()));
		Assert.assertTrue("@ResourceURIs needs at least one fileExtension", resourceURIs.fileExtensions().length > 0);
		ResourceURICollector collector = new ResourceURICollector();
		return collector.collectFiles(resourceURIs.baseDir(), resourceURIs.fileExtensions());

	}

	@Override
	protected void runChild(ResourceRunner arg0, RunNotifier arg1) {
		for (ParameterSetRunner ps : arg0.getParameterSets())
			ps.run(arg1);
	}

}
