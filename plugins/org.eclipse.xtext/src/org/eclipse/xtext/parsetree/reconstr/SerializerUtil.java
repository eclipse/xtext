/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenOutputStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerUtil {

	public static final SerializationOptions NO_FORMAT = new SerializationOptions(false, false);

	public static class SerializationOptions {

		private boolean format = true;
		private boolean validateConcreteSyntax = false;

		public SerializationOptions() {
		}

		public SerializationOptions(boolean format, boolean validateConcreteSyntax) {
			super();
			this.format = format;
			this.validateConcreteSyntax = validateConcreteSyntax;
		}

		public boolean isFormat() {
			return format;
		}

		public void setFormat(boolean format) {
			this.format = format;
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

	public TreeConstructionReport serialize(EObject obj, ITokenStream out, SerializationOptions options)
			throws IOException {
		if (options.isValidateConcreteSyntax()) {
			List<Diagnostic> diags = new ArrayList<Diagnostic>();
			validator.validateRecursive(obj, new IConcreteSyntaxValidator.DiagnosticListAcceptor(diags),
					new HashMap<Object, Object>());
			if (diags.size() > 0)
				throw new IConcreteSyntaxValidator.InvalidConcreteSyntaxException(
						"These errors need to be fixed before the model an be serialized.", diags);
		}
		ITokenStream t = formatter.createFormatterStream(null, out, !options.isFormat());
		return parseTreeReconstructor.serializeRecursive(obj, t);
	}

	@Deprecated
	// use serialize(EObject, OutputStream, CompositeNode, SerializationOptions) instead
	public TreeConstructionReport serialize(EObject obj, OutputStream out, boolean format) throws IOException {
		SerializationOptions opt = new SerializationOptions();
		opt.setFormat(format);
		return serialize(obj, out, opt);
	}

	public TreeConstructionReport serialize(EObject obj, OutputStream out, SerializationOptions opt) throws IOException {
		return serialize(obj, new TokenOutputStream(out), opt);
	}

	public String serialize(EObject obj) {
		return serialize(obj, new SerializationOptions());
	}

	@Deprecated
	// SerializerUtil.serialize(EObject, SerializationOptions) instead
	public String serialize(EObject obj, boolean format) {
		SerializationOptions opt = new SerializationOptions();
		opt.setFormat(format);
		return serialize(obj, opt);
	}

	public String serialize(EObject obj, SerializationOptions opt) {
		TokenStringBuffer out = new TokenStringBuffer();
		try {
			serialize(obj, out, opt);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}

}
