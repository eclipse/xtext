package org.eclipse.xtext.testlanguages.backtracking.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;

@State(name = "org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguageGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/SimpleBeeLangTestLanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class SimpleBeeLangTestLanguageFacetConfiguration extends AbstractFacetConfiguration<GeneratorConfigurationState> {
	@Override
	protected GeneratorConfigurationState createNewState() {
		return new GeneratorConfigurationState();
	}
}
