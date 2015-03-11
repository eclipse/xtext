/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.annotations.Beta;

/**
 * A contribution that allows to customize the computation
 * of a trace URI for an {@link XtextResource} or an {@link URI}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public interface ITraceURIConverterContribution {

	/**
	 * Compute the trace URI that points to the location of the given
	 * resource. Return <code>null</code> if the resource is not handled
	 * by this contribution.
	 */
	/* @Nullable */ URI getURIForTrace(XtextResource resource);
	
	/**
	 * Compute the trace URI that points to the location of the given uri.
	 * Return <code>null</code> if the uri's location is not handled by
	 * this contribution.
	 */
	/* @Nullable */ URI getURIForTrace(URI uri);
	
}
