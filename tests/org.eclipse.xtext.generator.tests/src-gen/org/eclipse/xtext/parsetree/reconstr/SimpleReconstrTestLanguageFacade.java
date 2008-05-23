package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.parser.*;

public class SimpleReconstrTestLanguageFacade extends org.eclipse.xtext.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String SIMPLERECONSTRTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleReconstrTestLanguageFacade.class.getClassLoader(),SIMPLERECONSTRTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new SimpleReconstrTestASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new SimpleReconstrTestParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new SimpleReconstrTestParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getsimplerewritetestEPackage()
		
		};
	}

	
	public static final String SIMPLEREWRITETEST_NS_URI = "http://simple/rewrite/test";
	public static final String SIMPLEREWRITETEST_CP_URI = "org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore";
	
	public static EPackage getsimplerewritetestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEREWRITETEST_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleReconstrTestLanguageFacade.class.getClassLoader(),SIMPLEREWRITETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLEREWRITETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEREWRITETEST_NS_URI);
	}
	

	private Resource.Factory resourceFactory = new SimpleReconstrTestResourceFactory(this);
	public Resource.Factory getResourceFactory() {
		return resourceFactory;
	}
	
	public String getModelFileExtension() {
		return "simplereconstrtest";
	}
}
