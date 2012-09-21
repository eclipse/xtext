package org.eclipse.xtend.macro.lang;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation;
import org.eclipse.xtend.macro.lang.macro.Processor;
import org.eclipse.xtend.macro.lang.macro.Registrator;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class MacroAnnotationExtensions {
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Inject
  private IResourceValidator _iResourceValidator;
  
  public Iterable<XtendField> getFields(final MacroAnnotation macro) {
    EList<XtendMember> _members = macro.getMembers();
    Iterable<XtendField> _filter = Iterables.<XtendField>filter(_members, XtendField.class);
    return _filter;
  }
  
  public String getQualifiedName(final MacroAnnotation it) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(it);
    String _string = _fullyQualifiedName.toString();
    return _string;
  }
  
  public Processor getProcessor(final MacroAnnotation macro) {
    EList<XtendMember> _members = macro.getMembers();
    Iterable<Processor> _filter = Iterables.<Processor>filter(_members, Processor.class);
    Processor _head = IterableExtensions.<Processor>head(_filter);
    return _head;
  }
  
  public String getProcessorClassName(final MacroAnnotation it) {
    String _qualifiedName = this.getQualifiedName(it);
    String _plus = (_qualifiedName + "Processor");
    return _plus;
  }
  
  public JvmGenericType getProcessorClass(final MacroAnnotation macro) {
    Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(macro);
    Iterable<JvmGenericType> _filter = Iterables.<JvmGenericType>filter(_jvmElements, JvmGenericType.class);
    final Function1<JvmGenericType,Boolean> _function = new Function1<JvmGenericType,Boolean>() {
        public Boolean apply(final JvmGenericType it) {
          String _identifier = it.getIdentifier();
          String _processorClassName = MacroAnnotationExtensions.this.getProcessorClassName(macro);
          boolean _equals = Objects.equal(_identifier, _processorClassName);
          return Boolean.valueOf(_equals);
        }
      };
    JvmGenericType _findFirst = IterableExtensions.<JvmGenericType>findFirst(_filter, _function);
    return _findFirst;
  }
  
  public Registrator getRegistrator(final MacroAnnotation macro) {
    EList<XtendMember> _members = macro.getMembers();
    Iterable<Registrator> _filter = Iterables.<Registrator>filter(_members, Registrator.class);
    Registrator _head = IterableExtensions.<Registrator>head(_filter);
    return _head;
  }
  
  public String getRegistratorClassName(final MacroAnnotation it) {
    String _qualifiedName = this.getQualifiedName(it);
    String _plus = (_qualifiedName + "Registrator");
    return _plus;
  }
  
  public JvmGenericType getRegistratorClass(final MacroAnnotation macro) {
    Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(macro);
    Iterable<JvmGenericType> _filter = Iterables.<JvmGenericType>filter(_jvmElements, JvmGenericType.class);
    final Function1<JvmGenericType,Boolean> _function = new Function1<JvmGenericType,Boolean>() {
        public Boolean apply(final JvmGenericType it) {
          String _identifier = it.getIdentifier();
          String _registratorClassName = MacroAnnotationExtensions.this.getRegistratorClassName(macro);
          boolean _equals = Objects.equal(_identifier, _registratorClassName);
          return Boolean.valueOf(_equals);
        }
      };
    JvmGenericType _findFirst = IterableExtensions.<JvmGenericType>findFirst(_filter, _function);
    return _findFirst;
  }
  
  public boolean hasErrors(final MacroAnnotation macro) {
    Resource _eResource = macro.eResource();
    final List<Issue> issues = this._iResourceValidator.validate(_eResource, CheckMode.ALL, CancelIndicator.NullImpl);
    final Function1<Issue,Boolean> _function = new Function1<Issue,Boolean>() {
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          boolean _equals = Objects.equal(_severity, Severity.ERROR);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter);
    return (!_isEmpty);
  }
}
