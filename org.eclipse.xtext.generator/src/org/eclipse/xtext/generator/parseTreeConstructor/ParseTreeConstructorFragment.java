/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parseTreeConstructor;

import static org.eclipse.xtext.generator.parseTreeConstructor.ParseTreeConstructorUtil.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstNFAToDot;

/**
 * An {@link org.eclipse.xtext.generator.IGeneratorFragment} to generate model-&gt;text services (aka serializer) for an Xtext language.
 *
 * @author Jan Koehnlein - Javadocs
 * 
 * @deprecated use org.eclipse.xtext.generator.serializer.SerializerFragment instead.
 */
@Deprecated
public class ParseTreeConstructorFragment extends AbstractGeneratorFragment {

	private static final Logger log = Logger.getLogger(ParseTreeConstructorFragment.class);

	private boolean generateDotDiagram = false;

	private String graphvizCommand = null;

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		if (generateDotDiagram || graphvizCommand != null) {
			try {
				TreeConstNFAToDot ftd = new TreeConstNFAToDot();
				String fn = new File(ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath() + "/"
						+ getNaming().asPath(getParseTreeConstructorName(grammar,getNaming()))).getCanonicalPath();
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
			}
			catch (IOException e) {
				log.error("IOError", e);
			}
		}
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.<Object>singletonList(getNaming().getLineDelimiter());
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[] { getPackage(grammar,getNaming()) };
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory().addTypeToType(IParseTreeConstructor.class.getName(),
				getParseTreeConstructorName(grammar, getNaming())).getBindings();
	}

	/**
	 * Decide whether to produce a Graphviz diagram for debugging.
	 *
	 * @param enable
	 */
	public void setGenerateDotDiagram(boolean enable) {
		generateDotDiagram = enable;
	}

	/**
	 * Set the Graphviz command that is issued to paint a debugging diagram.
	 *
	 * @param cmd
	 */
	public void setGraphvizCommand(String cmd) {
		if (cmd != null && cmd.length() == 0)
			cmd = null;
		graphvizCommand = cmd;
	}

}
