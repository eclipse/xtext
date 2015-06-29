package org.eclipse.xtext.parser.assignments.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug287184TestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.assignments.Bug287184TestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug287184TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug287184TestLanguage");
		org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
