package org.eclipse.xtext.parsetree.transientvalues;

import java.util.Set;

import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

/**
 * used to register components to be used at runtime.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TransientValuesTestRuntimeConfig extends
		AbstractTransientValuesTestRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = scope(
				TransientValuesTestStandaloneSetup.getServiceScope()).with(
				ITransientValueService.class, TransientHandler.class)
				.registrations();
		generated.addAll(super.registrations());
		return generated;
	}

}
