package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug443221TestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug443221TestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug443221TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug443221TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
