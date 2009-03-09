/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.crossref;

import static org.eclipse.xtext.util.CollectionUtils.filter;
import static org.eclipse.xtext.util.CollectionUtils.nextOrNull;
import static org.eclipse.xtext.util.CollectionUtils.list;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
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

	public IScope getScope(EObject context, final EClass type) {
		throw new UnsupportedOperationException();
//		try {
//			List<IScopedElement> scopedElements = invokeExtension(extensionName(context, type),
//					Collections.singletonList(context));
//			final Collection<String> names = new HashSet<String>(scopedElements.size());
//			return new XtendScope(list(filter(scopedElements, new Filter<IScopedElement>() {
//				public boolean matches(IScopedElement param) {
//					boolean result = type.isSuperTypeOf(param.element().eClass());
//					if (result) {
//						result = names.add(param.name());
//					}
//					return result;
//				}
//			})));
//		}
//		catch (Throwable e) {
//			log.error("Error invoking scope extension", e);
//		}
//		return null;
	}

	public IScope getScope(EObject context, final EReference reference) {
		try {
			List<IScopedElement> scopedElements = invokeExtension(extensionName(context, reference), Collections
					.singletonList(context));
			final Collection<String> names = new HashSet<String>(scopedElements.size());
			return new XtendScope(list(filter(scopedElements, new Filter<IScopedElement>() {
				public boolean matches(IScopedElement param) {
					boolean result = reference.getEReferenceType().isSuperTypeOf(param.element().eClass());
					if (result) {
						result = names.add(param.name());
					}
					return result;
				}
			})));
		}
		catch (Throwable e) {
			log.error("Error invoking scope extension", e);
		}
		return null;
	}

	private String extensionName(EObject context, EReference reference) {
		return SCOPE_EXTENSION_PREFIX + reference.getName();
	}

	public static class XtendScope implements IScope {

		private final Iterable<IScopedElement> scopedElements;

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
			Iterable<IScopedElement> allMatches = filter(scopedElements, new Filter<IScopedElement>() {
				public boolean matches(IScopedElement param) {
					return param.element().equals(element);
				}
			});
			return nextOrNull(allMatches);
		}

	}
}
