/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.swt.widgets.Display;
import org.junit.Assert;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DisplaySafeSyncer {

	private volatile CountDownLatch latch;

	public void start() throws InterruptedException {
		Assert.assertNull(latch);
		latch = new CountDownLatch(1);
	}

	public void awaitSignal(long timeout) throws TimeoutException, InterruptedException {
		try {
			Assert.assertNotNull("Syncer must have been started", latch);
			long waitTime = 0;
			while (waitTime < timeout) {
				if (latch.await(10, TimeUnit.MILLISECONDS)) {
					latch = null;
					return;
				}
				waitTime += 10;
				if (Display.getCurrent() != null) {
					while(Display.getCurrent().readAndDispatch()) {
						// work the event loop
					}
					
				}
			}
			throw new TimeoutException("Timeout in Syncer (timeout " + timeout + " ms)");
		} finally {
			latch = null;
		}
	}
	

	public void signal() {
		if (latch != null) {
			latch.countDown();
		}
	}
}
