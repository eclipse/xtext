/**
 * Copyright (c) 2020, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ui.editor.folding;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractFoldingTest;
import org.eclipse.xtext.xtext.ui.XtextUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextUiInjectorProvider.class)
public class XtextFoldingTest extends AbstractFoldingTest {
	@Test
	public void greetings() {
		String model =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"\n" +
				"[>Model:\n" +
				"	greetings+=Greeting*;<]\n" +
				"	\n" +
				"[>Greeting:\n" +
				"	'Hello' name=ID '!';<]\n";
		testFoldingRegions(model);
	}

	@Test
	public void arithmetics() {
		String model =
				"[>/*******************************************************************************\n" +
				" * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.\n" +
				" * This program and the accompanying materials are made available under the\n" +
				" * terms of the Eclipse Public License 2.0 which is available at\n" +
				" * http://www.eclipse.org/legal/epl-2.0.\n" +
				" *\n" +
				" * SPDX-License-Identifier: EPL-2.0\n" +
				" *******************************************************************************/<]\n" +
				"grammar org.eclipse.xtext.example.arithmetics.Arithmetics with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"generate arithmetics 'http://www.eclipse.org/Xtext/example/Arithmetics'\n" +
				"\n" +
				"[>Module:\n" +
				"	'module' name=ID\n" +
				"	(imports+=Import)*\n" +
				"	(statements+=Statement)*;<]\n" +
				"\n" +
				"[>Import:\n" +
				"	'import' module=[Module];<]\n" +
				"\n" +
				"[>Statement:\n" +
				"	Definition | Evaluation;<]\n" +
				"\n" +
				"[>Definition:\n" +
				"	'def' name=ID ('(' args+=DeclaredParameter (',' args+=DeclaredParameter)* ')')?\n" +
				"	':' expr=Expression ';';<]\n" +
				"\n" +
				"[>DeclaredParameter:\n" +
				"	name=ID;<]\n" +
				"\n" +
				"[>AbstractDefinition:\n" +
				"	Definition | DeclaredParameter;<]\n" +
				"\n" +
				"[>Evaluation:\n" +
				"	expression=Expression ';';<]\n" +
				"\n" +
				"[>Expression:\n" +
				"	Addition;<]\n" +
				"\n" +
				"[>Addition returns Expression:\n" +
				"	Multiplication (({Plus.left=current} '+' | {Minus.left=current} '-') right=Multiplication)*;<]\n" +
				"\n" +
				"[>Multiplication returns Expression:\n" +
				"	PrimaryExpression (({Multi.left=current} '*' | {Div.left=current} '/') right=PrimaryExpression)*;<]\n" +
				"\n" +
				"[>PrimaryExpression returns Expression:\n" +
				"	'(' Expression ')' |\n" +
				"	{NumberLiteral} value=NUMBER |\n" +
				"	{FunctionCall} func=[AbstractDefinition] ('(' args+=Expression (',' args+=Expression)* ')')?;<]\n" +
				"\n" +
				"[>terminal NUMBER returns ecore::EBigDecimal:\n" +
				"	('0'..'9')* ('.' ('0'..'9')+)?;<]\n" +
				"\n" +
				"[>@Override\n" +
				"terminal INT returns ecore::EInt:\n" +
				"	'this one has been deactivated';<]\n";
		testFoldingRegions(model);
	}

	@Test
	public void domainmodel() {
		String model =
				"[>/*******************************************************************************\n" +
				" * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.\n" +
				" * This program and the accompanying materials are made available under the\n" +
				" * terms of the Eclipse Public License 2.0 which is available at\n" +
				" * http://www.eclipse.org/legal/epl-2.0.\n" +
				" *\n" +
				" * SPDX-License-Identifier: EPL-2.0\n" +
				" *******************************************************************************/<]\n" +
				"grammar org.eclipse.xtext.example.domainmodel.Domainmodel with org.eclipse.xtext.xbase.Xbase\n" +
				"\n" +
				"generate domainmodel 'http://www.xtext.org/example/Domainmodel'\n" +
				"\n" +
				"[>DomainModel:\n" +
				"	importSection=XImportSection?\n" +
				"	elements+=AbstractElement*;<]\n" +
				"\n" +
				"[>AbstractElement:\n" +
				"	PackageDeclaration | Entity;<]\n" +
				"\n" +
				"[>PackageDeclaration:\n" +
				"	'package' name=QualifiedName '{'\n" +
				"		elements+=AbstractElement*\n" +
				"	'}';<]\n" +
				"\n" +
				"[>Entity:\n" +
				"	'entity' name=ValidID ('extends' superType=JvmParameterizedTypeReference)? '{'\n" +
				"		features+=Feature*\n" +
				"	'}';<]\n" +
				"\n" +
				"[>Feature:\n" +
				"	Property | Operation;<]\n" +
				"\n" +
				"[>Property:\n" +
				"	name=ValidID ':' type=JvmTypeReference;<]\n" +
				"\n" +
				"[>Operation:\n" +
				"	'op' name=ValidID '(' (params+=FullJvmFormalParameter (',' params+=FullJvmFormalParameter)*)? ')' (':' type=JvmTypeReference)?\n" +
				"		body=XBlockExpression;<]\n";
		testFoldingRegions(model);
	}

	@Test
	public void homeautomation() {
		String model =
				"[>/*******************************************************************************\n" +
				" * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.\n" +
				" * This program and the accompanying materials are made available under the\n" +
				" * terms of the Eclipse Public License 2.0 which is available at\n" +
				" * http://www.eclipse.org/legal/epl-2.0.\n" +
				" *\n" +
				" * SPDX-License-Identifier: EPL-2.0\n" +
				" *******************************************************************************/<]\n" +
				"grammar org.eclipse.xtext.example.homeautomation.RuleEngine with org.eclipse.xtext.xbase.Xbase\n" +
				"\n" +
				"import 'http://www.eclipse.org/xtext/xbase/Xbase' as xbase\n" +
				"generate ruleEngine 'http://www.eclipse.org/Xtext/example/RuleEngine'\n" +
				"\n" +
				"[>Model:\n" +
				"	declarations+=Declaration*;<]\n" +
				"\n" +
				"[>Declaration:\n" +
				"	Device | Rule;<]\n" +
				"\n" +
				"[>Device:\n" +
				"	'Device' name=ID 'can' 'be'\n" +
				"		(states+=State (',' states+=State)*)?;<]\n" +
				"\n" +
				"[>State:\n" +
				"	name=ID ;<]\n" +
				"\n" +
				"[>Rule:\n" +
				"	'Rule' description=STRING\n" +
				"		'when' deviceState=[State|QualifiedName]\n" +
				"		'then' thenPart=XBlockExpression;<]\n" +
				"\n" +
				"// We modify the concrete syntax of two Xbase expressions and make them indentation-aware\n" +
				"[>@Override\n" +
				"XBlockExpression returns xbase::XExpression:\n" +
				"	{xbase::XBlockExpression}\n" +
				"	BEGIN\n" +
				"		(expressions+=XExpressionOrVarDeclaration ';'?)*\n" +
				"	END;<]\n" +
				"\n" +
				"[>@Override\n" +
				"XSwitchExpression returns xbase::XExpression:\n" +
				"	{xbase::XSwitchExpression}\n" +
				"	'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'\n" +
				"		| =>(declaredParam=JvmFormalParameter ':')? switch=XExpression)\n" +
				"	BEGIN\n" +
				"		(cases+=XCasePart)*\n" +
				"		('default' ':' default=XExpression )?\n" +
				"	END;<]\n" +
				"\n" +
				"// The following synthetic tokens are used for the indentation-aware blocks\n" +
				"terminal BEGIN: 'synthetic:BEGIN';  // increase indentation\n" +
				"terminal END: 'synthetic:END';      // decrease indentation\n";
		testFoldingRegions(model);
	}

	@Test
	public void statemachine() {
		String model =
				"grammar org.eclipse.xtext.example.fowlerdsl.Statemachine with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate statemachine 'http://www.eclipse.org/xtext/example/fowlerdsl/Statemachine'\n" +
				"\n" +
				"[>Statemachine :\n" +
				"	{Statemachine}\n" +
				"	('events'\n" +
				"		events+=Event+\n" +
				"	'end')?\n" +
				"	('resetEvents'\n" +
				"		resetEvents+=[Event]+\n" +
				"	'end')?\n" +
				"	('commands'\n" +
				"		commands+=Command+\n" +
				"	'end')?\n" +
				"	states+=State*\n" +
				";<]\n" +
				"\n" +
				"[>Event:\n" +
				"	name=ID code=ID\n" +
				";<]\n" +
				"\n" +
				"[>Command:\n" +
				"	name=ID code=ID\n" +
				";<]\n" +
				"\n" +
				"[>State:\n" +
				"	'state' name=ID\n" +
				"		('actions' '{' actions+=[Command]+ '}')?\n" +
				"		transitions+=Transition*\n" +
				"	'end'\n" +
				";<]\n" +
				"\n" +
				"[>Transition:\n" +
				"	event=[Event] '=>' state=[State]\n" +
				";<]\n";
		testFoldingRegions(model);
	}
}
