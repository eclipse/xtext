/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
public class Minifier {
	
	/*
		if ( state.backtracking==0 ) {
			
					newCompositeNode(elementAccess.getPackageQualifiedNameParserRuleCall_0_1_0()); 
				
		}
		pushFollow(FOLLOW_ruleQualifiedName_in_ruleFile150);
		this_dataType=ruleQualifiedName();

		state._fsp--;
		if (state.failed) return current;
		if ( state.backtracking==0 ) {

					if (current==null) {
						current = createModelElementForParent(elementAccess.getRule());
					}
						set(
							current, 
							"package",
						this_dataType, 
						"QualifiedName");
					afterParserOrEnumRuleCall();
				
		}
	 */
	private static final Pattern CALL_ASSIGNED_PARSER_RULE_PATTERN = Pattern.compile(
			"^(\\s*)if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*newCompositeNode\\((elementAccess\\.get[^\\(]*\\(\\))\\);" +
			"\\s*\\}" +
			"\\s*pushFollow\\(([^\\)]*)\\);" +
			"\\s*(\\w+)=rule(\\w+)\\(\\);" +
			"\\s*state\\._fsp--;" +
			"\\s*if\\s*\\(state\\.failed\\)\\s*return\\s+current;" +
			"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*if\\s*\\(current==null\\)\\s\\{" +
			"\\s*current\\s*=\\s*createModelElementForParent\\(([^\\(]*\\(\\))\\);" +
			"\\s*\\}" +
			"\\s*(set|add)\\(\\s*current,\\s*([^;]*),\\s*([^;]*),\\s*([^\\)]*)\\);" +
			"\\s*afterParserOrEnumRuleCall\\(\\);" +
			"\\s*\\}",
			Pattern.MULTILINE | Pattern.DOTALL);
	
	/*
		if ( state.backtracking==0 ) {
			if (current==null) {
				current = createModelElement(elementAccess.getRule());
			}
		}
		if ( state.backtracking==0 ) {
			newCompositeNode(elementAccess.getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); 
		}
		pushFollow(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20811);
		ruleQualifiedName();
		state._fsp--;
		if (state.failed) return current;
		if ( state.backtracking==0 ) {
			afterParserOrEnumRuleCall();
		}
	 */
	private static final Pattern CALL_CROSS_REF_RULE_PATTERN = Pattern.compile(
		"^(\\s*)if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
		"\\s*if\\s*\\(current==null\\)\\s\\{" +
		"\\s*current\\s*=\\s*createModelElement\\([^\\(]*\\(\\)\\);" +
		"\\s*\\}" +
		"\\s*\\}" +
		"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
		"\\s*newCompositeNode\\((elementAccess\\.get[^\\(]*\\(\\))\\);" +
		"\\s*\\}" +
		"\\s*pushFollow\\(([^\\)]*)\\);" +
		"\\s*rule(\\w+)\\(\\);" +
		"\\s*state\\._fsp--;" +
		"\\s*if\\s*\\(state\\.failed\\)\\s*return\\s+current;" +
		"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
		"\\s*afterParserOrEnumRuleCall\\(\\);" +
		"\\s*\\}",
		Pattern.MULTILINE | Pattern.DOTALL);
	
	/*
		if ( state.backtracking==0 ) {
			newCompositeNode(elementAccess.getSimpleStringLiteralParserRuleCall_0()); 
		}
		pushFollow(FOLLOW_ruleSimpleStringLiteral_in_ruleXStringLiteral5632);
		this_object=ruleSimpleStringLiteral();
		state._fsp--;
		if (state.failed) return current;
		if ( state.backtracking==0 ) {
			current = this_object; 
			afterParserOrEnumRuleCall();
		}
	 */
	private static final Pattern CALL_UNASSIGNED_PARSER_RULE_PATTERN = Pattern.compile(
		"^(\\s*)if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
		"\\s*newCompositeNode\\((elementAccess\\.get[^\\(]*\\(\\))\\);" +
		"\\s*\\}" +
		"\\s*pushFollow\\(([^\\)]*)\\);" +
		"\\s*(\\w+)=rule(\\w+)\\(\\);" +
		"\\s*state\\._fsp--;" +
		"\\s*if\\s*\\(state\\.failed\\)\\s*return\\s+current;" +
		"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
		"\\s*current\\s*=\\s*(\\w+);" +
		"\\s*afterParserOrEnumRuleCall\\(\\);" +
		"\\s*\\}",
		Pattern.MULTILINE | Pattern.DOTALL);
	
