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
import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typing.TypesService;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StaticMethodsFeatureForTypeProvider implements IFeaturesForTypeProvider {

	@Inject
	private TypesService typeService;

	@Inject
	private TypesFactory typesFactory;

	@Inject
	private IJvmTypeConformanceComputer conformanceComputer;

	private EObject context;

	public Iterable<? extends JvmFeature> getFeaturesForType(final JvmDeclaredType declType) {
		final JvmParameterizedTypeReference reference = typesFactory
		.createJvmParameterizedTypeReference();
		reference.setType(declType);
		final Iterable<QualifiedName> operators = getClassesContainingStaticMethods(declType
				.getCanonicalName());
		Iterable<JvmOperation> staticMethods = emptySet();
		for (QualifiedName qualifiedName : operators) {
			JvmTypeReference typeReference = typeService.getTypeForName(qualifiedName, context);
			if (typeReference == null) {
				throw new IllegalStateException("couldn't find type " + operators.toString());
			}
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
		return newArrayList(staticMethods);
	}

	private static Map<String, QualifiedName> classes = newHashMap();
	{
		final QualifiedName create = QualifiedName.create("org", "eclipse", "xtext", "xbase", "lib");
		classes.put(Boolean.class.getCanonicalName(), create.append("Booleans"));
		classes.put(String.class.getCanonicalName(), create.append("Strings"));
		classes.put(Integer.class.getCanonicalName(), create.append("Integers"));
		classes.put(Comparable.class.getCanonicalName(), create.append("Comparables"));
		classes.put(Object.class.getCanonicalName(), create.append("Objects"));
		classes.put(Collection.class.getCanonicalName(), create.append("Collections"));
		classes.put(Iterable.class.getCanonicalName(), create.append("Iterables"));
	}

	protected Iterable<QualifiedName> getClassesContainingStaticMethods(String canonicalTypeName) {
		final QualifiedName o = classes.get(canonicalTypeName);
		if (o != null)
			return singleton(o);
		return emptyList();
	}

	public void setContext(EObject context) {
		this.context = context;
	}

}
