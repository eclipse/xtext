package org.eclipse.xtext.parser.encoding.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EncodingTestLanguageFacetType  extends AbstractFacetType<EncodingTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<EncodingTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EncodingTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.encoding.EncodingTestLanguage");

	public EncodingTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.encoding.EncodingTestLanguage", "EncodingTestLanguage");
		org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
