package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class PartialSerializationTestLanguageFacetType  extends AbstractFacetType<PartialSerializationTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.reconstr.PartialSerializationTestLanguage";

	public static  FacetTypeId<Facet<PartialSerializationTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<PartialSerializationTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public PartialSerializationTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "PartialSerializationTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
