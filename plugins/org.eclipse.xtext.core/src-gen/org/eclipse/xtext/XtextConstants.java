package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;

public class XtextConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String XTEXT_GRAMMAR_CP_URI = "org/eclipse/xtext/Xtext.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getXtextGrammar() {	
		if (GRAMMAR==null) {
			GRAMMAR = (Grammar) loadGrammarFile(XtextConstants.class.getClassLoader(),XTEXT_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String XTEXT_NS_URI = "http://www.eclipse.org/2008/Xtext";
	public static final String XTEXT_CP_URI = "org/eclipse/xtext/xtext.ecore";
	
	public static EPackage getxtextEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXT_NS_URI)) {
			EPackage p = loadEcoreFile(XtextConstants.class.getClassLoader(),XTEXT_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(XTEXT_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(XTEXT_NS_URI);
	}
	

}
