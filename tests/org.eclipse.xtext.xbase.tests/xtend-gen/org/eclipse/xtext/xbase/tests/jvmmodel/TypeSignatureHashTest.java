package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.jvmmodel.JvmDeclaredTypeSignatureHashProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * The remaining tests are in xtend.core.tests, as it is a lot easier to specify JvmModels in Xtend ;-)
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeSignatureHashTest extends AbstractXbaseTestCase {
  @Inject
  private JvmDeclaredTypeSignatureHashProvider _jvmDeclaredTypeSignatureHashProvider;
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Test
  public void testSubType() {
    final EObject eObject = EcoreFactory.eINSTANCE.createEObject();
    final JvmGenericType bar = this._jvmTypesBuilder.toClass(eObject, "Bar");
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          EList<JvmMember> _members = it.getMembers();
          _members.add(bar);
        }
      };
    final JvmGenericType foo = this._jvmTypesBuilder.toClass(eObject, "Foo", _function);
    final String hash = this._jvmDeclaredTypeSignatureHashProvider.getHash(foo);
    EList<JvmMember> _members = bar.getMembers();
    final Procedure1<JvmConstructor> _function_1 = new Procedure1<JvmConstructor>() {
        public void apply(final JvmConstructor it) {
        }
      };
    JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(eObject, _function_1);
    _members.add(_constructor);
    String _hash = this._jvmDeclaredTypeSignatureHashProvider.getHash(foo);
    Assert.assertEquals(hash, _hash);
    bar.setSimpleName("Baz");
    String _hash_1 = this._jvmDeclaredTypeSignatureHashProvider.getHash(foo);
    boolean _equals = Objects.equal(hash, _hash_1);
    Assert.assertFalse("Expected different hashes", _equals);
  }
}
