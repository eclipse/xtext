package org.eclipse.xtext.idea.common.types.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectType;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.idea.common.types.idea.lang.psi.impl.RefactoringTestLanguageFileImpl;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.idea.common.types.services.RefactoringTestLanguageGrammarAccess;

public class RefactoringTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<RefactoringTestLanguageFileImpl>>(RefactoringTestLanguageLanguage.INSTANCE);

	public static final IElementType NAME_TYPE = new IElementType("NAME", RefactoringTestLanguageLanguage.INSTANCE);

	public static final IElementType EOBJECT_TYPE = new IElementType("EOBJECT_TYPE", RefactoringTestLanguageLanguage.INSTANCE);

	public static final IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> NAMED_EOBJECT_TYPE = new PsiNamedEObjectType("NAMED_EOBJECT", RefactoringTestLanguageLanguage.INSTANCE);

	public static final IElementType CROSS_REFERENCE_TYPE = new IElementType("CROSS_REFERENCE", RefactoringTestLanguageLanguage.INSTANCE);
	
	public static final IGrammarAwareElementType Model_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Model_ReferenceHolderAssignment_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType Model_ReferenceHolderReferenceHolderParserRuleCall_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType ReferenceHolder_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType ReferenceHolder_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType ReferenceHolder_NameAssignment_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType ReferenceHolder_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType ReferenceHolder_DefaultReferenceAssignment_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType ReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType ReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_Group_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_Group_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_FullStopKeyword_1_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_Group_2_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_DollarSignKeyword_2_0_ELEMENT_TYPE;
	
	public static final IGrammarAwareElementType FQN_IDTerminalRuleCall_2_1_ELEMENT_TYPE;

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	static {
		RefactoringTestLanguageGrammarAccess grammarAccess = RefactoringTestLanguageLanguage.INSTANCE.getInstance(RefactoringTestLanguageGrammarAccess.class);
		
		Model_ELEMENT_TYPE =  new IGrammarAwareElementType("Model_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getModelRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getModelRule(), Model_ELEMENT_TYPE);
		Model_ReferenceHolderAssignment_ELEMENT_TYPE =  new IGrammarAwareElementType("Model_ReferenceHolderAssignment_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getModelAccess().getReferenceHolderAssignment());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getModelAccess().getReferenceHolderAssignment(), Model_ReferenceHolderAssignment_ELEMENT_TYPE);
		Model_ReferenceHolderReferenceHolderParserRuleCall_0_ELEMENT_TYPE =  new IGrammarAwareElementType("Model_ReferenceHolderReferenceHolderParserRuleCall_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getModelAccess().getReferenceHolderReferenceHolderParserRuleCall_0(), Model_ReferenceHolderReferenceHolderParserRuleCall_0_ELEMENT_TYPE);
		
		ReferenceHolder_ELEMENT_TYPE =  new IGrammarAwareElementType("ReferenceHolder_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getReferenceHolderRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getReferenceHolderRule(), ReferenceHolder_ELEMENT_TYPE);
		ReferenceHolder_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("ReferenceHolder_Group_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getReferenceHolderAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getReferenceHolderAccess().getGroup(), ReferenceHolder_Group_ELEMENT_TYPE);
		ReferenceHolder_NameAssignment_0_ELEMENT_TYPE =  new IGrammarAwareElementType("ReferenceHolder_NameAssignment_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getReferenceHolderAccess().getNameAssignment_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getReferenceHolderAccess().getNameAssignment_0(), ReferenceHolder_NameAssignment_0_ELEMENT_TYPE);
		ReferenceHolder_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE =  new IGrammarAwareElementType("ReferenceHolder_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getReferenceHolderAccess().getNameIDTerminalRuleCall_0_0(), ReferenceHolder_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE);
		ReferenceHolder_DefaultReferenceAssignment_1_ELEMENT_TYPE =  new IGrammarAwareElementType("ReferenceHolder_DefaultReferenceAssignment_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getReferenceHolderAccess().getDefaultReferenceAssignment_1(), ReferenceHolder_DefaultReferenceAssignment_1_ELEMENT_TYPE);
		ReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0_ELEMENT_TYPE =  new IGrammarAwareElementType("ReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeCrossReference_1_0(), ReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0_ELEMENT_TYPE);
		ReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1_ELEMENT_TYPE =  new IGrammarAwareElementType("ReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getReferenceHolderAccess().getDefaultReferenceJvmTypeFQNParserRuleCall_1_0_1(), ReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1_ELEMENT_TYPE);
		
		FQN_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNRule());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNRule(), FQN_ELEMENT_TYPE);
		FQN_Group_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_Group_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNAccess().getGroup());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNAccess().getGroup(), FQN_Group_ELEMENT_TYPE);
		FQN_IDTerminalRuleCall_0_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_IDTerminalRuleCall_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), FQN_IDTerminalRuleCall_0_ELEMENT_TYPE);
		FQN_Group_1_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_Group_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNAccess().getGroup_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNAccess().getGroup_1(), FQN_Group_1_ELEMENT_TYPE);
		FQN_FullStopKeyword_1_0_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_FullStopKeyword_1_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), FQN_FullStopKeyword_1_0_ELEMENT_TYPE);
		FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE);
		FQN_Group_2_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_Group_2_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNAccess().getGroup_2());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNAccess().getGroup_2(), FQN_Group_2_ELEMENT_TYPE);
		FQN_DollarSignKeyword_2_0_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_DollarSignKeyword_2_0_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNAccess().getDollarSignKeyword_2_0());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNAccess().getDollarSignKeyword_2_0(), FQN_DollarSignKeyword_2_0_ELEMENT_TYPE);
		FQN_IDTerminalRuleCall_2_1_ELEMENT_TYPE =  new IGrammarAwareElementType("FQN_IDTerminalRuleCall_2_1_ELEMENT_TYPE", RefactoringTestLanguageLanguage.INSTANCE, grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1());
		GRAMMAR_ELEMENT_TYPE.put(grammarAccess.getFQNAccess().getIDTerminalRuleCall_2_1(), FQN_IDTerminalRuleCall_2_1_ELEMENT_TYPE);
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
	
	public IGrammarAwareElementType getModelElementType() {
		return Model_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getModel_ReferenceHolderAssignmentElementType() {
		return Model_ReferenceHolderAssignment_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getModel_ReferenceHolderReferenceHolderParserRuleCall_0ElementType() {
		return Model_ReferenceHolderReferenceHolderParserRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getReferenceHolderElementType() {
		return ReferenceHolder_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getReferenceHolder_GroupElementType() {
		return ReferenceHolder_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getReferenceHolder_NameAssignment_0ElementType() {
		return ReferenceHolder_NameAssignment_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getReferenceHolder_NameIDTerminalRuleCall_0_0ElementType() {
		return ReferenceHolder_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getReferenceHolder_DefaultReferenceAssignment_1ElementType() {
		return ReferenceHolder_DefaultReferenceAssignment_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0ElementType() {
		return ReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1ElementType() {
		return ReferenceHolder_DefaultReferenceJvmTypeFQNParserRuleCall_1_0_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQNElementType() {
		return FQN_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQN_GroupElementType() {
		return FQN_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_0ElementType() {
		return FQN_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQN_Group_1ElementType() {
		return FQN_Group_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQN_FullStopKeyword_1_0ElementType() {
		return FQN_FullStopKeyword_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_1_1ElementType() {
		return FQN_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQN_Group_2ElementType() {
		return FQN_Group_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQN_DollarSignKeyword_2_0ElementType() {
		return FQN_DollarSignKeyword_2_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getFQN_IDTerminalRuleCall_2_1ElementType() {
		return FQN_IDTerminalRuleCall_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

}
