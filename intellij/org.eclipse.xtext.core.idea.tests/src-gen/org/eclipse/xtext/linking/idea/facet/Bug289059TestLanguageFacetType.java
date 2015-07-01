package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug289059TestLanguageFacetType  extends AbstractFacetType<Bug289059TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.Bug289059TestLanguage";

	public static  FacetTypeId<Facet<Bug289059TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug289059TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug289059TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug289059TestLanguage");
		org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
