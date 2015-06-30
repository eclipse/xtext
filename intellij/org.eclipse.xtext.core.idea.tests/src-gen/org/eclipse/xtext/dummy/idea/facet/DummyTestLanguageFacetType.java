package org.eclipse.xtext.dummy.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class DummyTestLanguageFacetType  extends AbstractFacetType<DummyTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.dummy.DummyTestLanguage";

	public static  FacetTypeId<Facet<DummyTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<DummyTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public DummyTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "DummyTestLanguage");
		org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
