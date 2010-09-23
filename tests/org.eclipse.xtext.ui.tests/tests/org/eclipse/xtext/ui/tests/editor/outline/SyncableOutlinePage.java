/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import java.util.concurrent.TimeoutException;

import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

/**
 * This horrible hack allows to wait for outline tree updates without blocking the display thread.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class SyncableOutlinePage extends OutlinePage {

	private volatile DisplaySafeSyncer syncer = new DisplaySafeSyncer();
	
	public void resetSyncer() throws InterruptedException {
		getRefreshJob().join();
		syncer.start();
	}

	public void waitForUpdate(long timeout) throws TimeoutException, InterruptedException {
		syncer.awaitSignal(timeout);
	}

	@Override
	protected void treeUpdated() {
		super.treeUpdated();
		syncer.signal();
	}
}
