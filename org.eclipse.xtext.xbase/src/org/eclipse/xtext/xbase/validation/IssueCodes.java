/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Stéphane Galland - Add the "deprecation" warning.
 */
public class IssueCodes extends org.eclipse.xtext.validation.IssueCodes {
	
	protected static final String ISSUE_CODE_PREFIX = "org.eclipse.xtext.xbase.validation.IssueCodes.";

	public static final String ABSTRACT_CLASS_INSTANTIATION = ISSUE_CODE_PREFIX + "abstract_class_instantiation";
	public static final String AMBIGUOUS_FEATURE_CALL = ISSUE_CODE_PREFIX + "ambiguous_feature_call";
	public static final String DUPLICATE_CASE = ISSUE_CODE_PREFIX + "duplicate_case";
	public static final String REDUNDANT_CASE = ISSUE_CODE_PREFIX + "redundant_case";
	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=397062 */
	/**
	 * This indicates an overload problem, e.g. if two implicit receivers provide methods
	 * and the outer receiver wins ('it' looses against 'this').
	 */
	public static final String SUSPICIOUSLY_OVERLOADED_FEATURE = ISSUE_CODE_PREFIX + "suspiciously_overloaded_feature";
	public static final String ANNOTATIONS_ILLEGAL_ATTRIBUTE = ISSUE_CODE_PREFIX + "no_illegal_value";
	public static final String ANNOTATIONS_NO_VALUE_ATTRIBUTE = ISSUE_CODE_PREFIX + "no_attribute_value";
	public static final String ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION = ISSUE_CODE_PREFIX + "missing_attribute_definition";
	public static final String ASSIGNMENT_TO_FINAL = ISSUE_CODE_PREFIX + "assignment_to_final";
	public static final String ASSIGNMENT_TO_NO_VARIABLE = ISSUE_CODE_PREFIX + "assignment_to_no_variable";
	public static final String CIRCULAR_CONSTRUCTOR_INVOCATION = ISSUE_CODE_PREFIX + "circular_constructor_invocation";
	public static final String FEATURE_NOT_VISIBLE = ISSUE_CODE_PREFIX + "invisible_feature";
	public static final String FIELD_ACCESS_WITH_PARENTHESES = ISSUE_CODE_PREFIX + "field_access_with_parentheses";
	public static final String ILLEGAL_FORWARD_REFERENCE = ISSUE_CODE_PREFIX + "illegal_forward_reference";
	public static final String ILLEGAL_CLASS_INSTANTIATION = ISSUE_CODE_PREFIX + "illegal_class_instantiation";
	/**
	 * This feature code indicates a type incompatibility of a method return type.
	 * Those include conflicts between an implementing method and its super declaration or between dispatch methods.
	 */
	public static final String INCOMPATIBLE_RETURN_TYPE = ISSUE_CODE_PREFIX + "incomptible_return_type";
	public static final String INCOMPATIBLE_TYPES = ISSUE_CODE_PREFIX + "incompatible_types";
	public static final String INSTANCE_ACCESS_TO_STATIC_MEMBER = ISSUE_CODE_PREFIX + "instance_access_to_static_member";
	public static final String INVALID_ARGUMENT_TYPES = ISSUE_CODE_PREFIX + "invalid_argument_types";
	public static final String INVALID_OPERAND_TYPES = ISSUE_CODE_PREFIX + "invalid_operand_types";
	public static final String INVALID_CAST = ISSUE_CODE_PREFIX + "invalid_cast";
	public static final String JAVA_STYLE_TYPE_CAST = ISSUE_CODE_PREFIX + "java_style_type_cast";
	public static final String INVALID_CONSTRUCTOR_INVOCATION = ISSUE_CODE_PREFIX + "invalid_constructor_invocation";
	public static final String INVALID_CONSTRUCTOR_ARGUMENT = ISSUE_CODE_PREFIX + "invalid_constructor_argument";
	public static final String INVALID_EARLY_EXIT = ISSUE_CODE_PREFIX + "invalid_early_exit";
	public static final String INVALID_GENERIC_ARGUMENT_TYPES = ISSUE_CODE_PREFIX + "invalid_generic_argument_types";
	/**
	 * Used to indicate expressions that don't cause any effect, e.g. they are pure but not 
	 * used in a return context / as an implicit return value.
	 */
	public static final String INVALID_INNER_EXPRESSION = ISSUE_CODE_PREFIX + "invalid_inner_expression";
	public static final String INVALID_INSTANCEOF = ISSUE_CODE_PREFIX + "invalid_instanceof";
	public static final String INVALID_MUTABLE_VARIABLE_ACCESS = ISSUE_CODE_PREFIX + "invalid_mutable_variable_access";
	public static final String INVALID_NUMBER_OF_ARGUMENTS = ISSUE_CODE_PREFIX + "invalid_number_of_arguments";
	public static final String INVALID_NUMBER_OF_TYPE_ARGUMENTS = ISSUE_CODE_PREFIX + "invalid_number_of_type_arguments";
	/**
	 * Indicates that an invalid wildcard reference was defined, e.g.
	 * &lt;? extends Number &amp; CharSequence&gt;
	 */
	public static final String INVALID_WILDCARD_CONSTRAINTS = ISSUE_CODE_PREFIX + "invalid_wildcard_constraints";
	/**
	 * Covers error conditions like the following:
	 * <ul>
	 * <li>Object&lt;String&gt;</li>
	 * <li>int&lt;String&gt;</li>
	 * <li>MyAnnotation&lt;String&gt;</li>
	 * <li>MyEnum&lt;String&gt;</li>
	 * </ul>
	 */
	public static final String TYPE_ARGUMENT_ON_NON_GENERIC_TYPE = ISSUE_CODE_PREFIX + "type_argument_on_non_generic_type";
	public static final String INVALID_RETURN = ISSUE_CODE_PREFIX + "invalid_return";
	public static final String INVALID_USE_OF_TYPE = ISSUE_CODE_PREFIX + "invalid_use_of_void";
	public static final String INVALID_USE_OF_WILDCARD = ISSUE_CODE_PREFIX + "invalid_use_of_wild_card";
	public static final String LOCAL_VAR_ACCESS_WITH_PARENTHESES = ISSUE_CODE_PREFIX + "local_var_access_with_parentheses";
	public static final String METHOD_ACCESS_WITHOUT_PARENTHESES = ISSUE_CODE_PREFIX + "method_access_without_parentheses";
	public static final String MISSING_INITIALIZATION = ISSUE_CODE_PREFIX + "missing_initialization";
	public static final String MISSING_TYPE = ISSUE_CODE_PREFIX + "missing_type";
	public static final String OBSOLETE_CAST = ISSUE_CODE_PREFIX + "obsolete_cast";
	public static final String OBSOLETE_INSTANCEOF = ISSUE_CODE_PREFIX + "obsolete_instanceof";
	public static final String STATIC_ACCESS_TO_INSTANCE_MEMBER = ISSUE_CODE_PREFIX	+ "static_access_to_instance_member";
	public static final String NO_ENCLOSING_INSTANCE_AVAILABLE = ISSUE_CODE_PREFIX + "no_enclosing_instance_available";
	public static final String TOO_LITTLE_TYPE_INFORMATION = ISSUE_CODE_PREFIX + "too_little_type_information";
	public static final String TOO_MANY_PARAMS_IN_CLOSURE = ISSUE_CODE_PREFIX + "too_many_params_in_closure";
	public static final String UNEXPECTED_INVOCATION_ON_TYPE_LITERAL = ISSUE_CODE_PREFIX + "unexpected_invocation_on_type_literal";
	public static final String UNHANDLED_EXCEPTION = ISSUE_CODE_PREFIX + "unhandled_exception";
	public static final String UNREACHABLE_CODE = ISSUE_CODE_PREFIX + "unreachable_code";
	public static final String CONSTANT_BOOLEAN_CONDITION = ISSUE_CODE_PREFIX + "constant_condition";
	public static final String UNREACHABLE_CASE = ISSUE_CODE_PREFIX + "unreachable_case";
	public static final String UNREACHABLE_IF_BLOCK = ISSUE_CODE_PREFIX + "unreachable_instance_of";
	public static final String UNREACHABLE_CATCH_BLOCK = ISSUE_CODE_PREFIX + "unreachable_catch_block";
	public static final String INCOMPLETE_CASES_ON_ENUM = ISSUE_CODE_PREFIX + "incomplete_cases_on_enum";
	public static final String VARIABLE_NAME_SHADOWING = ISSUE_CODE_PREFIX + "variable_name_shadowing";
	public static final String VARIABLE_NAME_DISALLOWED = ISSUE_CODE_PREFIX + "variable_name_disallowed";
	public static final String VARIABLE_NAME_DISCOURAGED = ISSUE_CODE_PREFIX + "variable_name_discouraged";
	public static final String NULL_SAFE_FEATURE_CALL_ON_PRIMITIVE = ISSUE_CODE_PREFIX + "null_safe_feature_call_on_primitive";
	/**
	 * Indicates a synthesized default value for a primitive type, e.g.
	 * {@code list?.isEmpty} or {@code val boolean b = if (condition) true}. 
	 */
	public static final String NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE = ISSUE_CODE_PREFIX + "null_safe_feature_call_on_primitive_valued_feature";
	public static final String PRIMITIVE_COMPARED_TO_NULL = ISSUE_CODE_PREFIX	+ "primitive_compared_to_null";
	/*
	 * See findbugs pattern EC_NULL_ARG:
	 * 
	 * This method calls equals(Object), passing a null value as the argument. According to the contract of the equals() method, this call should always return false.
	 */
	public static final String EQUALS_WITH_NULL = ISSUE_CODE_PREFIX	+ "equals_with_null";
	public static final String NOT_INSTANTIABLE = ISSUE_CODE_PREFIX + "not_instantiable";
	public static final String UNUSED_LOCAL_VARIABLE = ISSUE_CODE_PREFIX + "unused_local_variable";
	public static final String INVALID_IDENTIFIER = ISSUE_CODE_PREFIX + "invalid_identifier";
	public static final String INVALID_NUMBER_FORMAT = ISSUE_CODE_PREFIX + "invalidNumberFormat";
	public static final String FIELD_ALREADY_INITIALIZED = ISSUE_CODE_PREFIX + "field_already_initialized";
	public static final String INVALID_TYPE = ISSUE_CODE_PREFIX + "invalid_type";
	
