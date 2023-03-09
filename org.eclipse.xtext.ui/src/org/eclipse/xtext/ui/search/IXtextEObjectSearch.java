/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.search;

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
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IXtextEObjectSearch.Default.class)
public interface IXtextEObjectSearch {

	Iterable<IEObjectDescription> findMatches(String searchPattern, String typeSearchPattern);

	public static class Default implements IXtextEObjectSearch {
		@Inject
		private IResourceDescriptions resourceDescriptions;

		@Override
		public Iterable<IEObjectDescription> findMatches(final String searchPattern, final String typeSearchPattern) {
			return Iterables.filter(getSearchScope(), getSearchPredicate(searchPattern, typeSearchPattern));
		}

		protected Predicate<IEObjectDescription> getSearchPredicate(final String stringPattern,
				final String typeStringPattern) {
			final Collection<String> namespaceDelimiters = IXtextSearchFilter.Registry.allNamespaceDelimiters();			
			final SearchPattern searchPattern = new SearchPattern();
			searchPattern.setPattern(stringPattern);
			final SearchPattern typeSearchPattern = new SearchPattern();
			typeSearchPattern.setPattern(typeStringPattern);
			final Collection<IXtextSearchFilter> registeredFilters = IXtextSearchFilter.Registry.allFilters();
			return new Predicate<IEObjectDescription>() {
				@Override
				public boolean apply(IEObjectDescription input) {
					if (isNameMatches(searchPattern, input, namespaceDelimiters)
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

		protected boolean isNameMatches(SearchPattern searchPattern, IEObjectDescription eObjectDescription, Collection<String> namespaceDelimiters) {
			String qualifiedName = eObjectDescription.getQualifiedName().toString();
			if (qualifiedName!=null) {
				if(searchPattern.matches(qualifiedName)) {
					return true;
				}
				for(String namespaceDelimiter : namespaceDelimiters) {
					int index = qualifiedName.lastIndexOf(namespaceDelimiter); 
					if(index!=-1 && searchPattern.matches(qualifiedName.substring(index+1))) {
						return true;
					}
				}	
			}
			return false;
		}
		
		protected Iterable<IEObjectDescription> getSearchScope() {
			return Iterables.concat(Iterables.transform(getResourceDescriptions().getAllResourceDescriptions(),
					new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
						@Override
						public Iterable<IEObjectDescription> apply(IResourceDescription from) {
							return from.getExportedObjects();
						}
					}));
		}

		public void setResourceDescriptions(IResourceDescriptions resourceDescriptions) {
			this.resourceDescriptions = resourceDescriptions;
		}

		public IResourceDescriptions getResourceDescriptions() {
			return resourceDescriptions;
		}

	}
}