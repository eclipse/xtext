/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.util.Strings

/** 
 * Prefix matcher for fully qualified names.
 * 
 * @since 2.10
 * @noreference
 */
class FQNPrefixMatcher implements IPrefixMatcher {
	
	@Accessors
	@Inject IPrefixMatcher.IgnoreCase delegate
	
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	override boolean isCandidateMatchingPrefix(String name, String prefix) {
		if (delegate.isCandidateMatchingPrefix(name, prefix))
			return true
		val delimiter = getDelimiter
		// Assume a FQN if delimiter is present
		if (!delimiter.nullOrEmpty && name.indexOf(delimiter) >= 0) {
			if (prefix.indexOf(delimiter) < 0) {
				// Prefix is without delimiter - either namespace or last segment
				val lastSegment = getLastSegment(name, delimiter)
				if (lastSegment !== null && delegate.isCandidateMatchingPrefix(lastSegment, prefix))
					return true
			} else {
				val splitPrefix = Strings.split(prefix, delimiter)
				if (splitPrefix.empty)
					return false
				val splitName = Strings.split(name, delimiter)
				if (splitName.size < splitPrefix.size)
					return false
				for (var i = 0; i < splitPrefix.size; i++) {
					if (!delegate.isCandidateMatchingPrefix(splitName.get(i), splitPrefix.get(i)))
						return false
				}
				return true
			}
		}
		return false
	}

	def protected String getLastSegment(String fqn, String delimiter) {
		val lastDelimIndex = fqn.lastIndexOf(delimiter)
		if (lastDelimIndex >= 0 && lastDelimIndex + delimiter.length < fqn.length)
			return fqn.substring(lastDelimIndex + delimiter.length)
	}

	def String getDelimiter() {
		if (qualifiedNameConverter instanceof IQualifiedNameConverter.DefaultImpl)
			return qualifiedNameConverter.delimiter
		else
			return '.'
	}

}
