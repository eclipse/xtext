/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.util.Wrapper;

public abstract class DisplayRunnable {
	
	protected abstract void run() throws Exception;

	public void syncExec() {
		if (Display.getCurrent() == null) {
			final Wrapper<Exception> exceptionWrapper = new Wrapper<Exception>();
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						DisplayRunnable.this.run();
					} catch (Exception e) {
						exceptionWrapper.set(e);
					}
				}
			});
			if (exceptionWrapper.get() != null)
				throw new WrappedException(exceptionWrapper.get());
		} else {
			try {
				run();
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		}
	}

}