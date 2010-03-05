/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.apache.commons.lang.StringUtils;
import org.eclipse.xtext.util.Strings;

import com.google.inject.ImplementedBy;

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(ISimilarityMatcher.Default.class)
public interface ISimilarityMatcher {

	public boolean isSimilar(String s0, String s1);
	
	public static class Default implements ISimilarityMatcher {

		private static final double WEIGHTED_DIFFERENCE_THRESHOLD = .6;

		public boolean isSimilar(String s0, String s1) {
			if(Strings.isEmpty(s0) || Strings.isEmpty(s1)) {
				return false;
			}
			double maxLength = Math.max(s0.length(), s1.length());
			double levenshteinDistance = StringUtils.getLevenshteinDistance(s0, s1);
			return levenshteinDistance / maxLength < WEIGHTED_DIFFERENCE_THRESHOLD;
		}
	}
}
