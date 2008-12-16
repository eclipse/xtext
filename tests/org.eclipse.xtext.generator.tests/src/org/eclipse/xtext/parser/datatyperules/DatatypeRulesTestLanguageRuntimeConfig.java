package org.eclipse.xtext.parser.datatyperules;

import java.util.Set;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.datatyperules.AbstractDatatypeRulesTestLanguageRuntimeConfig;

/**
 * used to register components to be used at runtime.
 */
public class DatatypeRulesTestLanguageRuntimeConfig extends AbstractDatatypeRulesTestLanguageRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		generated.addAll(
			scope(DatatypeRulesTestLanguageStandaloneSetup.getServiceScope())
				.with(IValueConverterService.class, DatatypeRulesTestLanguageValueConverters.class)
				.registrations());
		return generated;
	}

}
			
