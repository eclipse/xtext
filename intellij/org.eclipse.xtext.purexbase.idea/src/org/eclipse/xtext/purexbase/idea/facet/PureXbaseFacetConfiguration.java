package org.eclipse.xtext.purexbase.idea.facet;

import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtext.purexbase.PureXbaseGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/PureXbaseGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class PureXbaseFacetConfiguration extends AbstractFacetConfiguration {
	
}
