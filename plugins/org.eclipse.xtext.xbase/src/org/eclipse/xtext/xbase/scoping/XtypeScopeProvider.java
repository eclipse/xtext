/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import static org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class XtypeScopeProvider extends AbstractScopeProvider {

	public IScope getScope(EObject context, EReference reference) {
		if (reference == TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE) {
			return getJvmTypeScope(context,reference);
		}
		return getDelegate().getScope(context, reference);
	}
	
	protected IScope getJvmTypeScope(EObject context, EReference reference) {
		return getDelegate().getScope(context, reference);
	}

	@Inject
	@Named(NAMED_DELEGATE)
	private IScopeProvider delegate;
	
	protected IScope delegateGetScope(EObject context, EReference reference) {
		return getDelegate().getScope(context, reference);
	}

	public void setDelegate(IScopeProvider delegate) {
		this.delegate = delegate;
	}

	public IScopeProvider getDelegate() {
		return delegate;
	}

}
