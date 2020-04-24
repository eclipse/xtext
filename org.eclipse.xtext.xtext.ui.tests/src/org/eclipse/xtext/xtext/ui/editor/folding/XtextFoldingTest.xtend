/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.folding

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractFoldingTest
import org.eclipse.xtext.xtext.ui.XtextUiInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextUiInjectorProvider)
class XtextFoldingTest extends AbstractFoldingTest {

	@Test def greetings() {
		'''
			grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
			
			generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
			
			[>Model:
				greetings+=Greeting*;<]
				
			[>Greeting:
				'Hello' name=ID '!';<]
		'''.testFoldingRegions
	}

	@Test def arithmetics() {
		'''
			[>/*******************************************************************************
			 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
			 * This program and the accompanying materials are made available under the
			 * terms of the Eclipse Public License 2.0 which is available at
			 * http://www.eclipse.org/legal/epl-2.0.
			 *
			 * SPDX-License-Identifier: EPL-2.0
			 *******************************************************************************/<]
			grammar org.eclipse.xtext.example.arithmetics.Arithmetics with org.eclipse.xtext.common.Terminals
			
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate arithmetics "http://www.eclipse.org/Xtext/example/Arithmetics"
			
			[>Module:
				'module' name=ID
				(imports+=Import)*
				(statements+=Statement)*;<]
			
			[>Import:
				'import' module=[Module];<]
			
			[>Statement:
				Definition | Evaluation;<]
			
			[>Definition:
				'def' name=ID ('(' args+=DeclaredParameter (',' args+=DeclaredParameter)* ')')?
				':' expr=Expression ';';<]
			
			[>DeclaredParameter:
				name=ID;<]
			
			[>AbstractDefinition:
				Definition | DeclaredParameter;<]
			
			[>Evaluation:
				expression=Expression ';';<]
			
			[>Expression:
				Addition;<]
			
			[>Addition returns Expression:
				Multiplication (({Plus.left=current} '+' | {Minus.left=current} '-') right=Multiplication)*;<]
			
			[>Multiplication returns Expression:
				PrimaryExpression (({Multi.left=current} '*' | {Div.left=current} '/') right=PrimaryExpression)*;<]
			
			[>PrimaryExpression returns Expression:
				'(' Expression ')' |
				{NumberLiteral} value=NUMBER |
				{FunctionCall} func=[AbstractDefinition] ('(' args+=Expression (',' args+=Expression)* ')')?;<]
			
			[>terminal NUMBER returns ecore::EBigDecimal:
				('0'..'9')* ('.' ('0'..'9')+)?;<]
			
			[>@Override
			terminal INT returns ecore::EInt:
				'this one has been deactivated';<]
		'''.testFoldingRegions
	}

	@Test def domainmodel() {
		'''
			[>/*******************************************************************************
			 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
			 * This program and the accompanying materials are made available under the
			 * terms of the Eclipse Public License 2.0 which is available at
			 * http://www.eclipse.org/legal/epl-2.0.
			 *
			 * SPDX-License-Identifier: EPL-2.0
			 *******************************************************************************/<]
			grammar org.eclipse.xtext.example.domainmodel.Domainmodel with org.eclipse.xtext.xbase.Xbase
			
			generate domainmodel "http://www.xtext.org/example/Domainmodel"
			
			[>DomainModel:
				importSection=XImportSection?
				elements+=AbstractElement*;<]
			
			[>AbstractElement:
				PackageDeclaration | Entity;<]
			
			[>PackageDeclaration:
				'package' name=QualifiedName '{'
					elements+=AbstractElement*
				'}';<]
			
			[>Entity:
				'entity' name=ValidID ('extends' superType=JvmParameterizedTypeReference)? '{'
					features+=Feature*
				'}';<]
			
			[>Feature:
				Property | Operation;<]
			
			[>Property:
				name=ValidID ':' type=JvmTypeReference;<]
			
			[>Operation:
				'op' name=ValidID '(' (params+=FullJvmFormalParameter (',' params+=FullJvmFormalParameter)*)? ')' (':' type=JvmTypeReference)?
					body=XBlockExpression;<]
		'''.testFoldingRegions
	}

	@Test def homeautomation() {
		'''
			[>/*******************************************************************************
			 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
			 * This program and the accompanying materials are made available under the
			 * terms of the Eclipse Public License 2.0 which is available at
			 * http://www.eclipse.org/legal/epl-2.0.
			 *
			 * SPDX-License-Identifier: EPL-2.0
			 *******************************************************************************/<]
			grammar org.eclipse.xtext.example.homeautomation.RuleEngine with org.eclipse.xtext.xbase.Xbase
			
			import "http://www.eclipse.org/xtext/xbase/Xbase" as xbase
			generate ruleEngine "http://www.eclipse.org/Xtext/example/RuleEngine"
			
			[>Model:
				declarations+=Declaration*;<]
			
			[>Declaration:
				Device | Rule;<]
			
			[>Device:
				'Device' name=ID 'can' 'be'
					(states+=State (',' states+=State)*)?;<]
			
			[>State:
				name=ID ;<]
			
			[>Rule:
				'Rule' description=STRING
					'when' deviceState=[State|QualifiedName]
					'then' thenPart=XBlockExpression;<]
			
			// We modify the concrete syntax of two Xbase expressions and make them indentation-aware
			[>@Override
			XBlockExpression returns xbase::XExpression:
				{xbase::XBlockExpression}
				BEGIN
					(expressions+=XExpressionOrVarDeclaration ';'?)*
				END;<]
			
			[>@Override
			XSwitchExpression returns xbase::XExpression:
				{xbase::XSwitchExpression}
				'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
					| =>(declaredParam=JvmFormalParameter ':')? switch=XExpression)
				BEGIN
					(cases+=XCasePart)*
					('default' ':' default=XExpression )?
				END;<]
			
			// The following synthetic tokens are used for the indentation-aware blocks
			terminal BEGIN: 'synthetic:BEGIN';  // increase indentation
			terminal END: 'synthetic:END';      // decrease indentation
		'''.testFoldingRegions
	}

	@Test def statemachine() {
		'''
			grammar org.eclipse.xtext.example.fowlerdsl.Statemachine with org.eclipse.xtext.common.Terminals
			
			generate statemachine "http://www.eclipse.org/xtext/example/fowlerdsl/Statemachine"
			
			[>Statemachine :
				{Statemachine}
				('events'
					events+=Event+
				'end')?
				('resetEvents'
					resetEvents+=[Event]+
				'end')?
				('commands'
					commands+=Command+
				'end')?
				states+=State*
			;<]
			
			[>Event:
				name=ID code=ID
			;<]
			
			[>Command:
				name=ID code=ID
			;<]
			
			[>State:
				'state' name=ID
					('actions' '{' actions+=[Command]+ '}')?
					transitions+=Transition*
				'end'
			;<]
			
			[>Transition:
				event=[Event] '=>' state=[State]
			;<]
		'''.testFoldingRegions
	}
}