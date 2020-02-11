/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.IAnnotationImageProvider;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Heiko Behrens
 */
public class XtextMarkerAnnotationImageProvider implements IAnnotationImageProvider {

	@Override
	public ImageDescriptor getImageDescriptor(String imageDescritporId) {
		return null;
	}

	@Override
	public String getImageDescriptorId(Annotation annotation) {
		return null;
	}

	@Override
	public Image getManagedImage(Annotation annotation) {
		return getImages(annotation).get(annotation.getType());
	}

	private Map<String, Image> getImages(Annotation annotation) {
		if(annotation.isMarkedDeleted())
			return XtextPluginImages.getAnnotationImagesDeleted();
		else {
			if (annotation instanceof MarkerAnnotation) {
				MarkerAnnotation ma = (MarkerAnnotation) annotation;
				if(ma.isQuickFixableStateSet() && ma.isQuickFixable())
					return XtextPluginImages.getAnnotationImagesFixable();
			}
			return XtextPluginImages.getAnnotationImagesNonfixable();
		}
	}
}
