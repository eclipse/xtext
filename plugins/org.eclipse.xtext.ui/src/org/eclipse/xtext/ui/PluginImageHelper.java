/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow
 */
public class PluginImageHelper implements IImageHelper, BundleListener {
	private Map<ImageDescriptor, Image> registry = Maps.newHashMapWithExpectedSize(10);

	@Inject
	private AbstractUIPlugin plugin;

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.pathSuffix")
	private String pathSuffix = "icons/";

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.defaultImage")
	private String defaultImage = "default.gif";

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.notFound")
	private String notFound = "notFound.gif";

	/**
	 * Returns the image associated with the given image descriptor.
	 * 
	 * @param descriptor
	 *            the image descriptor for which the helper manages an image, or <code>null</code> for a missing image
	 *            descriptor
	 * @return the image associated with the image descriptor or <code>null</code> if the image descriptor can't create
	 *         the requested image.
	 */
	public Image getImage(ImageDescriptor descriptor) {
		if (descriptor == null) {
			descriptor = ImageDescriptor.getMissingImageDescriptor();
		}

		Image result = registry.get(descriptor);
		if (result != null) {
			return result;
		}
		result = descriptor.createImage();
		if (result != null) {
			registry.put(descriptor, result);
		}
		return result;
	}

	/**
	 * Disposes all images managed by this iamge helper.
	 */
	public void dispose() {
		for (Iterator<Image> iter = registry.values().iterator(); iter.hasNext();) {
			Image image = iter.next();
			image.dispose();
		}
		registry.clear();
	}

	@Inject
	public void hookBundleListener(AbstractUIPlugin plugin) {
		plugin.getBundle().getBundleContext().addBundleListener(this);
	}

	public Image getImage(String imageName) {
		String imgname = imageName == null ? defaultImage : imageName;
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
			}
			if (!imgname.equals(notFound)) {
				return getImage(notFound);
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

	public String getDefaultImage() {
		return defaultImage;
	}

	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}

	public void bundleChanged(BundleEvent event) {
		if (event.getType() == BundleEvent.STOPPED) {
			dispose();
		}
	}

}
