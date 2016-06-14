/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import com.google.inject.ImplementedBy

/** 
 * Prefix matchers are used to reject content assist proposals that do not match the prefix at
 * the current cursor position.
 * 
 * @since 2.10
 * @noreference
 */
@ImplementedBy(IPrefixMatcher.IgnoreCase)
interface IPrefixMatcher {
	
	def boolean isCandidateMatchingPrefix(String name, String prefix)
	
	/** 
	 * Default prefix matcher that compares the prefix of the candidate ignoring case.
	 */
	static class IgnoreCase implements IPrefixMatcher {
		
		override boolean isCandidateMatchingPrefix(String name, String prefix) {
			return name.regionMatches(true, 0, prefix, 0, prefix.length)
		}
		
	}
	
}
