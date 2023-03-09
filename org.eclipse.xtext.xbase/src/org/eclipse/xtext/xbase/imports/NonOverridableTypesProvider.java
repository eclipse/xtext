/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Maps.*;

import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.util.RawSuperTypes;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

import com.google.inject.Inject;

/**
 * This class collects visible inner classes of the supertype and local type parameters. These cannot be overridden by
 * means of an import so they need special treatment.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NonOverridableTypesProvider {

	@Inject
	private IVisibilityHelper visibilityHelper;
	
	@Inject
	private RawSuperTypes rawSuperTypes;

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
			ContextualVisibilityHelper visibilityHelper = new ContextualVisibilityHelper(this.visibilityHelper, contextType);
			addInnerTypes(contextType, "", visibilityHelper, result);
			
			Set<JvmType> superTypes = rawSuperTypes.collect(contextType);
			for (JvmType superType : superTypes) {
				if (superType instanceof JvmDeclaredType)
					addInnerTypes((JvmDeclaredType) superType, "", visibilityHelper, result);
			}
		}
		if (context instanceof JvmTypeParameterDeclarator)
			addTypeParameters((JvmTypeParameterDeclarator) context, result);
		JvmDeclaredType declaringType = context.getDeclaringType();
		if (declaringType != null)
			process(declaringType, result);
	}

	protected void addInnerTypes(
			JvmDeclaredType type,
			String prefix,
			IVisibilityHelper visibilityHelper,
			Map<String, JvmIdentifiableElement> result) {
		for (JvmMember member : type.getMembers()) {
			if (member instanceof JvmDeclaredType && visibilityHelper.isVisible(member)) {
				String localName = prefix + member.getSimpleName();
				if (!result.containsKey(localName)) {
					result.put(localName, member);
				}
				addInnerTypes((JvmDeclaredType) member, prefix + member.getSimpleName() + ".", visibilityHelper, result);
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
