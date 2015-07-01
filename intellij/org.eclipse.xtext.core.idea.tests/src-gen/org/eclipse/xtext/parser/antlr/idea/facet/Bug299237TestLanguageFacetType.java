package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug299237TestLanguageFacetType  extends AbstractFacetType<Bug299237TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug299237TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug299237TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug299237TestLanguage");

	public Bug299237TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug299237TestLanguage", "Bug299237TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
