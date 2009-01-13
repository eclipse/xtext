/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.matching;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ISequenceMatcher {

	boolean matches(CharSequence input, int offset, int length);
	
	public static class Factory {
		public static ISequenceMatcher nullMatcher() {
			return new ISequenceMatcher() {
				public boolean matches(CharSequence input, int offset, int length) {
					return false;
				}
			};
		}
	}
	
}
