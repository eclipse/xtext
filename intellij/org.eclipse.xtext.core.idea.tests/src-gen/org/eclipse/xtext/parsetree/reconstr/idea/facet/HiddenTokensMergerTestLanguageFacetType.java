package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class HiddenTokensMergerTestLanguageFacetType  extends AbstractFacetType<HiddenTokensMergerTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<HiddenTokensMergerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<HiddenTokensMergerTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage");

	public HiddenTokensMergerTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage", "HiddenTokensMergerTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