	/*
		if ( state.backtracking==0 ) {
			newCompositeNode(elementAccess.getValidIDParserRuleCall_0()); 
		}
		pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier16959);
		this_dataType=ruleValidID();
		state._fsp--;
		if (state.failed) return current;
		if ( state.backtracking==0 ) {
			current.merge(this_dataType);
		}
		if ( state.backtracking==0 ) {
			afterParserOrEnumRuleCall();
		}
	 */
	private static final Pattern CALL_UNASSIGNED_DATA_TYPE_RULE_PATTERN = Pattern.compile(
			"^(\\s*)if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*newCompositeNode\\((elementAccess\\.get[^\\(]*\\(\\))\\);" +
			"\\s*\\}" +
			"\\s*pushFollow\\(([^\\)]*)\\);" +
			"\\s*(\\w+)=rule(\\w+)\\(\\);" +
			"\\s*state\\._fsp--;" +
			"\\s*if\\s*\\(state\\.failed\\)\\s*return\\s+current;" +
			"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*current\\.merge\\(\\w+\\);" +
			"\\s*\\}" +
			"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*afterParserOrEnumRuleCall\\(\\);" +
			"\\s*\\}",
			Pattern.MULTILINE | Pattern.DOTALL);
	
	/*
		kw=(Token)match(input,94,FOLLOW_94_in_ruleArrayBrackets19217); if (state.failed) return current;
		if ( state.backtracking==0 ) {
			current.merge(kw);
			newLeafNode(kw, elementAccess.getLeftSquareBracketKeyword_0()); 
		}
	 */
	private static final Pattern CALL_TERMINAL_FROM_DATA_TYPE_RULE_PATTERN = Pattern.compile(
			"^(\\s*)kw=\\(Token\\)match\\(input,(\\d+),([^\\)]*)\\);\\s*if\\s*\\(state\\.failed\\)\\s*return\\s*current;" +
			"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*current\\.merge\\(kw\\);\\s*" +
			"\\s*newLeafNode\\(kw\\s*,([^\\(]*)\\(\\)\\);" +
			"\\s*\\}",
			Pattern.MULTILINE | Pattern.DOTALL);
	
	/*
		other=(Token)match(input,34,FOLLOW_34_in_ruleFullJvmFormalParameter5477); if (state.failed) return current;
		if ( state.backtracking==0 ) {
				newLeafNode(other, elementAccess.getExtensionExtensionKeyword_0_0());
		}
		if ( state.backtracking==0 ) {
			if (current==null) {
				current = createModelElement(elementAccess.getRule());
			}
			setWithLastConsumed(current, "extension", true, "extension");
		}
	 */
	private static final Pattern CALL_ASSIGNED_KEYWORD_PATTERN = Pattern.compile(
			"^(\\s*)other=\\(Token\\)match\\(input,(\\d+),([^\\)]*)\\);\\s*if\\s*\\(state\\.failed\\)\\s*return\\s*current;" +
			"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*newLeafNode\\(other,([^\\(]*)\\(\\)\\);" +
			"\\s*\\}" +
			"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*if\\s*\\(current==null\\)\\s*\\{" +
			"\\s*current\\s*=\\s*createModelElement\\(([^\\(]*)\\(\\)\\);" +
			"\\s*\\}" +
			"\\s*(set|add)WithLastConsumed\\(\\s*current,\\s*([^;]*),\\s*(true|other)\\s*,\\s*([^\\)]*)\\);" +
			"\\s*}",
			Pattern.MULTILINE | Pattern.DOTALL);
	
	/*
		other=(Token)match(input,21,FOLLOW_21_in_ruleXExpressionInClosure14224); if (state.failed) return current;
		if ( state.backtracking==0 ) {
			newLeafNode(other, elementAccess.getSemicolonKeyword_1_1());
		} 
	 */
	private static final Pattern CALL_UNASSIGNED_KEYWORD_PATTERN = Pattern.compile(
			"^(\\s*)other=\\(Token\\)match\\(input,(\\d+),([^\\)]*)\\);\\s*if\\s*\\(state\\.failed\\)\\s*return\\s*current;" +
			"\\s*if\\s*\\(\\s*state\\.backtracking==0\\s*\\)\\s*\\{" +
			"\\s*newLeafNode\\(other,([^\\(]*)\\(\\)\\);\\" +
			"s*\\}",
			Pattern.MULTILINE | Pattern.DOTALL);
	
