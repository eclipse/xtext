<?xml version='1.0'?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:l="http://docbook.sourceforge.net/xmlns/l10n/1.0"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    version="1.0">

  <!-- Include other stylesheets -->
  <xsl:import href="docbook.xsl"/>
  <xsl:include href="inline.xsl" />
  <xsl:include href="component.xsl" />
  <xsl:include href="titlepage.xsl"/>

  <!-- Images -->
  <xsl:param name="draft.watermark.image" select="''"/>

  <!-- Enable bookmarks -->
  <xsl:param name="fop1.extensions" select="1"/>

  <!-- Do not print out URLs -->
  <xsl:param name="ulink.show" select="0"/>
  <!--<xsl:param name="show.comments" select="0"/>-->

  <!-- Page setup -->
  <xsl:param name="paper.type" select="'A4'"/>

  <!-- Paper type, no headers on blank pages, no double sided printing -->
  <xsl:param name="paper.type" select="'A4'"/>
  <xsl:param name="double.sided">0</xsl:param>
  <xsl:param name="headers.on.blank.pages">0</xsl:param>
  <xsl:param name="footers.on.blank.pages">0</xsl:param>
  
  <!--  Custom page footers -->
  <xsl:template name="footer.content">
      <xsl:param name="pageclass" select="''"/>
      <xsl:param name="sequence" select="''"/>
      <xsl:param name="position" select="''"/>
      <xsl:param name="gentext-key" select="''"/>

      <xsl:variable name="Version">
          <xsl:choose>
              <xsl:when test="//releaseinfo">
                      <xsl:text>Xtext </xsl:text><xsl:value-of select="//releaseinfo"/>
              </xsl:when>
              <xsl:otherwise>
                  Xtext 0.7
              </xsl:otherwise>
          </xsl:choose>
      </xsl:variable>

      <xsl:choose>
          <xsl:when test="$sequence='blank'">
          <xsl:choose>
            <xsl:when test="$double.sided != 0 and $position = 'left'">
              <xsl:value-of select="$Version"/>
            </xsl:when>

            <xsl:when test="$double.sided = 0 and $position = 'center'">
              <!-- nop -->
            </xsl:when>

            <xsl:otherwise>
              <fo:page-number/>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:when>

        <xsl:when test="$pageclass='titlepage'">
          <!-- nop: other titlepage sequences have no footer -->
        </xsl:when>

        <xsl:when test="$double.sided != 0 and $sequence = 'even' and $position='left'">
          <fo:page-number/>
        </xsl:when>

        <xsl:when test="$double.sided != 0 and $sequence = 'odd' and $position='right'">
          <fo:page-number/>
        </xsl:when>

        <xsl:when test="$double.sided = 0 and $position='right'">
          <fo:page-number/>
        </xsl:when>

        <xsl:when test="$double.sided != 0 and $sequence = 'odd' and $position='left'">
          <xsl:value-of select="$Version"/>
        </xsl:when>

        <xsl:when test="$double.sided != 0 and $sequence = 'even' and $position='right'">
          <xsl:value-of select="$Version"/>
        </xsl:when>

        <xsl:when test="$double.sided = 0 and $position='left'">
          <xsl:value-of select="$Version"/>
        </xsl:when>

        <xsl:otherwise>
          <!-- nop -->
        </xsl:otherwise>
      </xsl:choose>
  </xsl:template>    
  

  <!--<xsl:param name="header.column.widths">0 1 0</xsl:param>-->
  <!--<xsl:attribute-set name="header.content.properties">
    <xsl:attribute name="font-family">Helvetica</xsl:attribute>
    <xsl:attribute name="font-size">12pt</xsl:attribute>
    <xsl:attribute name="font-weight">bold</xsl:attribute>
  </xsl:attribute-set>-->

  <!--<xsl:attribute-set name="footer.content.properties">
    <xsl:attribute name="font-family">Helvetica</xsl:attribute>
    <xsl:attribute name="font-size">8pt</xsl:attribute>
  </xsl:attribute-set>
  <xsl:param name="footer.rule" select="0"/>-->

  <!--
  <xsl:param name="page.margin.top" select="'3.9cm'"/>
  <xsl:param name="page.margin.bottom" select="'3.9cm'"/>
  <xsl:param name="page.margin.inner" select="'4cm'"/>
  <xsl:param name="page.margin.outer" select="'4cm'"/>
  -->
  
  <xsl:param name="body.start.indent" select="'0'"/>
  <xsl:param name="body.margin.bottom" select="'1.2cm'"/>
  
  <xsl:attribute-set name="normal.para.spacing">
    <xsl:attribute name="space-before.optimum">0.4em</xsl:attribute>  
    <xsl:attribute name="space-before.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-before.maximum">0.5em</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="list.block.spacing">
    <xsl:attribute name="space-before.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-before.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-before.maximum">0.5em</xsl:attribute>
    <xsl:attribute name="space-after.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-after.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-after.maximum">0.5em</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="list.item.spacing">
    <xsl:attribute name="space-before.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-before.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-before.maximum">0.5em</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="verbatim.properties">
    <xsl:attribute name="space-before.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-before.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-before.maximum">0.5em</xsl:attribute>
    <xsl:attribute name="space-after.minimum">0.3em</xsl:attribute>
    <xsl:attribute name="space-after.optimum">0.4em</xsl:attribute>
    <xsl:attribute name="space-after.maximum">0.5em</xsl:attribute>
    <xsl:attribute name="hyphenate">false</xsl:attribute>
    <xsl:attribute name="wrap-option">no-wrap</xsl:attribute>
    <xsl:attribute name="white-space-collapse">false</xsl:attribute>
    <xsl:attribute name="white-space-treatment">preserve</xsl:attribute>
    <xsl:attribute name="linefeed-treatment">preserve</xsl:attribute>
    <xsl:attribute name="text-align">start</xsl:attribute>
    <xsl:attribute name="start-indent">3pc</xsl:attribute>
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="keep-together.within-column">always</xsl:attribute>
  </xsl:attribute-set>
  
  <!-- PETER -->
  <!-- <xsl:param name="title.margin.left">-3pc</xsl:param> -->
  <xsl:param name="body.start.indent">3pc</xsl:param>
  <xsl:param name="part.autolabel" select="1"/>
  <xsl:param name="chapter.autolabel" select="1"/>
  <xsl:param name="section.autolabel" select="1"/>
  <xsl:param name="section.autolabel.max.depth" select="3"/>
  <xsl:param name="section.label.includes.component.label" select="1"/>
  
  <xsl:attribute-set name="section.title.level1.properties" use-attribute-sets="section.properties">
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
  
  <xsl:attribute-set name="xref.properties">
    <xsl:attribute name="color">
    <xsl:choose>
      <xsl:when test="self::link">blue</xsl:when>
      <xsl:when test="self::ulink">blue</xsl:when>
      <xsl:otherwise>inherit</xsl:otherwise>
    </xsl:choose>
  </xsl:attribute>
  
  <xsl:attribute name="text-decoration">
    <xsl:choose>
      <xsl:when test="self::link">underline</xsl:when>
      <xsl:when test="self::ulink">underline</xsl:when>
      <xsl:otherwise>inherit</xsl:otherwise>
    </xsl:choose>
  </xsl:attribute>
