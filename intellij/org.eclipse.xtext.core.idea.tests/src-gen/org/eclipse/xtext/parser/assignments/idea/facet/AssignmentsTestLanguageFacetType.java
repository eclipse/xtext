package org.eclipse.xtext.parser.assignments.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class AssignmentsTestLanguageFacetType  extends AbstractFacetType<AssignmentsTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage";

	public static  FacetTypeId<Facet<AssignmentsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AssignmentsTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public AssignmentsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "AssignmentsTestLanguage");
		org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
