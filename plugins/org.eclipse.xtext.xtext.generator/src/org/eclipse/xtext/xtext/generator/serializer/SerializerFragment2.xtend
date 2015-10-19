/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.serializer

import com.google.common.collect.ImmutableSet
import com.google.inject.Inject
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.Alternatives
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Group
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.Parameter
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource
import org.eclipse.xtext.serializer.ISerializationContext
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition
import org.eclipse.xtext.serializer.impl.Serializer
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer
import org.eclipse.xtext.serializer.sequencer.ITransientValueService
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation
import org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.serializer.analysis.SerializationContext.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import static extension org.eclipse.xtext.xtext.generator.util.GenModelUtil2.*
import org.eclipse.xtext.serializer.analysis.SerializationContext

class SerializerFragment2 extends AbstractGeneratorFragment2 {
	
	private static def <K, V> Map<K, V> toMap(Iterable<Pair<K, V>> items) {
		val result = newLinkedHashMap
		for (i : items) {
			result.put(i.key, i.value)
		}
		result
	}
	
	@Inject extension XtextGeneratorNaming
	@Inject extension SemanticSequencerExtensions
	@Inject extension SyntacticSequencerExtensions
	@Inject extension GrammarAccessExtensions
	@Inject extension SyntheticTerminalDetector syntheticTerminalDetector
	@Inject extension IGrammarConstraintProvider
	@Inject DebugGraphGenerator debugGraphGenerator
	@Inject FileAccessFactory fileAccessFactory
	@Inject CodeConfig codeConfig
	
	@Accessors boolean generateDebugData = false
	@Accessors boolean generateStub = true
	@Accessors boolean generateSupportForDeprecatedContextObject = false
	
	boolean detectSyntheticTerminals = true
	
	/**
	 * Set to false if synthetic terminal should be ignored. Synthetic terminals
	 * have the form {@code terminal ABC: 'synthetic:ABC';} in the grammar
	 * and require a customized {@link AbstractSplittingTokenSource token source}.
	 */
	def void setDetectSyntheticTerminals(boolean detectSyntheticTerminals) {
		this.detectSyntheticTerminals = detectSyntheticTerminals
	}
	
	protected def String getSerializerBasePackage(Grammar grammar) {
		grammar.runtimeBasePackage + '.serializer'
	}
	
	protected def TypeReference getSemanticSequencerClass(Grammar grammar) {
		new TypeReference(grammar.serializerBasePackage, GrammarUtil.getSimpleName(grammar) + 'SemanticSequencer')
	}
	
	protected def TypeReference getSyntacticSequencerClass(Grammar grammar) {
		new TypeReference(grammar.serializerBasePackage, GrammarUtil.getSimpleName(grammar) + 'SyntacticSequencer')
	}
		
	protected def TypeReference getAbstractSemanticSequencerClass(Grammar grammar) {
		new TypeReference(grammar.serializerBasePackage, 'Abstract' + GrammarUtil.getSimpleName(grammar) + 'SemanticSequencer')
	}
		
	protected def TypeReference getAbstractSyntacticSequencerClass(Grammar grammar) {
		new TypeReference(grammar.serializerBasePackage, 'Abstract' + GrammarUtil.getSimpleName(grammar) + 'SyntacticSequencer')
	}
		
	protected def String getGrammarConstraintsPath(Grammar grammar) {
		grammar.serializerBasePackage.replace('.', '/') + '/' + GrammarUtil.getSimpleName(grammar) + 'GrammarConstraints.txt'
	}
	
	override generate() {
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType(ISemanticSequencer.typeRef, grammar.semanticSequencerClass)
			.addTypeToType(ISyntacticSequencer.typeRef, grammar.syntacticSequencerClass)
			.addTypeToType(ISerializer.typeRef, Serializer.typeRef)
			.contributeTo(language.runtimeGenModule)
		
		if (projectConfig.runtime.manifest !== null) {
			projectConfig.runtime.manifest.exportedPackages += grammar.serializerBasePackage
			projectConfig.runtime.manifest.requiredBundles += 'org.eclipse.xtext.xbase.lib'
		}
		
		generateAbstractSemanticSequencer()
		generateAbstractSyntacticSequencer()
		if (generateStub) {
			generateSemanticSequencer()
			generateSyntacticSequencer()
		}
		
		if (generateDebugData) {
			generateGrammarConstraints()
			for (fileToContent : debugGraphGenerator.generateDebugGraphs) {
				projectConfig.runtime.srcGen.generateFile(fileToContent.key, fileToContent.value)
			}
		}
	}
	
