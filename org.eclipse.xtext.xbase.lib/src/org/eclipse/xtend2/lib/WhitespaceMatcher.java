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
 * On GWT we use Character.isSpace instead
 */
@GwtCompatible(emulated = true)
class WhitespaceMatcher {
	public static boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}
}
