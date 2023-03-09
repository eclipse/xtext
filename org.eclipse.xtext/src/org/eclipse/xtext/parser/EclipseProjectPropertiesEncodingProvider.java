/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Singleton;

/**
 * Use this class to retrieve resource encodings from Eclipse project properties. The provider can be used
 * without a running Eclipse context, but depends on resources being stored in Eclipse projects.
 * Parts of the implementation are copied from {@link org.eclipse.core.internal.preferences.EclipsePreferences}.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 * @since 2.8
 */
@Singleton
public class EclipseProjectPropertiesEncodingProvider extends IEncodingProvider.Runtime {
	
	private static final String PROPERTIES_DIRNAME = ".settings";
	private static final String PREFS_FILE_EXTENSION = "prefs";
	private static final String PROJECT_PROPERTIES = "<project>";
	private static final String ENCODING_PREFIX = "encoding/";
	
	@Override
	public String getEncoding(URI uri) {
		// If a default encoding is explicitly set, use that one
		String result = getDefaultEncoding();
		if (result != null)
			return result;
		
		// Read the project properties
		if (uri != null) {
			try {
				result = getFromProperties(uri);
				if (result != null)
					return result;
			} catch (IOException e) {
			}
		}
		
		// Fall back to the standard encoding
		return super.getEncoding(uri);
	}
	
	protected String getFromProperties(URI uri) throws IOException {
		if (!uri.isHierarchical())
			return null;
		
		URI projectURI = uri;
		boolean projectFound = false;
		do {
			projectURI = projectURI.trimSegments(1);
			if (new File(projectURI.path(), ".project").exists()) {
				projectFound = true;
			}
			if (!projectFound && projectURI.segmentCount() == 0)
				// The resource is not contained in a project
				return null;
		} while (!projectFound);
		
		Properties properties = loadProperties(projectURI);
		URI resourceUri = URI.createHierarchicalURI(Arrays.copyOfRange(uri.segments(),
				projectURI.segmentCount(), uri.segmentCount()), null, null);
		return getValue(properties, resourceUri, ENCODING_PREFIX);
	}

	protected Properties loadProperties(URI projectURI) throws IOException {
		URI propertiesUri = projectURI.appendSegment(PROPERTIES_DIRNAME).appendSegment("org.eclipse.core.resources")
				.appendFileExtension(PREFS_FILE_EXTENSION);
		InputStream input = null;
		Properties result = new Properties();
		try {
			input = new FileInputStream(propertiesUri.path());
			result.load(input);
		} catch (FileNotFoundException e) {
			// File doesn't exist but that's ok
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
				}
			}
		}
		return result;
	}
	
	protected String getValue(Properties properties, URI resourceUri, String prefix) {
		URI path = resourceUri;
		do {
			String value = properties.getProperty(prefix + path.path());
			if (value != null)
				return value;
			path = path.trimSegments(1);
		} while (path.segmentCount() > 0);
		String value = properties.getProperty(prefix + PROJECT_PROPERTIES);
		if (value != null)
			return value;
		return null;
	}
	
}
