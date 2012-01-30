package bootstrap;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Chapter;
import org.eclipse.xtext.xdoc.xdoc.ChapterRef;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.Section;
import org.eclipse.xtext.xdoc.xdoc.Section2;
import org.eclipse.xtext.xdoc.xdoc.Section2Ref;
import org.eclipse.xtext.xdoc.xdoc.Section3;
import org.eclipse.xtext.xdoc.xdoc.Section4;
import org.eclipse.xtext.xdoc.xdoc.SectionRef;

@SuppressWarnings("all")
public class XdocExtensions {
  public Iterable<? extends AbstractSection> getSections(final AbstractSection section) {
    List<AbstractSection> _switchResult = null;
    AbstractSection _resolve = this.resolve(section);
    final AbstractSection it = _resolve;
    boolean matched = false;
    if (!matched) {
      if (it instanceof Document) {
        final Document _document = (Document)it;
        matched=true;
        EList<Chapter> _chapters = _document.getChapters();
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
    if (!matched) {
      if (it instanceof Chapter) {
        final Chapter _chapter = (Chapter)it;
        matched=true;
        EList<Section> _subSections = _chapter.getSubSections();
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
    if (!matched) {
      if (it instanceof Section) {
        final Section _section = (Section)it;
        matched=true;
        EList<Section2> _subSections = _section.getSubSections();
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
    if (!matched) {
      if (it instanceof Section2) {
        final Section2 _section2 = (Section2)it;
        matched=true;
        EList<Section3> _subSections = _section2.getSubSections();
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
    if (!matched) {
      if (it instanceof Section3) {
        final Section3 _section3 = (Section3)it;
        matched=true;
        EList<Section4> _subSections = _section3.getSubSections();
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
    if (!matched) {
      if (it instanceof Section4) {
        final Section4 _section4 = (Section4)it;
        matched=true;
        List<AbstractSection> _emptyList = CollectionLiterals.<AbstractSection>emptyList();
        _switchResult = _emptyList;
      }
    }
    return _switchResult;
  }
  
  public AbstractSection resolve(final AbstractSection section) {
    AbstractSection _switchResult = null;
    boolean matched = false;
    if (!matched) {
      if (section instanceof ChapterRef) {
        final ChapterRef _chapterRef = (ChapterRef)section;
        matched=true;
        Chapter _chapter = _chapterRef.getChapter();
        _switchResult = _chapter;
      }
    }
    if (!matched) {
      if (section instanceof SectionRef) {
        final SectionRef _sectionRef = (SectionRef)section;
        matched=true;
        Section _section = _sectionRef.getSection();
        _switchResult = _section;
      }
    }
    if (!matched) {
      if (section instanceof Section2Ref) {
        final Section2Ref _section2Ref = (Section2Ref)section;
        matched=true;
        Section2 _section2 = _section2Ref.getSection2();
        _switchResult = _section2;
      }
    }
    if (!matched) {
      _switchResult = section;
    }
    return _switchResult;
  }
  
  public String id(final AbstractSection section) {
    String _name = section.getName();
    return _name;
  }
}
