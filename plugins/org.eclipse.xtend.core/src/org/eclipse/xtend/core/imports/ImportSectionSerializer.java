/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.imports;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportSectionSerializer {

	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;
	
	public ReplaceRegion serialize(XtendFile xtendFile, SortedImportSection importSection) {
		String lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(xtendFile.eResource().getURI()).getLineSeparator();
		String serializedImports = serializeImports(importSection, lineSeparator);
		TextRegion importSectionRegion = computeRegion(xtendFile);
		StringBuffer sectionText = new StringBuffer();
		if(!isEmpty(xtendFile.getPackage()))
			sectionText.append(lineSeparator).append(lineSeparator);
		sectionText.append(serializedImports);
		if(!isEmpty(serializedImports)) 
			sectionText.append(lineSeparator);
		return new ReplaceRegion(importSectionRegion.getOffset(), importSectionRegion.getLength(), sectionText.toString());
	}
	
	public String serializeImports(SortedImportSection importSection, String lineSeparator) {
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

	public TextRegion computeRegion(XtendFile xtendFile) {
		if (xtendFile == null)
			return null;
		List<INode> packDecl = NodeModelUtils
				.findNodesForFeature(xtendFile, XtendPackage.Literals.XTEND_FILE__PACKAGE);
		int offset = 0;
		if (packDecl.size() >= 1)
			offset = packDecl.get(0).getOffset() + packDecl.get(0).getLength();
		if (xtendFile.getXtendTypes() == null)
			return null;
		if (xtendFile.getXtendTypes().isEmpty()) {
			ICompositeNode node = NodeModelUtils.getNode(xtendFile);
			if (node == null)
				throw new IllegalStateException("Cannot find node for clazz " + xtendFile.getClass().getName());
			return new TextRegion(offset, node.getTotalEndOffset() - offset);
		}
		ICompositeNode node = NodeModelUtils.getNode(xtendFile.getXtendTypes().get(0));
		if (node == null)
			throw new IllegalStateException("Cannot find node for clazz " + xtendFile.getClass().getName());
		int length = node.getTotalOffset() - offset;
		for(ILeafNode leaf: node.getLeafNodes()) {
			if(isEmpty(leaf.getText().trim())) 
				length += leaf.getLength();
			else
				break;
		}
		return new TextRegion(offset, length);
	}


}
