package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EObjectAtOffsetTestLanguageFacetType  extends AbstractFacetType<EObjectAtOffsetTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.resource.EObjectAtOffsetTestLanguage";

	public static  FacetTypeId<Facet<EObjectAtOffsetTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EObjectAtOffsetTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public EObjectAtOffsetTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EObjectAtOffsetTestLanguage");
		org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
