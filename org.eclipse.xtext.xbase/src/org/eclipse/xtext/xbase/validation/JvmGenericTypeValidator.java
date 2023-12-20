/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 * @author Sebastian Zarnekow - Author of the original Java code in XtendValidator extracted here.
 */
public class JvmGenericTypeValidator extends AbstractDeclarativeValidator {
	@Inject
	private IJvmModelAssociations associations;

	@Override
	public void register(EValidatorRegistrar registrar) {
		// library validator is not registered for a specific language
	}

	@Check
	public void interceptRoot(EObject o) {
		var contents = o.eResource().getContents();
		if (contents.get(0) != o)
			return;
		checkJvmGenericTypes(contents);
	}

	protected void checkJvmGenericTypes(List<? extends EObject> contents) {
		contents.stream()
				.filter(this::isAssociatedToSource)
				.filter(JvmGenericType.class::isInstance)
				.map(JvmGenericType.class::cast)
				.forEach(this::checkJvmGenericType);
	}

	private boolean isAssociatedToSource(EObject e) {
		return !associations.getSourceElements(e).isEmpty();
	}

	protected void checkJvmGenericType(JvmGenericType type) {
		handleExceptionDuringValidation(() -> checkSuperTypes(type));
		type.getDeclaredFields().forEach(field -> {
			if (isAssociatedToSource(field))
				handleExceptionDuringValidation(() -> checkField(field));
		});
		var members = type.getMembers();
		handleExceptionDuringValidation(() -> checkJvmExecutables(members));
		handleExceptionDuringValidation(() -> checkJvmGenericTypes(members));
	}

	protected void checkJvmExecutables(List<? extends JvmMember> contents) {
		contents.stream()
				.filter(this::isAssociatedToSource)
				.filter(JvmExecutable.class::isInstance)
				.map(JvmExecutable.class::cast)
				.forEach(this::checkJvmExecutable);
	}

	protected void checkSuperTypes(JvmGenericType type) {
		var primarySourceElement = associations.getPrimarySourceElement(type);
		if (primarySourceElement == null)
			return;
		if (hasCycleInHierarchy(type, new HashSet<>())) {
			error("The inheritance hierarchy of " + notNull(type.getSimpleName()) + " contains cycles",
					primarySourceElement,
					getFeatureForIssue(primarySourceElement), CYCLIC_INHERITANCE);
		}
		if (type.isInterface()) {
			var superTypes = type.getSuperTypes();
			for (int i = 0; i < superTypes.size(); ++i) {
				JvmTypeReference extendedType = superTypes.get(i);
				var associated = associations.getPrimarySourceElement(extendedType);
				var eContainingFeature = associated.eContainingFeature();
				if (!isInterface(extendedType.getType()) && !isAnnotation(extendedType.getType())) {
					error("Extended interface must be an interface",
						primarySourceElement,
						eContainingFeature, i, INTERFACE_EXPECTED);
				}
				checkWildcardSupertype(primarySourceElement, notNull(type.getSimpleName()),
						extendedType,
						eContainingFeature, i);
			}
		} else {
			var superTypes = type.getSuperTypes();
			var expectedInterfaceIndex = -1;
			for (int i = 0; i < superTypes.size(); ++i) {
				JvmTypeReference extendedType = superTypes.get(i);
				var associated = associations.getPrimarySourceElement(extendedType);
				if (associated == null)
					continue; // synthetic superclass (e.g., Object)
				var eContainingFeature = associated.eContainingFeature();
				// there's no direct way to tell whether the supertype is meant
				// to be an extended class or an implemented interface, so we
				// check whether the original source element's containing feature
				// is single or multiple, assuming that the source element allows
				// for a single extended class
				if (eContainingFeature.isMany()) { // assume to be expected as an interface
					expectedInterfaceIndex++;
					if (!isInterface(extendedType.getType()) && !isAnnotation(extendedType.getType())) {
						error("Implemented interface must be an interface",
							primarySourceElement,
							eContainingFeature, expectedInterfaceIndex, INTERFACE_EXPECTED);
					}
					checkWildcardSupertype(primarySourceElement, notNull(type.getSimpleName()),
							extendedType,
							eContainingFeature, expectedInterfaceIndex);
				} else { // assume to be expected as a class
					if (!(extendedType.getType() instanceof JvmGenericType)
							|| ((JvmGenericType) extendedType.getType()).isInterface()) {
						error("Superclass must be a class",
							primarySourceElement,
							eContainingFeature, CLASS_EXPECTED);
					} else {
						if (((JvmGenericType) extendedType.getType()).isFinal()) {
							error("Attempt to override final class",
								primarySourceElement,
								eContainingFeature, OVERRIDDEN_FINAL);
						}
						checkWildcardSupertype(primarySourceElement, notNull(type.getSimpleName()),
								extendedType,
								eContainingFeature, INSIGNIFICANT_INDEX);
					}
				}
			}
		}
	}

