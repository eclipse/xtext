package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug296889ExTestLanguageFacetType  extends AbstractFacetType<Bug296889ExTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug296889ExTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug296889ExTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage");

	public Bug296889ExTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage", "Bug296889ExTestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
