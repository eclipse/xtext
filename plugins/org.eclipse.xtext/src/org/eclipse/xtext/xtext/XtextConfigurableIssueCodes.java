/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Map;

import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.inject.Singleton;

/**
 * This class holds all the configurable issue codes for the Xtext grammar language.
 * Use {@link #getConfigurableIssueCodes()} to get all registered codes.
 * 
 * @author Miro Spoenemann - Initial contribution and API
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
	public static final String INVALID_TERMINALRULE_NAME = ISSUE_CODE_PREFIX + "InvalidTerminalRuleName";
	public static final String DISCOURAGED_RULE_NAME = ISSUE_CODE_PREFIX + "DiscouragedName";
	public static final String DUPLICATE_ENUM_LITERAL = ISSUE_CODE_PREFIX + "DuplicateEnumLiteral";
	public static final String BIDIRECTIONAL_REFERENCE = ISSUE_CODE_PREFIX + "BidirectionalReference";
	
	private Map<String, PreferenceKey> issueCodes;

	public XtextConfigurableIssueCodes() {
		final Map<String, PreferenceKey> map = Maps.newLinkedHashMap();
		initialize(new IAcceptor<PreferenceKey>() {
			@Override
			public void accept(PreferenceKey prefKey) {
				map.put(prefKey.getId(), prefKey);
			}
		});
		this.issueCodes = ImmutableMap.copyOf(map);
	}

	protected void initialize(IAcceptor<PreferenceKey> acceptor) {
		acceptor.accept(create(INVALID_ACTION_USAGE, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(EMPTY_ENUM_LITERAL, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(EMPTY_KEYWORD, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(SPACES_IN_KEYWORD, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(INVALID_HIDDEN_TOKEN, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(INVALID_HIDDEN_TOKEN_FRAGMENT, SeverityConverter.SEVERITY_ERROR));
		acceptor.accept(create(INVALID_PACKAGE_REFERENCE_INHERITED, SeverityConverter.SEVERITY_ERROR));
		
		acceptor.accept(create(INVALID_METAMODEL_NAME, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(INVALID_PACKAGE_REFERENCE_EXTERNAL, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(INVALID_PACKAGE_REFERENCE_NOT_ON_CLASSPATH, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(INVALID_TERMINALRULE_NAME, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(DUPLICATE_ENUM_LITERAL, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(BIDIRECTIONAL_REFERENCE, SeverityConverter.SEVERITY_WARNING));
		acceptor.accept(create(DISCOURAGED_RULE_NAME, SeverityConverter.SEVERITY_WARNING));
	}

	protected final PreferenceKey create(String id, String defaultValue) {
		return new PreferenceKey(id, defaultValue);
	}

	@Override
	public final Map<String, PreferenceKey> getConfigurableIssueCodes() {
		return issueCodes;
	}
	
}
