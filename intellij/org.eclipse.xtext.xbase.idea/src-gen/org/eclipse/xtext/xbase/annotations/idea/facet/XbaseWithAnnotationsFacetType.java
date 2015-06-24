package org.eclipse.xtext.xbase.annotations.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XbaseWithAnnotationsFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public XbaseWithAnnotationsFacetType() {
		super(TYPEID, TYPE_ID_STRING, "XbaseWithAnnotations");
		org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage.INSTANCE.injectMembers(this);
	}

}