</xsl:attribute-set>

  <xsl:param name="variablelist.as.blocks" select="0"/>

  <!-- Fonts & colors -->
  <xsl:param name="body.font.master" select="10"/>
  <xsl:param name="body.font.family" select="'Birka,Gentium Basic,Times'"/>
  <xsl:param name="title.font.family" select="'Myriad Pro,Delicious,Helvetica'"/>
  <xsl:param name="monospace.font.family" select="'Inconsolata,Courier'"/>

  <xsl:attribute-set name="monospace.verbatim.properties">
    <xsl:attribute name="font-size">.8em</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="nongraphical.admonition.properties">
    <xsl:attribute name="background-color">#F0F0F0</xsl:attribute>
    <xsl:attribute name="padding">5pt</xsl:attribute>
  </xsl:attribute-set>

  <xsl:param name="shade.verbatim" select="1"/>
  <xsl:attribute-set name="shade.verbatim.style">
    <xsl:attribute name="border">0</xsl:attribute>
    <xsl:attribute name="background-color">#F0F0F0</xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="section.title.chapter.properties">
    <xsl:attribute name="font-size">
      <xsl:value-of select="$body.font.master * 1.8"/>
      <xsl:text>pt</xsl:text>
    </xsl:attribute>
  </xsl:attribute-set>

  <xsl:attribute-set name="section.title.level1.properties">
    <xsl:attribute name="font-size">
      <xsl:value-of select="$body.font.master * 1.7"/>
      <xsl:text>pt</xsl:text>
    </xsl:attribute>
    <!--<xsl:attribute name="border-bottom">1pt solid #505050</xsl:attribute>-->
  </xsl:attribute-set>

  <xsl:attribute-set name="section.title.level2.properties">
    <xsl:attribute name="font-size">
      <xsl:value-of select="$body.font.master * 1.4"/>
      <xsl:text>pt</xsl:text>
    </xsl:attribute>
  </xsl:attribute-set>

  <!-- FIXME: Doesn't work 
  <xsl:attribute-set name="bibliography.title.properties">
    <xsl:attribute name="break-before">page</xsl:attribute>
  </xsl:attribute-set>
  -->

  <xsl:attribute-set name="toc.line.properties">
    <xsl:attribute name="font-size">10pt</xsl:attribute>
    <xsl:attribute name="font-weight">
      <xsl:choose>
        <xsl:when test="self::chapter | self::preface | self::appendix">bold</xsl:when>
        <xsl:otherwise>normal</xsl:otherwise>
      </xsl:choose>
    </xsl:attribute>
  </xsl:attribute-set>

  <xsl:param name="generate.toc">
    book      toc,title
  </xsl:param>

</xsl:stylesheet> 