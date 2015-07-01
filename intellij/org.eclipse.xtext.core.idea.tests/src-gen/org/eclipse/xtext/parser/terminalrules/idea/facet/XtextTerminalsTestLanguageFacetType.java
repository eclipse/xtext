package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtextTerminalsTestLanguageFacetType  extends AbstractFacetType<XtextTerminalsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<XtextTerminalsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtextTerminalsTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguage");

	public XtextTerminalsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguage", "XtextTerminalsTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
