/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.coloring

import com.google.common.collect.ImmutableList
import java.util.Collections
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.lsp4j.ColoringInformation
import org.eclipse.lsp4j.ColoringStyle
import org.eclipse.lsp4j.Range
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.coloring.IColoringService
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource

import static org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage.Literals.MEMBER__NAME

/**
 * Basic coloring service that highlights the method and variable declarations
 * for testing purposes.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@Deprecated
class ColoringServiceImpl implements IColoringService {

	static val STYLE_IDS = Collections.singletonList(ColoringStyle.Identifier);

	override getColoring(XtextResource resource, Document document) {
		if (resource === null) {
			return emptyList;
		}
		val builder = ImmutableList.builder;
		EcoreUtil.getAllContents(resource, true).forEach [
			val nodes = if (it instanceof Property) {
					NodeModelUtils.findNodesForFeature(it, MEMBER__NAME);
				} else if (it instanceof Operation) {
					NodeModelUtils.findNodesForFeature(it, MEMBER__NAME);
				} else {
					emptyList;
				}
			nodes.forEach [
				val start = offset;
				val end = offset + length;
				val range = new Range(document.getPosition(start), document.getPosition(end));
				builder.add(new ColoringInformation(range, STYLE_IDS));
			]
		];
		return builder.build;
	}

}
