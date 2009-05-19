<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:date="http://exslt.org/dates-and-times"
    extension-element-prefixes="date"
    exclude-result-prefixes="date">
  <!-- XSL-FO stylesheet customization layer for the TCC
   !   For documentation, see:
   !       http://www.nmt.edu/tcc/doc/docbook42xep/ims/
   !-->
  <xsl:import
    href="docbook.xsl"/>
  <xsl:output method="xml"/>
<xsl:param name="double.sided">1</xsl:param>
<xsl:param name="page.margin.outer">0.75in</xsl:param>
<xsl:param name="page.margin.inner">1in</xsl:param>
<xsl:param name="insert.xref.page.number">1</xsl:param>
<xsl:param name="draft.mode">no</xsl:param>
<xsl:param name="region.before.extent">0.25in</xsl:param>
<xsl:attribute-set name="normal.para.spacing">
  <xsl:attribute name="space-before.minimum">0.50em</xsl:attribute>
  <xsl:attribute name="space-before.optimum">0.60em</xsl:attribute>
  <xsl:attribute name="space-before.maximum">0.70em</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="list.block.spacing">
  <xsl:attribute name="space-before.minimum">0.70em</xsl:attribute>
  <xsl:attribute name="space-before.optimum">0.75em</xsl:attribute>
  <xsl:attribute name="space-before.maximum">0.80em</xsl:attribute>
  <xsl:attribute name="space-after.minimum">0.70em</xsl:attribute>
  <xsl:attribute name="space-after.optimum">0.75em</xsl:attribute>
  <xsl:attribute name="space-after.maximum">0.80em</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="list.item.spacing">
  <xsl:attribute name="space-before.minimum">0.50em</xsl:attribute>
  <xsl:attribute name="space-before.optimum">0.60em</xsl:attribute>
  <xsl:attribute name="space-before.maximum">0.70em</xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="verbatim.properties">
  <xsl:attribute name="space-before.minimum">0.4em</xsl:attribute>
  <xsl:attribute name="space-before.optimum">0.5em</xsl:attribute>
  <xsl:attribute name="space-before.maximum">0.6em</xsl:attribute>
  <xsl:attribute name="space-after.minimum">0.4em</xsl:attribute>
  <xsl:attribute name="space-after.optimum">0.5em</xsl:attribute>
  <xsl:attribute name="space-after.maximum">0.6em</xsl:attribute>
  <xsl:attribute name="border-width">0.1mm</xsl:attribute>
  <xsl:attribute name="border-style">solid</xsl:attribute>

  <xsl:attribute name="padding">1mm</xsl:attribute>
</xsl:attribute-set>
<xsl:template
    match="filename|sgmltag|userinput|varname|application"
    mode="no.anchor.mode">
  <xsl:apply-templates select="." />
</xsl:template>
<xsl:template name="component.title">
  <xsl:param name="node" select="."/>
  <xsl:param name="pagewide" select="0"/>
  <xsl:variable name="id">
    <xsl:call-template name="object.id">
      <xsl:with-param name="object" select="$node"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="title">
    <xsl:apply-templates select="$node" mode="object.title.markup">
      <xsl:with-param name="allow-anchors" select="1"/>
    </xsl:apply-templates>
  </xsl:variable>

  <xsl:if test="$passivetex.extensions != 0">
    <fotex:bookmark xmlns:fotex="http://www.tug.org/fotex"
                    fotex-bookmark-level="2"
                    fotex-bookmark-label="{$id}">
      <xsl:value-of select="$title"/>
    </fotex:bookmark>
  </xsl:if>
  <fo:block keep-with-next.within-column="always"
            hyphenate="false">
    <fo:table table-layout="fixed" padding-bottom="0.2in">
      <fo:table-column column-number="1" column-width="4in"/>
      <fo:table-column column-number="2" column-width="2in"/>
      <fo:table-body>
        <fo:table-row>
          <fo:table-cell>
            <fo:block text-align="left">
              <xsl:copy-of select="$title"/>
            </fo:block>
          </fo:table-cell>
          <fo:table-cell>
            <fo:block>
              <fo:external-graphic src="url(logo.jpg)"
                content-width="2in"/>
            </fo:block>
          </fo:table-cell>
        </fo:table-row>
      </fo:table-body>
    </fo:table>
  </fo:block>
</xsl:template>
<xsl:template match="revhistory" mode="titlepage.mode">
  <fo:block text-align="center">
    <xsl:call-template name="datetime.format">
      <xsl:with-param name="date" select="date:date-time()"/>
      <xsl:with-param name="format" select="'Y-m-d H:M'"/>
    </xsl:call-template>
  </fo:block>
</xsl:template>
<xsl:param name="header.rule" select="0"/>
<xsl:template name="header.content">
  <xsl:param name="pageclass" select="''"/>
  <xsl:param name="sequence" select="''"/>
  <xsl:param name="position" select="''"/>
  <xsl:param name="gentext-key" select="''"/>
</xsl:template>
<xsl:attribute-set name="footer.content.properties">
  <xsl:attribute name="font-style">italic</xsl:attribute>
  <xsl:attribute name="font-size">9pt</xsl:attribute>
  <xsl:attribute name="font-family">
    <xsl:value-of select="$body.fontset"/>
  </xsl:attribute>
  <xsl:attribute name="margin-left">
    <xsl:value-of select="$title.margin.left"/>
  </xsl:attribute>
