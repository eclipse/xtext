package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.parser.*;

public class ComplexReconstrTestLanguageFacade extends org.eclipse.xtext.core.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String COMPLEXRECONSTRTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ComplexReconstrTestLanguageFacade.class.getClassLoader(),COMPLEXRECONSTRTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new ComplexReconstrTestASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new ComplexReconstrTestParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new ComplexReconstrTestParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getcomplexrewritetestEPackage()
		
		};
	}

	
	public static final String COMPLEXREWRITETEST_NS_URI = "http://complex/rewrite/test";
	public static final String COMPLEXREWRITETEST_CP_URI = "org/eclipse/xtext/parsetree/reconstr/complexrewritetest.ecore";
	
	public static EPackage getcomplexrewritetestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(COMPLEXREWRITETEST_NS_URI)) {
			EPackage p = loadEcoreFile(ComplexReconstrTestLanguageFacade.class.getClassLoader(),COMPLEXREWRITETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(COMPLEXREWRITETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(COMPLEXREWRITETEST_NS_URI);
	}
	

}
