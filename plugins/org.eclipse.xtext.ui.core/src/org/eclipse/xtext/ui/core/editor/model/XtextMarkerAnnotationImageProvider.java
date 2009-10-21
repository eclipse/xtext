/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IAnnotationImageProvider;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.ui.core.editor.XtextEditor;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextMarkerAnnotationImageProvider implements IAnnotationImageProvider {
	private final static int NO_IMAGE = 0;
	private final static int GRAY_IMAGE = 1;
	private final static int WARNING_IMAGE = 2;
	private final static int ERROR_IMAGE = 3;
	private static ImageRegistry imageRegistry;
	private static Image errorImage;
	private static Image warningImage;
	private int cachedImageType;
	private Image cachedImage;
	private ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();

	public ImageDescriptor getImageDescriptor(String imageDescritporId) {
		return null;
	}

	public String getImageDescriptorId(Annotation annotation) {
		return null;
	}

	public Image getManagedImage(Annotation annotation) {
		if (annotation instanceof MarkerAnnotation) {
			int imageType = getImageType(annotation);
			Image image = getImage(annotation, imageType, Display.getCurrent());
			return image;
		}
		return null;
	}

	private int getImageType(Annotation annotation) {
		int imageType = NO_IMAGE;
		if (!annotation.isMarkedDeleted()) {
			imageType = XtextEditor.ERROR_ANNOTATION_TYPE.equals(annotation.getType()) ? ERROR_IMAGE : WARNING_IMAGE;
		}
		else {
			imageType = GRAY_IMAGE;
		}
		return imageType;
	}

	private Image getImage(Annotation annotation, int imageType, Display display) {
		if ((imageType == WARNING_IMAGE || imageType == ERROR_IMAGE) && cachedImageType == imageType) {
			return cachedImage;
		}
		Image image = null;
		switch (imageType) {
			case WARNING_IMAGE:
				image = getWarningImage();
				cachedImageType = imageType;
				cachedImage = image;
				break;
			case ERROR_IMAGE:
				image = getErrorImage();
				cachedImageType = imageType;
				cachedImage = image;
				break;
			case GRAY_IMAGE: {
				String annotationType = annotation.getType();
				if (XtextEditor.ERROR_ANNOTATION_TYPE.equals(annotationType)) {
					image = sharedImages.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
				}
				else if (XtextEditor.WARNING_ANNOTATION_TYPE.equals(annotationType)) {
					image = sharedImages.getImage(ISharedImages.IMG_OBJS_WARN_TSK);
				}
				if (image != null) {
					ImageRegistry registry = getImageRegistry(display);
					String key = Integer.toString(image.hashCode());
					Image grayImage = registry.get(key);
					if (grayImage == null) {
						grayImage = new Image(display, image, SWT.IMAGE_GRAY);
						registry.put(key, grayImage);
					}
					image = grayImage;
				}
				cachedImageType = -1;
				break;
			}
		}
		return image;
	}

	private ImageRegistry getImageRegistry(Display display) {
		if (imageRegistry == null)
			imageRegistry = new ImageRegistry(display);
		return imageRegistry;
	}

	private Image getErrorImage() {
		if (errorImage == null) {
			errorImage = sharedImages.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		}
		return errorImage;
	}

	private Image getWarningImage() {
		if (warningImage == null) {
			warningImage = sharedImages.getImage(ISharedImages.IMG_OBJS_WARN_TSK);
		}
		return warningImage;
	}
}
