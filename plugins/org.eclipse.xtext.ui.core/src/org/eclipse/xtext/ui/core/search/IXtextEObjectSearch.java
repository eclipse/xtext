/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.search;

import java.util.Collection;

import org.eclipse.ui.dialogs.SearchPattern;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(IXtextEObjectSearch.Default.class)
public interface IXtextEObjectSearch {

	Iterable<IEObjectDescription> findMatches(String searchPattern, String typeSearchPattern);

	public static class Default implements IXtextEObjectSearch {
		@Inject
		protected IResourceDescriptions resourceDescriptions;

		public Iterable<IEObjectDescription> findMatches(final String searchPattern, final String typeSearchPattern) {
			return Iterables.filter(getSearchScope(), getSearchPredicate(searchPattern, typeSearchPattern));
		}

		protected Predicate<IEObjectDescription> getSearchPredicate(final String stringPattern,
				final String typeStringPattern) {
			final SearchPattern searchPattern = new SearchPattern();
			searchPattern.setPattern(stringPattern);
			final SearchPattern typeSearchPattern = new SearchPattern();
			typeSearchPattern.setPattern(typeStringPattern);
			final Collection<IXtextSearchFilter> registeredFilters = IXtextSearchFilter.Registry.allRegisteredFilters();
			return new Predicate<IEObjectDescription>() {
				public boolean apply(IEObjectDescription input) {
					if (searchPattern.matches(input.getQualifiedName())
							&& typeSearchPattern.matches(input.getEClass().getName())) {
						for (IXtextSearchFilter xtextSearchFilter : registeredFilters) {
							if (xtextSearchFilter.reject(input)) {
								return false;
							}
						}
						return true;
					}
					return false;
				}
			};
		}

		protected Iterable<IEObjectDescription> getSearchScope() {
			return Iterables.concat(Iterables.transform(resourceDescriptions.getAllResourceDescriptions(),
					new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
						public Iterable<IEObjectDescription> apply(IResourceDescription from) {
							return from.getExportedObjects();
						}
					}));
		}

	}
}