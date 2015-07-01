package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class AbstractIgnoreCaseLinkingTestLanguageFacetType  extends AbstractFacetType<AbstractIgnoreCaseLinkingTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<AbstractIgnoreCaseLinkingTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractIgnoreCaseLinkingTestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguage");

	public AbstractIgnoreCaseLinkingTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguage", "AbstractIgnoreCaseLinkingTestLanguage");
		org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
