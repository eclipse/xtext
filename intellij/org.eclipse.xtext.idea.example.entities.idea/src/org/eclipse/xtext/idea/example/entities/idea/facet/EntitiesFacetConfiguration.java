package org.eclipse.xtext.idea.example.entities.idea.facet;

import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtext.idea.example.entities.EntitiesGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/EntitiesGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class EntitiesFacetConfiguration extends AbstractFacetConfiguration {
	
}
