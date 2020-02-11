/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.query;


import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
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

	private final TypeURIHelper typeURIHelper;

	private final UIParticipant uiParticipant;
	
	private Provider<IResourceDescriptions> resourceDescriptionsProvider;
	
	@Inject
	private Provider<JavaSearchHelper> javaSearchHelperProvider;

	@Inject
	public QueryParticipant(Provider<IResourceDescriptions> resourceDescriptionsProvider, UIParticipant uiParticipant) {
		this.resourceDescriptionsProvider = resourceDescriptionsProvider;
		this.uiParticipant = uiParticipant;
		typeURIHelper = new TypeURIHelper();
	}

	@Override
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
		IResourceDescriptions descriptionsToSearch = resourceDescriptionsProvider.get();
		if(descriptionsToSearch.isEmpty()) {
			waitForBuild();
			descriptionsToSearch = resourceDescriptionsProvider.get();
		}
		searchHelper.init(requestor, descriptionsToSearch);
		return searchHelper;
	}
	
	protected void waitForBuild() {
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD,
						null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				return;
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	@Override
	public int estimateTicks(QuerySpecification query) {
		if (isHandled(query)) {
			return 250;
		}
		return 0;
	}

	@Override
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
