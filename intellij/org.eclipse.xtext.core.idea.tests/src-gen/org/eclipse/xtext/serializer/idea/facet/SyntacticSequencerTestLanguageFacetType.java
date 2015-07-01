package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SyntacticSequencerTestLanguageFacetType  extends AbstractFacetType<SyntacticSequencerTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SyntacticSequencerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SyntacticSequencerTestLanguageFacetConfiguration>>("org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage");

	public SyntacticSequencerTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage", "SyntacticSequencerTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
