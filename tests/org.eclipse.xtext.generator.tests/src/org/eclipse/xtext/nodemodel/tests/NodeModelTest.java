package org.eclipse.xtext.nodemodel.tests;

import java.util.List;

import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.generator.tests.Invocation;
import org.eclipse.xtext.grammargen.tests.SimpleTest2;

public class NodeModelTest extends AbstractGeneratorTest {

	@Override
	protected Class<?> getTheClass() {
		return SimpleTest2.class;
	}
	
	public void testNodeModel() throws Exception {
		List<Invocation> result = parse("optional keyword x 7 {}");
		
	}
}
