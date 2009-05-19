<?xml version='1.0'?>
<xsl:stylesheet 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    version="1.0">

<xsl:template match="colophon">
  <fo:block xmlns:fo="http://www.w3.org/1999/XSL/Format" xsl:use-attribute-sets="colophon.titlepage.recto.style" margin-left="{$title.margin.left}" font-size="24.8832pt" font-family="{$title.fontset}" font-weight="bold">
    <xsl:call-template name="colophon.titlepage"/>
  </fo:block>
  <xsl:apply-templates/>
</xsl:template>

<xsl:template name="colophon.titlepage.recto">
  <fo:block xmlns:fo="http://www.w3.org/1999/XSL/Format" xsl:use-attribute-sets="colophon.titlepage.recto.style" margin-left="{$title.margin.left}" font-size="24.8832pt" font-family="{$title.fontset}" font-weight="bold">
<xsl:call-template name="component.colophon.title">
<xsl:with-param name="node" select="ancestor-or-self::colophon[1]"/>
</xsl:call-template></fo:block>
</xsl:template>

<xsl:template name="component.colophon.title">
  <fo:block xsl:use-attribute-sets="component.title.properties" text-align="left">
    <xsl:apply-templates select="." mode="object.title.markup">
      <xsl:with-param name="allow-anchors" select="1"/>
    </xsl:apply-templates>
  </fo:block>
</xsl:template>

</xsl:stylesheet> 