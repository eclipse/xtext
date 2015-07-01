package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug299395TestLanguageFacetType  extends AbstractFacetType<Bug299395TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug299395TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug299395TestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.reconstr.Bug299395TestLanguage");

	public Bug299395TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.reconstr.Bug299395TestLanguage", "Bug299395TestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
