package org.eclipse.xtend.ide.tests.quickfix;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

@SuppressWarnings("all")
public class QuickfixTestBuilder {
  @Inject
  private WorkbenchTestHelper _workbenchTestHelper;
  
  @Inject
  private IssueResolutionProvider _issueResolutionProvider;
  
  @Inject
  private IResourceValidator _iResourceValidator;
  
  @Inject
  private SyncUtil _syncUtil;
  
  private int caretOffset;
  
  private IFile file;
  
  private XtextEditor editor;
  
  private List<Issue> issues;
  
  public QuickfixTestBuilder create(final String fileName, final CharSequence model) {
    try {
      QuickfixTestBuilder _xblockexpression = null;
      {
        String _string = model.toString();
        String _replace = _string.replace("|", "");
        final IFile file = this._workbenchTestHelper.createFile(fileName, _replace);
        XtextEditor _openEditorSafely = this.openEditorSafely(file);
        this.editor = _openEditorSafely;
        final IXtextDocument document = this.editor.getDocument();
        final Function1<XtextResource,List<Issue>> _function = new Function1<XtextResource,List<Issue>>() {
            public List<Issue> apply(final XtextResource it) {
              List<Issue> _validate = QuickfixTestBuilder.this._iResourceValidator.validate(it, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
              List<Issue> _issues = QuickfixTestBuilder.this.issues = _validate;
              return _issues;
            }
          };
        document.<List<Issue>>readOnly(new IUnitOfWork<List<Issue>,XtextResource>() {
            public List<Issue> exec(XtextResource state) {
              return _function.apply(state);
            }
        });
        String _string_1 = model.toString();
        int _indexOf = _string_1.indexOf("|");
        this.caretOffset = _indexOf;
        _xblockexpression = (this);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public QuickfixTestBuilder caretOffset(final int offset) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      this.caretOffset = offset;
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public QuickfixTestBuilder assertIssueCodes(final String... issueCodes) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      Iterable<Issue> _issuesAtCaret = this.getIssuesAtCaret();
      final Function1<Issue,String> _function = new Function1<Issue,String>() {
          public String apply(final Issue it) {
            String _code = it.getCode();
            return _code;
          }
        };
      Iterable<String> _map = IterableExtensions.<Issue, String>map(_issuesAtCaret, _function);
      this.assertEqual(((List<String>)Conversions.doWrapArray(issueCodes)), _map);
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public QuickfixTestBuilder assertResolutionLabels(final String... resolutionLabels) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      Iterable<Issue> _issuesAtCaret = this.getIssuesAtCaret();
      final Function1<Issue,List<IssueResolution>> _function = new Function1<Issue,List<IssueResolution>>() {
          public List<IssueResolution> apply(final Issue it) {
            List<IssueResolution> _resolutions = QuickfixTestBuilder.this._issueResolutionProvider.getResolutions(it);
            return _resolutions;
          }
        };
      Iterable<List<IssueResolution>> _map = IterableExtensions.<Issue, List<IssueResolution>>map(_issuesAtCaret, _function);
      final Iterable<IssueResolution> resolutions = Iterables.<IssueResolution>concat(_map);
      final Function1<IssueResolution,String> _function_1 = new Function1<IssueResolution,String>() {
          public String apply(final IssueResolution it) {
            String _label = it.getLabel();
            return _label;
          }
        };
      Iterable<String> _map_1 = IterableExtensions.<IssueResolution, String>map(resolutions, _function_1);
      this.assertEqual(((List<String>)Conversions.doWrapArray(resolutionLabels)), _map_1);
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public QuickfixTestBuilder assertResolutionLabelsSubset(final String... expectedLabels) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      Iterable<Issue> _issuesAtCaret = this.getIssuesAtCaret();
      final Function1<Issue,List<IssueResolution>> _function = new Function1<Issue,List<IssueResolution>>() {
          public List<IssueResolution> apply(final Issue it) {
            List<IssueResolution> _resolutions = QuickfixTestBuilder.this._issueResolutionProvider.getResolutions(it);
            return _resolutions;
          }
        };
      Iterable<List<IssueResolution>> _map = IterableExtensions.<Issue, List<IssueResolution>>map(_issuesAtCaret, _function);
      Iterable<IssueResolution> _flatten = Iterables.<IssueResolution>concat(_map);
      final Function1<IssueResolution,String> _function_1 = new Function1<IssueResolution,String>() {
          public String apply(final IssueResolution it) {
            String _label = it.getLabel();
            return _label;
          }
        };
      Iterable<String> _map_1 = IterableExtensions.<IssueResolution, String>map(_flatten, _function_1);
      final Set<String> actualLabels = IterableExtensions.<String>toSet(_map_1);
      final Procedure1<String> _function_2 = new Procedure1<String>() {
          public void apply(final String it) {
            String _plus = ("Label \'" + it);
            String _plus_1 = (_plus + "\' missing");
            boolean _contains = actualLabels.contains(it);
            Assert.assertTrue(_plus_1, _contains);
          }
        };
      IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(expectedLabels)), _function_2);
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public QuickfixTestBuilder assertModelAfterQuickfix(final CharSequence expectedModel) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      Iterable<Issue> _issuesAtCaret = this.getIssuesAtCaret();
      final Function1<Issue,List<IssueResolution>> _function = new Function1<Issue,List<IssueResolution>>() {
          public List<IssueResolution> apply(final Issue it) {
            List<IssueResolution> _resolutions = QuickfixTestBuilder.this._issueResolutionProvider.getResolutions(it);
            return _resolutions;
          }
        };
      Iterable<List<IssueResolution>> _map = IterableExtensions.<Issue, List<IssueResolution>>map(_issuesAtCaret, _function);
      Iterable<IssueResolution> _flatten = Iterables.<IssueResolution>concat(_map);
      final List<IssueResolution> resolutions = IterableExtensions.<IssueResolution>toList(_flatten);
      IXtextDocument _document = this.editor.getDocument();
      final String originalModel = _document.get();
      IssueResolution _head = IterableExtensions.<IssueResolution>head(resolutions);
      _head.apply();
      String _string = expectedModel.toString();
      IXtextDocument _document_1 = this.editor.getDocument();
      String _get = _document_1.get();
      Assert.assertEquals(_string, _get);
      IXtextDocument _document_2 = this.editor.getDocument();
      _document_2.set(originalModel);
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  public QuickfixTestBuilder assertModelAfterQuickfix(final String label, final CharSequence expectedModel) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      Iterable<Issue> _issuesAtCaret = this.getIssuesAtCaret();
      final Function1<Issue,List<IssueResolution>> _function = new Function1<Issue,List<IssueResolution>>() {
          public List<IssueResolution> apply(final Issue it) {
            List<IssueResolution> _resolutions = QuickfixTestBuilder.this._issueResolutionProvider.getResolutions(it);
            return _resolutions;
          }
        };
      Iterable<List<IssueResolution>> _map = IterableExtensions.<Issue, List<IssueResolution>>map(_issuesAtCaret, _function);
      Iterable<IssueResolution> _flatten = Iterables.<IssueResolution>concat(_map);
      final List<IssueResolution> resolutions = IterableExtensions.<IssueResolution>toList(_flatten);
      IXtextDocument _document = this.editor.getDocument();
      final String originalModel = _document.get();
      final Function1<IssueResolution,Boolean> _function_1 = new Function1<IssueResolution,Boolean>() {
          public Boolean apply(final IssueResolution it) {
            String _label = it.getLabel();
            boolean _equals = ObjectExtensions.operator_equals(_label, label);
            return Boolean.valueOf(_equals);
          }
        };
      IssueResolution _findFirst = IterableExtensions.<IssueResolution>findFirst(resolutions, _function_1);
      _findFirst.apply();
      String _string = expectedModel.toString();
      IXtextDocument _document_1 = this.editor.getDocument();
      String _get = _document_1.get();
      Assert.assertEquals(_string, _get);
      IXtextDocument _document_2 = this.editor.getDocument();
      _document_2.set(originalModel);
      _xblockexpression = (this);
    }
    return _xblockexpression;
  }
  
