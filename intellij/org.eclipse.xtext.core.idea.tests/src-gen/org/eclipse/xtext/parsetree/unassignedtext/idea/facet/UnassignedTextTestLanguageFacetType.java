package org.eclipse.xtext.parsetree.unassignedtext.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class UnassignedTextTestLanguageFacetType  extends AbstractFacetType<UnassignedTextTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.unassignedtext.UnassignedTextTestLanguage";

	public static  FacetTypeId<Facet<UnassignedTextTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<UnassignedTextTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public UnassignedTextTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "UnassignedTextTestLanguage");
		org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
