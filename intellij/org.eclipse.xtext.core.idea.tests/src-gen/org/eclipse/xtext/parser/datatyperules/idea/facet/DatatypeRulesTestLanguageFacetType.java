package org.eclipse.xtext.parser.datatyperules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class DatatypeRulesTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public DatatypeRulesTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "DatatypeRulesTestLanguage");
		org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
