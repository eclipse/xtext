package org.eclipse.xtext.parser.fragments.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class FragmentTestLanguageExFacetType  extends AbstractFacetType<FragmentTestLanguageExFacetConfiguration> {

	public static final FacetTypeId<Facet<FragmentTestLanguageExFacetConfiguration>> TYPEID = new FacetTypeId<Facet<FragmentTestLanguageExFacetConfiguration>>("org.eclipse.xtext.parser.fragments.FragmentTestLanguageEx");

	public FragmentTestLanguageExFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.fragments.FragmentTestLanguageEx", "FragmentTestLanguageEx");
		org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage.INSTANCE.injectMembers(this);
	}

}
