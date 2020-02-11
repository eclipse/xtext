/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow
 * @author Michael Clay
 */
@ImplementedBy(IImageHelper.NullImageHelper.class)
public interface IImageHelper {

	Image getImage(String name);
	
	Image getImage(ImageDescriptor imageDescriptor);
	
	class NullImageHelper implements IImageHelper, IImageDescriptorHelper {

		@Override
		public Image getImage(String name) {
			return null;
		}

		@Override
		public Image getImage(ImageDescriptor imageDescriptor) {
			return null;
		}

		/**
		 * @since 2.4
		 */
		@Override
		public ImageDescriptor getImageDescriptor(String name) {
			return null;
		}

		/**
		 * @since 2.4
		 */
		@Override
		public ImageDescriptor getImageDescriptor(Image image) {
			return null;
		}
	}
	
	/**
	 * @since 2.4
	 */
	@ImplementedBy(IImageHelper.NullImageHelper.class)
	public interface IImageDescriptorHelper {
		ImageDescriptor getImageDescriptor(String name);
		ImageDescriptor getImageDescriptor(Image image);
	}

}
