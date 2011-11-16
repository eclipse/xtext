/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Exceptions {

	/**
	 * shamelessly taken from Project Lombok
	 * https://github.com/rzwitserloot/lombok/blob/master/src/core/lombok/Lombok.java
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
