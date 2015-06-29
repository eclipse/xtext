package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ImportUriTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.ImportUriTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public ImportUriTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ImportUriTestLanguage");
		org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
