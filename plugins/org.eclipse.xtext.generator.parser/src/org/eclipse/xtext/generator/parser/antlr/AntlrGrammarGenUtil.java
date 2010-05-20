/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Heiko Behrens
 */
public class AntlrGrammarGenUtil {

	public static String toAntlrString(String string) {
		return Strings.convertToJavaString(string, true).replace("\\\"", "\"");
	}

	public static String toStringInAntlrAction(String string) {
		return Strings.convertToJavaString(string, true).replace("%", "\\%");
	}

	public static String toAntlrStringIgnoreCase(String string) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < string.length() ; i++) {
			final char upperCase = Character.toUpperCase(string.charAt(i));
			final char lowerCase = Character.toLowerCase(string.charAt(i));
			if(upperCase == lowerCase) {
				sb.append("'");
				sb.append(toAntlrString(String.valueOf(upperCase)));
				sb.append("'");
			} else {
				sb.append("('");
				sb.append(toAntlrString(String.valueOf(upperCase)));
				sb.append("'|'");
				sb.append(toAntlrString(String.valueOf(lowerCase)));
				sb.append("')");
			}
		}
		return sb.toString();
	}

	public static String getClasspathURI(Grammar grammar, EObject object) {
		String fragment = EcoreUtil.getURI(object).fragment();
		return "classpath:/" + grammar.getName().replace('.', '/') + ".xmi#" + fragment;
	}
}
