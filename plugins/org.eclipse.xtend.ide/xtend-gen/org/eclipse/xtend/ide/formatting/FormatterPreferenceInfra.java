package org.eclipse.xtend.ide.formatting;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
import org.eclipse.xtend.ide.formatting.FormatterSetting;
import org.eclipse.xtend.ide.formatting.SettingsData.Category;
import org.eclipse.xtend.ide.formatting.SettingsData.WidgetType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FormatterPreferenceInfra {
  public static String PREFIX = "org.eclipse.xtend.formatter";
  
  public static String MAX_LINE_WIDTH = new Function0<String>() {
    public String apply() {
      String _plus = (FormatterPreferenceInfra.PREFIX + ".max_line_width");
      return _plus;
    }
  }.apply();
  
  public static String TAB_POLICY = new Function0<String>() {
    public String apply() {
      String _plus = (FormatterPreferenceInfra.PREFIX + ".tab_policy");
      return _plus;
    }
  }.apply();
  
  public static String INDENTATION_SIZE = new Function0<String>() {
    public String apply() {
      String _plus = (FormatterPreferenceInfra.PREFIX + ".indentation_size");
      return _plus;
    }
  }.apply();
  
  private static List<FormatterSetting> settings = new Function0<List<FormatterSetting>>() {
    public List<FormatterSetting> apply() {
      FormatterSetting _createNumberSetting = FormatterPreferenceInfra.createNumberSetting(Category.LINE_WRAPPING, FormatterPreferenceInfra.MAX_LINE_WIDTH, "Maximum line width");
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(JavaCore.SPACE, JavaCore.TAB, DefaultCodeFormatterConstants.MIXED);
      FormatterSetting _createSetting = FormatterPreferenceInfra.createSetting(Category.INDENTATION, WidgetType.COMBO_BOX, FormatterPreferenceInfra.TAB_POLICY, "Tab policy", _newArrayList);
      FormatterSetting _createNumberSetting_1 = FormatterPreferenceInfra.createNumberSetting(Category.INDENTATION, FormatterPreferenceInfra.INDENTATION_SIZE, "Tab size");
      ArrayList<FormatterSetting> _newArrayList_1 = CollectionLiterals.<FormatterSetting>newArrayList(_createNumberSetting, _createSetting, _createNumberSetting_1);
      return _newArrayList_1;
    }
  }.apply();
  
  public static FormatterSetting createNumberSetting(final Category category, final String name, final String label) {
    FormatterSetting _formatterSetting = new FormatterSetting(category, name, label, WidgetType.NUMBER_FIELD, null);
    return _formatterSetting;
  }
  
  public static FormatterSetting createSetting(final Category category, final WidgetType type, final String name, final String label, final List<String> values) {
    FormatterSetting _formatterSetting = new FormatterSetting(category, name, label, type, values);
    return _formatterSetting;
  }
  
  public static XtendFormatterConfig createRendererConfiguration(final Map<String,String> map) {
    XtendFormatterConfig _xtendFormatterConfig = new XtendFormatterConfig();
    final XtendFormatterConfig rendererConfiguration = _xtendFormatterConfig;
    try {
      String _get = map.get(FormatterPreferenceInfra.INDENTATION_SIZE);
      int _parseInt = Integer.parseInt(_get);
      rendererConfiguration.setIndentationLength(_parseInt);
      String _get_1 = map.get(FormatterPreferenceInfra.MAX_LINE_WIDTH);
      int _parseInt_1 = Integer.parseInt(_get_1);
      rendererConfiguration.setMaxLineWidth(_parseInt_1);
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException nfe = (NumberFormatException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return rendererConfiguration;
  }
  
  public Iterable<FormatterSetting> settingsByCategory(final Category category) {
    final Function1<FormatterSetting,Boolean> _function = new Function1<FormatterSetting,Boolean>() {
        public Boolean apply(final FormatterSetting it) {
          Category _category = it.getCategory();
          boolean _equals = Objects.equal(_category, category);
          return Boolean.valueOf(_equals);
        }
      };
    return IterableExtensions.<FormatterSetting>filter(FormatterPreferenceInfra.settings, _function);
  }
  
  public CharSequence previewText(final Category category) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(category,Category.INDENTATION)) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class BugTester {");
        _builder.newLine();
        _builder.append("def myDef(){");
        _builder.newLine();
        _builder.append("println(\"Works fine\")");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (Objects.equal(category,Category.LINE_WRAPPING)) {
        _matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("class Movies {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("def readMovies() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("val movies = new FileReader(\'data.csv\').readLines.map [ line |  val segments = line.split(\'  \').iterator");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return new Movie(segments.next, Integer::parseInt(segments.next), Double::parseDouble(segments.next), Long::parseLong(segments.next),  segments.toSet)]");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _switchResult = _builder_1;
      }
    }
    return _switchResult;
  }
}
