/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.xbase.scoping.featurecalls.IFeaturesForTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.DeclaredDependency;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class InjectedExtensionMethodsFeaturesProvider implements IFeaturesForTypeProvider {
	
	@Inject
	private FeatureOverridesService overridesService;
	
	private DeclaredDependency declaredDependency;
	
	public void setContext(DeclaredDependency declaredDependency) {
		this.declaredDependency = declaredDependency;
	}
	
	public Iterable<? extends JvmFeature> getFeaturesForType(JvmTypeReference type) {
		List<JvmFeature> result = newArrayList();
		JvmTypeReference typeReference = declaredDependency.getType();
		Iterable<JvmFeature> iterable = overridesService.getAllJvmFeatures(typeReference);
		for (JvmFeature jvmFeature : iterable) {
			if (jvmFeature instanceof JvmOperation) {
				final JvmOperation jvmOperation = (JvmOperation) jvmFeature;
				EList<JvmFormalParameter> parameters = jvmOperation.getParameters();
				if (!jvmOperation.isStatic() && parameters.size()>0) {
					if (parameters.get(0).getParameterType().getType()==type.getType())
						result.add(jvmFeature);
				}
			}
		}
		return result;
	}

}
