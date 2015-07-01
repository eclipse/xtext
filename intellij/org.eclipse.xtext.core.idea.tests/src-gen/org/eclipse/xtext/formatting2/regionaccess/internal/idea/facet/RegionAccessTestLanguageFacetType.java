package org.eclipse.xtext.formatting2.regionaccess.internal.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class RegionAccessTestLanguageFacetType  extends AbstractFacetType<RegionAccessTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<RegionAccessTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<RegionAccessTestLanguageFacetConfiguration>>("org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage");

	public RegionAccessTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage", "RegionAccessTestLanguage");
		org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
