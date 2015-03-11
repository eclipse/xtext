/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.swt.widgets.Display;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DisplaySafeSyncer {

	private volatile CountDownLatch latch;

	public void start() throws InterruptedException {
		if (latch == null)
			latch = new CountDownLatch(1);
	}

	public void awaitSignal(long timeout) throws TimeoutException, InterruptedException {
		if (latch == null)
			throw new IllegalStateException("Syncher must be initialized");
		long waitTime = 0;
		while (waitTime < timeout) {
			if (latch.await(10, TimeUnit.MILLISECONDS)) {
				latch = null;
				return;
			}
			waitTime += 10;
			if (Display.getCurrent() != null)
				Display.getCurrent().readAndDispatch();
		}
		throw new TimeoutException("Timeout in Syncer (timeout " + timeout + " ms)");
	}

	public void signal() {
		if (latch != null)
			latch.countDown();
	}
}
