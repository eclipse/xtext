/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
				public void run() {
					try {
						resultWrapper.set(DisplayRunnableWithResult.this.run());
					} catch (Exception e) {
						exceptionWrapper.set(e);
					}
				}
			});
			if (exceptionWrapper.get() != null)
				throw new WrappedException(exceptionWrapper.get());
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