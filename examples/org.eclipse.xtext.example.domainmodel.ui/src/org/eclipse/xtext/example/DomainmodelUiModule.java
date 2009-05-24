/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelUiModule extends AbstractDomainmodelUiModule {
	
	public IndexStore bindIndexStore() {
		return EmfIndexUIPlugin.getDefault().getIndexStore();
	}
	
}
