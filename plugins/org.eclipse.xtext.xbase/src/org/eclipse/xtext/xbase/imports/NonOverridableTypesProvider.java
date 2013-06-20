/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.common.types.util.VisibilityService;

import com.google.inject.Inject;

/**
 * This class collects visible inner classes of the supertype and local type parameters. These cannot be overridden by
 * means of an import so they need special treatment.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NonOverridableTypesProvider {

	@Inject
	private SuperTypeCollector superTypeCollector;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private VisibilityService visibilityService;

	private Map<JvmMember, Map<String, JvmIdentifiableElement>> visibleElements = newHashMap();

	/**
	 * Returns a type with the given name that is reachable in the context.
	 * If the context is <code>null</code>, it is assumed that no type is visible.
	 * @return the visible type or <code>null</code>
	 */
	public JvmIdentifiableElement getVisibleType(JvmMember context, String name) {
		if (context == null)
			return null;
		Map<String, JvmIdentifiableElement> map = visibleElements.get(context);
		if (map == null) {
			map = create(context);
		}
		return map.get(name);
	}

	protected Map<String, JvmIdentifiableElement> create(JvmMember context) {
		Map<String, JvmIdentifiableElement> result = newHashMap();
		process(context, result);
		return result;
	}

	protected void process(JvmMember context, Map<String, JvmIdentifiableElement> result) {
		if (context instanceof JvmDeclaredType) {
			if (!result.containsKey(context.getSimpleName()))
				result.put(context.getSimpleName(), context);
			JvmDeclaredType contextType = (JvmDeclaredType) context;
			addInnerTypes(contextType, "", contextType, result);
			JvmParameterizedTypeReference contextTypeRef = typeReferences.createTypeRef(contextType);
			for (JvmType superType : superTypeCollector.collectSuperTypesAsRawTypes(contextTypeRef)) {
				if (superType instanceof JvmDeclaredType)
					addInnerTypes((JvmDeclaredType) superType, "", contextType, result);
			}
		}
		if (context instanceof JvmTypeParameterDeclarator)
			addTypeParameters((JvmTypeParameterDeclarator) context, result);
		JvmDeclaredType declaringType = context.getDeclaringType();
		if (declaringType != null)
			process(declaringType, result);
	}

	protected void addInnerTypes(JvmDeclaredType type, String prefix, JvmDeclaredType contextType,
			Map<String, JvmIdentifiableElement> result) {
		for (JvmMember member : type.getMembers()) {
			if (member instanceof JvmDeclaredType && visibilityService.isVisible(member, contextType)) {
				String localName = prefix + member.getSimpleName();
				if (!result.containsKey(localName)) {
					result.put(localName, member);
				}
				addInnerTypes((JvmDeclaredType) member, prefix + member.getSimpleName() + ".", contextType, result);
			}
		}
	}

	protected void addTypeParameters(JvmTypeParameterDeclarator context, Map<String, JvmIdentifiableElement> result) {
		for (JvmTypeParameter typeParameter : context.getTypeParameters()) {
			if (!result.containsKey(typeParameter.getName()))
				result.put(typeParameter.getName(), typeParameter);
		}
	}

}
