/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.labeling;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.PluginImageHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class Xtend2Images {

	@Inject
	private PluginImageHelper imageHelper;
	
	public Image forPackage() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_PACKDECL);
	}

	public Image forImportContainer() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_IMPCONT);
	}

	public Image forImport() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_IMPDECL);
	}

	public Image forClass(int flags) {
		return getJdtImage(JavaElementImageProvider.getTypeImageDescriptor(false, false, Flags.AccPublic, false));
	}

	public Image forFunction(int flags) {
		return getJdtImage(JavaElementImageProvider.getMethodImageDescriptor(false, Flags.AccPublic));
	}
	
	public Image forField(boolean isExtension) {
		return getJdtImage(JavaPluginImages.DESC_FIELD_PRIVATE);
	}
	
	public Image forDispatcherFunction(int flags) {
		return getJdtImage(JavaElementImageProvider.getFieldImageDescriptor(false, Flags.AccPublic));
	}

	public Image forFile() {
		return imageHelper.getImage("xtend2.gif");
	}

	protected Image getJdtImage(ImageDescriptor descriptor) {
		return JavaPlugin.getImageDescriptorRegistry().get(descriptor);
	}
	
}
