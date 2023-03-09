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

public abstract class DisplayRunnableWithResult <T>{
	
	protected abstract T run() throws Exception;
	
	public T syncExec() {
		if (Display.getCurrent() == null) {
			final Wrapper<T> resultWrapper = new Wrapper<T>();
			final Wrapper<Exception> exceptionWrapper = new Wrapper<Exception>();
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						resultWrapper.set(DisplayRunnableWithResult.this.run());
					} catch (Exception e) {
						exceptionWrapper.set(e);
					}
				}
			});
			Exception exception = exceptionWrapper.get();
			if (exception != null)
				throw (exception instanceof RuntimeException) 
					? (RuntimeException) exception 
					: new WrappedException(exception);
			return resultWrapper.get();
		} else {
			try {
				return run();
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		}
	}
}