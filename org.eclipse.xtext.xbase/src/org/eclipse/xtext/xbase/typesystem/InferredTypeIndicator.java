/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * This is a {@link IJvmTypeReferenceProvider type reference provider} that
 * can be used to describe an infered type reference during the model inference.
 * 
 * Clients will usually use {@link #isInferred(JvmTypeReference)} and
 * {@link #resolveTo(JvmTypeReference, JvmTypeReference)}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InferredTypeIndicator implements IJvmTypeReferenceProvider {

	private boolean resolved = false;
	private final XExpression expression;

	public InferredTypeIndicator(XExpression expression) {
		this.expression = expression;
	}
	
	public InferredTypeIndicator() {
		this(null);
	}

	public static boolean isInferred(JvmTypeReference typeReference) {
		if (typeReference instanceof XComputedTypeReference) {
			IJvmTypeReferenceProvider typeProvider = ((XComputedTypeReference) typeReference).getTypeProvider();
			if (typeProvider instanceof InferredTypeIndicator && !((InferredTypeIndicator)typeProvider).resolved) {
				return true;
			}
		}
		return false;
	}
	
	public static void resolveTo(JvmTypeReference inferred, JvmTypeReference resolved) {
		if (isInferred(inferred)) {
			XComputedTypeReference casted = (XComputedTypeReference) inferred;
			casted.setEquivalent(resolved);
			((InferredTypeIndicator)casted.getTypeProvider()).resolved = true;
		} else {
			throw new IllegalStateException("Cannot resolve a reference that is not inferred");
		}
	}
	
	@Override
	public JvmTypeReference getTypeReference(/* @NonNull */ XComputedTypeReferenceImplCustom context) {
		Resource resource = context.eResource();
		IResolvedTypes resolvedTypes = null;
		if (resource instanceof XtextResource) {
			IBatchTypeResolver typeResolver = ((XtextResource) resource).getResourceServiceProvider().get(IBatchTypeResolver.class);
			if (typeResolver == null) {
				throw new IllegalStateException("typeResolver may not be null");
			}
			resolvedTypes = typeResolver.resolveTypes(context);
		}
		if (context.eIsSet(TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT)) {
			return context.getEquivalent();
		}
		if (expression != null && resolvedTypes != null) {
			LightweightTypeReference expressionType = resolvedTypes.getActualType(expression);
			if (expressionType != null) {
				JvmTypeReference result = expressionType.toJavaCompliantTypeReference();
				return result;
			}
		}
		throw new IllegalStateException("equivalent could not be computed");
	}
	
	/* @Nullable */
	public XExpression getExpression() {
		return expression;
	}
	
	@Override
	public String toString() {
		return String.format("InferredTypeIndicator[resolved=%s, expression=%s]", resolved, expression == null ? "null" : expression.eClass().getName());
	}
	
}
