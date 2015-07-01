package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug313089TestLanguageFacetType  extends AbstractFacetType<Bug313089TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.Bug313089TestLanguage";

	public static  FacetTypeId<Facet<Bug313089TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug313089TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug313089TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug313089TestLanguage");
		org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
