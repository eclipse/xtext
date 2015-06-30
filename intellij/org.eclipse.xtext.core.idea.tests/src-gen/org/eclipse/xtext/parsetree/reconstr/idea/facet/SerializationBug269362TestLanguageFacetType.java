package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SerializationBug269362TestLanguageFacetType  extends AbstractFacetType<SerializationBug269362TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.reconstr.SerializationBug269362TestLanguage";

	public static  FacetTypeId<Facet<SerializationBug269362TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SerializationBug269362TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public SerializationBug269362TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SerializationBug269362TestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
