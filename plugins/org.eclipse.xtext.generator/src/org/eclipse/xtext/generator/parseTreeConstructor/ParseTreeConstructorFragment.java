package org.eclipse.xtext.generator.parseTreeConstructor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;

public class ParseTreeConstructorFragment extends AbstractGeneratorFragment {
	@Override
	public Map<String, String> getGuiceBindingsRt(Grammar grammar) {
		Map<String, String> bindings = new HashMap<String, String>();
		bindings.put(IParseTreeConstructor.class.getName(),ParseTreeConstructorUtil.getParseTreeConstructorName(grammar));
		return bindings;
	}
}
