/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.labeling;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XbaseImages {
	
	public Image forClass(JvmVisibility visibility) {
		return getJdtImage(JavaElementImageProvider.getTypeImageDescriptor(false, false, toFlags(visibility), false));
	}

	public Image forConstructor(JvmVisibility visibility) {
		return getDecoratedJdtImage(JavaElementImageProvider.getMethodImageDescriptor(false, toFlags(visibility)),
				JavaElementImageDescriptor.CONSTRUCTOR);
	}

	public Image forOperation(JvmVisibility visibility, boolean isStatic) {
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
	
	public Image forLacalVariable(){
		return getJdtImage(JavaPluginImages.DESC_OBJS_LOCAL_VARIABLE);
	}
	
	public Image forTypeParameter(){
		return getJdtImage(JavaPluginImages.DESC_OBJS_TYPEVARIABLE);
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
