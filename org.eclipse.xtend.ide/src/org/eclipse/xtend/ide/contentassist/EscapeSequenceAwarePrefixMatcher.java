/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EscapeSequenceAwarePrefixMatcher extends PrefixMatcher.CamelCase {

	@Override
	public boolean isCandidateMatchingPrefix(String name, String prefix) {
		String strippedName = name;
		if (name.startsWith("^") && !prefix.startsWith("^")) {
			strippedName = name.substring(1);
		}
		return super.isCandidateMatchingPrefix(strippedName, prefix);
	}
	
}