	protected def generateSemanticSequencer() {
		if (codeConfig.preferXtendStubs) {
			fileAccessFactory.createXtendFile(grammar.semanticSequencerClass, '''
				class «grammar.semanticSequencerClass.simpleName» extends «grammar.abstractSemanticSequencerClass» {
				}
			''').writeTo(projectConfig.runtime.src)
		} else {
			fileAccessFactory.createJavaFile(grammar.semanticSequencerClass, '''
				public class «grammar.semanticSequencerClass.simpleName» extends «grammar.abstractSemanticSequencerClass» {
				}
			''').writeTo(projectConfig.runtime.src)
		}
	}
	
	private def unassignedCalledTokenRuleName(AbstractRule rule) '''get«rule.name»Token'''
	
	protected def generateSyntacticSequencer() {
		if (codeConfig.preferXtendStubs) {
			fileAccessFactory.createXtendFile(grammar.syntacticSequencerClass, '''
				class «grammar.syntacticSequencerClass.simpleName» extends «grammar.abstractSyntacticSequencerClass» {
					«IF detectSyntheticTerminals»
						«FOR rule : GrammarUtil.allTerminalRules(grammar).filter[isSyntheticTerminalRule]»
							
							/**
							 * Stub implementation for a synthetic terminal rule. Defaults to the empty string.
							 */
							// TODO review the concrete syntax for the terminal
							override «rule.unassignedCalledTokenRuleName»(«EObject» semanticObject, «RuleCall» ruleCall, «INode» node) {
								return ''
							}
						«ENDFOR»
					«ENDIF»
				}
			''').writeTo(projectConfig.runtime.src)
		} else {
			fileAccessFactory.createJavaFile(grammar.syntacticSequencerClass, '''
				public class «grammar.syntacticSequencerClass.simpleName» extends «grammar.abstractSyntacticSequencerClass» {
					«IF detectSyntheticTerminals»
						«FOR rule : GrammarUtil.allTerminalRules(grammar).filter[isSyntheticTerminalRule]»
							
							/**
							 * Stub implementation for a synthetic terminal rule. Defaults to the empty string.
							 */
							// TODO review the concrete syntax for the terminal
							@Override
							public String «rule.unassignedCalledTokenRuleName»(«EObject» semanticObject, «RuleCall» ruleCall, «INode» node) {
								return "";
							}
						«ENDFOR»
					«ENDIF»
				}
			''').writeTo(projectConfig.runtime.src)
		}
	}
	
	protected def generateAbstractSemanticSequencer() {
		val localConstraints = grammar.grammarConstraints
		val superConstraints = grammar.superGrammar.grammarConstraints
		val newLocalConstraints = localConstraints.filter[type !== null && !superConstraints.contains(it)].toSet
		val clazz = if (generateStub) grammar.abstractSemanticSequencerClass else grammar.semanticSequencerClass
		val superClazz = if (localConstraints.exists[superConstraints.contains(it)]) 
				grammar.usedGrammars.head.semanticSequencerClass
			else
				AbstractDelegatingSemanticSequencer.typeRef
		val javaFile = fileAccessFactory.createGeneratedJavaFile(clazz)
		javaFile.resourceSet = language.resourceSet
		
		javaFile.content = '''
			public «IF generateStub»abstract «ENDIF»class «clazz.simpleName» extends «superClazz» {
			
				@«Inject»
				private «grammar.grammarAccess» grammarAccess;
				
				«genMethodCreateSequence»
				
				«FOR c : newLocalConstraints.sort»
					«genMethodSequence(c)»
					
				«ENDFOR»
			}
		'''
		javaFile.annotations += new SuppressWarningsAnnotation
		javaFile.writeTo(projectConfig.runtime.srcGen)
	}
	
