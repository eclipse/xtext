/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {

	@org.eclipse.xtext.service.SingletonBinding(eager=true)
	public Class<? extends DomainModelValidator> bindDomainModelValidator() {
		return DomainModelValidator.class;
	}
}
