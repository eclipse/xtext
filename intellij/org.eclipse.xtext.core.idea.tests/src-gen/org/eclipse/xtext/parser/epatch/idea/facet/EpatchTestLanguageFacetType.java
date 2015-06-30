package org.eclipse.xtext.parser.epatch.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EpatchTestLanguageFacetType  extends AbstractFacetType<EpatchTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.epatch.EpatchTestLanguage";

	public static  FacetTypeId<Facet<EpatchTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EpatchTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public EpatchTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EpatchTestLanguage");
		org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
