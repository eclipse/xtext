package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SerializationErrorTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public SerializationErrorTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SerializationErrorTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
