/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting2;

import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContentFormatterFactory implements IContentFormatterFactory {

	@Inject
	private Provider<ContentFormatter> formatter;

	@Override
	public IContentFormatter createConfiguredFormatter(SourceViewerConfiguration cfg, ISourceViewer sourceViewer) {
		return formatter.get();
	}

}
