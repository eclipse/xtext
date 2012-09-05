package org.eclipse.xtext.xbase.tests.resources;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XbaseResourceDescriptionStrategyTest extends AbstractXbaseTestCase {
  @Inject
  private XbaseResourceDescriptionStrategy descriptionStrategy;
  
  @Test
  public void testInterfaceDescription_01() {
    final JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
    interfaceType.setInterface(true);
    interfaceType.setPackageName("foo");
    interfaceType.setSimpleName("MyType");
    final ArrayList<IEObjectDescription> list = CollectionLiterals.<IEObjectDescription>newArrayList();
    final Procedure1<IEObjectDescription> _function = new Procedure1<IEObjectDescription>() {
        public void apply(final IEObjectDescription it) {
          list.add(it);
        }
      };
    this.descriptionStrategy.createEObjectDescriptions(interfaceType, new IAcceptor<IEObjectDescription>() {
        public void accept(IEObjectDescription t) {
          _function.apply(t);
        }
    });
    final Function1<IEObjectDescription,Boolean> _function_1 = new Function1<IEObjectDescription,Boolean>() {
        public Boolean apply(final IEObjectDescription it) {
          String _userData = it.getUserData(XbaseResourceDescriptionStrategy.IS_INTERFACE);
          boolean _equals = Objects.equal("true", _userData);
          return Boolean.valueOf(_equals);
        }
      };
    boolean _exists = IterableExtensions.<IEObjectDescription>exists(list, _function_1);
    Assert.assertTrue(_exists);
  }
  
  @Test
  public void testInterfaceDescription_02() {
    final JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
    interfaceType.setInterface(false);
    interfaceType.setPackageName("foo");
    interfaceType.setSimpleName("MyType");
    final ArrayList<IEObjectDescription> list = CollectionLiterals.<IEObjectDescription>newArrayList();
    final Procedure1<IEObjectDescription> _function = new Procedure1<IEObjectDescription>() {
        public void apply(final IEObjectDescription it) {
          list.add(it);
        }
      };
    this.descriptionStrategy.createEObjectDescriptions(interfaceType, new IAcceptor<IEObjectDescription>() {
        public void accept(IEObjectDescription t) {
          _function.apply(t);
        }
    });
    final Function1<IEObjectDescription,Boolean> _function_1 = new Function1<IEObjectDescription,Boolean>() {
        public Boolean apply(final IEObjectDescription it) {
          String _userData = it.getUserData(XbaseResourceDescriptionStrategy.IS_INTERFACE);
          boolean _equals = Objects.equal("true", _userData);
          return Boolean.valueOf(_equals);
        }
      };
    boolean _exists = IterableExtensions.<IEObjectDescription>exists(list, _function_1);
    Assert.assertFalse(_exists);
  }
}
