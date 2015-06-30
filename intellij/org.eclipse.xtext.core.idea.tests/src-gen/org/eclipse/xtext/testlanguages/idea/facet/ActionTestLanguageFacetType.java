package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ActionTestLanguageFacetType  extends AbstractFacetType<ActionTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.ActionTestLanguage";

	public static  FacetTypeId<Facet<ActionTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ActionTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public ActionTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ActionTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
