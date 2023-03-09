/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * @deprecated use {@link XbaseImages2} instead for better handling of adornments
 */
@SuppressWarnings("restriction")
@Deprecated
public class XbaseImages {
	
	public Image forImportContainer() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_IMPCONT);
	}

	public Image forImport() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_IMPDECL);
	}

	public Image forClass(JvmVisibility visibility) {
		return getJdtImage(JavaElementImageProvider.getTypeImageDescriptor(false, false, toFlags(visibility), false));
	}

	public Image forInterface(JvmVisibility visibility) {
		return getJdtImage(JavaElementImageProvider.getTypeImageDescriptor(false, true, toFlags(visibility) | Flags.AccInterface, false));
	}

	public Image forEnum(JvmVisibility visibility) {
		return getJdtImage(JavaElementImageProvider.getTypeImageDescriptor(false, false, toFlags(visibility) | Flags.AccEnum, false));
	}

	public Image forAnnotation(JvmVisibility visibility) {
		return getJdtImage(JavaElementImageProvider.getTypeImageDescriptor(false, true, toFlags(visibility) | Flags.AccAnnotation, false));
	}

	public Image forConstructor(JvmVisibility visibility) {
		return getDecoratedJdtImage(JavaElementImageProvider.getMethodImageDescriptor(false, toFlags(visibility)),
				JavaElementImageDescriptor.CONSTRUCTOR);
	}

	public Image forOperation(JvmVisibility visibility, boolean isStatic) {
		return forOperation(visibility, false, isStatic, false); 	
	}
	
	public Image forOperation(JvmVisibility visibility, boolean isAbstract, boolean isStatic, boolean isFinal) {
		ImageDescriptor descriptor = JavaElementImageProvider.getMethodImageDescriptor(false, 
				toFlags(visibility, isAbstract, isStatic, isFinal));
		int adornment = 0;
		if(isStatic)
			adornment |= JavaElementImageDescriptor.STATIC;
		if(isFinal)
			adornment |= JavaElementImageDescriptor.FINAL;
		if(isAbstract)
			adornment |= JavaElementImageDescriptor.ABSTRACT;
		if (adornment != 0)
				return getDecoratedJdtImage(descriptor, adornment);
		else
			return getJdtImage(descriptor);
	}

	public Image forField(JvmVisibility visibility, boolean isStatic, boolean isExtension) {
		return forField(visibility, isStatic, isExtension, false);
	}
	
	public Image forField(JvmVisibility visibility, boolean isStatic, boolean isFinal, boolean isExtension) {
		ImageDescriptor descriptor = JavaElementImageProvider.getFieldImageDescriptor(false, 
				toFlags(visibility, false, isStatic, isFinal));
		int adornment = 0;
		if(isStatic)
			adornment |= JavaElementImageDescriptor.STATIC;
		if(isFinal)
			adornment |= JavaElementImageDescriptor.FINAL;
		if (adornment != 0)
				return getDecoratedJdtImage(descriptor, adornment);
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

	protected int toFlags(JvmVisibility visibility, boolean isAbstract, boolean isStatic, boolean isFinal) {
		int flags = toFlags(visibility);
		if(isAbstract)
			flags |= Flags.AccAbstract;
		if(isStatic)
			flags |= Flags.AccStatic;
		if(isFinal)
			flags |= Flags.AccFinal;
		return flags;
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
