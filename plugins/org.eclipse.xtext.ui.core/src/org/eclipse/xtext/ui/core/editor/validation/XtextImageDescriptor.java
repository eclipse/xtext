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
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.core.internal.XtextPluginImages;

/**
 * 
 * A {@link XtextImageDescriptor} consists of a base image and several adornments. The adornments are computed according
 * to the flags either passed during creation or set via the method {@link #setAdornments(int)}.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class XtextImageDescriptor extends CompositeImageDescriptor {
	// copied and adapted from org.eclipse.jdt.ui.JavaElementImageDescriptor
	public static Logger log = Logger.getLogger(XtextImageDescriptor.class);

	/** Flag to render the warning adornment. */
	public final static int WARNING = 0x020;

	/** Flag to render the error adornment. */
	public final static int ERROR = 0x040;

	private ImageDescriptor baseImage;
	private int flags;
	private Point size;

	/**
	 * Creates a new XtextImageDescriptor.
	 * 
	 * @param baseImage
	 *            an image descriptor used as the base image
	 * @param flags
	 *            flags indicating which adornments are to be rendered. See {@link #setAdornments(int)} for valid
	 *            values.
	 * @param size
	 *            the size of the resulting image
	 */
	public XtextImageDescriptor(ImageDescriptor baseImage, int flags, Point size) {
		Assert.isNotNull(baseImage);
		Assert.isTrue(flags >= 0);
		Assert.isNotNull(size);
		this.baseImage = baseImage;
		this.flags = flags;
		this.size = size;
	}

	/**
	 * Sets the descriptors adornments. Valid values are: {@link #WARNING}, {@link #ERROR}, or any combination of those.
	 * 
	 * @param adornments
	 *            the image descriptors adornments
	 */
	public void setAdornments(int adornments) {
		Assert.isTrue(adornments >= 0);
		flags = adornments;
	}

	/**
	 * Returns the current adornments.
	 * 
	 * @return the current adornments
	 */
	public int getAdornments() {
		return flags;
	}

	/**
	 * Sets the size of the image created by calling {@link #createImage()}.
	 * 
	 * @param size
	 *            the size of the image returned from calling {@link #createImage()}
	 */
	public void setImageSize(Point size) {
		Assert.isNotNull(size);
		Assert.isTrue(size.x >= 0 && size.y >= 0);
		this.size = size;
	}

	/**
	 * Returns the size of the image created by calling {@link #createImage()}.
	 * 
	 * @return the size of the image created by calling {@link #createImage()}
	 */
	public Point getImageSize() {
		return new Point(size.x, size.y);
	}

	/* (non-Javadoc)
	 * Method declared in CompositeImageDescriptor
	 */
	@Override
	protected Point getSize() {
		return size;
	}

	/* (non-Javadoc)
	 * Method declared on Object.
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null || !XtextImageDescriptor.class.equals(object.getClass()))
			return false;

		XtextImageDescriptor other = (XtextImageDescriptor) object;
		return (baseImage.equals(other.baseImage) && flags == other.flags && size.equals(other.size));
	}

	/* (non-Javadoc)
	 * Method declared on Object.
	 */
	@Override
	public int hashCode() {
		return baseImage.hashCode() | flags | size.hashCode();
	}

	/* (non-Javadoc)
	 * Method declared in CompositeImageDescriptor
	 */
	@Override
	protected void drawCompositeImage(int width, int height) {
		ImageData bg = getImageData(baseImage);
		drawImage(bg, 0, 0);
		drawBottomLeftDecorations();
	}

	private ImageData getImageData(ImageDescriptor descriptor) {
		ImageData data = descriptor.getImageData();
		if (data == null) {
			data = DEFAULT_IMAGE_DATA;
			log.error("Image data not available: " + descriptor.toString()); //$NON-NLS-1$
		}
		return data;
	}

	private void drawBottomLeftDecorations() {
		Point pos = new Point(0, getSize().y);
		if ((flags & ERROR) != 0) {
			addBottomLeftImage(XtextPluginImages.DESC_OVR_ERROR, pos);
		}
		if ((flags & WARNING) != 0) {
			addBottomLeftImage(XtextPluginImages.DESC_OVR_WARNING, pos);
		}

	}

	private void addBottomLeftImage(ImageDescriptor desc, Point pos) {
		ImageData data = getImageData(desc);
		int x = pos.x;
		int y = pos.y - data.height;
		if (x + data.width < getSize().x && y >= 0) {
			drawImage(data, x, y);
			pos.x = x + data.width;
		}
	}
}
