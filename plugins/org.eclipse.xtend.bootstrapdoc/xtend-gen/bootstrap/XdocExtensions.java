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
    final Function1<Part, EList<Chapter>> _function = new Function1<Part, EList<Chapter>>() {
      public EList<Chapter> apply(final Part it) {
        return it.getChapters();
      }
    };
    List<EList<Chapter>> _map = ListExtensions.<Part, EList<Chapter>>map(_parts, _function);
    Iterable<Chapter> _flatten = Iterables.<Chapter>concat(_map);
    Iterable<Chapter> _plus = Iterables.<Chapter>concat(_chapters, _flatten);
    final Function1<Chapter, Chapter> _function_1 = new Function1<Chapter, Chapter>() {
      public Chapter apply(final Chapter it) {
        AbstractSection _resolve = XdocExtensions.this.resolve(it);
        return ((Chapter) _resolve);
      }
    };
    return IterableExtensions.<Chapter, Chapter>map(_plus, _function_1);
  }
  
  public Iterable<? extends AbstractSection> getSections(final AbstractSection section) {
    Iterable<? extends AbstractSection> _switchResult = null;
    AbstractSection _resolve = this.resolve(section);
    final AbstractSection it = _resolve;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof Document) {
        _matched=true;
        _switchResult = this.getAllChapters(((Document)it));
      }
    }
    if (!_matched) {
      if (it instanceof Part) {
        _matched=true;
        EList<Chapter> _chapters = ((Part)it).getChapters();
        final Function1<Chapter, AbstractSection> _function = new Function1<Chapter, AbstractSection>() {
          public AbstractSection apply(final Chapter it) {
            return XdocExtensions.this.resolve(it);
          }
        };
        _switchResult = ListExtensions.<Chapter, AbstractSection>map(_chapters, _function);
      }
    }
    if (!_matched) {
      if (it instanceof Chapter) {
        _matched=true;
        EList<Section> _subSections = ((Chapter)it).getSubSections();
        final Function1<Section, AbstractSection> _function = new Function1<Section, AbstractSection>() {
          public AbstractSection apply(final Section it) {
            return XdocExtensions.this.resolve(it);
          }
        };
        _switchResult = ListExtensions.<Section, AbstractSection>map(_subSections, _function);
      }
    }
    if (!_matched) {
      if (it instanceof Section) {
        _matched=true;
        EList<Section2> _subSections = ((Section)it).getSubSections();
        final Function1<Section2, AbstractSection> _function = new Function1<Section2, AbstractSection>() {
          public AbstractSection apply(final Section2 it) {
            return XdocExtensions.this.resolve(it);
          }
        };
        _switchResult = ListExtensions.<Section2, AbstractSection>map(_subSections, _function);
      }
    }
    if (!_matched) {
      if (it instanceof Section2) {
        _matched=true;
        EList<Section3> _subSections = ((Section2)it).getSubSections();
        final Function1<Section3, AbstractSection> _function = new Function1<Section3, AbstractSection>() {
          public AbstractSection apply(final Section3 it) {
            return XdocExtensions.this.resolve(it);
          }
        };
        _switchResult = ListExtensions.<Section3, AbstractSection>map(_subSections, _function);
      }
    }
    if (!_matched) {
      if (it instanceof Section3) {
        _matched=true;
        EList<Section4> _subSections = ((Section3)it).getSubSections();
        final Function1<Section4, AbstractSection> _function = new Function1<Section4, AbstractSection>() {
          public AbstractSection apply(final Section4 it) {
            return XdocExtensions.this.resolve(it);
          }
        };
        _switchResult = ListExtensions.<Section4, AbstractSection>map(_subSections, _function);
      }
    }
    if (!_matched) {
      if (it instanceof Section4) {
        _matched=true;
        _switchResult = CollectionLiterals.<AbstractSection>emptyList();
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
        _switchResult = ((ChapterRef)section).getChapter();
      }
    }
    if (!_matched) {
      if (section instanceof SectionRef) {
        _matched=true;
        _switchResult = ((SectionRef)section).getSection();
      }
    }
    if (!_matched) {
      if (section instanceof Section2Ref) {
        _matched=true;
        _switchResult = ((Section2Ref)section).getSection2();
      }
    }
    if (!_matched) {
      _switchResult = section;
    }
    return _switchResult;
  }
  
  public String id(final AbstractSection section) {
    return section.getName();
  }
}
