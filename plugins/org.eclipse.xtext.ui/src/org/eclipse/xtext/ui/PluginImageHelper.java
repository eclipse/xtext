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
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
public class PluginImageHelper implements IImageHelper, IImageDescriptorHelper, SynchronousBundleListener {
	private Map<ImageDescriptor, Image> registry = Maps.newHashMapWithExpectedSize(10);

	@Inject
	private AbstractUIPlugin plugin;

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.pathSuffix")
	private String pathSuffix = "icons/"; //$NON-NLS-1$

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.defaultImage")
	private String defaultImage = "default.gif"; //$NON-NLS-1$

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.notFound")
	private String notFound = "notFound.gif"; //$NON-NLS-1$

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
	 * Disposes all images managed by this image helper.
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
	
	/**
	 * @since 2.4
	 */
	public ImageDescriptor getImageDescriptor(String imageName) {
		String imgname = imageName == null ? defaultImage : imageName;
		if (imgname != null) {
			URL imgUrl = getPlugin().getBundle().getEntry(getPathSuffix() + imgname);
			if (imgUrl != null) {
				return ImageDescriptor.createFromURL(imgUrl);
			}
			if (!imgname.equals(notFound)) {
				return getImageDescriptor(notFound);
			}
		}
		return null;
	}
	
	/**
	 * @since 2.4
	 */
	public ImageDescriptor getImageDescriptor(Image image) {
		for(Map.Entry<ImageDescriptor, Image> entry : registry.entrySet()) {
			if(entry.getValue().equals(image))
				return entry.getKey();
		}
		ImageDescriptor newDescriptor = ImageDescriptor.createFromImage(image);
		registry.put(newDescriptor, image);
		return newDescriptor;
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
		if (event.getType() == BundleEvent.STOPPING
				&& event.getBundle().getBundleId() == getPlugin().getBundle().getBundleId()) {
			dispose();
		}
	}

}
