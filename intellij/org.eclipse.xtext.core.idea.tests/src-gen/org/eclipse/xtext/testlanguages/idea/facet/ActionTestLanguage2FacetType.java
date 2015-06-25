package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ActionTestLanguage2FacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.ActionTestLanguage2";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public ActionTestLanguage2FacetType() {
		super(TYPEID, TYPE_ID_STRING, "ActionTestLanguage2");
		org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language.INSTANCE.injectMembers(this);
	}

}
