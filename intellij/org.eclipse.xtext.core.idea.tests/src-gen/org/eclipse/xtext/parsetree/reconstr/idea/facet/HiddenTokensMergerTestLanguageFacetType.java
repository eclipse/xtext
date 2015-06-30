package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class HiddenTokensMergerTestLanguageFacetType  extends AbstractFacetType<HiddenTokensMergerTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage";

	public static  FacetTypeId<Facet<HiddenTokensMergerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<HiddenTokensMergerTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public HiddenTokensMergerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "HiddenTokensMergerTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
