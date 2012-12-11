/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.imports;

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

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class VisibleTypesFromHierarchy {

	@Inject
	private SuperTypeCollector superTypeCollector;

	@Inject
	private TypeReferences typeReferences;

	private Map<JvmMember, Map<String, JvmIdentifiableElement>> visibleElements = newHashMap();

	public JvmIdentifiableElement getVisibleType(JvmMember context, String name) {
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
			addInnerTypes(contextType, "", result);
			JvmParameterizedTypeReference contextTypeRef = typeReferences.createTypeRef(contextType);
			for (JvmType superType : superTypeCollector.collectSuperTypesAsRawTypes(contextTypeRef)) {
				if (superType instanceof JvmDeclaredType)
					addInnerTypes((JvmDeclaredType) superType, "", result);
			}
		}
		if (context instanceof JvmTypeParameterDeclarator)
			addTypeParameters((JvmTypeParameterDeclarator) context, result);
		JvmDeclaredType declaringType = context.getDeclaringType();
		if (declaringType != null)
			process(declaringType, result);
	}

	protected void addInnerTypes(JvmDeclaredType type, String prefix, Map<String, JvmIdentifiableElement> result) {
		for (JvmMember member : type.getMembers()) {
			if (member instanceof JvmDeclaredType) {
				String localName = prefix + member.getSimpleName();
				if (!result.containsKey(localName)) {
					result.put(localName, member);
				}
				addInnerTypes((JvmDeclaredType) member, prefix + member.getSimpleName() + ".", result);
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
