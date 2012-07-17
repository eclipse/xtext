package org.eclipse.xpect.setup;

public class AbstractXpectSetup<T, K, V> implements IXpectSetup<T, K, V> {

	@Override
	public T beforeClass(org.eclipse.xpect.setup.IXpectSetup.IClassSetupContext frameworkCtx) {
		return null;
	}

	@Override
	public K beforeFile(org.eclipse.xpect.setup.IXpectSetup.IFileSetupContext frameworkCtx, T userCtx) {
		return null;
	}

	@Override
	public V beforeTest(org.eclipse.xpect.setup.IXpectSetup.ITestSetupContext frameworkCtx, K userCtx) {
		return null;
	}

	@Override
	public void afterTest(org.eclipse.xpect.setup.IXpectSetup.ITestSetupContext frameworkCtx, V userCtx) {
	}

	@Override
	public void afterFile(org.eclipse.xpect.setup.IXpectSetup.IFileSetupContext frameworkCtx, K userCtx) {
	}

	@Override
	public void afterClass(org.eclipse.xpect.setup.IXpectSetup.IClassSetupContext frameworkCtx, T userCtx) {
	}

}
