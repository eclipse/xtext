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
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.ui.IImageHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class Xtend2Images {

	@Inject
	private IImageHelper imageHelper;
	
	public Image forPackage() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_PACKDECL);
	}

	public Image forImportContainer() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_IMPCONT);
	}

	public Image forImport() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_IMPDECL);
	}

	public Image forClass(JvmVisibility visibility) {
		return getJdtImage(JavaElementImageProvider.getTypeImageDescriptor(false, false, toFlags(visibility), false));
	}

	public Image forFunction(JvmVisibility visibility) {
		return getJdtImage(JavaElementImageProvider.getMethodImageDescriptor(false, toFlags(visibility)));
	}
	
	public Image forField(JvmVisibility visibility, boolean isExtension) {
		return getJdtImage(JavaElementImageProvider.getFieldImageDescriptor(false, toFlags(visibility)));
	}
	
	public Image forDispatcherFunction(JvmVisibility visibility) {
		return getJdtImage(JavaElementImageProvider.getMethodImageDescriptor(false, toFlags(visibility)));
	}

	public Image forFile() {
		return imageHelper.getImage("xtend2.gif");
	}

	protected Image getJdtImage(ImageDescriptor descriptor) {
		return JavaPlugin.getImageDescriptorRegistry().get(descriptor);
	}
	
	protected int toFlags(JvmVisibility visibility) {
		switch(visibility) {
			case PRIVATE:
				return Flags.AccPrivate;
			case PROTECTED:
				return Flags.AccProtected;
			case PUBLIC:
				return Flags.AccPublic;
			default:
				return Flags.AccDefault;
		}
	}
}