	public static final String IMPORT_DUPLICATE = ISSUE_CODE_PREFIX + "import_duplicate";
	public static final String IMPORT_UNUSED = ISSUE_CODE_PREFIX + "import_unsued";
	public static final String IMPORT_COLLISION = ISSUE_CODE_PREFIX + "import_collision";
	public static final String IMPORT_CONFLICT = ISSUE_CODE_PREFIX + "import_conflict";
	public static final String IMPORT_WILDCARD_DEPRECATED = ISSUE_CODE_PREFIX + "import_wildcard_deprecated";
	public static final String IMPORT_UNRESOLVED = ISSUE_CODE_PREFIX + "import_unresolved";
	
	public static final String FORBIDDEN_REFERENCE = ISSUE_CODE_PREFIX	+ "forbidden_reference";
	public static final String DISCOURAGED_REFERENCE = ISSUE_CODE_PREFIX	+ "discouraged_reference";
	
	public static final String RAW_TYPE = ISSUE_CODE_PREFIX	+ "raw_type";
	public static final String TYPE_BOUNDS_MISMATCH = ISSUE_CODE_PREFIX + "type_bounds_missmatch";
	public static final String INVALID_USE_OF_TYPE_PARAMETER = ISSUE_CODE_PREFIX + "invalid_use_of_type_parameter";
	public static final String TYPE_PARAMETER_FORWARD_REFERENCE = ISSUE_CODE_PREFIX + "type_parameter_forward_reference";
	public static final String INVALID_TYPE_PARAMETER_BOUNDS = ISSUE_CODE_PREFIX + "invalid_type_parameter_bounds";
	public static final String INVALID_TYPE_ARGUMENTS_ON_TYPE_LITERAL = ISSUE_CODE_PREFIX + "invalid_type_arguments_on_type_literal";

