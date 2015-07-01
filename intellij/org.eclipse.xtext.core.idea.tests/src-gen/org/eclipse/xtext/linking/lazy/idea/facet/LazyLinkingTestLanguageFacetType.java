package org.eclipse.xtext.linking.lazy.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LazyLinkingTestLanguageFacetType  extends AbstractFacetType<LazyLinkingTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<LazyLinkingTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LazyLinkingTestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage");

	public LazyLinkingTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage", "LazyLinkingTestLanguage");
		org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
