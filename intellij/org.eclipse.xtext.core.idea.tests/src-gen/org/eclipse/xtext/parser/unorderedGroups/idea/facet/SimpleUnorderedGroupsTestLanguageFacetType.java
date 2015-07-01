package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleUnorderedGroupsTestLanguageFacetType  extends AbstractFacetType<SimpleUnorderedGroupsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SimpleUnorderedGroupsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SimpleUnorderedGroupsTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.unorderedGroups.SimpleUnorderedGroupsTestLanguage");

	public SimpleUnorderedGroupsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.unorderedGroups.SimpleUnorderedGroupsTestLanguage", "SimpleUnorderedGroupsTestLanguage");
		org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
