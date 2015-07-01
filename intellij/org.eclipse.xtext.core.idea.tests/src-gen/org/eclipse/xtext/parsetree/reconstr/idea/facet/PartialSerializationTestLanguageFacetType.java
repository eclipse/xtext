package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class PartialSerializationTestLanguageFacetType  extends AbstractFacetType<PartialSerializationTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<PartialSerializationTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<PartialSerializationTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.reconstr.PartialSerializationTestLanguage");

	public PartialSerializationTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.reconstr.PartialSerializationTestLanguage", "PartialSerializationTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
