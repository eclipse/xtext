package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SyntacticSequencerTestLanguageFacetType  extends AbstractFacetType<SyntacticSequencerTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage";

	public static  FacetTypeId<Facet<SyntacticSequencerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SyntacticSequencerTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public SyntacticSequencerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SyntacticSequencerTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
