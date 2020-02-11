/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypeReferencesValidator extends AbstractDeclarativeValidator {
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private IJvmModelAssociations jvmModelAssociations;
	
	@Inject
	private ProxyAwareUIStrings proxyAwareUIStrings;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(TypesPackage.eINSTANCE, XtypePackage.eINSTANCE);
	}
	
	@Check
	public void checkTypeArgumentsNotPrimitive(JvmParameterizedTypeReference typeRef) {
		EList<JvmTypeReference> arguments = typeRef.getArguments();
		for (int i=0;i<arguments.size();i++) {
			JvmTypeReference jvmTypeReference = arguments.get(i);
			checkNotPrimitive(jvmTypeReference);
		}
	}
	
	@Check
	public void checkNotMultipleBounds(JvmWildcardTypeReference typeRef) {
		List<JvmTypeConstraint> constraints = typeRef.getConstraints();
		if (constraints.size() >= 2) {
			int upperBounds = 0;
			int lowerBounds = 0;
			for(int i = 0; i < constraints.size(); i++) {
				JvmTypeConstraint constraint = constraints.get(i);
				if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND) {
					upperBounds++;
					if (upperBounds > 1) {
						error("Invalid type constraint. Cannot use multiple upper bounds in wildcards.", 
								typeRef, TypesPackage.Literals.JVM_CONSTRAINT_OWNER__CONSTRAINTS, i, IssueCodes.INVALID_WILDCARD_CONSTRAINTS);
						return;
					}
				} else {
					lowerBounds++;
					if (lowerBounds > 1) {
						error("Invalid type constraint. Cannot use multiple lower bounds in wildcards.", 
								typeRef, TypesPackage.Literals.JVM_CONSTRAINT_OWNER__CONSTRAINTS, i, IssueCodes.INVALID_WILDCARD_CONSTRAINTS);
					}
				}
			}
		}
	}
	
	@Check
	public void checkTypeArgsAgainstTypeParameters(JvmParameterizedTypeReference typeRef) {
		JvmType type = typeRef.getType();
		if(type instanceof JvmGenericType && !type.eIsProxy()) {
			int numTypeParameters = ((JvmGenericType) type).getTypeParameters().size();
			if(typeRef.getArguments().size() > 0) {
				if (numTypeParameters == 0) {
					errorTypeIsNotGeneric(type, typeRef);
				} else if(numTypeParameters != typeRef.getArguments().size()) {
					StringBuilder message = new StringBuilder(64);
					message.append("Incorrect number of arguments for type ");
					message = proxyAwareUIStrings.appendTypeSignature(type, message);
					message.append("; it cannot be parameterized with arguments ");
					message = proxyAwareUIStrings.appendTypeArguments(typeRef, message);
					if (message != null) {
						error(message.toString(),
								IssueCodes.INVALID_NUMBER_OF_TYPE_ARGUMENTS, typeRef);
					}
				}
			} else if(numTypeParameters > 0) {
				warnRawType(type, typeRef);
			}
		} else if (type != null && !type.eIsProxy() && !typeRef.getArguments().isEmpty()) {
			errorTypeIsNotGeneric(type, typeRef);
		}
	}

	protected void warnRawType(JvmType type, JvmParameterizedTypeReference typeRef) {
		if (typeRef.eContainer() instanceof XInstanceOfExpression) {
			return;
		}
		StringBuilder message = new StringBuilder(64);
		message.append(type.getSimpleName());
		message.append(" is a raw type. References to generic type ");
		message = proxyAwareUIStrings.appendTypeSignature(type, message);
		message.append(" should be parameterized");
		warning(message.toString(), IssueCodes.RAW_TYPE, typeRef);
	}

	protected void errorTypeIsNotGeneric(JvmType type, JvmParameterizedTypeReference typeRef) {
		StringBuilder message = new StringBuilder(64);
		message.append("The type ");
		message = proxyAwareUIStrings.appendTypeSignature(type, message);
		message.append(" is not generic; it cannot be parameterized with arguments ");
		message = proxyAwareUIStrings.appendTypeArguments(typeRef, message);
		if (message != null) {
			error(message.toString(), IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE, typeRef);
		}
	}
	
	protected void warning(String message, String issueCode, JvmParameterizedTypeReference typeReference) {
		EObject rootContainer = EcoreUtil.getRootContainer(typeReference);
		Resource resource = rootContainer.eResource();
		if (resource.getContents().get(0) == rootContainer) {
			super.warning(message, typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, issueCode);
		} else {
			EObject container = typeReference;
			EObject sourceElement = jvmModelAssociations.getPrimarySourceElement(container);
			container = container.eContainer();
			while(sourceElement == null && container != null) {
				sourceElement = jvmModelAssociations.getPrimarySourceElement(container);
				container = container.eContainer();
			}
			if (sourceElement != null) {
				warning(message, sourceElement, sourceElement.eClass().getEStructuralFeature("name"), -1, issueCode);
			} else {
				super.warning(message, typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, issueCode);
			}
		}
	}
	
	protected void error(String message, String issueCode, JvmParameterizedTypeReference typeReference) {
		EObject rootContainer = EcoreUtil.getRootContainer(typeReference);
		Resource resource = rootContainer.eResource();
		if (resource.getContents().get(0) == rootContainer) {
			super.error(message, typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, issueCode);
		} else {
			EObject container = typeReference;
			EObject sourceElement = jvmModelAssociations.getPrimarySourceElement(container);
			container = container.eContainer();
			while(sourceElement == null && container != null) {
				sourceElement = jvmModelAssociations.getPrimarySourceElement(container);
				container = container.eContainer();
			}
			if (sourceElement != null) {
				error(message, sourceElement, sourceElement.eClass().getEStructuralFeature("name"), -1, issueCode);
			} else {
				super.error(message, typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, issueCode);
			}
		}
	}
	
	@Check
	public void checkTypeArgumentsNotPrimitive(JvmTypeConstraint typeRef) {
		checkNotPrimitive(typeRef.getTypeReference());
	}
	
	@Check
	public void checkTypesAreDisjoint(JvmSynonymTypeReference typeRef) {
		List<JvmTypeReference> references = typeRef.getReferences();
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, typeRef);
		CompoundTypeReference lightweightTypeReference = (CompoundTypeReference) owner.toLightweightTypeReference(typeRef);
		List<LightweightTypeReference> components = lightweightTypeReference.getMultiTypeComponents();
		for(int left = 0; left < components.size(); left++) {
			for(int right = 0; right < components.size(); right++) {
				if (left != right) {
					LightweightTypeReference leftRef = components.get(left);
					LightweightTypeReference rightRef = components.get(right);
					if (leftRef.isAssignableFrom(rightRef)) {
						if (leftRef.getIdentifier().equals(rightRef.getIdentifier())) {
							if (right > left) {
								StringBuilder message = new StringBuilder("The caught ");
								message.append(rightRef.getHumanReadableName());
								message.append("is redundant");
								error(message.toString(), references.get(right), null, IssueCodes.INVALID_MULTITYPE_PART);
							}
						} else {
							StringBuilder message = new StringBuilder("The ");
							message.append(rightRef.getHumanReadableName());
							message.append(" is already covered by the caught ");
							message.append(leftRef.getHumanReadableName());
							error(message.toString(), references.get(right), null, IssueCodes.INVALID_MULTITYPE_PART);
						}
					}
				}
			}
		}
	}
	
	protected void checkNotPrimitive(JvmTypeReference jvmTypeReference) {
		if (primitives.isPrimitive(jvmTypeReference)) {
			error("The primitive '"+jvmTypeReference.getQualifiedName('.')+"' cannot be a type argument", jvmTypeReference, null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkJvmFormalParameterNotPrimitiveVoid(JvmFormalParameter param) {
		if (typeReferences.is(param.getParameterType(), Void.TYPE)) {
			error("The primitive 'void' cannot be the type of a parameter", param.getParameterType(), null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkFunctionTypeArgsNonVoid(XFunctionTypeRef typeRef) {
		for (JvmTypeReference paramType : typeRef.getParamTypes()) {
			JvmType type = paramType.getType();
			if (type instanceof JvmVoid && !type.eIsProxy()) {
				error("The primitive 'void' cannot be the type of a function parameter. ", 
						paramType, null, -1, INVALID_USE_OF_TYPE);
			}
		}
	}
	
}
