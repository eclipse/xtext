/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow
 */
public class PluginImageHelper implements IImageHelper {

	@Inject
	private AbstractUIPlugin plugin;
	
	@Inject(optional=true)
	@Named("org.eclipse.xtext.ui.core.PluginImageHelper.pathSuffix")
	private String pathSuffix = "icons/";
	
	@Inject(optional=true)
	@Named("org.eclipse.xtext.ui.core.PluginImageHelper.defaultImage")
	private String defaultImage = "default.gif";
	
	@Inject(optional=true)
	@Named("org.eclipse.xtext.ui.core.PluginImageHelper.notFound")
	private String notFound = "notFound.gif";
	
	public Image getImage(String imgname) {
		if (imgname == null)
			imgname = defaultImage;
		if (imgname != null) {
			Image result = null;
			URL imgUrl = getPlugin().getBundle().getEntry(getPathSuffix() + imgname);
			if (imgUrl != null) {
				ImageDescriptor id = null;
				result = getPlugin().getImageRegistry().get(imgUrl.toExternalForm());
				if (result == null) {
					id = ImageDescriptor.createFromURL(imgUrl);
					if (id != null) {
						result = id.createImage();
						getPlugin().getImageRegistry().put(imgUrl.toExternalForm(), result);
					}
				}
				return result;
			} else {
				if (!imgname.equals(notFound)) {
					return getImage(notFound);
				}
			}
		}
		return null;
	}

	public void setPathSuffix(String pathSuffix) {
		this.pathSuffix = pathSuffix;
	}

	public String getPathSuffix() {
		return pathSuffix;
	}

	public void setPlugin(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}

	public AbstractUIPlugin getPlugin() {
		return plugin;
	}

	public void setNotFound(String notFound) {
		this.notFound = notFound;
	}

	public String getNotFound() {
		return notFound;
	}
}
