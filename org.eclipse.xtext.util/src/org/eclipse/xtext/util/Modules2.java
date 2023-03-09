/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class Modules2 {
	
	public static Module mixin(Module...m) {
		if (m.length==0)
			return null;
		Module current = m[0];
		for (int i=1;i<m.length;i++) {
			current = Modules.override(current).with(m[i]);
		}
		return current;
	}
}
