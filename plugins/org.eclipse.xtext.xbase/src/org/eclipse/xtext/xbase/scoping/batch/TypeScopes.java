/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeScopes extends DelegatingScopes {

	public boolean isTypeScope(EReference reference) {
		return TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(reference.getEReferenceType());
	}

	public IScope createTypeScope(EObject context, EReference reference,
			IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		return doCreateTypeScope(context, reference, session);
	}
	
	protected IScope doCreateTypeScope(final EObject context, EReference reference, final IFeatureScopeSession session) {
		final IScope delegateScope = getDelegate().getScope(context, reference);
		// TODO visibility
		return delegateScope;
//		return new IScope() {
//
//			public Iterable<IEObjectDescription> getAllElements() {
//				Iterable<IEObjectDescription> original = delegateScope.getAllElements();
//				return createFeatureDescriptions(original);
//			}
//
//			protected Iterable<IEObjectDescription> createFeatureDescriptions(Iterable<IEObjectDescription> original) {
//				Iterable<IEObjectDescription> result = transform(original,
//						new Function<IEObjectDescription, IEObjectDescription>() {
//							public IEObjectDescription apply(IEObjectDescription from) {
//								JvmConstructor constructor = (JvmConstructor) from.getEObjectOrProxy();
//								if (constructor.eIsProxy()) {
//									EObject resolved = EcoreUtil.resolve(constructor, context);
//									if (resolved instanceof JvmConstructor)
//										constructor = (JvmConstructor) resolved;
//								}
//								boolean visible = session.isVisible(constructor);
//								BucketedEObjectDescription result = new BucketedEObjectDescription(from.getName(), constructor, CONSTRUCTOR_BUCKET, visible);
//								return result;
//							}
//						});
//				return result;
//			}
//
//			public Iterable<IEObjectDescription> getElements(EObject object) {
//				Iterable<IEObjectDescription> original = delegateScope.getElements(object);
//				return createFeatureDescriptions(original);
//			}
//
//			public Iterable<IEObjectDescription> getElements(QualifiedName name) {
//				Iterable<IEObjectDescription> original = delegateScope.getElements(name);
//				return createFeatureDescriptions(original);
//			}
//
//			public IEObjectDescription getSingleElement(EObject object) {
//				Iterable<IEObjectDescription> elements = getElements(object);
//				return (isEmpty(elements)) ? null : elements.iterator().next();
//			}
//
//			public IEObjectDescription getSingleElement(QualifiedName name) {
//				throw new UnsupportedOperationException();
//			}
//
//		};
	}
	
}
