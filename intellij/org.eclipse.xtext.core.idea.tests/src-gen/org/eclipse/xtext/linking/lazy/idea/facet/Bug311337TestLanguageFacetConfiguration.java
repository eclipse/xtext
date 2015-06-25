package org.eclipse.xtext.linking.lazy.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

@State(name = "org.eclipse.xtext.linking.lazy.Bug311337TestLanguageGenerator", storages = {
		@Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/org.eclipse.xtext.linking.lazy.Bug311337TestLanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class Bug311337TestLanguageFacetConfiguration extends AbstractFacetConfiguration {
	@Override
	protected String getTabTitle() {
		return "org.eclipse.xtext.linking.lazy.Bug311337TestLanguage facet";
	}
}
