package org.eclipse.xtext.purexbase.idea.facet;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.xbase.idea.facet.XbaseFacetConfiguration;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;

@State(name = "org.eclipse.xtext.purexbase.PureXbaseGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/PureXbaseGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class PureXbaseFacetConfiguration extends XbaseFacetConfiguration implements PersistentStateComponent<XbaseGeneratorConfigurationState>{

}
