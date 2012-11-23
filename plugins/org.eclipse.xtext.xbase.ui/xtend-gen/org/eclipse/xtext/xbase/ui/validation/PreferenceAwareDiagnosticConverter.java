package org.eclipse.xtext.xbase.ui.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.validation.IssueCodes;

@SuppressWarnings("all")
public class PreferenceAwareDiagnosticConverter extends DiagnosticConverterImpl {
  @Inject
  private IJavaProjectProvider projectProvider;
  
  private final Map<String,String> issueCodeToJavaCoreCode;
  
  public PreferenceAwareDiagnosticConverter() {
    Map<String,String> _issueCodeToJavaCoreCodeMap = this.getIssueCodeToJavaCoreCodeMap();
    this.issueCodeToJavaCoreCode = _issueCodeToJavaCoreCodeMap;
  }
  
  public Map<String,String> getIssueCodeToJavaCoreCodeMap() {
    Pair<String,String> _mappedTo = Pair.<String, String>of(IssueCodes.FORBIDDEN_REFERENCE, JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE);
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of(IssueCodes.DISCOURAGED_REFERENCE, JavaCore.COMPILER_PB_DISCOURAGED_REFERENCE);
    HashMap<String,String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1);
    return _newHashMap;
  }
  
  protected Severity getSeverity(final Diagnostic diagnostic) {
    final Severity original = super.getSeverity(diagnostic);
    boolean _equals = ObjectExtensions.operator_equals(original, null);
    if (_equals) {
      return null;
    }
    final String issueCode = this.getIssueCode(diagnostic);
    final String javaCoreCode = this.issueCodeToJavaCoreCode.get(issueCode);
    boolean _equals_1 = ObjectExtensions.operator_equals(javaCoreCode, null);
    if (_equals_1) {
      return original;
    }
    final EObject object = this.getCauser(diagnostic);
    Resource _eResource = object==null?(Resource)null:object.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    boolean _equals_2 = ObjectExtensions.operator_equals(_resourceSet, null);
    if (_equals_2) {
      return original;
    }
    Resource _eResource_1 = object.eResource();
    ResourceSet _resourceSet_1 = _eResource_1.getResourceSet();
    final IJavaProject project = this.projectProvider.getJavaProject(_resourceSet_1);
    final String jdtSeverity = project.getOption(javaCoreCode, true);
    Severity _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(jdtSeverity,"error")) {
        _matched=true;
        _switchResult = Severity.ERROR;
      }
    }
    if (!_matched) {
      if (Objects.equal(jdtSeverity,"warning")) {
        _matched=true;
        _switchResult = Severity.WARNING;
      }
    }
    if (!_matched) {
      if (Objects.equal(jdtSeverity,"ignore")) {
        _matched=true;
        _switchResult = null;
      }
    }
    return _switchResult;
  }
}
