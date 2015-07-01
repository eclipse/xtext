package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class BacktrackingBug325745TestLanguageFacetType  extends AbstractFacetType<BacktrackingBug325745TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<BacktrackingBug325745TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<BacktrackingBug325745TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguage");

	public BacktrackingBug325745TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguage", "BacktrackingBug325745TestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
