package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class AbstractIgnoreCaseLinkingTestLanguageFacetType  extends AbstractFacetType<AbstractIgnoreCaseLinkingTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguage";

	public static  FacetTypeId<Facet<AbstractIgnoreCaseLinkingTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractIgnoreCaseLinkingTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public AbstractIgnoreCaseLinkingTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "AbstractIgnoreCaseLinkingTestLanguage");
		org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