  protected Iterable<Issue> getIssuesAtCaret() {
    final Function1<Issue,Boolean> _function = new Function1<Issue,Boolean>() {
        public Boolean apply(final Issue it) {
          boolean _and = false;
          Integer _offset = it.getOffset();
          boolean _lessEqualsThan = ((_offset).intValue() <= QuickfixTestBuilder.this.caretOffset);
          if (!_lessEqualsThan) {
            _and = false;
          } else {
            Integer _offset_1 = it.getOffset();
            Integer _length = it.getLength();
            int _plus = ((_offset_1).intValue() + (_length).intValue());
            boolean _greaterEqualsThan = (_plus >= QuickfixTestBuilder.this.caretOffset);
            _and = (_lessEqualsThan && _greaterEqualsThan);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Issue> _filter = IterableExtensions.<Issue>filter(this.issues, _function);
    return _filter;
  }
  
  protected void assertEqual(final List<String> expected, final Iterable<String> actual) {
    String _error = this.error(expected, actual);
    int _size = expected.size();
    int _size_1 = IterableExtensions.size(actual);
    Assert.assertEquals(_error, _size, _size_1);
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          String _error = QuickfixTestBuilder.this.error(expected, actual);
          boolean _contains = expected.contains(it);
          Assert.assertTrue(_error, _contains);
        }
      };
    IterableExtensions.<String>forEach(actual, _function);
  }
  
  protected String error(final Iterable<String> expected, final Iterable<String> actual) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Expected ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'");
    String _join = IterableExtensions.join(expected, ", ");
    _builder.append(_join, "	");
    _builder.append("\'  ");
    _builder.newLineIfNotEmpty();
    _builder.append("but got ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'");
    String _join_1 = IterableExtensions.join(actual, ", ");
    _builder.append(_join_1, "	");
    _builder.append("\'");
    _builder.newLineIfNotEmpty();
    String _string = _builder.toString();
    return _string;
  }
  
  protected XtextEditor openEditorSafely(final IFile file) throws Exception {
    XtextEditor _xblockexpression = null;
    {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      this._syncUtil.waitForAutoBuild(_nullProgressMonitor);
      this._syncUtil.yieldToQueuedDisplayJobs(null);
      XtextEditor editor = this._workbenchTestHelper.openEditor(file);
      this._syncUtil.waitForReconciler(editor);
      this._syncUtil.yieldToQueuedDisplayJobs(null);
      _xblockexpression = (editor);
    }
    return _xblockexpression;
  }
  
  public void tearDown() {
    try {
      boolean _notEquals = ObjectExtensions.operator_notEquals(this.editor, null);
      if (_notEquals) {
        this.editor.close(false);
      }
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(this.file, null);
      if (_notEquals_1) {
        this.file.delete(true, null);
      }
      this._syncUtil.yieldToQueuedDisplayJobs(null);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
