package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ExBacktrackingBug325745TestLanguageFacetType  extends AbstractFacetType<ExBacktrackingBug325745TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ExBacktrackingBug325745TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ExBacktrackingBug325745TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.unorderedGroups.ExBacktrackingBug325745TestLanguage");

	public ExBacktrackingBug325745TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.unorderedGroups.ExBacktrackingBug325745TestLanguage", "ExBacktrackingBug325745TestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
