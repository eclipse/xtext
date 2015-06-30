package org.eclipse.xtext.metamodelreferencing.tests.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class MultiGenMMTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public MultiGenMMTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "MultiGenMMTestLanguage");
		org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
