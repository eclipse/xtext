/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class SuperTypeCollector {
	
	private JvmTypes jvmTypes;
	
	@Inject 
	public SuperTypeCollector(JvmTypes jvmTypes) {
		this.jvmTypes = jvmTypes;
	}

	public Set<JvmTypeReference> collectSuperTypes(JvmType type) {
		return collectSuperTypes(jvmTypes.createJvmTypeReference(type));
	}
	public Set<JvmTypeReference> collectSuperTypes(JvmTypeReference type) {
		Set<JvmTypeReference> doCollectSupertypeData = doCollectSupertypeData(type, Functions.<JvmTypeReference>identity());
		TreeSet<JvmTypeReference> set = new TreeSet<JvmTypeReference>(new Comparator<JvmTypeReference>() {
			public int compare(JvmTypeReference o1, JvmTypeReference o2) {
				return o1.getCanonicalName().compareTo(o2.getCanonicalName());
			}
		});
		set.addAll(doCollectSupertypeData);
		return set;
	}
	
	public Set<String> collectSuperTypeNames(JvmType type) {
		return collectSuperTypeNames(jvmTypes.createJvmTypeReference(type));
	}
	
	public Set<JvmType> collectSuperTypesAsRawTypes(JvmTypeReference type) {
		Function<JvmTypeReference, JvmType> function = new Function<JvmTypeReference, JvmType>() {
			public JvmType apply(JvmTypeReference from) {
				return from.getType();
			}
		};
		return doCollectSupertypeData(type, function);
	}
	
	public Set<String> collectSuperTypeNames(JvmTypeReference type) {
		Function<JvmTypeReference, String> function = new Function<JvmTypeReference, String>() {
			public String apply(JvmTypeReference from) {
				if (from instanceof JvmParameterizedTypeReference) {
					return ((JvmParameterizedTypeReference) from).getType().getCanonicalName();
				}
				return from.getCanonicalName();
			}
		};
		return doCollectSupertypeData(type, function);
	}
	
	public <Result> Set<Result> doCollectSupertypeData(JvmTypeReference type, Function<JvmTypeReference, Result> function) {
		if (type != null) {
			Implementation<Result> implementation = new Implementation<Result>(function);
			implementation.doSwitch(type);
			Set<Result> result = implementation.getResult();
			return result;
		}
		return Collections.emptySet();
	}
	
	public static class Implementation<Result> extends TypesSwitch<Void> {

		private boolean collecting = false;
		private final Set<Result> result;
		private final Function<JvmTypeReference, Result> transformation;
		
		public Implementation(Function<JvmTypeReference, Result> transformation){
			this.transformation = transformation;
			result = Sets.newLinkedHashSet();
		}
		
		public Set<Result> getResult() {
			return result;
		}
		
		@Override
		public Void caseJvmParameterizedTypeReference(JvmParameterizedTypeReference object) {
			if (!object.eIsProxy()) {
				if (!collecting || result.add(transformation.apply(object))) {
					collecting = true;
					if (object.getType() instanceof JvmDeclaredType) {
						for(JvmTypeReference superType: ((JvmDeclaredType)object.getType()).getSuperTypes()) {
							doSwitch(superType);
						}
					}
				}
			}
			return null;
		}
	}

}
