/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.typesystem;

import java.util.List;

import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.typesystem.computation.EnumLiteralImporter;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseWithAnnotationsTypeComputer extends XbaseTypeComputer {

	@Override
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if (expression instanceof XAnnotation) {
			_computeTypes((XAnnotation)expression, state);
		} else {
			super.computeTypes(expression, state);
		}
	}
	
	protected void _computeTypes(XAnnotation object, ITypeComputationState state) {
		JvmType annotationType = object.getAnnotationType();
		if (annotationType != null && !annotationType.eIsProxy()) {
			if (annotationType instanceof JvmAnnotationType) {
				XExpression expression = object.getValue();
				if (expression != null) {
					Iterable<JvmFeature> iterable = ((JvmAnnotationType) annotationType).findAllFeaturesByName("value");
					JvmFeature value = Iterables.getOnlyElement(iterable, null);
					if (value != null) {
						if (value instanceof JvmOperation) {
							computeTypes(object, (JvmOperation) value, expression, state);
						} else {
							throw new IllegalStateException("Unexpected feature type " + value);
						}
					} else {
						state.addDiagnostic(new EObjectDiagnosticImpl(
								Severity.ERROR, 
								IssueCodes.ANNOTATIONS_NO_VALUE_ATTRIBUTE, 
								"The attribute value is undefined for the annotation type " + annotationType.getSimpleName(), 
								object, 
								XAnnotationsPackage.Literals.XANNOTATION__VALUE, 
								-1, null));
						state.withNonVoidExpectation().computeTypes(expression);
					}
				} else {
					List<XAnnotationElementValuePair> valuePairs = object.getElementValuePairs();
					for(XAnnotationElementValuePair pair: valuePairs) {
						computeTypes(object, pair.getElement(), pair.getValue(), state);
					}
				}
			} else {
				state.addDiagnostic(new EObjectDiagnosticImpl(
						Severity.ERROR, 
						IssueCodes.INCOMPATIBLE_TYPES, 
						String.format("Type mismatch: cannot convert from %s to Annotation", annotationType.getSimpleName()), 
						object, 
						XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, 
						-1, null));
				computeChildTypesForUnknownAnnotation(object, state);	
			}
			state.acceptActualType(new ParameterizedTypeReference(state.getReferenceOwner(), annotationType));
		} else {
			computeChildTypesForUnknownAnnotation(object, state);
		}
	}

	protected void computeChildTypesForUnknownAnnotation(XAnnotation object, ITypeComputationState state) {
		XExpression expression = object.getValue();
		if (expression != null)
			state.withNonVoidExpectation().computeTypes(expression);
		else {
			List<XAnnotationElementValuePair> valuePairs = object.getElementValuePairs();
			for(XAnnotationElementValuePair pair: valuePairs) {
				computeTypes(object, pair.getElement(), pair.getValue(), state);
			}
		}
	}

	/**
	 * @param annotation passed into computeTypes to mimic the same signature as in super types. 
	 */
	protected void computeTypes(XAnnotation annotation, /* @Nullable */ JvmOperation operation, XExpression value,
			ITypeComputationState state) {
		LightweightTypeReference expectation = operation == null || operation.eIsProxy() ? null : state.getConverter().toLightweightReference(operation.getReturnType());
		if (expectation != null && expectation.isArray()) {
			LightweightTypeReference componentType = expectation.getComponentType();
			if (componentType == null) {
				throw new IllegalStateException("Array without component type: " + expectation.getIdentifier());
			}
			LightweightTypeReference actualExpectation =  (value instanceof XListLiteral)
					? expectation
					: componentType;
			ITypeComputationState expectationState = addEnumImportsIfNecessary(state, actualExpectation, componentType.getType());
			ITypeComputationResult result = expectationState.computeTypes(value);
			LightweightTypeReference resultType = result.getActualExpressionType();
			if (resultType != null && !actualExpectation.isAssignableFrom(resultType)) {
				if (value instanceof XListLiteral) {
					// our children are incompatible so let's mark the array itself as compatible.
					state.refineExpectedType(value, resultType);
				} else {
					CompoundTypeReference bothExpectations = new CompoundTypeReference(state.getReferenceOwner(), true);
					bothExpectations.addComponent(componentType);
					bothExpectations.addComponent(expectation);
					state.refineExpectedType(value, bothExpectations);
				}
			}
		} else if (expectation == null) {
			state.withNonVoidExpectation().computeTypes(value);
		} else {
			ITypeComputationState expectationState = addEnumImportsIfNecessary(state, expectation, expectation.getType());
			ITypeComputationResult valueResult = expectationState.computeTypes(value);
			LightweightTypeReference valueResultType = valueResult.getActualExpressionType();
			if (valueResultType != null && !expectation.isAssignableFrom(valueResultType)) {
				if (value instanceof XListLiteral) {
					ArrayTypeReference array = valueResultType.tryConvertToArray();
					if (array != null) {
						LightweightTypeReference primitiveComponentType = array.getComponentType().getPrimitiveIfWrapperType();
						state.addDiagnostic(new EObjectDiagnosticImpl(
								Severity.ERROR, 
								IssueCodes.INCOMPATIBLE_TYPES, 
								"Type mismatch: cannot convert from " + primitiveComponentType + "[] to " + expectation.getHumanReadableName(), 
								value, 
								null, 
								-1, null));
						state.refineExpectedType(value, new ArrayTypeReference(array.getOwner(), primitiveComponentType));
					}
				}
			}
		}
	}

	private ITypeComputationState addEnumImportsIfNecessary(ITypeComputationState state, LightweightTypeReference expectedType, JvmType enumTypeCandidate) {
		ITypeComputationState expectationState = state.withExpectation(expectedType);
		if (enumTypeCandidate != null && enumTypeCandidate.eClass() == TypesPackage.Literals.JVM_ENUMERATION_TYPE) {
			expectationState.addImports(new EnumLiteralImporter((JvmDeclaredType) enumTypeCandidate));
		}
		return expectationState;
	}

}
