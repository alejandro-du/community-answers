package com.example.vaadinupload;

import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.util.FastByteArrayOutputStream;

import java.io.OutputStream;

/**
 * @author Alejandro Duarte
 */
@SpringUI
@Push // enable UI modifications from background threads in the server
public class VaadinUI extends UI implements Upload.Receiver, Upload.SucceededListener {

    private Upload upload;
    private ProgressBar progressBar;

    private final ProcessingService processingService;
    private FastByteArrayOutputStream outputStream;

    public VaadinUI(ProcessingService processingService) { // processingService is injected by Spring
        this.processingService = processingService;
    }

    @Override
    protected void init(VaadinRequest request) {
        // create an Upload component and set a Receiver and a SucceededListener
        upload = new Upload("Upload a file", this);
        upload.addSucceededListener(this);

        // create an initially invisible and indeterminate ProgressBar component
        progressBar = new ProgressBar();
        progressBar.setVisible(false);
        progressBar.setIndeterminate(true);
        progressBar.setCaption("Uploading...");

        // configure the layout
        VerticalLayout mainLayout = new VerticalLayout(upload, progressBar);
        setContent(mainLayout);
    }

    @Override
    public OutputStream receiveUpload(String s, String s1) {
        progressBar.setVisible(true);
        return outputStream = new FastByteArrayOutputStream();
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
        upload.setVisible(false);

        progressBar.setCaption("Processing...");
        progressBar.setIndeterminate(false);

        // the actual job is started inside the service class in a new thread
        processingService.processData(outputStream.toString(),
                this::processingUpdated, this::processingSucceeded);
    }

    private void processingUpdated(Float percentage) {
        // use access when modifying the UI from a background thread
        access(() -> progressBar.setValue(percentage));
    }

    private void processingSucceeded() {
        access(() -> {
            progressBar.setVisible(false);
            Notification.show("Done!");
        });
    }
}
