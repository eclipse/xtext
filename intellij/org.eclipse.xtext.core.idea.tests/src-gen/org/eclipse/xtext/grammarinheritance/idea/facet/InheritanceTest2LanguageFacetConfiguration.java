package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

@State(name = "org.eclipse.xtext.grammarinheritance.InheritanceTest2LanguageGenerator", storages = {
		@Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/org.eclipse.xtext.grammarinheritance.InheritanceTest2LanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class InheritanceTest2LanguageFacetConfiguration extends AbstractFacetConfiguration {
	@Override
	protected String getTabTitle() {
		return "org.eclipse.xtext.grammarinheritance.InheritanceTest2Language facet";
	}
}
