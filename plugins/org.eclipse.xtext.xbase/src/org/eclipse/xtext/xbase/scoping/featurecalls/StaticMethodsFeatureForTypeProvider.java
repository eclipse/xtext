/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Booleans;
import org.eclipse.xtext.xbase.lib.Collections;
import org.eclipse.xtext.xbase.lib.Comparables;
import org.eclipse.xtext.xbase.lib.Integers;
import org.eclipse.xtext.xbase.lib.Iterables;
import org.eclipse.xtext.xbase.lib.Objects;
import org.eclipse.xtext.xbase.lib.Strings;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StaticMethodsFeatureForTypeProvider implements IFeaturesForTypeProvider {

	@Inject
	private XbaseTypeConformanceComputer conformanceComputer;
	
	@Inject
	private TypeReferences typeRefs;

	private Notifier context;

	public Iterable<? extends JvmFeature> getFeaturesForType(final JvmTypeReference reference) {
		String referenceTypeName = null;
		if (reference != null)
			referenceTypeName = reference.getType().getIdentifier();
		final Iterable<String> staticTypes = getVisibleTypesContainingStaticMethods(referenceTypeName);
		Iterable<JvmOperation> staticMethods = emptySet();
		for (String typeName : staticTypes) {
			JvmTypeReference typeReference = typeRefs.getTypeForName(typeName, context);
			if (typeReference != null) {
				final JvmDeclaredType type = (JvmDeclaredType) typeReference.getType();
				Iterable<JvmOperation> operations = type.getDeclaredOperations();
				staticMethods = concat(staticMethods, filter(operations, new Predicate<JvmOperation>() {
					public boolean apply(JvmOperation input) {
						if (input.isStatic()) {
							if (reference == null)
								return true;
							if (input.getParameters().size() > 0) {
								JvmFormalParameter firstParam = input.getParameters().get(0);
								return conformanceComputer.isConformant(firstParam.getParameterType(),
										reference, true);
							}
						}
						return false;
					}
				}));
			}
		}
		return newArrayList(staticMethods);
	}

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

	protected Iterable<String> getVisibleTypesContainingStaticMethods(String typeName) {
		if (typeName == null)
			return classes.values();
		final Collection<String> types = classes.get(typeName);
		return types;
	}

	public void setContext(Notifier context) {
		this.context = context;
	}

}
