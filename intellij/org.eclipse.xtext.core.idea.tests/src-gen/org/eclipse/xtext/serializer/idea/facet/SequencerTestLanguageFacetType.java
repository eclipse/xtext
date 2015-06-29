package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SequencerTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.serializer.SequencerTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public SequencerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SequencerTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
