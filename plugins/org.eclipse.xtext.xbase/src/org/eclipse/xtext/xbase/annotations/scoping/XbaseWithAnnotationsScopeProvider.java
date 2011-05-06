/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.scoping;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class XbaseWithAnnotationsScopeProvider extends XbaseScopeProvider {
	
	@Inject
	private FeatureOverridesService overrideService;
	
	@Inject 
	private TypeArgumentContextProvider typeArgumentContextProvider;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT) {
			XAnnotation annotation = EcoreUtil2.getContainerOfType(context, XAnnotation.class);
			JvmAnnotationType annotationType = annotation.getAnnotationType();
			Iterable<JvmFeature> features = overrideService.getAllJvmFeatures(annotationType, typeArgumentContextProvider.getNullContext());
			Iterable<IEObjectDescription> descriptions = transform(features, new Function<JvmFeature, IEObjectDescription>() {
				public IEObjectDescription apply(JvmFeature from) {
					return EObjectDescription.create(QualifiedName.create(from.getSimpleName()), from);
				}
			});
			return MapBasedScope.createScope(IScope.NULLSCOPE, descriptions);
		}
		return super.getScope(context, reference);
	}
}
