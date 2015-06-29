package org.eclipse.xtext.parser.indentation.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IndentationAwareTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public IndentationAwareTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "IndentationAwareTestLanguage");
		org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
