/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferenceSearchResult implements ISearchResult, IAcceptor<IReferenceDescription> {

	private ReferenceQuery query;

	private List<IReferenceDescription> matchingReferences;

	private List<ISearchResultListener> listeners;
	
	private Set<URI> removedURIs;

	protected ReferenceSearchResult(ReferenceQuery query) {
		this.query = query;
		matchingReferences = Lists.newArrayList();
		listeners = Lists.newArrayList();
		removedURIs = Sets.newHashSet();
	}

	@Override
	public void addListener(ISearchResultListener l) {
		synchronized (listeners) {
			listeners.add(l);
		}
	}

	@Override
	public void removeListener(ISearchResultListener l) {
		synchronized (listeners) {
			listeners.remove(l);
		}
	}

	void fireEvent(SearchResultEvent searchResultEvent) {
		synchronized (listeners) {
			for (ISearchResultListener listener : listeners) {
				listener.searchResultChanged(searchResultEvent);
			}
		}
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getLabel() {
		return String.format("%s - (%s %s)", //$NON-NLS-1$
				query.getLabel(), matchingReferences.size(), Messages.ReferenceSearchResult_Matches);
	}

	@Override
	public ISearchQuery getQuery() {
		return query;
	}

	@Override
	public String getTooltip() {
		return getLabel();
	}

	@Override
	public void accept(IReferenceDescription referenceDescription) {
		if (query.getFilter().apply(referenceDescription) && !removedURIs.contains(referenceDescription.getSourceEObjectUri())) {
			matchingReferences.add(referenceDescription);
			fireEvent(new ReferenceSearchResultEvents.Added(this, referenceDescription));
		}
	}

	public void remove(IReferenceDescription[] referenceDescriptions) {
		if (matchingReferences.removeAll(Arrays.asList(referenceDescriptions))) {
			//remember all URIs that have been removed by the user so when re-running
			//this search from history we don't show them again
			Arrays.stream(referenceDescriptions).map(d -> d.getSourceEObjectUri()).forEach(uri -> removedURIs.add(uri));
			fireEvent(new ReferenceSearchResultEvents.Removed(this, referenceDescriptions));
		}
	}

	public List<IReferenceDescription> getMatchingReferences() {
		return matchingReferences;
	}

	public void reset() {
		matchingReferences.clear();
		fireEvent(new ReferenceSearchResultEvents.Reset(this));
	}

	public void finish() {
		fireEvent(new ReferenceSearchResultEvents.Finish(this));
	}

}