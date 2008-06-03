package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.xtext.service.*;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.parser.*;

public class MetamodelRefTestLanguageFacade extends BaseEPackageAccess implements ILanguageFacade {

	public ILanguageDescriptor getLanguageDescriptor() {
		return MetamodelRefTestStandaloneSetup.getLanguageDescriptor();
	}
	
    public String getLanguageId() {
    	return MetamodelRefTestStandaloneSetup.LANGUAGE_ID;
    }
    
	public Grammar getGrammar() {	
		return ServiceRegistry.getService(getLanguageDescriptor(), IGrammarAccess.class).getGrammar();
	}
	
	public IElementFactory getElementFactory() {
		return ServiceRegistry.getService(getLanguageDescriptor(), IElementFactory.class);
	}
	
	public IParser getParser() {
		return ServiceRegistry.getService(getLanguageDescriptor(), IParser.class);
	}
	
	public IParseTreeConstructor getParsetreeConstructor() {
		return ServiceRegistry.getService(getLanguageDescriptor(), IParseTreeConstructor.class);
	}

	public Resource.Factory getResourceFactory() {
		return ServiceRegistry.getService(getLanguageDescriptor(), IResourceFactory.class);
	}

	public EPackage[] getGeneratedEPackages() {
		return ServiceRegistry.getService(getLanguageDescriptor(), IMetamodelAccess.class).getGeneratedEPackages();
	}

	public EPackage[] getReferencedEPackages() {
		return ServiceRegistry.getService(getLanguageDescriptor(), IMetamodelAccess.class).getReferencedEPackages();
	}

	public String getModelFileExtension() {
		return ServiceRegistry.getService(getLanguageDescriptor(), IResourceFactory.class).getModelFileExtension();
	}
}
