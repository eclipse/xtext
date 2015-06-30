package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ExBacktrackingBug325745TestLanguageFacetType  extends AbstractFacetType<ExBacktrackingBug325745TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.unorderedGroups.ExBacktrackingBug325745TestLanguage";

	public static  FacetTypeId<Facet<ExBacktrackingBug325745TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ExBacktrackingBug325745TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public ExBacktrackingBug325745TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ExBacktrackingBug325745TestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
