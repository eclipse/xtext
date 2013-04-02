package org.xpect.model;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.xpect.XjmSetup;
import org.xpect.XjmTest;
import org.xpect.XjmXpectMethod;
import org.xpect.parameter.IParameterAdapter;
import org.xpect.parameter.IParameterParser;
import org.xpect.parameter.IParameterParser.IClaimedRegion;
import org.xpect.parameter.IParameterParser.IMultiParameterParser;
import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.parameter.IParameterParser.ISingleParameterParser;
import org.xpect.parameter.IParameterProvider;
import org.xpect.util.IRegion;

import com.google.common.collect.Lists;

public class XpectInvocationImplCustom extends XpectInvocationImpl {
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

	public IParameterProvider adaptParameter(IParameterProvider param, Class<?> expectedType) {
		if (param.canProvide(expectedType))
			return param;
		XjmXpectMethod xpectMethod = getMethod();
		if (xpectMethod == null)
			return null;
		XjmTest test = xpectMethod.getTest();
		if (test == null)
			return null;
		for (IParameterAdapter adapter : test.getParameterAdapters())
			if (adapter.canAdapt(param, expectedType))
				return adapter.adapt(param, expectedType);
		for (XjmSetup setup : test.getSetups())
			for (IParameterAdapter adapter : setup.getParameterAdapters())
				if (adapter.canAdapt(param, expectedType))
					return adapter.adapt(param, expectedType);
		return null;
	}

	protected List<IClaimedRegion> collectClaimedRegions() {
		List<IClaimedRegion> result = Lists.newArrayList();
		for (int i = 0; i < method.getParameterCount(); i++) {
			ISingleParameterParser claimer = method.getSingleParameterProviders().get(i);
			if (claimer != null) {
				IRegion claim = claimer.claimRegion(this, i);
				if (claim != null)
					result.add(new ClaimedRegion(claimer, claim));
			}
		}
		for (IMultiParameterParser claimer : method.getMultiParameterProviders()) {
			IRegion claim = claimer.claimRegion(this);
			if (claim != null)
				result.add(new ClaimedRegion(claimer, claim));
		}
		return result;
	}

	protected List<List<IParsedParameterProvider>> collectParsedParameters(List<IClaimedRegion> claimedRegions) {
		List<List<IParsedParameterProvider>> result = Lists.newArrayList();
		List<IParsedParameterProvider> first = null;
		for (int i = 0; i < method.getParameterCount(); i++) {
			ISingleParameterParser claimer = method.getSingleParameterProviders().get(i);
			if (claimer != null) {
				if (first == null)
					first = Arrays.asList(new IParsedParameterProvider[method.getParameterCount()]);
				IParsedParameterProvider value = claimer.parseRegion(this, i, claimedRegions);
				first.set(i, value);
			}
		}
		if (first != null)
			result.add(first);
		for (IMultiParameterParser claimer : method.getMultiParameterProviders())
			result.add(claimer.parseRegion(this, claimedRegions));
		return result;
	}

	protected IParameterProvider collectProposedParameter(int paramIndex, List<IParameterProvider> candidates) {
		Class<?> expectedType = method.getJavaMethod().getParameterTypes()[paramIndex];
		for (IParameterProvider tp : candidates)
			if (tp.canProvide(expectedType))
				return tp;
		for (IParameterProvider tp : candidates) {
			IParameterProvider adapted = adaptParameter(tp, expectedType);
			if (adapted != null)
				return adapted;
		}
		return null;
	}

	protected List<IParameterProvider> collectProposedParameters(List<List<IParsedParameterProvider>> allParams) {
		List<IParameterProvider> result = Arrays.asList(new IParameterProvider[method.getParameterCount()]);
		for (int i = 0; i < method.getParameterCount(); i++) {
			List<IParameterProvider> candidates = Lists.newArrayList();
			for (List<? extends IParameterProvider> col : allParams)
				if (col.get(i) != null)
					candidates.add(col.get(i));
			result.set(i, collectProposedParameter(i, candidates));
		}
		return result;
	}

	@Override
	public EList<IParameterProvider> getParameters() {
		if (this.parameters == null) {
			List<IClaimedRegion> claimedRegions = collectClaimedRegions();
			List<List<IParsedParameterProvider>> parsedParameters = collectParsedParameters(claimedRegions);
			List<IParameterProvider> proposedParameters = collectProposedParameters(parsedParameters);
			super.getParameters().addAll(proposedParameters);
		}
		return super.getParameters();
	}

	@Override
	public void setMethod(XjmXpectMethod newMethod) {
		this.parameters = null;
		super.setMethod(newMethod);
	}

}
