package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.parser.*;

public class XtextLanguageFacade extends BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/Xtext";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String XTEXT_GRAMMAR_CP_URI = "org/eclipse/xtext/Xtext.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(XtextLanguageFacade.class.getClassLoader(),XTEXT_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new XtextASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new XtextParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new XtextParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getXtextEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String XTEXT_NS_URI = "http://www.eclipse.org/2008/Xtext";
	public static final String XTEXT_CP_URI = "org/eclipse/xtext/xtext.ecore";
	
	public static EPackage getXtextEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXT_NS_URI)) {
			EPackage p = loadEcoreFile(XtextLanguageFacade.class.getClassLoader(),XTEXT_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(XTEXT_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(XTEXT_NS_URI);
	}
	

	private Resource.Factory resourceFactory = new XtextResourceFactory(this);
	public Resource.Factory getResourceFactory() {
		return resourceFactory;
	}
	
	public String getModelFileExtension() {
		return "xtext";
	}
}
