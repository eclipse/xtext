package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IgnoreCaseImportsTestLanguageFacetType  extends AbstractFacetType<IgnoreCaseImportsTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.IgnoreCaseImportsTestLanguage";

	public static  FacetTypeId<Facet<IgnoreCaseImportsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IgnoreCaseImportsTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public IgnoreCaseImportsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "IgnoreCaseImportsTestLanguage");
		org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
