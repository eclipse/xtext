package org.eclipse.xtext.ui.editor.templates;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.xtext.Grammar;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * Resolves a template variable to <code>EEnumLiteral literals</code> which are
 * assignment-compatible with the <code>TemplateVariable variable</code>
 * enumeration parameter (e.g. in ${modifier:Enum('[PackageName.]Visibility')}).
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EnumTemplateVariableResolver extends
		AbstractTemplateVariableResolver {

	public EnumTemplateVariableResolver() {
		super(Messages.EnumTemplateVariableResolver_0, Messages.EnumTemplateVariableResolver_1 +
				Messages.EnumTemplateVariableResolver_2);
	}
	
	@Override
	public List<String> resolveValues(TemplateVariable variable,
			XtextTemplateContext castedContext) {
		String enumerationName = (String) variable.getVariableType()
				.getParams().iterator().next();
		Grammar grammar = getGrammar(castedContext);
		if (grammar == null)
			return Collections.emptyList();
		EEnum enumeration = (EEnum) getEClassifierForGrammar(enumerationName, grammar);
		if (enumeration == null) {
			return Collections.emptyList();
		}
		return Lists.transform(enumeration.getELiterals(), new Function<EEnumLiteral, String>() {
			public String apply(EEnumLiteral enumLiteral) {
				return enumLiteral.getLiteral();
			}
		});
	}

}
