/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import java.util.List;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * Prefix matcher for fully qualified names.
 * 
 * @since 2.10
 * @noreference
 */
public class FQNPrefixMatcher implements IPrefixMatcher {
	@Inject
	private IPrefixMatcher.IgnoreCase delegate;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public boolean isCandidateMatchingPrefix(String name, String prefix) {
		if (delegate.isCandidateMatchingPrefix(name, prefix)) {
			return true;
		}
		String delimiter = getDelimiter();
		if (!Strings.isEmpty(delimiter) && name.indexOf(delimiter) >= 0) {
			if (prefix.indexOf(delimiter) < 0) {
				String lastSegment = getLastSegment(name, delimiter);
				if (lastSegment != null && delegate.isCandidateMatchingPrefix(lastSegment, prefix)) {
					return true;
				}
			} else {
				List<String> splitPrefix = Strings.split(prefix, delimiter);
				if (splitPrefix.isEmpty()) {
					return false;
				}
				List<String> splitName = Strings.split(name, delimiter);
				if (splitName.size() < splitPrefix.size()) {
					return false;
				}
				for (int i = 0; i < splitPrefix.size(); i++) {
					if (!delegate.isCandidateMatchingPrefix(splitName.get(i), splitPrefix.get(i))) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	protected String getLastSegment(String fqn, String delimiter) {
		int lastDelimIndex = fqn.lastIndexOf(delimiter);
		if (lastDelimIndex >= 0 && lastDelimIndex + delimiter.length() < fqn.length()) {
			return fqn.substring(lastDelimIndex + delimiter.length());
		}
		return null;
	}

	public String getDelimiter() {
		if (qualifiedNameConverter instanceof IQualifiedNameConverter.DefaultImpl) {
			return ((IQualifiedNameConverter.DefaultImpl) qualifiedNameConverter).getDelimiter();
		} else {
			return ".";
		}
	}

	public IPrefixMatcher.IgnoreCase getDelegate() {
		return delegate;
	}

	public void setDelegate(IPrefixMatcher.IgnoreCase delegate) {
		this.delegate = delegate;
	}
}
