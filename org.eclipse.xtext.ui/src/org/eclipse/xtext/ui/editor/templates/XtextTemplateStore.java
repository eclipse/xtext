/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.text.templates.TemplatePersistenceData;
import org.eclipse.text.templates.TemplateReaderWriter;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
@Singleton
public class XtextTemplateStore extends TemplateStore {

	private final static Logger log = Logger.getLogger(XtextTemplateStore.class);
	private final URL resource;

	@Inject
	public XtextTemplateStore(ContextTypeRegistry registry, IPreferenceStore store, @Named(Constants.LANGUAGE_NAME) String key,
			AbstractUIPlugin plugin) {
		super(registry, store, key + ".templates");
		resource = getTemplateFileURL(plugin);
		try {
			load();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
	/**
	 * @since 2.24
	 */
	protected URL getResource() {
		return resource;
	}

	protected URL getTemplateFileURL(AbstractUIPlugin plugin) {
		return plugin.getBundle().getEntry("templates/templates.xml");
	}

	@Override
	protected void loadContributedTemplates() throws IOException {
		if (resource==null)
			return;
		TemplateReaderWriter reader = new TemplateReaderWriter();
		InputStream openStream = null;
		try {
			openStream = resource.openStream();
			try {
				TemplatePersistenceData[] read = reader.read(openStream, null);
				for (TemplatePersistenceData templatePersistenceData : read) {
					internalAdd(templatePersistenceData);
				}
			} finally {
				openStream.close();
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	protected void handleException(IOException x) {
		log.error(x.getMessage(), x);
	}
}
