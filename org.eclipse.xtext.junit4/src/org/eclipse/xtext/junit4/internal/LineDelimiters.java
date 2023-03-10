/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.internal;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public class LineDelimiters {
	public static String toUnix(String s) {
		StringConcatenation result = new StringConcatenation("\n");
		result.append(s);
		return result.toString();
	}

	public static String toPlatform(String s) {
		StringConcatenation result = new StringConcatenation();
		result.append(s);
		return result.toString();
	}
}
