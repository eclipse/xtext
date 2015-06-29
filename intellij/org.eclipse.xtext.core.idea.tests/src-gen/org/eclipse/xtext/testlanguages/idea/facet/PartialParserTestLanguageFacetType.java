package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class PartialParserTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.PartialParserTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public PartialParserTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "PartialParserTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
