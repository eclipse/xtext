package org.eclipse.xtext.parser.antlr.idea.facet;

import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtext.parser.antlr.Bug301935TestLanguageGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/Bug301935TestLanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class Bug301935TestLanguageFacetConfiguration extends AbstractFacetConfiguration {
	
}
