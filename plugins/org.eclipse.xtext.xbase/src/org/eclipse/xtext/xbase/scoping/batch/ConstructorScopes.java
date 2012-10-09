/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorScopes extends DelegatingScopes {

	public static final int CONSTRUCTOR_BUCKET = 1;
	
	/**
	 * creates the constructor scope for {@link XConstructorCall}.
	 * @param session the currently available session data
	 */
	public IScope createConstructorScope(EObject context, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (!(context instanceof XConstructorCall)) {
			return IScope.NULLSCOPE;
		}
		IScope result = doCreateConstructorScope(context, reference, session);
		return result;
	}
	
	protected IScope doCreateConstructorScope(final EObject context, EReference reference, final IFeatureScopeSession session) {
		final IScope delegateScope = getDelegate().getScope(context, reference);
		return new IScope() {

			public Iterable<IEObjectDescription> getAllElements() {
				Iterable<IEObjectDescription> original = delegateScope.getAllElements();
				return createFeatureDescriptions(original);
			}

			protected Iterable<IEObjectDescription> createFeatureDescriptions(Iterable<IEObjectDescription> original) {
				Iterable<IEObjectDescription> result = transform(original,
						new Function<IEObjectDescription, IEObjectDescription>() {
							public IEObjectDescription apply(IEObjectDescription from) {
								JvmConstructor constructor = (JvmConstructor) from.getEObjectOrProxy();
								if (constructor.eIsProxy()) {
									EObject resolved = EcoreUtil.resolve(constructor, context);
									if (resolved instanceof JvmConstructor)
										constructor = (JvmConstructor) resolved;
								}
								boolean visible = session.isVisible(constructor);
								ConstructorDescription result = new ConstructorDescription(from.getName(), constructor, CONSTRUCTOR_BUCKET, visible);
								return result;
							}
						});
				return result;
			}

			public Iterable<IEObjectDescription> getElements(EObject object) {
				Iterable<IEObjectDescription> original = delegateScope.getElements(object);
				return createFeatureDescriptions(original);
			}

			public Iterable<IEObjectDescription> getElements(QualifiedName name) {
				Iterable<IEObjectDescription> original = delegateScope.getElements(name);
				return createFeatureDescriptions(original);
			}

			public IEObjectDescription getSingleElement(EObject object) {
				Iterable<IEObjectDescription> elements = getElements(object);
				return (isEmpty(elements)) ? null : elements.iterator().next();
			}

			public IEObjectDescription getSingleElement(QualifiedName name) {
				throw new UnsupportedOperationException();
			}

		};
	}
	
	public boolean isConstructorCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
	}
	
}
