package org.eclipse.xtext.metamodelreferencing.tests.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class MetamodelRefTestLanguageFacetType  extends AbstractFacetType<MetamodelRefTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguage";

	public static  FacetTypeId<Facet<MetamodelRefTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<MetamodelRefTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public MetamodelRefTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "MetamodelRefTestLanguage");
		org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
