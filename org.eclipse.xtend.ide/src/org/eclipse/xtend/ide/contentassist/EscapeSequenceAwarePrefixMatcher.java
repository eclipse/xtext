/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
