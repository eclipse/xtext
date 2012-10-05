package org.eclipse.xpect.setup;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.XpectFile;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.runner.IXpectURIProvider;
import org.eclipse.xpect.runner.XpectFrameworkMethod;
import org.eclipse.xpect.setup.IXpectSetup.ITestSetupContext;
import org.eclipse.xpect.util.ITypedAdapter;
import org.eclipse.xpect.util.ITypedProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SetupContext implements ITestSetupContext {

	private Collection<URI> allFiles;

	// private List<List<ITypedProvider>> allParameters;

	private XpectFrameworkMethod method;

	private List<ITypedAdapter> paramAdapters;

	private Map<Class<? extends Annotation>, ITypedProvider> paramValues;

	// private List<ITypedProvider> proposedParameters;

	private Class<?> testClass;

	private Object testInstance;

	private IXpectURIProvider uriProvider;

	private Object userClassCtx;

	private Object userFileCtx;

	private Object userTestCtx;

	private XpectFile xpectFile;

	private XpectInvocation xpectInvocation;

	@Override
	public Collection<URI> getAllFiles() {
		return allFiles;
	}

	// public List<List<ITypedProvider>> getAllParameters() {
	// return allParameters;
	// }
	//
	// @Override
	// public Collection<ITypedProvider> getAllParameterValues(int
	// parameterIndex) {
	// return allParameters.get(parameterIndex);
	// }

	@Override
	public XpectFrameworkMethod getMethod() {
		return method;
	}

	public List<ITypedAdapter> getParamAdapters() {
		if (paramAdapters == null)
			return Collections.emptyList();
		return paramAdapters;
	}

	public Map<Class<? extends Annotation>, ITypedProvider> getParamValues() {
		if (paramValues == null)
			return Collections.emptyMap();
		return paramValues;
	}

	// public List<ITypedProvider> getProposedParameters() {
	// return proposedParameters;
	// }
	//
	// @Override
	// public ITypedProvider getProposedParameterValue(int parameterIndex) {
	// return proposedParameters.get(parameterIndex);
	// }

	@Override
	public Class<?> getTestClass() {
		return testClass;
	}

	@Override
	public Object getTestInstance() {
		return testInstance;
	}

	@Override
	public IXpectURIProvider getURIProvider() {
		return uriProvider;
	}

	public Object getUserClassCtx() {
		return userClassCtx;
	}

	public Object getUserFileCtx() {
		return userFileCtx;
	}

	public Object getUserTestCtx() {
		return userTestCtx;
	}

	@Override
	public XpectFile getXpectFile() {
		return xpectFile;
	}

	@Override
	public XpectInvocation getXpectInvocation() {
		return xpectInvocation;
	}

	@Override
	public void installParameterAdapter(ITypedAdapter adapter) {
		if (paramAdapters == null)
			paramAdapters = Lists.newArrayList();
		paramAdapters.add(adapter);
	}

	@Override
	public void installParameterValue(Class<? extends Annotation> key, ITypedProvider provider) {
		if (paramValues == null)
			paramValues = Maps.newLinkedHashMap();
		paramValues.put(key, provider);
	}

	public void setAllFiles(Collection<URI> allFiles) {
		this.allFiles = allFiles;
	}

	// public void setAllParameters(List<List<ITypedProvider>> allParameters) {
	// this.allParameters = allParameters;
	// }

	public void setMethod(XpectFrameworkMethod method) {
		this.method = method;
	}

	// @Override
	// public void setParameterValue(int parameterIndex, ITypedProvider value) {
	// proposedParameters.set(parameterIndex, value);
	// }

	// public void setProposedParameters(List<ITypedProvider>
	// proposedParameters) {
	// this.proposedParameters = proposedParameters;
	// }

	public void setTestClass(Class<?> testClass) {
		this.testClass = testClass;
	}

	public void setTestInstance(Object testInstance) {
		this.testInstance = testInstance;
	}

	public void setUriProvider(IXpectURIProvider uriProvider) {
		this.uriProvider = uriProvider;
	}

	public void setUserClassCtx(Object userClassCtx) {
		this.userClassCtx = userClassCtx;
	}

	public void setUserFileCtx(Object userFileCtx) {
		this.userFileCtx = userFileCtx;
	}

	public void setUserTestCtx(Object userTestCtx) {
		this.userTestCtx = userTestCtx;
	}

	public void setXpectFile(XpectFile xpectFile) {
		this.xpectFile = xpectFile;
	}

	public void setXpectInvocation(XpectInvocation xpectInvocation) {
		this.xpectInvocation = xpectInvocation;
	}

}
