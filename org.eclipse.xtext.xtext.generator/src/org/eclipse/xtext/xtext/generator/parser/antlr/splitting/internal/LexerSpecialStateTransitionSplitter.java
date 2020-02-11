/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerSpecialStateTransitionSplitter {
	
	public static final int CASES_PER_SPECIAL_STATE_SWITCH = -1;

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
			"([^;]*;(\\s*int\\s+index[^;]*;\\s*input\\.rewind\\(\\)\\s*;)?)" + // int .. = input.LA(..); ... -> $4 $5
			"\\s*s = -1;"  + // local var init
			"(\\s*if.*?;\\}(\\s*else if.*?;\\})*(\\s*else s.*?;)?(\\s*input\\.seek[^;]*;)?)" + // $6
			"\\s*(if\\s*\\(\\s*s\\s*>=0\\s*\\)\\s*return\\s*s;\\s*" + // if ( s>=0 ) return s; $10
			"^\\s*break;$)" // break, end case
			, Pattern.DOTALL | Pattern.MULTILINE);
	
	public static final Pattern TRANSORMED_SPECIAL_STATE_TRANSITION_METHOD = Pattern.compile(
			"((public int specialStateTransition\\(int s, IntStream _input\\) throws NoViableAltException\\s*\\{" +
			"\\s+IntStream[^;]*;\\s*" +
			"int[^;]*;\\s*)" +
			"(switch\\s*\\( s \\)\\s*" + // switch -> $3
			"(case\\s+\\d+\\s*:\\s*" + // case #
			"\\s*s\\s*=\\s*specialStateTransition\\d+\\(\\s*input\\s*\\)\\s*;" + // test transition # $2
			"\\s*if\\s*\\(\\s*s\\s*>=0\\s*\\)\\s*return\\s*s;\\s*" + // if ( s>=0 ) return s;
			"^\\s*break;\\s*)*" + // end case
			"[^}]*\\})" + // end switch
			"(\\s*NoViableAltException\\s+nvae\\s*=[^}]*\\}))" // $5
			,Pattern.DOTALL | Pattern.MULTILINE);
	
	public static final Pattern TRANSFORMED_CASE_PATTERN = Pattern.compile(
			"(^\\s*case\\s+(\\d+)\\s*:\\s*" + // case #
			"\\s*s\\s*=\\s*specialStateTransition\\d+\\(\\s*input\\s*\\)\\s*;" + // test transition # $2
			"\\s*if\\s*\\(\\s*s\\s*>=0\\s*\\)\\s*return\\s*s;\\s*" + // if ( s>=0 ) return s; $10
			"^\\s*break;)" // end case
			,Pattern.DOTALL | Pattern.MULTILINE);
	
	public static final Pattern STATE_PATTERN = Pattern.compile(
			Pattern.quote("if (state.backtracking>0) {state.failed=true; return -1;}"));

	/**
	 * Allow to disable the guard for large number of cases in switch statement.
	 * This is for testing purpose.
	 */
	private final boolean ignoreCaseCountGuard;
	
	private boolean allowDFAStaticClasses = true;
	
	private int casesPerSpecialStateSwitch = CASES_PER_SPECIAL_STATE_SWITCH;
	
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
			String tmpSpecialStateTransition = extractSpecialStateMethods(specialStateTransition);
			String transformedDfa;
			if (casesPerSpecialStateSwitch == -1) {
				transformedDfa = staticOrNot + tmpSpecialStateTransition + "$3";
			} else {
				transformedDfa = staticOrNot + splitSpecialStateSwitch(tmpSpecialStateTransition) + "$3";
			}
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
			extractedMethods.append(caseMatcher.group(4).replaceAll("(^|\n)\\s+", "$1"));
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
	
	private static void generateExtractedSwitch(List<String> extractedCasesList, String from, String to,
			StringBuffer extractedMethods, StringBuffer switchReplacementBuffer){
		String extractedMethodName = String.format("specialStateTransitionFrom%sTo%s", from, to);
		extractedMethods.append("\n        protected int ");
		extractedMethods.append(extractedMethodName);
		extractedMethods.append("(int s, IntStream input) {\n");
		extractedMethods.append("            int _s = s;\n");
		extractedMethods.append("            switch( s ) {\n");
		for(String extractedCase : extractedCasesList ){
			extractedMethods.append(extractedCase);
			extractedMethods.append("\n");
		}
		extractedMethods.append("            }\n");
		extractedMethods.append("            return -1;\n");
		extractedMethods.append("        }\n");
		
		switchReplacementBuffer.append("            s = ");
		switchReplacementBuffer.append(extractedMethodName);
		switchReplacementBuffer.append("( _s, input );\n");
		switchReplacementBuffer.append("            if ( s >= 0 ) return s;\n");
	}	

	/**
	 * Splits switch in specialStateTransition containing more than maxCasesPerSwitch
	 * cases into several methods each containing maximum of maxCasesPerSwitch cases
	 * or less.
	 * @since 2.9
	 */
	public String splitSpecialStateSwitch(String specialStateTransition){
		Matcher transformedSpecialStateMatcher =
				TRANSORMED_SPECIAL_STATE_TRANSITION_METHOD.matcher(specialStateTransition);
		if( !transformedSpecialStateMatcher.find() ){
			return specialStateTransition;
		}
		
		String specialStateSwitch = transformedSpecialStateMatcher.group(3);
		
		Matcher transformedCaseMatcher = TRANSFORMED_CASE_PATTERN.matcher(specialStateSwitch);
		
		StringBuffer switchReplacementBuffer = new StringBuffer();
		StringBuffer extractedMethods = new StringBuffer();
		List<String> extractedCasesList = new ArrayList<String>();

		switchReplacementBuffer.append("$2\n");
		
		boolean methodExtracted = false;
		boolean isFirst = true;
		String from = "0";
		String to = "0";
		//Process individual case statements
		while(transformedCaseMatcher.find()){
			if(isFirst){
				isFirst = false;
				from = transformedCaseMatcher.group(2);
			}
			to = transformedCaseMatcher.group(2);
			extractedCasesList.add(transformedCaseMatcher.group());
			//If the list of not processed extracted cases exceeds the maximal allowed number
			//generate individual method for those cases
			if (extractedCasesList.size() >= casesPerSpecialStateSwitch ){
				generateExtractedSwitch(extractedCasesList, from, to, extractedMethods, switchReplacementBuffer);
				extractedCasesList.clear();
				isFirst = true;
				methodExtracted = true;
			}
		}
		
		//If no method was extracted return the input unchanged
		//or process rest of cases by generating method for them
		if(!methodExtracted){
			return specialStateTransition;
		}else if(!extractedCasesList.isEmpty() && methodExtracted){
			generateExtractedSwitch(extractedCasesList, from, to, extractedMethods, switchReplacementBuffer);
		}
		switchReplacementBuffer.append("$5");
		
		StringBuffer result = new StringBuffer();
		transformedSpecialStateMatcher.appendReplacement( result, switchReplacementBuffer.toString());
		result.append(extractedMethods);
		transformedSpecialStateMatcher.appendTail(result);
		return result.toString();
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
	
	/**
	 * @since 2.9
	 */
	public void setCasesPerSpecialStateSwitch(int maxCasesPerSwitch){
		this.casesPerSpecialStateSwitch = maxCasesPerSwitch;
	}
	
	/**
	 * @since 2.9
	 */
	public int getCasesPerSpecialStateSwitch(){
		return casesPerSpecialStateSwitch;
	}


}
