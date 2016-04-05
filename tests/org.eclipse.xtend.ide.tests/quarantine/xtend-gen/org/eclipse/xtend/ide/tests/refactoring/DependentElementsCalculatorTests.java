package org.eclipse.xtend.ide.tests.refactoring;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class DependentElementsCalculatorTests extends AbstractXtendUITestCase {
  @Inject
  private IDependentElementsCalculator dependentElementsCalculator;
  
  @Inject
  @Extension
  private IXtendJvmAssociations associations;
  
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Test
  public void testDependentElements() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Foo foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.testHelper.xtendFile("Foo", _builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _get = _xtendTypes.get(0);
      final XtendClass fooClass = ((XtendClass) _get);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      final Iterable<URI> dependentElementURIs = this.dependentElementsCalculator.getDependentElementURIs(fooClass, _nullProgressMonitor);
      int _size = IterableExtensions.size(dependentElementURIs);
      Assert.assertEquals(3, _size);
      EList<XtendMember> _members = fooClass.getMembers();
      XtendMember _get_1 = _members.get(0);
      final XtendFunction fooFunction = ((XtendFunction) _get_1);
      JvmGenericType _inferredType = this.associations.getInferredType(fooClass);
      JvmConstructor _inferredConstructor = this.associations.getInferredConstructor(fooClass);
      ArrayList<EObject> _newArrayList = CollectionLiterals.<EObject>newArrayList(fooFunction, _inferredType, _inferredConstructor);
      for (final EObject it : _newArrayList) {
        String _string = it.toString();
        final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI element) {
            URI _uRI = EcoreUtil.getURI(it);
            return Boolean.valueOf(Objects.equal(element, _uRI));
          }
        };
        boolean _exists = IterableExtensions.<URI>exists(dependentElementURIs, _function);
        Assert.assertTrue(_string, _exists);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPolymorphicDispatch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Number it) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(String it) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile fooFile = this.testHelper.xtendFile("Foo", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      EList<XtendTypeDeclaration> _xtendTypes = fooFile.getXtendTypes();
      XtendTypeDeclaration _get = _xtendTypes.get(0);
      final XtendClass fooClass = ((XtendClass) _get);
      EList<XtendMember> _members = fooClass.getMembers();
      final XtendMember fooMethod1 = _members.get(1);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      final Iterable<URI> dependentElementURIs = this.dependentElementsCalculator.getDependentElementURIs(fooMethod1, _nullProgressMonitor);
      int _size = IterableExtensions.size(dependentElementURIs);
      Assert.assertEquals(5, _size);
      EList<XtendMember> _members_1 = fooClass.getMembers();
      JvmGenericType _inferredType = this.associations.getInferredType(fooClass);
      EList<JvmMember> _members_2 = _inferredType.getMembers();
      Iterable<EObject> _plus = Iterables.<EObject>concat(_members_1, _members_2);
      final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
        @Override
        public Boolean apply(final EObject it) {
          return Boolean.valueOf((!(it instanceof JvmConstructor)));
        }
      };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_plus, _function);
      List<EObject> _list = IterableExtensions.<EObject>toList(_filter);
      for (final EObject it : _list) {
        String _string = it.toString();
        final Function1<URI, Boolean> _function_1 = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI element) {
            URI _uRI = EcoreUtil.getURI(it);
            return Boolean.valueOf(Objects.equal(element, _uRI));
          }
        };
        boolean _exists = IterableExtensions.<URI>exists(dependentElementURIs, _function_1);
        Assert.assertTrue(_string, _exists);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
