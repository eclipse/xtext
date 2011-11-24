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
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
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

	public Image forConstructor(JvmVisibility visibility) {
		return getDecoratedJdtImage(JavaElementImageProvider.getMethodImageDescriptor(false, toFlags(visibility)),
				JavaElementImageDescriptor.CONSTRUCTOR);
	}

	public Image forFunction(JvmVisibility visibility, boolean isStatic) {
		ImageDescriptor descriptor = JavaElementImageProvider.getMethodImageDescriptor(false, toFlags(visibility));
		if (isStatic)
			return getDecoratedJdtImage(descriptor, JavaElementImageDescriptor.STATIC);
		else
			return getJdtImage(descriptor);
	}

	public Image forField(JvmVisibility visibility, boolean isStatic, boolean isExtension) {
		ImageDescriptor descriptor = JavaElementImageProvider.getFieldImageDescriptor(false, toFlags(visibility));
		if (isStatic)
			return getDecoratedJdtImage(descriptor, JavaElementImageDescriptor.STATIC);
		else
			return getJdtImage(descriptor);
	}

	public Image forDispatcherFunction(JvmVisibility visibility, boolean isStatic) {
		return forFunction(visibility, isStatic);
	}

	public Image forFile() {
		return imageHelper.getImage("xtend2.gif");
	}

	protected Image getJdtImage(ImageDescriptor descriptor) {
		return JavaPlugin.getImageDescriptorRegistry().get(descriptor);
	}

	protected Image getDecoratedJdtImage(ImageDescriptor descriptor, int adornment) {
		return JavaElementImageProvider.getDecoratedImage(descriptor, adornment, JavaElementImageProvider.SMALL_SIZE);
	}

	protected int toFlags(JvmVisibility visibility) {
		switch (visibility) {
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
