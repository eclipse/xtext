package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ActionTestLanguage2FacetType  extends AbstractFacetType<ActionTestLanguage2FacetConfiguration> {

	public static final FacetTypeId<Facet<ActionTestLanguage2FacetConfiguration>> TYPEID = new FacetTypeId<Facet<ActionTestLanguage2FacetConfiguration>>("org.eclipse.xtext.testlanguages.ActionTestLanguage2");

	public ActionTestLanguage2FacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.ActionTestLanguage2", "ActionTestLanguage2");
		org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language.INSTANCE.injectMembers(this);
	}

}
