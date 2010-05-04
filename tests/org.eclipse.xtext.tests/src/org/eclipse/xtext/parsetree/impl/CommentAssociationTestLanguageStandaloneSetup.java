
package org.eclipse.xtext.parsetree.impl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CommentAssociationTestLanguageStandaloneSetup extends CommentAssociationTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new CommentAssociationTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

