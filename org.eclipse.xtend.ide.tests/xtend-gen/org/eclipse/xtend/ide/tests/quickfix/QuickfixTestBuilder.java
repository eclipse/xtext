/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.quickfix;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.annotations.validation.UnresolvedFeatureCallTypeAwareMessageProvider;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.ui.builder.XbaseBuilderPreferenceAccess;
import org.junit.Assert;

@SuppressWarnings("all")
public class QuickfixTestBuilder {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;

  @Inject
  @Extension
  private IssueResolutionProvider _issueResolutionProvider;

  @Inject
  @Extension
  private IResourceValidator _iResourceValidator;

  @Inject
  @Extension
  private SyncUtil _syncUtil;

  @Inject
  private IPreferenceStoreAccess preferenceStoreAccess;

  @Inject
  private XbaseBuilderPreferenceAccess xbaseBuilderPreferenceAccess;

  private int caretOffset;

  private XtextEditor editor;

  private List<Issue> issues;

  private Set<String> modifiedIssueCodes;

  private final String primaryPositionMarker = "<|>";

  private final String secondaryPositionMarker = "|";

  private IPersistentPreferenceStore getPreferenceStore() {
    IPreferenceStore _writablePreferenceStore = this.preferenceStoreAccess.getWritablePreferenceStore(this._workbenchTestHelper.getProject());
    return ((IPersistentPreferenceStore) _writablePreferenceStore);
  }

  public void setSeverity(final String issueCode, final String severity) {
    if ((this.modifiedIssueCodes == null)) {
      this.modifiedIssueCodes = CollectionLiterals.<String>newHashSet();
    }
    this.modifiedIssueCodes.add(issueCode);
    this.getPreferenceStore().setValue(issueCode, "error");
  }

  public void setJavaVersion(final JavaVersion javaVersion) {
    this.xbaseBuilderPreferenceAccess.setJavaVersion(this._workbenchTestHelper.getProject(), javaVersion);
  }

