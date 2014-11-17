package org.eclipse.xtext.idea.sdomain.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectType;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.idea.sdomain.idea.lang.psi.impl.SDomainFileImpl;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.idea.sdomain.services.SDomainGrammarAccess;

public class SDomainElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SDomainFileImpl>>(SDomainLanguage.INSTANCE);

	public static final IElementType NAME_TYPE = new IElementType("NAME", SDomainLanguage.INSTANCE);

	public static final IElementType EOBJECT_TYPE = new IElementType("EOBJECT_TYPE", SDomainLanguage.INSTANCE);

	public static final IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> NAMED_EOBJECT_TYPE = new PsiNamedEObjectType("NAMED_EOBJECT", SDomainLanguage.INSTANCE);

	public static final IElementType CROSS_REFERENCE_TYPE = new IElementType("CROSS_REFERENCE", SDomainLanguage.INSTANCE);
	
	public static final IGrammarAwareElementType File_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType File_ElementsAssignment_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType File_ElementsElementParserRuleCall_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Import_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Import_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Import_ImportKeyword_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Import_ImportedNamespaceAssignment_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Import_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedNameWithWildCard_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedNameWithWildCard_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedNameWithWildCard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedNameWithWildCard_FullStopAsteriskKeyword_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedName_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedName_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedName_Group_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Namespace_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Namespace_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Namespace_NameAssignment_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Namespace_NameQualifiedNameParserRuleCall_0_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Namespace_LeftCurlyBracketKeyword_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Namespace_ElementsAssignment_2_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Namespace_ElementsElementParserRuleCall_2_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Namespace_RightCurlyBracketKeyword_3_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Element_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Element_Alternatives_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Element_NamespaceParserRuleCall_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Element_TypeParserRuleCall_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Element_ImportParserRuleCall_2_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Type_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Type_Alternatives_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Type_EntityParserRuleCall_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Type_DatatypeParserRuleCall_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_EntityKeyword_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_NameAssignment_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_PropertiesAssignment_3_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_PropertiesPropertyParserRuleCall_3_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Entity_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Datatype_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Datatype_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Datatype_DatatypeKeyword_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Datatype_NameAssignment_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Datatype_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Property_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Property_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Property_TypeAssignment_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Property_TypeTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Property_NameAssignment_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	static {
		SDomainGrammarAccess grammarAccess = SDomainLanguage.INSTANCE.getInstance(SDomainGrammarAccess.class);
		
		File_ELEMENT_TYPE =  new IGrammarAwareElementType("File_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getFileRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFileRule(), File_ELEMENT_TYPE);
		File_ElementsAssignment_ELEMENT_TYPE =  new IGrammarAwareElementType("File_ElementsAssignment_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getFileAccess().getElementsAssignment());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFileAccess().getElementsAssignment(), File_ElementsAssignment_ELEMENT_TYPE);
		File_ElementsElementParserRuleCall_0_ELEMENT_TYPE =  new IGrammarAwareElementType("File_ElementsElementParserRuleCall_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getFileAccess().getElementsElementParserRuleCall_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFileAccess().getElementsElementParserRuleCall_0(), File_ElementsElementParserRuleCall_0_ELEMENT_TYPE);
		
		Import_ELEMENT_TYPE =  new IGrammarAwareElementType("Import_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getImportRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getImportRule(), Import_ELEMENT_TYPE);
		Import_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("Import_Group_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getImportAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getImportAccess().getGroup(), Import_Group_ELEMENT_TYPE);
		Import_ImportKeyword_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Import_ImportKeyword_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getImportAccess().getImportKeyword_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getImportAccess().getImportKeyword_0(), Import_ImportKeyword_0_ELEMENT_TYPE);
		Import_ImportedNamespaceAssignment_1_ELEMENT_TYPE =  new IGrammarAwareElementType("Import_ImportedNamespaceAssignment_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getImportAccess().getImportedNamespaceAssignment_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), Import_ImportedNamespaceAssignment_1_ELEMENT_TYPE);
		Import_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Import_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0(), Import_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0_ELEMENT_TYPE);
		
		QualifiedNameWithWildCard_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedNameWithWildCard_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameWithWildCardRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameWithWildCardRule(), QualifiedNameWithWildCard_ELEMENT_TYPE);
		QualifiedNameWithWildCard_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedNameWithWildCard_Group_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameWithWildCardAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup(), QualifiedNameWithWildCard_Group_ELEMENT_TYPE);
		QualifiedNameWithWildCard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedNameWithWildCard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0(), QualifiedNameWithWildCard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE);
		QualifiedNameWithWildCard_FullStopAsteriskKeyword_1_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedNameWithWildCard_FullStopAsteriskKeyword_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1(), QualifiedNameWithWildCard_FullStopAsteriskKeyword_1_ELEMENT_TYPE);
		
		QualifiedName_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedName_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameRule(), QualifiedName_ELEMENT_TYPE);
		QualifiedName_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedName_Group_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameAccess().getGroup(), QualifiedName_Group_ELEMENT_TYPE);
		QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE);
		QualifiedName_Group_1_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedName_Group_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameAccess().getGroup_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), QualifiedName_Group_1_ELEMENT_TYPE);
		QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE);
		QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE =  new IGrammarAwareElementType("QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE);
		
		Namespace_ELEMENT_TYPE =  new IGrammarAwareElementType("Namespace_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getNamespaceRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getNamespaceRule(), Namespace_ELEMENT_TYPE);
		Namespace_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("Namespace_Group_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getNamespaceAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getNamespaceAccess().getGroup(), Namespace_Group_ELEMENT_TYPE);
		Namespace_NameAssignment_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Namespace_NameAssignment_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getNamespaceAccess().getNameAssignment_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getNamespaceAccess().getNameAssignment_0(), Namespace_NameAssignment_0_ELEMENT_TYPE);
		Namespace_NameQualifiedNameParserRuleCall_0_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Namespace_NameQualifiedNameParserRuleCall_0_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_0_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_0_0(), Namespace_NameQualifiedNameParserRuleCall_0_0_ELEMENT_TYPE);
		Namespace_LeftCurlyBracketKeyword_1_ELEMENT_TYPE =  new IGrammarAwareElementType("Namespace_LeftCurlyBracketKeyword_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_1(), Namespace_LeftCurlyBracketKeyword_1_ELEMENT_TYPE);
		Namespace_ElementsAssignment_2_ELEMENT_TYPE =  new IGrammarAwareElementType("Namespace_ElementsAssignment_2_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getNamespaceAccess().getElementsAssignment_2());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getNamespaceAccess().getElementsAssignment_2(), Namespace_ElementsAssignment_2_ELEMENT_TYPE);
		Namespace_ElementsElementParserRuleCall_2_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Namespace_ElementsElementParserRuleCall_2_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getNamespaceAccess().getElementsElementParserRuleCall_2_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getNamespaceAccess().getElementsElementParserRuleCall_2_0(), Namespace_ElementsElementParserRuleCall_2_0_ELEMENT_TYPE);
		Namespace_RightCurlyBracketKeyword_3_ELEMENT_TYPE =  new IGrammarAwareElementType("Namespace_RightCurlyBracketKeyword_3_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_3());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_3(), Namespace_RightCurlyBracketKeyword_3_ELEMENT_TYPE);
		
		Element_ELEMENT_TYPE =  new IGrammarAwareElementType("Element_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getElementRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getElementRule(), Element_ELEMENT_TYPE);
		Element_Alternatives_ELEMENT_TYPE =  new IGrammarAwareElementType("Element_Alternatives_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getElementAccess().getAlternatives());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getElementAccess().getAlternatives(), Element_Alternatives_ELEMENT_TYPE);
		Element_NamespaceParserRuleCall_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Element_NamespaceParserRuleCall_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getElementAccess().getNamespaceParserRuleCall_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getElementAccess().getNamespaceParserRuleCall_0(), Element_NamespaceParserRuleCall_0_ELEMENT_TYPE);
		Element_TypeParserRuleCall_1_ELEMENT_TYPE =  new IGrammarAwareElementType("Element_TypeParserRuleCall_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getElementAccess().getTypeParserRuleCall_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getElementAccess().getTypeParserRuleCall_1(), Element_TypeParserRuleCall_1_ELEMENT_TYPE);
		Element_ImportParserRuleCall_2_ELEMENT_TYPE =  new IGrammarAwareElementType("Element_ImportParserRuleCall_2_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getElementAccess().getImportParserRuleCall_2());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getElementAccess().getImportParserRuleCall_2(), Element_ImportParserRuleCall_2_ELEMENT_TYPE);
		
		Type_ELEMENT_TYPE =  new IGrammarAwareElementType("Type_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getTypeRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getTypeRule(), Type_ELEMENT_TYPE);
		Type_Alternatives_ELEMENT_TYPE =  new IGrammarAwareElementType("Type_Alternatives_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getTypeAccess().getAlternatives());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getTypeAccess().getAlternatives(), Type_Alternatives_ELEMENT_TYPE);
		Type_EntityParserRuleCall_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Type_EntityParserRuleCall_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getTypeAccess().getEntityParserRuleCall_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getTypeAccess().getEntityParserRuleCall_0(), Type_EntityParserRuleCall_0_ELEMENT_TYPE);
		Type_DatatypeParserRuleCall_1_ELEMENT_TYPE =  new IGrammarAwareElementType("Type_DatatypeParserRuleCall_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getTypeAccess().getDatatypeParserRuleCall_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getTypeAccess().getDatatypeParserRuleCall_1(), Type_DatatypeParserRuleCall_1_ELEMENT_TYPE);
		
		Entity_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityRule(), Entity_ELEMENT_TYPE);
		Entity_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_Group_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityAccess().getGroup(), Entity_Group_ELEMENT_TYPE);
		Entity_EntityKeyword_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_EntityKeyword_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityAccess().getEntityKeyword_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityAccess().getEntityKeyword_0(), Entity_EntityKeyword_0_ELEMENT_TYPE);
		Entity_NameAssignment_1_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_NameAssignment_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityAccess().getNameAssignment_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityAccess().getNameAssignment_1(), Entity_NameAssignment_1_ELEMENT_TYPE);
		Entity_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0(), Entity_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE);
		Entity_LeftCurlyBracketKeyword_2_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2(), Entity_LeftCurlyBracketKeyword_2_ELEMENT_TYPE);
		Entity_PropertiesAssignment_3_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_PropertiesAssignment_3_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityAccess().getPropertiesAssignment_3());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityAccess().getPropertiesAssignment_3(), Entity_PropertiesAssignment_3_ELEMENT_TYPE);
		Entity_PropertiesPropertyParserRuleCall_3_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_PropertiesPropertyParserRuleCall_3_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0(), Entity_PropertiesPropertyParserRuleCall_3_0_ELEMENT_TYPE);
		Entity_RightCurlyBracketKeyword_4_ELEMENT_TYPE =  new IGrammarAwareElementType("Entity_RightCurlyBracketKeyword_4_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4(), Entity_RightCurlyBracketKeyword_4_ELEMENT_TYPE);
		
		Datatype_ELEMENT_TYPE =  new IGrammarAwareElementType("Datatype_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getDatatypeRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getDatatypeRule(), Datatype_ELEMENT_TYPE);
		Datatype_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("Datatype_Group_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getDatatypeAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getDatatypeAccess().getGroup(), Datatype_Group_ELEMENT_TYPE);
		Datatype_DatatypeKeyword_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Datatype_DatatypeKeyword_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getDatatypeAccess().getDatatypeKeyword_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getDatatypeAccess().getDatatypeKeyword_0(), Datatype_DatatypeKeyword_0_ELEMENT_TYPE);
		Datatype_NameAssignment_1_ELEMENT_TYPE =  new IGrammarAwareElementType("Datatype_NameAssignment_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getDatatypeAccess().getNameAssignment_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getDatatypeAccess().getNameAssignment_1(), Datatype_NameAssignment_1_ELEMENT_TYPE);
		Datatype_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Datatype_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getDatatypeAccess().getNameIDTerminalRuleCall_1_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getDatatypeAccess().getNameIDTerminalRuleCall_1_0(), Datatype_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE);
		
		Property_ELEMENT_TYPE =  new IGrammarAwareElementType("Property_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getPropertyRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getPropertyRule(), Property_ELEMENT_TYPE);
		Property_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("Property_Group_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getPropertyAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getPropertyAccess().getGroup(), Property_Group_ELEMENT_TYPE);
		Property_TypeAssignment_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Property_TypeAssignment_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getPropertyAccess().getTypeAssignment_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getPropertyAccess().getTypeAssignment_0(), Property_TypeAssignment_0_ELEMENT_TYPE);
		Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0(), Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE);
		Property_TypeTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE =  new IGrammarAwareElementType("Property_TypeTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getPropertyAccess().getTypeTypeQualifiedNameParserRuleCall_0_0_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getPropertyAccess().getTypeTypeQualifiedNameParserRuleCall_0_0_1(), Property_TypeTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE);
		Property_NameAssignment_1_ELEMENT_TYPE =  new IGrammarAwareElementType("Property_NameAssignment_1_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getPropertyAccess().getNameAssignment_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getPropertyAccess().getNameAssignment_1(), Property_NameAssignment_1_ELEMENT_TYPE);
		Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SDomainLanguage.INSTANCE, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0(), Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE);
	}

	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	public IElementType getObjectType() {
		return EOBJECT_TYPE;
	}

	public IElementType getCrossReferenceType() {
		return CROSS_REFERENCE_TYPE;
	}

	public IElementType getNameType() {
		return NAME_TYPE;
	}

	public IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> getNamedObjectType() {
		return NAMED_EOBJECT_TYPE;
	}
	
	public IGrammarAwareElementType getFileElementType() {
		return File_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFile_ElementsAssignmentElementType() {
		return File_ElementsAssignment_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFile_ElementsElementParserRuleCall_0ElementType() {
		return File_ElementsElementParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getImportElementType() {
		return Import_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getImport_GroupElementType() {
		return Import_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getImport_ImportKeyword_0ElementType() {
		return Import_ImportKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getImport_ImportedNamespaceAssignment_1ElementType() {
		return Import_ImportedNamespaceAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType() {
		return Import_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildCardElementType() {
		return QualifiedNameWithWildCard_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildCard_GroupElementType() {
		return QualifiedNameWithWildCard_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType() {
		return QualifiedNameWithWildCard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameWithWildCard_FullStopAsteriskKeyword_1ElementType() {
		return QualifiedNameWithWildCard_FullStopAsteriskKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedNameElementType() {
		return QualifiedName_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_GroupElementType() {
		return QualifiedName_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_IDTerminalRuleCall_0ElementType() {
		return QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_Group_1ElementType() {
		return QualifiedName_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_FullStopKeyword_1_0ElementType() {
		return QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getQualifiedName_IDTerminalRuleCall_1_1ElementType() {
		return QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNamespaceElementType() {
		return Namespace_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNamespace_GroupElementType() {
		return Namespace_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNamespace_NameAssignment_0ElementType() {
		return Namespace_NameAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNamespace_NameQualifiedNameParserRuleCall_0_0ElementType() {
		return Namespace_NameQualifiedNameParserRuleCall_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNamespace_LeftCurlyBracketKeyword_1ElementType() {
		return Namespace_LeftCurlyBracketKeyword_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNamespace_ElementsAssignment_2ElementType() {
		return Namespace_ElementsAssignment_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNamespace_ElementsElementParserRuleCall_2_0ElementType() {
		return Namespace_ElementsElementParserRuleCall_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getNamespace_RightCurlyBracketKeyword_3ElementType() {
		return Namespace_RightCurlyBracketKeyword_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getElementElementType() {
		return Element_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getElement_AlternativesElementType() {
		return Element_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getElement_NamespaceParserRuleCall_0ElementType() {
		return Element_NamespaceParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getElement_TypeParserRuleCall_1ElementType() {
		return Element_TypeParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getElement_ImportParserRuleCall_2ElementType() {
		return Element_ImportParserRuleCall_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getTypeElementType() {
		return Type_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getType_AlternativesElementType() {
		return Type_Alternatives_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getType_EntityParserRuleCall_0ElementType() {
		return Type_EntityParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getType_DatatypeParserRuleCall_1ElementType() {
		return Type_DatatypeParserRuleCall_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntityElementType() {
		return Entity_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_GroupElementType() {
		return Entity_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_EntityKeyword_0ElementType() {
		return Entity_EntityKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_NameAssignment_1ElementType() {
		return Entity_NameAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_NameIDTerminalRuleCall_1_0ElementType() {
		return Entity_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_LeftCurlyBracketKeyword_2ElementType() {
		return Entity_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_PropertiesAssignment_3ElementType() {
		return Entity_PropertiesAssignment_3_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_PropertiesPropertyParserRuleCall_3_0ElementType() {
		return Entity_PropertiesPropertyParserRuleCall_3_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getEntity_RightCurlyBracketKeyword_4ElementType() {
		return Entity_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getDatatypeElementType() {
		return Datatype_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getDatatype_GroupElementType() {
		return Datatype_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getDatatype_DatatypeKeyword_0ElementType() {
		return Datatype_DatatypeKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getDatatype_NameAssignment_1ElementType() {
		return Datatype_NameAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getDatatype_NameIDTerminalRuleCall_1_0ElementType() {
		return Datatype_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getPropertyElementType() {
		return Property_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_GroupElementType() {
		return Property_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_TypeAssignment_0ElementType() {
		return Property_TypeAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_TypeTypeCrossReference_0_0ElementType() {
		return Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_TypeTypeQualifiedNameParserRuleCall_0_0_1ElementType() {
		return Property_TypeTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_NameAssignment_1ElementType() {
		return Property_NameAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getProperty_NameIDTerminalRuleCall_1_0ElementType() {
		return Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

}
