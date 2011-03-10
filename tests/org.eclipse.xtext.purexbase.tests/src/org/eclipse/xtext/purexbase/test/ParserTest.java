package org.eclipse.xtext.purexbase.test;

import static junit.framework.Assert.*;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.purexbase.PureXbaseInjectorProvider;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(PureXbaseInjectorProvider.class)
public class ParserTest {
	
	@Inject
	private ParseHelper<Model> parseHelper;
	
	@Test
	public void testParser() throws Exception {
		XBlockExpression expression = parseHelper.parse(
				"val x = 'hello' " +
				"val y = 'world!' " +
				"println(x+' '+y)").getBlock();
		assertEquals(3, expression.getExpressions().size());
	}

}
