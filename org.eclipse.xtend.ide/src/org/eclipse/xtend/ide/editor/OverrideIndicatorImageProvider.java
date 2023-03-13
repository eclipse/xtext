/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.IAnnotationImageProvider;
import org.eclipse.xtend.ide.labeling.XtendImages;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class OverrideIndicatorImageProvider implements IAnnotationImageProvider {
	private static final String OVERRIDE_IMG_DESC_ID = "XtendImages.DESC_OBJ_OVERRIDES"; //$NON-NLS-1$
	private static final String IMPLEMENTS_IMG_DESC_ID = "XtendImages.DESC_OBJ_IMPLEMENTS"; //$NON-NLS-1$
	private XtendImages xtendImages;

	@Inject
	public void setXtendImages(XtendImages xtendImages) {
		this.xtendImages = xtendImages;
	}

	@Override
	public Image getManagedImage(Annotation annotation) {
		return null;
	}

	@Override
	public String getImageDescriptorId(Annotation annotation) {
		if (!(annotation instanceof OverrideIndicatorAnnotation)) {
			return null;
		}
		OverrideIndicatorAnnotation overrideIndicatorAnnotation = (OverrideIndicatorAnnotation) annotation;
		return overrideIndicatorAnnotation.isOverwriteIndicator() ? OVERRIDE_IMG_DESC_ID : IMPLEMENTS_IMG_DESC_ID;
	}

	@Override
	public ImageDescriptor getImageDescriptor(String imageDescritporId) {
		ImageDescriptor imageDescriptor = null;
		if (IMPLEMENTS_IMG_DESC_ID.equals(imageDescritporId)) {
			imageDescriptor = xtendImages.forImplementsAnnotation();
		} else if (OVERRIDE_IMG_DESC_ID.equals(imageDescritporId)) {
			imageDescriptor = xtendImages.forOverridesAnnotation();
		}
		return imageDescriptor;
	}

}
