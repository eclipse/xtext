package org.eclipse.xtext.generator.ecore.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SubTestLanguageFacetType  extends AbstractFacetType<SubTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.generator.ecore.SubTestLanguage";

	public static  FacetTypeId<Facet<SubTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SubTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public SubTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SubTestLanguage");
		org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
