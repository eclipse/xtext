/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * Xbase Validator that does use the scope provider or the type argument context. 
 * It basically disables or replaces all call-outs to the scope and some
 * validations that will be superseded by immediate error annotations during type resolution.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseJavaValidator2 extends XbaseJavaValidator {
	
	@Inject
	private CommonTypeComputationServices services;
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	@Override
	@Check
	public void checkImplicitReturn(XExpression expr) {
		// disabled for now
	}
	
	@Override
	protected void checkDeclaredVariableName(EObject nameDeclarator, EObject attributeHolder, EAttribute attr) {
		if (nameDeclarator.eContainer() == null)
			return;
		if (attr.getEContainingClass().isInstance(attributeHolder)) {
			String name = (String) attributeHolder.eGet(attr);
			// shadowing 'it' is allowed
			if (name == null || equal(name, IFeatureNames.IT.toString()))
				return;
			if (getDisallowedVariableNames().contains(name)) {
				error("'" + name + "' is not a valid name.", attributeHolder, attr, -1,
						IssueCodes.VARIABLE_NAME_SHADOWING);
				return;
			}
			// temporarily disabled
//			int idx = 0;
//			if (nameDeclarator.eContainer() instanceof XBlockExpression) {
//				idx = ((XBlockExpression) nameDeclarator.eContainer()).getExpressions().indexOf(nameDeclarator);
//			}
//			IScope scope = getScopeProvider().createSimpleFeatureCallScope(nameDeclarator.eContainer(),
//					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, nameDeclarator.eResource(), true, idx);
//			Iterable<IEObjectDescription> elements = scope.getElements(QualifiedName.create(name));
//			for (IEObjectDescription desc : elements) {
//				if (desc.getEObjectOrProxy() != nameDeclarator && !(desc.getEObjectOrProxy() instanceof JvmFeature)) {
//					error("Duplicate variable name '" + name + "'", attributeHolder, attr,
//							IssueCodes.VARIABLE_NAME_SHADOWING);
//				}
//			}
		}
	}
	
	@Override
	protected void validateType(XExpression expression,
			Procedures.Procedure2<JvmTypeReference, JvmTypeReference> messageProducer) {
		JvmTypeReference expectedType = getTypeProvider().getExpectedType(expression);
		if (expectedType == null || expectedType.getType() == null)
			return;
		JvmTypeReference actualType = getTypeProvider().getType(expression);
		if (actualType == null || actualType.getType() == null)
			return;
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, expression.eResource().getResourceSet());
		OwnedConverter converter = new OwnedConverter(owner);
		boolean valid = converter.toLightweightReference(expectedType).isAssignableFrom(converter.toLightweightReference(actualType));
		if (!valid) {
			messageProducer.apply(expectedType, actualType);
		}
	}
	
	@Override
	protected void checkCast(JvmTypeReference toType, JvmTypeReference fromType) {
		if (toType != null && fromType != null && fromType.getType() instanceof JvmDeclaredType) {
			JvmDeclaredType targetType = (JvmDeclaredType) fromType.getType();
			if (targetType.isFinal()) {
				ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, targetType.eResource().getResourceSet());
				OwnedConverter converter = new OwnedConverter(owner);
				LightweightTypeReference lightweightToType = converter.toLightweightReference(toType);
				if (!lightweightToType.isAssignableFrom(converter.toLightweightReference(fromType))) {
					error("Cannot cast element of sealed type " + getNameOfTypes(fromType) + " to "
							+ canonicalName(toType), toType, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
							INVALID_CAST);
				}
			} else {
				JvmType type = toType.getType();
				if (type instanceof JvmGenericType && !((JvmGenericType) type).isInterface()) {
					ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, targetType.eResource().getResourceSet());
					OwnedConverter converter = new OwnedConverter(owner);
					LightweightTypeReference lightweightFromType = converter.toLightweightReference(fromType);
					LightweightTypeReference lightweightToType = converter.toLightweightReference(toType);
					if (!lightweightFromType.isAssignableFrom(lightweightToType) && !lightweightToType.isAssignableFrom(lightweightFromType)) {
						error("type mismatch: cannot convert from " + getNameOfTypes(fromType) + " to "
								+ canonicalName(toType), toType, null,
								ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_CAST);
					}
				}
			}
		}
	}
	
	@Override
	@Check
	public void checkTypes(XForLoopExpression obj) {
		try {
			JvmTypeReference actualType = getTypeProvider().getType(obj.getForExpression());
			if (actualType == null || actualType.getType() == null)
				return;

			JvmType iterable = getTypeRefs().findDeclaredType(Iterable.class, obj);
			if (iterable == null) {
				error("foreach needs '"+Iterable.class.getCanonicalName()+"' on the classpath.", obj, null, -1, MISSING_TYPE);
				return;
			}
			JvmTypeReference argument = getTypeRefs().wildCard();
			JvmTypeReference expected = obj.getDeclaredParam().getParameterType();
			if (expected != null) {
				if (getTypeRefs().is(expected, Void.TYPE)) {
					// see #checkTypeReferenceIsNotVoid
					return;
				}
				argument = getTypeRefs().wildCardExtends(EcoreUtil2.cloneIfContained(getPrimitives().asWrapperTypeIfPrimitive(expected)));
			}
			JvmTypeReference expectedType = getTypeRefs().createTypeRef(iterable, argument);
			
			ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, obj.eResource().getResourceSet());
			OwnedConverter converter = new OwnedConverter(owner);
			LightweightTypeReference lightweightExpectedType = converter.toLightweightReference(expectedType);
			LightweightTypeReference lightweightActualType = converter.toLightweightReference(actualType);
			if (!lightweightExpectedType.isAssignableFrom(lightweightActualType))
				error("Incompatible types. Expected " + getNameOfTypes(expectedType) + " but was "
						+ canonicalName(actualType), obj.getForExpression(), null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
			else if (lightweightActualType.isRawType()) {
				// rawType - check expectation for Object
				if (obj.getDeclaredParam().getParameterType() != null) {
					if (!getTypeRefs().is(obj.getDeclaredParam().getParameterType(), Object.class)) {
						error("Incompatible types. Expected " + getNameOfTypes(expectedType) + " but was "
								+ canonicalName(actualType), obj.getForExpression(), null,
								ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
					}
				}
			}
		} catch (WrappedException e) {
			throw new WrappedException("XbaseJavaValidator#checkTypes for " + obj + " caused: "
					+ e.getCause().getMessage(), e);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected org.eclipse.xtext.xbase.scoping.XbaseScopeProvider getScopeProvider() {
		throw new UnsupportedOperationException();
	}
}