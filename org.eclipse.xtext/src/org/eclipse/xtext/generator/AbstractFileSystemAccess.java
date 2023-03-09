/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static com.google.common.collect.Maps.*;

import java.nio.charset.Charset;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension,
		IFileSystemAccessExtension2 {

	@Inject(optional = true)
	private IFilePostProcessor postProcessor;

	private Map<String, OutputConfiguration> outputs = newLinkedHashMap();
	
	private String currentSource;
	
	/**
	 * @since 2.6
	 */
	public void setCurrentSource(String currentSource) {
		this.currentSource = currentSource;
	}
	
	/**
	 * The current source folder, relative to the project location
	 * @since 2.6
	 */
	protected String getCurrentSource() {
		return currentSource;
	}

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
			throw new IllegalArgumentException("No output configuration with name '" + outputName + "' exists.");
		return getOutputConfigurations().get(outputName);
	}

	protected Map<String, String> getPathes() {
		return transformValues(getOutputConfigurations(), new Function<OutputConfiguration, String>() {
			@Override
			public String apply(OutputConfiguration from) {
				if (currentSource == null) {
					return from.getOutputDirectory();
				} else {
					return from.getOutputDirectory(currentSource);
				}
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

	@Override
	public void generateFile(String fileName, CharSequence contents) {
		generateFile(fileName, DEFAULT_OUTPUT, contents);
	}

	/**
	 * @since 2.1
	 */
	@Override
	public void deleteFile(String fileName) {
		deleteFile(fileName, DEFAULT_OUTPUT);
	}

	/**
	 * @since 2.1
	 */
	@Override
	public void deleteFile(String fileName, String outputConfigurationName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 2.3
	 */
	protected CharSequence postProcess(String fileName, String outputConfiguration, CharSequence content) {
		if (postProcessor != null)
			return postProcessor.postProcess(getURI(fileName, outputConfiguration), content);
		else
			return content;
	}

	/**
	 * @since 2.4
	 */
	protected CharSequence postProcess(String fileName, String outputConfiguration, CharSequence content, String charset) {
		if (postProcessor instanceof IFilePostProcessorExtension) {
			return ((IFilePostProcessorExtension)postProcessor).postProcess(getURI(fileName, outputConfiguration), content, Charset.forName(charset));
		} else
			return postProcess(fileName, outputConfiguration, content);
	}
	
	/**
	 * @since 2.3
	 */
	@Override
	public URI getURI(String path) {
		return getURI(path, DEFAULT_OUTPUT);
	}
	
	void setPostProcessor(IFilePostProcessor postProcessor) {
		this.postProcessor = postProcessor;
	}
}