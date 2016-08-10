/*
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class TestLanguageGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Model");
		private final Assignment cTypesAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cTypesTypeDeclarationParserRuleCall_0 = (RuleCall)cTypesAssignment.eContents().get(0);
		
		//Model:
		//	types+=TypeDeclaration*;
		@Override public ParserRule getRule() { return rule; }
		
		//types+=TypeDeclaration*
		public Assignment getTypesAssignment() { return cTypesAssignment; }
		
		//TypeDeclaration
		public RuleCall getTypesTypeDeclarationParserRuleCall_0() { return cTypesTypeDeclarationParserRuleCall_0; }
	}
	public class TypeDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.TypeDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTypeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cExtendsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSuperTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cSuperTypeTypeDeclarationCrossReference_2_1_0 = (CrossReference)cSuperTypeAssignment_2_1.eContents().get(0);
		private final RuleCall cSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1 = (RuleCall)cSuperTypeTypeDeclarationCrossReference_2_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cPropertiesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cPropertiesPropertyParserRuleCall_4_0 = (RuleCall)cPropertiesAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//TypeDeclaration:
		//	'type' name=ID ('extends' superType=[TypeDeclaration])? '{'
		//	properties+=Property*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'type' name=ID ('extends' superType=[TypeDeclaration])? '{' properties+=Property* '}'
		public Group getGroup() { return cGroup; }
		
		//'type'
		public Keyword getTypeKeyword_0() { return cTypeKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//('extends' superType=[TypeDeclaration])?
		public Group getGroup_2() { return cGroup_2; }
		
		//'extends'
		public Keyword getExtendsKeyword_2_0() { return cExtendsKeyword_2_0; }
		
		//superType=[TypeDeclaration]
		public Assignment getSuperTypeAssignment_2_1() { return cSuperTypeAssignment_2_1; }
		
		//[TypeDeclaration]
		public CrossReference getSuperTypeTypeDeclarationCrossReference_2_1_0() { return cSuperTypeTypeDeclarationCrossReference_2_1_0; }
		
		//ID
		public RuleCall getSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1() { return cSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//properties+=Property*
		public Assignment getPropertiesAssignment_4() { return cPropertiesAssignment_4; }
		
		//Property
		public RuleCall getPropertiesPropertyParserRuleCall_4_0() { return cPropertiesPropertyParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class PropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Property");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTypeTypeParserRuleCall_0_0 = (RuleCall)cTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Property:
		//	type=Type name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//type=Type name=ID
		public Group getGroup() { return cGroup; }
		
		//type=Type
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_0_0() { return cTypeTypeParserRuleCall_0_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}
	public class TypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Type");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cTypeReferenceParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cPrimitiveTypeParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cArrayDiemensionsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Keyword cArrayDiemensionsLeftSquareBracketKeyword_1_0_0 = (Keyword)cArrayDiemensionsAssignment_1_0.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		
		//Type:
		//	(TypeReference | PrimitiveType) (arrayDiemensions+='[' ']')*;
		@Override public ParserRule getRule() { return rule; }
		
		//(TypeReference | PrimitiveType) (arrayDiemensions+='[' ']')*
		public Group getGroup() { return cGroup; }
		
		//(TypeReference | PrimitiveType)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//TypeReference
		public RuleCall getTypeReferenceParserRuleCall_0_0() { return cTypeReferenceParserRuleCall_0_0; }
		
		//PrimitiveType
		public RuleCall getPrimitiveTypeParserRuleCall_0_1() { return cPrimitiveTypeParserRuleCall_0_1; }
		
		//(arrayDiemensions+='[' ']')*
		public Group getGroup_1() { return cGroup_1; }
		
		//arrayDiemensions+='['
		public Assignment getArrayDiemensionsAssignment_1_0() { return cArrayDiemensionsAssignment_1_0; }
		
		//'['
		public Keyword getArrayDiemensionsLeftSquareBracketKeyword_1_0_0() { return cArrayDiemensionsLeftSquareBracketKeyword_1_0_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_1_1() { return cRightSquareBracketKeyword_1_1; }
	}
	public class TypeReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.TypeReference");
		private final Assignment cTypeRefAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cTypeRefTypeDeclarationCrossReference_0 = (CrossReference)cTypeRefAssignment.eContents().get(0);
		private final RuleCall cTypeRefTypeDeclarationIDTerminalRuleCall_0_1 = (RuleCall)cTypeRefTypeDeclarationCrossReference_0.eContents().get(1);
		
		//TypeReference:
		//	typeRef=[TypeDeclaration];
		@Override public ParserRule getRule() { return rule; }
		
		//typeRef=[TypeDeclaration]
		public Assignment getTypeRefAssignment() { return cTypeRefAssignment; }
		
		//[TypeDeclaration]
		public CrossReference getTypeRefTypeDeclarationCrossReference_0() { return cTypeRefTypeDeclarationCrossReference_0; }
		
		//ID
		public RuleCall getTypeRefTypeDeclarationIDTerminalRuleCall_0_1() { return cTypeRefTypeDeclarationIDTerminalRuleCall_0_1; }
	}
	public class PrimitiveTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.PrimitiveType");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cNameAlternatives_0 = (Alternatives)cNameAssignment.eContents().get(0);
		private final Keyword cNameStringKeyword_0_0 = (Keyword)cNameAlternatives_0.eContents().get(0);
		private final Keyword cNameIntKeyword_0_1 = (Keyword)cNameAlternatives_0.eContents().get(1);
		private final Keyword cNameBooleanKeyword_0_2 = (Keyword)cNameAlternatives_0.eContents().get(2);
		
		//PrimitiveType:
		//	name=('string' | 'int' | 'boolean');
		@Override public ParserRule getRule() { return rule; }
		
		//name=('string' | 'int' | 'boolean')
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//('string' | 'int' | 'boolean')
		public Alternatives getNameAlternatives_0() { return cNameAlternatives_0; }
		
		//'string'
		public Keyword getNameStringKeyword_0_0() { return cNameStringKeyword_0_0; }
		
		//'int'
		public Keyword getNameIntKeyword_0_1() { return cNameIntKeyword_0_1; }
		
		//'boolean'
		public Keyword getNameBooleanKeyword_0_2() { return cNameBooleanKeyword_0_2; }
	}
	
	
	private final ModelElements pModel;
	private final TypeDeclarationElements pTypeDeclaration;
	private final PropertyElements pProperty;
	private final TypeElements pType;
	private final TypeReferenceElements pTypeReference;
	private final PrimitiveTypeElements pPrimitiveType;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public TestLanguageGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pModel = new ModelElements();
		this.pTypeDeclaration = new TypeDeclarationElements();
		this.pProperty = new PropertyElements();
		this.pType = new TypeElements();
		this.pTypeReference = new TypeReferenceElements();
		this.pPrimitiveType = new PrimitiveTypeElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.ide.tests.testlanguage.TestLanguage".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Model:
	//	types+=TypeDeclaration*;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}
	
	//TypeDeclaration:
	//	'type' name=ID ('extends' superType=[TypeDeclaration])? '{'
	//	properties+=Property*
	//	'}';
	public TypeDeclarationElements getTypeDeclarationAccess() {
		return pTypeDeclaration;
	}
	
	public ParserRule getTypeDeclarationRule() {
		return getTypeDeclarationAccess().getRule();
	}
	
	//Property:
	//	type=Type name=ID;
	public PropertyElements getPropertyAccess() {
		return pProperty;
	}
	
	public ParserRule getPropertyRule() {
		return getPropertyAccess().getRule();
	}
	
	//Type:
	//	(TypeReference | PrimitiveType) (arrayDiemensions+='[' ']')*;
	public TypeElements getTypeAccess() {
		return pType;
	}
	
	public ParserRule getTypeRule() {
		return getTypeAccess().getRule();
	}
	
	//TypeReference:
	//	typeRef=[TypeDeclaration];
	public TypeReferenceElements getTypeReferenceAccess() {
		return pTypeReference;
	}
	
	public ParserRule getTypeReferenceRule() {
		return getTypeReferenceAccess().getRule();
	}
	
	//PrimitiveType:
	//	name=('string' | 'int' | 'boolean');
	public PrimitiveTypeElements getPrimitiveTypeAccess() {
		return pPrimitiveType;
	}
	
	public ParserRule getPrimitiveTypeRule() {
		return getPrimitiveTypeAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
