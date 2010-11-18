/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MultimapBasedScope;
import org.eclipse.xtext.scoping.impl.SimpleLocalScopeProvider;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseSimpleLocalScopeProvider extends SimpleLocalScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
		return new IgnoreCaseSelectorScope(super.getScope(context, reference));
	}
	
	@Override
	protected Multimap<QualifiedName, IEObjectDescription> toMap(EObject context, EReference reference) {
		TreeIterator<EObject> iterator = context.eResource().getAllContents();
		Multimap<QualifiedName, IEObjectDescription> result = LinkedHashMultimap.create();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (reference.getEReferenceType().isInstance(next)) {
				QualifiedName qualifiedName = getNameProvider().getFullyQualifiedName(next);
				QualifiedName key = qualifiedName.toLowerCase();
				if (key != null && !result.containsKey(key)) {
					IEObjectDescription description = createEObjectDescription(next, qualifiedName);
					if (description != null)
						result.put(key, description);
				}
			}
		}
		return result;
	}

	@Override
	protected IScope createScope(IScope parent, Multimap<QualifiedName, IEObjectDescription> map) {
		return new MultimapBasedScope(parent, map);
	}
}
