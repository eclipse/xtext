/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.util.TextRegion

/**
 * Base class for adding template proposals from an {@link IdeContentProposalProvider} implementation.
 * Use {@link #variable(String)} and {@link #cursor()} to generate edit positions and an exit position
 * into the proposal, e.g.
 * <pre>
 * val StringConcatenationClient template = '''
 *     state «variable('name')»
 *         «cursor»
 *     end
 * '''
 * acceptProposal('state', 'Create a new state', template, context, acceptor)
 * </pre>
 * 
 * @since 2.10
 */
abstract class AbstractIdeTemplateProposalProvider {
	
	@Inject IdeContentProposalPriorities proposalPriorities
	
	/** Placeholder for a variable (edit position) in a template. */
	@Data
	protected static class Variable {
		String name
	}
	
	protected def Variable variable(String name) {
		new Variable(name)
	}
	
	/** Placeholder for the cursor (exit position) in a template. */
	protected static class Cursor {
	}
	
	protected def Cursor cursor() {
		new Cursor
	}
	
	protected def void acceptProposal(String name, String description, StringConcatenationClient template,
			ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		acceptProposal(name, description, template, context, acceptor, true)
	}
	
	protected def void acceptProposal(String name, String description, StringConcatenationClient template,
			ContentAssistContext context, IIdeContentProposalAcceptor acceptor, boolean adaptIndentation) {
		val entry = createProposal(template, context, adaptIndentation)
		if (canAcceptProposal(entry, context)) {
			entry.label = name
			entry.description = description
			acceptor.accept(entry, proposalPriorities.getDefaultPriority(entry))
		}
	}
	
	protected def boolean canAcceptProposal(ContentAssistEntry entry, ContentAssistContext context) {
		entry.proposal.startsWith(context.prefix)
	}
	
	protected def ContentAssistEntry createProposal(StringConcatenationClient template,
			ContentAssistContext context, boolean adaptIndentation) {
		val entry = new ContentAssistEntry
		entry.prefix = context.prefix
		val stringConcat = new TemplateStringConcatenation(context, entry, lineDelimiter)
		val indentation = if (adaptIndentation) context.indentation else null
		if (indentation === null)
			stringConcat.append(template)
		else
			stringConcat.append(template, indentation)
		entry.proposal = stringConcat.toString
		return entry
	}
	
	protected def String getLineDelimiter() {
		StringConcatenation.DEFAULT_LINE_DELIMITER
	}
	
	protected def String getIndentation(ContentAssistContext context) {
		val text = context.rootNode?.text
		if (text !== null && text.length >= context.offset) {
			var lineStart = context.replaceRegion.offset
			var indentEnd = lineStart
			while (lineStart > 0 && text.charAt(lineStart - 1) != '\n'.charAt(0)) {
				lineStart--
				if (!Character.isWhitespace(text.charAt(lineStart)))
					indentEnd = lineStart
			}
			return text.substring(lineStart, indentEnd)
		}
	}
	
	private static class TemplateStringConcatenation extends StringConcatenation {
		
		val ContentAssistContext context
		val ContentAssistEntry entry
		
		new(ContentAssistContext context, ContentAssistEntry entry, String lineDelimiter) {
			super(lineDelimiter)
			this.context = context
			this.entry = entry
		}
		
		override protected getStringRepresentation(Object object) {
			if (object instanceof Variable) {
				val varName = object.name
				val offset = context.replaceRegion.offset + currentOffset
				entry.editPositions.add(new TextRegion(offset, varName.length))
				return varName
			} else if (object instanceof Cursor) {
				val offset = context.replaceRegion.offset + currentOffset
				entry.setEscapePosition(offset)
				return null
			} else {
				return object.toString
			}
		}
		
		protected def int getCurrentOffset() {
			var result = 0
			for (segment : content) {
				result += segment.length
			}
			return result
		}
		
		override newLineIfNotEmpty() {
			newLine()
		}
		
	}
	
}