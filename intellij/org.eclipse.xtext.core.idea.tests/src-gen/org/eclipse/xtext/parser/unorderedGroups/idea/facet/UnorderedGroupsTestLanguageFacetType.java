package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class UnorderedGroupsTestLanguageFacetType  extends AbstractFacetType<UnorderedGroupsTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.unorderedGroups.UnorderedGroupsTestLanguage";

	public static  FacetTypeId<Facet<UnorderedGroupsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<UnorderedGroupsTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public UnorderedGroupsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "UnorderedGroupsTestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
