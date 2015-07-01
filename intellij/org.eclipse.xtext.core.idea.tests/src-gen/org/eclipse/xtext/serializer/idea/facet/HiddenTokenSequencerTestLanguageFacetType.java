package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class HiddenTokenSequencerTestLanguageFacetType  extends AbstractFacetType<HiddenTokenSequencerTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<HiddenTokenSequencerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<HiddenTokenSequencerTestLanguageFacetConfiguration>>("org.eclipse.xtext.serializer.HiddenTokenSequencerTestLanguage");

	public HiddenTokenSequencerTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.serializer.HiddenTokenSequencerTestLanguage", "HiddenTokenSequencerTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
