package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class PartialParserTestLanguageFacetType  extends AbstractFacetType<PartialParserTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<PartialParserTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<PartialParserTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.PartialParserTestLanguage");

	public PartialParserTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.PartialParserTestLanguage", "PartialParserTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