  public QuickfixTestBuilder create(final String fileName, final String model) {
    try {
      QuickfixTestBuilder _xblockexpression = null;
      {
        final String positionMarker = this.getPositionMarker(model);
        final IFile file = this._workbenchTestHelper.createFile(fileName, model.replace(positionMarker, ""));
        this.editor = this.openEditorSafely(file);
        final IXtextDocument document = this.editor.getDocument();
        Assert.assertNotNull("Error getting document from editor", document);
        final IUnitOfWork<List<Issue>, XtextResource> _function = (XtextResource it) -> {
          return this.issues = this._iResourceValidator.validate(it, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
        };
        document.<List<Issue>>readOnly(_function);
        this.caretOffset = model.indexOf(positionMarker);
        _xblockexpression = this;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public QuickfixTestBuilder caretOffset(final int offset) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      this.caretOffset = offset;
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  public QuickfixTestBuilder assertIssueCodes(final String... issueCodes) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      final Function1<Issue, String> _function = (Issue it) -> {
        return it.getCode();
      };
      this.assertEqual(((List<String>)Conversions.doWrapArray(issueCodes)), IterableExtensions.<Issue, String>map(this.getIssuesAtCaret(), _function));
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  public QuickfixTestBuilder assertFeatureCallLinkingIssue() {
    QuickfixTestBuilder _xblockexpression = null;
    {
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        return Boolean.valueOf((Objects.equals(it.getCode(), Diagnostic.LINKING_DIAGNOSTIC) && 
          ArrayExtensions.contains(it.getData(), UnresolvedFeatureCallTypeAwareMessageProvider.FEATURE_CALL)));
      };
      Assert.assertTrue(IterableExtensions.<Issue>exists(this.getIssuesAtCaret(), _function));
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  public QuickfixTestBuilder assertTypeLiteralLinkingIssue() {
    QuickfixTestBuilder _xblockexpression = null;
    {
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        return Boolean.valueOf((Objects.equals(it.getCode(), Diagnostic.LINKING_DIAGNOSTIC) && 
          ArrayExtensions.contains(it.getData(), UnresolvedFeatureCallTypeAwareMessageProvider.TYPE_LITERAL)));
      };
      Assert.assertTrue(IterableExtensions.<Issue>exists(this.getIssuesAtCaret(), _function));
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  public QuickfixTestBuilder assertResolutionLabels(final String... resolutionLabels) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      final Function1<Issue, List<IssueResolution>> _function = (Issue it) -> {
        return this._issueResolutionProvider.getResolutions(it);
      };
      final Iterable<IssueResolution> resolutions = Iterables.<IssueResolution>concat(IterableExtensions.<Issue, List<IssueResolution>>map(this.getIssuesAtCaret(), _function));
      final Function1<IssueResolution, String> _function_1 = (IssueResolution it) -> {
        return it.getLabel();
      };
      this.assertEqual(((List<String>)Conversions.doWrapArray(resolutionLabels)), IterableExtensions.<IssueResolution, String>map(resolutions, _function_1));
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  public QuickfixTestBuilder assertResolutionLabelsSubset(final String... expectedLabels) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      final Function1<Issue, List<IssueResolution>> _function = (Issue it) -> {
        return this._issueResolutionProvider.getResolutions(it);
      };
      final Function1<IssueResolution, String> _function_1 = (IssueResolution it) -> {
        return it.getLabel();
      };
      final Set<String> actualLabels = IterableExtensions.<String>toSet(IterableExtensions.<IssueResolution, String>map(Iterables.<IssueResolution>concat(IterableExtensions.<Issue, List<IssueResolution>>map(this.getIssuesAtCaret(), _function)), _function_1));
      final Consumer<String> _function_2 = (String it) -> {
        String _join = IterableExtensions.join(actualLabels, ", ");
        String _plus = ((("Label \'" + it) + "\' missing. Got ") + _join);
        Assert.assertTrue(_plus, actualLabels.contains(it));
      };
      ((List<String>)Conversions.doWrapArray(expectedLabels)).forEach(_function_2);
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  public QuickfixTestBuilder assertNoResolutionLabels(final String... unExpectedLabels) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      final Function1<Issue, List<IssueResolution>> _function = (Issue it) -> {
        return this._issueResolutionProvider.getResolutions(it);
      };
      final Function1<IssueResolution, String> _function_1 = (IssueResolution it) -> {
        return it.getLabel();
      };
      final Set<String> actualLabels = IterableExtensions.<String>toSet(IterableExtensions.<IssueResolution, String>map(Iterables.<IssueResolution>concat(IterableExtensions.<Issue, List<IssueResolution>>map(this.getIssuesAtCaret(), _function)), _function_1));
      final Consumer<String> _function_2 = (String it) -> {
        String _join = IterableExtensions.join(actualLabels, ", ");
        String _plus = ((("Label \'" + it) + "\' should not appear. Got ") + _join);
        Assert.assertFalse(_plus, actualLabels.contains(it));
      };
      ((List<String>)Conversions.doWrapArray(unExpectedLabels)).forEach(_function_2);
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  public QuickfixTestBuilder assertModelAfterQuickfix(final CharSequence expectedModel) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      final Function1<Issue, List<IssueResolution>> _function = (Issue it) -> {
        return this._issueResolutionProvider.getResolutions(it);
      };
      final List<IssueResolution> resolutions = IterableExtensions.<IssueResolution>toList(Iterables.<IssueResolution>concat(IterableExtensions.<Issue, List<IssueResolution>>map(this.getIssuesAtCaret(), _function)));
      final String originalModel = this.editor.getDocument().get();
      final IssueResolution resolution = IterableExtensions.<IssueResolution>head(resolutions);
      Assert.assertNotNull(resolution);
      resolution.apply();
      Assert.assertEquals(expectedModel.toString(), this.editor.getDocument().get());
      this.editor.getDocument().set(originalModel);
      this._syncUtil.waitForReconciler(this.editor);
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  public QuickfixTestBuilder assertModelAfterQuickfix(final String label, final CharSequence expectedModel) {
    QuickfixTestBuilder _xblockexpression = null;
    {
      final Function1<Issue, List<IssueResolution>> _function = (Issue it) -> {
        return this._issueResolutionProvider.getResolutions(it);
      };
      final List<IssueResolution> resolutions = IterableExtensions.<IssueResolution>toList(Iterables.<IssueResolution>concat(IterableExtensions.<Issue, List<IssueResolution>>map(this.getIssuesAtCaret(), _function)));
      final String originalModel = this.editor.getDocument().get();
      final Function1<IssueResolution, Boolean> _function_1 = (IssueResolution it) -> {
        String _label = it.getLabel();
        return Boolean.valueOf(Objects.equals(_label, label));
      };
      final IssueResolution matchingResolution = IterableExtensions.<IssueResolution>findFirst(resolutions, _function_1);
      final Function1<IssueResolution, String> _function_2 = (IssueResolution it) -> {
        return label;
      };
      Assert.assertNotNull(this.error(CollectionLiterals.<String>newArrayList(label), ListExtensions.<IssueResolution, String>map(resolutions, _function_2)), matchingResolution);
      matchingResolution.apply();
      Assert.assertEquals(expectedModel.toString(), this.editor.getDocument().get());
      this.editor.getDocument().set(originalModel);
      this._syncUtil.waitForReconciler(this.editor);
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  protected XtextEditor getEditor() {
    return this.editor;
  }

  protected Iterable<Issue> getIssuesAtCaret() {
    final Function1<Issue, Boolean> _function = (Issue it) -> {
      return Boolean.valueOf((((it.getOffset()).intValue() <= this.caretOffset) && (((it.getOffset()).intValue() + (it.getLength()).intValue()) >= this.caretOffset)));
    };
    return IterableExtensions.<Issue>filter(this.issues, _function);
  }

  protected void assertEqual(final List<String> expected, final Iterable<String> actual) {
    Assert.assertEquals(IterableExtensions.join(IterableExtensions.<String>sort(expected), "\n"), IterableExtensions.join(IterableExtensions.<String>sort(actual), "\n"));
  }

  protected String error(final Iterable<String> expected, final Iterable<String> actual) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Expected ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'");
    String _join = IterableExtensions.join(expected, ", ");
    _builder.append(_join, "\t");
    _builder.append("\'  ");
    _builder.newLineIfNotEmpty();
    _builder.append("but got ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'");
    String _join_1 = IterableExtensions.join(actual, ", ");
    _builder.append(_join_1, "\t");
    _builder.append("\'");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  protected XtextEditor openEditorSafely(final IFile file) throws Exception {
    XtextEditor _xblockexpression = null;
    {
      final NullProgressMonitor monitor = new NullProgressMonitor();
      this._syncUtil.waitForBuild(monitor);
      this._syncUtil.yieldToQueuedDisplayJobs(monitor);
      XtextEditor editor = this._workbenchTestHelper.openEditor(file);
      this._syncUtil.waitForReconciler(editor);
      this._syncUtil.yieldToQueuedDisplayJobs(monitor);
      _xblockexpression = editor;
    }
    return _xblockexpression;
  }

  protected String getPositionMarker(final String model) {
    int _count = this.count(model, this.primaryPositionMarker);
    boolean _equals = (_count == 1);
    if (_equals) {
      return this.primaryPositionMarker;
    } else {
      int _count_1 = this.count(model, this.secondaryPositionMarker);
      boolean _equals_1 = (_count_1 == 1);
      if (_equals_1) {
        return this.secondaryPositionMarker;
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(this.primaryPositionMarker);
        _builder.append(" may be used to disambiguate ordinary ");
        _builder.append(this.secondaryPositionMarker);
        _builder.append(" from a position marker!");
        Assert.fail(_builder.toString());
      }
    }
    return null;
  }

  protected int count(final String model, final String positionMarker) {
    int _xblockexpression = (int) 0;
    {
      final String regex = Pattern.quote(positionMarker);
      int _length = model.split(regex).length;
      _xblockexpression = (_length - 1);
    }
    return _xblockexpression;
  }

  public void tearDown() {
    this.editor = null;
    this._workbenchTestHelper.closeAllEditors(false);
    final Consumer<IFile> _function = (IFile it) -> {
      try {
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        it.delete(true, _nullProgressMonitor);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this._workbenchTestHelper.getFiles().forEach(_function);
    this._workbenchTestHelper.getFiles().clear();
    if ((this.modifiedIssueCodes != null)) {
      IPersistentPreferenceStore _preferenceStore = this.getPreferenceStore();
      final Procedure1<IPersistentPreferenceStore> _function_1 = (IPersistentPreferenceStore it) -> {
        final Consumer<String> _function_2 = (String code) -> {
          it.setToDefault(code);
        };
        this.modifiedIssueCodes.forEach(_function_2);
        it.setToDefault(XbaseBuilderPreferenceAccess.PREF_USE_COMPILER_SOURCE);
        it.setToDefault(XbaseBuilderPreferenceAccess.PREF_JAVA_VERSION);
      };
      ObjectExtensions.<IPersistentPreferenceStore>operator_doubleArrow(_preferenceStore, _function_1);
      this.modifiedIssueCodes = null;
    }
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this._syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor);
  }

  public QuickfixTestBuilder removeFile(final String fileName) {
    try {
      QuickfixTestBuilder _xblockexpression = null;
      {
        IFile _file = this._workbenchTestHelper.getFile(fileName);
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
        _xblockexpression = this;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
