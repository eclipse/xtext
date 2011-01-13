/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.naming.QualifiedName;
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
	
	public Iterable<? extends JvmFeature> getFeaturesForType(JvmDeclaredType declType) {
		final JvmParameterizedTypeReference reference = typesFactory.createJvmParameterizedTypeReference();
		reference.setType(declType);
		JvmTypeReference typeReference = typeService.getTypeForName(getOperators(), declType);
		if (typeReference==null) {
			throw new IllegalStateException("couldn't find type "+getOperators().toString());
		}
		final JvmDeclaredType type = (JvmDeclaredType)typeReference.getType();
		Iterable<JvmOperation> operations = type.getDeclaredOperations();
		Iterable<JvmOperation> staticMethods = filter(operations, new Predicate<JvmOperation>() {
			public boolean apply(JvmOperation input) {
				if (input.isStatic()) {
					if (input.getParameters().size()>0) {
						JvmFormalParameter firstParam = input.getParameters().get(0);
						return conformanceComputer.isConformant(firstParam.getParameterType(), reference);
					}
				}
				return false;
			}
		});
		return staticMethods;
	}

	protected QualifiedName getOperators() {
		return QualifiedName.create("org","eclipse","xtext","xbase","lib","Operators");
	}
	
}