	private def Iterable<EPackage> getAccessedPackages() {
		grammar.grammarConstraints.filter[type !== null].map[type.EPackage].toSet.sortBy[name]
	}
	
	private def Iterable<EClass> getAccessedClasses(EPackage pkg) {
		grammar.grammarConstraints.map[type].filter[it !== null && EPackage == pkg].toSet.sortBy[name]
	}
	
	private def StringConcatenationClient genMethodCreateSequence() {
		val superConstraints = grammar.superGrammar.grammarConstraints.map[it->it].toMap
		'''
			@Override
			public void sequence(«ISerializationContext» context, «EObject» semanticObject) {
				«EPackage» epackage = semanticObject.eClass().getEPackage();
				«ParserRule» rule = context.getParserRule();
				«Action» action = context.getAssignedAction();
				«Set»<«Parameter»> parameters = context.getEnabledBooleanParameters();
				«FOR pkg : accessedPackages.indexed»
					«IF pkg.key > 0»else «ENDIF»if (epackage == «pkg.value».«packageLiteral»)
						switch (semanticObject.eClass().getClassifierID()) {
						«FOR type : pkg.value.accessedClasses»
							case «pkg.value».«type.getIntLiteral(language.resourceSet)»:
								«genMethodCreateSequenceCaseBody(superConstraints, type)»
						«ENDFOR»
						}
				«ENDFOR»
				if (errorAcceptor != null)
					errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
			}
		'''
	}
	
	private def StringConcatenationClient genContextCondition(ISerializationContext context, IConstraint constraint) {
		val StringConcatenationClient cond = switch it:context {
			case assignedAction !== null: '''action == grammarAccess.«assignedAction.gaAccessor»'''
			case parserRule !== null: '''rule == grammarAccess.«parserRule.gaAccessor»'''
		}
		val values = context.enabledBooleanParameters
		if (!values.isEmpty) {
			'''(«cond» && «ImmutableSet».of(«values.map["grammarAccess."+gaAccessor].join(", ")»).equals(parameters))'''
		} else if (!constraint.contexts.forall[(it as SerializationContext).declaredParameters.isEmpty]) {
			'''(«cond» && parameters.isEmpty())'''
		} else {
			cond
		}
	}
	
	private def StringConcatenationClient genMethodCreateSequenceCaseBody(Map<IConstraint, IConstraint> superConstraints, EClass type) {
		val contexts = grammar.getGrammarConstraints(type).entrySet.sortBy[key.name]
		'''
			«IF contexts.size > 1»
				«FOR ctx : contexts.indexed»
					«IF ctx.key > 0»else «ENDIF»if («FOR c : ctx.value.value.sort SEPARATOR "\n\t\t|| "»«c.genContextCondition(ctx.value.key)»«ENDFOR») {
						«genMethodCreateSequenceCall(superConstraints, type, ctx.value.key)»
					}
				«ENDFOR»
				else break;
			«ELSEIF contexts.size == 1»
				«genMethodCreateSequenceCall(superConstraints, type, contexts.head.key)»
			«ELSE»
				// error, no contexts. 
			«ENDIF»
		'''
	}
	
	private def StringConcatenationClient genMethodCreateSequenceCall(Map<IConstraint, IConstraint> superConstraints, EClass type, IConstraint key) {
		val superConstraint = superConstraints.get(key)
		val constraint = superConstraint ?: key
		'''
			sequence_«constraint.simpleName»(context, («type») semanticObject); 
			return; 
		'''
	}
	
