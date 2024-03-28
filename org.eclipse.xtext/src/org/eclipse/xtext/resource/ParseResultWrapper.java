package org.eclipse.xtext.resource;

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
	
}