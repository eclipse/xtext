/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
public class SerializerGenFileNames {
	public static class GenFileName {
		private boolean _abstract;
		private String component;
		private String fileext;
		private Grammar grammar;
		private Naming naming;

		public GenFileName(Grammar grammar, Naming naming, boolean _abstract, String component, String fileext) {
			super();
			this.grammar = grammar;
			this.naming = naming;
			this._abstract = _abstract;
			this.component = component;
			this.fileext = fileext;
		}

		public String getFileName() {
			return naming.asPath(getQualifiedName()) + "." + fileext;
		}

		protected String getName(Grammar grammar, String component) {
			String prefix = _abstract ? "Abstract" : "";
			return naming.basePackageRuntime(grammar) + ".serializer." + prefix
					+ naming.toSimpleName(grammar.getName()) + component;
		}

		public String getPackageName() {
			return naming.toPackageName(getQualifiedName());
		}

		public String getQualifiedName() {
			return getName(grammar, component);
		}

		public String getQualifiedName(Grammar grammar) {
			return getName(grammar, component);
		}

		public String getSimpleName() {
			return naming.toSimpleName(getQualifiedName());
		}

		public String getSimpleName(Grammar grammar) {
			return naming.toSimpleName(getQualifiedName(grammar));
		}

		public boolean isAbstract() {
			return _abstract;
		}
	}

	private GenFileName abstractSemanticSequencer;
	private GenFileName abstractSyntacticSequencer;
	private GenFileName grammarConstraints;
	private GenFileName semanticSequencer;
	private GenFileName syntacticSequencer;

	@Inject
	public SerializerGenFileNames(Naming naming, Grammar grammar, @Named("generateXtendStub")Boolean generateXtendStub) {
		String stubExtension = (generateXtendStub) ? "xtend" : "java";
		semanticSequencer = new GenFileName(grammar, naming, false, "SemanticSequencer", stubExtension);
		syntacticSequencer = new GenFileName(grammar, naming, false, "SyntacticSequencer", stubExtension);
		abstractSemanticSequencer = new GenFileName(grammar, naming, true, "SemanticSequencer", "java");
		abstractSyntacticSequencer = new GenFileName(grammar, naming, true, "SyntacticSequencer", "java");
		grammarConstraints = new GenFileName(grammar, naming, false, "GrammarConstraints", "xtext");
	}

	public GenFileName getAbstractSemanticSequencer() {
		return abstractSemanticSequencer;
	}

	public GenFileName getAbstractSyntacticSequencer() {
		return abstractSyntacticSequencer;
	}

	public GenFileName getGrammarConstraints() {
		return grammarConstraints;
	}

	public GenFileName getSemanticSequencer() {
		return semanticSequencer;
	}

	public GenFileName getSyntacticSequencer() {
		return syntacticSequencer;
	}

}
