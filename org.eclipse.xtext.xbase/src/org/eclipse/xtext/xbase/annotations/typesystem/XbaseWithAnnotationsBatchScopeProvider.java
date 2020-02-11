/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.typesystem;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;

import com.google.common.base.Function;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XbaseWithAnnotationsBatchScopeProvider extends XbaseBatchScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT) {
			XAnnotation annotation = EcoreUtil2.getContainerOfType(context, XAnnotation.class);
			JvmType annotationType = annotation.getAnnotationType();
			if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType)) {
				return IScope.NULLSCOPE;
			}
			Iterable<JvmOperation> operations = ((JvmAnnotationType) annotationType).getDeclaredOperations();
			Iterable<IEObjectDescription> descriptions = transform(operations, new Function<JvmOperation, IEObjectDescription>() {
				@Override
				public IEObjectDescription apply(JvmOperation from) {
					return EObjectDescription.create(QualifiedName.create(from.getSimpleName()), from);
				}
			});
			return MapBasedScope.createScope(IScope.NULLSCOPE, descriptions);
		}
		return super.getScope(context, reference);
	}
	
}

