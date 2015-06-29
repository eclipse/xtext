package org.eclipse.xtext.parser.bug419429.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

@State(name = "org.eclipse.xtext.parser.bug419429.Bug419429Generator", storages = {
		@Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/org.eclipse.xtext.parser.bug419429.Bug419429GeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class Bug419429FacetConfiguration extends AbstractFacetConfiguration {
	@Override
	protected String getTabTitle() {
		return "org.eclipse.xtext.parser.bug419429.Bug419429 facet";
	}
}
