package org.eclipse.xpect.runner;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.setup.IXpectSetup;
import org.eclipse.xpect.setup.SetupContext;
import org.eclipse.xpect.setup.XpectSetup;
import org.eclipse.xpect.util.AnnotationUtil;
import org.eclipse.xtext.common.types.JvmOperation;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class XpectRunner extends ParentRunner<XpectFileRunner> {

	private List<XpectFileRunner> children;
	private Collection<URI> files;
	private Map<String, XpectFrameworkMethod> methods = Maps.newHashMap();
	private Set<String> names = Sets.newHashSet();
	private IXpectURIProvider uriProvider;

	public XpectRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
		this.uriProvider = findUriProvider(testClass);
		if (this.uriProvider == null)
			throw new InitializationError("No " + IXpectURIProvider.class + " found for " + testClass
					+ ". This can be any annotation that is annotated with @" + XpectURIProvider.class);
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

	protected XpectFrameworkMethod createCrameworkMethod(JvmOperation op) throws InitializationError {
		return new XpectFrameworkMethod(getTestClass().getJavaClass(), op);
	}

	@SuppressWarnings("unchecked")
	protected IXpectSetup<Object, Object, Object, Object> createSetup(Class<?> clazz) {
		return AnnotationUtil.newInstanceViaAnnotation(clazz, XpectSetup.class, IXpectSetup.class);
	}

	protected SetupContext createSetupContext(IXpectSetup<Object, Object, Object, Object> setup) {
		return new SetupContext();
	}

	@Override
	protected Description describeChild(XpectFileRunner child) {
		return child.getDescription();
	}

	protected IXpectURIProvider findUriProvider(Class<?> clazz) {
		return AnnotationUtil.newInstanceViaMetaAnnotation(clazz, XpectURIProvider.class, IXpectURIProvider.class);
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

	public XpectFrameworkMethod getFrameworkMethod(JvmOperation op) throws InitializationError {
		if (op == null)
			throw new NullPointerException("operation is null.");
		if (op.eIsProxy())
			throw new NullPointerException("operation is an unresolved proxy.");
		String key = op.getQualifiedName();
		XpectFrameworkMethod result = methods.get(key);
		if (result == null)
			methods.put(key, result = createCrameworkMethod(op));
		return result;
	}

	public String getUniqueName(String proposal) {
		if (!names.contains(proposal)) {
			names.add(proposal);
			return proposal;
		}
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			String candidate = proposal + "#" + i;
			if (!names.contains(candidate)) {
				names.add(candidate);
				return candidate;
			}
		}
		return proposal;
	}

	public IXpectURIProvider getUriProvider() {
		return uriProvider;
	}

	@Override
	protected void runChild(XpectFileRunner child, RunNotifier notifier) {
		IXpectSetup<Object, Object, Object, Object> setup = createSetup(getTestClass().getJavaClass());
		SetupContext ctx = createSetupContext(setup);
		ctx.setAllFiles(getFiles());
		ctx.setTestClass(getTestClass().getJavaClass());
		ctx.setUriProvider(uriProvider);
		try {
			if (setup != null)
				setup.beforeClass(ctx);
			child.run(notifier, setup, ctx);
		} catch (Throwable t) {
			notifier.fireTestFailure(new Failure(getDescription(), t));
		} finally {
			try {
				if (setup != null)
					setup.afterClass(ctx, ctx.getUserClassCtx());
			} catch (Throwable t) {
				notifier.fireTestFailure(new Failure(getDescription(), t));
			}
		}
	}
}
