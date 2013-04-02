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
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.xpect.XjmXpectMethod;
import org.xpect.XpectInvocation;
import org.xpect.model.XpectInvocationImplCustom;
import org.xpect.parameter.IParameterProvider;
import org.xpect.setup.IXpectRunnerSetup;
import org.xpect.setup.SetupContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectTestRunner extends AbstractTestRunner {

	private XjmXpectMethod method;

	public XpectTestRunner(XpectFileRunner uriRunner, XpectInvocation invocation, XjmXpectMethod method) {
		super(uriRunner, invocation);
		this.method = method;
	}

	protected List<IParameterProvider> collectParameters(Map<Class<? extends Annotation>, IParameterProvider> setupValues) {
		List<IParameterProvider> result = Arrays.asList(new IParameterProvider[method.getParameterCount()]);
		EList<IParameterProvider> parameters = getInvocation().getParameters();
		for (int i = 0; i < method.getParameterCount(); i++) {
			if (parameters.get(i) != null)
				result.set(i, parameters.get(i));
			else {
				for (Annotation ann : method.getJavaMethod().getParameterAnnotations()[i]) {
					IParameterProvider provider = setupValues.get(ann.annotationType());
					if (provider != null) {
						Class<?> expectedType = method.getJavaMethod().getParameterTypes()[i];
						result.set(i, ((XpectInvocationImplCustom) getInvocation()).adaptParameter(provider, expectedType));
						continue;
					}
				}
			}
		}
		return result;
	}

	protected Object[] createParameterValues(List<IParameterProvider> proposedParameters,
			Map<Class<? extends Annotation>, IParameterProvider> setupValues) {
		Object[] params = new Object[method.getParameterCount()];
		for (int i = 0; i < method.getParameterCount(); i++) {
			Class<?>[] expectedTypes = method.getJavaMethod().getParameterTypes();
			if (proposedParameters.get(i) != null)
				params[i] = proposedParameters.get(i).get(expectedTypes[i], setupValues);
		}
		return params;
	}

	public XjmXpectMethod getMethod() {
		return method;
	}

	@Override
	protected void runInternal(IXpectRunnerSetup<Object, Object, Object, Object> setup, SetupContext ctx) throws Throwable {
		Object test = getInvocation().getMethod().getTest().getJavaClass().newInstance();
		ctx.setXpectInvocation(getInvocation());
		ctx.setMethod(method);
		ctx.setTestInstance(test);
		try {
			if (setup != null)
				ctx.setUserTestCtx(setup.beforeTest(ctx, ctx.getUserFileCtx()));
			List<IParameterProvider> parameterProviders = collectParameters(ctx.getParamValues());
			Object[] params = createParameterValues(parameterProviders, ctx.getParamValues());
			method.getJavaMethod().invoke(test, params);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		} finally {
			if (setup != null)
				setup.afterTest(ctx, ctx.getUserTestCtx());
		}

	}

}
