package org.eclipse.xtext.idea.facet;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtext.XtextGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/XtextGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class XtextFacetConfiguration extends AbstractFacetConfiguration {
	
}