	protected void checkField(JvmField field) {
		var declaredFieldType = field.getType();
		if (isPrimitiveVoid(declaredFieldType)) {
			var associated = associations.getPrimarySourceElement(declaredFieldType);
			error("Primitive void cannot be a dependency.",
					associated, null, INVALID_USE_OF_TYPE);
		}
	}

	protected void checkJvmExecutable(JvmExecutable executable) {
		var parameters = executable.getParameters();
		var sourceExecutable = associations.getPrimarySourceElement(executable);
		for (int i = 0; i < parameters.size(); ++i) {
			var parameter = parameters.get(i);
			var sourceParameter = associations.getPrimarySourceElement(parameter);
			if (sourceParameter == null)
				continue; // synthetic parameter
			var leftParameterName = parameter.getName();
			var sourceParametersFeature = sourceParameter.eContainingFeature();
			for (int j = i + 1; j < parameters.size(); ++j) {
				if (equal(leftParameterName, parameters.get(j).getName())) {
					error("Duplicate parameter " + leftParameterName,
						sourceExecutable, sourceParametersFeature, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName,
						sourceExecutable, sourceParametersFeature, j, DUPLICATE_PARAMETER_NAME);
				}
			}
			var parameterType = parameter.getParameterType();
			var sourceParameterType = associations.getPrimarySourceElement(parameterType);
			if (sourceParameterType == null)
				continue; // synthetic type (e.g., computed/inferred)
			if (isPrimitiveVoid(parameterType)) {
				error("void is an invalid type for the parameter " + parameter.getName() + " of the method "
						+ executable.getSimpleName(), sourceParameterType, null, INVALID_USE_OF_TYPE);
			}
		}
	}

	/**
	 * Copied from {@link XbaseValidator#isPrimitiveVoid(JvmTypeReference)}
	 */
	protected boolean isPrimitiveVoid(JvmTypeReference typeReference) {
		return typeReference != null && typeReference.getType() != null && !typeReference.getType().eIsProxy() && typeReference.getType() instanceof JvmVoid;
	}

	private boolean hasCycleInHierarchy(JvmGenericType type, Set<JvmGenericType> processedSuperTypes) {
		JvmDeclaredType container = type;
		do {
			if (processedSuperTypes.contains(container))
				return true;
			container = container.getDeclaringType();
		} while (container != null);
		processedSuperTypes.add(type);
		for (JvmTypeReference superTypeRef : type.getSuperTypes()) {
			if (superTypeRef.getType() instanceof JvmGenericType) {
				if (hasCycleInHierarchy((JvmGenericType) superTypeRef.getType(), processedSuperTypes))
					return true;
			}
		}
		processedSuperTypes.remove(type);
		return false;
	}

	protected boolean isInterface(JvmType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}

	protected boolean isAnnotation(JvmType jvmType) {
		return jvmType instanceof JvmAnnotationType;
	}

	protected void checkWildcardSupertype(EObject sourceElement,
			String name,
			JvmTypeReference superTypeReference,
			EStructuralFeature feature, int index) { 
		if(isInvalidWildcard(superTypeReference)) 
			error("The type "
					+ name
					+ " cannot extend or implement "
					+ superTypeReference.getIdentifier() 
					+ ". A supertype may not specify any wildcard",
				sourceElement,
				feature,
				index,
				WILDCARD_IN_SUPERTYPE);
	}

	protected boolean isInvalidWildcard(JvmTypeReference typeRef) {
		if (typeRef instanceof JvmWildcardTypeReference)
			return true;
		else if (typeRef instanceof JvmParameterizedTypeReference) {
			for(JvmTypeReference typeArgument: ((JvmParameterizedTypeReference) typeRef).getArguments()) {
				if(typeArgument instanceof JvmWildcardTypeReference) 
					return true;
			}
		} else if (typeRef instanceof JvmSpecializedTypeReference) {
			return isInvalidWildcard(((JvmSpecializedTypeReference) typeRef).getEquivalent());
		}
		return false;
	}

	/**
	 * The default implementation returns the feature "name".
	 */
	protected EStructuralFeature getFeatureForIssue(EObject object) {
		return object.eClass().getEStructuralFeature("name");
	}

	/**
	 * When the {@link AbstractDeclarativeValidator} executes {@link Check} methods,
	 * it swallows some runtime exceptions so that other methods can be executed.
	 * In this class we only have a {@link Check} method that calls other methods, so for th
	 * other methods we simulate the same behavior.
	 */
	protected void handleExceptionDuringValidation(Runnable code) {
		try {
			code.run();
		} catch (Throwable e) {
			handleExceptionDuringValidation(e);
		}
	}
}
