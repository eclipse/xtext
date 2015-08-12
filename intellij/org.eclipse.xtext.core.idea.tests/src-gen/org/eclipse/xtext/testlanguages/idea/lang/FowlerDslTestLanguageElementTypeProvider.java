package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.FowlerDslTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class FowlerDslTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<FowlerDslTestLanguageFileImpl>>(FowlerDslTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final FowlerDslTestLanguageGrammarAccess GRAMMAR_ACCESS = FowlerDslTestLanguageLanguage.INSTANCE.getInstance(FowlerDslTestLanguageGrammarAccess.class);

	private static class StatemachineFactory {
		public static IGrammarAwareElementType createStatemachineElementType() {
			return new IGrammarAwareElementType("Statemachine_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineRule());
		}
		public static IGrammarAwareElementType createStatemachine_GroupElementType() {
			return new IGrammarAwareElementType("Statemachine_Group_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getGroup());
		}
		public static IGrammarAwareElementType createStatemachine_EventsKeyword_0ElementType() {
			return new IGrammarAwareElementType("Statemachine_EventsKeyword_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getEventsKeyword_0());
		}
		public static IGrammarAwareElementType createStatemachine_EventsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Statemachine_EventsAssignment_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getEventsAssignment_1());
		}
		public static IGrammarAwareElementType createStatemachine_EventsEventParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Statemachine_EventsEventParserRuleCall_1_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getEventsEventParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createStatemachine_EndKeyword_2ElementType() {
			return new IGrammarAwareElementType("Statemachine_EndKeyword_2_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getEndKeyword_2());
		}
		public static IGrammarAwareElementType createStatemachine_CommandsKeyword_3ElementType() {
			return new IGrammarAwareElementType("Statemachine_CommandsKeyword_3_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getCommandsKeyword_3());
		}
		public static IGrammarAwareElementType createStatemachine_CommandsAssignment_4ElementType() {
			return new IGrammarAwareElementType("Statemachine_CommandsAssignment_4_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getCommandsAssignment_4());
		}
		public static IGrammarAwareElementType createStatemachine_CommandsCommandParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Statemachine_CommandsCommandParserRuleCall_4_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getCommandsCommandParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createStatemachine_EndKeyword_5ElementType() {
			return new IGrammarAwareElementType("Statemachine_EndKeyword_5_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getEndKeyword_5());
		}
		public static IGrammarAwareElementType createStatemachine_StatesAssignment_6ElementType() {
			return new IGrammarAwareElementType("Statemachine_StatesAssignment_6_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getStatesAssignment_6());
		}
		public static IGrammarAwareElementType createStatemachine_StatesStateParserRuleCall_6_0ElementType() {
			return new IGrammarAwareElementType("Statemachine_StatesStateParserRuleCall_6_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStatemachineAccess().getStatesStateParserRuleCall_6_0());
		}
	}

	public static final IGrammarAwareElementType Statemachine_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachineElementType());

	public static final IGrammarAwareElementType Statemachine_Group_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_GroupElementType());

	public static final IGrammarAwareElementType Statemachine_EventsKeyword_0_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_EventsKeyword_0ElementType());

	public static final IGrammarAwareElementType Statemachine_EventsAssignment_1_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_EventsAssignment_1ElementType());

	public static final IGrammarAwareElementType Statemachine_EventsEventParserRuleCall_1_0_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_EventsEventParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Statemachine_EndKeyword_2_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_EndKeyword_2ElementType());

	public static final IGrammarAwareElementType Statemachine_CommandsKeyword_3_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_CommandsKeyword_3ElementType());

	public static final IGrammarAwareElementType Statemachine_CommandsAssignment_4_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_CommandsAssignment_4ElementType());

	public static final IGrammarAwareElementType Statemachine_CommandsCommandParserRuleCall_4_0_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_CommandsCommandParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Statemachine_EndKeyword_5_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_EndKeyword_5ElementType());

	public static final IGrammarAwareElementType Statemachine_StatesAssignment_6_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_StatesAssignment_6ElementType());

	public static final IGrammarAwareElementType Statemachine_StatesStateParserRuleCall_6_0_ELEMENT_TYPE = associate(StatemachineFactory.createStatemachine_StatesStateParserRuleCall_6_0ElementType());

	private static class EventFactory {
		public static IGrammarAwareElementType createEventElementType() {
			return new IGrammarAwareElementType("Event_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEventRule());
		}
		public static IGrammarAwareElementType createEvent_GroupElementType() {
			return new IGrammarAwareElementType("Event_Group_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEventAccess().getGroup());
		}
		public static IGrammarAwareElementType createEvent_ResettingAssignment_0ElementType() {
			return new IGrammarAwareElementType("Event_ResettingAssignment_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEventAccess().getResettingAssignment_0());
		}
		public static IGrammarAwareElementType createEvent_ResettingResettingKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Event_ResettingResettingKeyword_0_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEventAccess().getResettingResettingKeyword_0_0());
		}
		public static IGrammarAwareElementType createEvent_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Event_NameAssignment_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEventAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createEvent_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Event_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEventAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEvent_CodeAssignment_2ElementType() {
			return new IGrammarAwareElementType("Event_CodeAssignment_2_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEventAccess().getCodeAssignment_2());
		}
		public static IGrammarAwareElementType createEvent_CodeIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Event_CodeIDTerminalRuleCall_2_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEventAccess().getCodeIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Event_ELEMENT_TYPE = associate(EventFactory.createEventElementType());

	public static final IGrammarAwareElementType Event_Group_ELEMENT_TYPE = associate(EventFactory.createEvent_GroupElementType());

	public static final IGrammarAwareElementType Event_ResettingAssignment_0_ELEMENT_TYPE = associate(EventFactory.createEvent_ResettingAssignment_0ElementType());

	public static final IGrammarAwareElementType Event_ResettingResettingKeyword_0_0_ELEMENT_TYPE = associate(EventFactory.createEvent_ResettingResettingKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Event_NameAssignment_1_ELEMENT_TYPE = associate(EventFactory.createEvent_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Event_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(EventFactory.createEvent_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Event_CodeAssignment_2_ELEMENT_TYPE = associate(EventFactory.createEvent_CodeAssignment_2ElementType());

	public static final IGrammarAwareElementType Event_CodeIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(EventFactory.createEvent_CodeIDTerminalRuleCall_2_0ElementType());

	private static class CommandFactory {
		public static IGrammarAwareElementType createCommandElementType() {
			return new IGrammarAwareElementType("Command_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommandRule());
		}
		public static IGrammarAwareElementType createCommand_GroupElementType() {
			return new IGrammarAwareElementType("Command_Group_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommandAccess().getGroup());
		}
		public static IGrammarAwareElementType createCommand_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Command_NameAssignment_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommandAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createCommand_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Command_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommandAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createCommand_CodeAssignment_1ElementType() {
			return new IGrammarAwareElementType("Command_CodeAssignment_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommandAccess().getCodeAssignment_1());
		}
		public static IGrammarAwareElementType createCommand_CodeIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Command_CodeIDTerminalRuleCall_1_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCommandAccess().getCodeIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Command_ELEMENT_TYPE = associate(CommandFactory.createCommandElementType());

	public static final IGrammarAwareElementType Command_Group_ELEMENT_TYPE = associate(CommandFactory.createCommand_GroupElementType());

	public static final IGrammarAwareElementType Command_NameAssignment_0_ELEMENT_TYPE = associate(CommandFactory.createCommand_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Command_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(CommandFactory.createCommand_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Command_CodeAssignment_1_ELEMENT_TYPE = associate(CommandFactory.createCommand_CodeAssignment_1ElementType());

	public static final IGrammarAwareElementType Command_CodeIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(CommandFactory.createCommand_CodeIDTerminalRuleCall_1_0ElementType());

	private static class StateFactory {
		public static IGrammarAwareElementType createStateElementType() {
			return new IGrammarAwareElementType("State_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateRule());
		}
		public static IGrammarAwareElementType createState_GroupElementType() {
			return new IGrammarAwareElementType("State_Group_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getGroup());
		}
		public static IGrammarAwareElementType createState_StateKeyword_0ElementType() {
			return new IGrammarAwareElementType("State_StateKeyword_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getStateKeyword_0());
		}
		public static IGrammarAwareElementType createState_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("State_NameAssignment_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createState_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("State_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createState_Group_2ElementType() {
			return new IGrammarAwareElementType("State_Group_2_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createState_ActionsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("State_ActionsKeyword_2_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getActionsKeyword_2_0());
		}
		public static IGrammarAwareElementType createState_LeftCurlyBracketKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("State_LeftCurlyBracketKeyword_2_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getLeftCurlyBracketKeyword_2_1());
		}
		public static IGrammarAwareElementType createState_ActionsAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("State_ActionsAssignment_2_2_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getActionsAssignment_2_2());
		}
		public static IGrammarAwareElementType createState_ActionsCommandCrossReference_2_2_0ElementType() {
			return new IGrammarAwareElementType("State_ActionsCommandCrossReference_2_2_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getActionsCommandCrossReference_2_2_0());
		}
		public static IGrammarAwareElementType createState_ActionsCommandIDTerminalRuleCall_2_2_0_1ElementType() {
			return new IGrammarAwareElementType("State_ActionsCommandIDTerminalRuleCall_2_2_0_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getActionsCommandIDTerminalRuleCall_2_2_0_1());
		}
		public static IGrammarAwareElementType createState_RightCurlyBracketKeyword_2_3ElementType() {
			return new IGrammarAwareElementType("State_RightCurlyBracketKeyword_2_3_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getRightCurlyBracketKeyword_2_3());
		}
		public static IGrammarAwareElementType createState_TransitionsAssignment_3ElementType() {
			return new IGrammarAwareElementType("State_TransitionsAssignment_3_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getTransitionsAssignment_3());
		}
		public static IGrammarAwareElementType createState_TransitionsTransitionParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("State_TransitionsTransitionParserRuleCall_3_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getTransitionsTransitionParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createState_EndKeyword_4ElementType() {
			return new IGrammarAwareElementType("State_EndKeyword_4_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getStateAccess().getEndKeyword_4());
		}
	}

	public static final IGrammarAwareElementType State_ELEMENT_TYPE = associate(StateFactory.createStateElementType());

	public static final IGrammarAwareElementType State_Group_ELEMENT_TYPE = associate(StateFactory.createState_GroupElementType());

	public static final IGrammarAwareElementType State_StateKeyword_0_ELEMENT_TYPE = associate(StateFactory.createState_StateKeyword_0ElementType());

	public static final IGrammarAwareElementType State_NameAssignment_1_ELEMENT_TYPE = associate(StateFactory.createState_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType State_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(StateFactory.createState_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType State_Group_2_ELEMENT_TYPE = associate(StateFactory.createState_Group_2ElementType());

	public static final IGrammarAwareElementType State_ActionsKeyword_2_0_ELEMENT_TYPE = associate(StateFactory.createState_ActionsKeyword_2_0ElementType());

	public static final IGrammarAwareElementType State_LeftCurlyBracketKeyword_2_1_ELEMENT_TYPE = associate(StateFactory.createState_LeftCurlyBracketKeyword_2_1ElementType());

	public static final IGrammarAwareElementType State_ActionsAssignment_2_2_ELEMENT_TYPE = associate(StateFactory.createState_ActionsAssignment_2_2ElementType());

	public static final IGrammarAwareElementType State_ActionsCommandCrossReference_2_2_0_ELEMENT_TYPE = associate(StateFactory.createState_ActionsCommandCrossReference_2_2_0ElementType());

	public static final IGrammarAwareElementType State_ActionsCommandIDTerminalRuleCall_2_2_0_1_ELEMENT_TYPE = associate(StateFactory.createState_ActionsCommandIDTerminalRuleCall_2_2_0_1ElementType());

	public static final IGrammarAwareElementType State_RightCurlyBracketKeyword_2_3_ELEMENT_TYPE = associate(StateFactory.createState_RightCurlyBracketKeyword_2_3ElementType());

	public static final IGrammarAwareElementType State_TransitionsAssignment_3_ELEMENT_TYPE = associate(StateFactory.createState_TransitionsAssignment_3ElementType());

	public static final IGrammarAwareElementType State_TransitionsTransitionParserRuleCall_3_0_ELEMENT_TYPE = associate(StateFactory.createState_TransitionsTransitionParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType State_EndKeyword_4_ELEMENT_TYPE = associate(StateFactory.createState_EndKeyword_4ElementType());

	private static class TransitionFactory {
		public static IGrammarAwareElementType createTransitionElementType() {
			return new IGrammarAwareElementType("Transition_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionRule());
		}
		public static IGrammarAwareElementType createTransition_GroupElementType() {
			return new IGrammarAwareElementType("Transition_Group_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getGroup());
		}
		public static IGrammarAwareElementType createTransition_EventAssignment_0ElementType() {
			return new IGrammarAwareElementType("Transition_EventAssignment_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getEventAssignment_0());
		}
		public static IGrammarAwareElementType createTransition_EventEventCrossReference_0_0ElementType() {
			return new IGrammarAwareElementType("Transition_EventEventCrossReference_0_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getEventEventCrossReference_0_0());
		}
		public static IGrammarAwareElementType createTransition_EventEventIDTerminalRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("Transition_EventEventIDTerminalRuleCall_0_0_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createTransition_EqualsSignGreaterThanSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("Transition_EqualsSignGreaterThanSignKeyword_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		public static IGrammarAwareElementType createTransition_StateAssignment_2ElementType() {
			return new IGrammarAwareElementType("Transition_StateAssignment_2_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getStateAssignment_2());
		}
		public static IGrammarAwareElementType createTransition_StateStateCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("Transition_StateStateCrossReference_2_0_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getStateStateCrossReference_2_0());
		}
		public static IGrammarAwareElementType createTransition_StateStateIDTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Transition_StateStateIDTerminalRuleCall_2_0_1_ELEMENT_TYPE", FowlerDslTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Transition_ELEMENT_TYPE = associate(TransitionFactory.createTransitionElementType());

	public static final IGrammarAwareElementType Transition_Group_ELEMENT_TYPE = associate(TransitionFactory.createTransition_GroupElementType());

	public static final IGrammarAwareElementType Transition_EventAssignment_0_ELEMENT_TYPE = associate(TransitionFactory.createTransition_EventAssignment_0ElementType());

	public static final IGrammarAwareElementType Transition_EventEventCrossReference_0_0_ELEMENT_TYPE = associate(TransitionFactory.createTransition_EventEventCrossReference_0_0ElementType());

	public static final IGrammarAwareElementType Transition_EventEventIDTerminalRuleCall_0_0_1_ELEMENT_TYPE = associate(TransitionFactory.createTransition_EventEventIDTerminalRuleCall_0_0_1ElementType());

	public static final IGrammarAwareElementType Transition_EqualsSignGreaterThanSignKeyword_1_ELEMENT_TYPE = associate(TransitionFactory.createTransition_EqualsSignGreaterThanSignKeyword_1ElementType());

	public static final IGrammarAwareElementType Transition_StateAssignment_2_ELEMENT_TYPE = associate(TransitionFactory.createTransition_StateAssignment_2ElementType());

	public static final IGrammarAwareElementType Transition_StateStateCrossReference_2_0_ELEMENT_TYPE = associate(TransitionFactory.createTransition_StateStateCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType Transition_StateStateIDTerminalRuleCall_2_0_1_ELEMENT_TYPE = associate(TransitionFactory.createTransition_StateStateIDTerminalRuleCall_2_0_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getStatemachineElementType() {
		return Statemachine_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_GroupElementType() {
		return Statemachine_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_EventsKeyword_0ElementType() {
		return Statemachine_EventsKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_EventsAssignment_1ElementType() {
		return Statemachine_EventsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_EventsEventParserRuleCall_1_0ElementType() {
		return Statemachine_EventsEventParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_EndKeyword_2ElementType() {
		return Statemachine_EndKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_CommandsKeyword_3ElementType() {
		return Statemachine_CommandsKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_CommandsAssignment_4ElementType() {
		return Statemachine_CommandsAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_CommandsCommandParserRuleCall_4_0ElementType() {
		return Statemachine_CommandsCommandParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_EndKeyword_5ElementType() {
		return Statemachine_EndKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_StatesAssignment_6ElementType() {
		return Statemachine_StatesAssignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatemachine_StatesStateParserRuleCall_6_0ElementType() {
		return Statemachine_StatesStateParserRuleCall_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEventElementType() {
		return Event_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEvent_GroupElementType() {
		return Event_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEvent_ResettingAssignment_0ElementType() {
		return Event_ResettingAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEvent_ResettingResettingKeyword_0_0ElementType() {
		return Event_ResettingResettingKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEvent_NameAssignment_1ElementType() {
		return Event_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEvent_NameIDTerminalRuleCall_1_0ElementType() {
		return Event_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEvent_CodeAssignment_2ElementType() {
		return Event_CodeAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEvent_CodeIDTerminalRuleCall_2_0ElementType() {
		return Event_CodeIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommandElementType() {
		return Command_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommand_GroupElementType() {
		return Command_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommand_NameAssignment_0ElementType() {
		return Command_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommand_NameIDTerminalRuleCall_0_0ElementType() {
		return Command_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommand_CodeAssignment_1ElementType() {
		return Command_CodeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCommand_CodeIDTerminalRuleCall_1_0ElementType() {
		return Command_CodeIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStateElementType() {
		return State_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_GroupElementType() {
		return State_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_StateKeyword_0ElementType() {
		return State_StateKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_NameAssignment_1ElementType() {
		return State_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_NameIDTerminalRuleCall_1_0ElementType() {
		return State_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_Group_2ElementType() {
		return State_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_ActionsKeyword_2_0ElementType() {
		return State_ActionsKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_LeftCurlyBracketKeyword_2_1ElementType() {
		return State_LeftCurlyBracketKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_ActionsAssignment_2_2ElementType() {
		return State_ActionsAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_ActionsCommandCrossReference_2_2_0ElementType() {
		return State_ActionsCommandCrossReference_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_ActionsCommandIDTerminalRuleCall_2_2_0_1ElementType() {
		return State_ActionsCommandIDTerminalRuleCall_2_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_RightCurlyBracketKeyword_2_3ElementType() {
		return State_RightCurlyBracketKeyword_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_TransitionsAssignment_3ElementType() {
		return State_TransitionsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_TransitionsTransitionParserRuleCall_3_0ElementType() {
		return State_TransitionsTransitionParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getState_EndKeyword_4ElementType() {
		return State_EndKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransitionElementType() {
		return Transition_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_GroupElementType() {
		return Transition_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_EventAssignment_0ElementType() {
		return Transition_EventAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_EventEventCrossReference_0_0ElementType() {
		return Transition_EventEventCrossReference_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_EventEventIDTerminalRuleCall_0_0_1ElementType() {
		return Transition_EventEventIDTerminalRuleCall_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_EqualsSignGreaterThanSignKeyword_1ElementType() {
		return Transition_EqualsSignGreaterThanSignKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_StateAssignment_2ElementType() {
		return Transition_StateAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_StateStateCrossReference_2_0ElementType() {
		return Transition_StateStateCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransition_StateStateIDTerminalRuleCall_2_0_1ElementType() {
		return Transition_StateStateIDTerminalRuleCall_2_0_1_ELEMENT_TYPE;
	}

}
