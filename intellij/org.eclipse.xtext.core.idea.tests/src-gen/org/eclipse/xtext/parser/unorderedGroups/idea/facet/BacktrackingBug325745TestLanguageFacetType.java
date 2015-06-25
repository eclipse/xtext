package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class BacktrackingBug325745TestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public BacktrackingBug325745TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "BacktrackingBug325745TestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
