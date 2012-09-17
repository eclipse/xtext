package org.eclipse.xtend.ide.formatting;

import com.google.common.base.Objects;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
import org.eclipse.xtend.ide.formatting.FormatterSetting;
import org.eclipse.xtend.ide.formatting.SettingsData.Category;
import org.eclipse.xtend.ide.formatting.SettingsData.WidgetType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class FormatterPreferenceInfra {
  public static String PREFIX = "org.eclipse.xtend.formatter";
  
  public static FormatterSetting createNumberSetting(final Category category, final String name, final String label) {
    FormatterSetting _formatterSetting = new FormatterSetting(category, name, label, WidgetType.NUMBER_FIELD, null);
    return _formatterSetting;
  }
  
  public static FormatterSetting createSetting(final Category category, final WidgetType type, final String name, final String label, final List<String> values) {
    FormatterSetting _formatterSetting = new FormatterSetting(category, name, label, type, values);
    return _formatterSetting;
  }
  
  public static Iterable<FormatterSetting> settingsByCategory(final Category category, final XtendFormatterConfig config) {
    List<FormatterSetting> _settings = FormatterPreferenceInfra.settings(config);
    final Function1<FormatterSetting,Boolean> _function = new Function1<FormatterSetting,Boolean>() {
        public Boolean apply(final FormatterSetting it) {
          Category _category = it.getCategory();
          boolean _equals = Objects.equal(_category, category);
          return Boolean.valueOf(_equals);
        }
      };
    return IterableExtensions.<FormatterSetting>filter(_settings, _function);
  }
  
  public static List<FormatterSetting> settings(final XtendFormatterConfig config) {
    final List<FormatterSetting> settings = CollectionLiterals.<FormatterSetting>newArrayList();
    Map<String,Field> _namedProperties = config.getNamedProperties();
    Set<Entry<String,Field>> _entrySet = _namedProperties.entrySet();
    for (final Entry<String,Field> entry : _entrySet) {
      {
        final String key = entry.getKey();
        String[] _split = key.split("\\.");
        final String category = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
        Category catEnum = Category.byName(category);
        Field _value = entry.getValue();
        Class<? extends Object> _type = _value.getType();
        boolean _equals = int.class.equals(_type);
        if (_equals) {
          String _firstUpper = StringExtensions.toFirstUpper(key);
          Field _value_1 = entry.getValue();
          String _name = _value_1.getName();
          ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(_name);
          FormatterSetting _createSetting = FormatterPreferenceInfra.createSetting(catEnum, WidgetType.NUMBER_FIELD, key, _firstUpper, _newArrayList);
          settings.add(_createSetting);
        }
      }
    }
    return settings;
  }
  
  public static CharSequence previewText(final Category category) {
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
    if (!_matched) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Movies {");
      _builder_2.newLine();
      _builder_2.append("def settings(XtendFormatterConfig config) {");
      _builder_2.newLine();
      _builder_2.append("val List<FormatterSetting> settings = newArrayList()");
      _builder_2.newLine();
      _builder_2.append("for (entry : config.namedProperties.entrySet) {");
      _builder_2.newLine();
      _builder_2.append("val key = entry.key");
      _builder_2.newLine();
      _builder_2.append("val category = key.split(\".\").head");
      _builder_2.newLine();
      _builder_2.append("var catEnum = SettingsData$Category::byName(category)");
      _builder_2.newLine();
      _builder_2.append("if (catEnum == null)");
      _builder_2.newLine();
      _builder_2.append("catEnum = SettingsData$Category::OTHER");
      _builder_2.newLine();
      _builder_2.append("settings.add(");
      _builder_2.newLine();
      _builder_2.append("createSetting(catEnum, SettingsData$WidgetType::NUMBER_FIELD, key, key.toFirstUpper,");
      _builder_2.newLine();
      _builder_2.append("newArrayList(entry.value.name)))");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("return settings");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      _switchResult = _builder_2;
    }
    return _switchResult;
  }
}