	private static final Pattern LINE_COMMENT_PATTERN = Pattern.compile(
			"^\\s*(//.*)?$",
			Pattern.MULTILINE);
	
	private static final Pattern UNUSED_LOCAL_VAR_PATTERN = Pattern.compile(
			"^\\s*(Token other=null;|EObject this_object = null;|AntlrDatatypeRuleToken this_dataType = null;|Token kw=null;)\\s*$",
			Pattern.MULTILINE);
	
	private String javaClass;
	
	public Minifier(String javaClass) {
		this.javaClass = javaClass;
	}

	public String transform() {
		String transformed = UNUSED_LOCAL_VAR_PATTERN.matcher(javaClass).replaceAll("");
		transformed = LINE_COMMENT_PATTERN.matcher(transformed).replaceAll("").replace("\n\n", "\n");
		List<String> newMethods = Lists.newArrayList();
		Set<Pair<String, String>> handles = Sets.newHashSet();
		transformed = extractParserRuleCalls(transformed, newMethods, handles);
		transformed = extractTerminals(transformed);
		int closingBrace = transformed.lastIndexOf("}");
		StringBuilder result = new StringBuilder(transformed.subSequence(0, closingBrace));
		for(String newMethod: newMethods) {
			result.append(newMethod);
		}
		result.append("}");
		return javaClass + "/*\n" + result + " */";
	}

	private String extractTerminals(String javaCode) {
		String result = extractAssignedKeywords(javaCode);
		result = extractUnassignedKeywords(result);
		return extractTerminalsInDatatypeRules(result);
	}

	private String extractTerminalsInDatatypeRules(String javaCode) {
		Matcher matcher = CALL_TERMINAL_FROM_DATA_TYPE_RULE_PATTERN.matcher(javaCode);
		StringBuffer result = new StringBuffer();
		while(matcher.find()) {
			String methodName = "consumeTokenAndMerge";
			
			String indentation = matcher.group(1);
			String tokenID = matcher.group(2);
			String followSet = matcher.group(3);
			String grammarElement = matcher.group(4);
			String invocation = String.format(
					"%sif (!%s(%s, %s, current, %s())) { return current; }\n", indentation, methodName, tokenID, followSet, grammarElement);
			matcher.appendReplacement(result, invocation);
		}
		matcher.appendTail(result);
		return result.toString();
	}

	private String extractUnassignedKeywords(String javaCode) {
		Matcher matcher = CALL_UNASSIGNED_KEYWORD_PATTERN.matcher(javaCode);
		StringBuffer result = new StringBuffer();
		while(matcher.find()) {
			String methodName = "consumeUnassignedToken";
			
			String indentation = matcher.group(1);
			String tokenID = matcher.group(2);
			String followSet = matcher.group(3);
			String grammarElement = matcher.group(4);
			String invocation = String.format(
					"%sif (!%s(%s, %s, %s())) { return current; }\n", indentation, methodName, tokenID, followSet, grammarElement);
			matcher.appendReplacement(result, invocation);
		}
		matcher.appendTail(result);
		return result.toString();
	}

	private String extractAssignedKeywords(String javaCode) {
		Matcher matcher = CALL_ASSIGNED_KEYWORD_PATTERN.matcher(javaCode);
		StringBuffer result = new StringBuffer();
		while(matcher.find()) {
			String indentation = matcher.group(1);
			String tokenID = matcher.group(2);
			String followSet = matcher.group(3);
			String grammarElement = matcher.group(4);
			String setOrAdd = matcher.group(6);
			String featureID = matcher.group(7);
			String value = matcher.group(8);
			if ("set".equals(setOrAdd) && "true".equals(value)) {
				String methodName = "consumeTokenAndSetBooleanValue";
				String invocation = String.format(
						"%scurrent = %s(%s, %s, current, %s(), elementAccess.getRule(), %s);\n" +
						"%sif (state.failed) return current;\n", indentation, methodName, tokenID, followSet, grammarElement, featureID, indentation);
				matcher.appendReplacement(result, invocation);
			} else {
				String methodName = "consumeTokenAnd" + Strings.toFirstUpper(setOrAdd);
				String invocation = String.format(
						"%scurrent = %s(%s, %s, current, %s(), elementAccess.getRule(), %s);\n" +
						"%sif (state.failed) return current;\n", indentation, methodName, tokenID, followSet, grammarElement, featureID, indentation);
				matcher.appendReplacement(result, invocation);
			}
			if (!"null".equals(matcher.group(9))) {
				throw new IllegalStateException(matcher.group());
			}
		}
		matcher.appendTail(result);
		return result.toString();
	}

