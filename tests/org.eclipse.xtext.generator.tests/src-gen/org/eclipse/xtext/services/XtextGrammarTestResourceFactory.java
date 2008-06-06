/*
Generated using Xtext at Fri Jun 06 17:58:55 CEST 2008
*/
package org.eclipse.xtext.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class XtextGrammarTestResourceFactory extends AbstractXtextResourceFactory {

	public XtextGrammarTestResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtextgrammartest", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "xtextgrammartest" };
	}
	
} 
