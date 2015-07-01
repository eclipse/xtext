package org.eclipse.xtext.grammarinheritance.idea.facet;

import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtext.grammarinheritance.InheritanceTestLanguageGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/InheritanceTestLanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class InheritanceTestLanguageFacetConfiguration extends AbstractFacetConfiguration {
	
}
