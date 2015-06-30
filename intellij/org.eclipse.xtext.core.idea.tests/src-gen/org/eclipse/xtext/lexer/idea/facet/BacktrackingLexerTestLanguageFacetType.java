package org.eclipse.xtext.lexer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class BacktrackingLexerTestLanguageFacetType  extends AbstractFacetType<BacktrackingLexerTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage";

	public static  FacetTypeId<Facet<BacktrackingLexerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<BacktrackingLexerTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public BacktrackingLexerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "BacktrackingLexerTestLanguage");
		org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
