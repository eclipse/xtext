/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import java.net.URL;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LoadedByClasspathFromSourceFolderTest extends AbstractURIHandlerWithEcoreTest {
	@Override
	public URI getResourceURI() {
		return URI.createURI("platform:/resource/org.eclipse.xtext/src/org/eclipse/xtext/Xtext.ecore");
	}

	@Override
	public URI getPackagedResourceURI() {
		return URI.createURI("classpath:/org/eclipse/xtext/Xtext.ecore");
	}

	@Override
	public URI getReferencedURI() {
		return URI.createURI("platform:/resource/org.eclipse.xtext.test/src/org/eclipse/xtext/resource/mydsl.ecore");
	}

	@Override
	public URI getPackagedReferencedURI() {
		URL url = classLoader.getResource("org/eclipse/xtext/resource/mydsl.ecore");
		if (url == null) {
			url = classLoader.getResource("/org/eclipse/xtext/resource/mydsl.ecore");
		}
		return URI.createURI(url.toString());
	}
}
