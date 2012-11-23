package org.eclipse.xtext.xbase.ui.tests.refactoring;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Iterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.ui.refactoring.TypeSerializationUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jan Koehnlein
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseInjectorProvider.class)
@SuppressWarnings("all")
public class TypeSerializationUtilTest {
  @Inject
  private TypeSerializationUtil util;
  
  @Inject
  private ParseHelper<XExpression> _parseHelper;
  
  @Inject
  private ITypeProvider _iTypeProvider;
  
  @Test
  public void testSimple() {
    this.assertSerializedTypeOfFoo("val foo = \'\'", "String");
    this.assertSerializedTypeOfFoo("val foo = 1", "int");
  }
  
  @Test
  public void testGenerics() {
    this.assertSerializedTypeOfFoo("val foo = newArrayList(new java.util.Date)", "java.util.ArrayList<java.util.Date>");
    this.assertSerializedTypeOfFoo("val foo = newHashMap(\'x\'->1, \'y\'->2)", "java.util.HashMap<String,Integer>");
  }
  
  @Test
  public void testClosure() {
    this.assertSerializedTypeOfFoo("val foo = [|1]", "()=>int");
    this.assertSerializedTypeOfFoo("val foo = [String x|x.toFirstUpper]", "(String)=>String");
    this.assertSerializedTypeOfFoo("val foo = [String x, int offset|x.substring(offset)]", "(String,int)=>String");
    this.assertSerializedTypeOfFoo("val foo = [String x|System.out.println(x)]", "(String)=>void");
  }
  
  protected void assertSerializedTypeOfFoo(final CharSequence model, final String expectedOutput) {
    try {
      String _plus = ("{" + model);
      String _plus_1 = (_plus + "}");
      final XExpression expression = this._parseHelper.parse(_plus_1);
      TreeIterator<EObject> _eAllContents = expression.eAllContents();
      Iterator<XVariableDeclaration> _filter = Iterators.<XVariableDeclaration>filter(_eAllContents, XVariableDeclaration.class);
      final Function1<XVariableDeclaration,Boolean> _function = new Function1<XVariableDeclaration,Boolean>() {
          public Boolean apply(final XVariableDeclaration it) {
            String _identifier = it.getIdentifier();
            boolean _equals = ObjectExtensions.operator_equals(_identifier, "foo");
            return Boolean.valueOf(_equals);
          }
        };
      Iterator<XVariableDeclaration> _filter_1 = IteratorExtensions.<XVariableDeclaration>filter(_filter, _function);
      final XVariableDeclaration varDecl = IteratorExtensions.<XVariableDeclaration>head(_filter_1);
      Assert.assertNotNull(varDecl);
      XExpression _right = varDecl.getRight();
      final JvmTypeReference type = this._iTypeProvider.getType(_right);
      final String serialized = this.util.serialize(type, expression);
      Assert.assertEquals(expectedOutput, serialized);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
