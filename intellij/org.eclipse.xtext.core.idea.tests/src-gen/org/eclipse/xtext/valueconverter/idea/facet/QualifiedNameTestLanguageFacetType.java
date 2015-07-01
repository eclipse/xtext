package org.eclipse.xtext.valueconverter.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class QualifiedNameTestLanguageFacetType  extends AbstractFacetType<QualifiedNameTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<QualifiedNameTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<QualifiedNameTestLanguageFacetConfiguration>>("org.eclipse.xtext.valueconverter.QualifiedNameTestLanguage");

	public QualifiedNameTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.valueconverter.QualifiedNameTestLanguage", "QualifiedNameTestLanguage");
		org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
