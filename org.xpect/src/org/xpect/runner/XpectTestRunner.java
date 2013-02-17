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
import org.xpect.runner.IXpectParameterProvider.IClaimedRegion;
import org.xpect.runner.IXpectParameterProvider.IXpectMultiParameterProvider;
import org.xpect.runner.IXpectParameterProvider.IXpectSingleParameterProvider;
import org.xpect.setup.IXpectRunnerSetup;
import org.xpect.setup.SetupContext;
import org.xpect.util.IRegion;
import org.xpect.util.ITypedAdapter;
import org.xpect.util.ITypedProvider;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectTestRunner extends AbstractTestRunner {

	public static class ClaimedRegion implements IClaimedRegion {
		private final IXpectParameterProvider claimer;
		private final IRegion delegate;

		public ClaimedRegion(IXpectParameterProvider claimer, IRegion delegate) {
			super();
			this.claimer = claimer;
			this.delegate = delegate;
		}

		public IXpectParameterProvider getClaminer() {
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

	protected List<List<ITypedProvider>> collectAllParameters() throws Exception {
		List<IClaimedRegion> claimedRegions = collectClaimedRegions();
		List<List<ITypedProvider>> result = Lists.newArrayList();
		List<ITypedProvider> first = null;
		for (int i = 0; i < method.getParameterCount(); i++) {
			IXpectSingleParameterProvider claimer = method.getSingleParameterProviders().get(i);
			if (claimer != null) {
				if (first == null)
					first = Arrays.asList(new ITypedProvider[method.getParameterCount()]);
				ITypedProvider value = claimer.parseRegion(this, i, claimedRegions);
				first.set(i, value);
			}
		}
		if (first != null)
			result.add(first);
		for (IXpectMultiParameterProvider claimer : method.getMultiParameterProviders())
			result.add(claimer.parseRegion(this, claimedRegions));
		return result;
	}

	protected List<IClaimedRegion> collectClaimedRegions() {
		List<IClaimedRegion> result = Lists.newArrayList();
		for (int i = 0; i < method.getParameterCount(); i++) {
			IXpectSingleParameterProvider claimer = method.getSingleParameterProviders().get(i);
			if (claimer != null) {
				IRegion claim = claimer.claimRegion(this, i);
				if (claim != null)
					result.add(new ClaimedRegion(claimer, claim));
			}
		}
		for (IXpectMultiParameterProvider claimer : method.getMultiParameterProviders()) {
			IRegion claim = claimer.claimRegion(this);
			if (claim != null)
				result.add(new ClaimedRegion(claimer, claim));
		}
		return result;
	}

	protected ITypedProvider collectProposedParameter(int paramIndex, List<ITypedProvider> candidates, List<ITypedAdapter> adapter) {
		Class<?> expectedType = method.getJavaMethod().getParameterTypes()[paramIndex];
		for (ITypedProvider tp : candidates)
			if (tp.canProvide(expectedType))
				return tp;
		for (ITypedProvider tp : candidates)
			for (ITypedAdapter ta : adapter)
				if (ta.canAdapt(tp, expectedType))
					return ta.adapt(tp, expectedType);
		return null;
	}

	protected List<ITypedProvider> collectProposedParameters(List<List<ITypedProvider>> allParams,
			Map<Class<? extends Annotation>, ITypedProvider> setupValues, List<ITypedAdapter> adapter) {
		List<ITypedProvider> result = Arrays.asList(new ITypedProvider[method.getParameterCount()]);
		for (int i = 0; i < method.getParameterCount(); i++) {
			List<ITypedProvider> candidates = Lists.newArrayList();
			for (List<ITypedProvider> col : allParams)
				if (col.get(i) != null)
					candidates.add(col.get(i));
			for (Annotation ann : method.getJavaMethod().getParameterAnnotations()[i]) {
				ITypedProvider provider = setupValues.get(ann.annotationType());
				if (provider != null)
					candidates.add(provider);
			}
			result.set(i, collectProposedParameter(i, candidates, adapter));
		}
		return result;
	}

	protected Object[] createParameterValues(List<ITypedProvider> proposedParameters) {
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
		List<List<ITypedProvider>> allParameters = collectAllParameters();
		Object test = getInvocation().getMethod().getTest().getJavaClass().newInstance();
		// ctx.setAllParameters(allParameters);
		ctx.setXpectInvocation(getInvocation());
		ctx.setMethod(method);
		ctx.setTestInstance(test);
		try {
			if (setup != null)
				ctx.setUserTestCtx(setup.beforeTest(ctx, ctx.getUserFileCtx()));
			List<ITypedProvider> proposedParameters = collectProposedParameters(allParameters, ctx.getParamValues(), ctx.getParamAdapters());
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
