package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parser.*;

public class SimpleExpressionsLanguageFacade extends org.eclipse.xtext.core.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/testlanguages/SimpleExpressions";
	public static final String SIMPLEEXPRESSIONS_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/SimpleExpressions.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleExpressionsLanguageFacade.class.getClassLoader(),SIMPLEEXPRESSIONS_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new SimpleExpressionsASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new SimpleExpressionsParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new SimpleExpressionsParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getsimpleExpressionsEPackage()
		
		};
	}

	
	public static final String SIMPLEEXPRESSIONS_NS_URI = "http://www.eclipse.org/xtext/test/simpleExpressions";
	public static final String SIMPLEEXPRESSIONS_CP_URI = "org/eclipse/xtext/testlanguages/simpleExpressions.ecore";
	
	public static EPackage getsimpleExpressionsEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEEXPRESSIONS_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleExpressionsLanguageFacade.class.getClassLoader(),SIMPLEEXPRESSIONS_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLEEXPRESSIONS_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEEXPRESSIONS_NS_URI);
	}
	

}
