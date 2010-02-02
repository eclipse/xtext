/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplatePersistenceData;
import org.eclipse.jface.text.templates.persistence.TemplateReaderWriter;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
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
	private final URL res;

	@Inject
	public XtextTemplateStore(ContextTypeRegistry registry, IPreferenceStore store, @Named(Constants.LANGUAGE_NAME) String key,
			AbstractUIPlugin plugin) {
		super(registry, store, key + ".templates");
		res = getTemplateFileURL(plugin);
		try {
			load();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	protected URL getTemplateFileURL(AbstractUIPlugin plugin) {
		return plugin.getBundle().getEntry("templates/templates.xml");
	}

	@Override
	protected void loadContributedTemplates() throws IOException {
		if (res==null)
			return;
		TemplateReaderWriter reader = new TemplateReaderWriter();
		InputStream openStream = null;
		try {
			openStream = res.openStream();
			try {
				TemplatePersistenceData[] read = reader.read(openStream, null);
				for (TemplatePersistenceData templatePersistenceData : read) {
					internalAdd(templatePersistenceData);
				}
			} finally {
				openStream.close();
			}
		} catch (IOException e) {
			log.error(e);
		}
	}

	@Override
	protected void handleException(IOException x) {
		log.error(x.getMessage(), x);
	}
}
