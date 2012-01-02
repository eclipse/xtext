/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.IAnnotationImageProvider;
import org.eclipse.xtext.xtend2.ui.labeling.Xtend2Images;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class OverrideIndicatorImageProvider implements IAnnotationImageProvider {
	private static final String OVERRIDE_IMG_DESC_ID = "Xtend2Images.DESC_OBJ_OVERRIDES"; //$NON-NLS-1$
	private static final String IMPLEMENTS_IMG_DESC_ID = "Xtend2Images.DESC_OBJ_IMPLEMENTS"; //$NON-NLS-1$
	private Xtend2Images xtend2Images;

	@Inject
	public void setXtend2Images(Xtend2Images xtend2Images) {
		this.xtend2Images = xtend2Images;
	}

	public Image getManagedImage(Annotation annotation) {
		return null;
	}

	public String getImageDescriptorId(Annotation annotation) {
		if (!(annotation instanceof OverrideIndicatorAnnotation)) {
			return null;
		}
		OverrideIndicatorAnnotation overrideIndicatorAnnotation = (OverrideIndicatorAnnotation) annotation;
		return overrideIndicatorAnnotation.isOverwriteIndicator() ? OVERRIDE_IMG_DESC_ID : IMPLEMENTS_IMG_DESC_ID;
	}

	public ImageDescriptor getImageDescriptor(String imageDescritporId) {
		ImageDescriptor imageDescriptor = null;
		if (IMPLEMENTS_IMG_DESC_ID.equals(imageDescritporId)) {
			imageDescriptor = xtend2Images.forImplementsAnnotation();
		} else if (OVERRIDE_IMG_DESC_ID.equals(imageDescritporId)) {
			imageDescriptor = xtend2Images.forOverridesAnnotation();
		}
		return imageDescriptor;
	}

}
