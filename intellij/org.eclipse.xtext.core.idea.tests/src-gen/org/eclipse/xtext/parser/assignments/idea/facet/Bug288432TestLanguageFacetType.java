package org.eclipse.xtext.parser.assignments.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug288432TestLanguageFacetType  extends AbstractFacetType<Bug288432TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug288432TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug288432TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.assignments.Bug288432TestLanguage");

	public Bug288432TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.assignments.Bug288432TestLanguage", "Bug288432TestLanguage");
		org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
