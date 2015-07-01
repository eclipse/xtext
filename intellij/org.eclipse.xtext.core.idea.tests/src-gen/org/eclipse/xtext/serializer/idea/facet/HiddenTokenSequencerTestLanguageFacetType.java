package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class HiddenTokenSequencerTestLanguageFacetType  extends AbstractFacetType<HiddenTokenSequencerTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.serializer.HiddenTokenSequencerTestLanguage";

	public static  FacetTypeId<Facet<HiddenTokenSequencerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<HiddenTokenSequencerTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public HiddenTokenSequencerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "HiddenTokenSequencerTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
