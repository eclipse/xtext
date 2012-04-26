/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeParameterSubstitutor extends AbstractTypeReferenceVisitor.InheritanceAware<JvmTypeReference> {
		
		private final Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping;
		private final TypesFactory typesFactory;

		public TypeParameterSubstitutor(Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping, TypesFactory typesFactory) {
			this.typeParameterMapping = typeParameterMapping;
			this.typesFactory = typesFactory;
		}
		
		@Override
		protected JvmTypeReference handleNullReference() {
			return TypesFactory.eINSTANCE.createJvmUnknownTypeReference();
		}
		@Override
		public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
			JvmType type = reference.getType();
			if (type instanceof JvmTypeParameter) {
				JvmTypeReference mappedReference = typeParameterMapping.get(type);
				if (mappedReference != null && mappedReference != reference) {
					return visit(mappedReference);
				}
			}
//				
//				if (isRawTypeContext() || boundParameters.containsKey(type)) {
//					JvmTypeReference bound = getBoundArgument((JvmTypeParameter) type);
//					if (isRecursive(type, bound)) {
//						// TODO find the reason for this recursion
////						System.out.println("Recursion2");
//						return bound;
//					}
//					
//					return visit(bound, replaceWildcards);
//				}
			JvmParameterizedTypeReference result = typesFactory.createJvmParameterizedTypeReference();
			result.setType(type);
//			if (!isRawTypeContext()) {
				for(JvmTypeReference argument: reference.getArguments()) {
					JvmTypeReference copiedArgument = visit(argument);
//					if (copiedArgument == null) {
//						copy = typeReferences.getTypeForName(Object.class, type);
//					}
					result.getArguments().add(copiedArgument);
				}
//			}
			return result;
		}
		
//		protected boolean isRecursive(final JvmType type, JvmTypeReference reference) {
//			boolean result = new AbstractTypeReferenceVisitor.InheritanceAware<Boolean>() {
//				@Override
//				protected Boolean handleNullReference() {
//					return true;
//				}
//				@Override
//				public Boolean doVisitTypeReference(JvmTypeReference reference) {
//					return false;
//				}
//				@Override
//				public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
//					for(JvmTypeConstraint constraint: reference.getConstraints()) {
//						if (visit(constraint.getTypeReference()))
//							return true;
//					}
//					return false;
//				}
//				@Override
//				public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
//					if (type == reference.getType())
//						return true;
//					for(JvmTypeReference argument: reference.getArguments()) {
//						if (visit(argument))
//							return true;
//					}
//					return false;
//				}
//			}.visit(reference);
//			return result;
//		}
		
		@Override
		public JvmTypeReference doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
			JvmWildcardTypeReference result = typesFactory.createJvmWildcardTypeReference();
			for(JvmTypeConstraint constraint: reference.getConstraints()) {
				JvmTypeReference copiedConstraintReference = visit(constraint.getTypeReference());
//				if (bound instanceof JvmWildcardTypeReference) {
//					result.getConstraints().addAll(((JvmWildcardTypeReference) bound).getConstraints());
//				} else {
					JvmTypeConstraint copiedConstraint = (JvmTypeConstraint) EcoreUtil.create(constraint.eClass());
//					copiedConstraint.setTypeReference(primitives.asWrapperTypeIfPrimitive(bound));
					copiedConstraint.setTypeReference(copiedConstraintReference);
					result.getConstraints().add(copiedConstraint);
				}
//			}
			return result;
		}
		
		@Override
		public JvmTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
			JvmTypeReference copiedComponent = visit(reference.getComponentType());
			JvmGenericArrayTypeReference result = typesFactory.createJvmGenericArrayTypeReference();
			result.setComponentType(copiedComponent);
			return result;
		}
		@Override
		public JvmTypeReference doVisitAnyTypeReference(JvmAnyTypeReference reference) {
			return typesFactory.createJvmAnyTypeReference();
		}
		
		@Override
		public JvmTypeReference doVisitMultiTypeReference(JvmMultiTypeReference reference) {
			JvmMultiTypeReference result = typesFactory.createJvmMultiTypeReference();
			for(JvmTypeReference component: reference.getReferences()) {
				result.getReferences().add(visit(component));
			}
			return result;
		}

		@Override
		public JvmTypeReference doVisitSynonymTypeReference(JvmSynonymTypeReference reference) {
			JvmSynonymTypeReference result = typesFactory.createJvmSynonymTypeReference();
			for(JvmTypeReference component: reference.getReferences()) {
				result.getReferences().add(visit(component));
			}
			return result;
		}

		@Override
		public JvmTypeReference doVisitUnknownTypeReference(JvmUnknownTypeReference reference) {
			return typesFactory.createJvmUnknownTypeReference();
		}
		
		public JvmTypeReference substitute(JvmTypeReference original) {
			JvmTypeReference result = visit(original);
			return result;
		}
	}