package org.eclipse.xtext.xtext.ui.graph.tests;

import static com.google.common.collect.Maps.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xtext.ui.graph.figures.BypassSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.CompartmentSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.CrossPointSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.ISegmentFigure;
import org.eclipse.xtext.xtext.ui.graph.figures.LoopSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.NodeSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.ParallelSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.RailroadDiagram;
import org.eclipse.xtext.xtext.ui.graph.figures.RailroadTrack;
import org.eclipse.xtext.xtext.ui.graph.figures.SequenceSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.Connection;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.CrossPoint;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.LabelNode;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.RectangleNode;
import org.eclipse.xtext.xtext.ui.graph.trafo.Xtext2RailroadTransformer;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(RailroadInjectorProvider.class)
public class TransformationTest {

	@Inject 
	private Xtext2RailroadTransformer transformer;
	
	@Inject 
	private GrammarParser parser;
	
	@Test
	public void testKeyword() throws Exception {
		getBuilder("Foo: 'foo';").hasChildren(1)
			.child(0).isType(RailroadTrack.class).as("t").hasChildren(5)
				.child(0).isType(LabelNode.class).as("label").parent()
				.child(1).isType(NodeSegment.class).hasChildren(1)
					.child(0).as("node").parent().parent()
				.child(2).isType(CrossPoint.class).as("exit").parent()
				.child(3).connects("label", "node").parent()
				.child(4).connects("node", "exit");
	}

	@Test
	public void testOptionalKeyword() throws Exception {
		getBuilder("Foo: 'foo'?;").hasChildren(1)
			.child(0).isType(RailroadTrack.class).as("t").hasChildren(5)
				.child(0).isType(LabelNode.class).as("label").parent()
				.child(1).isType(BypassSegment.class).hasChildren(8)
					.child(0).isType(CrossPoint.class).as("optional_entry").parent()
					.child(1).isType(NodeSegment.class).hasChildren(1)
						.child(0).as("node").parent().parent()
					.child(2).isType(CrossPointSegment.class).hasChildren(1)
						.child(0).as("optional").parent().parent()
					.child(3).isType(CrossPoint.class).as("optional_exit").parent()
					.child(4).connects("optional_entry", "optional").parent()
					.child(5).connects("optional", "optional_exit").parent()
					.child(6).connects("optional_entry", "node").parent()
					.child(7).connects("node", "optional_exit").parent().parent()
				.child(2).isType(CrossPoint.class).as("exit").parent()
				.child(3).connects("label", "optional_entry").parent()
				.child(4).connects("optional_exit", "exit");
	}

	@Test
	public void testMultipleKeyword() throws Exception {
		getBuilder("Foo: 'foo'+;").hasChildren(1)
			.child(0).isType(RailroadTrack.class).as("t").hasChildren(5)
				.child(0).isType(LabelNode.class).as("label").parent()
				.child(1).isType(LoopSegment.class).hasChildren(8)
					.child(0).isType(CrossPoint.class).as("loop_entry").parent()
					.child(1).isType(CrossPointSegment.class).hasChildren(1)
						.child(0).as("loop").parent().parent()
					.child(2).isType(NodeSegment.class).hasChildren(1)
						.child(0).as("node").parent().parent()
					.child(3).isType(CrossPoint.class).as("loop_exit").parent()
					.child(4).connects("loop_exit", "loop").parent()
					.child(5).connects("loop", "loop_entry").parent()
					.child(6).connects("loop_entry", "node").parent()
					.child(7).connects("node", "loop_exit").parent().parent()
				.child(2).isType(CrossPoint.class).as("exit").parent()
				.child(3).connects("label", "loop_entry").parent()
				.child(4).connects("loop_exit", "exit");
	}

	@Test
	public void testGroup() throws Exception {
		getBuilder("Foo: 'foo' 'bar';").hasChildren(1)
			.child(0).isType(RailroadTrack.class).as("t").hasChildren(5)
				.child(0).isType(LabelNode.class).as("label").parent()
				.child(1).isType(SequenceSegment.class).as("sequence").hasChildren(3)
					.child(0).isType(NodeSegment.class).hasChildren(1)
						.child(0).isType(RectangleNode.class).as("foo").parent().parent()
					.child(2).isType(NodeSegment.class).hasChildren(1)
						.child(0).isType(RectangleNode.class).as("bar").parent().parent()
				    .child(1).connects("foo", "bar").parent().parent()
				.child(2).isType(CrossPoint.class).as("exit").parent()
				.child(3).connects("label", "foo").parent()
				.child(4).connects("bar", "exit");
	}
	
	@Test
	public void testAlternative() throws Exception {
		getBuilder("Foo: 'foo' | 'bar';").hasChildren(1)
			.child(0).isType(RailroadTrack.class).as("t").hasChildren(5)
				.child(0).isType(LabelNode.class).as("label").parent()
				.child(1).isType(ParallelSegment.class).as("parallel").hasChildren(8)
					.child(0).isType(CrossPoint.class).as("p_entry").hasChildren(0).parent()
					.child(1).isType(CrossPoint.class).as("p_exit").hasChildren(0).parent()
					.child(2).isType(NodeSegment.class).hasChildren(1)
						.child(0).isType(RectangleNode.class).as("foo").parent().parent()
					.child(3).connects("p_entry", "foo").parent()
					.child(4).connects("foo", "p_exit").parent()
					.child(5).isType(NodeSegment.class).hasChildren(1)
						.child(0).isType(RectangleNode.class).as("bar").parent().parent()
					.child(6).connects("p_entry", "bar").parent()
					.child(7).connects("bar", "p_exit").parent().parent()
				.child(2).isType(CrossPoint.class).as("exit").parent()
				.child(3).connects("label", "p_entry").parent()
				.child(4).connects("p_exit", "exit");
	}
	
	
	@Test
	public void testAction() throws Exception {
		getBuilder("Foo: {Foo} 'foo';").hasChildren(1)
		.child(0).isType(RailroadTrack.class).hasChildren(5)
			.child(0).isType(LabelNode.class).as("label").parent()
			.child(1).isType(NodeSegment.class).hasChildren(1)
				.child(0).as("node");
	}

