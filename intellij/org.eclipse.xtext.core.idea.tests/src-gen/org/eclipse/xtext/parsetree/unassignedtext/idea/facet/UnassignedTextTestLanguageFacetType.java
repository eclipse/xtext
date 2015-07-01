package org.eclipse.xtext.parsetree.unassignedtext.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class UnassignedTextTestLanguageFacetType  extends AbstractFacetType<UnassignedTextTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<UnassignedTextTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<UnassignedTextTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.unassignedtext.UnassignedTextTestLanguage");

	public UnassignedTextTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.unassignedtext.UnassignedTextTestLanguage", "UnassignedTextTestLanguage");
		org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
