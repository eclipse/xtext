/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ReferenceSearchResultEvents {

	public static class Added extends SearchResultEvent {
		private static final long serialVersionUID = 591474718721135067L;
		private final IReferenceDescription referenceDescription;

		public Added(ISearchResult searchResult, IReferenceDescription referenceDescription) {
			super(searchResult);
			this.referenceDescription = referenceDescription;
		}

		public IReferenceDescription getReferenceDescription() {
			return referenceDescription;
		}
	}
	
	public static class Removed extends SearchResultEvent {
		private static final long serialVersionUID = 1L;
		private final IReferenceDescription[] removedDescriptions;
		
		public Removed(ISearchResult searchResult, IReferenceDescription[] removedDescriptions) {
			super(searchResult);
			this.removedDescriptions = removedDescriptions;
		}
		
		public IReferenceDescription[] getRemovedDescriptions() {
			return removedDescriptions;
		}
	}

	public static class Finish extends SearchResultEvent {

		private static final long serialVersionUID = 114654633086769996L;

		public Finish(ISearchResult result) {
			super(result);
		}
	}

	public static class Reset extends SearchResultEvent {
		private static final long serialVersionUID = 1244392086001617021L;

		public Reset(ReferenceSearchResult referenceSearchResult) {
			super(referenceSearchResult);
		}
	}

}