/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parseTreeConstructor;

import static org.eclipse.xtext.parsetree.reconstr.impl.ParseTreeConstructorUtil.getPackage;
import static org.eclipse.xtext.parsetree.reconstr.impl.ParseTreeConstructorUtil.getParseTreeConstructorName;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenMerger;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultHiddenTokenMerger;
import org.eclipse.xtext.parsetree.reconstr.impl.FollowerToDot;

public class ParseTreeConstructorFragment extends AbstractGeneratorFragment {

	protected static final Logger log = Logger
			.getLogger(ParseTreeConstructorFragment.class);

	private boolean generateDotDiagram = false;

	private String graphvizCommand = null;

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		if (generateDotDiagram || graphvizCommand != null) {
			try {
				FollowerToDot ftd = new FollowerToDot();
				String fn = new File(ctx.getOutput().getOutlet(
						Generator.SRC_GEN).getPath()
						+ "/"
						+ Naming.asPath(getParseTreeConstructorName(grammar)))
						.getCanonicalPath();
				if (generateDotDiagram) {
					PrintStream out;
					out = new PrintStream(fn + ".dot");
					ftd.draw(grammar, out);
					out.close();
				}
				if (graphvizCommand != null) {
					String cmd = graphvizCommand.replace("%1", fn);
					ftd.draw(grammar, cmd);
				}
			} catch (IOException e) {
				log.error("IOError", e);
			}
		}
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[] { getPackage(grammar) };
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory().addTypeToType(
				IParseTreeConstructor.class.getName(),
				getParseTreeConstructorName(grammar)).getBindings();
	}

	public void setGenerateDotDiagram(boolean enable) {
		generateDotDiagram = enable;
	}

	public void setGraphvizCommand(String cmd) {
		if (cmd != null && cmd.length() == 0)
			cmd = null;
		graphvizCommand = cmd;
	}

}
