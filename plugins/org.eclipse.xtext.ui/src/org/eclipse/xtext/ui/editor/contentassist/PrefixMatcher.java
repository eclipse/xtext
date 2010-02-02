/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.ui.dialogs.SearchPattern;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(PrefixMatcher.IgnoreCase.class)
public abstract class PrefixMatcher {

	public abstract boolean isCandidateMatchingPrefix(String name, String prefix);

	public static class IgnoreCase extends PrefixMatcher {
		@Override
		public boolean isCandidateMatchingPrefix(String name, String prefix) {
			return name.regionMatches(true, 0, prefix, 0, prefix.length());
		}
	}

	public static class CamelCase extends PrefixMatcher {
		@Override
		public boolean isCandidateMatchingPrefix(String name, String prefix) {
			SearchPattern pattern = new SearchPattern(
					SearchPattern.RULE_BLANK_MATCH | SearchPattern.RULE_CAMELCASE_MATCH | SearchPattern.RULE_PREFIX_MATCH);
			pattern.setPattern(prefix);
			boolean result = pattern.matches(name);
			return result;
		}
		
//		@SuppressWarnings("restriction")
//		public boolean camelCaseMatch(char[] pattern, int patternStart, int patternEnd, char[] name, int nameStart, int nameEnd, boolean samePartCount) {
//
//			/* !!!!!!!!!! WARNING !!!!!!!!!!
//			 * The algorithm implemented in this method has been heavily used in
//			 * StringOperation#getCamelCaseMatchingRegions(String, int, int, String, int, int, boolean)
//			 * method.
//			 *
//			 * So, if any change needs to be applied in the current algorithm,
//			 * do NOT forget to also apply the same change in the StringOperation method!
//			 */
//
//			if (name == null)
//				return false; // null name cannot match
//			if (pattern == null)
//				return true; // null pattern is equivalent to '*'
//			if (patternEnd < 0) 	patternEnd = pattern.length;
//			if (nameEnd < 0) nameEnd = name.length;
//
//			if (patternEnd <= patternStart) return nameEnd <= nameStart;
//			if (nameEnd <= nameStart) return false;
//			// check first pattern char
//			if (name[nameStart] != pattern[patternStart]) {
//				// first char must strictly match (upper/lower)
//				return false;
//			}
//
//			char patternChar, nameChar;
//			int iPattern = patternStart;
//			int iName = nameStart;
//
//			// Main loop is on pattern characters
//			while (true) {
//
//				iPattern++;
//				iName++;
//
//				if (iPattern == patternEnd) { // we have exhausted pattern...
//					// it's a match if the name can have additional parts (i.e. uppercase characters) or is also exhausted
//					if (!samePartCount || iName == nameEnd) return true;
//
//					// otherwise it's a match only if the name has no more uppercase characters
//					while (true) {
//						if (iName == nameEnd) {
//							// we have exhausted the name, so it's a match
//							return true;
//						}
//						nameChar = name[iName];
//						// test if the name character is uppercase
//						if (nameChar < ScannerHelper.MAX_OBVIOUS) {
//							if ((ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[nameChar] & ScannerHelper.C_UPPER_LETTER) != 0) {
//								return false;
//							}
//						}
//						else if (!Character.isJavaIdentifierPart(nameChar) || Character.isUpperCase(nameChar)) {
//							return false;
//						}
//						iName++;
//					}
//				}
//
//				if (iName == nameEnd){
//					// We have exhausted the name (and not the pattern), so it's not a match
//					return false;
//				}
//
//				// For as long as we're exactly matching, bring it on (even if it's a lower case character)
//				if ((patternChar = pattern[iPattern]) == name[iName]) {
//					continue;
//				}
//
//				// If characters are not equals, then it's not a match if patternChar is lowercase
//				if (patternChar < ScannerHelper.MAX_OBVIOUS) {
//					if ((ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[patternChar] & (ScannerHelper.C_UPPER_LETTER | ScannerHelper.C_DIGIT)) == 0) {
//						return false;
//					}
//				}
//				else if (Character.isJavaIdentifierPart(patternChar) && !Character.isUpperCase(patternChar) && !Character.isDigit(patternChar)) {
//					return false;
//				}
//
//				// patternChar is uppercase, so let's find the next uppercase in name
//				while (true) {
//					if (iName == nameEnd){
//			            //	We have exhausted name (and not pattern), so it's not a match
//						return false;
//					}
//
//					nameChar = name[iName];
//					if (nameChar < ScannerHelper.MAX_OBVIOUS) {
//						int charNature = ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[nameChar];
//						if ((charNature & (ScannerHelper.C_LOWER_LETTER | ScannerHelper.C_SPECIAL)) != 0) {
//							// nameChar is lowercase
//							iName++;
//						} else if ((charNature & ScannerHelper.C_DIGIT) != 0) {
//							// nameChar is digit => break if the digit is current pattern character otherwise consume it
//							if (patternChar == nameChar) break;
//							iName++;
//						// nameChar is uppercase...
//						} else  if (patternChar != nameChar) {
//							//.. and it does not match patternChar, so it's not a match
//							return false;
//						} else {
//							//.. and it matched patternChar. Back to the big loop
//							break;
//						}
//					}
//					// Same tests for non-obvious characters
//					else if (Character.isJavaIdentifierPart(nameChar) && !Character.isUpperCase(nameChar)) {
//						iName++;
//					} else if (Character.isDigit(nameChar)) {
//						if (patternChar == nameChar) break;
//						iName++;
//					} else  if (patternChar != nameChar) {
//						return false;
//					} else {
//						break;
//					}
//				}
//				// At this point, either name has been exhausted, or it is at an uppercase letter.
//				// Since pattern is also at an uppercase letter
//			}
//		}

	}

}
