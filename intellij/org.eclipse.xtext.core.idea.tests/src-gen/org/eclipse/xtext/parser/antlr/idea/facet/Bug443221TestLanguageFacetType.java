package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug443221TestLanguageFacetType  extends AbstractFacetType<Bug443221TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug443221TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug443221TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug443221TestLanguage");

	public Bug443221TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug443221TestLanguage", "Bug443221TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
