package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug301935TestLanguageFacetType  extends AbstractFacetType<Bug301935TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug301935TestLanguage";

	public static  FacetTypeId<Facet<Bug301935TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug301935TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug301935TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug301935TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
