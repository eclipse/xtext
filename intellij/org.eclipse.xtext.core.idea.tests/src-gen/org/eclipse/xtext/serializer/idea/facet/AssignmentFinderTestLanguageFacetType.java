package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class AssignmentFinderTestLanguageFacetType  extends AbstractFacetType<AssignmentFinderTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<AssignmentFinderTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AssignmentFinderTestLanguageFacetConfiguration>>("org.eclipse.xtext.serializer.AssignmentFinderTestLanguage");

	public AssignmentFinderTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.serializer.AssignmentFinderTestLanguage", "AssignmentFinderTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