	public static final String OPERATION_WITHOUT_PARENTHESES = ISSUE_CODE_PREFIX + "operation_without_parentheses";

	/**
	 * A deprecated feature is used.
	 */
	public static final String DEPRECATED_MEMBER_REFERENCE = ISSUE_CODE_PREFIX + "deprecated_member_reference";
	
	/**
	 * A type is defined twice.
	 */
	public static final String DUPLICATE_TYPE = ISSUE_CODE_PREFIX + "duplicate_type";
	
	public static final String INVALID_SUPER_CALL = ISSUE_CODE_PREFIX +  "invalid_super_call";
	
	/**
	 * In default methods, we need to use qualified super calls. Disabled by default. Enable if your language
	 * generates code with default methods.
	 */
	public static final String UNQUALIFIED_SUPER_CALL = ISSUE_CODE_PREFIX +  "unqualified_super_call";
	
	/**
	 * An explicit invocation of an abstract method. This is only relevant when using <code>super</code>, e.g. calling
	 * <code>super.foo()</code> when <code>foo()</code> is declared abstract in the super class.
	 */
	public static final String ABSTRACT_METHOD_INVOCATION = ISSUE_CODE_PREFIX + "abstract_method_invocation";
	
	public static final String REFER_INVALID_TYPES = ISSUE_CODE_PREFIX + "refer_invalid_types";
	
	/**
	 * A multitype `A | B` where A is a subtype of B or vice versa.
	 */
	public static final String INVALID_MULTITYPE_PART = ISSUE_CODE_PREFIX + "invalid_multitype_part";
	
	/**
	 * @since 2.18
	 */
	public static final String INVALID_TRY_RESOURCE_TYPE = ISSUE_CODE_PREFIX + "invalid_try_resource_type";
	
	private IssueCodes() {
	}

}
