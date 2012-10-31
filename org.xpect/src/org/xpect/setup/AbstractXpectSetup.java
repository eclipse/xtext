/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.setup;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
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
