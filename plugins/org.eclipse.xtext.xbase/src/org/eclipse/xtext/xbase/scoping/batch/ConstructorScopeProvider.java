/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorScopeProvider {
	
	protected IScope createConstructorCallScope(final IScope parentScope /*, final EObject context, final EReference reference */) {
		return parentScope;
//		return new IScope() {
//
//			public Iterable<IEObjectDescription> getAllElements() {
//				Iterable<IEObjectDescription> original = parentScope.getAllElements();
//				return createFeatureDescriptions(original);
//			}
//
//			protected Iterable<IEObjectDescription> createFeatureDescriptions(Iterable<IEObjectDescription> original) {
//				return original;
//			}
//
//			public Iterable<IEObjectDescription> getElements(EObject object) {
//				Iterable<IEObjectDescription> original = parentScope.getElements(object);
//				return createFeatureDescriptions(original);
//			}
//
//			public Iterable<IEObjectDescription> getElements(QualifiedName name) {
//				Iterable<IEObjectDescription> original = parentScope.getElements(name);
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
