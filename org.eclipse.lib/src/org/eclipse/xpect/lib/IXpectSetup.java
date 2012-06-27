package org.eclipse.xpect.lib;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.xpect.XpectFile;
import org.eclipse.xpect.xpect.XpectInvocation;

public interface IXpectSetup<T, K, V> {

	public interface IClassSetupContext {

		Collection<URI> getAllFiles();

		Class<?> getTestClass();

		void installParameterAdapter(ITypedAdapter adapter);
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

	void afterClass(IClassSetupContext frameworkCtx, T userCtx);

	void afterFile(IFileSetupContext frameworkCtx, K userCtx);

	void afterTest(ITestSetupContext frameworkCtx, V userCtx);

	T beforeClass(IClassSetupContext frameworkCtx);

	K beforeFile(IFileSetupContext frameworkCtx, T userCtx);

	V beforeTest(ITestSetupContext frameworkCtx, K userCtx);
}
