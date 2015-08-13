package org.eclipse.xtext.resource.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.resource.idea.lang.psi.impl.LocationProviderTestLanguageFileImpl;
import org.eclipse.xtext.resource.services.LocationProviderTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class LocationProviderTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<LocationProviderTestLanguageFileImpl>>(LocationProviderTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final LocationProviderTestLanguageGrammarAccess GRAMMAR_ACCESS = LocationProviderTestLanguageLanguage.INSTANCE.getInstance(LocationProviderTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ElementsAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsAssignment_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsAssignment_0());
		}
		public static IGrammarAwareElementType createModel_ElementsElementParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ElementsElementParserRuleCall_0_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getElementsElementParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_ComponentsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_ComponentsAssignment_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getComponentsAssignment_1());
		}
		public static IGrammarAwareElementType createModel_ComponentsComponentParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ComponentsComponentParserRuleCall_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getComponentsComponentParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ElementsAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_ElementsElementParserRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ElementsElementParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_ComponentsAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ComponentsAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_ComponentsComponentParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ComponentsComponentParserRuleCall_1_0ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("Element_ElementKeyword_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createElement_Group_2ElementType() {
			return new IGrammarAwareElementType("Element_Group_2_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createElement_SinglerefKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Element_SinglerefKeyword_2_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getSinglerefKeyword_2_0());
		}
		public static IGrammarAwareElementType createElement_SinglerefAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Element_SinglerefAssignment_2_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getSinglerefAssignment_2_1());
		}
		public static IGrammarAwareElementType createElement_SinglerefElementCrossReference_2_1_0ElementType() {
			return new IGrammarAwareElementType("Element_SinglerefElementCrossReference_2_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getSinglerefElementCrossReference_2_1_0());
		}
		public static IGrammarAwareElementType createElement_SinglerefElementIDTerminalRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("Element_SinglerefElementIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getSinglerefElementIDTerminalRuleCall_2_1_0_1());
		}
		public static IGrammarAwareElementType createElement_Group_3ElementType() {
			return new IGrammarAwareElementType("Element_Group_3_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createElement_MultirefKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Element_MultirefKeyword_3_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getMultirefKeyword_3_0());
		}
		public static IGrammarAwareElementType createElement_MultirefsAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Element_MultirefsAssignment_3_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getMultirefsAssignment_3_1());
		}
		public static IGrammarAwareElementType createElement_MultirefsElementCrossReference_3_1_0ElementType() {
			return new IGrammarAwareElementType("Element_MultirefsElementCrossReference_3_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getMultirefsElementCrossReference_3_1_0());
		}
		public static IGrammarAwareElementType createElement_MultirefsElementIDTerminalRuleCall_3_1_0_1ElementType() {
			return new IGrammarAwareElementType("Element_MultirefsElementIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getMultirefsElementIDTerminalRuleCall_3_1_0_1());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_ElementKeyword_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Element_Group_2_ELEMENT_TYPE = associate(ElementFactory.createElement_Group_2ElementType());

	public static final IGrammarAwareElementType Element_SinglerefKeyword_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_SinglerefKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Element_SinglerefAssignment_2_1_ELEMENT_TYPE = associate(ElementFactory.createElement_SinglerefAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Element_SinglerefElementCrossReference_2_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_SinglerefElementCrossReference_2_1_0ElementType());

	public static final IGrammarAwareElementType Element_SinglerefElementIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE = associate(ElementFactory.createElement_SinglerefElementIDTerminalRuleCall_2_1_0_1ElementType());

	public static final IGrammarAwareElementType Element_Group_3_ELEMENT_TYPE = associate(ElementFactory.createElement_Group_3ElementType());

	public static final IGrammarAwareElementType Element_MultirefKeyword_3_0_ELEMENT_TYPE = associate(ElementFactory.createElement_MultirefKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Element_MultirefsAssignment_3_1_ELEMENT_TYPE = associate(ElementFactory.createElement_MultirefsAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Element_MultirefsElementCrossReference_3_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_MultirefsElementCrossReference_3_1_0ElementType());

	public static final IGrammarAwareElementType Element_MultirefsElementIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE = associate(ElementFactory.createElement_MultirefsElementIDTerminalRuleCall_3_1_0_1ElementType());

	private static class ComponentFactory {
		public static IGrammarAwareElementType createComponentElementType() {
			return new IGrammarAwareElementType("Component_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentRule());
		}
		public static IGrammarAwareElementType createComponent_GroupElementType() {
			return new IGrammarAwareElementType("Component_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getGroup());
		}
		public static IGrammarAwareElementType createComponent_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("Component_Alternatives_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createComponent_BusParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Component_BusParserRuleCall_0_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getBusParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createComponent_ProcessorParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("Component_ProcessorParserRuleCall_0_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getProcessorParserRuleCall_0_1());
		}
		public static IGrammarAwareElementType createComponent_Group_1ElementType() {
			return new IGrammarAwareElementType("Component_Group_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createComponent_ModesKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Component_ModesKeyword_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getModesKeyword_1_0());
		}
		public static IGrammarAwareElementType createComponent_Alternatives_1_1ElementType() {
			return new IGrammarAwareElementType("Component_Alternatives_1_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getAlternatives_1_1());
		}
		public static IGrammarAwareElementType createComponent_ModeAssignment_1_1_0ElementType() {
			return new IGrammarAwareElementType("Component_ModeAssignment_1_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getModeAssignment_1_1_0());
		}
		public static IGrammarAwareElementType createComponent_ModeModeParserRuleCall_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Component_ModeModeParserRuleCall_1_1_0_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getModeModeParserRuleCall_1_1_0_0());
		}
		public static IGrammarAwareElementType createComponent_TransitionAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("Component_TransitionAssignment_1_1_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getTransitionAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createComponent_TransitionTransitionParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Component_TransitionTransitionParserRuleCall_1_1_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getTransitionTransitionParserRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createComponent_EndKeyword_2ElementType() {
			return new IGrammarAwareElementType("Component_EndKeyword_2_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getEndKeyword_2());
		}
		public static IGrammarAwareElementType createComponent_SemicolonKeyword_3ElementType() {
			return new IGrammarAwareElementType("Component_SemicolonKeyword_3_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getComponentAccess().getSemicolonKeyword_3());
		}
	}

	public static final IGrammarAwareElementType Component_ELEMENT_TYPE = associate(ComponentFactory.createComponentElementType());

	public static final IGrammarAwareElementType Component_Group_ELEMENT_TYPE = associate(ComponentFactory.createComponent_GroupElementType());

	public static final IGrammarAwareElementType Component_Alternatives_0_ELEMENT_TYPE = associate(ComponentFactory.createComponent_Alternatives_0ElementType());

	public static final IGrammarAwareElementType Component_BusParserRuleCall_0_0_ELEMENT_TYPE = associate(ComponentFactory.createComponent_BusParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Component_ProcessorParserRuleCall_0_1_ELEMENT_TYPE = associate(ComponentFactory.createComponent_ProcessorParserRuleCall_0_1ElementType());

	public static final IGrammarAwareElementType Component_Group_1_ELEMENT_TYPE = associate(ComponentFactory.createComponent_Group_1ElementType());

	public static final IGrammarAwareElementType Component_ModesKeyword_1_0_ELEMENT_TYPE = associate(ComponentFactory.createComponent_ModesKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Component_Alternatives_1_1_ELEMENT_TYPE = associate(ComponentFactory.createComponent_Alternatives_1_1ElementType());

	public static final IGrammarAwareElementType Component_ModeAssignment_1_1_0_ELEMENT_TYPE = associate(ComponentFactory.createComponent_ModeAssignment_1_1_0ElementType());

	public static final IGrammarAwareElementType Component_ModeModeParserRuleCall_1_1_0_0_ELEMENT_TYPE = associate(ComponentFactory.createComponent_ModeModeParserRuleCall_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Component_TransitionAssignment_1_1_1_ELEMENT_TYPE = associate(ComponentFactory.createComponent_TransitionAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType Component_TransitionTransitionParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(ComponentFactory.createComponent_TransitionTransitionParserRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType Component_EndKeyword_2_ELEMENT_TYPE = associate(ComponentFactory.createComponent_EndKeyword_2ElementType());

	public static final IGrammarAwareElementType Component_SemicolonKeyword_3_ELEMENT_TYPE = associate(ComponentFactory.createComponent_SemicolonKeyword_3ElementType());

	private static class BusFactory {
		public static IGrammarAwareElementType createBusElementType() {
			return new IGrammarAwareElementType("Bus_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBusRule());
		}
		public static IGrammarAwareElementType createBus_GroupElementType() {
			return new IGrammarAwareElementType("Bus_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBusAccess().getGroup());
		}
		public static IGrammarAwareElementType createBus_BusKeyword_0ElementType() {
			return new IGrammarAwareElementType("Bus_BusKeyword_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBusAccess().getBusKeyword_0());
		}
		public static IGrammarAwareElementType createBus_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Bus_NameAssignment_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBusAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createBus_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Bus_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBusAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createBus_PortAssignment_2ElementType() {
			return new IGrammarAwareElementType("Bus_PortAssignment_2_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBusAccess().getPortAssignment_2());
		}
		public static IGrammarAwareElementType createBus_PortPortParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Bus_PortPortParserRuleCall_2_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBusAccess().getPortPortParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Bus_ELEMENT_TYPE = associate(BusFactory.createBusElementType());

	public static final IGrammarAwareElementType Bus_Group_ELEMENT_TYPE = associate(BusFactory.createBus_GroupElementType());

	public static final IGrammarAwareElementType Bus_BusKeyword_0_ELEMENT_TYPE = associate(BusFactory.createBus_BusKeyword_0ElementType());

	public static final IGrammarAwareElementType Bus_NameAssignment_1_ELEMENT_TYPE = associate(BusFactory.createBus_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Bus_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(BusFactory.createBus_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Bus_PortAssignment_2_ELEMENT_TYPE = associate(BusFactory.createBus_PortAssignment_2ElementType());

	public static final IGrammarAwareElementType Bus_PortPortParserRuleCall_2_0_ELEMENT_TYPE = associate(BusFactory.createBus_PortPortParserRuleCall_2_0ElementType());

	private static class ProcessorFactory {
		public static IGrammarAwareElementType createProcessorElementType() {
			return new IGrammarAwareElementType("Processor_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getProcessorRule());
		}
		public static IGrammarAwareElementType createProcessor_GroupElementType() {
			return new IGrammarAwareElementType("Processor_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getProcessorAccess().getGroup());
		}
		public static IGrammarAwareElementType createProcessor_ProcessorKeyword_0ElementType() {
			return new IGrammarAwareElementType("Processor_ProcessorKeyword_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getProcessorAccess().getProcessorKeyword_0());
		}
		public static IGrammarAwareElementType createProcessor_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Processor_NameAssignment_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getProcessorAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createProcessor_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Processor_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getProcessorAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createProcessor_DataAssignment_2ElementType() {
			return new IGrammarAwareElementType("Processor_DataAssignment_2_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getProcessorAccess().getDataAssignment_2());
		}
		public static IGrammarAwareElementType createProcessor_DataDataParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Processor_DataDataParserRuleCall_2_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getProcessorAccess().getDataDataParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Processor_ELEMENT_TYPE = associate(ProcessorFactory.createProcessorElementType());

	public static final IGrammarAwareElementType Processor_Group_ELEMENT_TYPE = associate(ProcessorFactory.createProcessor_GroupElementType());

	public static final IGrammarAwareElementType Processor_ProcessorKeyword_0_ELEMENT_TYPE = associate(ProcessorFactory.createProcessor_ProcessorKeyword_0ElementType());

	public static final IGrammarAwareElementType Processor_NameAssignment_1_ELEMENT_TYPE = associate(ProcessorFactory.createProcessor_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Processor_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ProcessorFactory.createProcessor_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Processor_DataAssignment_2_ELEMENT_TYPE = associate(ProcessorFactory.createProcessor_DataAssignment_2ElementType());

	public static final IGrammarAwareElementType Processor_DataDataParserRuleCall_2_0_ELEMENT_TYPE = associate(ProcessorFactory.createProcessor_DataDataParserRuleCall_2_0ElementType());

	private static class ModeFactory {
		public static IGrammarAwareElementType createModeElementType() {
			return new IGrammarAwareElementType("Mode_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModeRule());
		}
		public static IGrammarAwareElementType createMode_GroupElementType() {
			return new IGrammarAwareElementType("Mode_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModeAccess().getGroup());
		}
		public static IGrammarAwareElementType createMode_ModeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Mode_ModeKeyword_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModeAccess().getModeKeyword_0());
		}
		public static IGrammarAwareElementType createMode_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Mode_NameAssignment_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModeAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createMode_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Mode_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModeAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createMode_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("Mode_SemicolonKeyword_2_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModeAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Mode_ELEMENT_TYPE = associate(ModeFactory.createModeElementType());

	public static final IGrammarAwareElementType Mode_Group_ELEMENT_TYPE = associate(ModeFactory.createMode_GroupElementType());

	public static final IGrammarAwareElementType Mode_ModeKeyword_0_ELEMENT_TYPE = associate(ModeFactory.createMode_ModeKeyword_0ElementType());

	public static final IGrammarAwareElementType Mode_NameAssignment_1_ELEMENT_TYPE = associate(ModeFactory.createMode_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Mode_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ModeFactory.createMode_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Mode_SemicolonKeyword_2_ELEMENT_TYPE = associate(ModeFactory.createMode_SemicolonKeyword_2ElementType());

	private static class TransitionFactory {
		public static IGrammarAwareElementType createTransitionElementType() {
			return new IGrammarAwareElementType("Transition_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionRule());
		}
		public static IGrammarAwareElementType createTransition_GroupElementType() {
			return new IGrammarAwareElementType("Transition_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getGroup());
		}
		public static IGrammarAwareElementType createTransition_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Transition_NameAssignment_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createTransition_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Transition_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createTransition_ColonKeyword_1ElementType() {
			return new IGrammarAwareElementType("Transition_ColonKeyword_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getColonKeyword_1());
		}
		public static IGrammarAwareElementType createTransition_SourceAssignment_2ElementType() {
			return new IGrammarAwareElementType("Transition_SourceAssignment_2_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getSourceAssignment_2());
		}
		public static IGrammarAwareElementType createTransition_SourceModeCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("Transition_SourceModeCrossReference_2_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getSourceModeCrossReference_2_0());
		}
		public static IGrammarAwareElementType createTransition_SourceModeIDTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Transition_SourceModeIDTerminalRuleCall_2_0_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getSourceModeIDTerminalRuleCall_2_0_1());
		}
		public static IGrammarAwareElementType createTransition_HyphenMinusGreaterThanSignKeyword_3ElementType() {
			return new IGrammarAwareElementType("Transition_HyphenMinusGreaterThanSignKeyword_3_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_3());
		}
		public static IGrammarAwareElementType createTransition_DestinationAssignment_4ElementType() {
			return new IGrammarAwareElementType("Transition_DestinationAssignment_4_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getDestinationAssignment_4());
		}
		public static IGrammarAwareElementType createTransition_DestinationModeCrossReference_4_0ElementType() {
			return new IGrammarAwareElementType("Transition_DestinationModeCrossReference_4_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getDestinationModeCrossReference_4_0());
		}
		public static IGrammarAwareElementType createTransition_DestinationModeIDTerminalRuleCall_4_0_1ElementType() {
			return new IGrammarAwareElementType("Transition_DestinationModeIDTerminalRuleCall_4_0_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getDestinationModeIDTerminalRuleCall_4_0_1());
		}
		public static IGrammarAwareElementType createTransition_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("Transition_SemicolonKeyword_5_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getSemicolonKeyword_5());
		}
	}

	public static final IGrammarAwareElementType Transition_ELEMENT_TYPE = associate(TransitionFactory.createTransitionElementType());

	public static final IGrammarAwareElementType Transition_Group_ELEMENT_TYPE = associate(TransitionFactory.createTransition_GroupElementType());

	public static final IGrammarAwareElementType Transition_NameAssignment_0_ELEMENT_TYPE = associate(TransitionFactory.createTransition_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Transition_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(TransitionFactory.createTransition_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Transition_ColonKeyword_1_ELEMENT_TYPE = associate(TransitionFactory.createTransition_ColonKeyword_1ElementType());

	public static final IGrammarAwareElementType Transition_SourceAssignment_2_ELEMENT_TYPE = associate(TransitionFactory.createTransition_SourceAssignment_2ElementType());

	public static final IGrammarAwareElementType Transition_SourceModeCrossReference_2_0_ELEMENT_TYPE = associate(TransitionFactory.createTransition_SourceModeCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType Transition_SourceModeIDTerminalRuleCall_2_0_1_ELEMENT_TYPE = associate(TransitionFactory.createTransition_SourceModeIDTerminalRuleCall_2_0_1ElementType());

	public static final IGrammarAwareElementType Transition_HyphenMinusGreaterThanSignKeyword_3_ELEMENT_TYPE = associate(TransitionFactory.createTransition_HyphenMinusGreaterThanSignKeyword_3ElementType());

	public static final IGrammarAwareElementType Transition_DestinationAssignment_4_ELEMENT_TYPE = associate(TransitionFactory.createTransition_DestinationAssignment_4ElementType());

	public static final IGrammarAwareElementType Transition_DestinationModeCrossReference_4_0_ELEMENT_TYPE = associate(TransitionFactory.createTransition_DestinationModeCrossReference_4_0ElementType());

	public static final IGrammarAwareElementType Transition_DestinationModeIDTerminalRuleCall_4_0_1_ELEMENT_TYPE = associate(TransitionFactory.createTransition_DestinationModeIDTerminalRuleCall_4_0_1ElementType());

	public static final IGrammarAwareElementType Transition_SemicolonKeyword_5_ELEMENT_TYPE = associate(TransitionFactory.createTransition_SemicolonKeyword_5ElementType());

	private static class PortFactory {
		public static IGrammarAwareElementType createPortElementType() {
			return new IGrammarAwareElementType("Port_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPortRule());
		}
		public static IGrammarAwareElementType createPort_GroupElementType() {
			return new IGrammarAwareElementType("Port_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPortAccess().getGroup());
		}
		public static IGrammarAwareElementType createPort_PortKeyword_0ElementType() {
			return new IGrammarAwareElementType("Port_PortKeyword_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPortAccess().getPortKeyword_0());
		}
		public static IGrammarAwareElementType createPort_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Port_NameAssignment_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPortAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createPort_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Port_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPortAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createPort_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("Port_SemicolonKeyword_2_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPortAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Port_ELEMENT_TYPE = associate(PortFactory.createPortElementType());

	public static final IGrammarAwareElementType Port_Group_ELEMENT_TYPE = associate(PortFactory.createPort_GroupElementType());

	public static final IGrammarAwareElementType Port_PortKeyword_0_ELEMENT_TYPE = associate(PortFactory.createPort_PortKeyword_0ElementType());

	public static final IGrammarAwareElementType Port_NameAssignment_1_ELEMENT_TYPE = associate(PortFactory.createPort_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Port_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(PortFactory.createPort_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Port_SemicolonKeyword_2_ELEMENT_TYPE = associate(PortFactory.createPort_SemicolonKeyword_2ElementType());

	private static class DataFactory {
		public static IGrammarAwareElementType createDataElementType() {
			return new IGrammarAwareElementType("Data_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataRule());
		}
		public static IGrammarAwareElementType createData_GroupElementType() {
			return new IGrammarAwareElementType("Data_Group_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataAccess().getGroup());
		}
		public static IGrammarAwareElementType createData_DataKeyword_0ElementType() {
			return new IGrammarAwareElementType("Data_DataKeyword_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataAccess().getDataKeyword_0());
		}
		public static IGrammarAwareElementType createData_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Data_NameAssignment_1_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createData_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Data_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createData_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("Data_SemicolonKeyword_2_ELEMENT_TYPE", LocationProviderTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Data_ELEMENT_TYPE = associate(DataFactory.createDataElementType());

	public static final IGrammarAwareElementType Data_Group_ELEMENT_TYPE = associate(DataFactory.createData_GroupElementType());

	public static final IGrammarAwareElementType Data_DataKeyword_0_ELEMENT_TYPE = associate(DataFactory.createData_DataKeyword_0ElementType());

	public static final IGrammarAwareElementType Data_NameAssignment_1_ELEMENT_TYPE = associate(DataFactory.createData_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Data_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(DataFactory.createData_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Data_SemicolonKeyword_2_ELEMENT_TYPE = associate(DataFactory.createData_SemicolonKeyword_2ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getModelElementType() {
		return Model_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GroupElementType() {
		return Model_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ElementsAssignment_0ElementType() {
		return Model_ElementsAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ElementsElementParserRuleCall_0_0ElementType() {
		return Model_ElementsElementParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ComponentsAssignment_1ElementType() {
		return Model_ComponentsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ComponentsComponentParserRuleCall_1_0ElementType() {
		return Model_ComponentsComponentParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElementElementType() {
		return Element_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_GroupElementType() {
		return Element_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ElementKeyword_0ElementType() {
		return Element_ElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameAssignment_1ElementType() {
		return Element_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameIDTerminalRuleCall_1_0ElementType() {
		return Element_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_Group_2ElementType() {
		return Element_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_SinglerefKeyword_2_0ElementType() {
		return Element_SinglerefKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_SinglerefAssignment_2_1ElementType() {
		return Element_SinglerefAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_SinglerefElementCrossReference_2_1_0ElementType() {
		return Element_SinglerefElementCrossReference_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_SinglerefElementIDTerminalRuleCall_2_1_0_1ElementType() {
		return Element_SinglerefElementIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_Group_3ElementType() {
		return Element_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_MultirefKeyword_3_0ElementType() {
		return Element_MultirefKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_MultirefsAssignment_3_1ElementType() {
		return Element_MultirefsAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_MultirefsElementCrossReference_3_1_0ElementType() {
		return Element_MultirefsElementCrossReference_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_MultirefsElementIDTerminalRuleCall_3_1_0_1ElementType() {
		return Element_MultirefsElementIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponentElementType() {
		return Component_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_GroupElementType() {
		return Component_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_Alternatives_0ElementType() {
		return Component_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_BusParserRuleCall_0_0ElementType() {
		return Component_BusParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_ProcessorParserRuleCall_0_1ElementType() {
		return Component_ProcessorParserRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_Group_1ElementType() {
		return Component_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_ModesKeyword_1_0ElementType() {
		return Component_ModesKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_Alternatives_1_1ElementType() {
		return Component_Alternatives_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_ModeAssignment_1_1_0ElementType() {
		return Component_ModeAssignment_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_ModeModeParserRuleCall_1_1_0_0ElementType() {
		return Component_ModeModeParserRuleCall_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_TransitionAssignment_1_1_1ElementType() {
		return Component_TransitionAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_TransitionTransitionParserRuleCall_1_1_1_0ElementType() {
		return Component_TransitionTransitionParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_EndKeyword_2ElementType() {
		return Component_EndKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getComponent_SemicolonKeyword_3ElementType() {
		return Component_SemicolonKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBusElementType() {
		return Bus_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBus_GroupElementType() {
		return Bus_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBus_BusKeyword_0ElementType() {
		return Bus_BusKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBus_NameAssignment_1ElementType() {
		return Bus_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBus_NameIDTerminalRuleCall_1_0ElementType() {
		return Bus_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBus_PortAssignment_2ElementType() {
		return Bus_PortAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBus_PortPortParserRuleCall_2_0ElementType() {
		return Bus_PortPortParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProcessorElementType() {
		return Processor_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProcessor_GroupElementType() {
		return Processor_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProcessor_ProcessorKeyword_0ElementType() {
		return Processor_ProcessorKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProcessor_NameAssignment_1ElementType() {
		return Processor_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProcessor_NameIDTerminalRuleCall_1_0ElementType() {
		return Processor_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProcessor_DataAssignment_2ElementType() {
		return Processor_DataAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProcessor_DataDataParserRuleCall_2_0ElementType() {
		return Processor_DataDataParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModeElementType() {
		return Mode_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMode_GroupElementType() {
		return Mode_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMode_ModeKeyword_0ElementType() {
		return Mode_ModeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMode_NameAssignment_1ElementType() {
		return Mode_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMode_NameIDTerminalRuleCall_1_0ElementType() {
		return Mode_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMode_SemicolonKeyword_2ElementType() {
		return Mode_SemicolonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransitionElementType() {
		return Transition_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_GroupElementType() {
		return Transition_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_NameAssignment_0ElementType() {
		return Transition_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_NameIDTerminalRuleCall_0_0ElementType() {
		return Transition_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_ColonKeyword_1ElementType() {
		return Transition_ColonKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_SourceAssignment_2ElementType() {
		return Transition_SourceAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_SourceModeCrossReference_2_0ElementType() {
		return Transition_SourceModeCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_SourceModeIDTerminalRuleCall_2_0_1ElementType() {
		return Transition_SourceModeIDTerminalRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_HyphenMinusGreaterThanSignKeyword_3ElementType() {
		return Transition_HyphenMinusGreaterThanSignKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_DestinationAssignment_4ElementType() {
		return Transition_DestinationAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_DestinationModeCrossReference_4_0ElementType() {
		return Transition_DestinationModeCrossReference_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_DestinationModeIDTerminalRuleCall_4_0_1ElementType() {
		return Transition_DestinationModeIDTerminalRuleCall_4_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_SemicolonKeyword_5ElementType() {
		return Transition_SemicolonKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPortElementType() {
		return Port_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPort_GroupElementType() {
		return Port_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPort_PortKeyword_0ElementType() {
		return Port_PortKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPort_NameAssignment_1ElementType() {
		return Port_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPort_NameIDTerminalRuleCall_1_0ElementType() {
		return Port_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPort_SemicolonKeyword_2ElementType() {
		return Port_SemicolonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataElementType() {
		return Data_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getData_GroupElementType() {
		return Data_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getData_DataKeyword_0ElementType() {
		return Data_DataKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getData_NameAssignment_1ElementType() {
		return Data_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getData_NameIDTerminalRuleCall_1_0ElementType() {
		return Data_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getData_SemicolonKeyword_2ElementType() {
		return Data_SemicolonKeyword_2_ELEMENT_TYPE;
	}

}
