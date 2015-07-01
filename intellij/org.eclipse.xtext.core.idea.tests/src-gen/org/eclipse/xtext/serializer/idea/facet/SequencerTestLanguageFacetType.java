package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SequencerTestLanguageFacetType  extends AbstractFacetType<SequencerTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SequencerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SequencerTestLanguageFacetConfiguration>>("org.eclipse.xtext.serializer.SequencerTestLanguage");

	public SequencerTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.serializer.SequencerTestLanguage", "SequencerTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
