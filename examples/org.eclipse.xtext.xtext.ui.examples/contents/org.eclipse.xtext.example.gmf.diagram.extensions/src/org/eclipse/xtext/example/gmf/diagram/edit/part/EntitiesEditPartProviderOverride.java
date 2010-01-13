package org.eclipse.xtext.example.gmf.diagram.edit.part;

import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesEditPartProvider;

public class EntitiesEditPartProviderOverride extends EntitiesEditPartProvider {

	public EntitiesEditPartProviderOverride() {
		setFactory(new EntitiesEditPartFactoryOverride());
	}
}
