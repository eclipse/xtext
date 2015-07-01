package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleExpressionsTestLanguageFacetType  extends AbstractFacetType<SimpleExpressionsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SimpleExpressionsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SimpleExpressionsTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage");

	public SimpleExpressionsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage", "SimpleExpressionsTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
