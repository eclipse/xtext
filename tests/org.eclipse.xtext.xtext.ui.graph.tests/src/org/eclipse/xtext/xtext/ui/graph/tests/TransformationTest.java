package org.eclipse.xtext.xtext.ui.graph.tests;

import java.io.IOException;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtext.ui.graph.figures.BypassSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.CrossPointSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.ISegmentFigure;
import org.eclipse.xtext.xtext.ui.graph.figures.NodeSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.RailroadDiagram;
import org.eclipse.xtext.xtext.ui.graph.figures.RailroadTrack;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.Connection;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.CrossPoint;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.LabelNode;
import org.eclipse.xtext.xtext.ui.graph.trafo.Xtext2RailroadTransformer;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import static com.google.common.collect.Maps.newHashMap;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(XtextRunner.class)
@InjectWith(RailroadInjectorProvider.class)
public class TransformationTest {

	@Inject 
	private Xtext2RailroadTransformer transformer;
	
	@Test
	public void testTransform() throws Exception {
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
	public void testTransformOptional() throws Exception {
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

	protected TreeVerificationBuilder getBuilder(String rules) throws IOException {
		Grammar grammar = parse(rules);
		ISegmentFigure figure = transformer.transform(grammar);
		assertTrue(figure != null);
		return new TreeVerificationBuilder(figure).isType(RailroadDiagram.class);
	}
	
	protected Grammar parse(String rules) throws IOException {
		ResourceSet resourceSet = new XtextResourceSet();
		Resource grammarResource = resourceSet.createResource(URI.createURI("Test.xtext"));
		grammarResource.load(new StringInputStream(
				"grammar Test with org.eclipse.xtext.common.Terminals \n"
				+ "generate test \"Test\"\n" + rules), null);
		EList<EObject> contents = grammarResource.getContents();
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		assertTrue(root instanceof Grammar);
		return (Grammar) root;
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
