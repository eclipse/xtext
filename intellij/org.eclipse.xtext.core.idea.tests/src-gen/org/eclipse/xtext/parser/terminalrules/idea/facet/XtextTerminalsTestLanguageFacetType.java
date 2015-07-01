package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtextTerminalsTestLanguageFacetType  extends AbstractFacetType<XtextTerminalsTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguage";

	public static  FacetTypeId<Facet<XtextTerminalsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtextTerminalsTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public XtextTerminalsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "XtextTerminalsTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
