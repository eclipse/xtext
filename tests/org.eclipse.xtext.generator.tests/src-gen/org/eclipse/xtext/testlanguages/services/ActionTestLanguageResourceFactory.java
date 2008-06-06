/*
Generated using Xtext at Fri Jun 06 17:59:00 CEST 2008
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class ActionTestLanguageResourceFactory extends AbstractXtextResourceFactory {

	public ActionTestLanguageResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("actiontestlanguage", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "actiontestlanguage" };
	}
	
} 
