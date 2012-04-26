/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeScopeProvider {

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	public IScope createTypeScope(IScope parentScope, EObject context, EReference reference) {
		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(context);
		if (logicalContainer != null) {
			 return createTypeScope(parentScope, logicalContainer, reference);
		}
		return parentScope;
	}
	
	protected IScope createTypeScope(IScope parentScope, JvmIdentifiableElement context, EReference reference) {
		if (context == null)
			return parentScope;
		if (context.eContainer() instanceof JvmIdentifiableElement) {
			parentScope = createTypeScope(parentScope, (JvmIdentifiableElement) context.eContainer(), reference);
		}
		if (context instanceof JvmTypeParameterDeclarator) {
			List<IEObjectDescription> descriptions = Lists.newArrayList();
			JvmTypeParameterDeclarator typeParamDeclarator = (JvmTypeParameterDeclarator) context;
			if (typeParamDeclarator instanceof JvmDeclaredType) {
				JvmDeclaredType declaredType = (JvmDeclaredType) typeParamDeclarator;
				if (declaredType.getSimpleName() != null) {
					QualifiedName inferredDeclaringTypeName = QualifiedName.create(declaredType.getSimpleName());
					descriptions.add(EObjectDescription.create(inferredDeclaringTypeName, declaredType));
				}
//				parentScope = createInnerTypeScopes(parentScope, declaredType, QualifiedName.EMPTY);
			}
			for (JvmTypeParameter param : typeParamDeclarator.getTypeParameters()) {
				if (param.getSimpleName() != null) {
					QualifiedName paramName = QualifiedName.create(param.getSimpleName());
					descriptions.add(EObjectDescription.create(paramName, param));
				}
			}
			if (!descriptions.isEmpty())
				return MapBasedScope.createScope(parentScope, descriptions);
		}
		return parentScope;
	}
	
//	protected IScope createInnerTypeScopes(IScope parentScope, JvmDeclaredType declaredType, Set<JvmType> visited, QualifiedName prefix) {
//		for(JvmTypeReference superType: declaredType.getSuperTypes()) {
//			superType.getType()
//		}
//		List<JvmMember> members = declaredType.getMembers();
//		List<IEObjectDescription> innerTypes = null;
//		for(JvmMember member: members) {
//			if (member instanceof JvmDeclaredType) {
//				if (innerTypes == null)
//					innerTypes = Lists.newArrayListWithCapacity(3);
//				addInnerTypesRecursive((JvmDeclaredType) member, innerTypes, prefix);
//			}
//		}
//		if (innerTypes != null) {
//			
//		}
//		return parentScope;
//	}
//
//	protected void addInnerTypesRecursive(JvmDeclaredType innerType, List<IEObjectDescription> innerTypes, QualifiedName prefix) {
//		QualifiedName name = prefix.append(innerType.getSimpleName());
//		innerTypes.add(EObjectDescription.create(name, innerType));
//		List<JvmMember> members = innerType.getMembers();
//		for(JvmMember member: members) {
//			if (member instanceof JvmDeclaredType) {
//				addInnerTypesRecursive((JvmDeclaredType) member, innerTypes, prefix);
//			}
//		}
//	}
	
}
