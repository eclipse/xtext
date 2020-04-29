/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * A composite node does not contribute any output directly, but only through its children. Thus it is an <em>inner</em>
 * node of the code generator tree.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeGeneratorNode implements IGeneratorNode {
	private final List<IGeneratorNode> children = new ArrayList<>();

	@Override
	public String toString() {
		StringConcatenation builder = new StringConcatenation();
		builder.append(getClass().getSimpleName());
		builder.append(" {");
		builder.newLineIfNotEmpty();
		for (IGeneratorNode c : children) {
			builder.append("\t");
			builder.append(c.toString(), "\t");
			builder.newLineIfNotEmpty();
		}
		builder.append("}");
		builder.newLine();
		return builder.toString();
	}

	public List<IGeneratorNode> getChildren() {
		return children;
	}
}
