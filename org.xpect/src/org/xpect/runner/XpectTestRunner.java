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

import org.xpect.XjmXpectMethod;
import org.xpect.XpectInvocation;
import org.xpect.parameter.IParameterAdapter;
import org.xpect.parameter.IParameterParser;
import org.xpect.parameter.IParameterProvider;
import org.xpect.parameter.IParameterParser.IClaimedRegion;
import org.xpect.parameter.IParameterParser.IMultiParameterParser;
import org.xpect.parameter.IParameterParser.ISingleParameterParser;
import org.xpect.setup.IXpectRunnerSetup;
import org.xpect.setup.SetupContext;
import org.xpect.util.IRegion;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectTestRunner extends AbstractTestRunner {

	public static class ClaimedRegion implements IClaimedRegion {
		private final IParameterParser claimer;
		private final IRegion delegate;

		public ClaimedRegion(IParameterParser claimer, IRegion delegate) {
			super();
			this.claimer = claimer;
			this.delegate = delegate;
		}

		public IParameterParser getClaminer() {
			return claimer;
		}

		public int getLength() {
			return delegate.getLength();
		}

		public int getOffset() {
			return delegate.getOffset();
		}
	}

	private XjmXpectMethod method;

	public XpectTestRunner(XpectFileRunner uriRunner, XpectInvocation invocation, XjmXpectMethod method) {
		super(uriRunner, invocation);
		this.method = method;
	}

	protected List<List<IParameterProvider>> collectAllParameters() throws Exception {
		List<IClaimedRegion> claimedRegions = collectClaimedRegions();
		List<List<IParameterProvider>> result = Lists.newArrayList();
		List<IParameterProvider> first = null;
		for (int i = 0; i < method.getParameterCount(); i++) {
			ISingleParameterParser claimer = method.getSingleParameterProviders().get(i);
			if (claimer != null) {
				if (first == null)
					first = Arrays.asList(new IParameterProvider[method.getParameterCount()]);
				IParameterProvider value = claimer.parseRegion(getInvocation(), i, claimedRegions);
				first.set(i, value);
			}
		}
		if (first != null)
			result.add(first);
		for (IMultiParameterParser claimer : method.getMultiParameterProviders())
			result.add(claimer.parseRegion(getInvocation(), claimedRegions));
		return result;
	}

	protected List<IClaimedRegion> collectClaimedRegions() {
		List<IClaimedRegion> result = Lists.newArrayList();
		for (int i = 0; i < method.getParameterCount(); i++) {
			ISingleParameterParser claimer = method.getSingleParameterProviders().get(i);
			if (claimer != null) {
				IRegion claim = claimer.claimRegion(getInvocation(), i);
				if (claim != null)
					result.add(new ClaimedRegion(claimer, claim));
			}
		}
		for (IMultiParameterParser claimer : method.getMultiParameterProviders()) {
			IRegion claim = claimer.claimRegion(getInvocation());
			if (claim != null)
				result.add(new ClaimedRegion(claimer, claim));
		}
		return result;
	}

	protected IParameterProvider collectProposedParameter(int paramIndex, List<IParameterProvider> candidates,
			List<IParameterAdapter> adapter) {
		Class<?> expectedType = method.getJavaMethod().getParameterTypes()[paramIndex];
		for (IParameterProvider tp : candidates)
			if (tp.canProvide(expectedType))
				return tp;
		for (IParameterProvider tp : candidates)
			for (IParameterAdapter ta : adapter)
				if (ta.canAdapt(tp, expectedType))
					return ta.adapt(tp, expectedType);
		return null;
	}

	protected List<IParameterProvider> collectProposedParameters(List<List<IParameterProvider>> allParams,
			Map<Class<? extends Annotation>, IParameterProvider> setupValues, List<IParameterAdapter> adapter) {
		List<IParameterProvider> result = Arrays.asList(new IParameterProvider[method.getParameterCount()]);
		for (int i = 0; i < method.getParameterCount(); i++) {
			List<IParameterProvider> candidates = Lists.newArrayList();
			for (List<IParameterProvider> col : allParams)
				if (col.get(i) != null)
					candidates.add(col.get(i));
			for (Annotation ann : method.getJavaMethod().getParameterAnnotations()[i]) {
				IParameterProvider provider = setupValues.get(ann.annotationType());
				if (provider != null)
					candidates.add(provider);
			}
			result.set(i, collectProposedParameter(i, candidates, adapter));
		}
		return result;
	}

	protected Object[] createParameterValues(List<IParameterProvider> proposedParameters) {
		Object[] params = new Object[method.getParameterCount()];
		for (int i = 0; i < method.getParameterCount(); i++) {
			Class<?>[] expectedTypes = method.getJavaMethod().getParameterTypes();
			if (proposedParameters.get(i) != null)
				params[i] = proposedParameters.get(i).get(expectedTypes[i]);
		}
		return params;
	}

	public XjmXpectMethod getMethod() {
		return method;
	}

	@Override
	protected void runInternal(IXpectRunnerSetup<Object, Object, Object, Object> setup, SetupContext ctx) throws Throwable {
		List<List<IParameterProvider>> allParameters = collectAllParameters();
		Object test = getInvocation().getMethod().getTest().getJavaClass().newInstance();
		// ctx.setAllParameters(allParameters);
		ctx.setXpectInvocation(getInvocation());
		ctx.setMethod(method);
		ctx.setTestInstance(test);
		try {
			if (setup != null)
				ctx.setUserTestCtx(setup.beforeTest(ctx, ctx.getUserFileCtx()));
			List<IParameterProvider> proposedParameters = collectProposedParameters(allParameters, ctx.getParamValues(),
					ctx.getParamAdapters());
			// ctx.setProposedParameters(proposedParameters);
			Object[] params = createParameterValues(proposedParameters);
			method.getJavaMethod().invoke(test, params);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		} finally {
			if (setup != null)
				setup.afterTest(ctx, ctx.getUserTestCtx());
		}

	}

}
