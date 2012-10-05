package org.eclipse.xpect.setup;

import java.lang.annotation.Annotation;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.XpectFile;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.runner.IXpectURIProvider;
import org.eclipse.xpect.runner.XpectFrameworkMethod;
import org.eclipse.xpect.util.ITypedAdapter;
import org.eclipse.xpect.util.ITypedProvider;

public interface IXpectSetup<T, K, V> {

	public interface IClassSetupContext {

		Collection<URI> getAllFiles();

		Class<?> getTestClass();

		void installParameterAdapter(ITypedAdapter adapter);

		void installParameterValue(Class<? extends Annotation> key, ITypedProvider provider);

		IXpectURIProvider getURIProvider();
	}

	public interface IFileSetupContext extends IClassSetupContext {
		XpectFile getXpectFile();
	}

	public interface ITestSetupContext extends IFileSetupContext {
		Collection<ITypedProvider> getAllParameterValues(int parameterIndex);

		XpectFrameworkMethod getMethod();

		ITypedProvider getProposedParameterValue(int parameterIndex);

		Object getTestInstance();

		XpectInvocation getXpectInvocation();

		void setParameterValue(int parameterIndex, ITypedProvider value);
	}

	void afterClass(IClassSetupContext frameworkCtx, T userCtx) throws Exception;

	void afterFile(IFileSetupContext frameworkCtx, K userCtx) throws Exception;

	void afterTest(ITestSetupContext frameworkCtx, V userCtx) throws Exception;

	T beforeClass(IClassSetupContext frameworkCtx) throws Exception;

	K beforeFile(IFileSetupContext frameworkCtx, T userCtx) throws Exception;

	V beforeTest(ITestSetupContext frameworkCtx, K userCtx) throws Exception;
}
