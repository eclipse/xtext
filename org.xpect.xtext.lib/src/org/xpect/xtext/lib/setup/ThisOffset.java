/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.XtextResource;
import org.xpect.XpectImport;
import org.xpect.XpectInvocation;
import org.xpect.parameter.AbstractOffsetProvider;
import org.xpect.parameter.IParameterProvider;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.xtext.lib.setup.ThisOffset.ThisOffsetProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@XpectImport({ XtextStandaloneSetup.class, ThisOffsetProvider.class, XtextWorkspaceSetup.class })
public @interface ThisOffset {

	@XpectSetupFactory
	public static class ThisOffsetProvider extends AbstractOffsetProvider {
		private final XpectInvocation invocation;
		private final XtextResource resource;

		public ThisOffsetProvider(XpectInvocation invocation, @ThisResource XtextResource resource) {
			this.invocation = invocation;
			this.resource = resource;
		}

		public XpectInvocation getInvocation() {
			return invocation;
		}

		@Override
		@Creates(ThisOffset.class)
		public int getOffset() {
			INode invNode = NodeModelUtils.getNode(invocation);
			int invEnd = invNode.getOffset() + invNode.getLength();
			INode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), invEnd);
			NodeIterator ni = new NodeIterator(node);
			while (ni.hasNext()) {
				INode next = ni.next();
				if (next instanceof ILeafNode && !((ILeafNode) next).isHidden())
					return next.getOffset();
			}
			return -1;
		}

		@Creates(ThisOffset.class)
		public IParameterProvider getProvider() {
			return this;
		}

		public XtextResource getResource() {
			return resource;
		}
	}
}
