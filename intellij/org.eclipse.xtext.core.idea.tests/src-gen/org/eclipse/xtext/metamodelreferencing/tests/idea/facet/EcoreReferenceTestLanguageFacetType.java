package org.eclipse.xtext.metamodelreferencing.tests.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EcoreReferenceTestLanguageFacetType  extends AbstractFacetType<EcoreReferenceTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<EcoreReferenceTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EcoreReferenceTestLanguageFacetConfiguration>>("org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage");

	public EcoreReferenceTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage", "EcoreReferenceTestLanguage");
		org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
