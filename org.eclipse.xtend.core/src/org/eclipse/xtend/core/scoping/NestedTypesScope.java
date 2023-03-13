/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypesScope extends AbstractKnownTypesScope {

	private final JvmDeclaredType innermost;
	private final XtendImportedNamespaceScopeProvider typeScopeProvider;

	public NestedTypesScope(JvmDeclaredType innermost, XtendImportedNamespaceScopeProvider typeScopeProvider, AbstractScope parent) {
		super(parent);
		this.innermost = innermost;
		this.typeScopeProvider = typeScopeProvider;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription result = doGetSingleElement(name);
		if (result != null) {
			return Collections.singletonList(result);
		}
		return super.getElements(name);
	}
	
	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		if (type instanceof JvmDeclaredType) {
			JvmDeclaredType declarator = innermost;
			while(declarator != null) {
				if (declarator != type && EcoreUtil.isAncestor(declarator, type)) {
					doGetDescriptions(type, declarator, 0, result);
				}
				declarator = EcoreUtil2.getContainerOfType(declarator.eContainer(), JvmDeclaredType.class);
			}
		}
		super.doGetElements(type, result);
	}

	@Override
	protected void doGetDescriptions(JvmType type, JvmType declarator, int index, List<IEObjectDescription> result) {
		String typeName = type.getQualifiedName('.');
		String declaratorName = declarator.getQualifiedName('.');
		int declaratorLength = declaratorName.length();
		String subName = typeName.substring(declaratorLength + 1);
		List<String> segments = Strings.split(subName, '.');
		result.add(EObjectDescription.create(QualifiedName.create(segments), type));
		result.add(EObjectDescription.create(subName.replace('.', '$'), type));
	}

	@Override
	protected IEObjectDescription doGetSingleElement(QualifiedName name, String firstSegment, int dollarIndex) {
		JvmDeclaredType declaredType = innermost;
		while(declaredType != null) {
			IEObjectDescription result = doGetSingleElement(declaredType, name, firstSegment, dollarIndex);
			if (result != null) {
				return result;
			}
			declaredType = EcoreUtil2.getContainerOfType(declaredType.eContainer(), JvmDeclaredType.class);
		}
		if (dollarIndex > 0 && name.getSegmentCount() == 1) {
			QualifiedName splitted = QualifiedName.create(Strings.split(name.getFirstSegment(), '$'));
			IEObjectDescription result = doGetSingleElement(splitted, splitted.getFirstSegment(), -1);
			if (result != null) {
				return new AliasedEObjectDescription(name, result);
			}
		}
		return null;
	}
		
	protected IEObjectDescription doGetSingleElement(JvmDeclaredType declarator, QualifiedName name, String firstSegment, int dollarIndex) {
		if (declarator.isLocal()) {
			JvmTypeReference superTypeReference = Iterables.getLast(declarator.getSuperTypes());
			if (InferredTypeIndicator.isInferred(superTypeReference))
				return findNestedTypeInLocalTypeNonResolving(declarator, name, firstSegment, dollarIndex);
		}
		
		Iterable<JvmDeclaredType> nestedTypes = declarator.findAllNestedTypesByName(firstSegment);
		for(JvmDeclaredType nested: nestedTypes) {
			JvmType nestedType = findNestedType(nested, 0, name);
			if (nestedType != null) {
				return toDescription(name, nestedType, dollarIndex, 0);
			}
		}
		return null;
	}

	/**
	 * We have to be careful to keep the unresolved super type of a local type which may depend on type resolution.
	 * Therefore these types are treated differently from other types.
	 */
	protected IEObjectDescription findNestedTypeInLocalTypeNonResolving(JvmDeclaredType localType, QualifiedName name,
			String firstSegment, int dollarIndex) {
		List<JvmMember> members = localType.getMembers();
		for(int i = 0; i < members.size(); i++) {
			JvmMember member = members.get(i);
			if (member instanceof JvmDeclaredType) {
				JvmDeclaredType nestedType = (JvmDeclaredType) member;
				if (firstSegment.equals(nestedType.getSimpleName())) {
					JvmType candidate = findNestedType(nestedType, 0, name);
					if (candidate != null) {
						return toDescription(name, candidate, dollarIndex, 0);
					}
				}
			}
		}
		JvmDeclaredType superType = typeScopeProvider.getSuperTypeOfLocalTypeNonResolving(localType);
		if (superType == null) {
			return null;
		}
		return doGetSingleElement(superType, name, firstSegment, dollarIndex);
	}

}