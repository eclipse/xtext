/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend2.lib;

import com.google.common.annotations.GwtCompatible;
/*
 * Will be replaced with \n on GWT 
 */
@GwtCompatible(emulated = true)
class DefaultLineDelimiter {
	public static String get() {
		return System.getProperty("line.separator");
	}
}