	private String extractParserRuleCalls(String javaCode, List<String> newMethods,	Set<Pair<String, String>> handles) {
		String result = extractAssignedParserRuleCalls(javaCode, newMethods, handles);
		result = extractUnassignedParserRuleCalls(result, newMethods, handles);
		result = extractUnassignedDatatypeRuleCalls(result, newMethods, handles);
		result = extractCrossReferenceRuleCalls(result, newMethods, handles);
		return result;
	}

	private String extractCrossReferenceRuleCalls(String javaCode, List<String> newMethods, Set<Pair<String, String>> handles) {
		Matcher matcher = CALL_CROSS_REF_RULE_PATTERN.matcher(javaCode);
		StringBuffer result = new StringBuffer();
		List<String> matches = Lists.newArrayList();
		while(matcher.find()) {
			String group = matcher.group();
			matches.add(group);
			String ruleName = matcher.group(4);
			String methodName = "callRule" + ruleName;
			Pair<String, String> methodHandle = Tuples.create(ruleName, "xref");
			if (handles.add(methodHandle)) {
				StringBuilder newMethod = new StringBuilder("\tprivate EObject ");
				newMethod.append(methodName);
				newMethod.append("(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {\n");
				newMethod.append("\t\tcurrent = createModelElementAndPushFollow(current, rule, followSet, grammarElement);\n");
				newMethod.append("\t\trule").append(ruleName).append("();\n");
				newMethod.append("\t\tpostCrossReference();\n");
				newMethod.append("\t\treturn current;\n");
				newMethod.append("\t}\n");
				newMethod.append("\n");
				newMethods.add(newMethod.toString());
			}
			String indentation = matcher.group(1);
			String followSet = matcher.group(3);
			String grammarElement = matcher.group(2);
			String invocation = String.format(
				"%scurrent = %s(%s, current, %s, elementAccess.getRule());\n" +
				"%sif (state.failed) return current;\n", indentation, methodName, followSet, grammarElement, indentation);
			matcher.appendReplacement(result, invocation);
		}
		matcher.appendTail(result);
		return result.toString();
	}

	private String extractUnassignedDatatypeRuleCalls(String javaCode, List<String> newMethods,
			Set<Pair<String, String>> handles) {
		Matcher matcher = CALL_UNASSIGNED_DATA_TYPE_RULE_PATTERN.matcher(javaCode);
		StringBuffer result = new StringBuffer();
		List<String> matches = Lists.newArrayList();
		while(matcher.find()) {
			String group = matcher.group();
			matches.add(group);
			String ruleName = matcher.group(5);
			String methodName = "callRule" + ruleName;
			Pair<String, String> methodHandle = Tuples.create(ruleName, "datatype");
			if (handles.add(methodHandle)) {
				String localVarName = matcher.group(4);
				String localVarTypeName = getLocalVarTypeName(localVarName);
				if (!"AntlrDatatypeRuleToken".equals(localVarTypeName)) {
					throw new IllegalStateException(matcher.group());
				}
				StringBuilder newMethod = new StringBuilder("\tprivate void ");
				newMethod.append(methodName);
				newMethod.append("(BitSet followSet, AntlrDatatypeRuleToken current, AbstractElement grammarElement) throws RecognitionException {\n");
				newMethod.append("\t\tpushFollow(followSet, grammarElement);\n");
				newMethod.append("\t\tmerge(current, rule").append(ruleName).append("());\n");
				newMethod.append("\t}\n");
				newMethod.append("\n");
				newMethods.add(newMethod.toString());
			}
			String indentation = matcher.group(1);
			String followSet = matcher.group(3);
			String grammarElement = matcher.group(2);
			String invocation = String.format(
				"%s%s(%s, current, %s);\n" +
				"%sif (state.failed) return current;\n", indentation, methodName, followSet, grammarElement, indentation);
			matcher.appendReplacement(result, invocation);
		}
		matcher.appendTail(result);
		return result.toString();
	}
	
