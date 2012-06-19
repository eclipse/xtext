/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.RawTypeHelper;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.util.XtypeReferenceVisitorWithParameter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class UnboundTypeParameterAwareRawTypeHelper extends RawTypeHelper {

	@Inject
	public UnboundTypeParameterAwareRawTypeHelper(UnboundTypeParameterAwareRawTypeImplementation typeImplementation, UnboundTypeParameterAwareRawTypeReferenceImplementation typeReferenceImplementation) {
		super(typeImplementation, typeReferenceImplementation);
	}
	
	public static class UnboundTypeParameterAwareRawTypeImplementation extends RawTypeImplementation implements XtypeReferenceVisitorWithParameter<Resource, List<JvmType>> {

		@Inject
		public UnboundTypeParameterAwareRawTypeImplementation(TypesFactory factory) {
			super(factory);
		}

		public List<JvmType> doVisitFunctionTypeReference(XFunctionTypeRef reference, Resource parameter) {
			return doVisitSpecializedTypeReference(reference, parameter);
		}

		public List<JvmType> doVisitComputedTypeReference(XComputedTypeReference reference, Resource parameter) {
			if (UnboundTypeParameters.isUnboundTypeParameter(reference)) {
				UnboundTypeParameter unbound = (UnboundTypeParameter) reference.getTypeProvider();
				return getRawTypesFromConstraints(unbound.getTypeParameter().getConstraints(), parameter);
			}
			return doVisitSpecializedTypeReference(reference, parameter);
		}
		
	}
	
	public static class UnboundTypeParameterAwareRawTypeReferenceImplementation extends RawTypeReferenceImplementation implements XtypeReferenceVisitorWithParameter<Resource, JvmTypeReference> {

		@Inject
		public UnboundTypeParameterAwareRawTypeReferenceImplementation(TypesFactory factory) {
			super(factory);
		}

		public JvmTypeReference doVisitFunctionTypeReference(XFunctionTypeRef reference, Resource parameter) {
			return doVisitSpecializedTypeReference(reference, parameter);
		}

		public JvmTypeReference doVisitComputedTypeReference(XComputedTypeReference reference, Resource parameter) {
			if (UnboundTypeParameters.isUnboundTypeParameter(reference)) {
				UnboundTypeParameter unbound = (UnboundTypeParameter) reference.getTypeProvider();
				return getRawTypeFromConstraints(unbound.getTypeParameter().getConstraints(), parameter);
			}
			return doVisitSpecializedTypeReference(reference, parameter);
		}
		
	}
}
