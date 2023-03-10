/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(PrefixMatcher.IgnoreCase.class)
public abstract class PrefixMatcher {

	public abstract boolean isCandidateMatchingPrefix(String name, String prefix);

	@ImplementedBy(PrefixMatcher.CamelCase.class)
	public static class IgnoreCase extends PrefixMatcher {
		@Override
		public boolean isCandidateMatchingPrefix(String name, String prefix) {
			return name.regionMatches(true, 0, prefix, 0, prefix.length());
		}
	}

	public static class CamelCase extends PrefixMatcher.IgnoreCase {
		
		private boolean canDoCamelCaseMatch = true;
		
		public CamelCase() {
			canDoCamelCaseMatch = isJdtAvailable();
		}
		
		/**
		 * @since 2.1
		 */
		protected boolean isJdtAvailable() {
			try {
				org.eclipse.jdt.core.compiler.CharOperation.camelCaseMatch(null, null);
				return true;
			} catch(Throwable t) {
				return false;
			}
		}

		@Override
		public boolean isCandidateMatchingPrefix(String name, String prefix) {
			boolean result = super.isCandidateMatchingPrefix(name, prefix) || 
					canDoCamelCaseMatch && prefix.length() < name.length() && camelCaseMatch(name, prefix);
			return result;
		}

		/**
		 * @since 2.1
		 */
		protected boolean camelCaseMatch(String name, String prefix) {
			return org.eclipse.jdt.core.compiler.CharOperation.camelCaseMatch(prefix.toCharArray(), name.toCharArray());
		}
	}

}
