/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.xtext.ui.core.IImageHelper;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.internal.XtextPluginImages;

import com.google.inject.Inject;

/**
 * LabelDecorator that decorates an element's image with error and warning overlays that represent the severity of
 * markers attached to the element's underlying resource. To see a problem decoration for a marker, the marker needs to
 * be a subtype of <code>IMarker.PROBLEM</code>.
 * <p>
 * <b>Important</b>: Although this decorator implements ILightweightLabelDecorator, do not contribute this class as a
 * decorator to the <code>org.eclipse.ui.decorators</code> extension. Only use this class in your own views and label
 * providers.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class ProblemsLabelDecorator implements ILabelDecorator, ILightweightLabelDecorator {
	// mostly copied from {@link org.eclipse.jdt.ui.ProblemsLabelDecorator}
	private static final Logger log = Logger.getLogger(XtextEditor.class);
	@Inject
	private IImageHelper imageHelper;

	/* (non-Javadoc)
	 * @see ILabelDecorator#decorateText(String, Object)
	 */
	public String decorateText(String text, Object element) {
		return text;
	}

	/* (non-Javadoc)
	 * @see ILabelDecorator#decorateImage(Image, Object)
	 */
	public Image decorateImage(Image image, Object obj) {
		if (image == null) {
			return null;
		}
		int adornmentFlags = computeAdornmentFlags(obj);
		if (adornmentFlags != 0) {
			Rectangle bounds = image.getBounds();
			return imageHelper.getImage(new XtextImageDescriptor(ImageDescriptor.createFromImage(image),
					adornmentFlags, new Point(bounds.width, bounds.height)));
		}
		return image;
	}

	/**
	 * Computes the adornment flags for the given element.
	 * 
	 * @param obj
	 *            the element to compute the flags for
	 * 
	 * @return the adornment flags
	 */
	protected int computeAdornmentFlags(Object obj) {
		try {
			if (obj instanceof IResource) {
				return getErrorTicksFromMarkers((IResource) obj, IResource.DEPTH_INFINITE);
			}
		} catch (CoreException e) {
			if (e.getStatus().getCode() == IResourceStatus.MARKER_NOT_FOUND) {
				return 0;
			}
			log.error(e);
		}
		return 0;
	}

	private int getErrorTicksFromMarkers(IResource resource, int depth) throws CoreException {
		if (resource == null || !resource.isAccessible()) {
			return 0;
		}
		int severity = resource.findMaxProblemSeverity(IMarker.PROBLEM, true, depth);
		if (severity == IMarker.SEVERITY_ERROR) {
			return XtextImageDescriptor.ERROR;
		} else if (severity == IMarker.SEVERITY_WARNING) {
			return XtextImageDescriptor.WARNING;
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see IBaseLabelProvider#dispose()
	 */
	public void dispose() {
	}

	/* (non-Javadoc)
	 * @see IBaseLabelProvider#isLabelProperty(Object, String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/* (non-Javadoc)
	 * @see IBaseLabelProvider#addListener(ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/* (non-Javadoc)
	 * @see IBaseLabelProvider#removeListener(ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
	 */
	public void decorate(Object element, IDecoration decoration) {
		int adornmentFlags = computeAdornmentFlags(element);
		if (adornmentFlags == XtextImageDescriptor.ERROR) {
			decoration.addOverlay(XtextPluginImages.DESC_OVR_ERROR);
		} else if (adornmentFlags == XtextImageDescriptor.WARNING) {
			decoration.addOverlay(XtextPluginImages.DESC_OVR_WARNING);
		}
	}

}
