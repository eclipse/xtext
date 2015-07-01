package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug289524TestLanguageFacetType  extends AbstractFacetType<Bug289524TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug289524TestLanguage";

	public static  FacetTypeId<Facet<Bug289524TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug289524TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug289524TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug289524TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
