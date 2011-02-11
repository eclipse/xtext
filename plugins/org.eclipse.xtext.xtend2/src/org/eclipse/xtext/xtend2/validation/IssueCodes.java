/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public final class IssueCodes {


	private IssueCodes() {
	}

	protected static final String ISSUE_CODE_PREFIX = "org.eclipse.xtext.xtend2.validation.IssueCodes.";

	public static final String CASE_FUNC_WITHOUT_PARAMS = ISSUE_CODE_PREFIX + "case_function_without_params";
	public static final String CASE_FUNC_WITH_TYPE_PARAMS = ISSUE_CODE_PREFIX + "case_function_with_type_params";
	public static final String SINGLE_CASE_FUNCTION = ISSUE_CODE_PREFIX + "single_case_function";
	public static final String WRONG_PACKAGE = ISSUE_CODE_PREFIX + "wrong_package";
	public static final String WRONG_FILE = ISSUE_CODE_PREFIX + "wrong_file";
	public static final String CLASS_EXPECTED = ISSUE_CODE_PREFIX + "class_expected";
	public static final String INTERFACE_EXPECTED = ISSUE_CODE_PREFIX + "interface_expected";
	public static final String DUPLICATE_METHOD = ISSUE_CODE_PREFIX + "duplicate_method";
	public static final String INCOMPATIBLE_RETURN_TYPE = ISSUE_CODE_PREFIX + "incomptible_return_type";
	public static final String MISSING_OVERRIDE = ISSUE_CODE_PREFIX + "missing_override";
	public static final String OBSOLETE_OVERRIDE = ISSUE_CODE_PREFIX + "obsolete_override";
	public static final String INCONSISTENT_INDENTATION = ISSUE_CODE_PREFIX + "inconsistent_indentation";

}
