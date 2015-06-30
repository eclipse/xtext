package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SequencerTestLanguageFacetType  extends AbstractFacetType<SequencerTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.serializer.SequencerTestLanguage";

	public static  FacetTypeId<Facet<SequencerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SequencerTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public SequencerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SequencerTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
