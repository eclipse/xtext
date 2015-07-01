package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SerializationErrorTestLanguageFacetType  extends AbstractFacetType<SerializationErrorTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SerializationErrorTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SerializationErrorTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage");

	public SerializationErrorTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage", "SerializationErrorTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
