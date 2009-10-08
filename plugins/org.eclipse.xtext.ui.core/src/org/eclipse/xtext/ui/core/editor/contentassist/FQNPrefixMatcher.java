/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.contentassist;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FQNPrefixMatcher extends PrefixMatcher {

	// TODO make delegate injectable via named binding
	@Inject
	private PrefixMatcher.IgnoreCase delegate;
	
	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.core.editor.contentassist.FQNPrefixMatcher.delimiter")
	private char delimiter = '.';
	
	@Inject
	private LastSegmentFinder lastSegmentFinder;
	
	@ImplementedBy(DefaultLastSegmentFinder.class)
	public interface LastSegmentFinder {
		String getLastSegment(String fqn, char delimiter);
	}
	
	public static class DefaultLastSegmentFinder implements LastSegmentFinder {

		public String getLastSegment(String fqn, char delimiter) {
			if (fqn == null || fqn.length() == 0)
				return null;
			boolean lookForUppercase = true;
			for(int i = 0; i < fqn.length(); i++) {
				if (lookForUppercase) {
					if (Character.isUpperCase(fqn.charAt(i))) {
						return fqn.substring(i);
					}
				} 
				lookForUppercase = delimiter == fqn.charAt(i);
			}
			return null;
		}
		
	}
	
	@Override
	public boolean isCandidateMatchingPrefix(String name, String prefix) {
		if (delegate.isCandidateMatchingPrefix(name, prefix))
			return true;
		if (name.indexOf(delimiter) >= 0) { // assume a fqn if delimiter is present
			if (prefix.indexOf(delimiter) < 0) { 
				// prefix is without a dot - either namespace or last segment
				// namespace was checked prior by delegate
				String lastSegment = lastSegmentFinder.getLastSegment(name, delimiter);
				if (lastSegment != null && delegate.isCandidateMatchingPrefix(lastSegment, prefix))
					return true;
			} else {
				String[] splitPrefix = prefix.split("\\.");
				String[] splitName = name.split("\\.", splitPrefix.length);
				if (splitName.length < splitPrefix.length) {
					return false;
				}
				for(int i = 0; i < splitPrefix.length ; i++) {
					if (!delegate.isCandidateMatchingPrefix(splitName[i], splitPrefix[i]))
						return false;
				}
				return true;
			}
		}
		return false;
	}

	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	public char getDelimiter() {
		return delimiter;
	}

	public void setDelegate(PrefixMatcher.IgnoreCase delegate) {
		this.delegate = delegate;
	}

	public PrefixMatcher.IgnoreCase getDelegate() {
		return delegate;
	}

	public void setLastSegmentFinder(LastSegmentFinder lastSegmentFinder) {
		this.lastSegmentFinder = lastSegmentFinder;
	}

	public LastSegmentFinder getLastSegmentFinder() {
		return lastSegmentFinder;
	}
	
}
