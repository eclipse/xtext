package org.eclipse.xtext.generator.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.generator.IGeneratorFragment;

/**
 * {@link IGeneratorFragment} to generate a java based validity checker for a given grammar. 
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class JavaValidatorFragment extends AbstractValidatorFragment {
	
	private static Logger log = Logger.getLogger(JavaValidatorFragment.class);
	
	private List<String> composedChecks = new ArrayList<String>();
	
	public void addComposedCheck(String composedCheckValidator) {
		this.composedChecks.add(composedCheckValidator);
	}
	
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (log.isInfoEnabled())
			log.info("executing generate for "+getClass().getName());
		XpandFacade.create(ctx).evaluate(getTemplate()+"::generate", grammar, getParameters(grammar),this.composedChecks);
	}

	@Override
	public Map<BindKey, BindValue> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addTypeToTypeEagerSingleton(getValidatorName(grammar, ""), getValidatorName(grammar, ""))
			.getBindings();
	}
	
	public static String getValidatorName(Grammar g, String prefix) {
		return GrammarUtil.getNamespace(g) + ".validation." + prefix + GrammarUtil.getName(g) + "JavaValidator";
	}
}
