/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.internal;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextLinkingDiagnostic implements XtextResource.Diagnostic{

	private final AbstractNode node;
	private final String message;

	public XtextLinkingDiagnostic(LeafNode linkInformation) {
		this(linkInformation, "Cannot resolve reference " + linkInformation.getText());
	}
	
	public XtextLinkingDiagnostic(AbstractNode linkInformation, String message) {
		this.node = linkInformation;
		this.message = message;
	}

	public int getLength() {
		return node.getLength();
	}

	public int getOffset() {
		return node.getOffset();
	}

	public int getColumn() {
		return 1;
	}

	public int getLine() {
		return node.getLine();
	}

	public String getLocation() {
		return null;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append(getClass().getSimpleName());
		b.append(": ");
		b.append(getLocation());
		b.append(":");
		b.append(getLine());
		b.append(" ");
		b.append(getMessage());
		return b.toString();
	}

}
