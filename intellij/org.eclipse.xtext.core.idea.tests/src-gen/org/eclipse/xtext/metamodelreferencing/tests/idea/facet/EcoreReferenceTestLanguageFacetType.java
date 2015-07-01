package org.eclipse.xtext.metamodelreferencing.tests.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EcoreReferenceTestLanguageFacetType  extends AbstractFacetType<EcoreReferenceTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage";

	public static  FacetTypeId<Facet<EcoreReferenceTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EcoreReferenceTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public EcoreReferenceTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EcoreReferenceTestLanguage");
		org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
