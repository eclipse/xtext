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