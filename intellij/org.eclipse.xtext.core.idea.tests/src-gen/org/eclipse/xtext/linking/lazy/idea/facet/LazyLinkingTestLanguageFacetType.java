package org.eclipse.xtext.linking.lazy.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LazyLinkingTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public LazyLinkingTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "LazyLinkingTestLanguage");
		org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
