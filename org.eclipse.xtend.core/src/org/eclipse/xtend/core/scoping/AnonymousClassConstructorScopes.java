/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.scoping.batch.ConstructorScopes;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AnonymousClassConstructorScopes extends ConstructorScopes {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Override
	public IScope createConstructorScope(EObject context, EReference reference, IFeatureScopeSession session,
			IResolvedTypes resolvedTypes) {
		if (context instanceof XConstructorCall) {
			EObject container = context.eContainer();
			if (container instanceof AnonymousClass) {
				JvmGenericType inferredType = associations.getInferredType((AnonymousClass) container);
				if (inferredType != null) {
					return createAnonymousClassConstructorScope(inferredType, context, session);
				}
			}
		}
		return super.createConstructorScope(context, reference, session, resolvedTypes);
	}

	
	
}
