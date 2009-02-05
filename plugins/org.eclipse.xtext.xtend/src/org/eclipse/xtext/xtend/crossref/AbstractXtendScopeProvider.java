/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.crossref;

import static org.eclipse.xtext.util.CollectionUtils.filter;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.xtend.AbstractXtendService;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractXtendScopeProvider extends AbstractXtendService implements IScopeProvider {

	private static Logger log = Logger.getLogger(AbstractXtendScopeProvider.class);

	private static final String SCOPE_EXTENSION_PREFIX = "scope_";

	public IScope getScope(EObject context, EReference reference) {
		try {
			List<IScopedElement> scopedElements = invokeExtension(extensionName(context, reference), Collections
					.singletonList(context));
			// TODO: filter elements
			return new XtendScope(scopedElements);
		}
		catch (Throwable e) {
			log.error("Error invoking scope extension", e);
		}
		return null;
	}

	private String extensionName(EObject context, EReference reference) {
		return SCOPE_EXTENSION_PREFIX + reference.getName();
	}

	private class XtendScope implements IScope {

		private Iterable<IScopedElement> scopedElements;

		public XtendScope(List<IScopedElement> scopedElements) {
			this.scopedElements = scopedElements;
		}

		public Iterable<IScopedElement> getAllContents() {
			return scopedElements;
		}

		public Iterable<IScopedElement> getContents() {
			return scopedElements;
		}

		public IScope getOuterScope() {
			return null;
		}

		public IScopedElement getScopedElement(final EObject element) {
			Iterator<IScopedElement> matchesIterator = filter(scopedElements, new Filter<IScopedElement>() {
				public boolean matches(IScopedElement param) {
					return param.element().equals(element);
				}
			}).iterator();
			return (matchesIterator.hasNext()) ? matchesIterator.next() : null;
		}

	}
}
