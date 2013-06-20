/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferenceSearchResult implements ISearchResult, IAcceptor<IReferenceDescription> {

	private ReferenceQuery query;

	private List<IReferenceDescription> matchingReferences;

	private List<ISearchResultListener> listeners;

	protected ReferenceSearchResult(ReferenceQuery query) {
		this.query = query;
		matchingReferences = Lists.newArrayList();
		listeners = Lists.newArrayList();
	}

	public void addListener(ISearchResultListener l) {
		synchronized (listeners) {
			listeners.add(l);
		}
	}

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

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getLabel() {
		return query.getLabel();
	}

	public ISearchQuery getQuery() {
		return query;
	}

	public String getTooltip() {
		return getLabel();
	}

	public void accept(IReferenceDescription referenceDescription) {
		if(query.getFilter().apply(referenceDescription)) {
			matchingReferences.add(referenceDescription);
			fireEvent(new ReferenceSearchResultEvents.Added(this, referenceDescription));
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