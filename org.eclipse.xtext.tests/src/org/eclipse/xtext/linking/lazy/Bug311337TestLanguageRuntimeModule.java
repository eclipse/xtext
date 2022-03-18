/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.lazy.bug311337.Child;
import org.eclipse.xtext.linking.lazy.bug311337.Definition;
import org.eclipse.xtext.linking.lazy.bug311337.NestedRef;
import org.eclipse.xtext.linking.lazy.bug311337.Reference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleLocalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class Bug311337TestLanguageRuntimeModule extends org.eclipse.xtext.linking.lazy.AbstractBug311337TestLanguageRuntimeModule {

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return MyDslScopeProvider.class;
	}
	
	public void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(com.google.inject.name.Names.named("org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.delegate")).to(SimpleLocalScopeProvider.class);
	}
	
	static public class MyDslScopeProvider extends AbstractDeclarativeScopeProvider {

	    public IScope scope_Reference_refChild(NestedRef context,
	            EReference ref) {
	        EList<Child> childList = null;

	        Child child = context.getLeft().getRefChild();
	        childList = child.getLink().getChild();

	        IScope newScope = Scopes.scopeFor(childList);
	        return newScope;

	    }

	    public IScope scope_Reference_refChild(Reference context, EReference ref) {

	        Definition localClass = null;
	        EList<Child> childList = null;
	        localClass = EcoreUtil2.getContainerOfType(context, Definition.class);  
	        childList = localClass.getChild();

	        IScope newScope = Scopes.scopeFor(childList);
	        return newScope;
	    }

	}
}
