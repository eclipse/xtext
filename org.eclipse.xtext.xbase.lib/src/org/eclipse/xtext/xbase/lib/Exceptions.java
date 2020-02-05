/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import com.google.common.annotations.GwtCompatible;

/**
 * Useful helper methods when dealing with exceptions.
 * @author Sven Efftinge - Initial contribution and API
 */
@GwtCompatible public class Exceptions {

	/*
	 * shamelessly taken from Project Lombok
	 * https://github.com/rzwitserloot/lombok/blob/master/src/core/lombok/Lombok.java
	 */
	/**
	 * Throws the given exception and sneaks it through any compiler checks. This
	 * allows to throw checked exceptions without the need to declare it.
	 * Clients should use the following idiom to trick static analysis and dead code checks:
	 * <pre>
	 * throw sneakyThrow(new CheckedException("Catch me if you can ;-)")).
	 * </pre>
	 * This method is heavily inspired by project
	 * <a href="https://github.com/rzwitserloot/lombok/blob/master/src/core/lombok/Lombok.java">Lombok</a>.
	 * @param t the throwable that should be sneaked through compiler checks. May not be <code>null</code>.
	 * @return never returns anything since {@code t} is always thrown.
	 * @throws NullPointerException if {@code t} is <code>null</code>.
	 */
	public static RuntimeException sneakyThrow(Throwable t) {
		if (t == null)
			throw new NullPointerException("t");
		Exceptions.<RuntimeException> sneakyThrow0(t);
		return null;
	}

	@SuppressWarnings("unchecked")
	private static <T extends Throwable> void sneakyThrow0(Throwable t) throws T {
		throw (T) t;
	}
}
