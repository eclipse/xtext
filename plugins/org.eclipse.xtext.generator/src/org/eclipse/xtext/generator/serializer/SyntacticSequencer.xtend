/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import com.google.inject.name.Named
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.terminals.SyntheticTerminalDetector
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.AbstractRule
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.INode

/**
 * @author Moritz Eyshold - Initial contribution and API
 */
class SyntacticSequencer extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject SerializerGenFileNames names
	
	/**
	 * @since 2.8
	 */
	@Accessors boolean detectSyntheticTerminals = true;
	
	/**
	 * @since 2.8
	 */
	@Accessors extension SyntheticTerminalDetector syntheticTerminalDetector
	
	@Inject @Named("generateXtendStub") Boolean generateXtendStub
	
	@Inject @Named("fileHeader") String fileHeader
	
	private def unassignedCalledTokenRuleName(AbstractRule rule) '''get«rule.name»Token'''
	
	override getFileContents(SerializerGenFileNames.GenFileName filename) {
		val file = new JavaFile(filename.packageName);
		file.body = if (generateXtendStub) '''
			class «filename.simpleName» extends «names.abstractSyntacticSequencer.simpleName» {
				«IF detectSyntheticTerminals»
					«FOR rule: GrammarUtil.allTerminalRules(grammar).filter[isSyntheticTerminalRule]»
						
						/**
						 * Stub implementation for a synthetic terminal rule. Defaults to the empty string.
						 */
						// TODO review the concrete syntax for the terminal
						override «rule.unassignedCalledTokenRuleName»(«file.imported(EObject)» semanticObject, «file.imported(RuleCall)» ruleCall, «file.imported(INode)» node) {
							return ''
						}
					«ENDFOR»
				«ENDIF»
			}
		''' else '''
			public class «filename.simpleName» extends «names.abstractSyntacticSequencer.simpleName» {
				«IF detectSyntheticTerminals»
					«FOR rule: GrammarUtil.allTerminalRules(grammar).filter[isSyntheticTerminalRule]»
						
						/**
						 * Stub implementation for a synthetic terminal rule. Defaults to the empty string.
						 */
						// TODO review the concrete syntax for the terminal
						@Override
						public String «rule.unassignedCalledTokenRuleName»(«file.imported(EObject)» semanticObject, «file.imported(RuleCall)» ruleCall, «file.imported(INode)» node) {
							return "";
						}
					«ENDFOR»
				«ENDIF»
			}
		'''
		return '''
			/*
			 «fileHeader»
			 */
			«file.toString»
		'''
		
	}

}