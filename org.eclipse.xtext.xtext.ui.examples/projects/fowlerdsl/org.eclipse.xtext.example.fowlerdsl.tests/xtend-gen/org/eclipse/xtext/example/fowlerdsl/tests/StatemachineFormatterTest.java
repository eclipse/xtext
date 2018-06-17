package org.eclipse.xtext.example.fowlerdsl.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.fowlerdsl.tests.StatemachineInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(StatemachineInjectorProvider.class)
@SuppressWarnings("all")
public class StatemachineFormatterTest {
  @Inject
  @Extension
  private FormatterTestHelper _formatterTestHelper;
  
  @Test
  public void events() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void commands() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockPanel PNUL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockPanel   NLK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockDoor    D1LK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockDoor  D1UL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void states() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("state idle end state active end state waitingForLight end");
      _builder.newLine();
      _builder.append("state waitingForDrawer end state unlockedPanel end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("state idle");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state active");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state waitingForLight");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state waitingForDrawer");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state unlockedPanel");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void resetEvent() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      _builder.append("resetEvents doorOpened end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("resetEvents");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void resetEvents() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      _builder.append("resetEvents doorClosed doorOpened end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("resetEvents");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void events_commands() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      _builder.append("commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockPanel PNUL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockPanel   NLK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockDoor    D1LK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockDoor  D1UL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void events_state() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      _builder.append("state idle end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state idle");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void events_resetEvents_commands() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      _builder.append("resetEvents doorOpened end");
      _builder.newLine();
      _builder.append("commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("resetEvents");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockPanel PNUL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockPanel   NLK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockDoor    D1LK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockDoor  D1UL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void events_resetEvents_state() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      _builder.append("resetEvents doorOpened end state idle doorClosed => active end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("resetEvents");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state idle");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed => active");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void events_resetEvents_commands_state() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      _builder.append("resetEvents doorOpened end");
      _builder.newLine();
      _builder.append("commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end");
      _builder.newLine();
      _builder.append("state idle actions {unlockDoor lockPanel} doorClosed => active end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("resetEvents");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockPanel PNUL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockPanel   NLK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockDoor    D1LK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockDoor  D1UL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state idle");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("actions {unlockDoor lockPanel}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed => active");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
  
  @Test
  public void events_resetEvents_commands_states() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end");
      _builder.newLine();
      _builder.append("resetEvents doorOpened end");
      _builder.newLine();
      _builder.append("commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end");
      _builder.newLine();
      _builder.append("state idle actions {unlockDoor lockPanel} doorClosed => active end");
      _builder.newLine();
      _builder.append("state active drawerOpened => waitingForLight lightOn => waitingForDrawer end");
      _builder.newLine();
      _builder.append("state waitingForLight lightOn => unlockedPanel end");
      _builder.newLine();
      _builder.append("state waitingForDrawer drawerOpened => unlockedPanel end");
      _builder.newLine();
      _builder.append("state unlockedPanel actions {unlockPanel lockDoor} panelClosed => idle end");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed   D1CL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened D2OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      L1ON");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened   D1OP");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed  PNCL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("resetEvents");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorOpened");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockPanel PNUL");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockPanel   NLK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lockDoor    D1LK");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unlockDoor  D1UL");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state idle");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("actions {unlockDoor lockPanel}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("doorClosed => active");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state active");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened => waitingForLight");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn      => waitingForDrawer");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state waitingForLight");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("lightOn => unlockedPanel");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state waitingForDrawer");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("drawerOpened => unlockedPanel");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("state unlockedPanel");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("actions {unlockPanel lockDoor}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("panelClosed => idle");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
}
