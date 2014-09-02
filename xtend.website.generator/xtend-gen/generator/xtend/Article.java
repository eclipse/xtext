package generator.xtend;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Article {
  public enum Kind {
    Video,
    
    Blog,
    
    Article;
  }
  
  @Accessors
  private String title;
  
  @Accessors
  private Article.Kind kind;
  
  @Accessors
  private String href;
  
  @Accessors
  private String img;
  
  public void setArticle(final String aTitle) {
    this.kind = Article.Kind.Article;
    this.title = aTitle;
  }
  
  public void setBlog(final String aTitle) {
    this.kind = Article.Kind.Blog;
    this.title = aTitle;
  }
  
  public void setVideo(final String aTitle) {
    this.kind = Article.Kind.Video;
    this.title = aTitle;
  }
  
  @Pure
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
  }
  
  @Pure
  public Article.Kind getKind() {
    return this.kind;
  }
  
  public void setKind(final Article.Kind kind) {
    this.kind = kind;
  }
  
  @Pure
  public String getHref() {
    return this.href;
  }
  
  public void setHref(final String href) {
    this.href = href;
  }
  
  @Pure
  public String getImg() {
    return this.img;
  }
  
  public void setImg(final String img) {
    this.img = img;
  }
}
