package org.eclipse.xtext.idea.example.entities.idea.completion

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.template.impl.LiveTemplateLookupElementImpl
import com.intellij.codeInsight.template.impl.TemplateImpl
import com.intellij.codeInsight.template.impl.TextExpression
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage

import static com.intellij.patterns.PlatformPatterns.*
import static org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesElementTypeProvider.*

class EntitiesCompletionContributor extends AbstractEntitiesCompletionContributor {
	new() {
		super(EntitiesLanguage.INSTANCE)
		extend(
			CompletionType.BASIC,
			psiElement.withParent(psiElement(Entity_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE))
		) [ parameters, context, result |
			val template = new TemplateImpl("entity name", "") => [
				addVariable(new TextExpression("Name"), true)
			]
			result += new LiveTemplateLookupElementImpl(template, false)
		]
	}

}
