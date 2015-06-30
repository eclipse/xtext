package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class AssignmentFinderTestLanguageFacetType  extends AbstractFacetType<AssignmentFinderTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.serializer.AssignmentFinderTestLanguage";

	public static  FacetTypeId<Facet<AssignmentFinderTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AssignmentFinderTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public AssignmentFinderTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "AssignmentFinderTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
