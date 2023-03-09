/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static org.eclipse.xtext.util.Strings.*;

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

	public ITextRegion computeRegion(XtextResource resource) {
		XImportSection xImportSection = config.getImportSection(resource);
		// try to obtain the region from the text if it is not a synthetic region.
		if (xImportSection != null && xImportSection.eResource() != null) {
			INode node = NodeModelUtils.findActualNodeFor(xImportSection);
			if(node == null) 
				LOG.error("Cannot detect node for original import section");
			else 
				return node.getTextRegion();
		} 
		return new TextRegion(config.getImportSectionOffset(resource), 0);
	}

	public ITextRegion addLeadingWhitespace(ITextRegion textRegion, XtextResource resource) {
		String text = resource.getParseResult().getRootNode().getText();
		int offset = textRegion.getOffset();
		int length = textRegion.getLength();
		while(offset > 0 && Character.isWhitespace(text.charAt(offset-1)) ){
			--offset;
			++length;
		}
		return new TextRegion(offset, length);
	}
	
	public ITextRegion addTrailingWhitespace(ITextRegion textRegion, XtextResource resource) {
		String text = resource.getParseResult().getRootNode().getText();
		int offset = textRegion.getOffset();
		int length = textRegion.getLength();
		while(offset + length < text.length() && Character.isWhitespace(text.charAt(offset+length))) {
			++length;
		}
		return new TextRegion(offset, length);
	}

	public ITextRegion addTrailingSingleWhitespace(ITextRegion textRegion, String lineSeparator, XtextResource resource) {
		String text = resource.getParseResult().getRootNode().getText();
		String theFollowing = text.substring(textRegion.getOffset() + textRegion.getLength());
		if(!isEmpty(theFollowing)) { 
			if(theFollowing.startsWith(lineSeparator)) 
				return new TextRegion(textRegion.getOffset(), textRegion.getLength() + lineSeparator.length());
			else if(Character.isWhitespace(theFollowing.charAt(0)))
				return new TextRegion(textRegion.getOffset(), textRegion.getLength() + 1);
		}
		return textRegion;
	}
}
