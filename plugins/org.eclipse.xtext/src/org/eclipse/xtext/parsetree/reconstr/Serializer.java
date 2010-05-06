/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.parsetree.reconstr.impl.WriterTokenStream;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Jan Koehnlein
 */
public class Serializer {
	private IParseTreeConstructor parseTreeReconstructor;
	private IFormatter formatter;
	private IConcreteSyntaxValidator validator;

	@Inject
	public Serializer(IParseTreeConstructor ptc, IFormatter fmt, IConcreteSyntaxValidator val) {
		this.parseTreeReconstructor = ptc;
		this.formatter = fmt;
		this.validator = val;
	}

	public TreeConstructionReport serialize(EObject obj, ITokenStream tokenStream, SerializerOptions options)
			throws IOException {
		if (options.isValidateConcreteSyntax()) {
			List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
			validator.validateRecursive(obj, new IConcreteSyntaxValidator.DiagnosticListAcceptor(diagnostics),
					new HashMap<Object, Object>());
			if (!diagnostics.isEmpty())
				throw new IConcreteSyntaxValidator.InvalidConcreteSyntaxException(
						"These errors need to be fixed before the model can be serialized.", diagnostics);
		}
		ITokenStream formatterTokenStream = formatter.createFormatterStream(null, tokenStream, !options.isFormatting());
		TreeConstructionReport report = parseTreeReconstructor.serializeSubtree(obj, formatterTokenStream);
		formatterTokenStream.flush();
		return report;
	}

	public TreeConstructionReport serialize(EObject obj, Writer writer, SerializerOptions options) throws IOException {
		return serialize(obj, new WriterTokenStream(writer), options);
	}

	public String serialize(EObject obj) {
		return serialize(obj, new SerializerOptions());
	}

	public String serialize(EObject obj, SerializerOptions options) {
		TokenStringBuffer tokenStringBuffer = new TokenStringBuffer();
		try {
			serialize(obj, tokenStringBuffer, options);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return tokenStringBuffer.toString();
	}

	protected IParseTreeConstructor getParseTreeReconstructor() {
		return parseTreeReconstructor;
	}
	
	protected IFormatter getFormatter() {
		return formatter;
	}
	
	protected IConcreteSyntaxValidator getValidator() {
		return validator;
	}
}
