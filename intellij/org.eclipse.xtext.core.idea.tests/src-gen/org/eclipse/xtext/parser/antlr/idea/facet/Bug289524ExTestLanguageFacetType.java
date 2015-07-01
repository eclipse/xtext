package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug289524ExTestLanguageFacetType  extends AbstractFacetType<Bug289524ExTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug289524ExTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug289524ExTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug289524ExTestLanguage");

	public Bug289524ExTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug289524ExTestLanguage", "Bug289524ExTestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
