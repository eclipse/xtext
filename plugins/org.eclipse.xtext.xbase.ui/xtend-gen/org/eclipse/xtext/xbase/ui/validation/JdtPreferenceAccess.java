package org.eclipse.xtext.xbase.ui.validation;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class JdtPreferenceAccess {
  private List<IScopeContext> lookupOrder;
  
  public JdtPreferenceAccess(final IJavaProject project) {
    IProject _project = project.getProject();
    ProjectScope _projectScope = new ProjectScope(_project);
    InstanceScope _instanceScope = new InstanceScope();
    DefaultScope _defaultScope = new DefaultScope();
    ArrayList<IScopeContext> _newArrayList = CollectionLiterals.<IScopeContext>newArrayList(_projectScope, _instanceScope, _defaultScope);
    this.lookupOrder = _newArrayList;
  }
  
  public Severity getSeverity(final String key) {
    for (final IScopeContext ctx : this.lookupOrder) {
      {
        IEclipsePreferences _node = ctx.getNode(JavaCore.PLUGIN_ID);
        final String result = _node.get(key, null);
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(result,"warning")) {
            _matched=true;
            return Severity.WARNING;
          }
        }
        if (!_matched) {
          if (Objects.equal(result,"error")) {
            _matched=true;
            return Severity.ERROR;
          }
        }
      }
    }
    return null;
  }
}
