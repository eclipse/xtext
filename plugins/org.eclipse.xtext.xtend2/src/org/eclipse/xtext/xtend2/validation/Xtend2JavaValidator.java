/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xtend2.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.common.types.util.JvmFeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableTypeProvider;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@ComposedChecks(validators = { ClasspathBasedChecks.class })
public class Xtend2JavaValidator extends XbaseJavaValidator {

	@Inject
	private JvmFeatureOverridesService featureOverridesService;

	@Inject
	private TypeArgumentContext.Provider typeArgumentContextProvider;

	@Inject
	private TypesFactory typesFactory;

	@Inject
	private IdentifiableTypeProvider identifiableTypeProvider;

	@Inject
	private RichStringProcessor richStringProcessor;

	@Inject
	private IJvmTypeConformanceComputer conformanceComputer;

	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(Xtend2Package.eINSTANCE, XbasePackage.eINSTANCE);
	}

	@Check
	public void checkWhitespaceInRichStrings(RichString richString) {
		// don't check the indentation of nested rich strings in 
		// IF and FOR individually
		if (richString.eContainer() instanceof RichStringIf) {
			RichStringIf container = (RichStringIf) richString.eContainer();
			if (container.getThen() == richString || container.getElse() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringElseIf) {
			RichStringElseIf container = (RichStringElseIf) richString.eContainer();
			if (container.getThen() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringForLoop) {
			RichStringForLoop container = (RichStringForLoop) richString.eContainer();
			if (container.getEachExpression() == richString)
				return;
		}
		doCheckWhitespaceIn(richString);
	}

	protected void doCheckWhitespaceIn(RichString richString) {
		ValidatingRichStringAcceptor helper = new ValidatingRichStringAcceptor(this);
		richStringProcessor.process(richString, helper, helper);
	}

	@Check
	public void checkSuperTypes(XtendClass xtendClass) {
		JvmTypeReference superClass = xtendClass.getExtends();
		if (superClass != null && superClass.getType() != null) {
			if (!(superClass.getType() instanceof JvmGenericType)
					|| ((JvmGenericType) superClass.getType()).isInterface()) {
				error("Superclass must be a class", Xtend2Package.Literals.XTEND_CLASS__EXTENDS, CLASS_EXPECTED);
			}
		}
		for (int i = 0; i < xtendClass.getImplements().size(); ++i) {
			JvmTypeReference implementedType = xtendClass.getImplements().get(i);
			if (!(implementedType.getType() instanceof JvmGenericType)
					|| !((JvmGenericType) implementedType.getType()).isInterface()) {
				error("Implemented interface must be an interface", Xtend2Package.Literals.XTEND_CLASS__IMPLEMENTS, i,
						INTERFACE_EXPECTED);
			}
		}
	}

	@Check
	public void checkDuplicateAndOverridenFunctions(XtendClass xtendClass) {
		JvmParameterizedTypeReference typeReference = typesFactory.createJvmParameterizedTypeReference();
		typeReference.setType(xtendClass.getInferredJvmType());
		TypeArgumentContext typeArgumentContext = typeArgumentContextProvider.get(typeReference);
		for (int i = 0; i < xtendClass.getMembers().size(); ++i) {
			if (xtendClass.getMembers().get(i) instanceof XtendFunction) {
				XtendFunction function = (XtendFunction) xtendClass.getMembers().get(i);
				JvmOperation inferredJvmOperation = (JvmOperation) function.getInferredJvmMember();
				for (int j = i + 1; j < xtendClass.getMembers().size(); j++) {
					if (xtendClass.getMembers().get(j) instanceof XtendFunction) {
						XtendFunction otherFunction = (XtendFunction) xtendClass.getMembers().get(j);
						if (featureOverridesService.isOverridden(inferredJvmOperation,
								(JvmFeature) otherFunction.getInferredJvmMember(), typeArgumentContext, false)) {
							error("Duplicate method " + canonicalName(function), function,
									Xtend2Package.Literals.XTEND_FUNCTION__NAME, DUPLICATE_METHOD);
							error("Duplicate method " + canonicalName(otherFunction), otherFunction,
									Xtend2Package.Literals.XTEND_FUNCTION__NAME, DUPLICATE_METHOD);
						}
					}
				}
				checkFunctionOverride(function, typeArgumentContext);
			}
		}
	}

	protected void checkFunctionOverride(XtendFunction function, TypeArgumentContext typeArgumentContext) {
		JvmOperation inferredJvmOperation = (JvmOperation) function.getInferredJvmMember();
		boolean overriddenOperationFound = false;
		if (function.getDeclaringType().getExtends() != null) {
			JvmTypeReference returnType = identifiableTypeProvider.getType(inferredJvmOperation);
			JvmTypeReference returnTypeUpperBound = typeArgumentContext.getUpperBound(returnType, function);
			for (JvmFeature superFeature : featureOverridesService.getAllJvmFeatures(function.getDeclaringType()
					.getExtends())) {
				if (superFeature.getVisibility() != JvmVisibility.PRIVATE && superFeature instanceof JvmOperation) {
					JvmOperation superOperation = (JvmOperation) superFeature;
					if (featureOverridesService.isOverridden(inferredJvmOperation, superOperation, typeArgumentContext,
							false)) {
						overriddenOperationFound = true;
						if (!function.isOverride())
							error("Missing 'override'. Function overrides " + canonicalName(superOperation),
									function, Xtend2Package.Literals.XTEND_FUNCTION__NAME, MISSING_OVERRIDE);
						JvmTypeReference superReturnTypeUpperBound = typeArgumentContext.getUpperBound(superOperation
								.getReturnType(), function);
						if (!conformanceComputer.isConformant(superReturnTypeUpperBound, returnTypeUpperBound)) {
							error("The return type is incompatible with "
									+ canonicalName(superOperation.getReturnType()) + " "
									+ canonicalName(superOperation), function,
									Xtend2Package.Literals.XTEND_FUNCTION__RETURN_TYPE, INCOMPATIBLE_RETURN_TYPE);
						}
					}
				}
			}
		}
		if (!overriddenOperationFound && function.isOverride()) {
			error("Function does not override any operation", function,
					Xtend2Package.Literals.XTEND_FUNCTION__OVERRIDE, OBSOLETE_OVERRIDE);
		}
	}

	protected String canonicalName(JvmIdentifiableElement element) {
		return (element != null) ? notNull(element.getCanonicalName()) : null;
	}
}
