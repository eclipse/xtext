package org.eclipse.xtext.ui.core.editor.findrefs;

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * @author koehnlein - Initial contribution and API
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

}