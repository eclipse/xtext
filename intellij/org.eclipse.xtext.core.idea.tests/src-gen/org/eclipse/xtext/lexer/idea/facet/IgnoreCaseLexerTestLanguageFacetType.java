package org.eclipse.xtext.lexer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IgnoreCaseLexerTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.lexer.IgnoreCaseLexerTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public IgnoreCaseLexerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "IgnoreCaseLexerTestLanguage");
		org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
