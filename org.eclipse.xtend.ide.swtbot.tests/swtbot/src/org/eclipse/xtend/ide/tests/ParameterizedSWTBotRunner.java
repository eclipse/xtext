/*******************************************************************************
 * Copyright (c) 2008 SWTBot Committers and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Hans Schwaebli - initial API and implementation (Bug 259787)
 *     Toby Weston  - initial API and implementation (Bug 259787)
 *******************************************************************************/
package org.eclipse.xtend.ide.tests;

import org.eclipse.swtbot.swt.finder.junit.ScreenshotCaptureListener;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Parameterized;

/**
 * A {@link Parameterized} runner that captures screenshots on test failures. 
 * Mixes the behavior of {@link Parameterized} and {@link SWTBotJunit4ClassRunner}.
 *
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @since 2.5
 */
public class ParameterizedSWTBotRunner extends Parameterized {

	/**
	 * Creates a SWTBotRunner to run {@code klass}
	 *
	 * @throws Exception if the test class is malformed.
	 */
	public ParameterizedSWTBotRunner(Class<?> klass) throws Throwable {
		super(klass);
	}

	@Override
	public void run(RunNotifier notifier) {
		RunListener failureSpy = new ScreenshotCaptureListener();
		notifier.removeListener(failureSpy); // remove existing listeners that could be added by suite or class runners
		notifier.addListener(failureSpy);
		try {
			super.run(notifier);
		} finally {
			notifier.removeListener(failureSpy);
		}
	}

}
