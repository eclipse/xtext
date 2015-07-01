package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TreeTestLanguageFacetType  extends AbstractFacetType<TreeTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.TreeTestLanguage";

	public static  FacetTypeId<Facet<TreeTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TreeTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public TreeTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "TreeTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
