/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.common.util.WrappedException;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Exceptions {

	public static <T> T throwUncheckedException(Throwable e) {
		if (e instanceof RuntimeException)
			throw (RuntimeException) e;
		if (e instanceof Error)
			throw (Error) e;
		if (e instanceof Exception)
			throw new WrappedException((Exception) e);
		throw new RuntimeException(e);
	}

	/**
	 * Invoke {@code Throwable#addSuppressed(Throwable)} reflectively if it is available.
	 * 
	 * It is not available on JRE &lt; 1.7
	 * 
	 * @since 2.8
	 */
	public static void addSuppressed(Throwable owner, Throwable add) {
		try {
			Method method = owner.getClass().getMethod("addSuppressed", Throwable.class);
			method.invoke(owner, add);
		} catch (NoSuchMethodException e) {
			// ignore, will happen for JRE < 1.7
		} catch (SecurityException e) {
			throwUncheckedException(e);
		} catch (IllegalAccessException e) {
			throwUncheckedException(e);
		} catch (IllegalArgumentException e) {
			throwUncheckedException(e);
		} catch (InvocationTargetException e) {
			throwUncheckedException(e);
		}
	}

}
