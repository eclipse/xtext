package org.eclipse.xtext.ui.core.editor.findrefs;

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.SearchResultEvent;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferenceAdded extends SearchResultEvent {
	private static final long serialVersionUID = 591474718721135067L;

	ReferenceAdded(ISearchResult searchResult) {
		super(searchResult);
	}
	
	
}