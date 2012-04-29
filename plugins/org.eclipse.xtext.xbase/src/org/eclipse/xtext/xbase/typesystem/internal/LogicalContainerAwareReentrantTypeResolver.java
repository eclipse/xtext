/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.scoping.batch.FeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class LogicalContainerAwareReentrantTypeResolver extends DefaultReentrantTypeResolver {

	public static class DemandTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {
		private final JvmMember member;
		private final ResolvedTypes resolvedTypes;
		private final LogicalContainerAwareReentrantTypeResolver resolver;
		private final IFeatureScopeSession featureScopeSession;

		public DemandTypeReferenceProvider(JvmMember member, ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, LogicalContainerAwareReentrantTypeResolver resolver) {
			this.member = member;
			this.resolvedTypes = resolvedTypes;
			this.featureScopeSession = featureScopeSession;
			this.resolver = resolver;
		}

		@Override
		protected JvmTypeReference doGetTypeReference() {
			resolver.computeTypes(resolvedTypes, featureScopeSession, member);
			return resolver.getComputedType(member);
		}
	}

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
//	private Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping;
	
	@Override
	public void initializeFrom(@NonNull EObject root) {
		if (!(root instanceof JvmType)) {
			throw new IllegalArgumentException("only JvmTypes are supported as root by this resolver");
		}
		super.initializeFrom(root);
	}
	
	@Override
	protected JvmType getRoot() {
		return (JvmType) super.getRoot();
	}
	
	protected JvmTypeReference getComputedType(JvmMember member) {
		throw new UnsupportedOperationException("member: " + member);
	}
//	
//	@Override
//	protected TypeParameterSubstitutor createTypeParameterSubstitutor() {
//		JvmType root = getRoot();
//		if (root instanceof JvmDeclaredType) {
//			DeclaratorTypeArgumentCollector visitor = new DeclaratorTypeArgumentCollector();
//			// TODO merge bound parameter things
//			Map<JvmTypeParameter, JvmTypeReference> mapping = Maps.newHashMap();
//			for(JvmTypeReference superType: ((JvmDeclaredType) root).getSuperTypes()) {
//				mapping.putAll(visitor.getTypeParameterMapping(superType));
//			}
//			if (root instanceof JvmTypeParameterDeclarator) {
//				
//			}
//			typeParameterMapping = mapping;
//		} else {
//			typeParameterMapping = Maps.newHashMap();			
//		}
//	}
	
	/**
	 * Assign computed type references to the identifiable structural elements in the processed type.
	 */
	protected void prepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession) {
		doPrepare(resolvedTypes, featureScopeSession, getRoot());
	}
	
	protected void doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmIdentifiableElement element) {
		if (element instanceof JvmDeclaredType) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmDeclaredType) element);
		} else if (element instanceof JvmConstructor) {
			_doPrepare(resolvedTypes, (JvmConstructor) element);
		} else if (element instanceof JvmField) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmField) element);
		} else if (element instanceof JvmOperation) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmOperation) element);
		}
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, type);
		List<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			doPrepare(resolvedTypes, childSession, members.get(i));
		}
	}

	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmField field) {
		if (field.getType() != null) {
			resolvedTypes.setType(field, field.getType());
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypes, featureScopeSession, field);
			field.setType(reference);
		}
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, JvmConstructor constructor) {
		JvmDeclaredType producedType = constructor.getDeclaringType();
		JvmParameterizedTypeReference asReference = getServices().getTypeReferences().createTypeRef(producedType);
		resolvedTypes.setType(constructor, asReference);
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmOperation operation) {
		if (operation.getReturnType() != null) {
			resolvedTypes.setType(operation, operation.getReturnType());
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypes, featureScopeSession, operation);
			operation.setReturnType(reference);
		}
	}
	
	protected JvmTypeReference createComputedTypeReference(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member) {
		XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
		result.setTypeProvider(createTypeProvider(resolvedTypes, featureScopeSession, member));
		resolvedTypes.setType(member, result);
		return result;
	}
	
	protected IJvmTypeReferenceProvider createTypeProvider(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member) {
		return new DemandTypeReferenceProvider(member, resolvedTypes, featureScopeSession, this);
	}
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		prepare(resolvedTypes, session);
		super.computeTypes(resolvedTypes, session);
		processResult(resolvedTypes);
	}
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, EObject element) {
		if (element instanceof JvmConstructor) {
			_computeTypes(resolvedTypes, featureScopeSession, (JvmConstructor) element);
		} else if (element instanceof JvmField) {
			_computeTypes(resolvedTypes, featureScopeSession, (JvmField) element);
		} else if (element instanceof JvmOperation) {
			_computeTypes(resolvedTypes, featureScopeSession, (JvmOperation) element);
		} else if (element instanceof JvmDeclaredType) {
			_computeTypes(resolvedTypes, featureScopeSession, (JvmDeclaredType) element);
		} else {
			super.computeTypes(resolvedTypes, featureScopeSession, element);
		}
	}

	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmField field) {
		FieldTypeComputationState state = new FieldTypeComputationState(resolvedTypes, featureScopeSession, field, this);
		state.computeTypes();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, field);
	}
	
	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmConstructor constructor) {
		ConstructorBodyComputationState state = new ConstructorBodyComputationState(resolvedTypes, featureScopeSession, constructor, this);
		state.computeTypes();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, constructor);
	}
	
	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmOperation operation) {
		OperationBodyComputationState state = new OperationBodyComputationState(resolvedTypes, featureScopeSession, operation, this);
		state.computeTypes();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, operation);
	}
	
	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmAnnotationTarget annotable) {
		if (!annotable.getAnnotations().isEmpty()) {
			throw new UnsupportedOperationException(resolvedTypes + " " + annotable + " " + featureScopeSession);
		}
	}
	
	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		StackedResolvedTypes childResolvedTypes = new StackedResolvedTypes(resolvedTypes);
		JvmTypeReference superType = getExtendedClass(type);
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, type, superType);
		if (superType != null) {
			childResolvedTypes.reassignType(superType.getType(), superType);
			// We use reassignType to make sure that the following works
			/*
			 * StringList extends AbstractList<String> {
			 *   NestedIntList extends AbstractList<Integer> {
			 *   }
			 *   SubType extends StringList {}
			 * }
			 */
		}
		childResolvedTypes.reassignType(type, superType);
		List<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			computeTypes(childResolvedTypes, childSession, members.get(i));
		}
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, type);
		childResolvedTypes.mergeIntoParent();
	}
	
	protected IFeatureScopeSession addThisAndSuper(IFeatureScopeSession session, JvmDeclaredType type) {
		JvmTypeReference superType = getExtendedClass(type);
		return addThisAndSuper(session, type, superType);
	}

	protected IFeatureScopeSession addThisAndSuper(IFeatureScopeSession session, JvmDeclaredType thisType,
			JvmTypeReference superType) {
		IFeatureScopeSession childSession = session;
		if (superType != null) {
			ImmutableMap.Builder<QualifiedName, JvmIdentifiableElement> builder = ImmutableMap.builder();
			builder.put(FeatureNames.THIS, thisType);
			builder.put(FeatureNames.SUPER, superType.getType());
			childSession = session.addLocalElements(builder.build());
		} else {
			childSession = session.addLocalElement(FeatureNames.THIS, thisType);
		}
		return childSession;
	}
	
	public JvmTypeReference getExtendedClass(JvmDeclaredType type) {
		for(JvmTypeReference candidate: type.getSuperTypes()) {
			if (candidate.getType() instanceof JvmGenericType && !((JvmGenericType) candidate.getType()).isInterface())
				return candidate;
		}
		return null;
	}

	protected void processResult(@SuppressWarnings("unused") ResolvedTypes resolvedTypes) {
		// TODO keep the result available for subsequent linking requests et al
	}
	
	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return logicalContainerProvider;
	}
	
}
