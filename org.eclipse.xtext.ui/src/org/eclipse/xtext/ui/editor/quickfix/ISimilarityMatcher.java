/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.xtext.util.Strings;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(ISimilarityMatcher.Default.class)
public interface ISimilarityMatcher {

	public boolean isSimilar(String s0, String s1);
	
	public static class Default implements ISimilarityMatcher {

		@Override
		public boolean isSimilar(String s0, String s1) {
			if(Strings.isEmpty(s0) || Strings.isEmpty(s1)) {
				return false;
			}
			double levenshteinDistance = Strings.getLevenshteinDistance(s0, s1);
			return levenshteinDistance <= 1;
		}

	}
}
