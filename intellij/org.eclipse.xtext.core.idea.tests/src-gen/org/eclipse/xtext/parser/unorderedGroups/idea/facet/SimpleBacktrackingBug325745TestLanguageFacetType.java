package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleBacktrackingBug325745TestLanguageFacetType  extends AbstractFacetType<SimpleBacktrackingBug325745TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SimpleBacktrackingBug325745TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SimpleBacktrackingBug325745TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.unorderedGroups.SimpleBacktrackingBug325745TestLanguage");

	public SimpleBacktrackingBug325745TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.unorderedGroups.SimpleBacktrackingBug325745TestLanguage", "SimpleBacktrackingBug325745TestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
