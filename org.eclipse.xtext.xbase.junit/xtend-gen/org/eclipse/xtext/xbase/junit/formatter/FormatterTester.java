package org.eclipse.xtext.xbase.junit.formatter;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.formatting.AbstractFormatter;
import org.eclipse.xtext.xbase.formatting.IBasicFormatter;
import org.eclipse.xtext.xbase.formatting.TextReplacement;
import org.eclipse.xtext.xbase.junit.formatter.AssertingFormatterData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;

/**
 * @deprecated use org.eclipse.xtext.junit4.formatter.FormatterTester
 */
@Deprecated
@SuppressWarnings("all")
public class FormatterTester {
  @Inject
  @Extension
  private ParseHelper<EObject> _parseHelper;
  
  @Inject
  private IBasicFormatter formatter;
  
  @SuppressWarnings("unchecked")
  public void assertFormatted(final Procedure1<? super AssertingFormatterData> init) {
    final AssertingFormatterData data = new AssertingFormatterData();
    HashMap<String, String> _newHashMap = CollectionLiterals.<String, String>newHashMap();
    MapBasedPreferenceValues _mapBasedPreferenceValues = new MapBasedPreferenceValues(_newHashMap);
    data.setConfig(_mapBasedPreferenceValues);
    init.apply(data);
    this.assertFormatted(data);
  }
  
  public void assertFormatted(final AssertingFormatterData it) {
    try {
      String _prefix = it.getPrefix();
      CharSequence _toBeFormatted = it.getToBeFormatted();
      String _plus = (_prefix + _toBeFormatted);
      String _postfix = it.getPostfix();
      final String fullToBeParsed = (_plus + _postfix);
      final EObject parsed = this._parseHelper.parse(fullToBeParsed);
      boolean _isAllowErrors = it.isAllowErrors();
      boolean _not = (!_isAllowErrors);
      if (_not) {
        Assert.assertEquals(IterableExtensions.join(parsed.eResource().getErrors(), "\n"), 0, parsed.eResource().getErrors().size());
      }
      Resource _eResource = parsed.eResource();
      IParseResult _parseResult = ((XtextResource) _eResource).getParseResult();
      ICompositeNode _rootNode = null;
      if (_parseResult!=null) {
        _rootNode=_parseResult.getRootNode();
      }
      String _text = null;
      if (_rootNode!=null) {
        _text=_rootNode.getText();
      }
      final String oldDocument = _text;
      final IBasicFormatter formatter = this.formatter;
      boolean _matched = false;
      if (formatter instanceof AbstractFormatter) {
        _matched=true;
        ((AbstractFormatter)this.formatter).setAllowIdentityEdits(true);
      }
      final int start = it.getPrefix().length();
      final int length = it.getToBeFormatted().length();
      final LinkedHashSet<TextReplacement> edits = CollectionLiterals.<TextReplacement>newLinkedHashSet();
      Resource _eResource_1 = parsed.eResource();
      List<TextReplacement> _format = this.formatter.format(((XtextResource) _eResource_1), start, length, it.getCfg());
      Iterables.<TextReplacement>addAll(edits, _format);
      final IBasicFormatter formatter_1 = this.formatter;
      boolean _matched_1 = false;
      if (formatter_1 instanceof AbstractFormatter) {
        _matched_1=true;
        boolean _isConflictOccurred = ((AbstractFormatter)this.formatter).isConflictOccurred();
        if (_isConflictOccurred) {
          throw new RuntimeException("There are conflicting text edits, see console for details.");
        }
      }
      boolean _isAllowErrors_1 = it.isAllowErrors();
      boolean _not_1 = (!_isAllowErrors_1);
      if (_not_1) {
        Resource _eResource_2 = parsed.eResource();
        ArrayList<TextReplacement> _createMissingEditReplacements = this.createMissingEditReplacements(((XtextResource) _eResource_2), edits, start, length);
        Iterables.<TextReplacement>addAll(edits, _createMissingEditReplacements);
      }
      final String newDocument = this.applyEdits(oldDocument, edits);
      try {
        String _prefix_1 = it.getPrefix();
        CharSequence _expectation = it.getExpectation();
        String _plus_1 = (_prefix_1 + _expectation);
        String _postfix_1 = it.getPostfix();
        Assert.assertEquals((_plus_1 + _postfix_1).toString(), newDocument.toString());
      } catch (final Throwable _t) {
        if (_t instanceof AssertionError) {
          final AssertionError e = (AssertionError)_t;
          InputOutput.<String>println(this.applyDebugEdits(oldDocument, edits));
          InputOutput.println();
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Resource _eResource_3 = parsed.eResource();
      final String parsed2Doc = this.applyEdits(fullToBeParsed, 
        this.formatter.format(((XtextResource) _eResource_3), 0, fullToBeParsed.length(), it.getCfg()));
      final EObject parsed2 = this._parseHelper.parse(parsed2Doc);
      boolean _isAllowErrors_2 = it.isAllowErrors();
      boolean _not_2 = (!_isAllowErrors_2);
      if (_not_2) {
        Assert.assertEquals(0, parsed2.eResource().getErrors().size());
      }
      Resource _eResource_4 = parsed2.eResource();
      final List<TextReplacement> edits2 = this.formatter.format(((XtextResource) _eResource_4), 0, parsed2Doc.length(), it.getCfg());
      final String newDocument2 = this.applyEdits(parsed2Doc, edits2);
      try {
        Assert.assertEquals(parsed2Doc, newDocument2.toString());
      } catch (final Throwable _t) {
        if (_t instanceof AssertionError) {
          final AssertionError e = (AssertionError)_t;
          InputOutput.<String>println(this.applyDebugEdits(newDocument, edits2));
          InputOutput.println();
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String applyEdits(final String oldDocument, final Collection<TextReplacement> edits) {
    String _xblockexpression = null;
    {
      int lastOffset = 0;
      final StringBuilder newDocument = new StringBuilder();
      final Function1<TextReplacement, Integer> _function = (TextReplacement it) -> {
        return Integer.valueOf(it.getOffset());
      };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          newDocument.append(oldDocument.substring(lastOffset, edit.getOffset()));
          newDocument.append(edit.getText());
          int _offset = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset + _length);
          lastOffset = _plus;
        }
      }
      newDocument.append(oldDocument.substring(lastOffset, oldDocument.length()));
      _xblockexpression = newDocument.toString();
    }
    return _xblockexpression;
  }
  
  protected String applyDebugEdits(final String oldDocument, final Collection<TextReplacement> edits) {
    String _xblockexpression = null;
    {
      int lastOffset = 0;
      final StringBuilder debugTrace = new StringBuilder();
      final Function1<TextReplacement, Integer> _function = (TextReplacement it) -> {
        return Integer.valueOf(it.getOffset());
      };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          debugTrace.append(oldDocument.substring(lastOffset, edit.getOffset()));
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          int _offset = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset + _length);
          String _substring = oldDocument.substring(edit.getOffset(), _plus);
          _builder.append(_substring);
          _builder.append("|");
          String _text = edit.getText();
          _builder.append(_text);
          _builder.append("]");
          debugTrace.append(_builder);
          int _offset_1 = edit.getOffset();
          int _length_1 = edit.getLength();
          int _plus_1 = (_offset_1 + _length_1);
          lastOffset = _plus_1;
        }
      }
      debugTrace.append(oldDocument.substring(lastOffset, oldDocument.length()));
      _xblockexpression = debugTrace.toString();
    }
    return _xblockexpression;
  }
  
