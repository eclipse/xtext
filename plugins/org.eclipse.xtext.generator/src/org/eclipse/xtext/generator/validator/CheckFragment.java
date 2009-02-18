package org.eclipse.xtext.generator.validator;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;


public class CheckFragment extends AbstractGeneratorFragment {
	
	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[]{
			"org.eclipse.xtend","org.eclipse.xtend.typesystem.emf"
		};
	}
	
}
