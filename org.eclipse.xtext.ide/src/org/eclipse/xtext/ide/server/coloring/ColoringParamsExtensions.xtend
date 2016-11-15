/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.coloring

import org.eclipse.lsp4j.ColoringParams
import org.eclipse.xtext.resource.XtextResource

/**
 * Extension for creating empty {@link ColoringParams coloring parameter}
 * instances or checking whether existing ones are
 * {@link ColoringParamsExtensions#isEmpty empty} or not.
 * 
 * @author akos.kitta - Initial contribution and API
 */
abstract class ColoringParamsExtensions {

	/**
	 * Unique URI that is being used when creating an empty parameter instance for
	 * an unknown resource.
	 */
	static val UNKNOWN_URI = '''missing://«ColoringParamsExtensions.name»''';

	private static val ColoringParams EMPTY = emptyColoringParams(UNKNOWN_URI);

	/**
	 * Returns with an empty coloring parameter instance. 
	 */
	static def emptyColoringParams() {
		return EMPTY;
	}

	/**
	 * Creates a new, empty coloring parameter instance for the resource given with
	 * the resource URI argument.
	 */
	static def emptyColoringParams(String resourceUri) {
		if (resourceUri === null) {
			return emptyColoringParams();
		}
		return new ColoringParams(resourceUri, emptyList);
	}

	/**
	 * Creates a new, empty coloring parameter instance with the URI of the resource
	 * argument. If either the resource or its URI is {@code null}, then the
	 * {@link ColoringParamsExtensions#UNKNOWN_URI unknown URI} will be used as the
	 * resource URI instead.
	 */
	static def emptyColoringParams(XtextResource resource) {
		return emptyColoringParams(resource?.URI?.toString);
	}

	/**
	 * Returns with {@code true} if any of the followings are {@code true}:
	 * <ul>
	 * <li>The coloring parameter argument is {@code null} or</li>
	 * <li>the URI of the argument equals with the
	 * {@link ColoringParamsExtensions#UNKNOWN_URI unknown URI} or</li>
	 * <li>the underlying {@link ColoringParams#getInfos() info} list is
	 * {@code null} or empty.</li>
	 * </ul>
	 * Otherwise returns with {@code false}.
	 */
	static def isEmpty(ColoringParams params) {
		return params === null || params.uri == UNKNOWN_URI || params.infos.nullOrEmpty;
	}
	
	private new() {
		// Extensions class.
	}

}
