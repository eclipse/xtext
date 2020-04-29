/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.inject.Inject;

/**
 * Base class for adding template proposals from an {@link IdeContentProposalProvider} implementation. Use
 * {@link #variable(String)} and {@link #cursor()} to generate edit positions and an exit position into the proposal,
 * e.g.
 * <pre>
 * StringConcatenationClient template = new StringConcatenationClient() {
 *      {@literal @}Override
 *      protected void appendTo(StringConcatenationClient.TargetStringConcatenation target) {
 *          target.append("state ");
 *          target.append(variable("name"));
 *          target.newLineIfNotEmpty();
 *          target.append("\t");
 *          target.append(cursor(), "\t");
 *          target.newLineIfNotEmpty();
 *          target.append("end");
 *          target.newLine();
 *      }
 * };
 * acceptProposal("state", "Create a new state", template, context, acceptor);
 * </pre>
 * 
 * @since 2.10
 */
public abstract class AbstractIdeTemplateProposalProvider {
	/**
	 * Placeholder for a variable (edit position) in a template.
	 */
	protected static class Variable {
		private final String name;

		public Variable(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Variable other = (Variable) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("name", name);
			return b.toString();
		}

		public String getName() {
			return name;
		}
	}

	/**
	 * Placeholder for the cursor (exit position) in a template.
	 */
	protected static class Cursor {
	}

	private static class TemplateStringConcatenation extends StringConcatenation {
		private final ContentAssistContext context;

		private final ContentAssistEntry entry;

		public TemplateStringConcatenation(ContentAssistContext context, ContentAssistEntry entry,
				String lineDelimiter) {
			super(lineDelimiter);
			this.context = context;
			this.entry = entry;
		}

		@Override
		protected String getStringRepresentation(Object object) {
			if (object instanceof Variable) {
				String varName = ((Variable) object).name;
				int offset = context.getReplaceRegion().getOffset() + getCurrentOffset();
				entry.getEditPositions().add(new TextRegion(offset, varName.length()));
				return varName;
			} else {
				if (object instanceof Cursor) {
					entry.setEscapePosition(
							Integer.valueOf(context.getReplaceRegion().getOffset() + getCurrentOffset()));
					return null;
				} else {
					return object.toString();
				}
			}
		}

		protected int getCurrentOffset() {
			int result = 0;
			for (String segment : getContent()) {
				result = result + segment.length();
			}
			return result;
		}

		@Override
		public void newLineIfNotEmpty() {
			newLine();
		}
	}

	@Inject
	private IdeContentProposalCreator proposalCreator;

	@Inject
	private IdeContentProposalPriorities proposalPriorities;

	protected Variable variable(String name) {
		return new Variable(name);
	}

	protected Cursor cursor() {
		return new Cursor();
	}

	protected void acceptProposal(String name, String description, StringConcatenationClient template,
			ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		acceptProposal(name, description, template, context, acceptor, true);
	}

	protected void acceptProposal(String name, String description, StringConcatenationClient template,
			ContentAssistContext context, IIdeContentProposalAcceptor acceptor, boolean adaptIndentation) {
		ContentAssistEntry entry = createProposal(template, context, adaptIndentation);
		if (canAcceptProposal(entry, context)) {
			entry.setLabel(name);
			entry.setDescription(description);
			acceptor.accept(entry, proposalPriorities.getDefaultPriority(entry));
		}
	}

	protected boolean canAcceptProposal(ContentAssistEntry entry, ContentAssistContext context) {
		return proposalCreator.isValidProposal(entry.getProposal(), entry.getPrefix(), context);
	}

	protected ContentAssistEntry createProposal(StringConcatenationClient template, ContentAssistContext context,
			boolean adaptIndentation) {
		ContentAssistEntry entry = new ContentAssistEntry();
		entry.setPrefix(context.getPrefix());
		TemplateStringConcatenation stringConcat = new TemplateStringConcatenation(context, entry, getLineDelimiter());
		String indentation = null;
		if (adaptIndentation) {
			indentation = getIndentation(context);
		}
		if (indentation == null) {
			stringConcat.append(template);
		} else {
			stringConcat.append(template, indentation);
		}
		entry.setProposal(stringConcat.toString());
		return entry;
	}

	protected String getLineDelimiter() {
		return StringConcatenation.DEFAULT_LINE_DELIMITER;
	}

	protected String getIndentation(ContentAssistContext context) {
		String text = null;
		if (context.getRootNode() != null) {
			text = context.getRootNode().getText();
		}
		if (text != null && text.length() >= context.getOffset()) {
			int lineStart = context.getReplaceRegion().getOffset();
			int indentEnd = lineStart;
			while (lineStart > 0 && text.charAt(lineStart - 1) != '\n') {
				lineStart--;
				if (!Character.isWhitespace(text.charAt(lineStart))) {
					indentEnd = lineStart;
				}
			}
			return text.substring(lineStart, indentEnd);
		}
		return null;
	}
}
