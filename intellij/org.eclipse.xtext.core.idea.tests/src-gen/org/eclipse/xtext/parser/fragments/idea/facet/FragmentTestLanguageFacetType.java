package org.eclipse.xtext.parser.fragments.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class FragmentTestLanguageFacetType  extends AbstractFacetType<FragmentTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<FragmentTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<FragmentTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.fragments.FragmentTestLanguage");

	public FragmentTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.fragments.FragmentTestLanguage", "FragmentTestLanguage");
		org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
