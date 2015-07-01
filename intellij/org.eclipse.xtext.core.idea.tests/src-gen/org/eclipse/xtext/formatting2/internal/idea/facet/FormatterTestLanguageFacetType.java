package org.eclipse.xtext.formatting2.internal.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class FormatterTestLanguageFacetType  extends AbstractFacetType<FormatterTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<FormatterTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<FormatterTestLanguageFacetConfiguration>>("org.eclipse.xtext.formatting2.internal.FormatterTestLanguage");

	public FormatterTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.formatting2.internal.FormatterTestLanguage", "FormatterTestLanguage");
		org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
