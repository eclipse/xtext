package org.xpect.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.xpect.XjmSetup;
import org.xpect.XjmTest;
import org.xpect.XjmXpectMethod;
import org.xpect.XpectConstants;
import org.xpect.parameter.IParameterAdapter;
import org.xpect.parameter.IParameterParser;
import org.xpect.parameter.IParameterParser.IClaimedRegion;
import org.xpect.parameter.IParameterParser.IMultiParameterParser;
import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.parameter.IParameterParser.ISingleParameterParser;
import org.xpect.parameter.IParameterProvider;
import org.xpect.registry.ILanguageInfo;
import org.xpect.util.IJavaReflectAccess;
import org.xpect.util.IRegion;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

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
		XjmXpectMethod xpectMethod = getMethod();
		if (xpectMethod != null) {
			for (int i = 0; i < xpectMethod.getParameterCount(); i++) {
				ISingleParameterParser claimer = xpectMethod.getSingleParameterProviders().get(i);
				if (claimer != null) {
					IRegion claim = claimer.claimRegion(this, i);
					if (claim != null)
						result.add(new ClaimedRegion(claimer, claim));
				}
			}
			for (IMultiParameterParser claimer : xpectMethod.getMultiParameterProviders()) {
				IRegion claim = claimer.claimRegion(this);
				if (claim != null)
					result.add(new ClaimedRegion(claimer, claim));
			}
		}
		return result;
	}

	protected List<List<IParsedParameterProvider>> collectParsedParameters(List<IClaimedRegion> claimedRegions) {
		XjmXpectMethod xpectMethod = getMethod();
		List<List<IParsedParameterProvider>> result = Lists.newArrayList();
		if (xpectMethod != null) {
			List<IParsedParameterProvider> first = null;
			for (int i = 0; i < xpectMethod.getParameterCount(); i++) {
				ISingleParameterParser claimer = xpectMethod.getSingleParameterProviders().get(i);
				if (claimer != null) {
					if (first == null)
						first = Arrays.asList(new IParsedParameterProvider[xpectMethod.getParameterCount()]);
					IParsedParameterProvider value = claimer.parseRegion(this, i, claimedRegions);
					first.set(i, value);
				}
			}
			if (first != null)
				result.add(first);
			for (IMultiParameterParser claimer : xpectMethod.getMultiParameterProviders())
				result.add(claimer.parseRegion(this, claimedRegions));
		}
		return result;
	}

	protected IParameterProvider collectProposedParameter(int paramIndex, List<IParameterProvider> candidates) {
		Class<?> expectedType = getParameterType(paramIndex);
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

	protected Class<?> getParameterType(int paramIndex) {
		Injector injector = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(XpectConstants.XPECT_FILE_EXT).getInjector();
		IJavaReflectAccess reflectAccess = injector.getInstance(IJavaReflectAccess.class);
		XjmXpectMethod xpectMethod = getMethod();
		if (xpectMethod == null)
			return null;
		JvmOperation jvmMethod = xpectMethod.getJvmMethod();
		if (jvmMethod == null || jvmMethod.eIsProxy())
			return null;
		JvmTypeReference parameterType = jvmMethod.getParameters().get(paramIndex).getParameterType();
		if (parameterType == null || parameterType.eIsProxy() || parameterType.getType() == null)
			return null;
		Class<?> expectedType = reflectAccess.getRawType(parameterType.getType());
		return expectedType;
	}

	protected List<IParameterProvider> collectProposedParameters(List<List<IParsedParameterProvider>> allParams) {
		XjmXpectMethod xpectMethod = getMethod();
		if (xpectMethod == null)
			return Collections.emptyList();
		int count = xpectMethod.getParameterCount();
		List<IParameterProvider> result = Arrays.asList(new IParameterProvider[count]);
		for (int i = 0; i < count; i++) {
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
