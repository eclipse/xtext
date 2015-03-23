package org.eclipse.xtext.idea.build.incremental;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.idea.build.incremental.IdeaBuildData;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.jetbrains.jps.incremental.messages.CompilerMessage;

@SuppressWarnings("all")
public class IdeaIssueHandler implements IIssueHandler {
  @Accessors
  private IdeaBuildData buildData;
  
  @Override
  public boolean handleIssue(final Iterable<Issue> issues) {
    boolean errorFree = true;
    final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
      @Override
      public Boolean apply(final Issue it) {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf((!Objects.equal(_severity, Severity.IGNORE)));
      }
    };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function);
    for (final Issue it : _filter) {
      {
        CompileContext _context = this.buildData.getContext();
        String _compilerName = this.buildData.getCompilerName();
        BuildMessage.Kind _kind = this.getKind(it);
        String _message = it.getMessage();
        URI _uriToProblem = it.getUriToProblem();
        String _path = _uriToProblem.path();
        Integer _offset = it.getOffset();
        Integer _offset_1 = it.getOffset();
        Integer _length = it.getLength();
        int _plus = ((_offset_1).intValue() + (_length).intValue());
        Integer _offset_2 = it.getOffset();
        Integer _lineNumber = it.getLineNumber();
        CompilerMessage _compilerMessage = new CompilerMessage(_compilerName, _kind, _message, _path, (_offset).intValue(), _plus, (_offset_2).intValue(), (_lineNumber).intValue(), 0);
        _context.processMessage(_compilerMessage);
        boolean _and = false;
        if (!errorFree) {
          _and = false;
        } else {
          Severity _severity = it.getSeverity();
          boolean _notEquals = (!Objects.equal(_severity, Severity.ERROR));
          _and = _notEquals;
        }
        errorFree = _and;
      }
    }
    return errorFree;
  }
  
  private BuildMessage.Kind getKind(final Issue issue) {
    BuildMessage.Kind _switchResult = null;
    Severity _severity = issue.getSeverity();
    if (_severity != null) {
      switch (_severity) {
        case ERROR:
          _switchResult = BuildMessage.Kind.ERROR;
          break;
        case WARNING:
          _switchResult = BuildMessage.Kind.WARNING;
          break;
        case INFO:
          _switchResult = BuildMessage.Kind.INFO;
          break;
        case IGNORE:
          _switchResult = BuildMessage.Kind.PROGRESS;
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  @Pure
  public IdeaBuildData getBuildData() {
    return this.buildData;
  }
  
  public void setBuildData(final IdeaBuildData buildData) {
    this.buildData = buildData;
  }
}
