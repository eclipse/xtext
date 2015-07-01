package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ExUnorderedGroupsTestLanguageFacetType  extends AbstractFacetType<ExUnorderedGroupsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ExUnorderedGroupsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ExUnorderedGroupsTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.unorderedGroups.ExUnorderedGroupsTestLanguage");

	public ExUnorderedGroupsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.unorderedGroups.ExUnorderedGroupsTestLanguage", "ExUnorderedGroupsTestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
