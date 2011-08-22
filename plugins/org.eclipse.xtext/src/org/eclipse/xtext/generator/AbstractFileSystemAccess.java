/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import com.google.common.base.Function;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension {

	private Map<String, OutputConfiguration> outputs = newLinkedHashMap();
	
	/**
	 * @since 2.1
	 */
	public void setOutputConfigurations(Map<String, OutputConfiguration> outputs) {
		this.outputs = outputs;
	}
	
	/**
	 * @since 2.1
	 */
	public Map<String, OutputConfiguration> getOutputConfigurations() {
		return outputs;
	}
	
	/**
	 * @since 2.1
	 */
	protected OutputConfiguration getOutputConfig(String outputName) {
		if (!getOutputConfigurations().containsKey(outputName))
			throw new IllegalArgumentException("No output configuration with name '"+outputName+"' exists.");
		return getOutputConfigurations().get(outputName);
	}
	
	protected Map<String, String> getPathes() {
		return transformValues(outputs, new Function<OutputConfiguration, String>() {
			public String apply(OutputConfiguration from) {
				return from.getOutputDirectory();
			}
		});
	}
	
	public void setOutputPath(String outputName, String path) {
		OutputConfiguration configuration = outputs.get(outputName);
		if (configuration == null) {
			configuration = new OutputConfiguration(outputName);
			outputs.put(outputName, configuration);
		}
		configuration.setOutputDirectory(path);
	}
	
	public void setOutputPath(String path) {
		setOutputPath(DEFAULT_OUTPUT, path);
	}

	public void generateFile(String fileName, CharSequence contents) {
		generateFile(fileName, DEFAULT_OUTPUT, contents);
	}
	
	/**
	 * @since 2.1
	 */
	public void deleteFile(String fileName) {
		deleteFile(fileName, DEFAULT_OUTPUT);
	}
	
	/**
	 * @since 2.1
	 */
	public void deleteFile(String fileName, String outputConfigurationName) {
		throw new UnsupportedOperationException();
	}

}