/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.core.runtime.Assert;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.actions.AbstractContentOutlineNodeHandler;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;

/**
 * TODO This is just a sample. I intend to replace it with some implementation
 * that actually does something meaningful, e.g. add a new subnode or find references to the
 * selected node.
 * @author Peter Friese - Initial contribution and API
 */
public class SampleOulineNodeHandler extends AbstractContentOutlineNodeHandler {

	@Override
	protected void doExecute(final IXtextDocument document, final ContentOutlineNode outlineNode) {
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) throws Exception {
				int offset = outlineNode.getSelectionOffset();

				IParseResult parseResult = resource.getParseResult();
				Assert.isNotNull(parseResult);
				CompositeNode rootNode = parseResult.getRootNode();
				AbstractNode currentNode = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, offset);
				if (currentNode instanceof LeafNode) {
					LeafNode leaf = (LeafNode) currentNode;
					System.out.println(leaf.getText());
				}
			}
		});
	}

}
