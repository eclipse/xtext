/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues;

import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class TransientValuesTestRuntimeModule extends AbstractTransientValuesTestRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
	
	@Override
	protected Class<? extends ITransientValueService> getITransientValueService() {
		return TransientHandler.class;
	}
	
}
