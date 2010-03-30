/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.google.common.base.Predicate;

public class ArithmeticsScopeProvider extends AbstractDeclarativeScopeProvider {
	
	/**
	 * we delegate to the default but filter out all descriptions with a qualified name (i.e. with '.' in the name)
	 */
	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope scope = super.getScope(context, reference);
		return new FilteringScope(scope,
				new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						return input!=null && input.getName()!=null && input.getName().indexOf('.')==-1;
					};
				});
	}

}
