/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class LanguageConfig extends CompositeGeneratorFragment {

	private Grammar grammar;

	public void setUri(String uri) {
		XtextResourceSet rs = new XtextResourceSet();
		Resource resource = rs.getResource(URI.createURI(uri), true);
		if (resource.getContents().isEmpty()) {
			throw new IllegalArgumentException("Couldn't load grammar for '" + uri + "'.");
		}
		grammar = (Grammar) resource.getContents().get(0);
		EValidator validator = EValidator.Registry.INSTANCE.getEValidator(XtextPackage.eINSTANCE);
		if (validator != null) {
			DiagnosticChain chain = new DiagnosticChain() {

				public void add(Diagnostic diagnostic) {
					if (diagnostic.getSeverity() == Diagnostic.ERROR)
						throw new IllegalStateException(diagnostic.getMessage());
				}

				public void addAll(Diagnostic diagnostic) {
					add(diagnostic);
				}

				public void merge(Diagnostic diagnostic) {
					throw new UnsupportedOperationException();
				}
			};
			validator.validate(grammar, chain, null);
			TreeIterator<EObject> iterator = grammar.eAllContents();
			while (iterator.hasNext())
				validator.validate(iterator.next(), chain, null);
		}
	}

	/**
	 * @return
	 */
	public Grammar getGrammar() {
		return grammar;
	}

}
