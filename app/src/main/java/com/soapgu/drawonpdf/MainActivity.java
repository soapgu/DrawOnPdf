package com.soapgu.drawonpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.pdfView = findViewById(R.id.pdfView);

        this.pdfView.fromAsset("eBook.pdf")
                .defaultPage(1)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                //.onPageChange( onPageChangeListener )
                //.onTap( onTapListener )
                //.onPageScroll( onPageScrollListener )
                .spacing(10) // in dp
                .pageFitPolicy(FitPolicy.BOTH)
                .load();

    }
}