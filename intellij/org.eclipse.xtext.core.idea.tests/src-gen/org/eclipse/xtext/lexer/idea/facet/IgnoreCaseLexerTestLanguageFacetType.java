package org.eclipse.xtext.lexer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IgnoreCaseLexerTestLanguageFacetType  extends AbstractFacetType<IgnoreCaseLexerTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.lexer.IgnoreCaseLexerTestLanguage";

	public static  FacetTypeId<Facet<IgnoreCaseLexerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IgnoreCaseLexerTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public IgnoreCaseLexerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "IgnoreCaseLexerTestLanguage");
		org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
