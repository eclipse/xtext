/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import org.apache.log4j.Logger;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportSectionRegionUtil {

	private static final Logger LOG = Logger.getLogger(ImportSectionRegionUtil.class);

	@Inject
	private IImportsConfiguration config;

	public TextRegion computeRegion(XtextResource resource) {
		XImportSection xImportSection = config.getImportSection(resource);
		if (xImportSection != null) {
			INode node = NodeModelUtils.findActualNodeFor(xImportSection);
			if(node == null) 
				LOG.error("Cannot detect node for original import section");
			else 
				return new TextRegion(node.getOffset(), node.getLength());
		} 
		return new TextRegion(config.getImportSectionOffset(resource), 0);
	}

	public TextRegion addLeadingWhitespace(ITextRegion textRegion, XtextResource resource) {
		String text = resource.getParseResult().getRootNode().getText();
		int offset = textRegion.getOffset();
		int length = textRegion.getLength();
		while(offset > 0 && Character.isWhitespace(text.charAt(offset-1)) ){
			--offset;
			++length;
		}
		return new TextRegion(offset, length);
	}
	
	public TextRegion addTrailingWhitespace(ITextRegion textRegion, XtextResource resource) {
		String text = resource.getParseResult().getRootNode().getText();
		int offset = textRegion.getOffset();
		int length = textRegion.getLength();
		while(offset + length < text.length() && Character.isWhitespace(text.charAt(offset+length))) {
			++length;
		}
		return new TextRegion(offset, length);
	}

}
