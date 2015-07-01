package org.eclipse.xtext.parser.datatyperules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class DatatypeRulesTestLanguageFacetType  extends AbstractFacetType<DatatypeRulesTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<DatatypeRulesTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<DatatypeRulesTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage");

	public DatatypeRulesTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage", "DatatypeRulesTestLanguage");
		org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
