package org.eclipse.xtext.parser.unorderedGroups.idea.facet;

import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguageGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/BacktrackingBug325745TestLanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class BacktrackingBug325745TestLanguageFacetConfiguration extends AbstractFacetConfiguration {
	
}
