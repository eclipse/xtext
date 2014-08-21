/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.junit.runner.Description;
import org.xpect.XjmMethod;
import org.xpect.XjmXpectMethod;
import org.xpect.XpectInvocation;
import org.xpect.model.XpectInvocationImplCustom;
import org.xpect.parameter.IParameterProvider;
import org.xpect.parameter.ParameterProvider;
import org.xpect.setup.ThisTestClass;
import org.xpect.setup.ThisTestObject;
import org.xpect.state.Configuration;
import org.xpect.state.StateContainer;

import com.google.common.base.Preconditions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectTestRunner extends AbstractTestRunner {

	private final XpectInvocation invocation;
	private final StateContainer state;

	public XpectTestRunner(XpectFileRunner uriRunner, XpectInvocation invocation) {
		super(uriRunner);
		Preconditions.checkNotNull(invocation);
		this.invocation = invocation;
		this.state = createState(createConfiguration());
	}

	@Override
	public StateContainer getState() {
		return state;
	}

	protected Configuration createConfiguration() {
		Configuration config = new Configuration();
		config.addValue(ThisTestClass.class, Class.class, this.invocation.getMethod().getTest().getJavaClass());
		config.addDefaultValue(XpectInvocation.class, this.invocation);
		config.addDefaultValue(XjmXpectMethod.class, this.invocation.getMethod());
		config.addDefaultValue(XjmMethod.class, this.invocation.getMethod());
		return config;
	}

	protected List<IParameterProvider> collectParameters() {
		XjmXpectMethod method = getMethod();
		int count = method.getParameterCount();
		List<IParameterProvider> result = Arrays.asList(new IParameterProvider[count]);
		EList<IParameterProvider> parameters = getInvocation().getParameters();
		Annotation[][] annotations = method.getJavaMethod().getParameterAnnotations();
		Class<?>[] parameterTypes = method.getJavaMethod().getParameterTypes();
		for (int i = 0; i < count; i++) {
			if (parameters.get(i) != null)
				result.set(i, parameters.get(i));
			else {
				Class<?> expectedType = parameterTypes[i];
				IParameterProvider provider = state.tryGet(IParameterProvider.class, (Object[]) annotations[i]);
				if (provider == null) {
					Object value = state.tryGet(expectedType, (Object[]) annotations[i]);
					if (value != null)
						provider = new ParameterProvider(value);
				}
				if (provider != null) {
					result.set(i, ((XpectInvocationImplCustom) getInvocation()).adaptParameter(provider, expectedType));
					continue;
				}
			}
		}
		return result;
	}

	public Description createDescription() {
		XpectRunner runner = getUriRunner().getRunner();
		Class<?> javaClass = runner.getTestClass().getJavaClass();
		Description description = DescriptionFactory.createTestDescription(javaClass, runner.getUriProvider(), invocation);
		return description;
	}

	protected Object[] createParameterValues(List<IParameterProvider> proposedParameters) {
		XjmXpectMethod method = getMethod();
		Object[] params = new Object[method.getParameterCount()];
		for (int i = 0; i < method.getParameterCount(); i++) {
			Class<?>[] expectedTypes = method.getJavaMethod().getParameterTypes();
			if (proposedParameters.get(i) != null)
				params[i] = proposedParameters.get(i).get(expectedTypes[i], state);
		}
		return params;
	}

	public XpectInvocation getInvocation() {
		return invocation;
	}

	public XjmXpectMethod getMethod() {
		return invocation.getMethod();
	}

	@Override
	protected boolean isIgnore() {
		return invocation.getFile().isIgnore() || invocation.isIgnore() || super.isIgnore();
	}

	@Override
	protected void runInternal() throws Throwable {
		Object test = state.get(Object.class, ThisTestObject.class).get();
		// Object test =
		// getInvocation().getMethod().getTest().getJavaClass().newInstance();
		// ctx.setXpectInvocation(getInvocation());
		// ctx.setMethod(getMethod());
		// ctx.setTestInstance(test);
		try {
			// if (setup != null)
			// ctx.setUserTestCtx(setup.beforeTest(ctx, ctx.getUserFileCtx()));
			List<IParameterProvider> parameterProviders = collectParameters();
			Object[] params = createParameterValues(parameterProviders);
			getMethod().getJavaMethod().invoke(test, params);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		}
		// finally {
		// if (setup != null)
		// setup.afterTest(ctx, ctx.getUserTestCtx());
		// }
	}

}
