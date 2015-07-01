package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug302128TestLanguageFacetType  extends AbstractFacetType<Bug302128TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug302128TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug302128TestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.reconstr.Bug302128TestLanguage");

	public Bug302128TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.reconstr.Bug302128TestLanguage", "Bug302128TestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
