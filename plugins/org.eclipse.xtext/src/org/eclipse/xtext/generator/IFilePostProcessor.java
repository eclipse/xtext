/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.URI;
import com.google.inject.ImplementedBy;

/**
 * The {@link IFilePostProcessor} allows to rewrite the contents that will
 * be written into a given file. A common use case is to fix-up the line 
 * delimiters and make all of them homogeneous.
 * 
 * The extension interface {@link IFilePostProcessorExtension} provides
 * additional information for implementors which is the target encoding of the file.
 * 
 * @see LineSeparatorHarmonizer
 * @see IFilePostProcessorExtension (since 2.4)
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@ImplementedBy(LineSeparatorHarmonizer.class)
public interface IFilePostProcessor {

	CharSequence postProcess(URI fileURI, CharSequence content);
	
}
