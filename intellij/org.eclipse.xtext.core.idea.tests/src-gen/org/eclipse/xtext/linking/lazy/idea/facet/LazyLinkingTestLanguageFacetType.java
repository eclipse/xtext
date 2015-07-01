package org.eclipse.xtext.linking.lazy.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LazyLinkingTestLanguageFacetType  extends AbstractFacetType<LazyLinkingTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage";

	public static  FacetTypeId<Facet<LazyLinkingTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LazyLinkingTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public LazyLinkingTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "LazyLinkingTestLanguage");
		org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
