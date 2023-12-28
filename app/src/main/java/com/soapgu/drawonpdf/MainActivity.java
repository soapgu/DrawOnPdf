package com.soapgu.drawonpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;
    Button commentButton;

    InkCanvasView inkCanvas;

    private boolean isComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.pdfView = findViewById(R.id.pdfView);
        this.commentButton = findViewById(R.id.button_comment);
        this.inkCanvas = findViewById(R.id.inkCanvas);
        this.commentButton.setOnClickListener( v->{
            isComment = !isComment;
            if( isComment ){
                inkCanvas.clear();
            }
            inkCanvas.setVisibility( isComment ? View.VISIBLE :View.GONE );
            commentButton.setText( isComment ? "停止批注":"开始批注" );
        } );

        this.pdfView.fromAsset("eBook.pdf")
                .defaultPage(1)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .onDrawAll((canvas, pageWidth, pageHeight, displayedPage) -> {
                    //Logger.i("onDrawAll page:%d",displayedPage);
                })
                .onDraw((canvas, pageWidth, pageHeight, displayedPage) -> {
                    //Logger.i("onDraw page:%d",displayedPage);
                })
                //.onPageChange( onPageChangeListener )
                //.onTap( onTapListener )
                //.onPageScroll( onPageScrollListener )
                .spacing(10) // in dp
                .pageFitPolicy(FitPolicy.BOTH)
                .load();

    }
}