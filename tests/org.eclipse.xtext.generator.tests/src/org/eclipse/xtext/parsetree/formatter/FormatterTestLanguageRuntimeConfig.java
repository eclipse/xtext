package org.eclipse.xtext.parsetree.formatter;

import java.util.Set;

import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;

/**
 * used to register components to be used at runtime.
 */
public class FormatterTestLanguageRuntimeConfig extends
		AbstractFormatterTestLanguageRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = scope(
				FormatterTestLanguageStandaloneSetup.getServiceScope()).with(
				ITokenSerializer.class, FormattingTokenSerializerTestImpl.class)
				.registrations();
		generated.addAll(super.registrations());
		return generated;
	}

}
