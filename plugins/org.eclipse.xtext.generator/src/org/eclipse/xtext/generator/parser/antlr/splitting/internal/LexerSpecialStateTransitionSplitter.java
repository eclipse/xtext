/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.splitting.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerSpecialStateTransitionSplitter {

	public static final Pattern DFA_PATTERN = Pattern.compile(
			"(class DFA\\d+ extends DFA \\{.*" +
			")(public int specialStateTransition\\(int s, IntStream _input\\) throws NoViableAltException \\{.*" +
			"\\}\\s*NoViableAltException nvae =[^{}]*" + // end of switch
			"\\})([^{]*" + // end of specialStateTransition
			"\\})" // end of nested class
			, Pattern.DOTALL | Pattern.MULTILINE);
	
	public static final Pattern TOO_MANY_CASES_PATTERN = Pattern.compile("^\\s*case\\s+\\d\\d\\d", Pattern.MULTILINE);
			
	public static final Pattern CASE_PATTERN = Pattern.compile(
			"(^\\s*case\\s+(\\d+)\\s*:(\\s*))" +// case # -> $1, $2, $3
			"([^;]*;" + // int .. = input.LA(..) -> $4
			"(\\s*int\\s+index[^;]*;\\s*input\\.rewind\\(\\)\\s*;)?)" +  // $5
			"\\s*s = -1;"  + // local var init
			"(\\s*if.*?;\\}(\\s*else if.*?;\\})*(\\s*else s.*?;)?(\\s*input\\.seek[^;]*;)?)" + // $6
			"\\s*(if\\s*\\(\\s*s\\s*>=0\\s*\\)\\s*return\\s*s;\\s*" + // if ( s>=0 ) return s; $10
			"^\\s*break;$)" // break, end case
			, Pattern.DOTALL | Pattern.MULTILINE);
	
	public static final Pattern STATE_PATTERN = Pattern.compile(
			Pattern.quote("if (state.backtracking>0) {state.failed=true; return -1;}"));

	/**
	 * Allow to disable the guard for large number of cases in switch statement.
	 * This is for testing purpose.
	 */
	private final boolean ignoreCaseCountGuard;
	
	private boolean allowDFAStaticClasses = true;
	
	public LexerSpecialStateTransitionSplitter(boolean ignoreCaseCountGuard) {
		this.ignoreCaseCountGuard = ignoreCaseCountGuard;
	}
	
	public String transform(String input) {
		Matcher dfaMatcher = DFA_PATTERN.matcher(input);
		StringBuffer result = new StringBuffer();
		while(dfaMatcher.find()) {
			String specialStateTransition = dfaMatcher.group(2);
			String staticOrNot = "$1";
			if (allowDFAStaticClasses && !STATE_PATTERN.matcher(specialStateTransition).find())
				staticOrNot = "static $1";
			String transformedDfa = staticOrNot + extractSpecialStateMethods(specialStateTransition) + "$3";
			dfaMatcher.appendReplacement(result, transformedDfa);
		}
		dfaMatcher.appendTail(result);
		return result.toString();
	}
	
	public String extractSpecialStateMethods(String specialStateTransition) {
		if (!ignoreCaseCountGuard && !TOO_MANY_CASES_PATTERN.matcher(specialStateTransition).find()) {
			return specialStateTransition.replace("\\", "\\\\").replace("$", "\\$");
		}
		Matcher caseMatcher = CASE_PATTERN.matcher(specialStateTransition);
		StringBuffer result = new StringBuffer();
		StringBuffer extractedMethods = new StringBuffer();
		while(caseMatcher.find()) {
			String replacedCaseBody = "$1s = specialStateTransition$2(input);$3$10";
			extractedMethods.append("\n        protected int specialStateTransition");
			extractedMethods.append(caseMatcher.group(2));
			extractedMethods.append("(IntStream input) {\n");
			extractedMethods.append("            int s = -1;\n            ");
			extractedMethods.append(caseMatcher.group(4));
			extractedMethods.append("\n");
			extractedMethods.append(caseMatcher.group(6).replaceAll("(^|\n)\\s+", "$1            "));
			extractedMethods.append("\n            return s;\n");
			extractedMethods.append("        }");
			caseMatcher.appendReplacement(result, replacedCaseBody);
		}
		caseMatcher.appendTail(result);
		result.append(extractedMethods);
		result.append("\n");
		return result.toString().replace("\\", "\\\\").replace("$", "\\$");
	}
	
	/**
	 * @since 2.9
	 */
	public boolean isAllowDFAStaticClasses() {
		return allowDFAStaticClasses;
	}

	/**
	 * @since 2.9
	 */
	public void setAllowDFAStaticClasses(boolean value) {
		this.allowDFAStaticClasses = value;
	}


}
