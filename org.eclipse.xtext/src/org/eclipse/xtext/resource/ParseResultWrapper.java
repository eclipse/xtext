/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.detachable.DetachableParseResult;
import org.eclipse.xtext.nodemodel.detachable.DetachableParseResultWrapper;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

/**
 * Low level API to customize the way the parse result and thereby the node model is stored.
 * 
 * @see DetachableParseResult
 * @see DetachableParseResultWrapper
 * @since 2.35
 */
public class ParseResultWrapper {

	public Triple<EObject, EReference, INode> toProxyInformation(IParseResult parseResult, EObject obj, EReference ref, INode node) {
		return Tuples.create(obj, ref, node);
	}

	public IDiagnosticProducer wrap(IParseResult parseResult, IDiagnosticProducer producer) {
		return producer;
	}
	
	public IParseResult release(IParseResult parseResult) {
		return null;
	}
	
	public IParseResult acquire(IParseResult parseResult) {
		return parseResult;
	}
	
	public boolean customWriteNodeModel(XtextResource resource, OutputStream outputStream) throws IOException {
		return false;
	}
	
	public boolean customReadNodeModel(XtextResource resource, InputStream inputStream) throws IOException {
		return false;
	}
	
}