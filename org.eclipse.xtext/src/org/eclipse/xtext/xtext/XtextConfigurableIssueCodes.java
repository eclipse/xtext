/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;

import com.google.inject.Singleton;

/**
 * This class holds all the configurable issue codes for the Xtext grammar language.
 * Use {@link #getConfigurableIssueCodes()} to get all registered codes.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 * @author Holger Schill
 */
@Singleton
public class XtextConfigurableIssueCodes extends ConfigurableIssueCodesProvider {

	protected static final String ISSUE_CODE_PREFIX = "org.eclipse.xtext.grammar.";
	
	public static final String INVALID_METAMODEL_NAME = ISSUE_CODE_PREFIX + "InvalidMetaModelName";
	public static final String INVALID_ACTION_USAGE = ISSUE_CODE_PREFIX + "InvalidActionUsage";
	public static final String EMPTY_ENUM_LITERAL = ISSUE_CODE_PREFIX + "EmptyEnumLiteral";
	public static final String EMPTY_KEYWORD = ISSUE_CODE_PREFIX + "EmptyKeyword";
	public static final String SPACES_IN_KEYWORD = ISSUE_CODE_PREFIX + "SpacesInKeyword";
	public static final String INVALID_HIDDEN_TOKEN = ISSUE_CODE_PREFIX + "InvalidHiddenToken";
	public static final String INVALID_HIDDEN_TOKEN_FRAGMENT = ISSUE_CODE_PREFIX + "InvalidHiddenTokenFragment";
	public static final String INVALID_PACKAGE_REFERENCE_INHERITED = ISSUE_CODE_PREFIX + "InvalidPackageReference.inherited";
	public static final String INVALID_PACKAGE_REFERENCE_EXTERNAL = ISSUE_CODE_PREFIX + "InvalidPackageReference.external";
	public static final String INVALID_PACKAGE_REFERENCE_NOT_ON_CLASSPATH = ISSUE_CODE_PREFIX + "InvalidPackageReference.notOnClasspath";
	public static final String INVALID_JAVAPACKAGE_NAME = ISSUE_CODE_PREFIX + "InvalidJavaPackageName";
	public static final String INVALID_TERMINALRULE_NAME = ISSUE_CODE_PREFIX + "InvalidTerminalRuleName";
	public static final String DISCOURAGED_RULE_NAME = ISSUE_CODE_PREFIX + "DiscouragedName";
	public static final String DUPLICATE_ENUM_LITERAL = ISSUE_CODE_PREFIX + "DuplicateEnumLiteral";
	public static final String BIDIRECTIONAL_REFERENCE = ISSUE_CODE_PREFIX + "BidirectionalReference";
	public static final String CROSS_REFERENCE_IN_ALTERNATIVES = ISSUE_CODE_PREFIX + "CrossReferenceInAlternatives";
	public static final String INVALID_FRAGMENT_AS_FIRST_RULE = ISSUE_CODE_PREFIX + "InvalidFragmentFirstRule";
	public static final String INVALID_TERMINAL_FRAGMENT_RULE_REFERENCE = ISSUE_CODE_PREFIX + "InvalidTerminalFragmentRuleReference";
	
	public static final String EXPLICIT_OVERRIDE_MISSING = ISSUE_CODE_PREFIX + "ExplicitOverrideMissing";
	public static final String EXPLICIT_OVERRIDE_INVALID = ISSUE_CODE_PREFIX + "ExplicitOverrideInvalid";
	public static final String INVALID_ANNOTAION = ISSUE_CODE_PREFIX + "InvalidAnnotation";
	public static final String USAGE_OF_DEPRECATED_RULE = ISSUE_CODE_PREFIX + "UsageOfDeprecatedRule";

	@Override
	protected void initialize(IAcceptor<PreferenceKey> acceptor) {
		acceptor.accept(create(INVALID_ACTION_USAGE, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(EMPTY_ENUM_LITERAL, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(EMPTY_KEYWORD, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(SPACES_IN_KEYWORD, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(INVALID_HIDDEN_TOKEN, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(INVALID_HIDDEN_TOKEN_FRAGMENT, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(INVALID_PACKAGE_REFERENCE_INHERITED, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(CROSS_REFERENCE_IN_ALTERNATIVES, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(INVALID_FRAGMENT_AS_FIRST_RULE, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(INVALID_TERMINAL_FRAGMENT_RULE_REFERENCE, SeverityConverter.SEVERITY_ERROR));
		
		acceptor.accept(create(INVALID_METAMODEL_NAME, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(INVALID_PACKAGE_REFERENCE_EXTERNAL, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(INVALID_PACKAGE_REFERENCE_NOT_ON_CLASSPATH, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(INVALID_JAVAPACKAGE_NAME, SeverityConverter.SEVERITY_IGNORE));
		acceptor.accept(create(INVALID_TERMINALRULE_NAME, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(DUPLICATE_ENUM_LITERAL, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(BIDIRECTIONAL_REFERENCE, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(DISCOURAGED_RULE_NAME, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(USAGE_OF_DEPRECATED_RULE, SeverityConverter.SEVERITY_WARNING));
		
	}
	
}