</xsl:attribute-set>
<xsl:template name="footer.content">
  <xsl:param name="pageclass" select="''"/>
  <xsl:param name="sequence" select="''"/>
  <xsl:param name="position" select="''"/>
  <xsl:param name="gentext-key" select="''"/>
  <fo:block>
    <xsl:choose>
      <xsl:when test="$pageclass = 'titlepage'">
        <!--no footer on title pages-->
      </xsl:when>
      <xsl:otherwise>       <!--Not a title page-->
        <xsl:choose>
          <xsl:when test="$double.sided = 0">   <!-- Single-sided -->
            <xsl:choose>
              <xsl:when test="$position = 'left'">
                <xsl:apply-templates select="." mode="titleabbrev.markup"/>
              </xsl:when>
              <xsl:when test="$position = 'center'">
                <fo:page-number/>
              </xsl:when>
              <xsl:when test="$position = 'right'">
                <xsl:text>New Mexico Tech Computer Center</xsl:text>
              </xsl:when>
            </xsl:choose>
          </xsl:when>       <!-- Single-sided -->
          <xsl:otherwise>   <!--Double-sided--> 
            <xsl:choose>
              <xsl:when test="$position = 'left'">
                <xsl:choose>
                  <xsl:when test="$sequence = 'even' or
                                  $sequence = 'blank'">
                    <fo:page-number/>
                  </xsl:when>
                  <xsl:otherwise> <!-- left/odd -->
                    <xsl:text>New Mexico Tech Computer Center</xsl:text>
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:when>
              <xsl:when test="$position = 'center'">
                <xsl:apply-templates select="." mode="titleabbrev.markup"/>
              </xsl:when>
              <xsl:when test="$position = 'right'">
                <xsl:choose>
                  <xsl:when test="$sequence = 'even' or
                                  $sequence = 'blank'">
                    <xsl:text>New Mexico Tech Computer Center</xsl:text>
                  </xsl:when>
                  <xsl:otherwise> <!-- left/odd -->
                    <fo:page-number/>
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:when>
            </xsl:choose>
          </xsl:otherwise>  <!-- Double-sided -->
        </xsl:choose>
      </xsl:otherwise>      <!--Not a title page-->
    </xsl:choose>
  </fo:block>
</xsl:template>
<xsl:param name="title.margin.left">-3pc</xsl:param>
<xsl:param name="section.autolabel" select="1"/>
<xsl:attribute-set name="section.title.level1.properties"
                   use-attribute-sets="section.properties">
  <xsl:attribute name="border-bottom-style">solid</xsl:attribute>
  <xsl:attribute name="border-bottom-width">1pt</xsl:attribute>
  <xsl:attribute name="font-size">
    <xsl:value-of select="$body.font.master * 1.728"/>
    <xsl:text>pt</xsl:text>
  </xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="section.title.level2.properties">
  <xsl:attribute name="font-size">
    <xsl:value-of select="$body.font.master * 1.44"/>
    <xsl:text>pt</xsl:text>
  </xsl:attribute>
</xsl:attribute-set>
<xsl:attribute-set name="section.title.level3.properties">
  <xsl:attribute name="font-size">
    <xsl:value-of select="$body.font.master * 1.2"/>
    <xsl:text>pt</xsl:text>
  </xsl:attribute>
</xsl:attribute-set>
<xsl:template name="inline.italicsansseq">
  <xsl:param name="content">
    <xsl:apply-templates/>
  </xsl:param>
  <fo:inline font-style="italic" font-family="sans-serif">
    <xsl:copy-of select="$content"/>
  </fo:inline>
</xsl:template>
<xsl:template name="inline.smallcaps">
  <xsl:param name="content">
    <xsl:apply-templates/>
  </xsl:param>
  <fo:inline font-variant="small-caps">
    <xsl:copy-of select="$content"/>
  </fo:inline>
</xsl:template>
<xsl:template match="application|guibutton|guiicon|guilabel|guimenu">
  <xsl:call-template name="inline.italicsansseq"/>
</xsl:template>
<xsl:template match="emphasis[@role='strong']">
  <xsl:call-template name="inline.boldseq"/>
</xsl:template>
<xsl:param name="callout.graphics.path">callouts/</xsl:param>
<xsl:param name="callout.graphics.extension">.pdf</xsl:param>
<xsl:param name="callout.graphics.number.limit">15</xsl:param>
<xsl:template match="firstterm">
  <xsl:call-template name="inline.italicseq"/>
</xsl:template>
<xsl:template match="keysym">
  <xsl:call-template name="inline.italicsansseq"/>
</xsl:template>
<xsl:param name="local.l10n.xml" select="document('')"/>
<l:i18n xmlns:l="http://docbook.sourceforge.net/xmlns/l10n/1.0">
  <l:l10n language="en">
    <l:context name="xref">
      <l:template name="page.citation" text=" (p. %p)"/>
    </l:context>
  </l:l10n>
</l:i18n>
<xsl:template name="nongraphical.admonition">
  <xsl:variable name="id">
    <xsl:call-template name="object.id"/>
  </xsl:variable>

  <fo:block space-before.minimum="0.8em"
            space-before.optimum="1em"
            space-before.maximum="1.2em"
            start-indent="0.25in"
            end-indent="0.25in"
            border="4pt solid #d0d0d0"
            padding="4pt"
            id="{$id}">
    <xsl:if test="$admon.textlabel != 0 or title">
      <fo:block keep-with-next='always'
                xsl:use-attribute-sets="admonition.title.properties">
         <xsl:apply-templates select="." mode="object.title.markup"/>
      </fo:block>
    </xsl:if>

    <fo:block xsl:use-attribute-sets="admonition.properties">
      <xsl:apply-templates/>
    </fo:block>
  </fo:block>
</xsl:template>
<xsl:param name="shade.verbatim" select="1"></xsl:param>
<xsl:param name="variablelist.as.blocks" select="1"></xsl:param>
<xsl:template match="varlistentry/term">
  <xsl:call-template name="inline.boldseq"/>
</xsl:template>
</xsl:stylesheet>
