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
@Push
public class VaadinUI extends UI implements Upload.Receiver, Upload.StartedListener, Upload.SucceededListener {

    private final ProcessingService processingService;

    private Upload upload;
    private ProgressBar progressBar;
    private OutputStream outputStream;

    public VaadinUI(ProcessingService processingService) {
        this.processingService = processingService;
    }

    @Override
    protected void init(VaadinRequest request) {
        // create an upload component and set a Receiver
        upload = new Upload("Upload a file:", this);
        upload.addStartedListener(this);
        upload.addSucceededListener(this);

        // create an initially invisible ProgressBar component
        progressBar = new ProgressBar();
        progressBar.setVisible(false);
        progressBar.setWidth("200px");

        // configure the layout
        VerticalLayout mainLayout = new VerticalLayout(upload, progressBar);
        setContent(mainLayout);
    }

    @Override
    public void uploadStarted(Upload.StartedEvent event) {
        progressBar.setVisible(true);
        progressBar.setCaption("Uploading...");
        progressBar.setIndeterminate(true); // will be changed to false during file processing time
    }

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        upload.setVisible(false);
        return outputStream = new FastByteArrayOutputStream();
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent event) {
        // update progress bar
        progressBar.setCaption("Processing...");
        progressBar.setIndeterminate(false); // file processing time

        // invoke file processing backend service passing listeners to update the UI
        processingService.processData(outputStream.toString(), this::updateProcessingProgress, this::processingSucceeded);
    }

    private void updateProcessingProgress(float percentage) {
        // this is called from a separate thread -> use UI.access() to update any UI components
        access(() -> progressBar.setValue(percentage));
    }

    private void processingSucceeded() {
        // this is called from a separate thread -> use UI.access() to update any UI components
        access(() -> {
            progressBar.setVisible(false);
            Notification.show("Done!");
        });
    }

}
