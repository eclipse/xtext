package org.eclipse.xtext.generator.idea

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumLiteralDeclaration
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule

class IdeaPluginExtension {
	
	@Inject extension IdeaPluginClassNames 
	
	def getAllRules(Grammar grammar) {
		getAllRules(grammar, <AbstractRule>newArrayList())
	}
	
	def List<AbstractRule> getAllRules(Grammar grammar, List<AbstractRule> rules) {
		rules.addAll(grammar.rules.filter(e | !(e instanceof TerminalRule) && rules.filter(r | r.name.equals(e.name)).empty))
		for (usedGrammar : grammar.usedGrammars) {
			getAllRules(usedGrammar, rules);
		}
		return rules;
	}
	
	def getSimpleName(Grammar grammar) {
		GrammarUtil::getName(grammar);
	}
	
	def getPackageName(Grammar grammar) {
		GrammarUtil::getNamespace(grammar);
	}
	
	def getPath(String packageName) {
		packageName.replaceAll("\\.", "/")
	}
	
	def getInstanceName(AbstractRule abstractRule) {
		abstractRule.name.toUpperCase
	}
	
	def ruleName(TerminalRule terminalRule) {
		"RULE_" + terminalRule.instanceName
	}
	
	def getRuleInstanceName(Assignment assignment) {
		(assignment.terminal as RuleCall).rule.instanceName
	}
	
	def getInstanceName(Assignment assignment) {
		GrammarUtil::containingRule(assignment).getInstanceName(assignment)
	}
	
	def getInstanceName(EnumLiteralDeclaration enumLiteralDeclaration) {
		GrammarUtil::containingRule(enumLiteralDeclaration).getInstanceName(enumLiteralDeclaration)
	}
	
	def getInstanceName(RuleCall ruleCall) {
		GrammarUtil::containingAssignment(ruleCall).instanceName
	}
	
	def getInstanceName(AbstractRule rule, Assignment assignment) {
		rule.instanceName + "_" + assignment.feature.toUpperCase
	}
	
	def getInstanceName(AbstractRule rule, EnumLiteralDeclaration enumLiteralDeclaration) {
		rule.instanceName + "_" + enumLiteralDeclaration.enumLiteral.literal.toUpperCase
	}
	
	def getPsiElementImplClassName(Grammar grammar, AbstractRule abstractRule) {
		grammar.fileImplName.toPackageName + "." + abstractRule.getPsiElementImplClassName
	}
	
	def getPsiElementImplClassName(AbstractRule abstractRule) {
		abstractRule.name + "Impl"
	}
	
	def getPsiElementClassName(AbstractRule abstractRule) {
		abstractRule.name
	}
	
	def getPsiElementSuperClassName(AbstractRule abstractRule) {
		if (abstractRule.hasName) {
			return "PsiNamedElement"
		}
		return "PsiElement"
	}
	
	def hasName(AbstractRule rule) {
		!rule.assignments.filter(a | a.feature.equals("name")).empty
	}
	
	def getAssignmentsWithoutName(AbstractRule rule) {
		rule.assignments.filter(a | !a.feature.equals("name")).toList
	}
	
	def getAssignments(AbstractRule rule) {
		rule.eAllContents.filter(typeof(Assignment)).filter(a | GrammarUtil::containingRule(a).equals(rule)).toList
	}
	
	def getEnumLiteralDeclarations(AbstractRule rule) {
		rule.eAllContents.filter(typeof(EnumLiteralDeclaration)).filter(a | GrammarUtil::containingRule(a).equals(rule)).toList
	}
	
	def getLocalName(AbstractRule abstractRule) {
		abstractRule.name.toFirstLower
	}
	
	def getRuleLocalName(AbstractElement element) {
		GrammarUtil::containingRule(element).localName
	}
	
	def getRuleInstanceName(AbstractElement element) {
		GrammarUtil::containingRule(element).instanceName
	}
	
	def getLocalName(Assignment assignment) {
		GrammarUtil::containingRule(assignment).localName + assignment.feature.toFirstUpper		
	}
	
	def getLocalName(RuleCall ruleCall) {
		GrammarUtil::containingAssignment(ruleCall).localName		
	}
	
	def hasMultipleAssigment(AbstractRule rule) {
		!rule.multipleAssignments.empty
	}
	
	def getMultipleAssignments(AbstractRule rule) {
		rule.assignments.filter(a | a.multiple)
	}
	
	def getTypeName(Assignment assignment) {
		if (assignment.multiple) {
			return "List<" + assignment.internalTypeName + ">";
		}
		return assignment.internalTypeName;
	}
	
	def isMultiple(Assignment assignment) {
		"+=".equals(assignment.operator)
	}
	
	def isBoolean(Assignment assignment) {
		"?=".equals(assignment.operator)
	}
	
	def isOneOrNone(AbstractElement element) {
		"?".equals(element.cardinality)
	}
	
	def isExactlyOne(AbstractElement element) {
		element.cardinality == null
	}
	
	def isAny(AbstractElement element) {
		"*".equals(element.cardinality)
	}
	
	def isOneOrMore(AbstractElement element) {
		"+".equals(element.cardinality)
	}
	
	def getVariableName(AbstractElement abstartElement) {
		"variable_" + GrammarUtil::containingRule(abstartElement).eAllContents.filter(typeof(AbstractElement)).toList.indexOf(abstartElement)
	}
	
	def dispatch String getInternalTypeName(Assignment assignment) {
		if (assignment.isBoolean) {
			return "boolean";
		}
		return assignment.terminal.internalTypeName;
	}
	
	def dispatch String getInternalTypeName(CrossReference crossReference) {
		crossReference.terminal.internalTypeName
	}
	
	def dispatch String getInternalTypeName(RuleCall ruleCall) {
		if (ruleCall.rule instanceof TerminalRule) {
			return "String";
		}
		return ruleCall.rule.name;
	}
	
	def dispatch String getInternalTypeName(AbstractElement abstractElement) {
		""
	}
	
	def getGetter(Assignment assignment) {
		if (assignment.isBoolean) {
			return "is" + assignment.feature.toFirstUpper	
		}
		return "get" + assignment.feature.toFirstUpper
	}
	
	def getSetter(Assignment assignment) {
		"set" + assignment.feature.toFirstUpper
	}
	
	def getPsiElementImplClassName(Assignment assignment) {
		(assignment.terminal as RuleCall).rule.psiElementImplClassName
	}
	
	def getPsiElementClassName(Assignment assignment) {
		(assignment.terminal as RuleCall).rule.psiElementClassName
	}
	
	def getLanguageID(Grammar grammar) {
		grammar.name
	}
	
	def getStubElementTypeClassName(AbstractRule abstractRule) {
		abstractRule.name + "StubElementType";
	}
	

}