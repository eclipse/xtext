/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class IgnoreCaseImportedNamespaceAwareScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		final IScope scope = super.getScope(context, reference);
		return new IgnoreCaseSelectorScope(scope);
	}

	@Override
	protected Multimap<QualifiedName, IEObjectDescription> toMap(Iterable<IEObjectDescription> scopedElementsFor) {
		Multimap<QualifiedName, IEObjectDescription> result = LinkedHashMultimap.create();
		for (IEObjectDescription ieObjectDescription : scopedElementsFor) {
			QualifiedName key = ieObjectDescription.getName().toLowerCase();
			if (!result.containsKey(key))
				result.put(key, ieObjectDescription);
		}
		return result;
	}
	
	@Override
	protected ImportNormalizer createImportedNamespaceResolver(String namespace) {
		return super.createImportedNamespaceResolver(namespace.toLowerCase());
	}
}
