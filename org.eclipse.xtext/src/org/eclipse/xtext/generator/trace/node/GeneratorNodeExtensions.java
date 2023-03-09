/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.ILocationData;

import com.google.inject.Inject;

/**
 * A builder API to create generator node trees
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class GeneratorNodeExtensions {
	@Inject
	private GeneratorWhiteSpaceConfig wsConfig = new GeneratorWhiteSpaceConfig();

	/**
	 * @return a root trace node for the given location
	 */
	public CompositeGeneratorNode trace(ILocationData data) {
		return new TraceNode(data);
	}

	/**
	 * @return a root trace node for the given location
	 */
	public CompositeGeneratorNode trace(ILocationData data, boolean useForDebugging) {
		TraceNode result = new TraceNode(data);
		result.setUseForDebugging(useForDebugging);
		return result;
	}

	/**
	 * @return a trace node for the given location, appended as a child on the given parent
	 */
	public CompositeGeneratorNode trace(CompositeGeneratorNode parent, ILocationData data) {
		TraceNode result = new TraceNode(data);
		parent.getChildren().add(result);
		return result;
	}

	/**
	 * @return a trace node for the given location, appended as a child on the given parent
	 */
	public CompositeGeneratorNode trace(CompositeGeneratorNode parent, ILocationData data, boolean useForDebugging) {
		TraceNode result = new TraceNode(data);
		result.setUseForDebugging(useForDebugging);
		parent.getChildren().add(result);
		return result;
	}

	/**
	 * @return an indentation node, using the default indentation string, appended as a child on the given parent
	 */
	public CompositeGeneratorNode indent(CompositeGeneratorNode parent) {
		return indent(parent, wsConfig.getIndentationString());
	}

	/**
	 * Appends the indentation string at the current position of the parent and adds a new composite node, indicating
	 * the same indentation for subsequent lines.
	 * 
	 * @return an indentation node, using the given indentString, appended as a child on the given parent
	 */
	public CompositeGeneratorNode indent(CompositeGeneratorNode parent, String indentString) {
		IndentNode indent = new IndentNode(indentString);
		parent.getChildren().add(indent);
		return indent;
	}

	/**
	 * Appends a line separator node to the given parent.
	 * 
	 * @return the given parent node
	 */
	public CompositeGeneratorNode appendNewLine(CompositeGeneratorNode parent) {
		parent.getChildren().add(new NewLineNode(wsConfig.getLineDelimiter(), false));
		return parent;
	}

	/**
	 * Appends a line separator node to the given parent.
	 * 
	 * @return the given parent node
	 */
	public CompositeGeneratorNode appendNewLine(CompositeGeneratorNode parent, String lineSeparator) {
		parent.getChildren().add(new NewLineNode(lineSeparator, false));
		return parent;
	}

	/**
	 * Appends a line separator node that will only be effective if the current line contains non-whitespace text.
	 * 
	 * @return the given parent node
	 */
	public CompositeGeneratorNode appendNewLineIfNotEmpty(CompositeGeneratorNode parent) {
		parent.getChildren().add(new NewLineNode(wsConfig.getLineDelimiter(), true));
		return parent;
	}

	/**
	 * Creates a text node containing the toString() representation of the given object and appends it to the given
	 * parent node.
	 * 
	 * @return the given parent node
	 */
	public CompositeGeneratorNode append(CompositeGeneratorNode parent, Object object) {
		if (object instanceof StringConcatenationClient) {
			appendTemplate(parent, (StringConcatenationClient) object);
		} else {
			if (object instanceof IGeneratorNode) {
				parent.getChildren().add((IGeneratorNode) object);
			} else {
				if (object != null) {
					parent.getChildren().add(new TextNode(object.toString()));
				}
			}
		}
		return parent;
	}

	/**
	 * Creates a template node for the given templateString and appends it to the given parent node.
	 * 
	 * Templates are translated to generator node trees and expressions in templates can be of type IGeneratorNode.
	 * 
	 * @return the given parent node
	 */
	public CompositeGeneratorNode appendTemplate(CompositeGeneratorNode parent,
			StringConcatenationClient templateString) {
		TemplateNode proc = new TemplateNode(templateString, this);
		parent.getChildren().add(proc);
		return parent;
	}
}
