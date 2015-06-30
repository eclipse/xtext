package org.eclipse.xtext.generator.ecore.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EcoreFragmentTestLanguageFacetType  extends AbstractFacetType<EcoreFragmentTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.generator.ecore.EcoreFragmentTestLanguage";

	public static  FacetTypeId<Facet<EcoreFragmentTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EcoreFragmentTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public EcoreFragmentTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EcoreFragmentTestLanguage");
		org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
