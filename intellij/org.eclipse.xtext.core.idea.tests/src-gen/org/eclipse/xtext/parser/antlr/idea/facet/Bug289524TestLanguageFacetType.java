package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug289524TestLanguageFacetType  extends AbstractFacetType<Bug289524TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug289524TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug289524TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug289524TestLanguage");

	public Bug289524TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug289524TestLanguage", "Bug289524TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
