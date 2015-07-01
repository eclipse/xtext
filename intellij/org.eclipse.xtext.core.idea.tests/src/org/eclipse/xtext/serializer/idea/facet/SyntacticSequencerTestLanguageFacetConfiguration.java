package org.eclipse.xtext.serializer.idea.facet;

import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;

@State(name = "org.eclipse.xtext.serializer.SyntacticSequencerTestLanguageGenerator", storages = {
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/SyntacticSequencerTestLanguageGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
public class SyntacticSequencerTestLanguageFacetConfiguration extends AbstractFacetConfiguration {
	
}
