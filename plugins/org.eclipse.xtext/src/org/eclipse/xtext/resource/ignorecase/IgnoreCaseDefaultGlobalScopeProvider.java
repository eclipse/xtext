/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseDefaultGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Override
	protected IScope createContainerScope(IScope parent, IContainer container, EReference reference) {
		if (container instanceof IIgnoreCaseContainer)
			return new IgnoreCaseContainerBasedScope(parent, reference, (IIgnoreCaseContainer) container);
		return super.createContainerScope(parent, container, reference);
	}
	
}
