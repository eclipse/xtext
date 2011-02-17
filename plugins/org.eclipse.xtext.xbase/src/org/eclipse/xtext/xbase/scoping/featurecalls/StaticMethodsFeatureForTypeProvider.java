/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Booleans;
import org.eclipse.xtext.xbase.lib.Collections;
import org.eclipse.xtext.xbase.lib.Comparables;
import org.eclipse.xtext.xbase.lib.Integers;
import org.eclipse.xtext.xbase.lib.Iterables;
import org.eclipse.xtext.xbase.lib.Objects;
import org.eclipse.xtext.xbase.lib.Strings;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StaticMethodsFeatureForTypeProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	private static final Multimap<String, String> classes = HashMultimap.create();
	{
		classes.put(Boolean.class.getCanonicalName(), Booleans.class.getCanonicalName());
		classes.put(String.class.getCanonicalName(), Strings.class.getCanonicalName());
		classes.put(Integer.class.getCanonicalName(), Integers.class.getCanonicalName());
		classes.put(Comparable.class.getCanonicalName(), Comparables.class.getCanonicalName());
		classes.put(Object.class.getCanonicalName(), Objects.class.getCanonicalName());
		classes.put(Collection.class.getCanonicalName(), Collections.class.getCanonicalName());
		classes.put(Iterable.class.getCanonicalName(), Iterables.class.getCanonicalName());
	}

	@Override
	protected Iterable<String> getVisibleTypesContainingStaticMethods(JvmTypeReference reference) {
		if (reference == null || reference.getType() == null)
			return classes.values();
		String typeName = reference.getType().getIdentifier();
		final Collection<String> types = classes.get(typeName);
		return types;
	}
}
