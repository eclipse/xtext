package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug299395TestLanguageFacetType  extends AbstractFacetType<Bug299395TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.reconstr.Bug299395TestLanguage";

	public static  FacetTypeId<Facet<Bug299395TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug299395TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug299395TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug299395TestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
