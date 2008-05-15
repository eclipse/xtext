package org.eclipse.xtext.parsetree;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.NodeAdapter;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.parser.XtextGrammarTestASTFactory;

public class NodeModelTest extends AbstractGeneratorTest {

	@Override
	protected Class<?> getTheClass() {
		return XtextGrammarTest.class;
	}
	
	public void testNodeModel() throws Exception {
		String model = "generate foo 'bar'\nFoo : name=ID (bars+=Bar)*;\nBar : x=STRING;";
		EObject object = (EObject) parse(model,new XtextGrammarTestASTFactory());
		checkNavigability(object);
		for(Iterator<EObject> i = object.eAllContents(); i.hasNext();) {
			checkNavigability(i.next());
		}
	}
	
	public AbstractNode checkNavigability(EObject object) {
		EList<Adapter> adapters = object.eAdapters();
		assertEquals(1, adapters.size());
		NodeAdapter adapter = (NodeAdapter) adapters.get(0);
		AbstractNode parsetreeNode = adapter.getParserNode();
		assertEquals(object, parsetreeNode.getElement());
		return parsetreeNode;
	}
}
