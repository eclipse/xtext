/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class LogicalContainerAwareReentrantTypeResolver extends DefaultReentrantTypeResolver {

	public static class DemandTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {
		private final JvmMember member;
		private final TypeResolution typeResolution;
		private final LogicalContainerAwareReentrantTypeResolver resolver;

		public DemandTypeReferenceProvider(JvmMember member, TypeResolution typeResolution, LogicalContainerAwareReentrantTypeResolver resolver) {
			this.member = member;
			this.typeResolution = typeResolution;
			this.resolver = resolver;
		}

		@Override
		protected JvmTypeReference doGetTypeReference() {
			resolver.computeTypes(typeResolution, member);
			return resolver.getComputedType(member);
		}
	}

	private Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping;
	
	@Inject
	private TypesFactory typesFactory = TypesFactory.eINSTANCE;
	
	@Inject
	private XtypeFactory xtypeFactory = XtypeFactory.eINSTANCE;
	
	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Override
	public void initializeFrom(@NonNull EObject root) {
		if (!(root instanceof JvmType)) {
			throw new IllegalArgumentException("only JvmTypes are supported as root by this resolver");
		}
		super.initializeFrom(root);
		if (root instanceof JvmDeclaredType) {
			DeclaratorTypeArgumentCollector visitor = new DeclaratorTypeArgumentCollector();
			for(JvmTypeReference superType: ((JvmDeclaredType) root).getSuperTypes()) {
				visitor.visit(superType);
			}
			typeParameterMapping = visitor.getTypeParameterMapping();
		} else {
			typeParameterMapping = Maps.newHashMap();			
		}
	}
	
	@Override
	protected JvmType getRoot() {
		return (JvmType) super.getRoot();
	}
	
	protected JvmTypeReference getComputedType(JvmMember member) {
		throw new UnsupportedOperationException("member: " + member);
	}
	
	public Map<JvmTypeParameter, JvmTypeReference> getTypeParameterMapping() {
		return typeParameterMapping;
	}

	public JvmTypeReference resolve(JvmTypeReference original) {
		JvmTypeReference result = new TypeParameterSubstitutor(typeParameterMapping, typesFactory).substitute(original);
		return result;
	}

	/**
	 * Assign computed type references to the identifiable structural elements in the processed type.
	 */
	protected void prepare(TypeResolution typeResolution) {
		doPrepare(typeResolution, getRoot());
	}
	
	protected void doPrepare(TypeResolution typeResolution, JvmIdentifiableElement element) {
		if (element instanceof JvmDeclaredType) {
			_doPrepare(typeResolution, (JvmDeclaredType) element);
		} else if (element instanceof JvmConstructor) {
			_doPrepare(typeResolution, (JvmConstructor) element);
		} else if (element instanceof JvmField) {
			_doPrepare(typeResolution, (JvmField) element);
		} else if (element instanceof JvmOperation) {
			_doPrepare(typeResolution, (JvmOperation) element);
		}
	}
	
	protected void _doPrepare(TypeResolution typeResolution, JvmDeclaredType type) {
		List<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			doPrepare(typeResolution, members.get(i));
		}
	}
	protected void _doPrepare(TypeResolution typeResolution, JvmField field) {
		if (field.getType() != null) {
			typeResolution.setType(field, field.getType());
		} else {
			JvmTypeReference reference = createComputedTypeReference(typeResolution, field);
			field.setType(reference);
		}
	}
	
	protected void _doPrepare(TypeResolution typeResolution, JvmConstructor constructor) {
		JvmDeclaredType producedType = constructor.getDeclaringType();
		JvmParameterizedTypeReference asReference = getTypeReferences().createTypeRef(producedType);
		typeResolution.setType(constructor, asReference);
	}
	
	protected void _doPrepare(TypeResolution typeResolution, JvmOperation operation) {
		if (operation.getReturnType() != null) {
			typeResolution.setType(operation, operation.getReturnType());
		} else {
			JvmTypeReference reference = createComputedTypeReference(typeResolution, operation);
			operation.setReturnType(reference);
		}
	}
	
	protected JvmTypeReference createComputedTypeReference(TypeResolution typeResolution, JvmMember member) {
		XComputedTypeReference result = xtypeFactory.createXComputedTypeReference();
		result.setTypeProvider(createTypeProvider(typeResolution, member));
		typeResolution.setType(member, result);
		return result;
	}
	
	protected IJvmTypeReferenceProvider createTypeProvider(TypeResolution typeResolution, JvmMember member) {
		return new DemandTypeReferenceProvider(member, typeResolution, this);
	}
	
	@Override
	protected void computeTypes(TypeResolution typeResolution) {
		prepare(typeResolution);
		super.computeTypes(typeResolution);
		processResult(typeResolution);
	}
	
	@Override
	protected void computeTypes(TypeResolution typeResolution, EObject element) {
		if (element instanceof JvmConstructor) {
			_computeTypes(typeResolution, (JvmConstructor) element);
		} else if (element instanceof JvmField) {
			_computeTypes(typeResolution, (JvmField) element);
		} else if (element instanceof JvmOperation) {
			_computeTypes(typeResolution, (JvmOperation) element);
		} else if (element instanceof JvmDeclaredType) {
			_computeTypes(typeResolution, (JvmDeclaredType) element);
		} else {
			super.computeTypes(typeResolution, element);
		}
	}

	protected void _computeTypes(TypeResolution typeResolution, JvmField field) {
		FieldTypeComputationState state = new FieldTypeComputationState(typeResolution, field, this);
		state.computeTypes();
		computeAnnotationTypes(typeResolution, field);
	}
	
	protected void _computeTypes(TypeResolution typeResolution, JvmConstructor constructor) {
		ConstructorBodyComputationState state = new ConstructorBodyComputationState(typeResolution, constructor, this);
		state.computeTypes();
		computeAnnotationTypes(typeResolution, constructor);
	}
	
	protected void _computeTypes(TypeResolution typeResolution, JvmOperation operation) {
		OperationBodyComputationState state = new OperationBodyComputationState(typeResolution, operation, this);
		state.computeTypes();
		computeAnnotationTypes(typeResolution, operation);
	}
	
	protected void computeAnnotationTypes(TypeResolution typeResolution, JvmAnnotationTarget annotable) {
		if (!annotable.getAnnotations().isEmpty()) {
			throw new UnsupportedOperationException(typeResolution + " " + annotable);
		}
	}
	
	protected void _computeTypes(TypeResolution typeResolution, JvmDeclaredType type) {
		List<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			computeTypes(typeResolution, members.get(i));
		}
		computeAnnotationTypes(typeResolution, type);
	}

	protected void processResult(@SuppressWarnings("unused") TypeResolution typeResolution) {
		// TODO keep the result available for subsequent linking requests et al
	}
	
	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return logicalContainerProvider;
	}
	
}
