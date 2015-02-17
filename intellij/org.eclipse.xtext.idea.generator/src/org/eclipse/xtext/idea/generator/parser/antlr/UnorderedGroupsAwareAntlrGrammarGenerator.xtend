package org.eclipse.xtext.idea.generator.parser.antlr

import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.UnorderedGroup
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*

class UnorderedGroupsAwareAntlrGrammarGenerator extends DefaultAntlrGrammarGenerator {
		
	protected def compileInitUnorderedGroups(ParserRule it, AntlrOptions options) '''
		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
		«FOR group:eAllContentsAsList.filter(UnorderedGroup) SEPARATOR ', '»
			grammarAccess.«group.gaRuleElementAccessor»
		«ENDFOR»
		);
	'''
	
	protected def compileRestoreUnorderedGroups(ParserRule it, AntlrOptions options)
		'''«IF definesUnorderedGroups(options)»myUnorderedGroupState.restore();«ENDIF»'''
	
	override protected _dataTypeEbnf2(UnorderedGroup it, boolean supportActions) {
		if (supportActions) {
			val mandatoryContent = elements.filter[!optionalCardinality].size
			'''
				(
					{ 
					  getUnorderedGroupHelper().enter(grammarAccess.«gaRuleElementAccessor»);
					}
					(
						(
				«FOR element:elements.indexed SEPARATOR '|'»
							(
								{getUnorderedGroupHelper().canSelect(grammarAccess.«gaRuleElementAccessor», «element.key»)}?=>(
									{
										getUnorderedGroupHelper().select(grammarAccess.«gaRuleElementAccessor», «element.key»);
									}
			«««	Predicate {true}=> helps to workaround an issue in the Antlr grammar processing
									({true}?=>(«element.value.dataTypeEbnf2(supportActions)»))«IF element.value.multipleCardinality»+«ENDIF»
									{ 
										getUnorderedGroupHelper().returnFromSelection(grammarAccess.«gaRuleElementAccessor»);
									}
								)
							)
				«ENDFOR»
						)«IF mandatoryContent != 0»+
						{getUnorderedGroupHelper().canLeave(grammarAccess.«gaRuleElementAccessor»)}?«ELSE»*«ENDIF»
					)
				)
					{ 
					  getUnorderedGroupHelper().leave(grammarAccess.«gaRuleElementAccessor»);
					}
			'''
		} else {
			super._dataTypeEbnf2(it, supportActions)
		}
	}
	
	override protected _ebnf2(UnorderedGroup it, AntlrOptions options, boolean supportActions) {
		if (supportActions) {
			val mandatoryContent = elements.filter[!optionalCardinality].size
			'''
				(
					{ 
					  getUnorderedGroupHelper().enter(grammarAccess.«gaRuleElementAccessor»);
					}
					(
						(
				«FOR element:elements.indexed SEPARATOR '|'»
							(
								{getUnorderedGroupHelper().canSelect(grammarAccess.«gaRuleElementAccessor», «element.key»)}?=>(
									{
										getUnorderedGroupHelper().select(grammarAccess.«gaRuleElementAccessor», «element.key»);
									}
			«««	Predicate {true}=> helps to workaround an issue in the Antlr grammar processing
									({true}?=>(«element.value.ebnf2(options, supportActions)»))«IF element.value.multipleCardinality»+«ENDIF»
									{ 
										getUnorderedGroupHelper().returnFromSelection(grammarAccess.«gaRuleElementAccessor»);
									}
								)
							)
				«ENDFOR»
						)«IF mandatoryContent != 0»+
						{getUnorderedGroupHelper().canLeave(grammarAccess.«gaRuleElementAccessor»)}?«ELSE»*«ENDIF»
					)
				)
					{ 
					  getUnorderedGroupHelper().leave(grammarAccess.«gaRuleElementAccessor»);
					}
				'''
		} else {
			super._ebnf2(it, options, supportActions)	
		}
	}
	
}