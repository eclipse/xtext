/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.formatting.IFormatterExtension;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.parsetree.reconstr.impl.WriterTokenStream;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Jan Koehnlein
 * 
 * @deprecated use org.eclipse.xtext.serializer.impl.Serializer instead
 */
@Deprecated
public class Serializer implements ISerializer {
	private IParseTreeConstructor parseTreeReconstructor;
	private IFormatter formatter;
	private IConcreteSyntaxValidator validator;

	@Inject
	public Serializer(IParseTreeConstructor ptc, IFormatter fmt, IConcreteSyntaxValidator val) {
		this.parseTreeReconstructor = ptc;
		this.formatter = fmt;
		this.validator = val;
	}

	public TreeConstructionReport serialize(EObject obj, ITokenStream tokenStream, SaveOptions options)
			throws IOException {
		if (options.isValidating()) {
			List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
			validator.validateRecursive(obj, new IConcreteSyntaxValidator.DiagnosticListAcceptor(diagnostics),
					new HashMap<Object, Object>());
			if (!diagnostics.isEmpty())
				throw new IConcreteSyntaxValidator.InvalidConcreteSyntaxException(
						"These errors need to be fixed before the model can be serialized.", diagnostics);
		}
		ITokenStream formatterTokenStream;
		if(formatter instanceof IFormatterExtension)
			formatterTokenStream = ((IFormatterExtension) formatter).createFormatterStream(obj, null, tokenStream, !options.isFormatting());
		else 
			formatterTokenStream = formatter.createFormatterStream(null, tokenStream, !options.isFormatting());
		TreeConstructionReport report = parseTreeReconstructor.serializeSubtree(obj, formatterTokenStream);
		formatterTokenStream.flush();
		return report;
	}

	@Override
	public void serialize(EObject obj, Writer writer, SaveOptions options) throws IOException {
		serialize(obj, new WriterTokenStream(writer), options);
	}

	@Override
	public String serialize(EObject obj) {
		return serialize(obj, SaveOptions.defaultOptions());
	}

	@Override
	public String serialize(EObject obj, SaveOptions options) {
		TokenStringBuffer tokenStringBuffer = new TokenStringBuffer();
		try {
			serialize(obj, tokenStringBuffer, options);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return tokenStringBuffer.toString();
	}

	@Deprecated
	public TreeConstructionReport serialize(EObject obj, ITokenStream tokenStream, SerializerOptions options)
			throws IOException {
		return serialize(obj, tokenStream, options.toSaveOptions());
	}

	@Deprecated
	public TreeConstructionReport serialize(EObject obj, Writer writer, SerializerOptions options) throws IOException {
		return serialize(obj, new WriterTokenStream(writer), options.toSaveOptions());
	}

	@Deprecated
	public String serialize(EObject obj, SerializerOptions options) {
		return serialize(obj, options.toSaveOptions());
	}

	@Override
	public ReplaceRegion serializeReplacement(EObject obj, SaveOptions options) {
		TokenStringBuffer tokenStringBuffer = new TokenStringBuffer();
		try {
			TreeConstructionReport report = serialize(obj, tokenStringBuffer, options);
			return new ReplaceRegion(report.getPreviousLocation(), tokenStringBuffer.toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
