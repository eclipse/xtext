/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration;

import org.eclipse.xtext.scoping.IScopeProvider;



/**
 * used to register components to be used within the IDE.
 */
public class TestLanguageRuntimeModule extends AbstractTestLanguageRuntimeModule {
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return MyScopeProvider.class;
	}
}
