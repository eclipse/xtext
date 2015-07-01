package org.eclipse.xtext.dummy.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class DummyTestLanguageFacetType  extends AbstractFacetType<DummyTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<DummyTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<DummyTestLanguageFacetConfiguration>>("org.eclipse.xtext.dummy.DummyTestLanguage");

	public DummyTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.dummy.DummyTestLanguage", "DummyTestLanguage");
		org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
