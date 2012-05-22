/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitor;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
public class TypeReferenceAnalyzer {

	public boolean isReferencedBy(JvmType type, JvmTypeReference reference) {
		return isReferencedBy(type, reference, true);
	}
	
	public boolean isReferencedBy(JvmType type, JvmTypeReference reference, final boolean resolveUnbound) {
		ITypeReferenceVisitorWithParameter<JvmType,Boolean> visitor = new AbstractXtypeReferenceVisitorWithParameter<JvmType, Boolean>() {
			@Override
			public Boolean doVisitTypeReference(JvmTypeReference reference, JvmType type) {
				return Boolean.FALSE;
			}
			@Override
			protected Boolean handleNullReference(JvmType type) {
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitFunctionTypeReference(XFunctionTypeRef reference, JvmType type) {
				for(JvmTypeReference paramType: reference.getParamTypes()) {
					if (visit(paramType, type))
						return Boolean.TRUE;
				}
				if (visit(reference.getReturnType(), type))
					return Boolean.TRUE;
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitCompoundTypeReference(JvmCompoundTypeReference reference, JvmType type) {
				for(JvmTypeReference component: reference.getReferences()) {
					if (visit(component, type))
						return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitComputedTypeReference(XComputedTypeReference reference, JvmType type) {
				if (type instanceof JvmTypeParameter) {
					if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
						UnboundTypeParameter unboundTypeParameter = (UnboundTypeParameter) reference.getTypeProvider();
						if (unboundTypeParameter.getTypeParameter() == type) {
							return Boolean.TRUE;
						}
						if (!resolveUnbound)
							return Boolean.FALSE;
					}
				}
				return super.doVisitComputedTypeReference(reference, type);
			}
			@Override
			public Boolean doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, JvmType type) {
				if (type instanceof JvmArrayType) {
					if (type == reference.getType()) {
						return Boolean.TRUE;
					}
				}
				if (visit(reference.getComponentType(), type))
					return Boolean.TRUE;
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference, JvmType type) {
				for(JvmTypeConstraint constraint: reference.getConstraints()) {
					if (visit(constraint.getTypeReference(), type))
						return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, JvmType type) {
				if (type == reference.getType())
					return Boolean.TRUE;
				for(JvmTypeReference argument: reference.getArguments()) {
					if (visit(argument, type))
						return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
		};
		boolean result = visitor.visit(reference, type);
		return result;
	}
	
	public boolean isReferenceToTypeParameter(JvmTypeReference reference, final boolean resolveUnbound) {
		ITypeReferenceVisitor<Boolean> visitor = new AbstractXtypeReferenceVisitor<Boolean>() {
			@Override
			public Boolean doVisitTypeReference(JvmTypeReference reference) {
				return Boolean.FALSE;
			}
			@Override
			protected Boolean handleNullReference() {
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitFunctionTypeReference(XFunctionTypeRef reference) {
				for(JvmTypeReference paramType: reference.getParamTypes()) {
					if (visit(paramType))
						return Boolean.TRUE;
				}
				if (visit(reference.getReturnType()))
					return Boolean.TRUE;
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
				for(JvmTypeReference component: reference.getReferences()) {
					if (visit(component))
						return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitComputedTypeReference(XComputedTypeReference reference) {
				if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
					if (!resolveUnbound) {
						return Boolean.TRUE;
					}
				}
				return super.doVisitComputedTypeReference(reference);
			}
			@Override
			public Boolean doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
				if (visit(reference.getComponentType()))
					return Boolean.TRUE;
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
				for(JvmTypeConstraint constraint: reference.getConstraints()) {
					if (visit(constraint.getTypeReference()))
						return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
				if (reference.getType() instanceof JvmTypeParameter)
					return Boolean.TRUE;
				for(JvmTypeReference argument: reference.getArguments()) {
					if (visit(argument))
						return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
		};
		boolean result = visitor.visit(reference);
		return result;
	}
	
}
