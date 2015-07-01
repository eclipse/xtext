package org.eclipse.xtext.parsetree.formatter.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class FormatterTestLanguageFacetType  extends AbstractFacetType<FormatterTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.formatter.FormatterTestLanguage";

	public static  FacetTypeId<Facet<FormatterTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<FormatterTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public FormatterTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "FormatterTestLanguage");
		org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
