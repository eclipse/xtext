/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.example.scoping.DomainmodelScopeProvider;
import org.eclipse.xtext.example.valueconverter.DomainmodelValueConverterService;
import org.eclipse.xtext.scoping.IScopeProvider;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return DomainmodelScopeProvider.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return DomainmodelValueConverterService.class;
	}
	
}
