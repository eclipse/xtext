package org.eclipse.xtext.lexer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IgnoreCaseLexerTestLanguageFacetType  extends AbstractFacetType<IgnoreCaseLexerTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<IgnoreCaseLexerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IgnoreCaseLexerTestLanguageFacetConfiguration>>("org.eclipse.xtext.lexer.IgnoreCaseLexerTestLanguage");

	public IgnoreCaseLexerTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.lexer.IgnoreCaseLexerTestLanguage", "IgnoreCaseLexerTestLanguage");
		org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
