/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.internal.LexerSpecialStateTransitionSplitter;

/**
 *
 * @author Heiko Behrens - Initial contribution and API
 */
public class AntlrLexerSplitter {

	public static final String INDENT = "    ";
	public static final String INDENT2 = INDENT + INDENT;
	public static final Pattern METHOD_SIGNATURE_PATTERN = Pattern.compile("public void mTokens\\(\\) throws RecognitionException \\{", 0);
	public static final Pattern METHOD_END_PATTERN = Pattern.compile("^\\s{4}}", 0);
	public static final Pattern OUTER_BLOCK_END_PATTERN = Pattern.compile("^\\s{8}}", 0);
	public static final Pattern INDENT_LEVEL_PATTERN = Pattern.compile("^\\s{12}", 0);
	public static final Pattern ASSIGNMENT_PATTERN = Pattern.compile("int (\\w+)=\\d+", 0);
	public static final Pattern DFA_ASSIGNMENT_PATTERN = Pattern.compile("\\w+ = dfa\\d+\\.predict\\(input\\);", 0);
	public static final Pattern BREAK_LINE_PATTERN = Pattern.compile("^\\s{12}\\s*break;", 0);
	public static final Pattern OUTER_SWITCH_PATTERN = Pattern.compile("^\\s{8}switch", 0);
	public static final Pattern OUTER_IF_PATTERN = Pattern.compile("^\\s{8}if", 0);
	public static final Pattern OUTER_BRACE_IN_IF_CASCADE_PATTERN = Pattern.compile("^(\\s{12}[^\\s]+.*)}\\s*$", 0);
	public static final Pattern DFA_TRANSITIONS_PATTERN = Pattern.compile("(static final String\\[\\] (DFA\\d+_transitionS) = )\\{", 0);
	public static final Pattern DFA_FIELD_END_PATTERN = Pattern.compile("^\\s{4}};", 0);

	private List<ExtractedMethod> extractedMethods = new ArrayList<ExtractedMethod>();

	public List<ExtractedMethod> getExtractedMethods() {
		return Collections.unmodifiableList(extractedMethods);
	}

	private StringBuilder stringBuilder;
	private final Scanner scanner;
	
	private boolean allowDFAStaticClasses = true;
	
	private int casesPerSpecialStateSwitch = LexerSpecialStateTransitionSplitter.CASES_PER_SPECIAL_STATE_SWITCH;
	
	public AntlrLexerSplitter(String content) {
		scanner = new Scanner(content);
	}

