package org.eclipse.xtext.parser.assignments.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug287184TestLanguageFacetType  extends AbstractFacetType<Bug287184TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug287184TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug287184TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.assignments.Bug287184TestLanguage");

	public Bug287184TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.assignments.Bug287184TestLanguage", "Bug287184TestLanguage");
		org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
