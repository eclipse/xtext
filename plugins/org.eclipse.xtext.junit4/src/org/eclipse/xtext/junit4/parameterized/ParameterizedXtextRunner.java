/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import static org.eclipse.xtext.util.Exceptions.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.parameterized.IParameterProvider.IParameterAcceptor;
import org.eclipse.xtext.junit4.parameterized.ParameterizedXtextRunner.ResourceRunner;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.ITestExpectationValidator;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.TestResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.ReflectionUtil;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
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

	protected static class MethodWithExpectation {
		protected Method method;

		protected ITestExpectationValidator<Object> validator;

		public MethodWithExpectation(Method method) throws Throwable {
			super();
			this.method = method;
			this.validator = findValidator();
		}

		protected ITestExpectationValidator<? extends Object> createValidator(Test annotation) {
			if (method.getReturnType() != void.class)
				throw new RuntimeException("The method is expected to return void. Method: " + method);
			return new TestExpectationValidator.NullTestResultValidator(annotation);
		}

		protected ITestExpectationValidator<? extends Object> createValidator(TestExpectationValidator trv,
				Annotation annotation) throws Throwable {
			Class<? extends ITestExpectationValidator<?>> validatorClass = trv.validator();
			Class<?> expectedResultType = getExpectedResultType(validatorClass);
			if (!expectedResultType.isAssignableFrom(method.getReturnType()))
				throw new RuntimeException("The return type of " + method + " is expected to be "
						+ expectedResultType.getName());
			Constructor<? extends ITestExpectationValidator<?>> c = validatorClass.getConstructor(annotation
					.annotationType());
			return c.newInstance(annotation);
		}

		@SuppressWarnings("unchecked")
		protected ITestExpectationValidator<Object> findValidator() throws Throwable {
			for (Annotation an : method.getAnnotations())
				if (an instanceof Test)
					return (ITestExpectationValidator<Object>) createValidator((Test) an);
				else {
					TestExpectationValidator trv = an.annotationType().getAnnotation(TestExpectationValidator.class);
					if (trv != null)
						return (ITestExpectationValidator<Object>) createValidator(trv, an);
				}
			throw new RuntimeException("Annotation missing: @Test or @TestString or @TestIterable, etc. in: " + method);
		}

		protected Class<?> getExpectedResultType(Class<? extends ITestExpectationValidator<?>> clazz) {
			for (Method meth : clazz.getMethods()) {
				Annotation[][] annotations = meth.getParameterAnnotations();
				for (int i = 0; i < annotations.length; i++)
					for (Annotation an : annotations[i])
						if (an instanceof TestResult)
							return meth.getParameterTypes()[i];
			}
			throw new RuntimeException("One of the method parameters of " + clazz.getName()
					+ " must be annotated with @" + TestResult.class.getSimpleName());
		}

		public Method getMethod() {
			return method;
		}

		public ITestExpectationValidator<Object> getValidator() {
			return validator;
		}
	}

	protected static class ParameterSetRunner {
		protected Description description;
		protected String expectation;
		protected boolean ignore;
		protected int index = -1;
		protected String methodName;
		protected Object[] params;
		protected ResourceRunner runner;
		protected String title;

		public Description getDescription() {
			if (description == null)
				description = Description.createTestDescription(runner.clazz.getJavaClass(), getFullTitle());
			return description;
		}

		public String getExpectation() {
			return expectation;
		}

		public String getFullTitle() {
			StringBuilder result = new StringBuilder();
			result.append(methodName);
			if (!Strings.isEmpty(title)) {
				result.append(" ");
				result.append(title);
			}
			if (index > -1) {
				result.append("#");
				result.append(index);
			}
			result.append(" - ");
			result.append(runner.resource.getURI().lastSegment());
			return result.toString();
		}

		public IInjectorProvider getInjectorProvider() {
			return runner.injectorProvider;
		}

		public String getMethdoName() {
			return methodName;
		}

		public Object[] getParams() {
			return params;
		}

		public Class<?> getTestClass() {
			return runner.clazz.getJavaClass();
		}

		public void init(ResourceRunner runner, String title, String method, Object[] params, String expectation,
				boolean ignore) {
			this.runner = runner;
			this.title = title;
			this.methodName = method;
			this.params = params;
			this.expectation = expectation;
			this.ignore = ignore;
		}

		public boolean isIgnore() {
			return ignore;
		}

	}

	protected static class ResourceRunner implements IParameterAcceptor {
		protected TestClass clazz;
		protected Description description;
		protected IInjectorProvider injectorProvider;
		protected List<ParameterSetRunner> parameterSets = Lists.newArrayList();
		protected XtextResource resource;
		protected ResourceSet resourceSet;

		public void acceptImportURI(URI uri) {
			resourceSet.getResource(uri, true);
		}

		public void acceptTest(String title, String method, Object[] params, String expectation, boolean ignore) {
			ParameterSetRunner runner = injectorProvider.getInjector().getInstance(ParameterSetRunner.class);
			runner.init(this, title, method, params, expectation, ignore);
			parameterSets.add(runner);
		}

		public void acceptTestClass(Class<?> t) {
			Assert.assertEquals(clazz, t);
		}

		protected void collectParameters() {
			IParameterProvider parameterProvider = injectorProvider.getInjector().getInstance(IParameterProvider.class);
			parameterProvider.collectParameters(resource, this);
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

		public void init(TestClass clazz, IInjectorProvider injector, URI uri) {
			this.clazz = clazz;
			this.injectorProvider = injector;
			this.resourceSet = injectorProvider.getInjector().getInstance(ResourceSet.class);
			this.resource = (XtextResource) resourceSet.getResource(uri, true);
			collectParameters();
			setIndex();
		}

		protected void setIndex() {
			Set<String> visited = Sets.newHashSet();
			Set<String> duplicate = Sets.newHashSet();
			for (ParameterSetRunner r : getParameterSets())
				if (!visited.add(r.getFullTitle()))
					duplicate.add(r.getFullTitle());
			Map<String, Integer> counter = Maps.newHashMap();
			for (ParameterSetRunner r : getParameterSets())
				if (duplicate.contains(r.getFullTitle())) {
					String title = r.getFullTitle();
					Integer count = counter.get(title);
					if (count == null)
						count = 1;
					else
						count++;
					counter.put(title, count);
					r.index = count;
				}
		}
	}

	private static Map<Class<?>, IInjectorProvider> injectorProviderClassCache = Maps.newHashMap();

	protected List<ResourceRunner> children;

	protected Filter filter = null;

	protected Map<String, MethodWithExpectation> methods = Maps.newHashMap();

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
	public void filter(Filter filter) throws NoTestsRemainException {
		super.filter(filter);
		this.filter = filter;
	}

	protected Constructor<?> findConstructor(Object[] params) {
		ROOT: for (Constructor<?> candidate : getTestClass().getJavaClass().getConstructors())
			if (candidate.getParameterTypes().length == params.length) {
				for (int i = 0; i < params.length; i++)
					if (params[i] != null
							&& !ReflectionUtil.getObjectType(candidate.getParameterTypes()[i]).isInstance(params[i]))
						continue ROOT;
				return candidate;
			}
		List<String> types = Lists.newArrayList();
		for (Object p : params)
			types.add(p == null ? "?" : p.getClass().getName());
		throw new RuntimeException("No valid constructor found in class " + getTestClass().getJavaClass().getName()
				+ " for types " + Joiner.on(", ").join(types));
	}

	protected MethodWithExpectation findTestMethod(String name) throws Throwable {
		MethodWithExpectation result = methods.get(name);
		if (result == null) {
			Method method = getTestClass().getJavaClass().getMethod(name);
			if (method == null)
				throw new RuntimeException("Method " + name + "() not found in " + getTestClass().getName());
			result = new MethodWithExpectation(method);
			methods.put(name, result);
		}
		return result;
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

	protected void runChild(ParameterSetRunner ps) throws Throwable {
		MethodWithExpectation method = findTestMethod(ps.getMethdoName());
		Constructor<?> constructor = findConstructor(ps.getParams());
		Object test = constructor.newInstance(ps.getParams());
		if (ps.getInjectorProvider() instanceof IRegistryConfigurator)
			((IRegistryConfigurator) ps.getInjectorProvider()).setupRegistry();
		try {
			ps.getInjectorProvider().getInjector().injectMembers(test);
			Object result = method.getMethod().invoke(test);
			method.getValidator().validate(ps.getExpectation(), result);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		} finally {
			if (ps.getInjectorProvider() instanceof IRegistryConfigurator)
				((IRegistryConfigurator) ps.getInjectorProvider()).restoreRegistry();
		}
	}

	@Override
	protected void runChild(ResourceRunner arg0, RunNotifier notifier) {
		for (ParameterSetRunner ps : arg0.getParameterSets())
			if (filter == null || filter.shouldRun(ps.getDescription())) {
				notifier.fireTestStarted(ps.getDescription());
				if (ps.isIgnore())
					notifier.fireTestIgnored(ps.getDescription());
				else
					try {
						runChild(ps);
					} catch (Throwable e) {
						notifier.fireTestFailure(new Failure(ps.getDescription(), e));
					}
				notifier.fireTestFinished(ps.getDescription());
			}
	}

}
