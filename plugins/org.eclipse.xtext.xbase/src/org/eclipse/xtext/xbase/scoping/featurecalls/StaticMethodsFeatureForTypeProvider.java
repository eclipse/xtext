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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
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
	private TypesFactory typesFactory;

	@Inject
	private XbaseTypeConformanceComputer conformanceComputer;
	
	@Inject
	private TypeReferences typeRefs;

	private EObject context;

	public Iterable<? extends JvmFeature> getFeaturesForType(final JvmDeclaredType declType) {
		final JvmParameterizedTypeReference reference = typesFactory
		.createJvmParameterizedTypeReference();
		reference.setType(declType);
		final Iterable<Class<?>> operators = getClassesContainingStaticMethods(declType
				.getCanonicalName());
		Iterable<JvmOperation> staticMethods = emptySet();
		for (Class<?> clazz : operators) {
			JvmTypeReference typeReference = typeRefs.getTypeForName(clazz, context);
			if (typeReference != null) {
				final JvmDeclaredType type = (JvmDeclaredType) typeReference.getType();
				Iterable<JvmOperation> operations = type.getDeclaredOperations();
				staticMethods = concat(staticMethods, filter(operations, new Predicate<JvmOperation>() {
					public boolean apply(JvmOperation input) {
						if (input.isStatic()) {
							if (input.getParameters().size() > 0) {
								JvmFormalParameter firstParam = input.getParameters().get(0);
								return conformanceComputer.isConformant(firstParam.getParameterType(),
										reference);
							}
						}
						return false;
					}
				}));
			}
		}
		return newArrayList(staticMethods);
	}

	private static Multimap<String, Class<?>> classes = HashMultimap.create();
	{
		classes.put(Boolean.class.getCanonicalName(), Booleans.class);
		classes.put(String.class.getCanonicalName(), Strings.class);
		classes.put(Integer.class.getCanonicalName(), Integers.class);
		classes.put(Comparable.class.getCanonicalName(), Comparables.class);
		classes.put(Object.class.getCanonicalName(), Objects.class);
		classes.put(Collection.class.getCanonicalName(), Collections.class);
		classes.put(Iterable.class.getCanonicalName(), Iterables.class);
	}

	protected Iterable<Class<?>> getClassesContainingStaticMethods(String canonicalTypeName) {
		final Collection<Class<?>> o = classes.get(canonicalTypeName);
		if (o != null)
			return o;
		return emptyList();
	}

	public void setContext(EObject context) {
		this.context = context;
	}

}
