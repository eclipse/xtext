/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.xbase.ide.contentassist.antlr.internal.InternalXtypeParser;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

public class XtypeParser extends AbstractContentAssistParser {

	@Inject
	private XtypeGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalXtypeParser createParser() {
		InternalXtypeParser result = new InternalXtypeParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getJvmTypeReferenceAccess().getAlternatives(), "rule__JvmTypeReference__Alternatives");
					put(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives(), "rule__JvmArgumentTypeReference__Alternatives");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2(), "rule__JvmWildcardTypeReference__Alternatives_2");
					put(grammarAccess.getXImportDeclarationAccess().getAlternatives_1(), "rule__XImportDeclaration__Alternatives_1");
					put(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3(), "rule__XImportDeclaration__Alternatives_1_0_3");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0(), "rule__JvmTypeReference__Group_0__0");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1(), "rule__JvmTypeReference__Group_0_1__0");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0(), "rule__JvmTypeReference__Group_0_1_0__0");
					put(grammarAccess.getArrayBracketsAccess().getGroup(), "rule__ArrayBrackets__Group__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getGroup(), "rule__XFunctionTypeRef__Group__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0(), "rule__XFunctionTypeRef__Group_0__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1(), "rule__XFunctionTypeRef__Group_0_1__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1(), "rule__XFunctionTypeRef__Group_0_1_1__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup(), "rule__JvmParameterizedTypeReference__Group__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1(), "rule__JvmParameterizedTypeReference__Group_1__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2(), "rule__JvmParameterizedTypeReference__Group_1_2__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4(), "rule__JvmParameterizedTypeReference__Group_1_4__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0(), "rule__JvmParameterizedTypeReference__Group_1_4_0__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0(), "rule__JvmParameterizedTypeReference__Group_1_4_0_0__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2(), "rule__JvmParameterizedTypeReference__Group_1_4_2__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2(), "rule__JvmParameterizedTypeReference__Group_1_4_2_2__0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup(), "rule__JvmWildcardTypeReference__Group__0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0(), "rule__JvmWildcardTypeReference__Group_2_0__0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1(), "rule__JvmWildcardTypeReference__Group_2_1__0");
					put(grammarAccess.getJvmUpperBoundAccess().getGroup(), "rule__JvmUpperBound__Group__0");
					put(grammarAccess.getJvmUpperBoundAndedAccess().getGroup(), "rule__JvmUpperBoundAnded__Group__0");
					put(grammarAccess.getJvmLowerBoundAccess().getGroup(), "rule__JvmLowerBound__Group__0");
					put(grammarAccess.getJvmLowerBoundAndedAccess().getGroup(), "rule__JvmLowerBoundAnded__Group__0");
					put(grammarAccess.getJvmTypeParameterAccess().getGroup(), "rule__JvmTypeParameter__Group__0");
					put(grammarAccess.getJvmTypeParameterAccess().getGroup_1(), "rule__JvmTypeParameter__Group_1__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup(), "rule__QualifiedNameWithWildcard__Group__0");
					put(grammarAccess.getXImportDeclarationAccess().getGroup(), "rule__XImportDeclaration__Group__0");
					put(grammarAccess.getXImportDeclarationAccess().getGroup_1_0(), "rule__XImportDeclaration__Group_1_0__0");
					put(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup(), "rule__QualifiedNameInStaticImport__Group__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0(), "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0");
					put(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1(), "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1");
					put(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2(), "rule__XFunctionTypeRef__ReturnTypeAssignment_2");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0(), "rule__JvmParameterizedTypeReference__TypeAssignment_0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1(), "rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1");
					put(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1(), "rule__JvmUpperBound__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1(), "rule__JvmUpperBoundAnded__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1(), "rule__JvmLowerBound__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1(), "rule__JvmLowerBoundAnded__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmTypeParameterAccess().getNameAssignment_0(), "rule__JvmTypeParameter__NameAssignment_0");
					put(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_0(), "rule__JvmTypeParameter__ConstraintsAssignment_1_0");
					put(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_1(), "rule__JvmTypeParameter__ConstraintsAssignment_1_1");
					put(grammarAccess.getXImportSectionAccess().getImportDeclarationsAssignment(), "rule__XImportSection__ImportDeclarationsAssignment");
					put(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0(), "rule__XImportDeclaration__StaticAssignment_1_0_0");
					put(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1(), "rule__XImportDeclaration__ExtensionAssignment_1_0_1");
					put(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2(), "rule__XImportDeclaration__ImportedTypeAssignment_1_0_2");
					put(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0(), "rule__XImportDeclaration__WildcardAssignment_1_0_3_0");
					put(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1(), "rule__XImportDeclaration__MemberNameAssignment_1_0_3_1");
					put(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1(), "rule__XImportDeclaration__ImportedTypeAssignment_1_1");
					put(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2(), "rule__XImportDeclaration__ImportedNamespaceAssignment_1_2");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalXtypeParser typedParser = (InternalXtypeParser) parser;
			typedParser.entryRuleJvmTypeReference();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public XtypeGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(XtypeGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
