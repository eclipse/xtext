package org.eclipse.xtext.ui.editor.formatting2;

import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContentFormatterFactory implements IContentFormatterFactory {

	@Inject
	private ContentFormatter formatter;

	public IContentFormatter createConfiguredFormatter(SourceViewerConfiguration cfg, ISourceViewer sourceViewer) {
		return formatter;
	}

}
