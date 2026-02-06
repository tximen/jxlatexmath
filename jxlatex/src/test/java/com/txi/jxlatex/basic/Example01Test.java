package com.txi.jxlatex.basic;

import com.txi.jxlatex.TeXConstants;
import com.txi.jxlatex.TeXFormula;
import com.txi.jxlatex.TeXIcon;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;



public class Example01Test {

    private static final String LATEX = 
	      "\\begin{array}{lr}\\mbox{\\textcolor{Blue}{Russian}}&\\mbox{\\textcolor{Melon}{Greek}}\\\\"
       + "\\mbox{" + "привет мир".toUpperCase() + "}&\\mbox{" + "γειά κόσμο".toUpperCase()
                 + "}\\\\"
       + "\\mbox{привет мир}&\\mbox{γειά κόσμο}\\\\"
       + "\\mathbf{\\mbox{привет мир}}&\\mathbf{\\mbox{γειά κόσμο}}\\\\"
       + "\\mathit{\\mbox{привет мир}}&\\mathit{\\mbox{γειά κόσμο}}\\\\"
       + "\\mathsf{\\mbox{привет мир}}&\\mathsf{\\mbox{γειά κόσμο}}\\\\"
       + "\\mathtt{\\mbox{привет мир}}&\\mathtt{\\mbox{γειά κόσμο}}\\\\"
       + "\\mathbf{\\mathit{\\mbox{привет мир}}}&\\mathbf{\\mathit{\\mbox{γειά κόσμο}}}\\\\"
       + "\\mathbf{\\mathsf{\\mbox{привет мир}}}&\\mathbf{\\mathsf{\\mbox{γειά κόσμο}}}\\\\"
       + "\\mathsf{\\mathit{\\mbox{привет мир}}}&\\mathsf{\\mathit{\\mbox{γειά κόσμο}}}\\\\"
       + "&\\\\"
       + "\\mbox{\\textcolor{Salmon}{Bulgarian}}&\\mbox{\\textcolor{Tan}{Serbian}}\\\\"
       + "\\mbox{здравей свят}&\\mbox{Хелло уорлд}\\\\"
       + "&\\\\"
       + "\\mbox{\\textcolor{Turquoise}{Bielorussian}}&\\mbox{\\textcolor{LimeGreen}{Ukrainian}}\\\\"
       + "\\mbox{прывітаньне Свет}&\\mbox{привіт світ}\\\\"
       + "\\end{array}";


    @Test
    public void createImageTest() {
System.out.println(LATEX);
        TeXFormula formula = new TeXFormula(LATEX);
        TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(20)
                .build();


    }

}
