package org.eclipse.xtend.core.formatting;

import java.util.Map;
import org.eclipse.xtend.core.formatting.AbstractConfiguration;
import org.eclipse.xtend.core.formatting.IntegerEntry;
import org.eclipse.xtend.core.formatting.NewLineConfig;
import org.eclipse.xtend.core.formatting.StringEntry;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendFormatterConfig extends AbstractConfiguration {
  private final StringEntry _lineSeparator = new Function0<StringEntry>() {
    public StringEntry apply() {
      StringEntry _stringEntry = new StringEntry("line.separator", "\n");
      return _stringEntry;
    }
  }.apply();
  
  public StringEntry getLineSeparator() {
    return this._lineSeparator;
  }
  
  private final IntegerEntry _maxLineWidth = new Function0<IntegerEntry>() {
    public IntegerEntry apply() {
      IntegerEntry _integerEntry = new IntegerEntry("line.width.max", Integer.valueOf(120));
      return _integerEntry;
    }
  }.apply();
  
  public IntegerEntry getMaxLineWidth() {
    return this._maxLineWidth;
  }
  
  private final StringEntry _indentation = new Function0<StringEntry>() {
    public StringEntry apply() {
      StringEntry _stringEntry = new StringEntry("indentation", "\t");
      return _stringEntry;
    }
  }.apply();
  
  private final IntegerEntry _indentationLength = new Function0<IntegerEntry>() {
    public IntegerEntry apply() {
      IntegerEntry _integerEntry = new IntegerEntry("indentation.length", Integer.valueOf(4));
      return _integerEntry;
    }
  }.apply();
  
  public IntegerEntry getIndentationLength() {
    return this._indentationLength;
  }
  
  private final NewLineConfig _newLinesAfterPackageName = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.after.packagename", 2, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesAfterPackageName() {
    return this._newLinesAfterPackageName;
  }
  
  private final NewLineConfig _newLinesBetweenImports = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.imports", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesBetweenImports() {
    return this._newLinesBetweenImports;
  }
  
  private final NewLineConfig _newLinesAfterImportSection = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.after.importsection", 2, 3);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesAfterImportSection() {
    return this._newLinesAfterImportSection;
  }
  
  private final NewLineConfig _newLinesBeforeFirstMember = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.before.first.member", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesBeforeFirstMember() {
    return this._newLinesBeforeFirstMember;
  }
  
  private final NewLineConfig _newLinesAfterLastMember = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.after.last.member", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesAfterLastMember() {
    return this._newLinesAfterLastMember;
  }
  
  private final NewLineConfig _newLinesBetweenFields = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.fields", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesBetweenFields() {
    return this._newLinesBetweenFields;
  }
  
  private final NewLineConfig _newLinesBetweenFieldsAndMethods = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.fields.and.methods", 2, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesBetweenFieldsAndMethods() {
    return this._newLinesBetweenFieldsAndMethods;
  }
  
  private final NewLineConfig _newLinesBetweenMethods = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.methods", 2, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesBetweenMethods() {
    return this._newLinesBetweenMethods;
  }
  
  private final NewLineConfig _newLinesBetweenClasses = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.classes", 2, 3);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesBetweenClasses() {
    return this._newLinesBetweenClasses;
  }
  
  private final NewLineConfig _newLinesAroundExpression = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.around.expressions", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesAroundExpression() {
    return this._newLinesAroundExpression;
  }
  
  private final NewLineConfig _newLinesAfterAnnotations = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.after.annotations", 0, 1);
      return _newLineConfig;
    }
  }.apply();
  
  public NewLineConfig getNewLinesAfterAnnotations() {
    return this._newLinesAfterAnnotations;
  }
  
  public XtendFormatterConfig() {
    super(((String) null));
  }
  
  public XtendFormatterConfig(final Map<String,String> properties) {
    super(properties);
  }
  
  public String getIndentation(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      int _minus = (levels - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            String _value = XtendFormatterConfig.this._indentation.getValue();
            return _value;
          }
        };
      Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public int getIndentationLenght(final int levels) {
    IntegerEntry _indentationLength = this.getIndentationLength();
    int _value = _indentationLength.getValue();
    int _multiply = (levels * _value);
    return _multiply;
  }
  
  public String getWrap(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      int _minus = (levels - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            String _value = XtendFormatterConfig.this._lineSeparator.getValue();
            return _value;
          }
        };
      Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
}
