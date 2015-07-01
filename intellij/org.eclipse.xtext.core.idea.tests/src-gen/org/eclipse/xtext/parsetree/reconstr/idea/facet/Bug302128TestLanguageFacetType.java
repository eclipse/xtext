package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug302128TestLanguageFacetType  extends AbstractFacetType<Bug302128TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.reconstr.Bug302128TestLanguage";

	public static  FacetTypeId<Facet<Bug302128TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug302128TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug302128TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug302128TestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
