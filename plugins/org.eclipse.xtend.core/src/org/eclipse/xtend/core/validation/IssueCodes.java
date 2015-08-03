/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.validation;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public final class IssueCodes {

	private IssueCodes() {
	}

	protected static final String ISSUE_CODE_PREFIX = "org.eclipse.xtend.core.validation.IssueCodes.";
//	public static final String FEATURECALL_LINKING_DIAGNOSTIC = ISSUE_CODE_PREFIX + "feature_linking";
	public static final String JAVA_DOC_LINKING_DIAGNOSTIC = ISSUE_CODE_PREFIX + "java_doc_linking";
	public static final String ANNOTATION_WRONG_TARGET = ISSUE_CODE_PREFIX + "wrong_annotation_target";
	public static final String ANNOTATION_MULTIPLE = ISSUE_CODE_PREFIX + "multiple_annotations_used";
	
	public static final String DISPATCH_FUNC_WITHOUT_PARAMS = ISSUE_CODE_PREFIX + "case_function_without_params";
	public static final String DISPATCH_FUNC_WITH_TYPE_PARAMS = ISSUE_CODE_PREFIX + "case_function_with_type_params";
	public static final String DISPATCH_FUNC_NAME_STARTS_WITH_UNDERSCORE = ISSUE_CODE_PREFIX
			+ "case_func_name_starts_with_underscore";
	public static final String DISPATCH_FUNCTIONS_WITH_DIFFERENT_VISIBILITY = "dispatch_functions_with_different_visibility";
	public static final String DISPATCH_FUNCTIONS_MIXED_STATIC_AND_NON_STATIC = "dispatch_functions_mixed_static_and_non_static";
	public static final String DISPATCH_FUNCTIONS_STATIC_EXPECTED = "dispatch_functions_static_expected";
	public static final String DISPATCH_FUNCTIONS_NON_STATIC_EXPECTED = "dispatch_functions_non_static_expected";
	public static final String DISPATCH_FUNCTIONS_MUST_NOT_BE_ABSTRACT = "dispatch_functions_must_not_be_abstract";
	public static final String DISPATCH_FUNCTIONS_INVALID_PARAMETER_TYPE = "dispatch_functions_may_not_widen_inherited_signature";
	public static final String SINGLE_DISPATCH_FUNCTION = ISSUE_CODE_PREFIX + "single_case_function";
	public static final String DISPATCH_PLAIN_FUNCTION_NAME_CLASH = ISSUE_CODE_PREFIX + "dispatch_plain_function_name_clash";
	public static final String DISPATCH_FUNCTIONS_DIFFERENT_PRIMITIVE_ARGS = ISSUE_CODE_PREFIX + "dispatch_functions_different_primitive_args";
	public static final String CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT = "create_functions_must_not_be_abstract";
	public static final String WRONG_PACKAGE = ISSUE_CODE_PREFIX + "wrong_package";
	public static final String WRONG_FILE = ISSUE_CODE_PREFIX + "wrong_file";
	public static final String CLASS_EXPECTED = ISSUE_CODE_PREFIX + "class_expected";
	public static final String INTERFACE_EXPECTED = ISSUE_CODE_PREFIX + "interface_expected";
	public static final String DUPLICATE_METHOD = ISSUE_CODE_PREFIX + "duplicate_method";
	public static final String DUPLICATE_FIELD = ISSUE_CODE_PREFIX + "duplicate_field";
	public static final String DUPLICATE_TYPE_NAME = org.eclipse.xtext.xbase.validation.IssueCodes.DUPLICATE_TYPE;
	public static final String CONFLICTING_DEFAULT_METHODS = ISSUE_CODE_PREFIX + "conflicting_default_methods";
	public static final String MISSING_ABSTRACT = ISSUE_CODE_PREFIX + "missing_abstract";
	public static final String MISSING_ABSTRACT_IN_ANONYMOUS = ISSUE_CODE_PREFIX + "missing_abstract_in_anonymous";
	public static final String MISSING_OVERRIDE = ISSUE_CODE_PREFIX + "missing_override";
	public static final String OBSOLETE_OVERRIDE = ISSUE_CODE_PREFIX + "obsolete_override";
	public static final String INCONSISTENT_INDENTATION = ISSUE_CODE_PREFIX + "inconsistent_indentation";

	public static final String XBASE_LIB_NOT_ON_CLASSPATH = ISSUE_CODE_PREFIX + "xbase_lib_not_on_classpath";
	public static final String JDK_NOT_ON_CLASSPATH = ISSUE_CODE_PREFIX + "jdk_not_on_classpath";

	public static final String CLASS_MUST_BE_ABSTRACT = ISSUE_CODE_PREFIX + "class_must_be_defined_abstract";
	public static final String ANONYMOUS_CLASS_MISSING_MEMBERS = ISSUE_CODE_PREFIX + "anonymous_class_missing_members";
	public static final String ANONYMOUS_CLASS_STATIC_METHOD = ISSUE_CODE_PREFIX + "anonymous_class_static_method";
	public static final String ANONYMOUS_CLASS_STATIC_FIELD = ISSUE_CODE_PREFIX + "anonymous_class_static_field";
	public static final String DUPLICATE_PARAMETER_NAME = ISSUE_CODE_PREFIX + "duplicate_parameter_name";

	public static final String OVERRIDDEN_FINAL = ISSUE_CODE_PREFIX + "overridden_final";
	public static final String OVERRIDE_REDUCES_VISIBILITY = ISSUE_CODE_PREFIX + "override_reduces_visibility";
	public static final String INCOMPATIBLE_THROWS_CLAUSE = ISSUE_CODE_PREFIX + "incompatible_throws_clause";
	public static final String CYCLIC_INHERITANCE = ISSUE_CODE_PREFIX + "cyclic_inheritance";

	public static final String UNUSED_PRIVATE_MEMBER = ISSUE_CODE_PREFIX + "unused_private_member";
	public static final String FIELD_NOT_INITIALIZED = ISSUE_CODE_PREFIX + "field_not_initialized";
	public static final String EXCEPTION_NOT_THROWABLE = ISSUE_CODE_PREFIX + "exception_not_throwable";
	public static final String EXCEPTION_DECLARED_TWICE = ISSUE_CODE_PREFIX + "exception_declared_twice";

	public static final String MISSING_CONSTRUCTOR = ISSUE_CODE_PREFIX + "missing_constructor";
	public static final String MUST_INVOKE_SUPER_CONSTRUCTOR = ISSUE_CODE_PREFIX + "must_invoke_super_constructor";
	public static final String CONSTRUCTOR_TYPE_PARAMS_NOT_SUPPORTED = ISSUE_CODE_PREFIX
			+ "constructor_type_params_not_supported";
	public static final String CONSTRUCTOR_NOT_PERMITTED = ISSUE_CODE_PREFIX + "constructor_not_permitted";

	public static final String INVALID_USE_OF_STATIC = ISSUE_CODE_PREFIX + "invalid_use_of_static";
	public static final String INVALID_USE_OF_VAR_ARG = ISSUE_CODE_PREFIX + "invalid_use_of_varArg";
	public static final String INVALID_ANNOTATION_VALUE_TYPE = ISSUE_CODE_PREFIX + "invalid_annotation_value_type";

	public static final String INVALID_MEMBER_NAME = ISSUE_CODE_PREFIX + "invalid_member_name";
	public static final String LEFT_HAND_SIDE_MUST_BE_VARIABLE = "left_hand_side_must_be_variable";
	
	public static final String ABSTRACT_METHOD_MISSING_RETURN_TYPE = ISSUE_CODE_PREFIX + "abstract_method_missing_return_type";
	public static final String ABSTRACT_METHOD_WITH_BODY = ISSUE_CODE_PREFIX + "abstract_method_with_body";
	
	public static final String INVALID_MODIFIER = ISSUE_CODE_PREFIX +  "invalid_modifier";
	public static final String MISSING_STATIC_MODIFIER = ISSUE_CODE_PREFIX +  "missing_static_modifier";
	
	public static final String WILDCARD_IN_SUPERTYPE = ISSUE_CODE_PREFIX +  "wildcard_in_supertype";

	public static final String INVALID_EXTENSION_TYPE = ISSUE_CODE_PREFIX +  "invalid_extension_type";
	
	public static final String INVALID_OPERATOR_SIGNATURE = ISSUE_CODE_PREFIX +  "invalid_operator_signature";
	
	public static final String PROCESSING_ERROR = ISSUE_CODE_PREFIX +  "processing_error";
	
	public static final String ORPHAN_ELMENT = ISSUE_CODE_PREFIX +  "orphan_element";
	
	public static final String ACTIVE_ANNOTAION_IN_SAME_CONTAINER = ISSUE_CODE_PREFIX +  "active_annotation_in_same_project";
	
	public static final String API_TYPE_INFERENCE = ISSUE_CODE_PREFIX +  "api_type_inference";
	
	public static final String IMPLICIT_RETURN = ISSUE_CODE_PREFIX +  "implicit_return";
	
}
