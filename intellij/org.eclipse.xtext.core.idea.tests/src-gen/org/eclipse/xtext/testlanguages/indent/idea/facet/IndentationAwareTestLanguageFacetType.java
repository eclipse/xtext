package org.eclipse.xtext.testlanguages.indent.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IndentationAwareTestLanguageFacetType  extends AbstractFacetType<IndentationAwareTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<IndentationAwareTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IndentationAwareTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguage");

	public IndentationAwareTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguage", "IndentationAwareTestLanguage");
		org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
