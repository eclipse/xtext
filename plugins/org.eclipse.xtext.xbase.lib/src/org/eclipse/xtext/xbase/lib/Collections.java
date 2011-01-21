/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Collection;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Collections {

	/**
	 * operator mapping for {@link Collection#add(Object)} to +=
	 */
	public static <A extends Collection<B>,B> boolean _operator_add(A a, B b) {
		return a.add(b);
	}
}
