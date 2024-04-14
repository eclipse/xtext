/**
 * Copyright (c) 2019, 2022 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.rename;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.server.rename.RenameService2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;

public class TestLanguageRenameService extends RenameService2 {
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Override
	protected EObject getElementWithIdentifierAt(XtextResource xtextResource, int offset) {
		if (offset >= 0) {
			if (xtextResource != null) {
				IParseResult parseResult = xtextResource.getParseResult();
				if (parseResult != null) {
					ICompositeNode rootNode = parseResult.getRootNode();
					if (rootNode != null) {
						ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
						if (leaf != null) {
							EObject element = eObjectAtOffsetHelper.getElementWithNameAt(xtextResource, offset);
							if (element != null) {
								IQualifiedNameProvider nameProvider = xtextResource.getResourceServiceProvider()
										.get(IQualifiedNameProvider.class);
								QualifiedName fqn = nameProvider.getFullyQualifiedName(element);
								if (fqn != null) {
									String leafText = NodeModelUtils.getTokenText(leaf);
									if (fqn.getSegmentCount() == 1 && Objects.equals(fqn.toString(), leafText)
											|| Objects.equals(fqn.getLastSegment(), leafText)) {
										return element;
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}
