/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.Flags;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.util.ReflectionUtil;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.FunctionExtensions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.ProcedureExtensions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class StaticMethodsFeatureForTypeProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	@Singleton
	public static class ExtensionClassNameProvider {
	
		private final Collection<String> literalClassNames;
		private final Map<String, Collection<String>> extensionClassNames;
		
		public ExtensionClassNameProvider() {
			this.literalClassNames = computeLiteralClassNames();
			this.extensionClassNames = computeExtensionClassNames();
		}

		protected Map<String, Collection<String>> computeExtensionClassNames() {
			return denormalize(simpleComputeExtensionClasses());
		}
		
		protected Map<String, Collection<String>> denormalize(Multimap<Class<?>, Class<?>> classMapping) {
			Multimap<String, String> result = LinkedHashMultimap.create();
			for(Map.Entry<Class<?>, Class<?>> entry: classMapping.entries()) {
				Class<?> key = entry.getKey();
				Class<?> keyObjectType = ReflectionUtil.getObjectType(key);
				Class<?> value = entry.getValue();
				for(Method method: value.getDeclaredMethods()) {
					if (Flags.isStatic(method.getModifiers()) && method.getParameterTypes().length > 0) {
						Class<?> paramType = method.getParameterTypes()[0];
						Class<?> paramObjectType = ReflectionUtil.getObjectType(paramType);		
						if (keyObjectType.isAssignableFrom(paramObjectType)) {
							result.put(paramObjectType.getCanonicalName(), value.getCanonicalName());
						}
					}
				}
			}
			return ImmutableMultimap.copyOf(result).asMap();
		}

		protected Collection<String> getLiteralClassNames() {
			return literalClassNames;
		}
		
		protected Map<String, Collection<String>> getExtensionClassNames() {
			return extensionClassNames;
		}
		
		protected Collection<String> computeLiteralClassNames() {
			return Lists.newArrayList(
					CollectionLiterals.class.getName(),
					InputOutput.class.getName()
			);
		}
		
		protected Multimap<Class<?>, Class<?>> simpleComputeExtensionClasses() {
			Multimap<Class<?>, Class<?>> result = ArrayListMultimap.create();
			result.put(Boolean.class, BooleanExtensions.class);
			result.put(String.class, StringExtensions.class);
			result.put(Integer.class, IntegerExtensions.class);
			result.put(Comparable.class, ComparableExtensions.class);
			result.put(Object.class, ObjectExtensions.class);
			result.put(List.class, ListExtensions.class);
			result.put(Collection.class, CollectionExtensions.class);
			result.put(Map.class, CollectionExtensions.class);
			result.put(Map.class, MapExtensions.class);
			result.put(Iterable.class, IterableExtensions.class);
			result.put(Functions.Function0.class, FunctionExtensions.class);
			result.put(Functions.Function1.class, FunctionExtensions.class);
			result.put(Functions.Function2.class, FunctionExtensions.class);
			result.put(Functions.Function3.class, FunctionExtensions.class);
			result.put(Functions.Function4.class, FunctionExtensions.class);
			result.put(Functions.Function5.class, FunctionExtensions.class);
			result.put(Functions.Function6.class, FunctionExtensions.class);
			result.put(Procedures.Procedure0.class, ProcedureExtensions.class);
			result.put(Procedures.Procedure1.class, ProcedureExtensions.class);
			result.put(Procedures.Procedure2.class, ProcedureExtensions.class);
			result.put(Procedures.Procedure3.class, ProcedureExtensions.class);
			result.put(Procedures.Procedure4.class, ProcedureExtensions.class);
			result.put(Procedures.Procedure5.class, ProcedureExtensions.class);
			result.put(Procedures.Procedure6.class, ProcedureExtensions.class);
			return result;
		}
	}

	@Inject
	private Primitives primitives;
	
	@Inject
	private ExtensionClassNameProvider extensionClassProvider;
	
	@Override
	protected Map<JvmTypeReference, Collection<String>> getVisibleTypesContainingStaticMethods(Iterable<JvmTypeReference> hierarchy) {
		if (hierarchy == null) {
			return Collections.singletonMap(null, getLiteralClassNames());
		}
		Iterator<JvmTypeReference> iterator = hierarchy.iterator();
		if (!iterator.hasNext())
			return Collections.singletonMap(null, getLiteralClassNames());
		Map<JvmTypeReference, Collection<String>> result = Maps.newLinkedHashMap();
		while(iterator.hasNext()) {
			JvmTypeReference reference = iterator.next();
			if (reference.getType() != null) {
				JvmTypeReference wrapped = primitives.asWrapperTypeIfPrimitive(reference);
				String typeName = wrapped.getType().getQualifiedName('.');
				Collection<String> extensionTypes = getExtensionClassNames().get(typeName);
				if (extensionTypes != null) {
					result.put(reference, extensionTypes);
				}
			} else {
				if (result.isEmpty() && !iterator.hasNext()) {
					return Collections.singletonMap(null, getLiteralClassNames()); 
				}
			}
		}
		return result;
	}

	protected Collection<String> getLiteralClassNames() {
		return extensionClassProvider.getLiteralClassNames();
	}
	
	protected Map<String, Collection<String>> getExtensionClassNames() {
		return extensionClassProvider.getExtensionClassNames();
	}
	
}
