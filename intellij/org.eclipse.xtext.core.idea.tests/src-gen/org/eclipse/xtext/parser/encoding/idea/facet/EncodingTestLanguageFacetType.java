package org.eclipse.xtext.parser.encoding.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EncodingTestLanguageFacetType  extends AbstractFacetType<EncodingTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.encoding.EncodingTestLanguage";

	public static  FacetTypeId<Facet<EncodingTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EncodingTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public EncodingTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EncodingTestLanguage");
		org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
