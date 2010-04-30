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
 * TODO: Rethink name: Is that a Util or the Serializer itself?
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Jan Koehnlein
 */
public class SerializerUtil {

	// TODO: rename NO_FORMATTING
	public static final SerializationOptions NO_FORMAT = new SerializationOptions(false, true);

	public static class SerializationOptions {

		private boolean formatting = true;
		private boolean validateConcreteSyntax = true;

		public SerializationOptions() {
		}

		public SerializationOptions(boolean format, boolean validateConcreteSyntax) {
			super();
			this.formatting = format;
			this.validateConcreteSyntax = validateConcreteSyntax;
		}

		// rename: isFormatting
		public boolean isFormat() {
			return formatting;
		}

		// rename: setFormatting
		public void setFormat(boolean formatting) {
			this.formatting = formatting;
		}

		public boolean isValidateConcreteSyntax() {
			return validateConcreteSyntax;
		}

		public void setValidateConcreteSyntax(boolean validateConcreteSyntax) {
			this.validateConcreteSyntax = validateConcreteSyntax;
		}
	}

	private IParseTreeConstructor parseTreeReconstructor;
	private IFormatter formatter;
	private IConcreteSyntaxValidator validator;

	@Inject
	public SerializerUtil(IParseTreeConstructor ptc, IFormatter fmt, IConcreteSyntaxValidator val) {
		this.parseTreeReconstructor = ptc;
		this.formatter = fmt;
		this.validator = val;
	}

	public TreeConstructionReport serialize(EObject obj, ITokenStream tokenStream, SerializationOptions options)
			throws IOException {
		if (options.isValidateConcreteSyntax()) {
			List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
			validator.validateRecursive(obj, new IConcreteSyntaxValidator.DiagnosticListAcceptor(diagnostics),
					new HashMap<Object, Object>());
			if (diagnostics.size() > 0)
				throw new IConcreteSyntaxValidator.InvalidConcreteSyntaxException(
						"These errors need to be fixed before the model an be serialized.", diagnostics);
		}
		ITokenStream formatterTokenStream = formatter.createFormatterStream(null, tokenStream, !options.isFormat());
		TreeConstructionReport report = parseTreeReconstructor.serializeRecursive(obj, formatterTokenStream);
		// TODO: formatterTokenStream.flush() instead?
		tokenStream.flush();
		return report;
	}

	public TreeConstructionReport serialize(EObject obj, Writer writer, SerializationOptions options) throws IOException {
		return serialize(obj, new WriterTokenStream(writer), options);
	}

	public String serialize(EObject obj) {
		return serialize(obj, new SerializationOptions());
	}

	public String serialize(EObject obj, SerializationOptions options) {
		TokenStringBuffer tokenStringBuffer = new TokenStringBuffer();
		try {
			serialize(obj, tokenStringBuffer, options);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return tokenStringBuffer.toString();
	}

}
