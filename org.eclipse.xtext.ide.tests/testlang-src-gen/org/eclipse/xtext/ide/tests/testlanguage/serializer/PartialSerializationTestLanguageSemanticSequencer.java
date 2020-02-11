/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChilds;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.EClassRef;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Import;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChildList;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyMandatoryValues;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ManyValues;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Model;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChildList;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.SubChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.WithTransientContainer;
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialSerializationTestLanguageGrammarAccess;
import org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient;
import org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithtransientPackage;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class PartialSerializationTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PartialSerializationTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == EcorePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case EcorePackage.ECLASS:
				sequence_EClassDecl(context, (EClass) semanticObject); 
				return; 
			}
		else if (epackage == PartialSerializationTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILD:
				sequence_ChildWithSubChild(context, (ChildWithSubChild) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.CHILD_WITH_SUB_CHILDS:
				sequence_ChildWithSubChilds(context, (ChildWithSubChilds) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.ECLASS_REF:
				sequence_EClassRef(context, (EClassRef) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.MANDATORY_CHILD:
				sequence_MandatoryChild(context, (MandatoryChild) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.MANDATORY_CHILD_LIST:
				sequence_MandatoryChildList(context, (MandatoryChildList) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.MANDATORY_VALUE:
				sequence_MandatoryValue(context, (MandatoryValue) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.MANY_MANDATORY_VALUES:
				sequence_ManyMandatoryValues(context, (ManyMandatoryValues) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.MANY_VALUES:
				sequence_ManyOptionalValues(context, (ManyValues) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.NODE:
				sequence_Node(context, (Node) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD:
				sequence_OptionalChild(context, (OptionalChild) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.OPTIONAL_CHILD_LIST:
				sequence_OptionalChildList(context, (OptionalChildList) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.OPTIONAL_VALUE:
				sequence_OptionalValue(context, (OptionalValue) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.SUB_CHILD:
				sequence_SubChild(context, (SubChild) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.TWO_CHILD_LISTS:
				sequence_TwoChildLists(context, (TwoChildLists) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.TWO_CHILDS:
				sequence_TwoChilds(context, (TwoChilds) semanticObject); 
				return; 
			case PartialSerializationTestLanguagePackage.WITH_TRANSIENT_CONTAINER:
				sequence_WithTransientContainer(context, (WithTransientContainer) semanticObject); 
				return; 
			}
		else if (epackage == WithtransientPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case WithtransientPackage.WITH_TRANSIENT:
				sequence_WithTransient(context, (WithTransient) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ChildWithSubChild returns ChildWithSubChild
	 *
	 * Constraint:
	 *     subChilds+=SubChild*
	 */
	protected void sequence_ChildWithSubChild(ISerializationContext context, ChildWithSubChild semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns ChildWithSubChilds
	 *     ChildWithSubChilds returns ChildWithSubChilds
	 *
	 * Constraint:
	 *     children+=ChildWithSubChild*
	 */
	protected void sequence_ChildWithSubChilds(ISerializationContext context, ChildWithSubChilds semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EClassDecl returns EClass
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_EClassDecl(ISerializationContext context, EClass semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EcorePackage.Literals.ENAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EcorePackage.Literals.ENAMED_ELEMENT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns EClassRef
	 *     EClassRef returns EClassRef
	 *
	 * Constraint:
	 *     ref=[EClass|QualifiedName]
	 */
	protected void sequence_EClassRef(ISerializationContext context, EClassRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PartialSerializationTestLanguagePackage.Literals.ECLASS_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialSerializationTestLanguagePackage.Literals.ECLASS_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEClassRefAccess().getRefEClassQualifiedNameParserRuleCall_0_1(), semanticObject.eGet(PartialSerializationTestLanguagePackage.Literals.ECLASS_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     importedNamespace=QualifiedName
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PartialSerializationTestLanguagePackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialSerializationTestLanguagePackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns MandatoryChildList
	 *     MandatoryChildList returns MandatoryChildList
	 *
	 * Constraint:
	 *     children+=MandatoryValue+
	 */
	protected void sequence_MandatoryChildList(ISerializationContext context, MandatoryChildList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns MandatoryChild
	 *     MandatoryChild returns MandatoryChild
	 *
	 * Constraint:
	 *     child=MandatoryValue
	 */
	protected void sequence_MandatoryChild(ISerializationContext context, MandatoryChild semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PartialSerializationTestLanguagePackage.Literals.MANDATORY_CHILD__CHILD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialSerializationTestLanguagePackage.Literals.MANDATORY_CHILD__CHILD));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMandatoryChildAccess().getChildMandatoryValueParserRuleCall_0(), semanticObject.getChild());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns MandatoryValue
	 *     MandatoryValue returns MandatoryValue
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_MandatoryValue(ISerializationContext context, MandatoryValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PartialSerializationTestLanguagePackage.Literals.MANDATORY_VALUE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialSerializationTestLanguagePackage.Literals.MANDATORY_VALUE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMandatoryValueAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns ManyMandatoryValues
	 *     ManyMandatoryValues returns ManyMandatoryValues
	 *
	 * Constraint:
	 *     name+=ID+
	 */
	protected void sequence_ManyMandatoryValues(ISerializationContext context, ManyMandatoryValues semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns ManyValues
	 *     ManyOptionalValues returns ManyValues
	 *
	 * Constraint:
	 *     name+=ID*
	 */
	protected void sequence_ManyOptionalValues(ISerializationContext context, ManyValues semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     clazz+=EClassDecl+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Node
	 *     Node returns Node
	 *
	 * Constraint:
	 *     (imports+=Import* name=ID? refs+=[Node|QualifiedName]* children+=Node* ref=[Node|QualifiedName]?)
	 */
	protected void sequence_Node(ISerializationContext context, Node semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns OptionalChildList
	 *     OptionalChildList returns OptionalChildList
	 *
	 * Constraint:
	 *     children+=MandatoryValue*
	 */
	protected void sequence_OptionalChildList(ISerializationContext context, OptionalChildList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns OptionalChild
	 *     OptionalChild returns OptionalChild
	 *
	 * Constraint:
	 *     child=MandatoryValue?
	 */
	protected void sequence_OptionalChild(ISerializationContext context, OptionalChild semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns OptionalValue
	 *     OptionalValue returns OptionalValue
	 *
	 * Constraint:
	 *     name=ID?
	 */
	protected void sequence_OptionalValue(ISerializationContext context, OptionalValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubChild returns SubChild
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_SubChild(ISerializationContext context, SubChild semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PartialSerializationTestLanguagePackage.Literals.SUB_CHILD__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialSerializationTestLanguagePackage.Literals.SUB_CHILD__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubChildAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns TwoChildLists
	 *     TwoChildLists returns TwoChildLists
	 *
	 * Constraint:
	 *     (directChildren+=MandatoryValue+ childsList=MandatoryChildList)
	 */
	protected void sequence_TwoChildLists(ISerializationContext context, TwoChildLists semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns TwoChilds
	 *     TwoChilds returns TwoChilds
	 *
	 * Constraint:
	 *     (directChild=MandatoryValue? optChild=OptionalChild)
	 */
	protected void sequence_TwoChilds(ISerializationContext context, TwoChilds semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns WithTransientContainer
	 *     WithTransientContainer returns WithTransientContainer
	 *
	 * Constraint:
	 *     child=WithTransient
	 */
	protected void sequence_WithTransientContainer(ISerializationContext context, WithTransientContainer semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PartialSerializationTestLanguagePackage.Literals.WITH_TRANSIENT_CONTAINER__CHILD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialSerializationTestLanguagePackage.Literals.WITH_TRANSIENT_CONTAINER__CHILD));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getWithTransientContainerAccess().getChildWithTransientParserRuleCall_0(), semanticObject.getChild());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     WithTransient returns WithTransient
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_WithTransient(ISerializationContext context, WithTransient semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, WithtransientPackage.Literals.WITH_TRANSIENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WithtransientPackage.Literals.WITH_TRANSIENT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getWithTransientAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
}
