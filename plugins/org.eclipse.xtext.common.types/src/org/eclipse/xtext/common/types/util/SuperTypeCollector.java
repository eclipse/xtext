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

import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeReference;

import com.google.common.base.Function;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SuperTypeCollector {

	public Collection<Type> collectSuperTypes(Type type) {
		Function<Type, Type> function = new Function<Type, Type>() {
			public Type apply(Type from) {
				return from;
			}
		};
		return doCollectSupertypeData(type, function);
	}
	
	public Collection<String> collectSuperTypeNames(Type type) {
		Function<Type, String> function = new Function<Type, String>() {
			public String apply(Type from) {
				return from.getCanonicalName();
			}
		};
		return doCollectSupertypeData(type, function);
	}
	
	public <Result> Collection<Result> doCollectSupertypeData(Type type, Function<Type, Result> function) {
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
		private final Function<Type, Result> transformation;
		
		public Implementation(Function<Type, Result> transformation){
			this.transformation = transformation;
			result = Sets.newHashSet();
		}
		
		public Collection<Result> getResult() {
			return result;
		}
		
		@Override
		public Void caseType(Type object) {
			// do nothing
			return null;
		}
		
		@Override
		public Void caseDeclaredType(DeclaredType object) {
			if (!object.eIsProxy()) {
				if (!collecting || result.add(transformation.apply(object))) {
					collecting = true;
					for(TypeReference superType: object.getSuperTypes()) {
						if (superType.getType() != null)
							doSwitch(superType.getType());
					}
				}
			}
			return null;
		}
	}
	
}
