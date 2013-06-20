package org.eclipse.xtend.core.formatting;

import com.google.inject.Singleton;
import org.eclipse.xtext.xbase.formatting.BlankLineKey;
import org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@Singleton
@SuppressWarnings("all")
public class XtendFormatterPreferenceKeys extends XbaseFormatterPreferenceKeys {
  public final static BlankLineKey blankLinesAfterPackageDecl = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.after.packagedecl", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesBetweenImports = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.imports", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesAfterImports = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.after.imports", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesBetweenClasses = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.classes", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesBeforeFirstMember = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.before.first.member", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesAfterLastMember = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.after.last.member", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesBetweenFields = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.fields", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesBetweenFieldsAndMethods = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.fields.and.methods", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesBetweenMethods = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.methods", Integer.valueOf(1));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesBetweenEnumLiterals = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.lines.between.enum.literals", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
}
