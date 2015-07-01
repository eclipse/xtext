package org.eclipse.xtext.metamodelreferencing.tests.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class MetamodelRefTestLanguageFacetType  extends AbstractFacetType<MetamodelRefTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<MetamodelRefTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<MetamodelRefTestLanguageFacetConfiguration>>("org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguage");

	public MetamodelRefTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguage", "MetamodelRefTestLanguage");
		org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
