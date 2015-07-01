package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug313089TestLanguageFacetType  extends AbstractFacetType<Bug313089TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug313089TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug313089TestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.Bug313089TestLanguage");

	public Bug313089TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.Bug313089TestLanguage", "Bug313089TestLanguage");
		org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
