package org.eclipse.xtend.core.formatting;

import javax.inject.Singleton;
import org.eclipse.xtend.core.formatting.AbstractConfigurationKeys;
import org.eclipse.xtend.core.formatting.BlankLineKey;
import org.eclipse.xtend.core.formatting.BooleanKey;
import org.eclipse.xtend.core.formatting.IntegerKey;
import org.eclipse.xtend.core.formatting.NewLineKey;
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
  
  public final IntegerKey maxLineWidth = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("line.width.max", Integer.valueOf(120));
      return _integerKey;
    }
  }.apply();
  
  public final IntegerKey preserveBlankLines = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("preserve.blank.lines", Integer.valueOf(1));
      return _integerKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesAfterPackageDecl = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.after.packagedecl", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesBetweenImports = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.imports", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesAfterImports = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.after.imports", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesBetweenClasses = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.classes", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesBeforeFirstMember = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.before.first.member", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesAfterLastMember = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.after.last.member", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesBetweenFields = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.fields", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesBetweenFieldsAndMethods = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.fields.and.methods", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesBetweenMethods = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.methods", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final BlankLineKey blankLinesAroundExpression = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.line.around.expressions", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final BooleanKey preserveNewLines = new Function0<BooleanKey>() {
    public BooleanKey apply() {
      BooleanKey _booleanKey = new BooleanKey("preserve.new.lines", Boolean.valueOf(true));
      return _booleanKey;
    }
  }.apply();
  
  public final NewLineKey newLineAfterClassAnnotations = new Function0<NewLineKey>() {
    public NewLineKey apply() {
      NewLineKey _newLineKey = new NewLineKey("newline.after.class.annotations", Boolean.valueOf(false));
      return _newLineKey;
    }
  }.apply();
  
  public final NewLineKey newLineAfterFieldAnnotations = new Function0<NewLineKey>() {
    public NewLineKey apply() {
      NewLineKey _newLineKey = new NewLineKey("newline.after.field.annotations", Boolean.valueOf(false));
      return _newLineKey;
    }
  }.apply();
  
  public final NewLineKey newLineAfterMethodAnnotations = new Function0<NewLineKey>() {
    public NewLineKey apply() {
      NewLineKey _newLineKey = new NewLineKey("newline.after.method.annotations", Boolean.valueOf(false));
      return _newLineKey;
    }
  }.apply();
  
  public final NewLineKey newLineAfterConstructorAnnotations = new Function0<NewLineKey>() {
    public NewLineKey apply() {
      NewLineKey _newLineKey = new NewLineKey("newline.after.constructor.annotations", Boolean.valueOf(false));
      return _newLineKey;
    }
  }.apply();
  
  public final NewLineKey newLineAfterParameterAnnotations = new Function0<NewLineKey>() {
    public NewLineKey apply() {
      NewLineKey _newLineKey = new NewLineKey("newline.after.parameter.annotations", Boolean.valueOf(false));
      return _newLineKey;
    }
  }.apply();
}
