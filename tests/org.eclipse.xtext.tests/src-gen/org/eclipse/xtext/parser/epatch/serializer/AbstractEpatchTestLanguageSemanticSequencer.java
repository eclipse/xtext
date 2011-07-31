package org.eclipse.xtext.parser.epatch.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExtensionImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaExecutable;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractEpatchTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected EpatchTestLanguageGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == EpatchTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EpatchTestLanguagePackage.ASSIGNMENT_VALUE:
				if(context == grammarAccess.getAssignmentValueRule()) {
					sequence_AssignmentValue(context, (AssignmentValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getListAssignmentValueRule()) {
					sequence_ListAssignmentValue(context, (AssignmentValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSingleAssignmentValueRule()) {
					sequence_SingleAssignmentValue(context, (AssignmentValue) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.EPACKAGE_IMPORT:
				if(context == grammarAccess.getEPackageImportRule() ||
				   context == grammarAccess.getImportRule() ||
				   context == grammarAccess.getModelImportRule()) {
					sequence_EPackageImport(context, (EPackageImport) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.EPATCH:
				if(context == grammarAccess.getEPatchRule()) {
					sequence_EPatch(context, (EPatch) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.EXPRESSION_EXECUTABLE:
				if(context == grammarAccess.getExecutableRule() ||
				   context == grammarAccess.getExpressionExecutableRule()) {
					sequence_ExpressionExecutable(context, (ExpressionExecutable) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.EXTENSION_IMPORT:
				if(context == grammarAccess.getExtensionImportRule() ||
				   context == grammarAccess.getImportRule()) {
					sequence_ExtensionImport(context, (ExtensionImport) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.JAVA_EXECUTABLE:
				if(context == grammarAccess.getExecutableRule() ||
				   context == grammarAccess.getJavaExecutableRule()) {
					sequence_JavaExecutable(context, (JavaExecutable) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.JAVA_IMPORT:
				if(context == grammarAccess.getImportRule() ||
				   context == grammarAccess.getJavaImportRule()) {
					sequence_JavaImport(context, (JavaImport) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.LIST_ASSIGNMENT:
				if(context == grammarAccess.getAssignmentRule()) {
					sequence_Assignment(context, (ListAssignment) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getBiListAssignmentRule()) {
					sequence_BiListAssignment(context, (ListAssignment) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMonoListAssignmentRule()) {
					sequence_MonoListAssignment(context, (ListAssignment) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.MIGRATION:
				if(context == grammarAccess.getMigrationRule()) {
					sequence_Migration(context, (Migration) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.NAMED_RESOURCE:
				if(context == grammarAccess.getNamedResourceRule()) {
					sequence_NamedResource(context, (NamedResource) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.OBJECT_COPY:
				if(context == grammarAccess.getCreatedObjectRule() ||
				   context == grammarAccess.getNamedObjectRule()) {
					sequence_CreatedObject(context, (ObjectCopy) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getObjectCopyRule()) {
					sequence_ObjectCopy(context, (ObjectCopy) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.OBJECT_NEW:
				if(context == grammarAccess.getCreatedObjectRule() ||
				   context == grammarAccess.getNamedObjectRule()) {
					sequence_CreatedObject(context, (ObjectNew) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getObjectNewRule()) {
					sequence_ObjectNew(context, (ObjectNew) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.OBJECT_REF:
				if(context == grammarAccess.getNamedObjectRule() ||
				   context == grammarAccess.getObjectRefRule()) {
					sequence_ObjectRef(context, (ObjectRef) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.RESOURCE_IMPORT:
				if(context == grammarAccess.getImportRule() ||
				   context == grammarAccess.getModelImportRule() ||
				   context == grammarAccess.getResourceImportRule()) {
					sequence_ResourceImport(context, (ResourceImport) semanticObject); 
					return; 
				}
				else break;
			case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT:
				if(context == grammarAccess.getAssignmentRule()) {
					sequence_Assignment(context, (SingleAssignment) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getBiSingleAssignmentRule()) {
					sequence_BiSingleAssignment(context, (SingleAssignment) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMonoSingleAssignmentRule()) {
					sequence_MonoSingleAssignment(context, (SingleAssignment) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (value=STRING | (refObject=[NamedObject|ID] (refFeature=ID refIndex=INT?)?) | newObject=CreatedObject | (import=[Import|ID] impFrag=FRAGMENT))
	 *
	 * Features:
	 *    value[0, 1]
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refObject[0, 1]
	 *         MANDATORY_IF_SET refFeature
	 *         MANDATORY_IF_SET refIndex
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refFeature[0, 1]
	 *         MANDATORY_IF_SET refIndex
	 *         EXCLUDE_IF_UNSET refObject
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refIndex[0, 1]
	 *         EXCLUDE_IF_UNSET refFeature
	 *         EXCLUDE_IF_UNSET refObject
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    newObject[0, 1]
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    import[0, 1]
	 *         EXCLUDE_IF_UNSET impFrag
	 *         MANDATORY_IF_SET impFrag
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *    impFrag[0, 1]
	 *         EXCLUDE_IF_UNSET import
	 *         MANDATORY_IF_SET import
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 */
	protected void sequence_AssignmentValue(EObject context, AssignmentValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             feature=ID 
	 *             (leftValues+=ListAssignmentValue leftValues+=ListAssignmentValue*)? 
	 *             (rightValues+=ListAssignmentValue rightValues+=ListAssignmentValue*)?
	 *         ) | 
	 *         (feature=ID (leftValues+=AssignmentValue leftValues+=AssignmentValue*)?)
	 *     )
	 *
	 * Features:
	 *    feature[0, 2]
	 *    leftValues[0, *]
	 *    rightValues[0, *]
	 *         EXCLUDE_IF_UNSET feature
	 *         EXCLUDE_IF_SET feature
	 *         EXCLUDE_IF_SET leftValues
	 *         EXCLUDE_IF_SET leftValues
	 */
	protected void sequence_Assignment(EObject context, ListAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((feature=ID leftValue=SingleAssignmentValue rightValue=SingleAssignmentValue) | (feature=ID leftValue=SingleAssignmentValue))
	 *
	 * Features:
	 *    feature[0, 2]
	 *    leftValue[0, 2]
	 *    rightValue[0, 1]
	 *         EXCLUDE_IF_UNSET feature
	 *         MANDATORY_IF_SET feature
	 *         EXCLUDE_IF_UNSET leftValue
	 *         MANDATORY_IF_SET leftValue
	 *         EXCLUDE_IF_SET feature
	 *         EXCLUDE_IF_SET leftValue
	 */
	protected void sequence_Assignment(EObject context, SingleAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         feature=ID 
	 *         (leftValues+=ListAssignmentValue leftValues+=ListAssignmentValue*)? 
	 *         (rightValues+=ListAssignmentValue rightValues+=ListAssignmentValue*)?
	 *     )
	 *
	 * Features:
	 *    feature[1, 1]
	 *    leftValues[0, *]
	 *    rightValues[0, *]
	 */
	protected void sequence_BiListAssignment(EObject context, ListAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (feature=ID leftValue=SingleAssignmentValue rightValue=SingleAssignmentValue)
	 *
	 * Features:
	 *    feature[1, 1]
	 *    leftValue[1, 1]
	 *    rightValue[1, 1]
	 */
	protected void sequence_BiSingleAssignment(EObject context, SingleAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.ASSIGNMENT__FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.ASSIGNMENT__FEATURE));
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.SINGLE_ASSIGNMENT__LEFT_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.SINGLE_ASSIGNMENT__LEFT_VALUE));
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.SINGLE_ASSIGNMENT__RIGHT_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.SINGLE_ASSIGNMENT__RIGHT_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBiSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), semanticObject.getFeature());
		feeder.accept(grammarAccess.getBiSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0(), semanticObject.getLeftValue());
		feeder.accept(grammarAccess.getBiSingleAssignmentAccess().getRightValueSingleAssignmentValueParserRuleCall_4_0(), semanticObject.getRightValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         resource=[NamedResource|ID] 
	 *         fragment=FRAGMENT 
	 *         name=ID? 
	 *         ((assignments+=MonoSingleAssignment | assignments+=MonoListAssignment)+ leftMig=Migration?)?
	 *     )
	 *
	 * Features:
	 *    name[0, 1]
	 *    assignments[0, *]
	 *    leftMig[0, 1]
	 *    resource[1, 1]
	 *    fragment[1, 1]
	 */
	protected void sequence_CreatedObject(EObject context, ObjectCopy semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (import=[Import|ID] impFrag=FRAGMENT name=ID? ((assignments+=MonoSingleAssignment | assignments+=MonoListAssignment)+ leftMig=Migration?)?)
	 *
	 * Features:
	 *    name[0, 1]
	 *    assignments[0, *]
	 *    leftMig[0, 1]
	 *    import[1, 1]
	 *    impFrag[1, 1]
	 */
	protected void sequence_CreatedObject(EObject context, ObjectNew semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID nsURI=STRING)
	 *
	 * Features:
	 *    name[1, 1]
	 *    nsURI[1, 1]
	 */
	protected void sequence_EPackageImport(EObject context, EPackageImport semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.MODEL_IMPORT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.MODEL_IMPORT__NAME));
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.EPACKAGE_IMPORT__NS_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.EPACKAGE_IMPORT__NS_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEPackageImportAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getEPackageImportAccess().getNsURISTRINGTerminalRuleCall_3_0(), semanticObject.getNsURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID imports+=Import* resources+=NamedResource* objects+=ObjectRef*)
	 *
	 * Features:
	 *    name[1, 1]
	 *    imports[0, *]
	 *    resources[0, *]
	 *    objects[0, *]
	 */
	protected void sequence_EPatch(EObject context, EPatch semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     exprstr=STRING
	 *
	 * Features:
	 *    exprstr[1, 1]
	 */
	protected void sequence_ExpressionExecutable(EObject context, ExpressionExecutable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.EXPRESSION_EXECUTABLE__EXPRSTR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.EXPRESSION_EXECUTABLE__EXPRSTR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionExecutableAccess().getExprstrSTRINGTerminalRuleCall_0(), semanticObject.getExprstr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (path+=ID path+=ID*)
	 *
	 * Features:
	 *    path[1, *]
	 */
	protected void sequence_ExtensionImport(EObject context, ExtensionImport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     method=ID
	 *
	 * Features:
	 *    method[1, 1]
	 */
	protected void sequence_JavaExecutable(EObject context, JavaExecutable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.JAVA_EXECUTABLE__METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.JAVA_EXECUTABLE__METHOD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJavaExecutableAccess().getMethodIDTerminalRuleCall_1_0(), semanticObject.getMethod());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (path+=ID path+=ID*)
	 *
	 * Features:
	 *    path[1, *]
	 */
	protected void sequence_JavaImport(EObject context, JavaImport semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         index=INT 
	 *         (
	 *             refIndex=INT | 
	 *             value=STRING | 
	 *             (refObject=[NamedObject|ID] (refFeature=ID refIndex=INT?)?) | 
	 *             newObject=CreatedObject | 
	 *             (import=[Import|ID] impFrag=FRAGMENT)
	 *         )
	 *     )
	 *
	 * Features:
	 *    value[0, 1]
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refObject[0, 1]
	 *         MANDATORY_IF_SET refFeature
	 *         MANDATORY_IF_SET refIndex
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refFeature[0, 1]
	 *         MANDATORY_IF_SET refIndex
	 *         EXCLUDE_IF_UNSET refObject
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refIndex[0, 2]
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    newObject[0, 1]
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    import[0, 1]
	 *         EXCLUDE_IF_UNSET impFrag
	 *         MANDATORY_IF_SET impFrag
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *    impFrag[0, 1]
	 *         EXCLUDE_IF_UNSET import
	 *         MANDATORY_IF_SET import
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *    index[1, 1]
	 */
	protected void sequence_ListAssignmentValue(EObject context, AssignmentValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (first=Executable? (asOp=Executable | eachOp=Executable)?)
	 *
	 * Features:
	 *    first[0, 1]
	 *    asOp[0, 1]
	 *         EXCLUDE_IF_SET eachOp
	 *    eachOp[0, 1]
	 *         EXCLUDE_IF_SET asOp
	 */
	protected void sequence_Migration(EObject context, Migration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (feature=ID (leftValues+=AssignmentValue leftValues+=AssignmentValue*)?)
	 *
	 * Features:
	 *    feature[1, 1]
	 *    leftValues[0, *]
	 */
	protected void sequence_MonoListAssignment(EObject context, ListAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (feature=ID leftValue=SingleAssignmentValue)
	 *
	 * Features:
	 *    feature[1, 1]
	 *    leftValue[1, 1]
	 */
	protected void sequence_MonoSingleAssignment(EObject context, SingleAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (leftUri=STRING | leftRoot=CreatedObject) (rightUri=STRING | rightRoot=CreatedObject))
	 *
	 * Features:
	 *    name[1, 1]
	 *    leftUri[0, 1]
	 *         EXCLUDE_IF_SET leftRoot
	 *    leftRoot[0, 1]
	 *         EXCLUDE_IF_SET leftUri
	 *    rightUri[0, 1]
	 *         EXCLUDE_IF_SET rightRoot
	 *    rightRoot[0, 1]
	 *         EXCLUDE_IF_SET rightUri
	 */
	protected void sequence_NamedResource(EObject context, NamedResource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (resource=[NamedResource|ID] fragment=FRAGMENT)
	 *
	 * Features:
	 *    resource[1, 1]
	 *    fragment[1, 1]
	 */
	protected void sequence_ObjectCopy(EObject context, ObjectCopy semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (import=[Import|ID] impFrag=FRAGMENT)
	 *
	 * Features:
	 *    import[1, 1]
	 *    impFrag[1, 1]
	 */
	protected void sequence_ObjectNew(EObject context, ObjectNew semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         ((leftRes=[NamedResource|ID] leftFrag=FRAGMENT) | (leftRes=[NamedResource|ID] leftFrag=FRAGMENT rightRes=[NamedResource|ID] rightFrag=FRAGMENT)) 
	 *         ((assignments+=BiSingleAssignment | assignments+=BiListAssignment)+ leftMig=Migration? rightMig=Migration?)?
	 *     )
	 *
	 * Features:
	 *    name[0, 1]
	 *    assignments[0, *]
	 *    leftMig[0, 1]
	 *    leftRes[0, 2]
	 *    leftFrag[0, 2]
	 *    rightRes[0, 1]
	 *         EXCLUDE_IF_UNSET leftRes
	 *         MANDATORY_IF_SET leftRes
	 *         EXCLUDE_IF_UNSET leftFrag
	 *         MANDATORY_IF_SET leftFrag
	 *         EXCLUDE_IF_UNSET rightFrag
	 *         MANDATORY_IF_SET rightFrag
	 *         EXCLUDE_IF_SET leftRes
	 *         EXCLUDE_IF_SET leftFrag
	 *    rightFrag[0, 1]
	 *         EXCLUDE_IF_UNSET leftRes
	 *         MANDATORY_IF_SET leftRes
	 *         EXCLUDE_IF_UNSET leftFrag
	 *         MANDATORY_IF_SET leftFrag
	 *         EXCLUDE_IF_UNSET rightRes
	 *         MANDATORY_IF_SET rightRes
	 *         EXCLUDE_IF_SET leftRes
	 *         EXCLUDE_IF_SET leftFrag
	 *    rightMig[0, 1]
	 */
	protected void sequence_ObjectRef(EObject context, ObjectRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID uri=STRING)
	 *
	 * Features:
	 *    name[1, 1]
	 *    uri[1, 1]
	 */
	protected void sequence_ResourceImport(EObject context, ResourceImport semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.MODEL_IMPORT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.MODEL_IMPORT__NAME));
			if(transientValues.isValueTransient(semanticObject, EpatchTestLanguagePackage.Literals.RESOURCE_IMPORT__URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EpatchTestLanguagePackage.Literals.RESOURCE_IMPORT__URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getResourceImportAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getResourceImportAccess().getUriSTRINGTerminalRuleCall_3_0(), semanticObject.getUri());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         keyword='null' | 
	 *         value=STRING | 
	 *         (refObject=[NamedObject|ID] (refFeature=ID refIndex=INT?)?) | 
	 *         newObject=CreatedObject | 
	 *         (import=[Import|ID] impFrag=FRAGMENT)
	 *     )
	 *
	 * Features:
	 *    value[0, 1]
	 *         EXCLUDE_IF_SET keyword
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refObject[0, 1]
	 *         MANDATORY_IF_SET refFeature
	 *         MANDATORY_IF_SET refIndex
	 *         EXCLUDE_IF_SET keyword
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refFeature[0, 1]
	 *         MANDATORY_IF_SET refIndex
	 *         EXCLUDE_IF_UNSET refObject
	 *         EXCLUDE_IF_SET keyword
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    refIndex[0, 1]
	 *         EXCLUDE_IF_UNSET refFeature
	 *         EXCLUDE_IF_UNSET refObject
	 *         EXCLUDE_IF_SET keyword
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    newObject[0, 1]
	 *         EXCLUDE_IF_SET keyword
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 *    import[0, 1]
	 *         EXCLUDE_IF_UNSET impFrag
	 *         MANDATORY_IF_SET impFrag
	 *         EXCLUDE_IF_SET keyword
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *    impFrag[0, 1]
	 *         EXCLUDE_IF_UNSET import
	 *         MANDATORY_IF_SET import
	 *         EXCLUDE_IF_SET keyword
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *    keyword[0, 1]
	 *         EXCLUDE_IF_SET value
	 *         EXCLUDE_IF_SET refObject
	 *         EXCLUDE_IF_SET refFeature
	 *         EXCLUDE_IF_SET refIndex
	 *         EXCLUDE_IF_SET newObject
	 *         EXCLUDE_IF_SET import
	 *         EXCLUDE_IF_SET impFrag
	 */
	protected void sequence_SingleAssignmentValue(EObject context, AssignmentValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
