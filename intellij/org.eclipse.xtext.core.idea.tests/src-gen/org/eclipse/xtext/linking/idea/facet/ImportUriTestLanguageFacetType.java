package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ImportUriTestLanguageFacetType  extends AbstractFacetType<ImportUriTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ImportUriTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ImportUriTestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.ImportUriTestLanguage");

	public ImportUriTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.ImportUriTestLanguage", "ImportUriTestLanguage");
		org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
