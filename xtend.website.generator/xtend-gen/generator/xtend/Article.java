package generator.xtend;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Article {
  @Accessors
  private String title;
  
  @Accessors
  private boolean article;
  
  @Accessors
  private String href;
  
  @Accessors
  private String img;
  
  public void setArticle(final String aTitle) {
    this.article = true;
    this.title = aTitle;
  }
  
  public void setBlog(final String aTitle) {
    this.article = false;
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
  public boolean isArticle() {
    return this.article;
  }
  
  public void setArticle(final boolean article) {
    this.article = article;
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
