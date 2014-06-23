package org.eclipse.xtext.example.tutorial.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.tutorial.tutorial.Entity;
import org.eclipse.xtext.example.tutorial.tutorial.Property;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Synthetic;

/**
 * <p>Translates entities to Java classes.</p>
 */
@SuppressWarnings("all")
public class TutorialJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  protected void _infer(final Entity entity, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexingPhase) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(entity);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(entity, _fullyQualifiedName);
    IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        String _documentation = TutorialJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(entity);
        TutorialJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
        EList<Property> _features = entity.getFeatures();
        for (final Property feature : _features) {
          TutorialJvmModelInferrer.this.addJavaBeansProperty(it, feature);
        }
      }
    };
    _accept.initializeLater(_function);
  }
  
  /**
   * Adds a field, a setter and a getter according to JavaBeans conventions for the given property.
   */
  public boolean addJavaBeansProperty(final JvmDeclaredType javaClass, final Property property) {
    boolean _xblockexpression = false;
    {
      EList<JvmMember> _members = javaClass.getMembers();
      String _name = property.getName();
      JvmTypeReference _type = property.getType();
      final Procedure1<JvmField> _function = new Procedure1<JvmField>() {
        public void apply(final JvmField it) {
          String _documentation = TutorialJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(property);
          TutorialJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
        }
      };
      JvmField _field = this._jvmTypesBuilder.toField(property, _name, _type, _function);
      this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
      EList<JvmMember> _members_1 = javaClass.getMembers();
      String _name_1 = property.getName();
      JvmTypeReference _type_1 = property.getType();
      JvmOperation _getter = this._jvmTypesBuilder.toGetter(property, _name_1, _type_1);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _getter);
      EList<JvmMember> _members_2 = javaClass.getMembers();
      String _name_2 = property.getName();
      JvmTypeReference _type_2 = property.getType();
      JvmOperation _setter = this._jvmTypesBuilder.toSetter(property, _name_2, _type_2);
      _xblockexpression = this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _setter);
    }
    return _xblockexpression;
  }
  
  @Synthetic
  public void infer(final EObject entity, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexingPhase) {
    if (entity instanceof Entity) {
      _infer((Entity)entity, acceptor, preIndexingPhase);
      return;
    } else if (entity != null) {
      _infer(entity, acceptor, preIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entity, acceptor, preIndexingPhase).toString());
    }
  }
}
