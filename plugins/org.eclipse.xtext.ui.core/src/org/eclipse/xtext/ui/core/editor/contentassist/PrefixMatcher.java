/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.contentassist;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrefixMatcher {

	public boolean isCandidateMatchingPrefix(String name, String prefix) {
		return name.regionMatches(true, 0, prefix, 0,prefix.length());
	}
	
}
