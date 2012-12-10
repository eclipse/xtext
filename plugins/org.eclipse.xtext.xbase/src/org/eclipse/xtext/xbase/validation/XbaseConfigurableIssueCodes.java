/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.ConfigurableIssueCode;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseConfigurableIssueCodes extends ConfigurableIssueCodesProvider {

	private static final ConfigurableIssueCode JAVA_COMPILER_PB_FORBIDDEN_REFERENCE = new ConfigurableIssueCode(JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE, Severity.ERROR);
	private static final ConfigurableIssueCode JAVA_COMPILER_PB_DISCOURAGED_REFERENCE = new ConfigurableIssueCode(JavaCore.COMPILER_PB_DISCOURAGED_REFERENCE, Severity.WARNING);
	public static final ConfigurableIssueCode FORBIDDEN_REFERENCE = new ConfigurableIssueCode(IssueCodes.FORBIDDEN_REFERENCE, JAVA_COMPILER_PB_FORBIDDEN_REFERENCE);
	public static final ConfigurableIssueCode DISCOURAGED_REFERENCE = new ConfigurableIssueCode(IssueCodes.DISCOURAGED_REFERENCE, JAVA_COMPILER_PB_DISCOURAGED_REFERENCE);
	
	private static final Map<String, ConfigurableIssueCode> allConfigurableCodes = newLinkedHashMap();
	
	static {
		allConfigurableCodes.put(FORBIDDEN_REFERENCE.getId(), FORBIDDEN_REFERENCE);
		allConfigurableCodes.put(DISCOURAGED_REFERENCE.getId(), DISCOURAGED_REFERENCE);
	}
	
	@Override
	public Map<String, ConfigurableIssueCode> getConfigurableIssueCodes() {
		return allConfigurableCodes;
	}
}
