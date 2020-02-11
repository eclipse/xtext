/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;

import com.google.inject.Inject;

/**
 * A label provider that implements {@link ILabelProvider} as well as {@link IStyledLabelProvider} with an optional
 * delegate.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractLabelProvider extends LabelProvider implements IStyledLabelProvider, IItemLabelProvider, ILabelProviderImageDescriptorExtension {

	private ILabelProvider delegate;

	@Inject
	private IImageHelper imageHelper;
	@Inject
	private IImageDescriptorHelper imageDescriptorHelper;

	protected AbstractLabelProvider() {
	}

	protected AbstractLabelProvider(ILabelProvider delegate) {
		this.delegate = delegate;
	}

	/**
	 * Subclasses should rather override {@link #doGetImage}.
	 */
	@Override
	public Image getImage(Object element) {
		Image image = convertToImage(doGetImage(element));
		if (image != null) {
			return image;
		} else if (delegate != null) {
			image = delegate.getImage(element);
			if (image != null) {
				return image;
			}
		}
		return convertToImage(getDefaultImage());
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public ImageDescriptor getImageDescriptor(Object element) {
		Object image = doGetImage(element);
		ImageDescriptor imageDescriptor = convertToImageDescriptor(image);
		return imageDescriptor;
	}
	
	/**
	 * @since 2.4
	 */
	protected ImageDescriptor convertToImageDescriptor(Object imageDescription) {
		if (imageDescription instanceof Image) {
			final Image image = (Image) imageDescription;
			return imageDescriptorHelper.getImageDescriptor(image);
		} else if (imageDescription instanceof ImageDescriptor) {
			return (ImageDescriptor) imageDescription;
		} else if (imageDescription instanceof String) {
			return imageDescriptorHelper.getImageDescriptor((String) imageDescription);
		}
		return null;
	}

	/**
	 * @param imageDescription
	 *            a {@link String}, an {@link ImageDescriptor} or an {@link Image}
	 * @return the {@link Image} associated with the description or <code>null</code>
	 */
	protected Image convertToImage(Object imageDescription) {
		if (imageDescription instanceof Image) {
			return (Image) imageDescription;
		} else if (imageDescription instanceof ImageDescriptor) {
			return imageHelper.getImage((ImageDescriptor) imageDescription);
		} else if (imageDescription instanceof String) {
			return imageHelper.getImage((String) imageDescription);
		}
		return null;
	}

	/**
	 * Expected to be overridden by clients.
	 * 
	 * @return a {@link String}, an {@link ImageDescriptor} or an {@link Image} passed to
	 *         {@link #convertToImage(Object)} to determine the actual {@link Image}.
	 */
	protected Object doGetImage(Object element) {
		return null;
	}

	protected Object getDefaultImage() {
		return null;
	}

	/**
	 * Subclasses should rather override {@link #doGetText}.
	 */
	@Override
	public StyledString getStyledText(Object element) {
		StyledString styledText = convertToStyledString(doGetText(element));
		if (styledText != null) {
			return styledText;
		} else if (delegate != null) {
			if (delegate instanceof IStyledLabelProvider) {
				styledText = ((IStyledLabelProvider) delegate).getStyledText(element);
				if (styledText != null) {
					return styledText;
				}
			} else {
				styledText = convertToStyledString(delegate.getText(element));
				if (styledText != null) {
					return styledText;
				}
			}
		}
		return getDefaultStyledText();
	}

	/**
	 * @param text a {@link StyledString} or a a {@link String}
	 * @return a {@link StyledString} representing the parameter or <code>null</code>.
	 */
	protected StyledString convertToStyledString(Object text) {
		if (text instanceof StyledString) {
			return (StyledString) text;
		} else if(text instanceof String){
			return new StyledString((String) text);
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		String text = convertToString(doGetText(element));
		if (text != null) {
			return text;
		} else if (delegate != null) {
			text = delegate.getText(element);
			if (text != null) {
				return text;
			}
		}
		return getDefaultText();
	}

	/**
	 * @param text a {@link StyledString} or a a {@link String}
	 * @return a {@link String} representing the parameter or <code>null</code>.
	 */
	protected String convertToString(Object text) {
		if (text instanceof StyledString) {
			return ((StyledString) text).getString();
		} else if (text instanceof String){
			return (String) text;
		} else if (text instanceof CharSequence) {
			return text.toString();
		}
		return null;
	}

	/**
	 * Expected to be overridden by clients.
	 * 
	 * @return a {@link StyledString} or a a {@link String}.
	 */
	protected Object doGetText(Object element) {
		return null;
	}

	protected StyledString getDefaultStyledText() {
		return null;
	}

	protected String getDefaultText() {
		return null;
	}
	
	protected void setImageHelper(IImageHelper imageHelper) {
		this.imageHelper = imageHelper;
	}
}