	private String extractUnassignedParserRuleCalls(String javaCode, List<String> newMethods,
			Set<Pair<String, String>> handles) {
		Matcher matcher = CALL_UNASSIGNED_PARSER_RULE_PATTERN.matcher(javaCode);
		StringBuffer result = new StringBuffer();
		List<String> matches = Lists.newArrayList();
		while(matcher.find()) {
			String group = matcher.group();
			matches.add(group);
			String ruleName = matcher.group(5);
			String methodName = "callUnassignedRule" + ruleName;
			Pair<String, String> methodHandle = Tuples.create(ruleName, "unassigned");
			if (handles.add(methodHandle)) {
				String localVarName = matcher.group(4);
				String localVarTypeName = getLocalVarTypeName(localVarName);
				
				StringBuilder newMethod = new StringBuilder("\tprivate EObject ");
				newMethod.append(methodName);
				newMethod.append("(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {\n");
				newMethod.append("\t\tpushFollow(followSet, grammarElement);\n");
				newMethod.append("\t\t").append(localVarTypeName).append(" token = rule").append(ruleName).append("();\n");
				newMethod.append("\t\treturn getCurrentOrNull(token);\n");
				newMethod.append("\t}\n");
				newMethod.append("\n");
				newMethods.add(newMethod.toString());
			}
			String indentation = matcher.group(1);
			String followSet = matcher.group(3);
			String grammarElement = matcher.group(2);
			String invocation = String.format(
				"%scurrent = %s(%s, %s);\n" +
				"%sif (state.failed) return current;\n", indentation, methodName, followSet, grammarElement, indentation);
			matcher.appendReplacement(result, invocation);
		}
		matcher.appendTail(result);
		return result.toString();
	}

	private String getLocalVarTypeName(String localVarName) {
		String localVarTypeName;
		if ("this_dataType".equals(localVarName)) {
			localVarTypeName = "AntlrDatatypeRuleToken";
		} else if ("this_object".equals(localVarName)) {
			localVarTypeName = "EObject";
		} else {
			localVarTypeName = "Token";
		}
		return localVarTypeName;
	}
	
	private String extractAssignedParserRuleCalls(String javaCode, List<String> newMethods,
			Set<Pair<String, String>> handles) {
		Matcher matcher = CALL_ASSIGNED_PARSER_RULE_PATTERN.matcher(javaCode);
		StringBuffer result = new StringBuffer();
		List<String> matches = Lists.newArrayList();
		while(matcher.find()) {
			String group = matcher.group();
			matches.add(group);
			String ruleName = matcher.group(5);
			String setOrAdd = matcher.group(7);
			String methodName = "callRule" + ruleName + "And" +Strings.toFirstUpper(setOrAdd);
			Pair<String, String> methodHandle = Tuples.create(ruleName, setOrAdd);
			if (handles.add(methodHandle)) {
				String localVarName = matcher.group(4);
				String localVarTypeName = getLocalVarTypeName(localVarName);
				
				StringBuilder newMethod = new StringBuilder("\tprivate EObject ");
				newMethod.append(methodName);
				newMethod.append("(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {\n");
				newMethod.append("\t\tpushFollow(followSet, grammarElement);\n");
				newMethod.append("\t\t").append(localVarTypeName).append(" token = rule").append(ruleName).append("();\n");
				newMethod.append("\t\treturn ").append(setOrAdd).append("Value(current, token, rule, featureId, ruleName);\n");
				newMethod.append("\t}\n");
				newMethod.append("\n");
				newMethods.add(newMethod.toString());
			}
			String indentation = matcher.group(1);
			String followSet = matcher.group(3);
			String grammarElement = matcher.group(2);
			String featureId = matcher.group(8);
			String calledRuleName = matcher.group(10);
			String invocation = String.format(
				"%scurrent = %s(%s, current, %s, elementAccess.getRule(), %s, %s);\n" +
				"%sif (state.failed) return current;\n", indentation, methodName, followSet, grammarElement, featureId, calledRuleName, indentation);
			matcher.appendReplacement(result, invocation);
		}
		matcher.appendTail(result);
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(CALL_CROSS_REF_RULE_PATTERN.pattern());
	}
	
}
