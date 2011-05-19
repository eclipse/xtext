/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.edit.part;

import static com.google.common.collect.Iterables.*;

import java.io.StringReader;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.gmf.glue.Activator;
import org.eclipse.xtext.gmf.glue.editingdomain.UpdateXtextResourceTextCommand;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;

import com.google.inject.Inject;

/**
 * Wraps a (partial) Xtext parser in a GMF {@link IParser}.
 * 
 * @author Jan Koehnlein
 */
public class AntlrParserWrapper implements IParser {

	@Inject
	private XtextContentAssistProcessor xtextContentAssistProcessor;

	@Inject
	private org.eclipse.xtext.parser.IParser xtextParser;

	private IParser originalParser;

	private ParserRule parserRule;

	public AntlrParserWrapper() {
	}

	public void initialize(ParserRule parserRule, IParser originalParser) {
		this.parserRule = parserRule;
		this.originalParser = originalParser;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO does not work. need to fake an XtextDocument
		return xtextContentAssistProcessor;
	}

	public String getEditString(IAdaptable element, int flags) {
		EObject semanticElement = (EObject) element.getAdapter(EObject.class);
		if (semanticElement != null) {
			ICompositeNode parserNode = NodeModelUtils.findActualNodeFor(semanticElement);
			if (parserNode != null) {
				return parserNode.getText().trim();
			}
		}
		return "invalid";
	}

	public ICommand getParseCommand(IAdaptable element, final String newString, int flags) {
		EObject semanticElement = (EObject) element.getAdapter(EObject.class);
		if (semanticElement != null) {
			IParseResult parseResult = xtextParser.parse(parserRule, new StringReader(newString));
			if (isValidParseResult(parseResult, semanticElement)) {
				ICompositeNode parserNode = NodeModelUtils.findActualNodeFor(semanticElement);
				if (parserNode != null) {
					final XtextResource semanticResource = (XtextResource) semanticElement.eResource();
					ICommand reparseCommand = UpdateXtextResourceTextCommand.createUpdateCommand(semanticResource,
							parserNode.getOffset(), parserNode.getLength(), newString);
					return reparseCommand;
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	public String getPrintString(IAdaptable element, int flags) {
		return originalParser.getPrintString(element, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		try {
			IParseResult parseResult = xtextParser.parse(parserRule, new StringReader(editString));
			if (isValidParseResult(parseResult, (EObject) element.getAdapter(EObject.class))) {
				return new ParserEditStatus(IStatus.OK, Activator.PLUGIN_ID, IParserEditStatus.EDITABLE, "OK", null);
			} else {
				if (parseResult.hasSyntaxErrors()) {
					INode syntaxErrorNode = parseResult.getSyntaxErrors().iterator().next();
					return new ParserEditStatus(IStatus.INFO, Activator.PLUGIN_ID, IParserEditStatus.UNEDITABLE,
							syntaxErrorNode.getSyntaxErrorMessage().getMessage(), null);
				} else {
					return new ParserEditStatus(IStatus.ERROR, Activator.PLUGIN_ID, IParserEditStatus.UNEDITABLE,
							"Unknown parse error", null);
				}
			}
		} catch (Exception exc) {
			return new ParserEditStatus(IStatus.INFO, Activator.PLUGIN_ID, IParserEditStatus.UNEDITABLE,
					exc.getMessage(), exc);
		}
	}

	private boolean isValidParseResult(IParseResult parseResult, EObject semanticElement) {
		EObject rootASTElement = parseResult.getRootASTElement();
		return isEmpty(parseResult.getSyntaxErrors()) && rootASTElement != null && semanticElement != null
				&& semanticElement.eClass() == rootASTElement.eClass();
	}

}
