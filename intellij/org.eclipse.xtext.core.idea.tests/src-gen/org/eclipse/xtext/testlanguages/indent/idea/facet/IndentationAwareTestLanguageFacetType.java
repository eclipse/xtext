package org.eclipse.xtext.testlanguages.indent.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IndentationAwareTestLanguageFacetType  extends AbstractFacetType<IndentationAwareTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguage";

	public static  FacetTypeId<Facet<IndentationAwareTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IndentationAwareTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public IndentationAwareTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "IndentationAwareTestLanguage");
		org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
