/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StaticExplicitMethodsFeatureForTypeProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	private JvmTypeReference currentType;

	public JvmTypeReference getCurrentType() {
		return currentType;
	}

	public void setTypeContext(JvmTypeReference currentType) {
		this.currentType = currentType;
	}

	protected void collectMethods(JvmTypeReference typeReference, Multimap<JvmTypeReference, JvmTypeReference> result) {
		if (typeReference != null) {
			JvmType type = typeReference.getType();
			if (type instanceof JvmGenericType) {
				JvmGenericType genericType = (JvmGenericType) type;
				for (JvmMember member : genericType.getMembers()) {
					if (member instanceof JvmOperation && ((JvmOperation) member).isStatic())
						result.put(null, typeReference);
					else if (member instanceof JvmField && ((JvmField) member).isStatic())
						result.put(null, typeReference);
				}
			}
		}
	}

	@Override
	protected Map<JvmTypeReference, Collection<JvmTypeReference>> getVisibleJvmTypesContainingStaticMethods(
			Iterable<JvmTypeReference> hierarchy) {
		Multimap<JvmTypeReference, JvmTypeReference> result = HashMultimap.create();
		collectMethods(currentType, result);
		if (hierarchy != null)
			for (JvmTypeReference ref : hierarchy)
				collectMethods(ref, result);
		return result.asMap();
	}

}