	private boolean copyUntilMethod() {
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			stringBuilder.append(line);
			stringBuilder.append("\n");
			if(METHOD_SIGNATURE_PATTERN.matcher(line).find())
				return true;
		}
		return false;
	}

	public String transform() {
		if(stringBuilder != null)
			return stringBuilder.toString();

		stringBuilder = new StringBuilder();
		if(copyUntilMethod()) {
			refactorAndExtract();
			produceMethods();
		}
		copyTailAndRefactorDfaTransitionS();
		String result = stringBuilder.toString();
		LexerSpecialStateTransitionSplitter lexerSplitter;
		lexerSplitter = new LexerSpecialStateTransitionSplitter(false);
		lexerSplitter.setAllowDFAStaticClasses(allowDFAStaticClasses);
		lexerSplitter.setCasesPerSpecialStateSwitch(casesPerSpecialStateSwitch);
		result = lexerSplitter.transform(result);
		return result;
	}

	public void produceMethods() {
		for (ExtractedMethod m : extractedMethods) {
			m.writeTo(stringBuilder);
			stringBuilder.append("\n");
		}
	}

	/**
	 * @since 2.17
	 */
	public void refactorAndExtract() {
		refacatorAndExtract();
	}
	
	@Deprecated
	public void refacatorAndExtract() {

//      {0}  // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
//      {1}  int alt12=16;
//      {2a}  int LA12_0 = input.LA(1);
//		{2b}  alt12 = dfa12.predict(input); -> no extraction
//		{3}
//      {4}  if ( (LA12_0=='i') ) {

		//{0}
		stringBuilder.append(scanner.nextLine());
		stringBuilder.append("\n");
		//{1}
		String varDecl = scanner.nextLine();
		stringBuilder.append(varDecl);
		stringBuilder.append("\n");
		String varName = getVarnameFromDecl(varDecl);

		// some lexer mToken methods are just delegating to another method
		if(varName != null) {
			// {2}
			stringBuilder.append(scanner.nextLine());
			stringBuilder.append("\n");

			// try to identify outer switch/if statement withing the first 4 lines
			// if this fails - do nothing
			int lineNo = 2;
			do {
				lineNo++;
				String line = scanner.nextLine();
				stringBuilder.append(line);
				stringBuilder.append("\n");
				if(OUTER_SWITCH_PATTERN.matcher(line).find()) {
					extractMethodsFromSwitch(varName);
					break;
				} else if (OUTER_IF_PATTERN.matcher(line).find()) {
					Pattern switchPattern = Pattern.compile(String.format("^        switch \\(%s\\) \\{", varName));
					extractMethodsFromIf(varName, switchPattern);
					break;
				}
			} while (lineNo <= 4);
		}

		// leave tail of method body unmodified
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			stringBuilder.append(line);
			stringBuilder.append("\n");
			if(METHOD_END_PATTERN.matcher(line).find())
				break;
		}
	}

	private void extractMethodsFromSwitch(String varName) {
		// TODO: provide extraction for switch statements, too
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			stringBuilder.append(line);
			stringBuilder.append("\n");
			if(OUTER_BLOCK_END_PATTERN.matcher(line).find()) {
				break;
			}
		}
	}

	private void extractMethodsFromIf(String varName, Pattern endPattern) {
		// refactor if cascade - until final switch statement and collect methods
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if(INDENT_LEVEL_PATTERN.matcher(line).find()) {
				ExtractedMethod method = new ExtractedMethod(varName, extractedMethods.size() + 1);
				extractMethod(stringBuilder, scanner, varName, method, line);
				extractedMethods.add(method);
			} else {
				stringBuilder.append(line);
				stringBuilder.append("\n");
			}

			if(endPattern.matcher(line).find()) {
				break;
			}

		}
	}

	static void extractMethod(StringBuilder sb, Scanner scanner, String varName, ExtractedMethod method, String firstLine) {
		boolean addBrace = method.addLine(firstLine) == ExtractedMethod.ExtractedMethodLineState.ignoredClosingBrace;
		boolean simplyEndOfMethod = false;
		String line = null;
		do {
			if(addBrace || simplyEndOfMethod) {
				sb.append(INDENT2);
				sb.append(INDENT);
				sb.append(varName);
				sb.append(" = ");
				sb.append(method.getName());
				sb.append("();");
				if(addBrace)
					sb.append("}");
				sb.append("\n");
				if(line != null) {
					sb.append(line);
					sb.append("\n");
				}
				break;
			}

			if(scanner.hasNextLine()) {
				line = scanner.nextLine();
				if(INDENT_LEVEL_PATTERN.matcher(line).find() || "".equals(line))
					addBrace = method.addLine(line) == ExtractedMethod.ExtractedMethodLineState.ignoredClosingBrace;
				else
					simplyEndOfMethod = true;
			}
		} while (scanner.hasNextLine());
	}

	private static String getVarnameFromDecl(String varDecl) {
		Matcher m = ASSIGNMENT_PATTERN.matcher(varDecl);
		if(!m.find())
			return null;
		return m.group(1);
	}
	
	private void copyTailAndRefactorDfaTransitionS() {
		copyAndBeginNestedClass();
		copyFieldAndEndNestedClass();
		copyTail();
	}

	private void copyAndBeginNestedClass() {
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Matcher matcher = DFA_TRANSITIONS_PATTERN.matcher(line);
			if (matcher.find()) {
				String fieldDecl = matcher.group(1);
				String fieldName = matcher.group(2);
				stringBuilder.append(INDENT).append(fieldDecl).append(fieldName).append("_.").append(fieldName).append(";\n");
				stringBuilder.append(INDENT).append("private static final class ").append(fieldName).append("_ {\n");
				stringBuilder.append(INDENT).append(line).append('\n');
				break;
			}
			stringBuilder.append(line);
			if(scanner.hasNextLine())
				stringBuilder.append("\n");
		}
	}

	private void copyFieldAndEndNestedClass() {
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			stringBuilder.append(INDENT).append(line).append("\n");
			if (DFA_FIELD_END_PATTERN.matcher(line).matches()) {
				stringBuilder.append(INDENT).append("}\n");
				break;
			}
		}
	}

	private void copyTail() {
		while(scanner.hasNextLine()) {
			stringBuilder.append(scanner.nextLine());
			if(scanner.hasNextLine())
				stringBuilder.append("\n");
		}
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
	public int getCasesPerSpecialStateSwitch(){
		return casesPerSpecialStateSwitch;
	}
	
	/**
	 * @since 2.9
	 */
	public void setCasesPerSpecialStateSwitch(int value){
		this.casesPerSpecialStateSwitch = value;
	}

	static public class ExtractedMethod {

		private final int index;
		private final List<String> lines = new ArrayList<String>();
		private final Pattern assignmentPattern;

		public ExtractedMethod(String resultVar, int index) {
			this.index = index;
			this.assignmentPattern = Pattern.compile(resultVar+"=(\\d+);", 0);
		}

		private enum ExtractedMethodLineState {added, ignored, ignoredClosingBrace}

		public ExtractedMethodLineState addLine(String line) {
			if(BREAK_LINE_PATTERN.matcher(line).find())
				return ExtractedMethodLineState.ignored;

			Matcher m = OUTER_BRACE_IN_IF_CASCADE_PATTERN.matcher(line);
			if(m.find()) {
				lines.add(m.group(1));
				return ExtractedMethodLineState.ignoredClosingBrace;
			}

			lines.add(line);
			return ExtractedMethodLineState.added;
		}

		public Object getName() {
			return String.format("mTokensHelper%03d", index);
		}

		public void writeTo(StringBuilder sb) {
			// TODO remove breaks of lowest level (no performance hit but kind of ugly)
			sb.append(INDENT);
			sb.append("private int ");
			sb.append(getName());
			sb.append("() throws RecognitionException {\n");
			for(String s : lines) {
				sb.append(getAsExtractedLine(s));
				sb.append("\n");
			}
			sb.append(INDENT);
			sb.append("}\n");
		}

		public String getAsExtractedLine(String s) {
			return assignmentPattern.matcher(s).replaceFirst("return $1;").replaceFirst(INDENT, "");
		}
	}

}