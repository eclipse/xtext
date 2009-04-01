/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.crossref;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.crossref.impl.SimpleNestedScope;
import org.eclipse.xtext.xtend.AbstractXtendService;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractXtendScopeProvider extends AbstractXtendService implements IScopeProvider {

	private static Logger log = Logger.getLogger(AbstractXtendScopeProvider.class);

	private static final String SCOPE_EXTENSION_PREFIX = "scope_";

	public IScope getScope(EObject context, final EReference reference) {
		try {
			List<IScopedElement> scopedElements = invokeExtension(extensionName(context, reference), Collections
					.singletonList(context));
			final Collection<String> names = new HashSet<String>(scopedElements.size());
			return new SimpleNestedScope(Iterables.filter(scopedElements, new Predicate<IScopedElement>() {
				public boolean apply(IScopedElement param) {
					boolean result = reference.getEReferenceType().isSuperTypeOf(param.element().eClass());
					if (result) {
						result = names.add(param.name());
					}
					return result;
				}
			}));
		}
		catch (Throwable e) {
			log.error("Error invoking scope extension", e);
		}
		return null;
	}

	private String extensionName(EObject context, EReference reference) {
		return SCOPE_EXTENSION_PREFIX + reference.getName();
	}

}
