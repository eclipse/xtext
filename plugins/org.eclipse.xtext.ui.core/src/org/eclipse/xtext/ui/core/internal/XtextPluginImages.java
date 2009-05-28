/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.internal;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * Bundle of all images used by the Xtext UI plugin. Inspired by
 * PDEPluginImages.
 * 
 * @author Peter Friese - Initial contribution and API
 * @author Dennis Hübner
 * 
 */
public class XtextPluginImages {

	private static final String NAME_PREFIX = Activator.PLUGIN_ID + "."; //$NON-NLS-1$

	private static ImageRegistry PLUGIN_REGISTRY;

	public final static String ICONS_PATH = "icons/"; //$NON-NLS-1$

	/**
	 * Set of predefined Image Descriptors.
	 */

	private static final String PATH_OBJ = ICONS_PATH + "obj16/"; //$NON-NLS-1$
	//    private static final String PATH_VIEW = ICONS_PATH + "view16/"; //$NON-NLS-1$
	private static final String PATH_LCL = ICONS_PATH + "elcl16/"; //$NON-NLS-1$
	private static final String PATH_LCL_DISABLED = ICONS_PATH + "dlcl16/"; //$NON-NLS-1$
	//    private static final String PATH_TOOL = ICONS_PATH + "etool16/"; //$NON-NLS-1$
	//    private static final String PATH_OVR = ICONS_PATH + "ovr16/"; //$NON-NLS-1$
	//    private static final String PATH_WIZBAN = ICONS_PATH + "wizban/"; //$NON-NLS-1$

	/**
	 * Frequently used images
	 */
	public static final String OBJ_DESC_SERVICE_LOADED = NAME_PREFIX + "OBJ_DESC_SERVICE_LOADED"; //$NON-NLS-1$
	public static final String OBJ_DESC_SERVICE_NOT_LOADED = NAME_PREFIX + "OBJ_DESC_SERVICE_NOT_LOADED"; //$NON-NLS-1$
	public static final String OBJ_DESC_LANGUAGE = NAME_PREFIX + "OBJ_DESC_LANGUAGE"; //$NON-NLS-1$

	/**
	 * OBJ16
	 */
	public static final ImageDescriptor DESC_SERVICE_LOADED_OBJ = create(PATH_OBJ, "service_loaded.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_SERVICE_NOT_LOADED_OBJ = create(PATH_OBJ, "service_not_loaded.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_LANGUAGE_OBJ = create(PATH_OBJ, "font.gif"); //$NON-NLS-1$

	/**
	 * OVR16
	 */

	/**
	 * TOOL16
	 */

	/**
	 * LCL
	 */
	public static final ImageDescriptor DESC_LINK_WITH_EDITOR = create(PATH_LCL, "synced.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ALPHAB_SORT_CO = create(PATH_LCL, "alphab_sort_co.gif"); //$NON-NLS-1$

	public static final ImageDescriptor DESC_LINK_WITH_EDITOR_DISABLED = create(PATH_LCL_DISABLED, "synced.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ALPHAB_SORT_CO_DISABLED = create(PATH_LCL_DISABLED, "alphab_sort_co.gif"); //$NON-NLS-1$

	/**
	 * WIZ
	 */

	/**
	 * View
	 */

	private static ImageDescriptor create(String prefix, String name) {
		return ImageDescriptor.createFromURL(makeImageURL(prefix, name));
	}

	public static Image get(String key) {
		if (PLUGIN_REGISTRY == null)
			initialize();
		return PLUGIN_REGISTRY.get(key);
	}

	/* package */
	private static final void initialize() {
		PLUGIN_REGISTRY = new ImageRegistry();
		manage(OBJ_DESC_SERVICE_LOADED, DESC_SERVICE_LOADED_OBJ);
		manage(OBJ_DESC_SERVICE_NOT_LOADED, DESC_SERVICE_NOT_LOADED_OBJ);
		manage(OBJ_DESC_LANGUAGE, DESC_LANGUAGE_OBJ);
	}

	private static URL makeImageURL(String prefix, String name) {
		String path = "$nl$/" + prefix + name; //$NON-NLS-1$
		return FileLocator.find(Activator.getDefault().getBundle(), new Path(path), null);
	}

	public static Image manage(String key, ImageDescriptor desc) {
		Image image = desc.createImage();
		PLUGIN_REGISTRY.put(key, image);
		return image;
	}
}
