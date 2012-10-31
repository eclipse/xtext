package org.xpect.setup;

public class AbstractXpectSetup<T, K, V, X> implements IXpectSetup<T, K, V, X> {

	@Override
	public T beforeClass(IClassSetupContext frameworkCtx) throws Exception {
		return null;
	}

	@Override
	public K beforeFile(IFileSetupContext frameworkCtx, T userCtx, ISetupInitializer<X> initializer) throws Exception {
		return null;
	}

	@Override
	public V beforeTest(ITestSetupContext frameworkCtx, K userCtx) throws Exception {
		return null;
	}

	@Override
	public void afterTest(ITestSetupContext frameworkCtx, V userCtx) throws Exception {
	}

	@Override
	public void afterFile(IFileSetupContext frameworkCtx, K userCtx) throws Exception {
	}

	@Override
	public void afterClass(IClassSetupContext frameworkCtx, T userCtx) throws Exception {
	}

}
