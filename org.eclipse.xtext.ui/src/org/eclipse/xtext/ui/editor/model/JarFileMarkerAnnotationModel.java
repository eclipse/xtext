/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.4
 */
public class JarFileMarkerAnnotationModel extends ResourceMarkerAnnotationModel {

	private static final Logger log = Logger.getLogger(JarFileMarkerAnnotationModel.class);

	public static final String MARKER_URI = JarFileMarkerAnnotationModel.class.getName() + ".URI";

	private final SourceRelativeURI sourceRelativeURI;

	/**
	 * @since 2.9
	 */
	public JarFileMarkerAnnotationModel(IResource jarFile, SourceRelativeURI sourceRelativeURI) {
		super(jarFile);
		this.sourceRelativeURI = sourceRelativeURI;
	}
	
	public JarFileMarkerAnnotationModel(IResource jarFile, URI sourceRelativeURI) {
		this(jarFile, new SourceRelativeURI(sourceRelativeURI));
	}

	@Override
	protected boolean isAcceptable(IMarker marker) {
		if (!super.isAcceptable(marker))
			return false;
		Object markerURI;
		try {
			markerURI = marker.getAttribute(MARKER_URI);
			return markerURI != null && markerURI.equals(sourceRelativeURI.toString());
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}

}
