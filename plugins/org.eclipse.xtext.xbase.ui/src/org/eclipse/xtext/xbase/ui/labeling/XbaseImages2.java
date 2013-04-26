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

import static org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider.*;

import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * Obsoletes {@link XbaseImages} to allow better adornments. Use {@link XbaseImageAdornments} for 
 * calculating adornments.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4.2
 */
public class XbaseImages2 {
		
	public Image forImportContainer() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_IMPCONT);
	}

	public Image forImport() {
		return getJdtImage(JavaPluginImages.DESC_OBJS_IMPDECL);
	}

	/**
	 * @param visibility the visibility of the class
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forClass(JvmVisibility visibility, int adornments) {
		return getDecorated(getTypeImageDescriptor(false, false, toFlags(visibility), false), adornments);
	}

	/**
	 * @param visibility the visibility of the interface
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forInterface(JvmVisibility visibility, int adornments) {
		return getDecorated(getTypeImageDescriptor(false, true, toFlags(visibility) | Flags.AccInterface, false), adornments);
	}

	/**
	 * @param visibility the visibility of the enum
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forEnum(JvmVisibility visibility, int adornments) {
		return getDecorated(getTypeImageDescriptor(false, false, toFlags(visibility) | Flags.AccEnum, false), adornments);
	}

	/**
	 * @param visibility the visibility of the annotation type
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forAnnotation(JvmVisibility visibility, int adornments) {
		return getDecorated(getTypeImageDescriptor(false, true, toFlags(visibility) | Flags.AccAnnotation, false), adornments);
	}

	/**
	 * @param visibility the visibility of the constructor
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forConstructor(JvmVisibility visibility, int adornments) {
		return getDecorated(getMethodImageDescriptor(false, toFlags(visibility)), adornments | 
				JavaElementImageDescriptor.CONSTRUCTOR);
	}

	/**
	 * @param visibility the visibility of the operation
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forOperation(JvmVisibility visibility, int adornments) {
		return getDecorated(getMethodImageDescriptor(false, toFlags(visibility)), adornments);
	}
	
	/**
	 * @param visibility the visibility of the field
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forField(JvmVisibility visibility, int adornments) {
		return getDecorated(getFieldImageDescriptor(false, toFlags(visibility)), adornments);
	}
	
	/**
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forLocalVariable(int adornments){
		return getDecorated(JavaPluginImages.DESC_OBJS_LOCAL_VARIABLE, adornments);
	}
	
	/**
	 * @param adornments OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public Image forTypeParameter(int adornments) {
		return getDecorated(JavaPluginImages.DESC_OBJS_TYPEVARIABLE, adornments);
	}

	protected Image getJdtImage(ImageDescriptor descriptor) {
		return JavaPlugin.getImageDescriptorRegistry().get(descriptor);
	}

	protected Image getDecorated(ImageDescriptor baseImage, int adornments) {
		if(adornments == 0)
			return getJdtImage(baseImage);
		else
			return getDecoratedImage(baseImage, adornments, JavaElementImageProvider.SMALL_SIZE);
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
