package org.eclipse.xpect.lib;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xpect.lib.IXpectParameterProvider.IClaimedRegion;
import org.eclipse.xpect.lib.IXpectParameterProvider.IRegion;
import org.eclipse.xpect.lib.IXpectParameterProvider.IXpectMultiParameterProvider;
import org.eclipse.xpect.lib.IXpectParameterProvider.IXpectSingleParameterProvider;
import org.eclipse.xpect.xpect.XpectInvocation;
import org.eclipse.xpect.xpect.XpectPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import com.google.common.collect.Lists;

public class XpectTestRunner {

	public static class ClaimedRegion implements IClaimedRegion {
		private final IXpectParameterProvider claimer;
		private final IRegion delegate;

		public ClaimedRegion(IXpectParameterProvider claimer, IRegion delegate) {
			super();
			this.claimer = claimer;
			this.delegate = delegate;
		}

		@Override
		public IXpectParameterProvider getClaminer() {
			return claimer;
		}

		@Override
		public int getLength() {
			return delegate.getLength();
		}

		@Override
		public int getOffset() {
			return delegate.getOffset();
		}
	}

	private Description description;

	private Throwable error;
	private XpectInvocation invocation;
	private XpectFrameworkMethod method;
	private XpectFileRunner uriRunner;

	public XpectTestRunner(XpectFileRunner uriRunner, XpectInvocation invocation) {
		super();
		this.uriRunner = uriRunner;
		this.invocation = invocation;
		try {
			this.method = uriRunner.getRunner().getFrameworkMethod(invocation.getElement());
		} catch (Throwable e) {
			this.error = e;
		}
	}

	protected List<List<ITypedProvider>> collectAllParameters() throws Exception {
		List<IClaimedRegion> claimedRegions = collectClaimedRegions();
		List<List<ITypedProvider>> result = Lists.newArrayList();
		List<ITypedProvider> first = null;
		for (int i = 0; i < method.getParameterCount(); i++) {
			IXpectSingleParameterProvider claimer = method.getSingleParameterProvider().get(i);
			if (claimer != null) {
				if (first == null)
					first = Arrays.asList(new ITypedProvider[method.getParameterCount()]);
				ITypedProvider value = claimer.parseRegion(this, i, claimedRegions);
				first.set(i, value);
			}
		}
		if (first != null)
			result.add(first);
		for (IXpectMultiParameterProvider claimer : method.getMultiParameterProvider())
			result.add(claimer.parseRegion(this, claimedRegions));
		return result;
	}

	protected List<IClaimedRegion> collectClaimedRegions() {
		List<IClaimedRegion> result = Lists.newArrayList();
		for (int i = 0; i < method.getParameterCount(); i++) {
			IXpectSingleParameterProvider claimer = method.getSingleParameterProvider().get(i);
			if (claimer != null) {
				IRegion claim = claimer.claimRegion(this, i);
				result.add(new ClaimedRegion(claimer, claim));
			}
		}
		for (IXpectMultiParameterProvider claimer : method.getMultiParameterProvider()) {
			IRegion claim = claimer.claimRegion(this);
			result.add(new ClaimedRegion(claimer, claim));
		}
		return result;
	}

	protected ITypedProvider collectProposedParameter(int paramIndex, List<ITypedProvider> candidates, List<ITypedAdapter> adapter) {
		Class<?> expectedType = method.getMethod().getParameterTypes()[paramIndex];
		for (ITypedProvider tp : candidates)
			if (tp.canProvide(expectedType))
				return tp;
		for (ITypedProvider tp : candidates)
			for (ITypedAdapter ta : adapter)
				if (ta.canAdapt(tp, expectedType))
					return ta.adapt(tp, expectedType);
		return null;
	}

	protected List<ITypedProvider> collectProposedParameters(List<List<ITypedProvider>> allParams, List<ITypedAdapter> adapter) {
		List<ITypedProvider> result = Arrays.asList(new ITypedProvider[method.getParameterCount()]);
		for (int i = 0; i < method.getParameterCount(); i++) {
			List<ITypedProvider> candidates = Lists.newArrayList();
			for (List<ITypedProvider> col : allParams)
				if (col.get(i) != null)
					candidates.add(col.get(i));
			result.set(i, collectProposedParameter(i, candidates, adapter));
		}
		return result;
	}

	public String getMethodName() {
		if (method != null && method.getMethod() != null)
			return method.getMethod().getName();
		for (INode node : NodeModelUtils.findNodesForFeature(invocation, XpectPackage.Literals.XPECT_INVOCATION__ELEMENT))
			return NodeModelUtils.getTokenText(node);
		return "(error)";
	}

	public Description createDescription() {
		XpectRunner runner = uriRunner.getRunner();
		Class<?> javaClass = runner.getTestClass().getJavaClass();
		return Description.createTestDescription(javaClass, runner.getUniqueName(getMethodName()));
	}

	protected Object[] createParameterValues(List<ITypedProvider> proposedParameters) {
		Object[] params = new Object[method.getParameterCount()];
		for (int i = 0; i < method.getParameterCount(); i++) {
			Class<?>[] expectedTypes = method.getMethod().getParameterTypes();
			if (proposedParameters.get(i) != null)
				params[i] = proposedParameters.get(i).get(expectedTypes[i]);
		}
		return params;
	}

	public Description getDescription() {
		if (this.description == null)
			this.description = createDescription();
		return description;
	}

	public String getDocument() {
		return ((XtextResource) invocation.eResource()).getParseResult().getRootNode().getText();
	}

	public Throwable getError() {
		return error;
	}

	public XpectInvocation getInvocation() {
		return invocation;
	}

	public XpectFrameworkMethod getMethod() {
		return method;
	}

	public XpectFileRunner getUriRunner() {
		return uriRunner;
	}

	public void run(RunNotifier notifier, IXpectSetup<Object, Object, Object> setup, SetupContext ctx) {
		notifier.fireTestStarted(getDescription());
		try {
			if (invocation.isIgnore())
				notifier.fireTestIgnored(getDescription());
			else if (error != null)
				notifier.fireTestFailure(new Failure(getDescription(), error));
			else {
				runInternal(setup, ctx);
			}
		} catch (Throwable t) {
			notifier.fireTestFailure(new Failure(getDescription(), t));
		} finally {
			notifier.fireTestFinished(getDescription());
		}
	}

	protected void runInternal(IXpectSetup<Object, Object, Object> setup, SetupContext ctx) throws Throwable {
		List<List<ITypedProvider>> allParameters = collectAllParameters();
		List<ITypedProvider> proposedParameters = collectProposedParameters(allParameters, ctx.getParamAdapters());
		Object test = uriRunner.getRunner().getTestClass().getJavaClass().newInstance();
		ctx.setProposedParameters(proposedParameters);
		ctx.setAllParameters(allParameters);
		ctx.setXpectInvocation(invocation);
		ctx.setMethod(method);
		ctx.setTestInstance(test);
		try {
			if (setup != null)
				ctx.setUserTestCtx(setup.beforeTest(ctx, ctx.getUserFileCtx()));
			Object[] params = createParameterValues(proposedParameters);
			method.getMethod().invoke(test, params);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		} finally {
			if (setup != null)
				setup.afterTest(ctx, ctx.getUserTestCtx());
		}

	}

}
