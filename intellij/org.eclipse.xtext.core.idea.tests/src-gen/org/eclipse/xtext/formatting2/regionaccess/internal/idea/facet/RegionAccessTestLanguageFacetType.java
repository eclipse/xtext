package org.eclipse.xtext.formatting2.regionaccess.internal.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class RegionAccessTestLanguageFacetType  extends AbstractFacetType<RegionAccessTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage";

	public static  FacetTypeId<Facet<RegionAccessTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<RegionAccessTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public RegionAccessTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "RegionAccessTestLanguage");
		org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
