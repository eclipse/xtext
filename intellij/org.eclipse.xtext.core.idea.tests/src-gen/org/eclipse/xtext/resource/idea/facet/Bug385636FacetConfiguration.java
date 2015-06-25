package org.eclipse.xtext.resource.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

@State(name = "org.eclipse.xtext.resource.Bug385636Generator", storages = {
		@Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/org.eclipse.xtext.resource.Bug385636GeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class Bug385636FacetConfiguration extends AbstractFacetConfiguration {
	@Override
	protected String getTabTitle() {
		return "org.eclipse.xtext.resource.Bug385636 facet";
	}
}
