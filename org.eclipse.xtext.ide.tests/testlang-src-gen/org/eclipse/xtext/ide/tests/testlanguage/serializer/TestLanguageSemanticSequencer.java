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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Model;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.OperationCall;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PackageDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TestLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case TestLanguagePackage.OPERATION:
				sequence_Operation(context, (Operation) semanticObject); 
				return; 
			case TestLanguagePackage.OPERATION_CALL:
				sequence_OperationCall(context, (OperationCall) semanticObject); 
				return; 
			case TestLanguagePackage.PACKAGE_DECLARATION:
				sequence_PackageDeclaration(context, (PackageDeclaration) semanticObject); 
				return; 
			case TestLanguagePackage.PARAMETER:
				sequence_Parameter(context, (org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter) semanticObject); 
				return; 
			case TestLanguagePackage.PRIMITIVE_TYPE:
				if (rule == grammarAccess.getPrimitiveTypeRule()) {
					sequence_PrimitiveType(context, (PrimitiveType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeRule()) {
					sequence_PrimitiveType_Type(context, (PrimitiveType) semanticObject); 
					return; 
				}
				else break;
			case TestLanguagePackage.PROPERTY:
				sequence_Property(context, (Property) semanticObject); 
				return; 
			case TestLanguagePackage.TYPE_DECLARATION:
				sequence_TypeDeclaration(context, (TypeDeclaration) semanticObject); 
				return; 
			case TestLanguagePackage.TYPE_REFERENCE:
				if (rule == grammarAccess.getTypeReferenceRule()) {
					sequence_TypeReference(context, (TypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeRule()) {
					sequence_Type_TypeReference(context, (TypeReference) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     elements+=AbstractElement+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OperationCall returns OperationCall
	 *
	 * Constraint:
	 *     (operation=[Operation|ID] (params+=INT params+=INT*)?)
	 */
	protected void sequence_OperationCall(ISerializationContext context, OperationCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Member returns Operation
	 *     Operation returns Operation
	 *
	 * Constraint:
	 *     (name=ID (params+=Parameter params+=Parameter*)? returnType=Type? operationCall=OperationCall?)
	 */
	protected void sequence_Operation(ISerializationContext context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PackageDeclaration returns PackageDeclaration
	 *     AbstractElement returns PackageDeclaration
	 *
	 * Constraint:
	 *     (name=QualifiedName elements+=AbstractElement*)
	 */
	protected void sequence_PackageDeclaration(ISerializationContext context, PackageDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns Parameter
	 *
	 * Constraint:
	 *     (name=ID type=Type)
	 */
	protected void sequence_Parameter(ISerializationContext context, org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TestLanguagePackage.Literals.PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TestLanguagePackage.Literals.PARAMETER__NAME));
			if (transientValues.isValueTransient(semanticObject, TestLanguagePackage.Literals.PARAMETER__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TestLanguagePackage.Literals.PARAMETER__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_3_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PrimitiveType returns PrimitiveType
	 *
	 * Constraint:
	 *     (name='string' | name='int' | name='boolean' | name='void')
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns PrimitiveType
	 *
	 * Constraint:
	 *     ((name='string' | name='int' | name='boolean' | name='void') arrayDiemensions+='['*)
	 */
	protected void sequence_PrimitiveType_Type(ISerializationContext context, PrimitiveType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Member returns Property
	 *     Property returns Property
	 *
	 * Constraint:
	 *     (type=Type name=ID)
	 */
	protected void sequence_Property(ISerializationContext context, Property semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TestLanguagePackage.Literals.PROPERTY__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TestLanguagePackage.Literals.PROPERTY__TYPE));
			if (transientValues.isValueTransient(semanticObject, TestLanguagePackage.Literals.MEMBER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TestLanguagePackage.Literals.MEMBER__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AbstractElement returns TypeDeclaration
	 *     TypeDeclaration returns TypeDeclaration
	 *
	 * Constraint:
	 *     (name=ID superType=[TypeDeclaration|QualifiedName]? members+=Member*)
	 */
	protected void sequence_TypeDeclaration(ISerializationContext context, TypeDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeReference returns TypeReference
	 *
	 * Constraint:
	 *     typeRef=[TypeDeclaration|QualifiedName]
	 */
	protected void sequence_TypeReference(ISerializationContext context, TypeReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TestLanguagePackage.Literals.TYPE_REFERENCE__TYPE_REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TestLanguagePackage.Literals.TYPE_REFERENCE__TYPE_REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationQualifiedNameParserRuleCall_0_1(), semanticObject.eGet(TestLanguagePackage.Literals.TYPE_REFERENCE__TYPE_REF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Type returns TypeReference
	 *
	 * Constraint:
	 *     (typeRef=[TypeDeclaration|QualifiedName] arrayDiemensions+='['*)
	 */
	protected void sequence_Type_TypeReference(ISerializationContext context, TypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