	@Test
	public void testAssignment() throws Exception {
		getBuilder("Foo: name=ID;").hasChildren(1)
		.child(0).isType(RailroadTrack.class).hasChildren(5)
			.child(0).isType(LabelNode.class).as("label").parent()
			.child(1).isType(NodeSegment.class).hasChildren(1)
				.child(0).as("node");
	}

	@Test
	public void testOptionalAssignment() throws Exception {
		getBuilder("Foo: name=ID?;").hasChildren(1)
		.child(0).isType(RailroadTrack.class).hasChildren(5)
			.child(0).isType(LabelNode.class).as("label").parent()
			.child(1).isType(BypassSegment.class);
	}

	@Test
	public void testRuleCall() throws Exception {
		getBuilder("Foo: ID;").hasChildren(1)
		.child(0).isType(RailroadTrack.class).hasChildren(5)
			.child(0).isType(LabelNode.class).as("label").parent()
			.child(1).isType(NodeSegment.class).hasChildren(1)
				.child(0).as("node");
	}

	@Test
	public void testOptionalRullCall() throws Exception {
		getBuilder("Foo: ID?;").hasChildren(1)
		.child(0).isType(RailroadTrack.class).hasChildren(5)
			.child(0).isType(LabelNode.class).as("label").parent()
			.child(1).isType(BypassSegment.class);
	}

	@Test
	public void testUnorderedGroup() throws Exception {
		getBuilder("Foo: 'foo' & 'bar';").hasChildren(1)
		.child(0).isType(RailroadTrack.class).hasChildren(5)
			.child(0).isType(LabelNode.class).as("label").parent()
			.child(1).isType(CompartmentSegment.class).hasChildren(5)
				.child(0).isType(CrossPoint.class).as("comp_entry").parent()
				.child(1).isType(CrossPoint.class).as("comp_exit").parent()
				.child(2).isType(ParallelSegment.class);
	}

	@Test
	public void testKeywordAssignment() throws Exception {
		getBuilder("Foo: bar='foo'?;").hasChildren(1)
		.child(0).isType(RailroadTrack.class).hasChildren(5)
			.child(0).isType(LabelNode.class).as("label").parent()
			.child(1).isType(BypassSegment.class);
	}

	@Test
	public void testEnumRule() throws Exception {
		getBuilder("enum Foo: bar='foo' | fooBar;").hasChildren(1)
		.child(0).isType(RailroadTrack.class).hasChildren(5)
			.child(0).isType(LabelNode.class).as("label").parent()
			.child(1).isType(ParallelSegment.class).hasChildren(8)
				.child(0).isType(CrossPoint.class).parent()
				.child(1).isType(CrossPoint.class).parent()
				.child(2).isType(NodeSegment.class).parent()
				.child(5).isType(NodeSegment.class);
	}

	protected TreeVerificationBuilder getBuilder(String rules) throws IOException {
		Grammar grammar = parser.parse(rules);
		ISegmentFigure figure = transformer.transform(grammar);
		assertTrue(figure != null);
		return new TreeVerificationBuilder(figure).isType(RailroadDiagram.class);
	}
	
	protected class TreeVerificationBuilder {
		
		private IFigure currentFigure;
		
		private Map<String, IFigure> vars = newHashMap();

		public TreeVerificationBuilder(IFigure currentFigure) {
			this.currentFigure = currentFigure;
		}

		public TreeVerificationBuilder as(String name) {
			vars.put(name, currentFigure);
			return this;
		}
		
		public TreeVerificationBuilder goTo(String name) {
			currentFigure = vars.get(name);
			assertTrue(currentFigure != null);
			return this;
		}
		
		public TreeVerificationBuilder hasChildren(int numChildren) {
			assertEquals(numChildren, currentFigure.getChildren().size());
			return this;
		}
		
		public TreeVerificationBuilder child(int index) {
			assertTrue("Index " + index + " out of bounds", currentFigure.getChildren().size() > index && index >= 0);
			currentFigure = (IFigure) currentFigure.getChildren().get(index);
			return this;
		}
		
		public TreeVerificationBuilder parent() {
			currentFigure = currentFigure.getParent();
			assertTrue("No parent", currentFigure != null);
			return this;
		}
		
		public TreeVerificationBuilder isType(Class<? extends IFigure> clazz) {
			assertEquals("Invalid type ", clazz, currentFigure.getClass());
			return this;
		}
		
		public TreeVerificationBuilder connects(String from, String to) {
			isType(Connection.class);
			assertEquals(vars.get(from), ((Connection)currentFigure).getSourceAnchor().getOwner());
			assertEquals(vars.get(to), ((Connection)currentFigure).getTargetAnchor().getOwner());
			return this;
		}
	}
}
