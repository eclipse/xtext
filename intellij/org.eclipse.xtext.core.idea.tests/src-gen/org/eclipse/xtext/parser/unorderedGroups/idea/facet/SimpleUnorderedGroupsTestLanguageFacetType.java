package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleUnorderedGroupsTestLanguageFacetType  extends AbstractFacetType<SimpleUnorderedGroupsTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.unorderedGroups.SimpleUnorderedGroupsTestLanguage";

	public static  FacetTypeId<Facet<SimpleUnorderedGroupsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SimpleUnorderedGroupsTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public SimpleUnorderedGroupsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SimpleUnorderedGroupsTestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
