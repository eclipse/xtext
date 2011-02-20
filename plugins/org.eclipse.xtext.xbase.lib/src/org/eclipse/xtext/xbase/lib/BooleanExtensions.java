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
public class BooleanExtensions {
	public static boolean _operator_and(boolean a, boolean b) {
		return a&&b;
	}

	public static boolean _operator_or(boolean a, boolean b) {
		return a||b;
	}

	public static boolean _operator_not(boolean b) {
		return !b;
	}
}
