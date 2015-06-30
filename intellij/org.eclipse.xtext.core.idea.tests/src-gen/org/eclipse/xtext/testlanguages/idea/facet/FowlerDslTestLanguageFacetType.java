package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class FowlerDslTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.FowlerDslTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public FowlerDslTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "FowlerDslTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
