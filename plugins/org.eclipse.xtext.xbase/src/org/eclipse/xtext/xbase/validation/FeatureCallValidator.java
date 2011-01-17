/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FeatureCallValidator extends AbstractDeclarativeValidator {

	@Inject
	protected UIStrings uiStrings;

	protected static final String ISSUE_CODE_PREFIX = FeatureCallValidator.class.getCanonicalName() + ".";
	public static final String INVALID_NUMBER_OF_ARGUMENTS = ISSUE_CODE_PREFIX + "invalid_number_of_arguments";
	public static final String INVALID_NUMBER_OF_TYPE_ARGUMENTS = ISSUE_CODE_PREFIX
			+ "invalid_number_of_type_arguments";
	public static final String INVALID_ARGUMENT_TYPES = ISSUE_CODE_PREFIX + "invalid_argument_types";
	public static final String ASSIGNMENT_TARGET_IS_NOT_WRITEABLE = ISSUE_CODE_PREFIX
			+ "assignment_target_is_not_writeable";
	public static final String INSTANCE_ACCESS_TO_STATIC_MEMBER = ISSUE_CODE_PREFIX
			+ "instance_access_to_static_member";
	public static final String FIELD_ACCESS_WITH_PARENTHESES = ISSUE_CODE_PREFIX + "field_access_with_parentheses";
	public static final String METHOD_ACCESS_WITHOUT_PARENTHESES = ISSUE_CODE_PREFIX
			+ "method_access_without_parentheses";

	@Check
	public void checkInvalidFeatureLinked(XAbstractFeatureCall featureCall) {
		if (!featureCall.isValidFeature()) {
			error(featureCall, featureCall.getInvalidFeatureIssueCode());
		}
	}

	@Check
	public void checkInvalidFeatureLinked(XConstructorCall constructorCall) {
		if (!constructorCall.isValidFeature()) {
			error(constructorCall, constructorCall.getInvalidFeatureIssueCode());
		}
	}

	protected void error(XAbstractFeatureCall featureCall, String issueCode) {
		String message = null;
		if (INVALID_NUMBER_OF_ARGUMENTS.equals(issueCode)) {
			message = "Invalid number of arguments. Expected " + uiStrings.parameters(featureCall.getFeature());
		} else if (INVALID_NUMBER_OF_TYPE_ARGUMENTS.equals(issueCode)) {
			message = "Invalid number of type arguments. Expected "
					+ uiStrings.typeParameters(featureCall.getFeature()) + " but got "
					+ uiStrings.typeArguments(featureCall);
		} else if (INVALID_ARGUMENT_TYPES.equals(issueCode)) {
			message = "Invalid argument types. Expected " + uiStrings.parameters(featureCall.getFeature())
					+ " but got " + uiStrings.arguments(featureCall);
		} else if (ASSIGNMENT_TARGET_IS_NOT_WRITEABLE.equals(issueCode)) {
			message = "Feature " + featureCall.getFeatureName() + " is not writeable.";
		} else if (INSTANCE_ACCESS_TO_STATIC_MEMBER.equals(issueCode)) {
			message = "Instance access to static member " + featureCall.getFeatureName();
		} else if (FIELD_ACCESS_WITH_PARENTHESES.equals(issueCode)) {
			message = "Cannot access field " + featureCall.getFeatureName() + " with parentheses";
		} else if (METHOD_ACCESS_WITHOUT_PARENTHESES.equals(issueCode)) {
			message = "Missing parentheses for calling method " + featureCall.getFeature().getCanonicalName();
		} else {
			message = "Missig error message for " + issueCode;
		}
		error(message, -1, issueCode);
	}
	
	protected void error(XConstructorCall constructorCall, String issueCode) {
		String message = null;
		if (INVALID_NUMBER_OF_ARGUMENTS.equals(issueCode)) {
			message = "Invalid number of arguments. Expected " + uiStrings.parameters(constructorCall.getConstructor());
		} else if (INVALID_NUMBER_OF_TYPE_ARGUMENTS.equals(issueCode)) {
			message = "Invalid number of type arguments. Expected "
					+ uiStrings.typeParameters(constructorCall.getConstructor()) + " but got "
					+ uiStrings.typeArguments(constructorCall);
		} else if (INVALID_ARGUMENT_TYPES.equals(issueCode)) {
			message = "Invalid argument types. Expected " + uiStrings.parameters(constructorCall.getConstructor())
					+ " but got " + uiStrings.arguments(constructorCall);
		} 
		error(message, -1, issueCode);
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}
}
