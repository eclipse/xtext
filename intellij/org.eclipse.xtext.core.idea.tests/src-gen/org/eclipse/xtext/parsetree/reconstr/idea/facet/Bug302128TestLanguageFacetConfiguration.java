package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

@State(name = "org.eclipse.xtext.parsetree.reconstr.Bug302128TestLanguageGenerator", storages = {
		@Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/org.eclipse.xtext.parsetree.reconstr.Bug302128TestLanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class Bug302128TestLanguageFacetConfiguration extends AbstractFacetConfiguration {
	@Override
	protected String getTabTitle() {
		return "org.eclipse.xtext.parsetree.reconstr.Bug302128TestLanguage facet";
	}
}
