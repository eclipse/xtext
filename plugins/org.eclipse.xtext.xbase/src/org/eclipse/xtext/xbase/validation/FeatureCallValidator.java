/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FeatureCallValidator extends AbstractDeclarativeValidator {

	@Inject
	protected UIStrings uiStrings;

	@Inject
	private IdentifiableSimpleNameProvider nameProvider;

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
		if (FEATURE_NOT_VISIBLE.equals(issueCode))
			message = "Feature " + nameProvider.getSimpleName(featureCall.getFeature()) + " is not visible";
		else if (INVALID_NUMBER_OF_ARGUMENTS.equals(issueCode)) {
			message = "Invalid number of arguments. Expected " + uiStrings.parameters(featureCall.getFeature());
		} else if (INVALID_NUMBER_OF_TYPE_ARGUMENTS.equals(issueCode)) {
			message = "Invalid number of type arguments. Expected "
					+ uiStrings.typeParameters(featureCall.getFeature()) + " but got "
					+ uiStrings.typeArguments(featureCall);
		} else if (INVALID_ARGUMENT_TYPES.equals(issueCode)) {
			// Type conformance errors are checked in XbaseJavaValidator.
			// We cannot rely on the types used during linking because, they might have been incomplete
		} else if (ASSIGNMENT_TARGET_IS_NOT_WRITEABLE.equals(issueCode)) {
			message = "Feature " + nameProvider.getSimpleName(featureCall.getFeature()) + " is not writeable.";
		} else if (INSTANCE_ACCESS_TO_STATIC_MEMBER.equals(issueCode)) {
			message = "Instance access to static member " + nameProvider.getSimpleName(featureCall.getFeature());
		} else if (STATIC_ACCESS_TO_INSTANCE_MEMBER.equals(issueCode)) {
			message = "Static access to instance member " + nameProvider.getSimpleName(featureCall.getFeature());
		} else if (FIELD_ACCESS_WITH_PARENTHESES.equals(issueCode)) {
			message = "Cannot access field " + nameProvider.getSimpleName(featureCall.getFeature())
					+ " with parentheses";
		} else if (LOCAL_VAR_ACCESS_WITH_PARENTHESES.equals(issueCode)) {
			message = "Cannot access local variable " + nameProvider.getSimpleName(featureCall.getFeature())
					+ " with parentheses";
		} else if (METHOD_ACCESS_WITHOUT_PARENTHESES.equals(issueCode)) {
			message = "Missing parentheses for calling method " + featureCall.getFeature().getIdentifier();
		} else if (INVALID_MUTABLE_VARIABLE_ACCESS.equals(issueCode)) {
			message = "Cannot refer to a non-final variable "+ featureCall.getFeature().getIdentifier() + " from within a closure";
		} else {
			message = "Missig error message for " + issueCode;
		}
		if (message != null)
			error(message, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, issueCode);
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
		error(message, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, issueCode);
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}
}
