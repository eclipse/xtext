package org.eclipse.xtext.ui.editor.model;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.4
 */
public class JarFileMarkerAnnotationModel extends ResourceMarkerAnnotationModel {

	private static final Logger log = Logger.getLogger(JarFileMarkerAnnotationModel.class);

	public static final String MARKER_URI = JarFileMarkerAnnotationModel.class.getName() + ".URI";

	final URI fullURI;

	public JarFileMarkerAnnotationModel(IResource jarFile, URI fullURI) {
		super(jarFile);
		this.fullURI = fullURI;
	}

	@Override
	protected boolean isAcceptable(IMarker marker) {
		if (!super.isAcceptable(marker))
			return false;
		Object markerURI;
		try {
			markerURI = marker.getAttribute(MARKER_URI);
			return markerURI != null && markerURI.equals(fullURI.toString());
		} catch (CoreException e) {
			log.error(e);
			return false;
		}
	}

}
