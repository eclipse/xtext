/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public abstract class AbstractStaticMethodsFeatureForTypeProvider implements IFeaturesForTypeProvider {

	@Inject
	private XbaseTypeConformanceComputer conformanceComputer;
	
	@Inject
	private TypeReferences typeRefs;

	private Resource context;

	public Iterable<? extends JvmFeature> getFeaturesForType(final JvmTypeReference reference) {
		final Iterable<String> staticTypeNames = getVisibleTypesContainingStaticMethods(reference);
		List<JvmOperation> result = newArrayList();
		for (String staticTypeName : staticTypeNames) {
			JvmTypeReference staticType = typeRefs.getTypeForName(staticTypeName, context);
			if (staticType != null) {
				final JvmDeclaredType type = (JvmDeclaredType) staticType.getType();
				Iterable<JvmOperation> operations = type.getDeclaredOperations();
				for(JvmOperation operation: operations) {
					if (isMatchingExtension(reference, operation)) {
						result.add(operation);
					}
				}
			}
		}
		return result;
	}
	
	protected boolean isMatchingExtension(JvmTypeReference expectedParameterTypeReference, JvmOperation operation) {
		if (operation.isStatic()) {
			if (expectedParameterTypeReference == null)
				return true;
			JvmType expectedParameterType = expectedParameterTypeReference.getType();
			if (operation.getParameters().size() > 0) {
				JvmFormalParameter firstParam = operation.getParameters().get(0);
				JvmType actualParameterType = firstParam.getParameterType().getType();
				if (actualParameterType == expectedParameterType)
					return true;
				if (actualParameterType instanceof JvmTypeParameter) {
					boolean upperBoundSeen = false;
					for(JvmTypeConstraint constraint: ((JvmTypeParameter) actualParameterType).getConstraints()) {
						if (constraint instanceof JvmUpperBound) {
							upperBoundSeen = true;
							if (constraint.getTypeReference().getType() == expectedParameterType)
								return true;
						}
					}
					if (!upperBoundSeen) {
						if (typeRefs.is(expectedParameterTypeReference, Object.class)) {
							return true;
						}
					}
				}
				return false;
			}
		}
		return false;
	}

	protected abstract Iterable<String> getVisibleTypesContainingStaticMethods(JvmTypeReference reference);

	public void setContext(Resource context) {
		this.context = context;
	}
	
	protected Resource getContext() {
		return context;
	}
	
	protected XbaseTypeConformanceComputer getConformanceComputer() {
		return conformanceComputer;
	}
	
	protected TypeReferences getTypeRefs() {
		return typeRefs;
	}

}
