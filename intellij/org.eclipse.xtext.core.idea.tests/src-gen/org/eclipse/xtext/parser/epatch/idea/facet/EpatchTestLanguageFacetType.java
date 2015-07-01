package org.eclipse.xtext.parser.epatch.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EpatchTestLanguageFacetType  extends AbstractFacetType<EpatchTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<EpatchTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EpatchTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.epatch.EpatchTestLanguage");

	public EpatchTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.epatch.EpatchTestLanguage", "EpatchTestLanguage");
		org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
