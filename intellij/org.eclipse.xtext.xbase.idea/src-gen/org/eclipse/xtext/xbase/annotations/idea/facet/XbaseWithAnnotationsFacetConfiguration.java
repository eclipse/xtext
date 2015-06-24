package org.eclipse.xtext.xbase.annotations.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StorageScheme;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

@State(name = "org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsGenerator", storages = {
		@Storage(id = "ipr", file = "$PROJECT_FILE$"),
		@Storage(id = "prjDir", file = "${PROJECT_CONFIG_DIR$/org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class XbaseWithAnnotationsFacetConfiguration extends AbstractFacetConfiguration {
	@Override
	protected String getTabTitle() {
		return "org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations facet";
	}
}
