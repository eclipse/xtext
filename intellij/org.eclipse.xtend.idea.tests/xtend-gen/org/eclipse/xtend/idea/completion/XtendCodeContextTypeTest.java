/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.completion;

import com.google.common.base.Objects;
import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.codeInsight.template.impl.TemplateManagerImpl;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.completion.XtendCodeContextType;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendCodeContextTypeTest extends LightXtendTest {
  @Data
  public static class ContextTypeAssertion {
    private final TemplateContextType contextType;
    
    private final boolean shouldMatch;
    
    public ContextTypeAssertion(final TemplateContextType contextType, final boolean shouldMatch) {
      super();
      this.contextType = contextType;
      this.shouldMatch = shouldMatch;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.contextType== null) ? 0 : this.contextType.hashCode());
      result = prime * result + (this.shouldMatch ? 1231 : 1237);
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      XtendCodeContextTypeTest.ContextTypeAssertion other = (XtendCodeContextTypeTest.ContextTypeAssertion) obj;
      if (this.contextType == null) {
        if (other.contextType != null)
          return false;
      } else if (!this.contextType.equals(other.contextType))
        return false;
      if (other.shouldMatch != this.shouldMatch)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("contextType", this.contextType);
      b.add("shouldMatch", this.shouldMatch);
      return b.toString();
    }
    
    @Pure
    public TemplateContextType getContextType() {
      return this.contextType;
    }
    
    @Pure
    public boolean isShouldMatch() {
      return this.shouldMatch;
    }
  }
  
  public void testContexts_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<caret>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendCodeContextTypeTest.ContextTypeAssertion _is = this.is(XtendCodeContextType.Generic.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _is_1 = this.is(XtendCodeContextType.Member.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _not = this.not(XtendCodeContextType.Statement.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _not_1 = this.not(XtendCodeContextType.Expression.class);
    this.assertContext(_builder, _is, _is_1, _not, _not_1);
  }
  
  public void testContexts_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <caret> foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendCodeContextTypeTest.ContextTypeAssertion _is = this.is(XtendCodeContextType.Generic.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _not = this.not(XtendCodeContextType.Member.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _not_1 = this.not(XtendCodeContextType.Statement.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _not_2 = this.not(XtendCodeContextType.Expression.class);
    this.assertContext(_builder, _is, _not, _not_1, _not_2);
  }
  
  public void testContexts_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<caret>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendCodeContextTypeTest.ContextTypeAssertion _is = this.is(XtendCodeContextType.Generic.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _not = this.not(XtendCodeContextType.Member.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _is_1 = this.is(XtendCodeContextType.Statement.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _is_2 = this.is(XtendCodeContextType.Expression.class);
    this.assertContext(_builder, _is, _not, _is_1, _is_2);
  }
  
  public void testContexts_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (<caret>foo) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return false");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return true");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendCodeContextTypeTest.ContextTypeAssertion _is = this.is(XtendCodeContextType.Generic.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _not = this.not(XtendCodeContextType.Member.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _not_1 = this.not(XtendCodeContextType.Statement.class);
    XtendCodeContextTypeTest.ContextTypeAssertion _is_1 = this.is(XtendCodeContextType.Expression.class);
    this.assertContext(_builder, _is, _not, _not_1, _is_1);
  }
  
  protected void assertContext(final CharSequence text, final XtendCodeContextTypeTest.ContextTypeAssertion... contextTypes) {
    String _string = text.toString();
    final PsiFile file = this.configureByText(_string);
    for (final XtendCodeContextTypeTest.ContextTypeAssertion type : contextTypes) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("Code Context :");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(text, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("Should ");
      {
        if ((!type.shouldMatch)) {
          _builder.append("NOT ");
        }
      }
      _builder.append("match: ");
      String _string_1 = type.contextType.toString();
      _builder.append(_string_1, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      Editor _editor = this.getEditor();
      CaretModel _caretModel = _editor.getCaretModel();
      int _offset = _caretModel.getOffset();
      boolean _isInContext = type.contextType.isInContext(file, _offset);
      TestCase.assertEquals(_builder.toString(), 
        type.shouldMatch, _isInContext);
    }
  }
  
  protected XtendCodeContextTypeTest.ContextTypeAssertion not(final Class<? extends TemplateContextType> clazz) {
    final TemplateContextType ctxType = this.findTemplateContext(clazz);
    return new XtendCodeContextTypeTest.ContextTypeAssertion(ctxType, false);
  }
  
  protected XtendCodeContextTypeTest.ContextTypeAssertion is(final Class<? extends TemplateContextType> clazz) {
    final TemplateContextType ctxType = this.findTemplateContext(clazz);
    return new XtendCodeContextTypeTest.ContextTypeAssertion(ctxType, true);
  }
  
  protected TemplateContextType findTemplateContext(final Class<? extends TemplateContextType> clazz) {
    TemplateContextType[] _allContextTypes = TemplateManagerImpl.getAllContextTypes();
    final Function1<TemplateContextType, Boolean> _function = new Function1<TemplateContextType, Boolean>() {
      @Override
      public Boolean apply(final TemplateContextType it) {
        return Boolean.valueOf(clazz.isInstance(it));
      }
    };
    final TemplateContextType result = IterableExtensions.<TemplateContextType>findFirst(((Iterable<TemplateContextType>)Conversions.doWrapArray(_allContextTypes)), _function);
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      String _name = clazz.getName();
      String _plus = ("The context type " + _name);
      String _plus_1 = (_plus + " wasn\'t registered.");
      throw new AssertionError(_plus_1);
    }
    return result;
  }
}
