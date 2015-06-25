package org.eclipse.xtext.parsetree.impl.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

@State(name = "org.eclipse.xtext.parsetree.impl.Bug305397Generator", storages = {
		@Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/org.eclipse.xtext.parsetree.impl.Bug305397GeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class Bug305397FacetConfiguration extends AbstractFacetConfiguration {
	@Override
	protected String getTabTitle() {
		return "org.eclipse.xtext.parsetree.impl.Bug305397 facet";
	}
}
