package org.eclipse.xtext.xtext.ui.graph.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GrammarParser {

	public Grammar parse(String rules) throws IOException {
		ResourceSet resourceSet = new XtextResourceSet();
		Resource grammarResource = resourceSet.createResource(URI.createURI("Test.xtext"));
		grammarResource.load(new StringInputStream(
				"grammar Test with org.eclipse.xtext.common.Terminals \n"
				+ "generate test \"Test\"\n" + rules), null);
		EList<EObject> contents = grammarResource.getContents();
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		assertTrue(root instanceof Grammar);
		return (Grammar) root;
	}

}
