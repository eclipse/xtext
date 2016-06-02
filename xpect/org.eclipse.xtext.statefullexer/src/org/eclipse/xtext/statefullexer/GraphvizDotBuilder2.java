package org.eclipse.xtext.statefullexer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.GraphvizDotBuilder;

public abstract class GraphvizDotBuilder2 extends GraphvizDotBuilder {

	protected class Cluster extends Props {

		private static final long serialVersionUID = -5773274009853009437L;
		private List<Edge> edges = new ArrayList<Edge>();
		private List<Node2> nodes = new ArrayList<Node2>();
		protected Object obj;

		public Cluster(Object obj) {
			this.obj = obj;
		}

		public Cluster(Object obj, String label) {
			this.obj = obj;
			setLabel(label);
		}

		public void add(Props child) {
			if (child instanceof Node2)
				nodes.add((Node2) child);
			else if (child instanceof Edge)
				edges.add((Edge) child);
			else
				throw new RuntimeException("Unknown child type");
		}

		@Override
		public void draw(PrintStream out) {
			out.println("subgraph cluster_" + id(obj) + " {");
			print(out);
			for (Node n : nodes)
				n.draw(out);
			out.println("}");
			out.println();
		}

	}

	protected class Digraph2 extends Props {

		private static final long serialVersionUID = -8103262357417982098L;

		private List<Cluster> cluster = new ArrayList<Cluster>();
		private List<Edge> edges = new ArrayList<Edge>();
		private List<Node2> nodes = new ArrayList<Node2>();

		public Digraph2() {
			super();
		}

		public void add(Props child) {
			if (child instanceof Node2)
				nodes.add((Node2) child);
			else if (child instanceof Edge)
				edges.add((Edge) child);
			else if (child instanceof Cluster)
				cluster.add((Cluster) child);
			else
				throw new RuntimeException("Unknown child type");
		}

		public void draw(PrintStream out) {
			out.println("digraph G {");
			for (Cluster c : cluster)
				c.draw(out);
			for (Node n : nodes)
				n.draw(out);
			for (Node2 n : nodes)
				for (Edge e : n.edges)
					e.draw(out);
			for (Cluster c : cluster) {
				for (Node2 n : c.nodes)
					for (Edge e : n.edges)
						e.draw(out);

				for (Edge e : c.edges)
					e.draw(out);
			}
			for (Edge e : edges)
				e.draw(out);
			out.println("}");
			out.println();
		}
	}

	protected class Node2 extends Node {

		private static final long serialVersionUID = -5221893288161698810L;

		public Node2(Object obj, String label, String shape) {
			super(obj, label, shape);
		}

		public Node2(Object obj, String label) {
			super(obj, label);
		}

		public Node2(Object obj) {
			super(obj);
		}

		private List<Edge> edges = new ArrayList<Edge>();

		public void add(Edge edge) {
			edges.add(edge);
		}

	}

}
