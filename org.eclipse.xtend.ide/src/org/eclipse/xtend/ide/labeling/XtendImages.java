/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.labeling;

import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages2;

import com.google.inject.Inject;


/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
@SuppressWarnings("restriction")
public class XtendImages extends XbaseImages2 {

	@Inject
	private IImageDescriptorHelper imageHelper;
	
	public ImageDescriptor forFilter() {
		return JavaPluginImages.DESC_ELCL_FILTER;
	}

	public ImageDescriptor forImplementsAnnotation() {
		return JavaPluginImages.DESC_OBJ_IMPLEMENTS;
	}

	public ImageDescriptor forOverridesAnnotation() {
		return JavaPluginImages.DESC_OBJ_OVERRIDES;
	}

	public ImageDescriptor forPackage() {
		return getDecorated(JavaPluginImages.DESC_OBJS_PACKDECL, 0);
	}

	public ImageDescriptor forDispatcherFunction(JvmVisibility visibility, int adornments) {
		String fileName = new StringBuilder("dispatch_method_")
			.append(visibility.getName().toLowerCase())
			.append(".png").toString();
		return getDecorated(imageHelper.getImageDescriptor(fileName), adornments);
	}

	public ImageDescriptor forFile() {
		return imageHelper.getImageDescriptor("xtend.gif");
	}

	public ImageDescriptor forReadonly() {
		return imageHelper.getImageDescriptor("xtend_readonly_editor.png");
	}
	
	@Override
	protected Point imagesSize() {
		return JavaElementImageProvider.BIG_SIZE;
	}
}
