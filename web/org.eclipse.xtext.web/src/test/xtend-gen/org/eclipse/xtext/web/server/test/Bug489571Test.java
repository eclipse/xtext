package org.eclipse.xtext.web.server.test;

import com.google.inject.Module;
import java.io.File;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.formatting.FormattingResult;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class Bug489571Test extends AbstractWebServerTest {
  public static class Bug489571IndentationInformation implements IIndentationInformation {
    @Override
    public String getIndentString() {
      return "  ";
    }
  }
  
  @Override
  protected Module getRuntimeModule() {
    abstract class __Bug489571Test_1 extends StatemachineRuntimeModule {
      public abstract Class<? extends IIndentationInformation> bindIIndentationInformation();
    }
    
    return new __Bug489571Test_1() {
      public Class<? extends IIndentationInformation> bindIIndentationInformation() {
        return Bug489571Test.Bug489571IndentationInformation.class;
      }
    };
  }
  
  @Test
  public void testFormatFile() {
    final File file = this.createFile("/* bla */ output signal x state foo set x = true end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "format");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    final XtextServiceDispatcher.ServiceDescriptor format = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
    boolean _isHasSideEffects = format.isHasSideEffects();
    Assert.assertTrue(_isHasSideEffects);
    Function0<? extends IServiceResult> _service = format.getService();
    IServiceResult _apply = _service.apply();
    final FormattingResult result = ((FormattingResult) _apply);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("FormattingResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("stateId = \"-7fffffff\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("formattedText = \"/* bla */ output signal x\\nstate foo\\n  set x = true\\nend\\n\"");
    _builder.newLine();
    _builder.append("]");
    final String expectedResult = _builder.toString();
    String _string = result.toString();
    Assert.assertEquals(expectedResult, _string);
  }
  
  @Test
  public void testFormatSelection() {
    final File file = this.createFile("/* bla */ output signal x state foo set x = true end ");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "format");
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("selectionStart", "26");
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("selectionEnd", "52");
    String _name = file.getName();
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("resource", _name);
    final XtextServiceDispatcher.ServiceDescriptor format = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)));
    boolean _isHasSideEffects = format.isHasSideEffects();
    Assert.assertTrue(_isHasSideEffects);
    Function0<? extends IServiceResult> _service = format.getService();
    IServiceResult _apply = _service.apply();
    final FormattingResult result = ((FormattingResult) _apply);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("FormattingResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("stateId = \"-7fffffff\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("formattedText = \"state foo\\n  set x = true\\nend\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("replaceRegion = [26:26]");
    _builder.newLine();
    _builder.append("]");
    final String expectedResult = _builder.toString();
    String _string = result.toString();
    Assert.assertEquals(expectedResult, _string);
  }
}
