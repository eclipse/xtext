/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Implementing classes must not rely on being run on the display thread.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public interface ILabelProviderImageDescriptorExtension {

	/**
	 * @return the image descriptor for the given element or <code>null</code>.
	 */
	ImageDescriptor getImageDescriptor(Object element);
}
