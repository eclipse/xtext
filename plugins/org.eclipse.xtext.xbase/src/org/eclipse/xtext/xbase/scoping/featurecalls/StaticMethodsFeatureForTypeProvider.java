/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StaticMethodsFeatureForTypeProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	private static final Map<String, String> extensionClasses = Maps.newHashMap();
	
	static {
		extensionClasses.put(Boolean.class.getCanonicalName(), BooleanExtensions.class.getCanonicalName());
		extensionClasses.put(String.class.getCanonicalName(), StringExtensions.class.getCanonicalName());
		extensionClasses.put(Integer.class.getCanonicalName(), IntegerExtensions.class.getCanonicalName());
		extensionClasses.put(Comparable.class.getCanonicalName(), ComparableExtensions.class.getCanonicalName());
		extensionClasses.put(Object.class.getCanonicalName(), ObjectExtensions.class.getCanonicalName());
		extensionClasses.put(List.class.getCanonicalName(), ListExtensions.class.getCanonicalName());
		extensionClasses.put(Collection.class.getCanonicalName(), CollectionExtensions.class.getCanonicalName());
		extensionClasses.put(Map.class.getCanonicalName(), CollectionExtensions.class.getCanonicalName());
		extensionClasses.put(Iterable.class.getCanonicalName(), IterableExtensions.class.getCanonicalName());
	}

	private static final Collection<String> literalClasses = ImmutableList.of(
			CollectionLiterals.class.getName(),
			InputOutput.class.getName()
	);
	
	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private Primitives primitives;
	
	@Override
	protected Iterable<String> getVisibleTypesContainingStaticMethods(JvmTypeReference reference) {
		if (reference == null || reference.getType() == null) {
			return literalClasses;
		}
		reference = primitives.asWrapperTypeIfPrimitive(reference);
		List<String> typeNames = Lists.newArrayList(reference.getType().getIdentifier());
		typeNames.addAll(superTypeCollector.collectSuperTypeNames(reference.getType()));
		Iterable<String> result = Iterables.filter(Iterables.transform(typeNames, new Function<String, String>() {
			public String apply(String from) {
				return extensionClasses.get(from);
			}
		}), Predicates.notNull());
		return result;
	}
}