	private def StringConcatenationClient genMethodSequence(IGrammarConstraintProvider.IConstraint c) {
		val rs = language.resourceSet
		val StringConcatenationClient cast =
			if (c.type.getGenClass(rs).isEObjectExtension)
				''''''
			else
				'''(«EObject») '''
		val states = c.linearListOfMandatoryAssignments
		'''
			/**
			 * Contexts:
			 *     «c.contexts.sort.join("\n").replaceAll("\\n","\n*     ")»
			 *
			 * Constraint:
			 *     «IF c.body === null»{«c.type.name»}«ELSE»«c.body.toString.replaceAll("\\n","\n*     ")»«ENDIF»
			 */
			protected void sequence_«c.simpleName»(«ISerializationContext» context, «c.type» semanticObject) {
				«IF states !== null»
					if (errorAcceptor != null) {
						«FOR s : states»
							if (transientValues.isValueTransient(«cast»semanticObject, «s.feature.EContainingClass.EPackage».«s.feature.getFeatureLiteral(rs)») == «ITransientValueService.ValueTransient».YES)
								errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(«cast»semanticObject, «s.feature.EContainingClass.EPackage».«s.feature.getFeatureLiteral(rs)»));
						«ENDFOR»
					}
					«SequenceFeeder» feeder = createSequencerFeeder(context, «cast»semanticObject);
					«FOR f: states»
						feeder.accept(grammarAccess.«f.assignedGrammarElement.gaAccessor()», semanticObject.«f.feature.getGetAccessor(rs)»());
					«ENDFOR»
					feeder.finish();
				«ELSE»
					genericSequencer.createSequence(context, «cast»semanticObject);
				«ENDIF»
			}
			
			«IF generateSupportForDeprecatedContextObject»
				@Deprecated
				protected void sequence_«c.simpleName»(«EObject» context, «c.type» semanticObject) {
					sequence_«c.simpleName»(createContext(context, semanticObject), semanticObject);
				}
			«ENDIF»
		'''
	}
	
	protected def generateAbstractSyntacticSequencer() {
		val clazz = if (generateStub) grammar.abstractSyntacticSequencerClass else grammar.syntacticSequencerClass
		val javaFile = fileAccessFactory.createGeneratedJavaFile(clazz)
		javaFile.resourceSet = language.resourceSet
		
		javaFile.content = '''
			public «IF generateStub»abstract «ENDIF»class «clazz.simpleName» extends «AbstractSyntacticSequencer» {
			
				protected «grammar.grammarAccess» grammarAccess;
				«FOR group : allAmbiguousTransitionsBySyntax»
					protected «'org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias'.typeRef» match_«group.identifier»;
				«ENDFOR»
				
				@«Inject»
				protected void init(«IGrammarAccess» access) {
					grammarAccess = («grammar.grammarAccess») access;
					«FOR group : allAmbiguousTransitionsBySyntax»
						match_«group.identifier» = «group.elementAlias.elementAliasToConstructor»;
					«ENDFOR»
				}
				
				«genGetUnassignedRuleCallTokens»
				
				«FOR rule : unassignedCalledTokenRules SEPARATOR "\n"»
					«genGetUnassignedRuleCallToken(rule)»
				«ENDFOR»
				
				«genEmitUnassignedTokens»
			
				«FOR group : allAmbiguousTransitionsBySyntax»
					/**
					 * Ambiguous syntax:
					 *     «group.elementAlias.toString.replace("\n", "\n *     ")»
					 *
					 * This ambiguous syntax occurs at:
					 «FOR trans : group.transitions.map[group.ambiguityInsideTransition(it).trim].toSet.sort»
					 	*     «trans.toString.replace("\n", "\n*     ")»
					 «ENDFOR»
					 */
					protected void emit_«group.identifier»(«EObject» semanticObject, «ISyntacticSequencerPDAProvider.ISynNavigable» transition, «List»<«INode»> nodes) {
						acceptNodes(transition, nodes);
					}
					
				«ENDFOR»
			}
		'''
		javaFile.annotations += new SuppressWarningsAnnotation
		javaFile.writeTo(projectConfig.runtime.srcGen)
	}
	
	private def List<AbstractRule> unassignedCalledTokenRules() {
		val rules = grammar.allRules.filter[isEObjectRule]
		val calls = rules.map[containedRuleCalls.filter[isUnassignedRuleCall]].flatten
		return calls.map[rule].toSet.sortBy[name]
	}

