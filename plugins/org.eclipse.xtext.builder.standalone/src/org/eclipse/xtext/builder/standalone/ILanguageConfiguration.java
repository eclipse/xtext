/**
 * 
 */
package org.eclipse.xtext.builder.standalone;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.OutputConfiguration;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public interface ILanguageConfiguration {
	
	@NonNull
	String getSetup();

	@Nullable
	Set<OutputConfiguration> getOutputConfigurations();
	
	/**
	 * @return whether this language links or produces Java types
	 */
	boolean isJavaSupport();
}
