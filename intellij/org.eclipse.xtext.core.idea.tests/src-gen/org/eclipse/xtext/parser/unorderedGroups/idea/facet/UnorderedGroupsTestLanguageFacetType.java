package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class UnorderedGroupsTestLanguageFacetType  extends AbstractFacetType<UnorderedGroupsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<UnorderedGroupsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<UnorderedGroupsTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.unorderedGroups.UnorderedGroupsTestLanguage");

	public UnorderedGroupsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.unorderedGroups.UnorderedGroupsTestLanguage", "UnorderedGroupsTestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
