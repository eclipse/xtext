/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class GraphvizDotBuilder {

	protected static final Logger log = Logger.getLogger(GraphvizDotBuilder.class);

	protected class Digraph extends Props {

		private static final long serialVersionUID = -8103262357417982098L;

		private List<Edge> edges = new ArrayList<Edge>();
		private List<Node> nodes = new ArrayList<Node>();

		public Digraph() {
			super();
		}

		public void add(Props child) {
			if (child instanceof Node)
				nodes.add((Node) child);
			else if (child instanceof Edge)
				edges.add((Edge) child);
			else
				throw new RuntimeException("Unknown child type");
		}

		@Override
		public void draw(PrintStream out) {
			out.println("digraph G {");
			for (Node n : nodes)
				n.draw(out);
			for (Edge e : edges)
				e.draw(out);
			out.println("}");
			out.println();
		}
	}

	protected class Edge extends Props {
		private static final long serialVersionUID = 1941409538047058551L;
		private Object dst;
		private Object src;

		public Edge(Object src, Object dst) {
			this.src = src;
			this.dst = dst;
		}

		@Override
		public void draw(PrintStream out) {
			out.println(id(src) + "->" + id(dst) + " [" + this + "];");
		}

		public void setNoConstraint() {
			put("constraint", "false");
		}
	}

	protected class Node extends Props {
		private static final long serialVersionUID = 758381202465081606L;
		private Object obj;

		public Node(Object obj) {
			this.obj = obj;
		}

		public Node(Object obj, String label) {
			this(obj);
			setLabel(label);
		}

		public Node(Object obj, String label, String shape) {
			this(obj, label);
			setShape(shape);
		}

		@Override
		public void draw(PrintStream out) {
			out.println(id(obj) + " [" + this + "];");
		}

		// record, diamond, etc.
		public void setShape(String shape) {
			put("shape", shape);
		}

	}

	protected abstract class Props extends HashMap<String, String> {
		private static final long serialVersionUID = 414470084198132521L;

		public abstract void draw(PrintStream out);

		protected String esc(String s) {
			if (noEsc.matcher(s).matches())
				return s;
			return "\"" + s.replaceAll("\"|\\[|\\]|>|<|&", "\\\\$0") + "\"";
		}

		public void print(PrintStream out) {
			for (Map.Entry<String, String> e : entrySet())
				out.println(e.getKey() + "=" + esc(e.getValue()) + ";");
		}

		public void setLabel(String label) {
			put("label", label);
		}

		public void setStyle(String style) {
			put("style", style);
		}

		@Override
		public String toString() {
			if (size() == 0)
				return "";
			StringBuffer b = new StringBuffer();
			Iterator<Map.Entry<String, String>> i = entrySet().iterator();
			Map.Entry<String, String> e = i.next();
			b.append(e.getKey() + "=" + esc(e.getValue()));
			while (i.hasNext()) {
				e = i.next();
				b.append("," + e.getKey() + "=" + esc(e.getValue()));
			}
			return b.toString();
		}

	}

	private static final Pattern noEsc = Pattern.compile("[a-zA-Z0-9]+");

	public String draw(Object obj) {
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		draw(obj, new PrintStream(ba));
		return ba.toString();
	}

	public void draw(Object obj, PrintStream out) {
		out.println("## This is a Graphviz .dot file " + "(http://www.graphviz.org/)");
		out.println("## You can use the command " + "'dot -Tpdf this.dot > out.pdf' to render it.");
		drawObject(obj).draw(out);
	}

	// example options: "-v -T png"
	public void draw(Object obj, String outfile, String options) throws IOException {
		String cmd = getGraphvizBinary() + " -o " + outfile + " " + options;
		draw(obj, cmd);
	}

	public void draw(Object obj, String cmd) throws IOException {
		log.info("Running '" + cmd + "' in '" + new File(".").getCanonicalPath() + "'");
		Process p = Runtime.getRuntime().exec(cmd);
		PrintStream ps = new PrintStream(p.getOutputStream());
		BufferedInputStream in = new BufferedInputStream(p.getInputStream());
		BufferedInputStream err = new BufferedInputStream(p.getErrorStream());
		draw(obj, ps);
		ps.close();
		int b;
		ByteArrayOutputStream oerr = new ByteArrayOutputStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		while ((b = err.read()) >= 0)
			oerr.write(b);
		while ((b = in.read()) >= 0)
			out.write(b);
		if (oerr.size() > 0)
			log.info("Graphviz output to stderr: \n" + oerr.toString());
		if (out.size() > 0)
			log.info("Graphviz output to stdout: \n" + out.toString());
	}

	protected abstract Props drawObject(Object obj);

	protected String getGraphvizBinary() {
		return "/opt/local/bin/dot";
	}

	protected String id(Object cls) {
		if (cls instanceof EPackage)
			return "cluster" + cls.hashCode();
		else if (cls instanceof EObject)
			return ((EObject) cls).eClass().getName().toLowerCase() + cls.hashCode();
		return cls.getClass().getSimpleName().toLowerCase() + cls.hashCode();
	}

}
