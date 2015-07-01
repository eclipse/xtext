package org.eclipse.xtext.parsetree.formatter.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class FormatterTestLanguageFacetType  extends AbstractFacetType<FormatterTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<FormatterTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<FormatterTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.formatter.FormatterTestLanguage");

	public FormatterTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.formatter.FormatterTestLanguage", "FormatterTestLanguage");
		org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
