package bootstrap;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Chapter;
import org.eclipse.xtext.xdoc.xdoc.ChapterRef;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.Part;
import org.eclipse.xtext.xdoc.xdoc.Section;
import org.eclipse.xtext.xdoc.xdoc.Section2;
import org.eclipse.xtext.xdoc.xdoc.Section2Ref;
import org.eclipse.xtext.xdoc.xdoc.Section3;
import org.eclipse.xtext.xdoc.xdoc.Section4;
import org.eclipse.xtext.xdoc.xdoc.SectionRef;

@SuppressWarnings("all")
public class XdocExtensions {
  public Iterable<Chapter> getAllChapters(final Document document) {
    EList<Chapter> _chapters = document.getChapters();
    EList<Part> _parts = document.getParts();
    final Function1<Part,EList<Chapter>> _function = new Function1<Part,EList<Chapter>>() {
      public EList<Chapter> apply(final Part it) {
        EList<Chapter> _chapters = it.getChapters();
        return _chapters;
      }
    };
    List<EList<Chapter>> _map = ListExtensions.<Part, EList<Chapter>>map(_parts, _function);
    Iterable<Chapter> _flatten = Iterables.<Chapter>concat(_map);
    Iterable<Chapter> _plus = Iterables.<Chapter>concat(_chapters, _flatten);
    final Function1<Chapter,Chapter> _function_1 = new Function1<Chapter,Chapter>() {
      public Chapter apply(final Chapter it) {
        AbstractSection _resolve = XdocExtensions.this.resolve(it);
        return ((Chapter) _resolve);
      }
    };
    Iterable<Chapter> _map_1 = IterableExtensions.<Chapter, Chapter>map(_plus, _function_1);
    return _map_1;
  }
  
  public Iterable<? extends AbstractSection> getSections(final AbstractSection section) {
    Iterable<? extends AbstractSection> _switchResult = null;
    AbstractSection _resolve = this.resolve(section);
    final AbstractSection it = _resolve;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof Document) {
        _matched=true;
        Iterable<Chapter> _allChapters = this.getAllChapters(((Document)it));
        _switchResult = _allChapters;
      }
    }
    if (!_matched) {
      if (it instanceof Part) {
        _matched=true;
        EList<Chapter> _chapters = ((Part)it).getChapters();
        final Function1<Chapter,AbstractSection> _function = new Function1<Chapter,AbstractSection>() {
          public AbstractSection apply(final Chapter it) {
            AbstractSection _resolve = XdocExtensions.this.resolve(it);
            return _resolve;
          }
        };
        List<AbstractSection> _map = ListExtensions.<Chapter, AbstractSection>map(_chapters, _function);
        _switchResult = _map;
      }
    }
    if (!_matched) {
      if (it instanceof Chapter) {
        _matched=true;
        EList<Section> _subSections = ((Chapter)it).getSubSections();
        final Function1<Section,AbstractSection> _function = new Function1<Section,AbstractSection>() {
          public AbstractSection apply(final Section it) {
            AbstractSection _resolve = XdocExtensions.this.resolve(it);
            return _resolve;
          }
        };
        List<AbstractSection> _map = ListExtensions.<Section, AbstractSection>map(_subSections, _function);
        _switchResult = _map;
      }
    }
    if (!_matched) {
      if (it instanceof Section) {
        _matched=true;
        EList<Section2> _subSections = ((Section)it).getSubSections();
        final Function1<Section2,AbstractSection> _function = new Function1<Section2,AbstractSection>() {
          public AbstractSection apply(final Section2 it) {
            AbstractSection _resolve = XdocExtensions.this.resolve(it);
            return _resolve;
          }
        };
        List<AbstractSection> _map = ListExtensions.<Section2, AbstractSection>map(_subSections, _function);
        _switchResult = _map;
      }
    }
    if (!_matched) {
      if (it instanceof Section2) {
        _matched=true;
        EList<Section3> _subSections = ((Section2)it).getSubSections();
        final Function1<Section3,AbstractSection> _function = new Function1<Section3,AbstractSection>() {
          public AbstractSection apply(final Section3 it) {
            AbstractSection _resolve = XdocExtensions.this.resolve(it);
            return _resolve;
          }
        };
        List<AbstractSection> _map = ListExtensions.<Section3, AbstractSection>map(_subSections, _function);
        _switchResult = _map;
      }
    }
    if (!_matched) {
      if (it instanceof Section3) {
        _matched=true;
        EList<Section4> _subSections = ((Section3)it).getSubSections();
        final Function1<Section4,AbstractSection> _function = new Function1<Section4,AbstractSection>() {
          public AbstractSection apply(final Section4 it) {
            AbstractSection _resolve = XdocExtensions.this.resolve(it);
            return _resolve;
          }
        };
        List<AbstractSection> _map = ListExtensions.<Section4, AbstractSection>map(_subSections, _function);
        _switchResult = _map;
      }
    }
    if (!_matched) {
      if (it instanceof Section4) {
        _matched=true;
        List<AbstractSection> _emptyList = CollectionLiterals.<AbstractSection>emptyList();
        _switchResult = _emptyList;
      }
    }
    return _switchResult;
  }
  
  public AbstractSection resolve(final AbstractSection section) {
    AbstractSection _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (section instanceof ChapterRef) {
        _matched=true;
        Chapter _chapter = ((ChapterRef)section).getChapter();
        _switchResult = _chapter;
      }
    }
    if (!_matched) {
      if (section instanceof SectionRef) {
        _matched=true;
        Section _section = ((SectionRef)section).getSection();
        _switchResult = _section;
      }
    }
    if (!_matched) {
      if (section instanceof Section2Ref) {
        _matched=true;
        Section2 _section2 = ((Section2Ref)section).getSection2();
        _switchResult = _section2;
      }
    }
    if (!_matched) {
      _switchResult = section;
    }
    return _switchResult;
  }
  
  public String id(final AbstractSection section) {
    String _name = section.getName();
    return _name;
  }
}