	private def boolean isUnassignedRuleCall(RuleCall c) {
		if (c.isEObjectRuleCall)
			return false
		val ass = c.containingAssignment
		return ass == null || ass.isBooleanAssignment
	}

	private def String defaultValue(AbstractElement ele, Set<AbstractElement> visited) {
		switch (ele) {
			case !visited.add(ele): ""
			case ele.isOptionalCardinality(): ""
			Alternatives: ele.elements.head.defaultValue(visited)
			Group: ele.elements.map[defaultValue(visited)].join
			Keyword: ele.value
			RuleCall: ele.rule.alternatives.defaultValue(visited)
			default: ''
		}
	}

	private def StringConcatenationClient genGetUnassignedRuleCallTokens() '''
		@Override
		protected String getUnassignedRuleCallToken(«EObject» semanticObject, «RuleCall» ruleCall, «INode» node) {
			«FOR rule : unassignedCalledTokenRules.indexed»
				«IF rule.key > 0»else «ENDIF»if (ruleCall.getRule() == grammarAccess.«rule.value.gaAccessor»)
					return «rule.value.unassignedCalledTokenRuleName»(semanticObject, ruleCall, node);
			«ENDFOR»
			return "";
		}
	'''

	private def String textWithoutComments(INode node) {
		switch node {
			ILeafNode case !node.hidden || node.text.trim.length == 0: node.text
			ICompositeNode: node.children.map[textWithoutComments].join
			default: ''
		}
	}

	private def StringConcatenationClient genGetUnassignedRuleCallToken(AbstractRule rule) {
		if (rule instanceof TerminalRule) {
			if (detectSyntheticTerminals && rule.isSyntheticTerminalRule) {
				return '''
					/**
					 * Synthetic terminal rule. The concrete syntax is to be specified by clients.
					«IF !generateStub» * Defaults to the empty string.«ENDIF»
					 */
					protected «IF generateStub»abstract «ENDIF»String «rule.unassignedCalledTokenRuleName»(«EObject» semanticObject, «RuleCall» ruleCall, «INode» node)«IF generateStub»;«ELSE» { return ""; }«ENDIF»
				'''
			}
		}
		return '''
			/**
			 * «NodeModelUtils.getNode(rule).textWithoutComments.trim.replace('\n', '\n* ')»
			 */
			protected String «rule.unassignedCalledTokenRuleName»(«EObject» semanticObject, «RuleCall» ruleCall, «INode» node) {
				if (node != null)
					return getTokenText(node);
				return "«Strings.convertToJavaString(rule.alternatives.defaultValue(newHashSet))»";
			}
		'''
	}

	private def StringConcatenationClient genEmitUnassignedTokens() '''
		@Override
		protected void emitUnassignedTokens(«EObject» semanticObject, «ISynTransition» transition, «INode» fromNode, «INode» toNode) {
			if (transition.getAmbiguousSyntaxes().isEmpty()) return;
			«List»<«INode»> transitionNodes = collectNodes(fromNode, toNode);
			for («AbstractElementAlias» syntax : transition.getAmbiguousSyntaxes()) {
				«List»<«INode»> syntaxNodes = getNodesFor(transitionNodes, syntax);
				«FOR group : allAmbiguousTransitionsBySyntax.indexed»
					«IF group.key > 0»else «ENDIF»if (match_«group.value.identifier».equals(syntax))
						emit_«group.value.identifier»(semanticObject, getLastNavigableState(), syntaxNodes);
				«ENDFOR»
				«IF !allAmbiguousTransitionsBySyntax.empty»else «ENDIF»acceptNodes(getLastNavigableState(), syntaxNodes);
			}
		}
	'''
	
	protected def generateGrammarConstraints() {
		fileAccessFactory.createTextFile(grammar.grammarConstraintsPath, '''
			«FOR e : grammar.constraints.groupByEqualityAndSort SEPARATOR '\n'»
				«e.first»:
					«IF e.second.body == null»
						{«e.second.type?.name»};
					«ELSE»
						«e.second.body»;
					«ENDIF»
			«ENDFOR»
		''').writeTo(projectConfig.runtime.srcGen)
	}
}
