package org.eclipse.xtext.idea.sdomain.idea.tests.psi;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.psi.ResourceDescriptionEventSource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PsiTreeChangeToDeltaConverterTest extends LightCodeInsightFixtureTestCase implements IResourceDescription.Event.Listener {
  private List<IResourceDescription.Event> events;
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    ArrayList<IResourceDescription.Event> _newArrayList = CollectionLiterals.<IResourceDescription.Event>newArrayList();
    this.events = _newArrayList;
    Project _project = this.getProject();
    IResourceDescription.Event.Source _instance = ResourceDescriptionEventSource.getInstance(_project);
    _instance.addListener(this);
  }
  
  @Override
  protected void tearDown() throws Exception {
    Project _project = this.getProject();
    IResourceDescription.Event.Source _instance = ResourceDescriptionEventSource.getInstance(_project);
    _instance.removeListener(this);
    this.events = null;
    super.tearDown();
  }
  
  @Override
  public void descriptionsChanged(final IResourceDescription.Event event) {
    this.events.add(event);
  }
  
  public void testAddEntity() {
    final PsiFile file = this.myFixture.addFileToProject("Foo.sdomain", "");
    VirtualFile _virtualFile = file.getVirtualFile();
    this.myFixture.openFileInEditor(_virtualFile);
    this.events.clear();
    final Procedure0 _function = new Procedure0() {
      @Override
      public void apply() {
        PsiTreeChangeToDeltaConverterTest.this.myFixture.type("entity Foo {}");
      }
    };
    this.writeAndCommit(_function);
    this.assertEvents(this.events, "Foo");
  }
  
  public void testRenameEntity() {
    final PsiFile file = this.myFixture.addFileToProject("Foo.sdomain", "entity Foo {}");
    VirtualFile _virtualFile = file.getVirtualFile();
    this.myFixture.openFileInEditor(_virtualFile);
    this.events.clear();
    final Procedure0 _function = new Procedure0() {
      @Override
      public void apply() {
        Editor _editor = PsiTreeChangeToDeltaConverterTest.this.myFixture.getEditor();
        CaretModel _caretModel = _editor.getCaretModel();
        int _length = "entity Foo".length();
        _caretModel.moveToOffset(_length);
        PsiTreeChangeToDeltaConverterTest.this.myFixture.type("\b\b\bBar");
      }
    };
    this.writeAndCommit(_function);
    this.assertEvents(this.events, "Foo", "Bar");
  }
  
  public void testRemoveEntity() {
    final PsiFile file = this.myFixture.addFileToProject("Foo.sdomain", "entity Foo {}");
    VirtualFile _virtualFile = file.getVirtualFile();
    this.myFixture.openFileInEditor(_virtualFile);
    this.events.clear();
    final Procedure0 _function = new Procedure0() {
      @Override
      public void apply() {
        Editor _editor = PsiTreeChangeToDeltaConverterTest.this.myFixture.getEditor();
        CaretModel _caretModel = _editor.getCaretModel();
        int _length = "entity Foo".length();
        _caretModel.moveToOffset(_length);
        PsiTreeChangeToDeltaConverterTest.this.myFixture.type("\b\b\b");
      }
    };
    this.writeAndCommit(_function);
    this.assertEvents(this.events, "Foo");
  }
  
  protected void assertEvents(final Iterable<IResourceDescription.Event> events, final String... expectedExportedNames) {
    final Function1<IResourceDescription.Event, ImmutableList<IResourceDescription.Delta>> _function = new Function1<IResourceDescription.Event, ImmutableList<IResourceDescription.Delta>>() {
      @Override
      public ImmutableList<IResourceDescription.Delta> apply(final IResourceDescription.Event it) {
        return it.getDeltas();
      }
    };
    Iterable<ImmutableList<IResourceDescription.Delta>> _map = IterableExtensions.<IResourceDescription.Event, ImmutableList<IResourceDescription.Delta>>map(events, _function);
    Iterable<IResourceDescription.Delta> _flatten = Iterables.<IResourceDescription.Delta>concat(_map);
    this.assertDeltas(_flatten, expectedExportedNames);
  }
  
  protected void assertDeltas(final Iterable<IResourceDescription.Delta> deltas, final String... expectedExportedNames) {
    boolean _isEmpty = IterableExtensions.isEmpty(deltas);
    TestCase.assertFalse("There are not deltas", _isEmpty);
    int _size = ((List<String>)Conversions.doWrapArray(expectedExportedNames)).size();
    boolean _notEquals = (_size != 0);
    if (_notEquals) {
      final Set<String> exportedNames = this.getExportedNames(deltas);
      this.<String>assertContainsElements(exportedNames, expectedExportedNames);
      CollectionExtensions.<String>removeAll(exportedNames, expectedExportedNames);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unexpected exported names: ");
      _builder.append(exportedNames, "");
      boolean _isEmpty_1 = exportedNames.isEmpty();
      TestCase.assertTrue(_builder.toString(), _isEmpty_1);
    }
  }
  
  protected Set<String> getExportedNames(final Iterable<IResourceDescription.Delta> deltas) {
    final Function1<IResourceDescription.Delta, HashSet<String>> _function = new Function1<IResourceDescription.Delta, HashSet<String>>() {
      @Override
      public HashSet<String> apply(final IResourceDescription.Delta it) {
        HashSet<String> _xblockexpression = null;
        {
          final HashSet<String> names = CollectionLiterals.<String>newHashSet();
          IResourceDescription _new = it.getNew();
          Iterable<IEObjectDescription> _exportedObjects = null;
          if (_new!=null) {
            _exportedObjects=_new.getExportedObjects();
          }
          if (_exportedObjects!=null) {
            final Procedure1<IEObjectDescription> _function = new Procedure1<IEObjectDescription>() {
              @Override
              public void apply(final IEObjectDescription it) {
                String _string = it.toString();
                names.add(_string);
              }
            };
            IterableExtensions.<IEObjectDescription>forEach(_exportedObjects, _function);
          }
          IResourceDescription _old = it.getOld();
          Iterable<IEObjectDescription> _exportedObjects_1 = null;
          if (_old!=null) {
            _exportedObjects_1=_old.getExportedObjects();
          }
          if (_exportedObjects_1!=null) {
            final Procedure1<IEObjectDescription> _function_1 = new Procedure1<IEObjectDescription>() {
              @Override
              public void apply(final IEObjectDescription it) {
                String _string = it.toString();
                names.add(_string);
              }
            };
            IterableExtensions.<IEObjectDescription>forEach(_exportedObjects_1, _function_1);
          }
          _xblockexpression = names;
        }
        return _xblockexpression;
      }
    };
    Iterable<HashSet<String>> _map = IterableExtensions.<IResourceDescription.Delta, HashSet<String>>map(deltas, _function);
    Iterable<String> _flatten = Iterables.<String>concat(_map);
    return IterableExtensions.<String>toSet(_flatten);
  }
  
  protected void writeAndCommit(final Procedure0 action) {
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        action.apply();
        Project _project = PsiTreeChangeToDeltaConverterTest.this.getProject();
        PsiDocumentManager _instance = PsiDocumentManager.getInstance(_project);
        _instance.commitAllDocuments();
      }
    };
    _application.runWriteAction(_function);
  }
}
