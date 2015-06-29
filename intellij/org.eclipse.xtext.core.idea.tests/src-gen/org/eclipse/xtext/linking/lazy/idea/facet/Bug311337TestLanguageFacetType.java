package org.eclipse.xtext.linking.lazy.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug311337TestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.lazy.Bug311337TestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug311337TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug311337TestLanguage");
		org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
