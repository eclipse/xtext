/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportSectionSerializer {

	private static final Logger LOG = Logger.getLogger(ImportSectionSerializer.class);
	
	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;
	
	@Inject
	private IImportsConfiguration config;
	
	public ReplaceRegion serialize(XtextResource resource, ImportCollection newImportCollection) {
		if(resource == null)
			return null;
		String lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI()).getLineSeparator();
		String serializedImports = serializeImports(newImportCollection, lineSeparator);
		String newImportSectionText = addLineBreaks(serializedImports, resource, lineSeparator);
		TextRegion importSectionRegion = computeRegion(resource);
		return new ReplaceRegion(importSectionRegion.getOffset(), importSectionRegion.getLength(), newImportSectionText);
	}

	protected String addLineBreaks(String serializedImports, XtextResource resource, String lineSeparator) {
		StringBuffer sectionText = new StringBuffer();
		if(!isEmpty(config.getCommonPackageName(resource)))
			sectionText.append(lineSeparator).append(lineSeparator);
		sectionText.append(serializedImports);
		if(!isEmpty(serializedImports)) 
			sectionText.append(lineSeparator);
		String newImportSectionText = sectionText.toString();
		return newImportSectionText;
	}
	
	public String serializeImports(ImportCollection importSection, String lineSeparator) {
		StringBuilder importsSection = new StringBuilder();
		boolean needNewline = false;
		if (!importSection.getImportedTypes().isEmpty()) {
			for (JvmDeclaredType type : getSorted(importSection.getImportedTypes())) {
				importsSection.append("import ").append(type.getIdentifier()).append(lineSeparator);
			}
			needNewline = true;
		}
		if (!importSection.getStaticImports().isEmpty()) {
			if(needNewline)
				importsSection.append(lineSeparator);
			for (JvmDeclaredType type : getSorted(importSection.getStaticImports())) {
				importsSection.append("import static ").append(type.getIdentifier()).append(".*").append(lineSeparator);
			}
			needNewline = true;
		}
		if (!importSection.getExtensionImports().isEmpty()) {
			if(needNewline)
				importsSection.append(lineSeparator);
			for (JvmDeclaredType type : getSorted(importSection.getExtensionImports())) {
				importsSection.append("import static extension ").append(type.getIdentifier()).append(".*").append(lineSeparator);
			}
		}
		return importsSection.toString();
	}
	
	protected List<JvmDeclaredType> getSorted(Iterable<JvmDeclaredType> types) {
		List<JvmDeclaredType> sortMe = newArrayList(types);
		Collections.sort(sortMe, new Comparator<JvmDeclaredType>() {
			public int compare(JvmDeclaredType o1, JvmDeclaredType o2) {
				return o1.getIdentifier().compareTo(o2.getIdentifier());
			}
		});
		return sortMe;
	}

	public TextRegion computeRegion(XtextResource resource) {
		XImportSection xImportSection = config.getImportSection(resource);
		if (xImportSection != null) {
			INode node = NodeModelUtils.findActualNodeFor(xImportSection);
			if(node == null) 
				LOG.error("Cannot detect node for original import section");
			else 
				return addSurroundingWhitespace(node.getOffset(), node.getLength(), resource);
		} 
		return addSurroundingWhitespace(config.getImportSectionOffset(resource), 0, resource);
	}

	protected TextRegion addSurroundingWhitespace(int offset, int length, XtextResource resource) {
		String text = resource.getParseResult().getRootNode().getText();
		while(offset > 0 && Character.isWhitespace(text.charAt(offset-1)) ){
			--offset;
			++length;
		}
		while(offset + length < text.length() && Character.isWhitespace(text.charAt(offset+length))) {
			++length;
		}
		return new TextRegion(offset, length);
	}
}
