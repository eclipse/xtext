/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StaticMethodsFeatureForTypeProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	private static final Multimap<String, String> extensionClasses = HashMultimap.create();
	
	static {
		extensionClasses.put(Boolean.class.getCanonicalName(), BooleanExtensions.class.getCanonicalName());
		extensionClasses.put(String.class.getCanonicalName(), StringExtensions.class.getCanonicalName());
		extensionClasses.put(Integer.class.getCanonicalName(), IntegerExtensions.class.getCanonicalName());
		extensionClasses.put(Comparable.class.getCanonicalName(), ComparableExtensions.class.getCanonicalName());
		extensionClasses.put(Object.class.getCanonicalName(), ObjectExtensions.class.getCanonicalName());
		extensionClasses.put(Collection.class.getCanonicalName(), CollectionExtensions.class.getCanonicalName());
		extensionClasses.put(Iterable.class.getCanonicalName(), IterableExtensions.class.getCanonicalName());
	}

	private static final Collection<String> literalClasses = ImmutableList.of(
			CollectionLiterals.class.getName()
	);
	
	@Override
	protected Iterable<String> getVisibleTypesContainingStaticMethods(JvmTypeReference reference) {
		if (reference == null || reference.getType() == null) {
			return literalClasses;
		}
		String typeName = reference.getType().getIdentifier();
		final Collection<String> types = extensionClasses.get(typeName);
		return Collections.unmodifiableCollection(types);
	}
}
