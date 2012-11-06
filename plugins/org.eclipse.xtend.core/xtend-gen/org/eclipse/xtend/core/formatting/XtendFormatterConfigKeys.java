package org.eclipse.xtend.core.formatting;

import javax.inject.Singleton;
import org.eclipse.xtend.core.formatting.AbstractConfigurationKeys;
import org.eclipse.xtend.core.formatting.IntegerKey;
import org.eclipse.xtend.core.formatting.NewLineConfig;
import org.eclipse.xtend.core.formatting.TransientKey;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@Singleton
@SuppressWarnings("all")
public class XtendFormatterConfigKeys extends AbstractConfigurationKeys {
  private final TransientKey<String> _lineSeparator = new Function0<TransientKey<String>>() {
    public TransientKey<String> apply() {
      TransientKey<String> _transientKey = new TransientKey<String>("line.separator", "\n");
      return _transientKey;
    }
  }.apply();
  
  public TransientKey<String> getLineSeparator() {
    return this._lineSeparator;
  }
  
  private final IntegerKey _maxLineWidth = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("line.width.max", Integer.valueOf(120));
      return _integerKey;
    }
  }.apply();
  
  public IntegerKey getMaxLineWidth() {
    return this._maxLineWidth;
  }
  
  private final TransientKey<String> _indentation = new Function0<TransientKey<String>>() {
    public TransientKey<String> apply() {
      TransientKey<String> _transientKey = new TransientKey<String>("indentation", "\t");
      return _transientKey;
    }
  }.apply();
  
  public TransientKey<String> getIndentation() {
    return this._indentation;
  }
  
  private final TransientKey<Integer> _indentationLength = new Function0<TransientKey<Integer>>() {
    public TransientKey<Integer> apply() {
      TransientKey<Integer> _transientKey = new TransientKey<Integer>("indentation.length", Integer.valueOf(4));
      return _transientKey;
    }
  }.apply();
  
  public TransientKey<Integer> getIndentationLength() {
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
}
