/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.labeling;

import static org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider.*;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * Obsoletes XbaseImages to allow better adornments and use {@link ImageDescriptor}s instead of
 * {@link org.eclipse.swt.graphics.Image}s. Use {@link XbaseImageAdornments} for calculating adornments.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4.2
 */
@SuppressWarnings("restriction")
public class XbaseImages2 {

	public ImageDescriptor forImportContainer() {
		return getDecorated(JavaPluginImages.DESC_OBJS_IMPCONT, 0);
	}

	public ImageDescriptor forImport() {
		return JavaPluginImages.DESC_OBJS_IMPDECL;
	}

	/**
	 * @param visibility
	 *            the visibility of the class
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forClass(JvmVisibility visibility, int adornments) {
		return getDecorated(getTypeImageDescriptor(true, false, toFlags(visibility), false), adornments);
	}

	/**
	 * @param visibility
	 *            the visibility of the interface
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forInterface(JvmVisibility visibility, int adornments) {
		return getDecorated(getTypeImageDescriptor(true, false, toFlags(visibility) | Flags.AccInterface, false),
				adornments);
	}

	/**
	 * @param visibility
	 *            the visibility of the enum
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forEnum(JvmVisibility visibility, int adornments) {
		return getDecorated(getTypeImageDescriptor(true, false, toFlags(visibility) | Flags.AccEnum, false),
				adornments);
	}

	/**
	 * @param visibility
	 *            the visibility of the annotation type
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forAnnotation(JvmVisibility visibility, int adornments) {
		return getDecorated(getTypeImageDescriptor(true, true, toFlags(visibility) | Flags.AccAnnotation, false),
				adornments);
	}

	/**
	 * @param visibility
	 *            the visibility of the constructor
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forConstructor(JvmVisibility visibility, int adornments) {
		return getDecorated(getMethodImageDescriptor(false, toFlags(visibility)), adornments
				| JavaElementImageDescriptor.CONSTRUCTOR);
	}

	/**
	 * @param visibility
	 *            the visibility of the operation
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forOperation(JvmVisibility visibility, int adornments) {
		return getDecorated(getMethodImageDescriptor(false, toFlags(visibility)), adornments);
	}

	/**
	 * @param visibility
	 *            the visibility of the field
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forField(JvmVisibility visibility, int adornments) {
		return getDecorated(getFieldImageDescriptor(false, toFlags(visibility)), adornments);
	}

	/**
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forLocalVariable(int adornments) {
		return getDecorated(JavaPluginImages.DESC_OBJS_LOCAL_VARIABLE, adornments);
	}

	/**
	 * @param adornments
	 *            OR-ed flags from {@link JavaElementImageDescriptor} to denote decorations
	 */
	public ImageDescriptor forTypeParameter(int adornments) {
		return getDecorated(JavaPluginImages.DESC_OBJS_TYPEVARIABLE, adornments);
	}

	protected ImageDescriptor getDecorated(ImageDescriptor baseImage, int adornments) {
		return new JavaElementImageDescriptor(baseImage, adornments, imagesSize());
	}

	/**
	 * Possible Values:<br>
	 * {@link JavaElementImageProvider#SMALL_SIZE}
	 * {@link JavaElementImageProvider#BIG_SIZE}
	 */
	protected Point imagesSize() {
		return JavaElementImageProvider.BIG_SIZE;
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
