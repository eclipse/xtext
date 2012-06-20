/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitor;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO move this one to tests if everything worked out as expected
 */
public class RootResolvedTypes extends ResolvedTypes {

	protected RootResolvedTypes(DefaultReentrantTypeResolver resolver) {
		super(resolver);
	}

	@Override
	protected Multimap<XExpression, TypeData> createExpressionTypesMap() {
		final Multimap<XExpression, TypeData> result = super.createExpressionTypesMap();
		return new ForwardingMultimap<XExpression, TypeData>() {
			
			// TODO guard asserter - should only be active in tests
			ITypeReferenceVisitor<Boolean> asserter = new AbstractXtypeReferenceVisitor<Boolean>() {
				@Override
				public Boolean doVisitTypeReference(LightweightTypeReference reference) {
					return Boolean.FALSE;
				}
				@Override
				protected Boolean handleNullReference() {
					return Boolean.FALSE;
				}
				@Override
				public Boolean doVisitFunctionTypeReference(XFunctionTypeRef reference) {
					for(LightweightTypeReference paramType: reference.getParamTypes()) {
						if (visit(paramType))
							return Boolean.TRUE;
					}
					if (visit(reference.getReturnType()))
						return Boolean.TRUE;
					return Boolean.FALSE;
				}
				@Override
				public Boolean doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
					for(LightweightTypeReference component: reference.getReferences()) {
						if (visit(component))
							return Boolean.TRUE;
					}
					return Boolean.FALSE;
				}
				@Override
				public Boolean doVisitComputedTypeReference(XComputedTypeReference reference) {
					if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
						BaseUnboundTypeParameter unboundTypeParameter = (BaseUnboundTypeParameter) reference.getTypeProvider();
						if (!(unboundTypeParameter instanceof RootUnboundTypeParameter)) {
							throw new IllegalStateException("reference points to a StackedUnboundParameter");
						}
						getUnboundTypeParameter(unboundTypeParameter.getHandle());
						for(Object other: unboundTypeParameter.getEquallyBoundHandles())
							getUnboundTypeParameter(other);
					}
					return Boolean.FALSE;
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
					for(LightweightTypeReference argument: reference.getArguments()) {
						if (visit(argument))
							return Boolean.TRUE;
					}
					return Boolean.FALSE;
				}
			};
			
			@Override
			protected Multimap<XExpression, TypeData> delegate() {
				return result;
			}
			
			@Override
			public boolean put(XExpression key, TypeData value) {
				asserter.visit(value.getActualType());
				if (value.getExpectation() != null)
					asserter.visit(value.getExpectation().getExpectedType());
				return super.put(key, value);
			}
			
			@Override
			public boolean putAll(Multimap<? extends XExpression, ? extends TypeData> multimap) {
				for(TypeData typeData: multimap.values()) {
					asserter.visit(typeData.getActualType());
					if (typeData.getExpectation() != null)
						asserter.visit(typeData.getExpectation().getExpectedType());
				}
				return super.putAll(multimap);
			}
			
			@Override
			public boolean putAll(XExpression key, Iterable<? extends TypeData> values) {
				for(TypeData typeData: values) {
					asserter.visit(typeData.getActualType());
					if (typeData.getExpectation() != null)
						asserter.visit(typeData.getExpectation().getExpectedType());
				}
				return super.putAll(key, values);
			}
		};
	}
	
	@Override
	@NonNull
	protected RootUnboundTypeParameter getUnboundTypeParameter(@NonNull Object handle) {
		return (RootUnboundTypeParameter) super.getUnboundTypeParameter(handle);
	}

}
