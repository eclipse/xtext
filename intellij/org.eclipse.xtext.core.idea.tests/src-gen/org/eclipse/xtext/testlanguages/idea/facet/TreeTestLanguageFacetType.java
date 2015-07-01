package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TreeTestLanguageFacetType  extends AbstractFacetType<TreeTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<TreeTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TreeTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.TreeTestLanguage");

	public TreeTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.TreeTestLanguage", "TreeTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
