package org.eclipse.xtext.idea.common.types.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;

@State(name = "org.eclipse.xtext.idea.common.types.RefactoringTestLanguageGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/RefactoringTestLanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class RefactoringTestLanguageFacetConfiguration extends AbstractFacetConfiguration<GeneratorConfigurationState> {
	@Override
	protected GeneratorConfigurationState createNewState() {
		return new GeneratorConfigurationState();
	}
}
