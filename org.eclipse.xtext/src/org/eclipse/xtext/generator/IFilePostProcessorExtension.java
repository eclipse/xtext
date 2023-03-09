/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.nio.charset.Charset;

import org.eclipse.emf.common.util.URI;

/**
 * Extension interface to {@link IFilePostProcessor}. It allows to process
 * the content with respect to the target charset. Implementors should handle
 * a {@link #postProcess(URI, CharSequence, Charset) postProcess} request
 * without an explicit target charset in the same way as a plain
 * {@link IFilePostProcessor#postProcess(URI, CharSequence)} request.
 * 
 * @see IFilePostProcessor
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
public interface IFilePostProcessorExtension {
	
	CharSequence postProcess(URI fileURI, CharSequence content, /* @Nullable */ Charset targetCharset);
	
}
