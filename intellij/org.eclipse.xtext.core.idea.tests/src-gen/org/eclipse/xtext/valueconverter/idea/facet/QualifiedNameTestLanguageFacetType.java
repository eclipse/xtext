package org.eclipse.xtext.valueconverter.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class QualifiedNameTestLanguageFacetType  extends AbstractFacetType<QualifiedNameTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.valueconverter.QualifiedNameTestLanguage";

	public static  FacetTypeId<Facet<QualifiedNameTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<QualifiedNameTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public QualifiedNameTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "QualifiedNameTestLanguage");
		org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
