/*******************************************************************************
 * Copyright (c) 2008, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/** Helper for loading images from plugins.
 *
 * <p>
 * This helper enables to find the images within the current plugin and other
 * plugins. In case the image is located within another plugin than the current
 * one, the image's name should be qualifed with the plugin's identifier:
 * {@code platform:/plugin/<plugin_identifier>/<image_name>.<image_filename_extension>}.
 * The image name must not contains a dot character.
 * For example, the following name corresponds to the image with the name
 * {@code "mypicture.png"} within the plugin with the identifier
 * {@code "org.myorganization.myplugin"}.
 * <pre><code>platform:/plugin/org.myorganization.myplugin/mypicture.png</code></pre>
 * </p>
 *
 * @author Sebastian Zarnekow
 * @author Stephane Galland - Add function for searching the images within plugins.
 */
@Singleton
public class PluginImageHelper implements IImageHelper, IImageDescriptorHelper, SynchronousBundleListener {

	private static final String PLATFORM_URL_PREFIX = "platform:/plugin/";

	private static final String PLATFORM_URL_SEPARATOR = "/";

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

	private DisplayDisposeListener displayDisposeListener = null;

	/**
	 * Returns the image associated with the given image descriptor.
	 * 
	 * @param descriptor
	 *            the image descriptor for which the helper manages an image, or <code>null</code> for a missing image
	 *            descriptor
	 * @return the image associated with the image descriptor or <code>null</code> if the image descriptor can't create
	 *         the requested image.
	 */
	@Override
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
			putToRegistry(descriptor, result);
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
		if (displayDisposeListener != null) {
			displayDisposeListener.setHelper(null);
			displayDisposeListener = null;
		}
	}

	@Inject
	public void hookBundleListener(AbstractUIPlugin plugin) {
		plugin.getBundle().getBundleContext().addBundleListener(this);
	}

	@Override
	public Image getImage(String imageName) {
		ImageDescriptor descriptor = findImage(imageName);
		if (descriptor != null) {
			return getImage(descriptor);
		}
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
	@Override
	public ImageDescriptor getImageDescriptor(String imageName) {
		final ImageDescriptor descriptor = findImage(imageName);
		if (descriptor != null) {
			return descriptor;
		}
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
	@Override
	public ImageDescriptor getImageDescriptor(Image image) {
		for(Map.Entry<ImageDescriptor, Image> entry : registry.entrySet()) {
			if(entry.getValue().equals(image))
				return entry.getKey();
		}
		ImageDescriptor newDescriptor = ImageDescriptor.createFromImage(image);
		putToRegistry(newDescriptor, image);
		return newDescriptor;
	}

	/**
	 * @since 2.26
	 */
	protected void putToRegistry(ImageDescriptor descriptor, Image image) {
		if (displayDisposeListener == null) {
			displayDisposeListener = new DisplayDisposeListener(this);
			Display.getCurrent().disposeExec(displayDisposeListener);
		}
		registry.put(descriptor, image);
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

	@Override
	public void bundleChanged(BundleEvent event) {
		if (event.getType() == BundleEvent.STOPPING
				&& event.getBundle().getBundleId() == getPlugin().getBundle().getBundleId()) {
			dispose();
		}
	}

	/** Find the descriptor of the image with the given id.
	 *
	 * The name given as argument should be the name of the image to be found
	 * qualified by the identifier of the plugin in which the image is located:
	 * {@code platform:/plugin/<plugin_identifier>/<image_name>.<image_filename_extension>}.
	 * The image name must not contain a dot character.
	 *
	 * For example, the following name corresponds to the image with the name
	 * {@code "mypicture.png"} within the plugin with the identifier
	 * {@code "org.myorganization.myplugin"}.
	 *
	 * <pre><code>platform:/plugin/org.myorganization.myplugin/mypicture.png</code></pre>
	 *
	 * @param name the identifier of the image. It may be qualified with the plugin's id.
	 * @return the descriptor.
	 * @since 2.14
	 */
	protected ImageDescriptor findImage(String name) {
		if (name != null && name.startsWith(PLATFORM_URL_PREFIX)) {
			final int index = name.indexOf(PLATFORM_URL_SEPARATOR, PLATFORM_URL_PREFIX.length());
			if (index >= 0) {
				final String pluginId = name.substring(
					PLATFORM_URL_PREFIX.length(), index);
				final String imageId = name.substring(index + 1);
				return AbstractUIPlugin.imageDescriptorFromPlugin(pluginId,
							getPathSuffix() + imageId);
			}
		}
		return null;
	}
	
	/**
	 * @since 2.26
	 */
	public static class DisplayDisposeListener implements Runnable {

		private PluginImageHelper helper;

		public DisplayDisposeListener(PluginImageHelper helper) {
			this.helper = helper;
		}

		public PluginImageHelper getHelper() {
			return helper;
		}

		public void setHelper(PluginImageHelper helper) {
			this.helper = helper;
		}

		@Override
		public void run() {
			if (helper != null) {
				helper.dispose();
			}
			helper = null;
		}

	}

}
