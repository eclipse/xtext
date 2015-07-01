package org.eclipse.xtext.parser.assignments.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class AssignmentsTestLanguageFacetType  extends AbstractFacetType<AssignmentsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<AssignmentsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AssignmentsTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage");

	public AssignmentsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage", "AssignmentsTestLanguage");
		org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
