/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import java.util.List;

import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticQualifierPrefixMatcher extends PrefixMatcher {

	@Inject
	private PrefixMatcher.IgnoreCase delegate;
	
	protected String delimiter = "::";
	
	public String getLastSegment(String fqn) {
		if (fqn == null || fqn.length() == 0)
			return null;
		boolean lookForUppercase = true;
		for(int i = 0; i <= fqn.length() - delimiter.length(); i++) {
			if (lookForUppercase) {
				if (Character.isUpperCase(fqn.charAt(i))) {
					return fqn.substring(i);
				}
			} 
			lookForUppercase = delimiter.equals(fqn.substring(i, i + delimiter.length()));
			if (lookForUppercase)
				i++;
		}
		return null;
	}
	
	@Override
	public boolean isCandidateMatchingPrefix(String name, String prefix) {
		if (delegate.isCandidateMatchingPrefix(name, prefix))
			return true;
		if (name.indexOf(delimiter) >= 0) { // assume a fqn if delimiter is present
			if (prefix.indexOf(delimiter) < 0) { 
				// prefix is without a dot - either namespace or last segment
				// namespace was checked prior by delegate
				String lastSegment = getLastSegment(name);
				if (lastSegment != null && delegate.isCandidateMatchingPrefix(lastSegment, prefix))
					return true;
			} else {
				List<String> splitPrefix = Strings.split(prefix, delimiter);
				if (splitPrefix.isEmpty())
					return false;
				List<String> splitName = Strings.split(name, delimiter);
				if (splitName.size() < splitPrefix.size()) {
					return false;
				}
				for(int i = 0; i < splitPrefix.size(); i++) {
					if (!delegate.isCandidateMatchingPrefix(splitName.get(i), splitPrefix.get(i)))
						return false;
				}
				return true;
			}
		}
		return false;
	}

}
