package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug378967TestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug378967TestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug378967TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug378967TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
