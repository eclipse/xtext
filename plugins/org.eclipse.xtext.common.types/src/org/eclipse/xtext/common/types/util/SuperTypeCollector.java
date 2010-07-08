/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Function;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SuperTypeCollector {

	public Collection<JvmType> collectSuperTypes(JvmType type) {
		Function<JvmType, JvmType> function = new Function<JvmType, JvmType>() {
			public JvmType apply(JvmType from) {
				return from;
			}
		};
		return doCollectSupertypeData(type, function);
	}
	
	public Collection<String> collectSuperTypeNames(JvmType type) {
		Function<JvmType, String> function = new Function<JvmType, String>() {
			public String apply(JvmType from) {
				return from.getCanonicalName();
			}
		};
		return doCollectSupertypeData(type, function);
	}
	
	public <Result> Collection<Result> doCollectSupertypeData(JvmType type, Function<JvmType, Result> function) {
		if (type != null) {
			Implementation<Result> implementation = new Implementation<Result>(function);
			implementation.doSwitch(type);
			Collection<Result> result = implementation.getResult();
			return result;
		}
		return Collections.emptySet();
	}
	
	public static class Implementation<Result> extends TypesSwitch<Void> {

		private boolean collecting = false;
		private final Collection<Result> result;
		private final Function<JvmType, Result> transformation;
		
		public Implementation(Function<JvmType, Result> transformation){
			this.transformation = transformation;
			result = Sets.newHashSet();
		}
		
		public Collection<Result> getResult() {
			return result;
		}
		
		@Override
		public Void caseJvmType(JvmType object) {
			// do nothing
			return null;
		}
		
		@Override
		public Void caseJvmDeclaredType(JvmDeclaredType object) {
			if (!object.eIsProxy()) {
				if (!collecting || result.add(transformation.apply(object))) {
					collecting = true;
					for(JvmTypeReference superType: object.getSuperTypes()) {
						if (superType.getType() != null)
							doSwitch(superType.getType());
					}
				}
			}
			return null;
		}
	}
	
}
