/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.query;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.ui.search.ElementQuerySpecification;
import org.eclipse.jdt.ui.search.IMatchPresentation;
import org.eclipse.jdt.ui.search.IQueryParticipant;
import org.eclipse.jdt.ui.search.ISearchRequestor;
import org.eclipse.jdt.ui.search.QuerySpecification;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class QueryParticipant implements IQueryParticipant {

	private final IResourceDescriptions resourceDescriptions;

	private final TypeURIHelper typeURIHelper;

	private final UIParticipant uiParticipant;
	
	@Inject
	private Provider<JavaSearchHelper> javaSearchHelperProvider;

	@Inject
	public QueryParticipant(IResourceDescriptions resourceDescriptions, UIParticipant uiParticipant) {
		this.resourceDescriptions = resourceDescriptions;
		this.uiParticipant = uiParticipant;
		typeURIHelper = new TypeURIHelper();
	}

	public void search(ISearchRequestor requestor, QuerySpecification query, IProgressMonitor monitor)
			throws CoreException {
		if (!isHandled(query)) {
			return;
		}
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		try {
			if (query instanceof ElementQuerySpecification) {
				ElementQuerySpecification elementQuery = (ElementQuerySpecification) query;
				IJavaElement element = elementQuery.getElement();
				final URI uri = typeURIHelper.getFullURI(element);
				if (uri != null)
					createSearchHelper(requestor).search(uri, monitor);
			}
		} finally {
			monitor.done();
		}
	}

	protected JavaSearchHelper createSearchHelper(ISearchRequestor requestor) {
		JavaSearchHelper searchHelper = javaSearchHelperProvider.get();
		searchHelper.init(requestor, resourceDescriptions);
		return searchHelper;
	}

	public int estimateTicks(QuerySpecification query) {
		if (isHandled(query)) {
			return 250;
		}
		return 0;
	}

	public IMatchPresentation getUIParticipant() {
		return uiParticipant;
	}

	private boolean isHandled(QuerySpecification query) {
		switch (query.getLimitTo()) {
			case IJavaSearchConstants.REFERENCES:
			case IJavaSearchConstants.ALL_OCCURRENCES: {
				break;
			}
			default: {
				return false;
			}
		}
		if (query instanceof ElementQuerySpecification) {
			IJavaElement element = ((ElementQuerySpecification) query).getElement();
			return element.getElementType() == IJavaElement.TYPE || element.getElementType() == IJavaElement.FIELD
					|| element.getElementType() == IJavaElement.METHOD;
		}
		//		if (query instanceof PatternQuerySpecification) {
		//			PatternQuerySpecification patternQuery = (PatternQuerySpecification) query;
		//			switch (patternQuery.getSearchFor()) {
		//				case IJavaSearchConstants.UNKNOWN:
		//				case IJavaSearchConstants.TYPE:
		//				case IJavaSearchConstants.CLASS:
		//				case IJavaSearchConstants.CLASS_AND_INTERFACE:
		//				case IJavaSearchConstants.CLASS_AND_ENUM: {
		//					return true;
		//				}
		//			}
		//		}
		return false;
	}
}
