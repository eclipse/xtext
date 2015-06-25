package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ExUnorderedGroupsTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.unorderedGroups.ExUnorderedGroupsTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public ExUnorderedGroupsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ExUnorderedGroupsTestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
