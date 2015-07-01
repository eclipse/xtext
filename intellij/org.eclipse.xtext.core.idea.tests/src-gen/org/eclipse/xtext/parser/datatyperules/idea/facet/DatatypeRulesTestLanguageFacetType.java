package org.eclipse.xtext.parser.datatyperules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class DatatypeRulesTestLanguageFacetType  extends AbstractFacetType<DatatypeRulesTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage";

	public static  FacetTypeId<Facet<DatatypeRulesTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<DatatypeRulesTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public DatatypeRulesTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "DatatypeRulesTestLanguage");
		org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
