package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;

public class XtextLanguageFacade extends BaseEPackageAccess implements ILanguageFacade {

	public ILanguageDescriptor getLanguageDescriptor() {
		return XtextStandaloneSetup.getLanguageDescriptor();
	}
	
    public String getLanguageId() {
    	return XtextStandaloneSetup.LANGUAGE_ID;
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
