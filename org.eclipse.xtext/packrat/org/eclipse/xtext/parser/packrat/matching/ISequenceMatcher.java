/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.matching;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ISequenceMatcher {

	boolean matches(CharSequence input, int offset, int length);

	class Factory {
		private static class NullSequenceMatcher implements ISequenceMatcher {
			private static ISequenceMatcher INSTANCE = new NullSequenceMatcher();
			@Override
			public boolean matches(CharSequence input, int offset, int length) {
				return false;
			}
		}

		public static ISequenceMatcher nullMatcher() {
			return NullSequenceMatcher.INSTANCE;
		}
	}
	
}