  protected ArrayList<TextReplacement> createMissingEditReplacements(final XtextResource res, final Collection<TextReplacement> edits, final int offset, final int length) {
    ArrayList<TextReplacement> _xblockexpression = null;
    {
      final Function1<TextReplacement, Integer> _function = (TextReplacement it) -> {
        return Integer.valueOf(it.getOffset());
      };
      final Set<Integer> offsets = IterableExtensions.<Integer>toSet(IterableExtensions.<TextReplacement, Integer>map(edits, _function));
      final ArrayList<TextReplacement> result = CollectionLiterals.<TextReplacement>newArrayList();
      int lastOffset = 0;
      Iterable<ILeafNode> _elvis = null;
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = null;
      if (_parseResult!=null) {
        _rootNode=_parseResult.getRootNode();
      }
      Iterable<ILeafNode> _leafNodes = null;
      if (_rootNode!=null) {
        _leafNodes=_rootNode.getLeafNodes();
      }
      if (_leafNodes != null) {
        _elvis = _leafNodes;
      } else {
        List<ILeafNode> _emptyList = CollectionLiterals.<ILeafNode>emptyList();
        _elvis = _emptyList;
      }
      for (final ILeafNode leaf : _elvis) {
        if (((!leaf.isHidden()) || (!StringExtensions.isNullOrEmpty(leaf.getText().trim())))) {
          final ITextRegion leafRegion = leaf.getTextRegion();
          if ((((lastOffset >= offset) && (leafRegion.getOffset() <= (offset + length))) && (!offsets.contains(Integer.valueOf(lastOffset))))) {
            int _offset = leafRegion.getOffset();
            int _minus = (_offset - lastOffset);
            TextReplacement _textReplacement = new TextReplacement(lastOffset, _minus, "!!");
            result.add(_textReplacement);
          }
          int _offset_1 = leafRegion.getOffset();
          int _length = leafRegion.getLength();
          int _plus = (_offset_1 + _length);
          lastOffset = _plus;
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
