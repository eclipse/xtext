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
  public final TransientKey<String> lineSeparator = new Function0<TransientKey<String>>() {
    public TransientKey<String> apply() {
      TransientKey<String> _transientKey = new TransientKey<String>("line.separator", "\n");
      return _transientKey;
    }
  }.apply();
  
  public final IntegerKey maxLineWidth = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("line.width.max", Integer.valueOf(120));
      return _integerKey;
    }
  }.apply();
  
  public final TransientKey<String> indentation = new Function0<TransientKey<String>>() {
    public TransientKey<String> apply() {
      TransientKey<String> _transientKey = new TransientKey<String>("indentation", "\t");
      return _transientKey;
    }
  }.apply();
  
  public final TransientKey<Integer> indentationLength = new Function0<TransientKey<Integer>>() {
    public TransientKey<Integer> apply() {
      TransientKey<Integer> _transientKey = new TransientKey<Integer>("indentation.length", Integer.valueOf(4));
      return _transientKey;
    }
  }.apply();
  
  public final NewLineConfig newLinesAfterPackageName = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.after.packagename", 2, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesBetweenImports = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.imports", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesAfterImportSection = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.after.importsection", 2, 3);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesBeforeFirstMember = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.before.first.member", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesAfterLastMember = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.after.last.member", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesBetweenFields = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.fields", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesBetweenFieldsAndMethods = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.fields.and.methods", 2, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesBetweenMethods = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.methods", 2, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesBetweenClasses = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.between.classes", 2, 3);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesAroundExpression = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.around.expressions", 1, 2);
      return _newLineConfig;
    }
  }.apply();
  
  public final NewLineConfig newLinesAfterAnnotations = new Function0<NewLineConfig>() {
    public NewLineConfig apply() {
      NewLineConfig _newLineConfig = new NewLineConfig("newlines.after.annotations", 0, 1);
      return _newLineConfig;
    }
  }.apply();
}
